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
import model.Doctor;

/**
 *
 * @author Minh Cuong
 */
public class DoctorDAO extends DBContext {

    public List<Doctor> getDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Doctors";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("DoctorID");
                String fullName = rs.getString("FullName");
                String specialty = rs.getString("Specialty");
                int departmentID = rs.getInt("DepartmentID");
                doctors.add(new Doctor(id, fullName, specialty, departmentID));
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
        return doctors;
    }

    public boolean insert(Doctor doctor) {
        PreparedStatement pstmt = null;
        boolean isInserted = false;

        try {
            String sql = "INSERT INTO Doctors (DoctorID, FullName, Specialty, DepartmentID) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, doctor.getId());
            pstmt.setString(2, doctor.getFullName());
            pstmt.setString(3, doctor.getSpecialty());
            pstmt.setInt(4, doctor.getDepartmentId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                isInserted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // It's better to log this in real-world applications
        } finally {
        }

        // Do not close the connection here, the servlet will handle closing if necessary
        return isInserted;
    }

    public int getLastDoctorID() {
        PreparedStatement pstmt = null;
        int latestOrderID = 0;
        ResultSet rs = null;

        try {
            String sql = "SELECT MAX(DoctorID) FROM Doctors";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                latestOrderID = rs.getInt(1);
            }
        } catch (SQLException e) {
        } finally {
        }
        return latestOrderID;
    }

    public Doctor getDoctorById(int doctorId) {
        Doctor doctor = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Doctors WHERE DoctorID = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, doctorId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("DoctorID");
                String fullName = rs.getString("FullName");
                String specialty = rs.getString("Specialty");
                int departmentID = rs.getInt("DepartmentID");

                doctor = new Doctor(id, fullName, specialty, departmentID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return doctor;
    }

    public static void main(String[] args) {
        DoctorDAO d = new DoctorDAO();
        System.out.println(d.getLastDoctorID());
    }
}
