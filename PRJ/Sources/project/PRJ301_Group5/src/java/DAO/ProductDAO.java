package DAO;

import Model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getString("Thumbnail"),
                        rs.getInt("Price"),
                        rs.getInt("Quantity"),
                        rs.getInt("SizeID"),
                        "", // Placeholder for sizeName
                        rs.getInt("BrandID"),
                        "", // Placeholder for brandName
                        rs.getInt("CategoryID"),
                        "", // Placeholder for categoryName
                        rs.getString("ProductGender")
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public boolean deleteProduct(int id) {
        String query = "DELETE FROM Image WHERE ProductID = ?\n"
                + "DELETE FROM Product WHERE ProductID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean addProduct(Product product) {
        String query = "INSERT INTO Product (Title, Description, Thumbnail, Price, Quantity, SizeID, BrandID, CategoryID, ProductGender) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getTitle());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getThumbnail());
            stmt.setInt(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getSizeID());
            stmt.setInt(7, product.getBrandID());
            stmt.setInt(8, product.getCategoryID());
            stmt.setString(9, product.getProductGender());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean updateProduct(Product product) {
    String query = "UPDATE Product SET Title = ?, Description = ?, Thumbnail = ?, Price = ?, Quantity = ?, SizeID = ?, BrandID = ?, CategoryID = ?, ProductGender = ? WHERE ProductID = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, product.getTitle());
        stmt.setString(2, product.getDescription());
        stmt.setString(3, product.getThumbnail());
        stmt.setInt(4, product.getPrice());
        stmt.setInt(5, product.getQuantity());
        stmt.setInt(6, product.getSizeID());
        stmt.setInt(7, product.getBrandID());
        stmt.setInt(8, product.getCategoryID());
        stmt.setString(9, product.getProductGender());
        stmt.setInt(10, product.getProductID());  // ProductID is the identifier for the WHERE clause
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return false;
}

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println(dao.updateProduct(new Product(4, "Áo khoác lông cừu trắngggg", "Chất nỉ kết hợp lông cừu dày dặn màu trắng kem nhẹ nhàng thanh lịch", "Images/Female/aokhoacHM_2.jpg", 1, 1, 1, "", 1, "", 1,"", "male")));
    }
}
