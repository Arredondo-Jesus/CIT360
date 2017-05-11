/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import edu.byui.cit360.model.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus Arredondo
 */
public class ProcessClient {

    public ArrayList getClientInfo(Connection conn, String query) {
        ArrayList<Client> clients = new ArrayList<Client>();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");

                Client client = new Client();

                client.setId(id);
                client.setName(name);
                client.setLastName(lastName);
                client.setPhoneNumber(phoneNumber);
                client.setEmail(email);

                clients.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }
}
