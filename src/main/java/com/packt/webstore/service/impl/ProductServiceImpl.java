package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by okeynan on 4/19/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository mProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return mProductRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return mProductRepository.getProductsByCategory(category);
    }

    @Override
    public Product getById(String productId) throws ProductNotFoundException {
        return mProductRepository.getProductById(productId);
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return mProductRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public void addProduct(Product product) {
        mProductRepository.addProduct(product);
    }
}
