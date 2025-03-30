/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.HobbyDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Hobby;
import model.Student;

/**
 *
 * @author Teacher
 */
@WebServlet(name = "StudentDetailServlet", urlPatterns = {"/StudentDetailServlet"})
public class StudentDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin sinh viên dựa trên ID từ cơ sở dữ liệu
        int studentID = Integer.parseInt(request.getParameter("studentID"));
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentByID(studentID);
        
        // Lấy danh sách sở thích của sinh viên từ cơ sở dữ liệu
        HobbyDAO hobbyDao = new HobbyDAO();
        List<Hobby> hobbies = hobbyDao.getHobbiesByStudentID(studentID);

        // Gửi thông tin sinh viên và danh sách sở thích đến trang JSP
        request.setAttribute("student", student);
        request.setAttribute("hobbies", hobbies);
        request.getRequestDispatcher("studentDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
