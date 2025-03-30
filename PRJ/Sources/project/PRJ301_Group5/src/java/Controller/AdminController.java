package Controller;

import Model.Product;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.UserDAO;
import DAO.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminController extends HttpServlet {

    private UserDAO userDAO;
    private ProductDAO productDAO;

    @Override
    public void init() {
        userDAO = new UserDAO();
        productDAO = new ProductDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String section = request.getParameter("section");
        String action = request.getParameter("action");

        if (section == null) {
            section = "product";
        }

        try {
            switch (section) {
                case "user" ->
                    handleUserSection(request, response, action);
                case "product" ->
                    handleProductSection(request, response, action);
                default ->
                    response.sendRedirect("admin?section=product");
            }
        } catch (ServletException | IOException e) {
            throw new ServletException(e);
        }
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

    private void handleUserSection(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException {

        if (action == null) {
            // Display users
            List<User> users = userDAO.getAllUsers();
            String keyword = request.getParameter("keyword");
            if (keyword != null) {
                if (!keyword.isEmpty()) {
                    users = users.stream().filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
                }
            }
//            PrintWriter out = response.getWriter();
//            for (User user : users) {
//                out.println(user.getName());
//            }
            request.setAttribute("users", users);
            request.setAttribute("section", "user");
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } else {
            switch (action) {
                case "deleteUser" -> {
                    int userId = Integer.parseInt(request.getParameter("id"));
                    boolean deletionSuccessful = userDAO.deleteUser(userId);
                    setDeletionMessage(request, deletionSuccessful, "User");
                    response.sendRedirect("admin?section=user");
                }
                case "editUser" -> {
                    String method = request.getMethod();
                    if ("GET".equalsIgnoreCase(method)) {
                        List<User> users = userDAO.getAllUsers();
                        int userId = Integer.parseInt(request.getParameter("id"));

                        User user = users.stream()
                                .filter(u -> u.getId() == userId)
                                .findFirst()
                                .orElse(null);

                        if (user != null) {
                            request.setAttribute("user", user);
                            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
                        } else {
                            response.sendRedirect("admin?section=user&error=notfound");
                        }
                    } else if ("POST".equalsIgnoreCase(method)) {
                        // Update user data
                        int userId = Integer.parseInt(request.getParameter("id"));
                        String userName = request.getParameter("name");
                        String fullName = request.getParameter("fullname");
                        String password = request.getParameter("pass");
                        String email = request.getParameter("email");
                        int roleId = Integer.parseInt(request.getParameter("role"));

                        User updatedUser = new User(userId, userName, "male", email, password, "", roleId, fullName); // Adjust based on User model
                        boolean updateSuccess = userDAO.updateUser(updatedUser);

                        if (updateSuccess) {
                            response.sendRedirect("admin?section=user");
                        } else {
                            response.sendRedirect("updateUser.jsp?id=" + userId + "&error=updatefailed");
                        }
                    }
                }
                default ->
                    response.sendRedirect("admin?section=user"); // Redirect for invalid action
            }
        }
    }

    private void handleProductSection(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException {
        List<Product> products;
        if (null == action) {
            // Display products
            products = productDAO.getAllProducts();

            String keyword = request.getParameter("keyword");
            if (keyword != null) {
                if (!keyword.isEmpty()) {
                    products = products.stream().filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase())).toList();
                }
            }

            request.setAttribute("products", products);
            request.setAttribute("section", "product");
            request.getRequestDispatcher("Admin.jsp").forward(request, response);
        } else {
            switch (action) {
                case "deleteProduct" -> {
                    int productId = Integer.parseInt(request.getParameter("id"));
                    boolean deletionSuccessful = productDAO.deleteProduct(productId);
                    setDeletionMessage(request, deletionSuccessful, "Product");
                    response.sendRedirect("admin?section=product");
                }
                case "editProduct" -> {
                    products = productDAO.getAllProducts();
                    String method = request.getMethod();
                    if ("GET".equalsIgnoreCase(method)) {
                        int productId = Integer.parseInt(request.getParameter("id"));
                        Product product = products.stream().filter(p -> p.getProductID() == productId).findFirst().orElse(null);
                        if (product != null) {
                            request.setAttribute("product", product);
                            request.setAttribute("section", "product");
                            request.getRequestDispatcher("editProduct.jsp").forward(request, response);
                        } else {
                            response.sendRedirect("admin?section=product&error=notfound");
                        }
                    } else if ("POST".equalsIgnoreCase(method)) {
                        // Update product details
                        int productId = Integer.parseInt(request.getParameter("id"));
                        String title = request.getParameter("name");
                        String description = request.getParameter("description");
                        String thumbnail = request.getParameter("thumbnail");
                        int price = Integer.parseInt(request.getParameter("price"));
                        int quantity = Integer.parseInt(request.getParameter("quantity"));
                        int sizeID = Integer.parseInt(request.getParameter("sizeID"));
                        int brandID = Integer.parseInt(request.getParameter("brandID"));
                        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                        String productGender = request.getParameter("productGender");

                        Product updatedProduct = new Product(
                                productId,
                                title,
                                description,
                                thumbnail,
                                price,
                                quantity,
                                sizeID,
                                "",
                                brandID,
                                "",
                                categoryID,
                                "",
                                productGender
                        );

                        boolean updateSuccess = productDAO.updateProduct(updatedProduct);

                        if (updateSuccess) {
                            response.sendRedirect("admin?section=product");
                        } else {
                            PrintWriter out = response.getWriter();
                            out.print(updatedProduct.toString());
//                            response.sendRedirect("editProduct.jsp?id=" + productId + "&error=failed");
                        }
                    }
                }

                case "addProduct" -> {
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");
                    String thumbnail = request.getParameter("thumbnail");
                    int price = Integer.parseInt(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    int sizeID = Integer.parseInt(request.getParameter("sizeID"));
                    int brandID = Integer.parseInt(request.getParameter("brandID"));
                    int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                    String productGender = request.getParameter("productGender");

                    Product product = new Product(0, title, description, thumbnail, price, quantity, sizeID, "", brandID, "", categoryID, "", productGender);
                    if (productDAO.addProduct(product)) {
                        response.sendRedirect("admin");
                    } else {
                        response.sendRedirect("addProduct.jsp?error=failed");
                    }
                }
            }
        }
    }

    private void setDeletionMessage(HttpServletRequest request, boolean success, String entity) {
        String message = success ? entity + " deleted successfully." : "Failed to delete " + entity + ".";
        request.getSession().setAttribute("successMessage", message);
    }
}
