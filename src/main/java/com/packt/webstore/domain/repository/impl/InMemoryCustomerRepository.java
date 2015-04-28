package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by okeynan on 4/19/15.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    List<Customer> mCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer c1 = new Customer();
        c1.setCustomerId("123");
        c1.setName("c1");
        c1.setNoOfOrdersMade(3);
        c1.setAddress("c1 address");
        mCustomers.add(c1);
        c1 = new Customer();
        c1.setCustomerId("111");
        c1.setName("c2");
        c1.setNoOfOrdersMade(1);
        c1.setAddress("c2 address");
        mCustomers.add(c1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return mCustomers;
    }
}
