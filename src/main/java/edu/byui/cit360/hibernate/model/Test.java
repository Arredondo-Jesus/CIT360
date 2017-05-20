/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.hibernate.model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jesus Arredondo
 */
public class Test {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Client client = new Client("Joe", "Smith", "1212 34353", "joe@joe.com");
        session.save(client);

        session.save(new Event("Jakab Gipsz", "US", 1, client));
        session.save(new Event("Captain Nemo", "Mexico", 1, client));

        session.getTransaction().commit();

        Query q = session.createQuery("From Client ");

        List<Client> resultList = q.list();
        System.out.println("num of Clients:" + resultList.size());
        for (Client next : resultList) {
            System.out.println("next client: " + next);
        }

    }
}
