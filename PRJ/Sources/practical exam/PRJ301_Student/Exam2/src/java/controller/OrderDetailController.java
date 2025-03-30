package controller;

import dal.CustomerDAO;
import dal.OrderDetailDAO;
import dal.ProductDAO;
import model.Customer;
import model.OrderDetail;
import model.Product;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderIdStr = request.getParameter("orderID");
        if (orderIdStr != null) {
            int orderID = Integer.parseInt(orderIdStr);

            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.getByOrderID(orderID);

            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            List<OrderDetail> orderDetails = orderDetailDAO.getBOrderID(orderID);

            ProductDAO productDAO = new ProductDAO();
            request.setAttribute("customer", customer);
            request.setAttribute("orderDetails", orderDetails);

            request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
        } else {
            response.sendRedirect("orderList.jsp");
        }
    }   
}
