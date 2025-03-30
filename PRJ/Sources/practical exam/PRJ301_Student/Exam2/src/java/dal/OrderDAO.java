/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 *
 * @author Minh Cuong
 */
public class OrderDAO extends DBContext {

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Orders";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int orderID = rs.getInt("OrderID");
                int customerID = rs.getInt("CustomerID");
                String orderDate = rs.getString("OrderDate");

                Order order = new Order(orderID, orderDate, customerID);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Method to retrieve the latest OrderID from the database
    public int getLatestOrderID() {
        PreparedStatement pstmt = null;
        int latestOrderID = 0;
        ResultSet rs = null;

        try {
            String sql = "SELECT MAX(OrderID) FROM Orders";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                latestOrderID = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return latestOrderID;
    }

    public boolean insert(Order order) {
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO Orders (OrderID, OrderDate, CustomerID) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, order.getId());
            pstmt.setString(2, order.getDate());
            pstmt.setInt(3, order.getCustomerId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        OrderDAO a = new OrderDAO();
//
//        boolean success = a.insert(new Order(7, "2024-02-29", 3));
//
//        if (success) {
//            System.out.println("Order inserted successfully.");
//        } else {
//            System.out.println("Failed to insert order.");
//        }
//    }
}
