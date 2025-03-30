/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

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
 * @author dkien
 */
public class ExeServlet extends HttpServlet {

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
        request.getRequestDispatcher("MyExecution.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        List<Execution> list = (List<Execution>) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList<>();
        }

        int n = Integer.parseInt(request.getParameter("number"));
        String str = request.getParameter("str");
        String result = str.substring(0, n + 1);
        Execution e = new Execution(str, n, result);

        boolean isExisted = list.stream()
                .anyMatch(execution
                        -> e.getStr().equals(execution.getStr())
                && e.getIndex() == execution.getIndex());
        if (isExisted) {
            request.setAttribute("error", "Execution existed");
            doGet(request, response);
            return;
        }
        list.add(e);
        session.setAttribute("list", list);
        request.setAttribute("number", n);
        request.setAttribute("str", str);
        request.setAttribute("result", result);
        doGet(request, response);
    }

}
