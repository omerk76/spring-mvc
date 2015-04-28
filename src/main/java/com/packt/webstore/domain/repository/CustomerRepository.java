package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Customer;

import java.util.List;

/**
 * Created by okeynan on 4/19/15.
 */
public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
