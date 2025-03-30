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
import model.Customer;

/**
 *
 * @author Minh Cuong
 */
public class CustomerDAO extends DBContext {

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Customers";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("CustomerID");
                String name = rs.getString("CustomerName");
                String email = rs.getString("ContactEmail");
                customers.add(new Customer(id, name, email));
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
        return customers;
    }

    public Customer getByOrderID(int orderID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Customer customer = null;

        try {
            String sql = "SELECT c.CustomerID, c.CustomerName, c.ContactEmail "
                    + "FROM Customers c "
                    + "JOIN Orders o ON c.CustomerID = o.CustomerID "
                    + "WHERE o.OrderID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, orderID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int customerID = rs.getInt("CustomerID");
                String name = rs.getString("CustomerName");
                String email = rs.getString("ContactEmail");
                customer = new Customer(customerID, name, email);
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
        return customer;
    }
//    public static void main(String[] args) {
//        CustomerDAO c = new CustomerDAO();
//        c.getAllCustomers().forEach(pr -> System.out.println(pr.toString()));
//    }
}
