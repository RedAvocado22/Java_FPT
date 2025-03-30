/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;
import dal.CourseDAO;
import dal.StudentDAO;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import model.Student;

/**
 *
 * @author Teacher
 */
@WebServlet(name="StudentsServlet", urlPatterns={"/StudentsServlet"})
public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Lấy danh sách tất cả sinh viên nếu không có courseID được truyền vào
        // Nếu có courseID, lấy danh sách sinh viên thuộc khóa học đó
        String courseIDParam = request.getParameter("courseID");
        StudentDAO studentDAO = new StudentDAO();
        if (courseIDParam != null && !courseIDParam.isEmpty()) {
            int courseID = Integer.parseInt(courseIDParam);
            List<Student> students = studentDAO.getStudentsByCourseID(courseID);
            request.setAttribute("students", students);
        } else {
            List<Student> students = studentDAO.getAllStudents();
            request.setAttribute("students", students);
        }

        // Lấy danh sách các khóa học từ cơ sở dữ liệu
        CourseDAO courseDAO = new CourseDAO();
        List<Course> courses = courseDAO.getAllCourses();

        // Gửi danh sách sinh viên và danh sách khóa học đến trang JSP
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("students.jsp").forward(request, response);
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
