package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by okeynan on 4/28/15.
 */
@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private Map<Long, Order> listOfOrders;
    private long             nextOrderId;

    public InMemoryOrderRepository() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }

    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}
