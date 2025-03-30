/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Student;

/**
 *
 * @author Teacher
 */
@WebServlet(name = "StudentsPaginationServlet", urlPatterns = {"/StudentsPaginationServlet"})
public class StudentsPaginationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getStudentsWithPagination(page);
        request.setAttribute("students", students);

        int totalStudents = studentDAO.getTotalStudents(); // Lấy tổng số sinh viên từ cơ sở dữ liệu
        request.setAttribute("totalStudents", totalStudents);
        request.getRequestDispatcher("studentsPagination.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
