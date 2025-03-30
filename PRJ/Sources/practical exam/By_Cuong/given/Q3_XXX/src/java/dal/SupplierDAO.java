/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Supplier;

/**
 *
 * @author Minh Cuong
 */
public class SupplierDAO extends DBContext {
    
    public List<Supplier> getSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Suppliers s JOIN Types sb ON s.TypeID = sb.TypeID";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String code = rs.getString("SupplierID");
                String name = rs.getString("SupplierName");
                
                SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd");
                String dob = timeFormatter.format(rs.getDate("BirthDate"));
                
                String gender;
                if (rs.getInt("Gender") == 1) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                
                String typeId = rs.getString("TypeID");
                String typeName = rs.getString("TypeName");

                suppliers.add(new Supplier(code, name, dob, gender, typeId, typeName));
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
        return suppliers;
    }
    
    public static void main(String[] args) {
        SupplierDAO s = new SupplierDAO();
        for (Supplier supplier : s.getSuppliers()) {
            System.out.println(supplier.getName());
        }
    }
}
