package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by okeynan on 4/16/15.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository mProductRepository;

    @Override
    public void processOrder(String productId, int count) throws ProductNotFoundException {
        Product productById = mProductRepository.getProductById(productId);

        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Out of Stock. Available Units in stock" + productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
