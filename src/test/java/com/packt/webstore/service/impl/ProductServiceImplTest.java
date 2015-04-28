package com.packt.webstore.service.impl;

import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

/**
 * Created by okeynan on 4/19/15.
 */
public class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl mProductService;

    @Mock
    ProductRepository mProductRepository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void that_product_service_calls_repository_get_all_items(){
        mProductService.getAllProducts();
        verify(mProductRepository).getAllProducts();
    }

    @Test
    public void that_product_service_calls_repository_get_item_by_id() throws ProductNotFoundException {
        mProductService.getById("id");
        verify(mProductRepository).getProductById(any(String.class));
    }

}