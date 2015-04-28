package com.packt.webstore.exception;

/**
 * Created by okeynan on 4/26/15.
 */
public class ProductNotFoundException extends Exception {

    private String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
