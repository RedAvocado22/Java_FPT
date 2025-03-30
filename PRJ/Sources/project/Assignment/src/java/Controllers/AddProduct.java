/*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package Controllers;

import DAO.DAO_Products;
import Models.UserDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDTO user = (UserDTO) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("LoginController");
            return;
        }

        if (!user.isRole()) {
            response.sendRedirect("HomeController");
            return;
        }
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String origin = request.getParameter("origin");
            int pack = Integer.parseInt(request.getParameter("pack"));
            String img = request.getParameter("img");
            double price = Double.parseDouble(request.getParameter("price"));
            String status = request.getParameter("status");
            String description = request.getParameter("description");
            
            boolean isAdded = DAO_Products.INSTANCE.insertProduct(id, name, origin, pack, img, price, status, description);

            if (isAdded) {
                request.getSession().setAttribute("successMessage", "Product updated successfully!");
            }

            response.sendRedirect("AdminController?product");

        } catch (NumberFormatException | IOException | SQLException e) {
            response.sendRedirect("error.jsp");
        }
    }

}
