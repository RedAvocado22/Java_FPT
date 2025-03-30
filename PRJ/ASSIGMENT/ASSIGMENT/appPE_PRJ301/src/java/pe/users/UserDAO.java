package pe.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import pe.utils.DBUtils;

public class UserDAO {
    
    public UserDTO login(String username, String password) throws ClassNotFoundException {
        UserDTO user = null;
        String sql = "SELECT UserID, FirstName, LastName, PhoneNumber, Username FROM Users "
                   + " WHERE Username = ? AND Password = ?";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            if (con != null) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        user = new UserDTO();
                        user.setUserID(rs.getInt("UserID"));
                        user.setFirstName(rs.getString("FirstName"));
                        user.setLastName(rs.getString("LastName"));
                        user.setPhoneNumber(rs.getString("PhoneNumber"));
                        user.setUsername(rs.getString("Username"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in UserDAO: " + ex.getMessage());
            ex.printStackTrace();
        }
        return user;
    }
    
      public boolean checkUserExists(String username) throws SQLException, ClassNotFoundException {
        String sql = "SELECT COUNT(*) FROM Users WHERE Username = ?";
        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Nếu COUNT(*) > 0 thì username đã tồn tại
                }
            }
        }
        return false;
    }
   public boolean register(UserDTO user) throws SQLException, ClassNotFoundException {
    String sql = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
    try (Connection con = DBUtils.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        return ps.executeUpdate() > 0;
    } catch (SQLIntegrityConstraintViolationException e) {
        System.out.println("Error: Username '" + user.getUsername() + "' already exists.");
        return false;
    }
   }
  public boolean updateProfile(String username, String firstName, String lastName, String phone, 
                             String email, String gender, String studentID, String birthday) 
                             throws SQLException, ClassNotFoundException {
    boolean updated = false;
    String sql = "UPDATE Users SET FirstName=?, LastName=?, PhoneNumber=? WHERE Username=?";
    
    try (Connection con = DBUtils.getConnection();
         PreparedStatement stm = con.prepareStatement(sql)) {
        
        stm.setString(1, firstName);
        stm.setString(2, lastName);
        stm.setString(3, phone);
        stm.setString(4, username); // Cột Username làm điều kiện WHERE

        updated = stm.executeUpdate() > 0;
    }
    return updated;
}
public boolean updatePassword(String username, String newPassword) throws SQLException, ClassNotFoundException {
    if (username == null || newPassword == null || newPassword.isEmpty()) {
        System.out.println("Lỗi: Username hoặc Password trống!");
        return false;
    }

    String sql = "UPDATE Users SET Password = ? WHERE Username = ?";
    try (Connection conn = DBUtils.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, newPassword);
        stmt.setString(2, username);

        int rowsUpdated = stmt.executeUpdate();
        System.out.println("Debug: Rows updated = " + rowsUpdated);  // Kiểm tra số dòng cập nhật
        
        return rowsUpdated > 0;
    } catch (SQLException e) {
        System.out.println("Lỗi SQL khi cập nhật mật khẩu: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}






}


