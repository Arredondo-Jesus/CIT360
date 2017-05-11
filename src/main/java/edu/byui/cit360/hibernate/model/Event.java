/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cit360.hibernate.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.*;

/**
 *
 * @author Jesus Arredondo
 */
@Entity
@Table
public class Event {

    @Id
    @GeneratedValue
    private int id;

    private String type;
    private String place;
    private int number_people;
    private Date date;
    private Time time;

    @ManyToOne
    private Client client;

    public Event() {
    }

    public Event(String type, String place, int number_people, Client client) {
        this.type = type;
        this.place = place;
        this.number_people = number_people;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumberPeople() {
        return number_people;
    }

    public void setNumberPeople(int numberPeople) {
        this.number_people = numberPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
