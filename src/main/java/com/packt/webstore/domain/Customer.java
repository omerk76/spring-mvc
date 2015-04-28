package com.packt.webstore.domain;

import java.io.Serializable;

/**
 * Created by okeynan on 4/19/15.
 */
public class Customer implements Serializable {
    String  customerId;
    String  name;
    Address address;
    int     noOfOrdersMade;

    public Customer() {
        address = new Address();
    }

    public Customer(String customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
}
