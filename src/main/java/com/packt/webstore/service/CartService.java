package com.packt.webstore.service;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.exception.InvalidCartException;

/**
 * Created by okeynan on 4/28/15.
 */
public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

    Cart validate(String cartId) throws InvalidCartException;
}
