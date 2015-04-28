package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;

import java.util.List;

/**
 * Created by okeynan on 4/16/15.
 */
public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productID) throws ProductNotFoundException;

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    void addProduct(Product product);
}
