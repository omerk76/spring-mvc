package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by okeynan on 4/28/15.
 */
@Repository
public class InMemoryCartRepository implements CartRepository {
    private Map<String, Cart> listOfCarts;


    public InMemoryCartRepository() {
        listOfCarts = new HashMap<>();

    }

    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Can not create a cart. A cart with the give id (%) aldrady exist", new Object[]{cart.getCartId()}));
        }

        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not update cart. The cart with the give id (%) does not does not exist", new Object[]{cartId}));
        }

        listOfCarts.put(cartId, cart);
    }

    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart. The cart with the give id (%) does not does not exist", new Object[]{cartId}));
        }

        listOfCarts.remove(cartId);
    }
}
