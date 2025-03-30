<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.book.BookDTO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/booklist.css">
    </head>
    <body>
        <%@ include file="/menu.jsp" %>

        <div class="container">
            <!-- Bộ lọc -->
           <aside class="filter">
    <h3>LỌC THEO</h3>
    <form action="MainController" method="GET">
        <input type="hidden" name="action" value="listbook">
        <!-- Các checkbox lựa chọn -->
        <ul>
            <li><input type="checkbox" class="category-checkbox" value="Science Fiction"> Science Fiction </li>
            <li><input type="checkbox" class="category-checkbox" value="History"> History Book</li>
            <li><input type="checkbox" class="category-checkbox" value="Programming"> Programming book </li>
            <li><input type="checkbox" class="category-checkbox" value="Philosophy"> Philosophy book </li>
            <li><input type="checkbox" class="category-checkbox" value="new"> Sách mới</li>
            <li><input type="checkbox" class="category-checkbox" value="kit"> Bộ dụng cụ</li>
        </ul>
           
        <!-- Ẩn input để chứa các category được chọn -->
        <input type="hidden" name="categories" id="categories">

        <input type="submit" value="Lọc">
    </form>
</aside>

            <!-- Danh sách sách -->
            <div class="book-container">
                <%
                    List<BookDTO> list = (List<BookDTO>) request.getAttribute("bookList");
                    if (list != null && !list.isEmpty()) {
                        for (BookDTO book : list) {
                            pageContext.setAttribute("book", book);
                %>

                <div class="book-item">
                    <img src="<%= book.getImageUrl() %>" alt="<%= book.getTitle() %>" width="150">
                    <p>
                        <a href="MainController?action=viewBookInfo&id=<%= book.getId() %>">
                            <%= book.getTitle() %>
                        </a>
                    </p>
                </div>

                <%
                        }
                    } else {
                %>
                <p style="text-align: center; width: 100%;">Không tìm thấy sách</p>
                <% } %>
            </div>
        </div>
    </body>
</html>
