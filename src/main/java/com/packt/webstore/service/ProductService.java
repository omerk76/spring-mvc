package com.packt.webstore.service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Product getById(String productId) throws ProductNotFoundException;

    List<Product> getProductsByManufacturer(String manufacturer);

    void addProduct(Product product);
}
