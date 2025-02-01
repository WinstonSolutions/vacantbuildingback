package com.rrc.vacantbuilding.entity;

import jakarta.persistence.Column;
// Import necessary packages
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

// Annotate the class as an entity and map it to the table name
@Entity
@Table(name = "vacantbuilding")
public class VacantBuilding {

    // Annotate the ID field as the primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String orderNumber;
    
    private String orderType;

    private Date orderIssuedDate;

    // Getter and Setter methods for the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }       

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }   

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }               

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getOrderIssuedDate() {
        return orderIssuedDate;
    }

    public void setOrderIssuedDate(Date orderIssuedDate) {
        this.orderIssuedDate = orderIssuedDate;
    }
}
