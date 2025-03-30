/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Department;
import model.Doctor;

/**
 *
 * @author Minh Cuong
 */
public class DepartmentDAO extends DBContext{
    
    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Departments";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DepartmentID");
                String name = rs.getString("DepartmentName");
                departments.add(new Department(id, name));
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
        return departments;
    }
}
