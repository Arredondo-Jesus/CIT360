/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.pattern;

import java.util.HashMap;

/**
 *
 * @author Jesus Arredondo
 */
public class Dispatcher {

    public void dispatch(String request) {
        addClientView clientView = new addClientView();
        HomeView homeView = new HomeView();

        HashMap views = new HashMap();
        views.put("Home", homeView);
        views.put("Client", clientView);

        if (request.equalsIgnoreCase("CLIENT")) {
            addClientView view1 = (addClientView) views.get("Client");
            view1.show();
        } else {
            HomeView view2 = (HomeView) views.get("Home");
            view2.show();

        }
    }
}
