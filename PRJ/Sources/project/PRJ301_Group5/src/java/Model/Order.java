
package Model;

/**
 *
 * @author ICBAdmin
 */
public class Order {
    private int orderID;
    private User userID;
    private int totalCost;
    private String orderStatus;
    private String saleNotes;

    public Order() {
    }

    public Order(int orderID, User userID, int totalCost, String orderStatus, String saleNotes) {
        this.orderID = orderID;
        this.userID = userID;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
        this.saleNotes = saleNotes;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSaleNotes() {
        return saleNotes;
    }

    public void setSaleNotes(String saleNotes) {
        this.saleNotes = saleNotes;
    }

    
    
}
