/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import edu.byui.cit360.model.Client;
import edu.byui.cit360.model.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.ParseException;

/**
 *
 * @author Jesus Arredondo
 */
@WebServlet(name = "sendClientInfo", urlPatterns = {"/sendClientInfo"})
public class sendClientInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        /* TODO output your page here. You may use following sample code. */
        String query = "SELECT * FROM client";
        ArrayList<Client> clients = new ArrayList<>();

        DBConnection dbConnection = new DBConnection();
        Connection conn = dbConnection.getConnection();

        ProcessClient processClient = new ProcessClient();
        clients = processClient.getClientInfo(conn, query);
        request.setAttribute("clients", clients);

        //this are the methods used with qcJSON
        List<String> clientStrings = processClient.convertToJSONString(clients);
        ArrayList objs = new ArrayList();

        try {
            objs = processClient.convertToJSONObject(clientStrings);
        } catch (JSONException | ParseException ex) {
            Logger.getLogger(sendClientInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        //this is to work with json through qcjson library
        //List<Video> videoList = new ArrayList<>();
        //SearchYoutubeVideos search = new SearchYoutubeVideos();
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date dateobj = new Date();
        //DateTime date = new DateTime(df.format(dateobj) + "T00:00:00Z");
        //videoList = search.searchVideosInChannel("UCupvZG-5ko_eiXAupbDfxWw", 25, date);
        request.getRequestDispatcher("clientList.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
