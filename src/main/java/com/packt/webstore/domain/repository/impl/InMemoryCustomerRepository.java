package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Address;
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
        Address address = new Address();
        address.setAreaName("area1");
        address.setDoorNo("3");
        address.setStreetName("street1");
        address.setZipCode("zip1");
        c1.setAddress(address);
        mCustomers.add(c1);
        c1 = new Customer();
        c1.setCustomerId("111");
        c1.setName("c2");
        c1.setNoOfOrdersMade(1);
        address = new Address();
        address.setAreaName("area2");
        address.setDoorNo("2");
        address.setStreetName("street2");
        address.setZipCode("zip2");
        c1.setAddress(address);
        mCustomers.add(c1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return mCustomers;
    }
}
