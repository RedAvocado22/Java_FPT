<%@page import="pe.book.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shelf Page</title>
    </head>
    <body>
      <jsp:include page="/menu.jsp" flush="true" />
 
      <h2>Book Shelf</h2>
     

      <table border="1">
          <tr>
               <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Status</th>
                <th>Action</th>
              
          </tr>
          
          <%
          List<BookDTO> shelf = (List<BookDTO>) request.getAttribute("shelfList");
          if (shelf != null && !shelf.isEmpty()) {
              for (BookDTO book : shelf) { 
          %>
          <tr>
              <td><%= book.getId() %></td>
              <td><%= book.getTitle() %></td>
              <td><%= book.getQuantity() %></td>
              <td><%= book.getStatus() %></td>
              
               <td>
                    <form action="MainController" method="post">
                        <input type="hidden" name="action" value="removeFromShelf">
                        <input type="hidden" name="id" value="<%= book.getId() %>">
                        <input type="submit" value="Remove">
                    </form>
                </td>
          </tr>
          <% 
              }
          } else { 
          %>
          <tr>
              <td colspan="5" style="text-align: center;">No book in shelf</td>
          </tr>
          <% } %>
      </table>

    </body>
</html>
