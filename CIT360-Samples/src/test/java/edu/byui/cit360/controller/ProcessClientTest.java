/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.controller;

import edu.byui.cit360.model.Client;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.ParseException;

/**
 *
 * @author jesus
 */
public class ProcessClientTest {

    public ProcessClientTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getClientInfo method, of class ProcessClient.
     */
    @Test(expected = java.lang.NullPointerException.class)
    public void testGetClientInfo() {
        System.out.println("getClientInfo");
        Connection conn = null;
        String query = "";
        ProcessClient instance = new ProcessClient();
        ArrayList expResult = null;
        ArrayList result = instance.getClientInfo(conn, query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertToJSONString method, of class ProcessClient.
     */
    @Test
    public void testConvertToJSONString() {
        System.out.println("convertToJSONString");
        Client client1 = new Client();

        client1.setId(1);
        client1.setName("Joe");
        client1.setLastName("Smith");
        client1.setEmail("test@test.com");
        client1.setPhoneNumber("123");

        List clients = new ArrayList();
        clients.add(client1);

        List strings = new ArrayList();
        String string = "{\"id\":1,\"name\":\"Joe\",\"lastName\":\"Smith\",\"phoneNumber\":\"123\",\"email\":\"test@test.com\"}";
        strings.add(string);

        ProcessClient instance = new ProcessClient();
        List expResult = strings;
        List result = instance.convertToJSONString(clients);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    // Using assertNotNull
    @Test
    public void testConvertToJSONStringClient() {
        System.out.println("convertToJSONString");
        Client client1 = new Client();

        client1.setId(1);
        client1.setName("Joe");
        client1.setLastName("Smith");
        client1.setEmail("test@test.com");
        client1.setPhoneNumber("123");

        List<Client> clients = new ArrayList();
        clients.add(client1);

        ProcessClient instance = new ProcessClient();
        Client result = client1;
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of convertToJSONObject method, of class ProcessClient.
     */
    @Ignore
    @Test
    public void testConvertToJSONObject() throws Exception {
        System.out.println("convertToJSONObject");
        List JSONStrings = null;
        ProcessClient instance = new ProcessClient();
        ArrayList result = instance.convertToJSONObject(JSONStrings);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    // Using assertNull
    @Test
    public void testConvertToJSONObjectNull() throws Exception {
        System.out.println("convertToJSONObject");
        List JSONStrings = null;
        ProcessClient instance = new ProcessClient();
        Client result = null;
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    //use asertSame
    @Test
    public void testConvertToJSONStringClientSame() throws JSONException, ParseException {
        System.out.println("convertToJSONString");
        Client client1 = new Client();

        client1.setId(1);
        client1.setName("Joe");
        client1.setLastName("Smith");
        client1.setEmail("test@test.com");
        client1.setPhoneNumber("123");

        List clients = new ArrayList();
        clients.add(client1);

        List strings = new ArrayList();
        String string = "{\"id\":1,\"name\":\"Joe\",\"lastName\":\"Smith\",\"phoneNumber\":\"123\",\"email\":\"test@test.com\"}";
        strings.add(string);

        ProcessClient instance = new ProcessClient();
        Client expResult = client1;
        Client result = client1;
        assertSame(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of testInfinteloop method, of class ProcessClient.
     */
    @Test(timeout = 1000)
    public void testTestInfinteloop() {
        System.out.println("testInfinteloop");
        ProcessClient instance = new ProcessClient();
        instance.testInfinteloop();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
