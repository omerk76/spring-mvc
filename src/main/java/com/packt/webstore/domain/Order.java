package com.packt.webstore.domain;

import java.io.Serializable;

/**
 * Created by okeynan on 4/28/15.
 */
public class Order implements Serializable {
    private Long           orderId;
    private Cart           cart;
    private Customer       customer;
    private ShippingDetail shippingDetail;

    public Order() {
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }
}
