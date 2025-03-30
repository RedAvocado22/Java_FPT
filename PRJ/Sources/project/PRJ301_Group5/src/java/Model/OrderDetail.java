
package Model;

/**
 *
 * @author ICBAdmin
 */
public class OrderDetail {
    private int orderDetailID;
    private Order orderID;
    private int productID;
    private String title;
    private int quantity;
    private String thumbnail;
    private int price;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailID, Order orderID, int productID, String title, int quantity, String thumbnail, int price) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
        this.title = title;
        this.quantity = quantity;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    
}
