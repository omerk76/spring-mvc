package com.packt.webstore.domain;

import java.math.BigDecimal;

/**
 * Created by okeynan on 4/28/15.
 */
public class CartItem {
    private Product    mProduct;
    private int        quantity;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    public CartItem(Product product) {
        this.mProduct = product;
        quantity = 1;
        totalPrice = product.getUnitPrice();
    }

    public void setProduct(Product product) {
        this.mProduct = product;
        updateTotalPrice();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotalPrice();
    }

    public void updateTotalPrice() {
        totalPrice = this.mProduct.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    public Product getProduct() {
        return mProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 311;
        int result = 1;
        result = prime * result + ((mProduct == null) ? 0 : mProduct.hashCode());
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
        CartItem other = (CartItem) obj;
        if (mProduct == null) {
            if (other.mProduct != null) {
                return false;
            }
        } else if (!mProduct.equals(other.mProduct)) {
            return false;
        }
        return true;
    }
}
