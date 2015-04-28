package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by okeynan on 4/16/15.
 */
public class ProductControllerTest {

    MockMvc           mMockMvc;
    ProductController mProductController;

    @Before
    public void setup() {
        mProductController = new ProductController();
        mMockMvc = standaloneSetup(mProductController).build();
    }
    
    @Test
    public void that_list_products_model_contains_product_property() throws Exception {
        mMockMvc.perform(get("/products"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("products"))
            .andExpect(model().attributeExists("product"));
    }

    @Test
    public void that_filter_products_works() throws Exception {
        mMockMvc.perform(get("/products/tablet/price;min=200;max=400?manufacturer=google"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("products"))
            .andExpect(model().attributeExists("product"));
    }
}