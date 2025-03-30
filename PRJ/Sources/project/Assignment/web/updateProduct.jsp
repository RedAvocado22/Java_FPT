<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard - Fruit Store</title>
        <link rel="stylesheet" type="text/css" href="css/styleAddProduct.css">
    </head>
    <body>
        <div class="admin-container">
            <div class="header">
                <h2>Admin Panel</h2>
                <nav>
                    <ul>
                        <li><a href="AdminController">Products Management</a></li>
                        <li><a href="AdminController">Orders Management</a></li>
                        <li><a href="AdminController">User Management</a></li>
                    </ul>
                </nav>
            </div>

            <div class="main-content">
                <h2>Edit Product</h2>
                <div class="content-section active">
                    <form method="post" action="updatepro">
                        <input type="text"  name="id" value="${product.vegetableId}" hidden>
                        <div class="form-group">
                            <label for="name">Product Name:</label>
                            <input type="text" id="name" name="name" value="${product.name}">
                        </div>

                        <div class="form-group">
                            <label for="origin">Origin:</label>
                            <input type="text" id="origin" name="origin" value="${product.origin}">
                        </div>

                        <div class="form-group">
                            <label for="pack">Pack Size:</label>
                            <input type="text" id="pack" name="pack" value="${product.pack}">
                        </div>

                        <div class="form-group">
                            <label for="img">Image URL:</label>
                            <input type="text" id="img" name="img" value="${product.img}">
                        </div>

                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="text" id="price" name="price" value="${product.price}">
                        </div>

                        <div class="form-group">
                            <label for="status">Status:</label>
                            <input type="text" id="status" name="status" value="${product.status}">
                        </div>

                        <div class="form-group">
                            <label for="description">Description:</label>
                            <textarea id="description" name="description" >${product.description}</textarea>
                        </div>

                        <input type="submit" value="Edit Product" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
