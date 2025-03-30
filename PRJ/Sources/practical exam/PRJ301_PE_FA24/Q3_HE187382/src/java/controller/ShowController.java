/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import dal.StudentDAO;
import dal.SubjectDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Student;
import model.Subject;

/**
 *
 * @author Minh Cuong
 */
public class ShowController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String subjectID = request.getParameter("subjectID");

        SubjectDAO subjectDAO = new SubjectDAO();
        StudentDAO studentDAO = new StudentDAO();

        List<Subject> subjects = subjectDAO.getSubjects();
        List<Student> students = studentDAO.getStudents();

        if (id != null) {
            Student student = students.stream()
                                      .filter(s -> s.getId().equalsIgnoreCase(id))
                                      .findFirst()
                                      .orElse(null);
            
            request.setAttribute("student", student);
        }

        if (subjectID != null && !subjectID.equalsIgnoreCase("all")) {
            students = students.stream()
                               .filter(s -> s.getSubjectId().equalsIgnoreCase(subjectID))
                               .toList();
            
            request.setAttribute("subjectID", subjectID);
        } else {
            request.setAttribute("subjectID", "all");
        }

        request.setAttribute("subjects", subjects);
        request.setAttribute("students", students);

        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
