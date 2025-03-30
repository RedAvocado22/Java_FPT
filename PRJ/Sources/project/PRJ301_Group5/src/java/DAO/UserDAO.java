package DAO;

import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DBContext {
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM [User] u JOIN [Role] r ON u.RoleID = r.RoleID";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("UserID"),
                        rs.getString("UserName"),
                        rs.getString("Gender"),
                        rs.getString("Email"),
                        rs.getString("Password"),
                        "", // Placeholder for avatar
                        rs.getInt("RoleID"),
                        rs.getString("RoleName")
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }
    
    public boolean deleteUser(int id) {
        String query = "DELETE FROM [User] WHERE UserID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean updateUser(User user) {
        String query = "UPDATE [User] SET UserName = ?, Gender = ?, Email = ?, Password = ?, RoleID = ? WHERE UserID = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getGender()); 
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());
            stmt.setInt(6, user.getId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return false;
    }
    
    
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        for (User allUser : dao.getAllUsers()) {
            System.out.println(allUser.getRoleName());
        }
        System.out.println(dao.deleteUser(17));
    }
}
