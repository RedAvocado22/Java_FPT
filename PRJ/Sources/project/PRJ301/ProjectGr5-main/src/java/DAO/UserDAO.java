/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class UserDAO extends DBContext {

    public User login(String user, String pass) {
        String sql = "SELECT * FROM [User] WHERE [UserName] = ? AND [Password] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("UserID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("RoleID")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error in login: " + e.getMessage());
        }
        return null;
    }

    //insert a new User
    public boolean insertUser(String name, String pass, String email, String gender, int roleId) {
        String sql = "INSERT INTO [User] ([UserName], [Password], [Email], [Gender], [RoleID]) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, pass);
            pre.setString(3, email);
            pre.setString(4, gender);
            pre.setInt(5, roleId);
            int rowsAffected = pre.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error in insertUser: " + e.getMessage());
        }
        return false;
    }

    //Check duplicate Users
    public User checkUsers(String user) {
        String sql = "SELECT * FROM [User] WHERE [UserName] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("UserID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("RoleID"));
            }
        } catch (SQLException e) {
            System.out.println("Error in checkUserExists: " + e.getMessage());
        }
        return null;
    }

    //get Users by 
    public int getIDByName(String name) {
        String sql = "select UserID from User where Username like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt("UserID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //get all Users in DB
    public List<User> getAllUsersByRole(int roleId) {
        String sql = "SELECT * FROM [User] WHERE RoleID = ?";
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roleId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("UserID"),
                        rs.getString("UserName"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("RoleID"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error in getAllUsersByRole: " + e.getMessage());
        }
        return list;
    }

    //admin delete account user
    public void deleteUser(int id) {
        String sql = "DELETE FROM [User] WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteUser: " + e.getMessage());
        }
    }

    //get Users by id
    public User getUserByID(int id) {
        String sql = "  select * from User\n"
                + "  where [UserID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("Role"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //update role for user
    public void updateRole(int role, int id) {
        String sql = "UPDATE [User] SET [RoleID] = ? WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, role);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateRole: " + e.getMessage());
        }
    }

    //change password user
    public void change(String pass, String user) {
        String sql = "UPDATE [User] SET [Password] = ? WHERE [UserName] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, user);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in changePassword: " + e.getMessage());
        }
    }

    //get total Users
    public int getTotalUsers() {
        String sql = "select COUNT(*) from User where Role=0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int number = rs.getInt(1);
                return number;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //get next 18 Users
    public List<User> getUsersOffFetch(int index) {
        List<User> list = new ArrayList<>();
        String sql = "select * from User where Role=0 order by UserID offset ? rows fetch next 18 rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * 18);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("Role"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get name Users by id
    public User getNameUserByID(int id) {
        String sql = "  select Username from User\n"
                + "  where [UserID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getInt("Role"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.insertUser("me may", "123", "me@may.com", "male", 4));
        System.out.println(dao.login("Nguyen Van A", "123"));
    }

}
