/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.model;

/**
 *
 * @author Jesus Arredondo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection getConnection() {
        Connection con = null;
        String error = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            error = "Class not found driver missing";
        }

        String message = "Driver registered";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event_planner?user=root&serverTimezone=UTC");
        } catch (SQLException e) {
            error = "Check your connection, connection failed";
        }

        if (con != null) {
            message = "You are connected";
        } else {
            error = "Failed to connect";
        }

        return con;

    }

    /* public static void main(String[] argos) {
        DBConnection con = new DBConnection();
        Connection connection = con.getConnection();

    }*/
}
