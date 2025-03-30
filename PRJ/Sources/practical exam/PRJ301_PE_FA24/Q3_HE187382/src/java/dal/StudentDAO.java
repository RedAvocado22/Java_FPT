package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDAO extends DBContext {

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Students s JOIN Subjects sb ON s.SubjectID = sb.SubjectID";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("StudentID");
                String name = rs.getString("StudentName");
                
                SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd");
                String birthDate = timeFormatter.format(rs.getDate("BirthDate"));
                
                String gender;
                if (rs.getInt("Gender") == 1) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                
                String subjectId = rs.getString("SubjectID");
                String subjectName = rs.getString("SubjectName");

                students.add(new Student(id, name, birthDate, gender, subjectId, subjectName));
            }
        } catch (SQLException e) {
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
            }
        }
        return students;
    }
    
    public static void main(String[] args) {
        StudentDAO s = new StudentDAO();
        
        for (Student student : s.getStudents()) {
            System.out.println(student.toString());
        }
    }
    
}
