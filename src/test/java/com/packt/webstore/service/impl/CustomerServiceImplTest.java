package com.packt.webstore.service.impl;

import com.packt.webstore.domain.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by okeynan on 4/19/15.
 */
public class CustomerServiceImplTest {
    
    @InjectMocks
    CustomerServiceImpl mCustomerService;
    
    @Mock
    CustomerRepository mCustomerRepository;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void that_customer_service_get_all_customers_invokes_customer_repository_get_all_customers(){
        mCustomerService.getAllCustomers();
        verify(mCustomerRepository).getAllCustomers();
    }

}