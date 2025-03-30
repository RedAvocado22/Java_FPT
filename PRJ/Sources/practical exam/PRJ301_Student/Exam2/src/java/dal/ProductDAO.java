/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
/**
 *
 * @author Teacher
 */
public class ProductDAO extends DBContext {
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Products";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
        return products;
    }
    
    public Product getProductByID(int productID) {
        Product product = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Products WHERE ProductID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, productID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");

                product = new Product(productID, productName, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
//    public static void main(String[] args) {
//        ProductDAO p = new ProductDAO();
//        p.getAllProducts().forEach(pr -> System.out.println(pr.toString()));
//    }
}
