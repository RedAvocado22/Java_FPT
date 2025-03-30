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
import model.Execution;

/**
 *
 * @author Minh Cuong
 */
public class ExecutionDAO extends DBContext {
    
    public List<Execution> getExecutions() {
        List<Execution> executions = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Executions s JOIN Types sb ON s.TypeID = sb.TypeID";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ExecutionID");
                String str = rs.getString("InputString");
                int result = rs.getInt("Result");
                int typeID = rs.getInt("TypeID");
                String typeName = rs.getString("TypeName");
                executions.add(new Execution(id, str, result, typeID, typeName));
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
        return executions;
    }
    
    public static void main(String[] args) {
        ExecutionDAO dao = new ExecutionDAO();
        for (Execution e : dao.getExecutions()) {
            System.out.println(e.getResult());
        }
    }
}
