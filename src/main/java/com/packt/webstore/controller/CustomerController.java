package com.packt.webstore.controller;

import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by okeynan on 4/19/15.
 */

@Controller
public class CustomerController {

    @Autowired
    CustomerService mCustomerService;

    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", mCustomerService.getAllCustomers());
        return "customers";
    }
}
