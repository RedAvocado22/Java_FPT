/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;
/**
 *
 * @author Teacher
 */
public class CourseDAO extends DBContext {
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            

            String sql = "SELECT * FROM Courses";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int courseID = rs.getInt("CourseID");
                String courseName = rs.getString("CourseName");
                courses.add(new Course(courseID, courseName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courses;
    }
}
