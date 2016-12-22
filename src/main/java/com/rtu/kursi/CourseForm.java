/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rtu.kursi;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dnarushevich
 */
public class CourseForm extends Component {
    private String name = "";
    private String authorFName = "";
    private String authorLName = "";
    private String place = "";
    private String dateFrom = "";
    private String dateTo = "";
    private Integer maxSeats = 0;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        firePropertyChange("name", this.name, this.name = name);
    }
// <editor-fold desc="Parejie lauki">
    public String getAuthor() {
        return authorFName + " " + authorLName;
    }
    
    public void setAuthor(String author) {
        String[] splited = author.split("\\s+");
        String firstName = splited.length > 0 ? splited[0] : "";
        String lastName = splited.length > 1 ? splited[1] : "";
        setAuthorFName(firstName);
        setAuthorLName(lastName);
    }

    public void setAuthorFName(String fName) {
        firePropertyChange("authorFName", this.authorFName, this.authorFName = fName);
    }
    
    public String getAuthorFName() {
        return authorFName;
    }
    
    public void setAuthorLName(String lName) {
        firePropertyChange("authorLName", this.authorLName, this.authorLName = lName);
    }

    public String getAuthorLName(){
        return authorLName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        firePropertyChange("place", this.place, this.place = place);
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        firePropertyChange("dateFrom", this.dateFrom, this.dateFrom = dateFrom);
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        firePropertyChange("dateTo", this.dateTo, this.dateTo = dateTo);
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        Integer oldValue = this.maxSeats;
        this.maxSeats = maxSeats;
        firePropertyChange("maxSeats", oldValue, this.maxSeats);
    }
    // </editor-fold>
    public void reset(){
        setName("");
        setPlace("");
        setAuthor("");
        setDateFrom("");
        setDateTo("");
        setMaxSeats(10);
    }
}
