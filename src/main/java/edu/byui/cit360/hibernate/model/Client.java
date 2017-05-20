/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.hibernate.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jesus Arredondo
 */
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String last_name;
    private String phone_number;
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST)
    private List<Event> event = new ArrayList<Event>();

    public Client() {
    }

    public Client(String name, String last_name, String phone_number, String email) {
        this.name = name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
