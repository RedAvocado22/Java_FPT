/*
  Student ID   : HE187382
  Student name : Nguyen Minh Cuong
  Due date     :  
 */
package controller;

import dal.CustomerDAO;
import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 *
 * @author Minh Cuong
 */
public class CreateOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();

        List<Product> products = productDAO.getAllProducts();
        List<Customer> customers = customerDAO.getAllCustomers();
        int nextOrderId = orderDAO.getLatestOrderID() + 1;

        request.setAttribute("products", products);
        request.setAttribute("customers", customers);
        request.setAttribute("nextOrderId", nextOrderId);

        request.getRequestDispatcher("createOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderIdStr = request.getParameter("orderID");
        String customerIdStr = request.getParameter("customer");
        String orderDateStr = request.getParameter("orderDate");

        if (orderIdStr != null && customerIdStr != null && orderDateStr != null) {
            int orderID = Integer.parseInt(orderIdStr);
            int customerID = Integer.parseInt(customerIdStr);
            String[] productIds = request.getParameterValues("products");

            Order order = new Order(orderID, orderDateStr, customerID);

            OrderDAO orderDAO = new OrderDAO();
            boolean orderInserted = orderDAO.insert(order);

            if (orderInserted && productIds != null) {
                OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                List<OrderDetail> orderDetailsList = new ArrayList();

                for (String productIdStr : productIds) {
                    int prodId = Integer.parseInt(productIdStr);
                    String quantityStr = request.getParameter("quantity_" + prodId);

                    if (quantityStr != null && !quantityStr.isEmpty()) {
                        int quantity = Integer.parseInt(quantityStr);
                        OrderDetail orderDetail = new OrderDetail(orderID, prodId, quantity);
                        orderDetailsList.add(orderDetail);
                    }
                }

                boolean orderDetailsInserted = orderDetailDAO.insert(orderDetailsList);

                if (orderDetailsInserted) {
                    response.sendRedirect("success.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
