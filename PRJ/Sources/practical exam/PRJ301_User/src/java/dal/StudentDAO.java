/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author Teacher
 */
public class StudentDAO extends DBContext {

    private static final int ROWS_PER_PAGE = 3; // Số lượng sinh viên mỗi trang

    public int addStudent(String fullName, String gender, int courseID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int studentID = -1;
        try {
            String sql = "INSERT INTO Students (FullName, Gender, CourseID) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, fullName);
            pstmt.setString(2, gender);
            pstmt.setInt(3, courseID);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                studentID = rs.getInt(1);
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
        return studentID;
    }

    public List<Student> getStudentsByCourseID(int courseID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.*, c.CourseName "
                    + "FROM Students s INNER JOIN Courses c "
                    + "ON s.CourseID = c.CourseID "
                    + "WHERE s.CourseID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, courseID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setCourseID(rs.getInt("CourseID"));
                student.setCourseName(rs.getString("CourseName"));
                students.add(student);
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
        return students;
    }

    // Phương thức để lấy danh sách tất cả sinh viên từ cơ sở dữ liệu  
    public List<Student> getAllStudents() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {
            String sql = "SELECT s.*, c.CourseName "
                    + "FROM Students s INNER JOIN Courses c "
                    + "ON s.CourseID = c.CourseID";

            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setCourseID(rs.getInt("CourseID"));
                student.setCourseName(rs.getString("CourseName"));
                students.add(student);
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
        return students;
    }

    // Phương thức để lấy thông tin sinh viên bằng ID từ cơ sở dữ liệu
    public Student getStudentByID(int studentID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;

        try {
            String sql = "SELECT s.*, c.CourseName "
                    + "FROM Students s INNER JOIN Courses c "
                    + "ON s.CourseID = c.CourseID "
                    + "WHERE s.StudentID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, studentID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setCourseID(rs.getInt("CourseID"));
                student.setCourseName(rs.getString("CourseName"));
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
        return student;
    }

    public List<Student> searchStudents(String name, int courseID) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();

        try {

            String sql = "SELECT s.*, c.CourseName "
                    + "FROM Students s INNER JOIN Courses c "
                    + "ON s.CourseID = c.CourseID "
                    + "WHERE s.FullName LIKE ? ";
            if (courseID != -1) {
                sql += "AND c.CourseID = ?";
            }
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            if (courseID != -1) {
                pstmt.setInt(2, courseID);
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setCourseID(rs.getInt("CourseID"));
                student.setCourseName(rs.getString("CourseName"));
                students.add(student);
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
        return students;
    }

    // Phương thức để xóa sinh viên từ cơ sở dữ liệu dựa trên studentID
    public void deleteStudent(int studentID) {
        PreparedStatement pstmt = null;
        try {

            // Xóa sinh viên từ bảng StudentHobbies
            String deleteHobbiesSql = "DELETE FROM StudentHobbies WHERE StudentID = ?";
            pstmt = connection.prepareStatement(deleteHobbiesSql);
            pstmt.setInt(1, studentID);
            pstmt.executeUpdate();

            // Xóa sinh viên từ bảng Students
            String deleteStudentSql = "DELETE FROM Students WHERE StudentID = ?";
            pstmt = connection.prepareStatement(deleteStudentSql);
            pstmt.setInt(1, studentID);
            pstmt.executeUpdate();
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

    public List<Student> getStudentsWithPagination(int page) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList<>();
        try {
            // Tính toán OFFSET để lấy số lượng sinh viên cho trang hiện tại
            int offset = (page - 1) * ROWS_PER_PAGE;

            String sql = "SELECT * FROM Students "
                    + "ORDER BY StudentID "
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, offset);
            pstmt.setInt(2, ROWS_PER_PAGE);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setFullName(rs.getString("FullName"));
                student.setGender(rs.getString("Gender"));
                student.setCourseID(rs.getInt("CourseID"));
                students.add(student);
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public int getTotalStudents() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalStudents = 0;

        try {
            String sql = "SELECT COUNT(*) AS total FROM Students";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                totalStudents = rs.getInt("total");
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
        return totalStudents;
    }
}

/*StudentID không tự tăng


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public int addStudent(String fullName, String gender, int courseID) {
        PreparedStatement pstmt = null;
        int studentID = -1;

        try {

            // Câu lệnh SQL INSERT, không sử dụng auto-increment cho StudentID
            String sql = "INSERT INTO Students (StudentID, FullName, Gender, CourseID) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
pstmt.setInt(1, getNextStudentID(connection)); // Lấy StudentID tiếp theo
            pstmt.setString(2, fullName);
            pstmt.setString(3, gender);
            pstmt.setInt(4, courseID);
            pstmt.executeUpdate();

            studentID = getLastInsertedStudentID(connection); // Lấy StudentID vừa thêm vào
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentID;
    }

    // Hàm để lấy StudentID tiếp theo
    private int getNextStudentID(Connection conn) throws SQLException {
        String sql = "SELECT MAX(StudentID) FROM Students";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int nextID = 1;
        try {
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                nextID = pstmt.getResultSet().getInt(1) + 1;
            }
        } finally {
            if (pstmt != null) pstmt.close();
        }
        return nextID;
    }

    // Hàm để lấy StudentID vừa thêm vào
    private int getLastInsertedStudentID(Connection conn) throws SQLException {
        String sql = "SELECT IDENT_CURRENT('Students')";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int lastID = -1;
        try {
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                lastID = pstmt.getResultSet().getInt(1);
            }
        } finally {
            if (pstmt != null) pstmt.close();
        }
        return lastID;
    }
}
 */
