/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import dal.DoctorDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Doctor;

/**
 *
 * @author Minh Cuong
 */
@WebServlet(name = "ShowController", urlPatterns = {"/show"})
public class ShowController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        Doctor doctor = null;
        if (idString != null) {
            int id = Integer.parseInt(idString);

            DoctorDAO doctorDAO = new DoctorDAO();
            doctor = doctorDAO.getDoctorById(id);
        }

        DoctorDAO doctorDAO = new DoctorDAO();

        List<Doctor> doctors = doctorDAO.getDoctors();

        request.setAttribute("doctors", doctors);
        request.setAttribute("doctor", doctor);

        request.getRequestDispatcher("show.jsp").forward(request, response);

    }
}
