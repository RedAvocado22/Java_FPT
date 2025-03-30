/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int userid;
    private List<CartItem> cartItem;

    public Cart() {
        this.cartItem = new ArrayList<>(); 
    }

    public Cart(int userid, List<CartItem> cartItem) {
        this.userid = userid;
        this.cartItem = (cartItem != null) ? cartItem : new ArrayList<>(); 
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public List<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItem> cartItem) {
        this.cartItem = (cartItem != null) ? cartItem : new ArrayList<>(); 
    }

    public void addItem(CartItem item) {
        for (CartItem cartItem : this.cartItem) {
            if (cartItem.getProductID() == item.getProductID()) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        this.cartItem.add(item);
    }

    public void removeItem(int productID) {
        cartItem.removeIf(item -> item.getProductID() == productID);
    }

    public void updateItemQuantity(int productID, int quantity) {
        for (CartItem item : cartItem) {
            if (item.getProductID() == productID) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

     public int getTotalAmount() {
        int total = 0;
        for (CartItem item : cartItem) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void clearCart() {
        cartItem.clear();
    }
}
