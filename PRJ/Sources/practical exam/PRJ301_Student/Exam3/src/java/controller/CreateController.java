/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import dal.DepartmentDAO;
import dal.DoctorDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import model.Department;
import model.Doctor;

/**
 *
 * @author Minh Cuong
 */
@WebServlet(name = "CreateController", urlPatterns = {"/create"})
public class CreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();

        List<Doctor> doctors = doctorDAO.getDoctors();
        List<Department> departments = departmentDAO.getDepartments();
        int nextId = doctors.stream().mapToInt(Doctor::getId).max().orElse(0) + 1;

        request.setAttribute("doctors", doctors);
        request.setAttribute("departments", departments);
        request.setAttribute("nextId", nextId);

        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String specialty = request.getParameter("specialty");
        String departmentIDStr = request.getParameter("departmentID");

        if (fullName == null || fullName.isEmpty()
                || specialty == null || specialty.isEmpty()
                || departmentIDStr == null || departmentIDStr.isEmpty()) {

            request.setAttribute("error", "All fields are required.");
            doGet(request, response); // Re-render the form with an error message
            return;
        }

        int departmentID = Integer.parseInt(departmentIDStr);

        DoctorDAO doctorDAO = new DoctorDAO();
        int nextId = doctorDAO.getLastDoctorID() + 1;

        Doctor newDoctor = new Doctor(nextId, fullName, specialty, departmentID);

        boolean isSuccess = doctorDAO.insert(newDoctor);

        PrintWriter out = response.getWriter();
        out.print(newDoctor.getId());
        out.print(newDoctor.getFullName());
        out.print(newDoctor.getSpecialty());
        out.print(newDoctor.getDepartmentId());
        if (isSuccess) {
            request.setAttribute("success", "Add succesfully!");
            doGet(request, response); // Re-render the form
        } else {
            request.setAttribute("error", "Failed to create doctor.");
            doGet(request, response); // Re-render the form
        }
    }
}
