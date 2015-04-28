package com.packt.webstore.domain.repository.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by okeynan on 4/16/15.
 */
public class InMemoryProductRepositoryTest {

    InMemoryProductRepository mInMemoryProductRepository = new InMemoryProductRepository();

    @Test
    public void that_constructor_creates_and_stores_3_products(){
        assertThat(mInMemoryProductRepository.getAllProducts().size(), is(3));
    }

}