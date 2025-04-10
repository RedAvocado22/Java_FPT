/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import dal.ExecutionDAO;
import dal.TypeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Execution;

/**
 *
 * @author Minh Cuong
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");
        String str = request.getParameter("str");

        ExecutionDAO executionDAO = new ExecutionDAO();
        TypeDAO typeDAO = new TypeDAO();
        
        List<Execution> executions = executionDAO.getExecutions();
        List<String> types = typeDAO.getTypes();

        if (option != null) {
            if (!option.isEmpty()) {
                executions = executions.stream().filter(e -> e.getTypeName().equalsIgnoreCase(option)).toList();
            }
        }
        
        if (str != null) {
            if (!str.isEmpty()) {
                executions = executions.stream().filter(e -> e.getStr().toLowerCase().contains(str.toLowerCase())).toList();
            }
        }
        
        request.setAttribute("executions", executions);
        request.setAttribute("types", types);
        request.setAttribute("option", option);
        request.setAttribute("str", str);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
