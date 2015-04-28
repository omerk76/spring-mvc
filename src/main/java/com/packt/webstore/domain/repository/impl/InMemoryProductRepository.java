package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by okeynan on 4/16/15.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> mProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        Product iphone = new Product("p1234", "iphone 5s", new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display");
        iphone.setCategory("Smartphone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);
        Product laptop_dell = new Product("p1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus = new Product("p1236", "Nexus 7", new BigDecimal(300));
        tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);

        mProducts.add(laptop_dell);
        mProducts.add(tablet_Nexus);
        mProducts.add(iphone);
    }

    @Override
    public List<Product> getAllProducts() {
        return mProducts;
    }

    @Override
    public Product getProductById(String productId) throws ProductNotFoundException {
        Product productById = null;

        for (Product product : mProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }

        if (productById == null) {
            throw new ProductNotFoundException(productId);
        }

        return productById;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        String lowCase = category.toLowerCase();
        List<Product> result = new ArrayList<>();
        for (Product product : mProducts) {
            if (product.getCategory().toLowerCase().equals(lowCase)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> list = new ArrayList<>();
        for (Product product : mProducts) {
            if (product.getManufacturer().toLowerCase().equals(manufacturer.toLowerCase())) {
                list.add(product);
            }
        }
        return list;
    }

    @Override
    public void addProduct(Product product) {
        mProducts.add(product);
    }
}
