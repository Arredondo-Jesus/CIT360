/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.pattern;

/**
 *
 * @author Jesus Arredondo
 */
public class Dispatcher {

    private addClientView clientView;
    private HomeView homeView;

    public Dispatcher() {
        clientView = new addClientView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if (request.equalsIgnoreCase("CLIENT")) {
            clientView.show();
        } else {
            homeView.show();
        }
    }
}
