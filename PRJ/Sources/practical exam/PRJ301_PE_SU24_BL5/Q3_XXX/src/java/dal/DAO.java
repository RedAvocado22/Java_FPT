/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Execution;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkien
 */
public class DAO extends DBContext {

    private DAO() {
    }

    public static DAO getInstance() {
        return new DAO();
    }

    public List<Execution> getAll(String typeOrder, String indexOrder) {
        List<Execution> list = new ArrayList<>();
        String sql = """
                     SELECT  [ExecutionID]
                           ,[InputString]
                           ,[SubIndex]
                           ,[Result]
                           ,[TypeName]
                       FROM [Y24SU1B5].[dbo].[Executions], [Y24SU1B5].[dbo].[Types]
                        WHERE [Executions].[TypeID] = [Types].[TypeID]
                     """;
        typeOrder = typeOrder == null ? "" : typeOrder;
        indexOrder = indexOrder == null ? "" : indexOrder;

        if (!"".equals(typeOrder) && !"".equals(indexOrder)) {
            sql += String.format("\nORDER BY [TypeName] %s, [SubIndex] %s", typeOrder, indexOrder);
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ExecutionID");
                String inputString = rs.getString("InputString");
                int subIndex = rs.getInt("SubIndex");
                String result = rs.getString("Result");
                String typeName = rs.getString("TypeName");
                list.add(new Execution(id, inputString, subIndex, result, typeName));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(DAO.getInstance().getAll("", ""));
    }
}
