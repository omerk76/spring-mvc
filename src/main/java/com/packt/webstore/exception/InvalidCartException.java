package com.packt.webstore.exception;

/**
 * Created by okeynan on 4/28/15.
 */
public class InvalidCartException extends Exception {
    private String cartId;

    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }
}
