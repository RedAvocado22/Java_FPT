/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author DUNGHUYNH
 */
public class BookDAO {

    public List<BookDTO> list(String keyword, String sortCol) throws ClassNotFoundException {
        
        List<BookDTO> list = new ArrayList<BookDTO>();

        try {

            Connection con = DBUtils.getConnection();
            String sql = "SELECT b.BookID, b.Title, a.AuthorName, c.CategoryName, b.Quantity, b.Status "
                    + "FROM Book b "
                    + "JOIN Author a ON b.AuthorID = a.AuthorID "
                    + "JOIN Category c ON b.CategoryID = c.CategoryID";
          
         
            if (keyword != null && !keyword.isEmpty()) {
                sql += " WHERE b.Title LIKE ? OR a.AuthorName LIKE ?";
            }

            if (sortCol != null && !sortCol.isEmpty()) {
                sql += " ORDER BY " + sortCol + " ASC ";
            }

            PreparedStatement stmt = con.prepareStatement(sql);

            if (keyword != null && !keyword.isEmpty()) {
                stmt.setString(1, "%" + keyword + "%");
                stmt.setString(2, "%" + keyword + "%");
            }

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    int id = rs.getInt("BookID");
                    String title = rs.getString("Title");
                    String authorname = rs.getString("AuthorName");
                    String categoryname = rs.getString("CategoryName");
                    int quantity = rs.getInt("Quantity");
                    String status = rs.getString("Status");

                    BookDTO book = new BookDTO();
                    book.setId(id);
                    book.setTitle(title);
                    book.setAuthorname(authorname);
                    book.setCategoryname(categoryname);
                    book.setQuantity(quantity);
                    book.setStatus(status);

                    list.add(book);
                }
            }

            con.close();
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details:" + ex.getMessage());
            ex.printStackTrace();

        }
        return list;
    }

    /*
    Load student with id
     */
    public BookDTO load(int id) throws ClassNotFoundException {

        String sql = "SELECT b.BookID, b.Title, a.AuthorName, c.CategoryName, b.Quantity, b.Status "
                + "FROM Book b "
                + "JOIN Author a ON b.AuthorID = a.AuthorID "
                + "JOIN Category c ON b.CategoryID = c.CategoryID "
                + "WHERE b.BookID = ?";
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("Title");
                String authorname = rs.getString("AuthorName");
                String categoryname = rs.getString("CategoryName");
                int quantity = rs.getInt("Quantity");
                String status = rs.getString("Status");
                //==========================================================

                BookDTO book = new BookDTO();
                book.setId(id);
                book.setTitle(title);
                book.setAuthorname(authorname);
                book.setCategoryname(categoryname);
                book.setQuantity(quantity);
                book.setStatus(status);
                return book;
            }
        } catch (SQLException ex) {
            System.out.println("Query Book error!" + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(BookDTO book) throws ClassNotFoundException {

        String sql = "UPDATE Book SET Title = ?, Quantity = ?, Status = ? WHERE BookID = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getTitle());       // ✅ Lấy tiêu đề sách

            ps.setInt(2, book.getQuantity());       // ✅ Lấy số lượng sách
            ps.setString(3, book.getStatus());      // ✅ Lấy trạng thái sách
            ps.setInt(4, book.getId());             // ✅ Lấy BookID để cập nhật đúng sách

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("Update book error! " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Integer insert(BookDTO book) throws ClassNotFoundException {

        String sql = "INSERT INTO Book( BookID, Title, Quantity, Status)"
                + " VALUES (?, ?, ?, ?)";
        try {

            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());       // ✅ Lấy tiêu đề sách

            ps.setInt(3, book.getQuantity());       // ✅ Lấy số lượng sách
            ps.setString(4, book.getStatus());      // ✅ Lấy trạng thái sách

            ps.executeUpdate();

            conn.close();
            return book.getId();

        } catch (SQLException ex) {
            System.out.println("Insert book error!" + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public boolean delete(Integer id) throws ClassNotFoundException {
        String sql = "DELETE FROM Book WHERE BookID = ? ";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Delete Book error!" + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

}
