package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;

/**
 * Created by okeynan on 4/28/15.
 */
public interface OrderRepository {

    Long saveOrder(Order order);
}
