<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit User - Admin Dashboard</title>
        <link rel="stylesheet" type="text/css" href="assets/css/styleAddProduct.css">
    </head>
    <body>
        <div class="admin-container">
            <div class="header">
                <h2>Admin Panel</h2>
                <nav>
                    <ul>
                        <li><a href="adminr?section=product">Products Management</a></li>
                        <li><a href="admin?section=user">User Management</a></li>
                    </ul>
                </nav>
            </div>

            <div class="main-content">
                <h2>Edit User</h2>
                <div class="content-section active">
                    <form method="post" action="admin?action=editUser">
                        <!-- Hidden field for user ID -->
                        <input type="hidden" name="id" value="${user.id}">
                        <input type="hidden" name="section" value="user">

                        <div class="form-group">
                            <label for="name">Username:</label>
                            <input type="text" id="name" name="name" value="${user.name}" required>
                        </div>

                        <div class="form-group">
                            <label for="pass">Password:</label>
                            <input type="text" id="pass" name="pass" value="${user.password}" required>
                        </div>

                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" value="${user.email}" required>
                        </div>

                        <div class="form-group">
                            <label for="role">Role:</label>
                            <select id="role" name="role" required>
                                <option value="1" ${user.roleId == 1 ? "selected" : ""}>Admin</option>
                                <option value="4" ${user.roleId == 4 ? "selected" : ""}>Customer</option>
                                <option value="2" ${user.roleId == 2 ? "selected" : ""}>Marketing</option>
                                <option value="3" ${user.roleId == 3 ? "selected" : ""}>Sales</option>
                            </select>
                        </div>

                        <input type="submit" value="Edit User" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
