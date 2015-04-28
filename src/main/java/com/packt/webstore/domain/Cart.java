package com.packt.webstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by okeynan on 4/28/15.
 */
public class Cart {

    private String                cartId;
    private Map<String, CartItem> mCartItems;
    private BigDecimal            grandTotal;

    public Cart() {
        mCartItems = new HashMap<>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return mCartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.mCartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void addCartItem(CartItem item) {
        String productId = item.getProduct().getProductId();

        if (mCartItems.containsKey(productId)) {
            CartItem existingCartItem = mCartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
            mCartItems.put(productId, existingCartItem);
        } else {
            mCartItems.put(productId, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem item) {
        String productId = item.getProduct().getProductId();
        mCartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal = new BigDecimal(0);
        for (CartItem item : mCartItems.values()) {
            grandTotal = grandTotal.add(item.getTotalPrice());
        }
    }

    @Override
    public int hashCode() {
        final int prime = 71;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cart other = (Cart) obj;
        if (cartId == null) {
            if (other.cartId != null) {
                return false;
            }
        } else if (!cartId.equals(other.cartId)) {
            return false;
        }
        return true;
    }
}
