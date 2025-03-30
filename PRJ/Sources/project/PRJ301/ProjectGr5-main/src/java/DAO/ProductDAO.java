/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ProductAtHome;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author havie
 */
public class ProductDAO extends DBContext {
    public static void main(String[] args) {
        System.out.println(new ProductDAO().getRelatedProduct(1));
    }

    public ProductAtHome getProductById(int prouductId) {
        ProductAtHome p = null;
        String sql = "SELECT \n"
                + "    Product.ProductID, \n"
                + "    Product.Title, \n"
                + "    Product.[Description], \n"
                + "    Product.Thumbnail, \n"
                + "    ImageMore.ImageMore, \n"
                + "    Product.Price, \n"
                + "    Product.Quantity, \n"
                + "    Product.SizeID, \n"
                + "    Size.SizeName, \n"
                + "    Product.BrandID, \n"
                + "    Brand.BrandName,\n"
                + "    Product.CategoryID, \n"
                + "    Category.CategoryName, \n"
                + "    Product.ProductGender\n"
                + "FROM \n"
                + "    Brand \n"
                + "INNER JOIN Product ON Brand.BrandID = Product.BrandID \n"
                + "INNER JOIN Category ON Product.CategoryID = Category.CategoryID \n"
                + "INNER JOIN Size ON Product.SizeID = Size.SizeID\n"
                + "OUTER APPLY (  \n"
                + "    SELECT TOP 1 [Image].ImageMore \n"
                + "    FROM [Image] \n"
                + "    WHERE [Image].ProductID = Product.ProductID \n"
                + "    ORDER BY [Image].ImageID  \n"
                + ") AS ImageMore\n"
                + "WHERE \n"
                + "    Product.ProductID = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, prouductId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 p = new ProductAtHome(rs.getInt("ProductID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getString("Thumbnail"),
                        rs.getString("ImageMore"),
                        rs.getInt("Price"),
                        rs.getInt("Quantity"),
                        rs.getInt("SizeID"),
                        rs.getString("SizeName"),
                        rs.getInt("BrandID"),
                        rs.getString("BrandName"),
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"),
                        rs.getString("ProductGender"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return p;
    }
    
    public List<ProductAtHome> getRelatedProduct(int currentProductId) {
    List<ProductAtHome> relatedProducts = new ArrayList<>();
    
    // Truy vấn để lấy ra các sản phẩm có cùng CategoryID nhưng khác ProductID hiện tại
    String sql = "SELECT TOP 4 " +
            "    Product.ProductID, " +
            "    Product.Title, " +
            "    Product.[Description], " +
            "    Product.Thumbnail, " +
            "    ImageMore.ImageMore, " +
            "    Product.Price, " +
            "    Product.Quantity, " +
            "    Product.SizeID, " +
            "    Size.SizeName, " +
            "    Product.BrandID, " +
            "    Brand.BrandName, " +
            "    Product.CategoryID, " +
            "    Category.CategoryName, " +
            "    Product.ProductGender " +
            "FROM Brand " +
            "INNER JOIN Product ON Brand.BrandID = Product.BrandID " +
            "INNER JOIN Category ON Product.CategoryID = Category.CategoryID " +
            "INNER JOIN Size ON Product.SizeID = Size.SizeID " +
            "OUTER APPLY ( " +
            "    SELECT TOP 1 [Image].ImageMore " +
            "    FROM [Image] " +
            "    WHERE [Image].ProductID = Product.ProductID " +
            "    ORDER BY [Image].ImageID " +
            ") AS ImageMore " +
            "WHERE Product.CategoryID = (SELECT CategoryID FROM Product WHERE ProductID = ?) " +
            "AND Product.ProductID != ?";

    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, currentProductId);  // ID sản phẩm hiện tại để lấy CategoryID
        ps.setInt(2, currentProductId);  // Loại bỏ sản phẩm hiện tại khỏi kết quả
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            ProductAtHome relatedProduct = new ProductAtHome(
                    rs.getInt("ProductID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getString("Thumbnail"),
                    rs.getString("ImageMore"),
                    rs.getInt("Price"),
                    rs.getInt("Quantity"),
                    rs.getInt("SizeID"),
                    rs.getString("SizeName"),
                    rs.getInt("BrandID"),
                    rs.getString("BrandName"),
                    rs.getInt("CategoryID"),
                    rs.getString("CategoryName"),
                    rs.getString("ProductGender")
            );
            relatedProducts.add(relatedProduct);
        }
    } catch (SQLException e) {
        System.err.println(e);
    }

    return relatedProducts;
}

}
