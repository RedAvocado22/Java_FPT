/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Execution;

/**
 *
 * @author Minh Cuong
 */
public class ExecutionController extends HttpServlet {

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
        String str = request.getParameter("str");
        String option = request.getParameter("option");
        int result = 0, se = 0;

        HttpSession session = request.getSession();
        List<Execution> executions = (List<Execution>) session.getAttribute("executions");
        if (executions == null) {
            executions = new ArrayList();
        }

        switch (option) {
            case "Vowel characters" -> {
                result = Vowels_Consonats(str);
                se = 1;
            }

            case "Length of string" -> {
                result = str.length();
                se = 2;
            }
        }
        
        if (
            !executions.stream()
                      .filter(e -> e.getStr().equalsIgnoreCase(str))
                      .filter(e -> e.getOption().equalsIgnoreCase(option))
                      .findFirst().isEmpty()
        ) {
            request.setAttribute("error", "Execution existed!");
            request.setAttribute("result", "");
        } else {
            executions.add(new Execution(str, option, result));
            request.setAttribute("result", result);
        }

        session.setAttribute("executions", executions);
        request.setAttribute("str", str);
        request.setAttribute("se", se);
        request.setAttribute("option", option);
        request.getRequestDispatcher("MyExam.jsp").forward(request, response);
    }

    public int Vowels_Consonats(String str) {
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                // Kiểm tra xem ký tự có phải là nguyên âm hay không
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return vowels;
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
