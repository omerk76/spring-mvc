package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;

import java.util.List;

/**
 * Created by okeynan on 4/19/15.
 */
public interface CustomerService {

    List<Customer> getAllCustomers();
}
