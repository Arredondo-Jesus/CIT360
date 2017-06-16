package android;

import edu.byui.cit360.controller.ProcessClient;
import edu.byui.cit360.model.Client;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HTTPURLConnectionExample extends ProcessClient {

    //private final String USER_AGENT = "Mozilla/5.0";
    public static void main(String[] args) throws Exception {

        HTTPURLConnectionExample http = new HTTPURLConnectionExample();
        ArrayList<Client> clients = new ArrayList<Client>();
        List<String> stringList = new ArrayList<>();

        System.out.println("Testing 1 - Send Http GET request");
        List JSONStringsGet = http.sendGet();
        List JSONObjGet = http.convertToJSONObject(JSONStringsGet);

        System.out.println("\nTesting 2 - Send Http POST request");
        //using post method
        List JSONStringsPost = http.sendPost();
        List JSONObjPost = http.convertToJSONObject(JSONStringsPost);

        //Print json result
        http.printJSON(JSONObjPost);
        http.printJSON(JSONStringsPost);
    }

    // HTTP GET request
    private List sendGet() throws Exception {

        String urlString = "http://creatingux.com/CIT360/clients.json";

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        List<String> JSONStrings = new ArrayList<>();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            if (!"".equals(inputLine)) {
                JSONStrings.add(inputLine);
            }
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return JSONStrings;

    }

    // HTTP POST request
    private List sendPost() throws Exception {

        String urlString = "http://creatingux.com/CIT360/clients.json";
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        List<String> JSONStrings = new ArrayList<>();
        //add reuqest header
        con.setRequestMethod("POST");
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        //wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            if (!"".equals(inputLine)) {
                JSONStrings.add(inputLine);
            }
        }
        in.close();

        //print result
        System.out.println(response.toString());
        return JSONStrings;

    }

    private void printJSON(List JSONList) {
        System.out.println("=============================================");
        for (int i = 0; i < JSONList.size(); i++) {
            System.out.println(JSONList.get(i));
        }
    }
}
