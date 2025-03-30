/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package dal;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;

/**
 *
 * @author Minh Cuong
 */
public class OrderDetailDAO extends DBContext {

    public boolean insert(List<OrderDetail> orderDetails) {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (OrderDetail orderDetail : orderDetails) {
                pstmt.setInt(1, orderDetail.getOrderId());
                pstmt.setInt(2, orderDetail.getProductId());
                pstmt.setInt(3, orderDetail.getQuantity());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<OrderDetail> getBOrderID(int orderID) {
        List<OrderDetail> orderDetails = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM OrderDetails WHERE OrderID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, orderID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");

                OrderDetail detail = new OrderDetail(orderID, productId, quantity);
                orderDetails.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        return orderDetails;
    }

    public static void main(String[] args) {
        OrderDetailDAO o = new OrderDetailDAO();

//        System.out.println(o.insert(new OrderDetail(1, 3, 2)));
    }
}
