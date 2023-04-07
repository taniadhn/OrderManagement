package com.dehghan.q4;

public class CartModel {

    private CartType type;

    public CartModel(CartType type) {
        this.type = type;
    }

    public CartType getType() {
        return type;
    }

    public void setType(CartType type) {
        this.type = type;
    }
}
