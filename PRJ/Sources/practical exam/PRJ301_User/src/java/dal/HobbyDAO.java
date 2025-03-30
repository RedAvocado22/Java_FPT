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
import model.Hobby;

/**
 *
 * @author Teacher
 */
public class HobbyDAO extends DBContext {

    public List<Hobby> getAllHobbies() {
        List<Hobby> hobbies = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Hobbies";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int hobbyID = rs.getInt("HobbyID");
                String hobbyName = rs.getString("HobbyName");
                hobbies.add(new Hobby(hobbyID, hobbyName));
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
        return hobbies;
    }

    public void addHobbiesForStudent(int studentID, String[] hobbies) {
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO StudentHobbies (StudentID, HobbyID) VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);
            for (String hobby : hobbies) {
                pstmt.setInt(1, studentID);
                pstmt.setInt(2, Integer.parseInt(hobby));
                pstmt.executeUpdate();
            }
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
    }

    public List<Hobby> getHobbiesByStudentID(int studentID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Hobby> hobbies = new ArrayList<>();

        try {
            String sql = "SELECT * FROM StudentHobbies SH INNER JOIN Hobbies H ON SH.HobbyID = H.HobbyID WHERE SH.StudentID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, studentID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Hobby hobby = new Hobby();
                hobby.setHobbyID(rs.getInt("HobbyID"));
                hobby.setHobbyName(rs.getString("HobbyName"));
                hobbies.add(hobby);
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
        return hobbies;
    }
}
