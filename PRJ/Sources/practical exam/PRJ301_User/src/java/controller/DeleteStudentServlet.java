/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.StudentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Teacher
 */
@WebServlet(name="DeleteStudentServlet", urlPatterns={"/DeleteStudentServlet"})
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      
    } 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Lấy studentID từ request
        int studentID = Integer.parseInt(request.getParameter("studentID"));        
        
        // Xóa sinh viên từ cơ sở dữ liệu
        StudentDAO studentDao = new StudentDAO();
        studentDao.deleteStudent(studentID);
      
        // Chuyển hướng trở lại trang searchStudents.jsp sau khi xóa
        response.sendRedirect("SearchStudentsServlet");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
