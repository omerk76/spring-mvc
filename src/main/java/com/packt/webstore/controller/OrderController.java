package com.packt.webstore.controller;

import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by okeynan on 4/16/15.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService mOrderService;

    @RequestMapping("/order/{id}/{count}")
    public String process(@PathVariable String id, @PathVariable int count) throws ProductNotFoundException {
        mOrderService.processOrder(id, count);
        return "redirect:/products";
    }
}
