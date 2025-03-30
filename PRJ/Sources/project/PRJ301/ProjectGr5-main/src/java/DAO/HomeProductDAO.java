/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Attribute;
import Model.ProductAtHome;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anh Tuan
 */
public class HomeProductDAO extends DBContext {

    public List<ProductAtHome> getAllProduct(Integer page, String category, String brand, String search, String sort) {
        List<ProductAtHome> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT\n"
                + "    Product.ProductID,\n"
                + "    Product.Title,\n"
                + "    Product.[Description],\n"
                + "    Product.Thumbnail,\n"
                + "    ImageMore.ImageMore,\n"
                + "    Product.Price,\n"
                + "    Product.Quantity,\n"
                + "    Product.SizeID,\n"
                + "    Size.SizeName,\n"
                + "    Product.BrandID,\n"
                + "    Brand.BrandName,\n"
                + "    Product.CategoryID,\n"
                + "    Category.CategoryName,\n"
                + "    Product.ProductGender\n"
                + "FROM\n"
                + "    Brand\n"
                + "INNER JOIN Product ON Brand.BrandID = Product.BrandID\n"
                + "INNER JOIN Category ON Product.CategoryID = Category.CategoryID\n"
                + "INNER JOIN Size ON Product.SizeID = Size.SizeID\n"
                + "OUTER APPLY (\n"
                + "    SELECT TOP 1 [Image].ImageMore\n"
                + "    FROM [Image]\n"
                + "    WHERE [Image].ProductID = Product.ProductID\n"
                + "    ORDER BY [Image].ImageID\n"
                + ") AS ImageMore\n"
                + "WHERE 1=1 ");

        if (category != null && !category.isEmpty()) {
            sql.append(" AND Product.CategoryID = ? ");
        }

        if (brand != null && !brand.isEmpty()) {
            sql.append(" AND Product.BrandID = ? ");
        }

        if (search != null && !search.isEmpty()) {
            sql.append(" AND Product.Title LIKE ? ");
        }
        
        if (sort != null) {
            if (sort.equalsIgnoreCase("ASC")) {
                sql.append(" ORDER BY Product.Price ASC ");
            } else if (sort.equalsIgnoreCase("DESC")) {
                sql.append(" ORDER BY Product.Price DESC ");

            } else {
                sql.append(" ORDER BY Product.ProductID ASC ");
            }
        } else {
            sql.append(" ORDER BY Product.ProductID ASC ");
        }

        if (page
                != null) {
            sql.append(" OFFSET ? ROWS \n"
                    + "FETCH NEXT ? ROWS ONLY;");
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql.toString());
            int count = 1;

            if (category != null && !category.isEmpty()) {
                st.setString(count++, category);
            }

            if (brand != null && !brand.isEmpty()) {
                st.setString(count++, brand);
            }

            if (search != null && !search.isEmpty()) {
                st.setString(count++, "%" + search + "%");
            }

            if (page != null) {
                st.setInt(count++, (page - 1) * 12);
                st.setInt(count++, 12);
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductAtHome c = new ProductAtHome(rs.getInt("ProductID"),
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
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

    public List<ProductAtHome> getNew8Product() {
        List<ProductAtHome> list = new ArrayList<>();
        String sql = "SELECT TOP 8\n"
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
                + "    Brand.BrandName, \n"
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
                + "ORDER BY Product.ProductID DESC;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductAtHome c = new ProductAtHome(rs.getInt("ProductID"),
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
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

    public List<ProductAtHome> getPopular8Product() {
        List<ProductAtHome> list = new ArrayList<>();
        String sql = "SELECT TOP 8\n"
                + "    Product.ProductID, \n"
                + "    Product.Title, \n"
                + "    Product.Description, \n"
                + "    Product.Thumbnail,\n"
                + "    ImageMore.ImageMore,\n"
                + "    Product.Price, \n"
                + "    Product.Quantity, \n"
                + "    Product.SizeID, \n"
                + "    Size.SizeName, \n"
                + "    Product.BrandID, \n"
                + "    Brand.BrandName, \n"
                + "    Product.CategoryID, \n"
                + "    Category.CategoryName, \n"
                + "    Product.ProductGender,\n"
                + "    ISNULL(SUM(OrderDetails.Quantity), 0) AS TotalSold \n"
                + "FROM \n"
                + "    Product \n"
                + "INNER JOIN \n"
                + "    Category ON Product.CategoryID = Category.CategoryID \n"
                + "INNER JOIN \n"
                + "    Brand ON Product.BrandID = Brand.BrandID \n"
                + "LEFT JOIN \n"
                + "    OrderDetails ON Product.ProductID = OrderDetails.ProductID \n"
                + "INNER JOIN \n"
                + "    Size ON Product.SizeID = Size.SizeID \n"
                + "OUTER APPLY (  \n"
                + "    SELECT TOP 1 [Image].ImageMore \n"
                + "    FROM [Image] \n"
                + "    WHERE [Image].ProductID = Product.ProductID \n"
                + "    ORDER BY [Image].ImageID  \n"
                + ") AS ImageMore\n"
                + "GROUP BY \n"
                + "    Product.ProductID, \n"
                + "    Product.Title, \n"
                + "    Product.Description, \n"
                + "    Product.Thumbnail, \n"
                + "    Product.Price, \n"
                + "    Product.Quantity, \n"
                + "    Product.SizeID, \n"
                + "    Size.SizeName, \n"
                + "    Product.BrandID, \n"
                + "    Brand.BrandName, \n"
                + "    Product.CategoryID, \n"
                + "    Category.CategoryName, \n"
                + "    Product.ProductGender,\n"
                + "    ImageMore.ImageMore  \n"
                + "ORDER BY \n"
                + "    TotalSold DESC;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductAtHome c = new ProductAtHome(rs.getInt("ProductID"),
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
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

    public List<Attribute> getAllBrand() {
        List<Attribute> list = new ArrayList<>();
        String sql = "SELECT [BrandID],\n"
                + "       [BrandName],\n"
                + "       ISNULL([BrandImage], 'Hehe') AS [BrandImage]\n"
                + "FROM [dbo].[Brand];";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attribute c = new Attribute(rs.getInt("BrandID"),
                        rs.getString("BrandName"),
                        rs.getString("BrandImage"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

    public List<Attribute> getAllCategory() {
        List<Attribute> list = new ArrayList<>();
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "      ,ISNULL([CategoryImage], 'Hehe') AS [CategoryImage]\n"
                + "  FROM [dbo].[Category]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Attribute c = new Attribute(rs.getInt("CategoryID"),
                        rs.getString("CategoryName"),
                        rs.getString("CategoryImage"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

    public List<ProductAtHome> getFeature8Product() {
        List<ProductAtHome> list = new ArrayList<>();
        String sql = "SELECT TOP 8\n"
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
                + "    Brand.BrandName, \n"
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
                + "ORDER BY Product.Price DESC;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductAtHome c = new ProductAtHome(rs.getInt("ProductID"),
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
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return list;
    }

}
