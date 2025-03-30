/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */

package controller;

import dal.OrderDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;

/**
 *
 * @author Minh Cuong
 */
@WebServlet(name="OrdersController", urlPatterns={"/orders"})
public class OrdersController extends HttpServlet {
   
   

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.getAllOrders(); // This method should return the list of all orders

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("orders.jsp").forward(request, response);
    } 


}
