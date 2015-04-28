package com.packt.webstore.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by okeynan on 4/28/15.
 */
public class ShippingDetail implements Serializable {
    private String  name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    shippingDate;
    private Address shippingAddress;


    public ShippingDetail() {
        this.shippingAddress = new Address();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
