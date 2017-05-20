/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.samples;

/**
 *
 * @author Jesus Arredondo
 */
public class RunnableExample implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Hello from a thread! " + threadName);
    }

    public static void main(String args[]) {
        Thread running1 = new Thread(new RunnableExample());
        Thread running2 = new Thread(new RunnableExample());
        running1.start();
        running2.start();
    }

}
