/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CourseDAO;
import dal.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Course;
import model.Student;

/**
 *
 * @author Teacher
 */
@WebServlet(name = "SearchStudentsServlet", urlPatterns = {"/SearchStudentsServlet"})
public class SearchStudentsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        String courseIDParam = request.getParameter("courseID");

        if (searchName == null) {
            searchName = ""; // Nếu không có tên sinh viên, đặt giá trị mặc định là chuỗi trống
        }

        int courseID = -1;
        if (courseIDParam != null && !courseIDParam.isEmpty()) {
            courseID = Integer.parseInt(courseIDParam);
        }
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.searchStudents(searchName, courseID);
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.getAllCourses();

        request.setAttribute("students", students);
        request.setAttribute("courses", courses);

        request.getRequestDispatcher("searchStudents.jsp").forward(request, response);
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
