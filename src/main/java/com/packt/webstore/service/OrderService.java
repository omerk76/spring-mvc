package com.packt.webstore.service;

import com.packt.webstore.domain.Order;
import com.packt.webstore.exception.ProductNotFoundException;

/**
 * Created by okeynan on 4/16/15.
 */
public interface OrderService {

    void processOrder(String productId, int count) throws ProductNotFoundException;

    Long saveOrder(Order order);
}
