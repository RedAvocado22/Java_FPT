/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CourseDAO;
import dal.HobbyDAO;
import dal.StudentDAO;
import java.util.List;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import model.Hobby;

/**
 *
 * @author Teacher
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDAO = new CourseDAO();
        HobbyDAO hobbyDAO = new HobbyDAO();

        List<Course> courses = courseDAO.getAllCourses();
        List<Hobby> hobbies = hobbyDAO.getAllHobbies();

        request.setAttribute("courses", courses);
        request.setAttribute("hobbies", hobbies);

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        int courseID = Integer.parseInt(request.getParameter("course"));
        String[] hobbies = request.getParameterValues("hobbies");

        // Gọi model để lưu thông tin sinh viên
        StudentDAO studentDAO = new StudentDAO();
        int studentID = studentDAO.addStudent(fullName, gender, courseID);

        // Lưu sở thích của sinh viên
        if (hobbies != null && hobbies.length > 0) {
            HobbyDAO hobbyDAO = new HobbyDAO();
            hobbyDAO.addHobbiesForStudent(studentID, hobbies);
        }

        response.sendRedirect("success.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
