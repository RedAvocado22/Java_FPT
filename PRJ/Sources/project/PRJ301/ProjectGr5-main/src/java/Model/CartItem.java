/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Anh Tuan
 */
public class CartItem {
    private int productID;
    private String title,thumbnail;
    private int price,quantity;

    public CartItem() {
    }

    public CartItem(int productID, String title, String thumbnail, int price, int quantity) {
        this.productID = productID;
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     public int getTotalPrice() {
        return this.price * this.quantity;
    }
    
}
