package com.dehghan.q4;

public class Exception {

    public boolean isGiftCart(CartModel cart) {
        if (cart == null) {
            return false;
        }
        try {
            return cart.getType().equals(CartType.GIFT);
        } catch (NullPointerException ex) {
            return false;
        }
    }

}
