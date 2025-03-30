<%@page import="pe.rate.RateDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="pe.book.BookDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Thông tin Sách</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/bookinfo.css">

    </head>
    <body>
        <%@ include file="/menu.jsp" %>
        <div class="container">
            <% BookDTO book = (BookDTO) request.getAttribute("book"); %>
            <% if (book != null) {%>
            <div class="content-wrapper">
                <div class="left-section">
                    <!-- Hình ảnh sản phẩm -->
                    <div class="product-images">
                        <img src="<%= book.getImageUrl()%>" alt="<%= book.getTitle()%>">
                    </div>
                    <!-- Tên sách dưới hình ảnh -->
                    <h2 class="book-title"><%= book.getTitle()%></h2>
                    <!-- Nút Thêm vào giỏ hàng và Mượn ngay -->
                    <div class="button-group">
                        <form action="MainController" method="POST">
                            <input type="hidden" name="action" value="addToShelf">
                            <input type="hidden" name="id" value="<%= book.getId()%>">
                            <button type="submit" class="add-to-cart">Thêm vào giỏ hàng</button>
                        </form>
                        <button class="borrow-now">Mượn ngay</button>
                    </div>
                </div>
                <div class="right-section">
                    <p><strong>Tác giả:</strong> <%= book.getAuthorname()%></p>
                    <p><strong>Thể loại:</strong> <%= book.getCategoryname()%></p>
                    <p><strong>Số lượng:</strong> <%= book.getQuantity()%></p>
                    <!-- Mô tả sản phẩm -->
                    <div class="description">
                        <h3>Mô tả sản phẩm</h3>

                    </div>
                </div>
            </div>

            <!-- Form đánh giá -->
            <div class="review-section">
                <h3>Đánh giá của bạn</h3>
                <form action="MainController" method="POST">
                    <input type="hidden" name="action" value="RateBook"> <!-- Thêm action -->
                    <input type="hidden" name="bookId" value="<%= book.getId()%>">

                    <!-- Chọn sao -->
                    <div class="star-rating">
                        <input type="radio" id="star5" name="rateStar" value="5"><label for="star5">&#9733;</label>
                        <input type="radio" id="star4" name="rateStar" value="4"><label for="star4">&#9733;</label>
                        <input type="radio" id="star3" name="rateStar" value="3"><label for="star3">&#9733;</label>
                        <input type="radio" id="star2" name="rateStar" value="2"><label for="star2">&#9733;</label>
                        <input type="radio" id="star1" name="rateStar" value="1"><label for="star1">&#9733;</label>
                    </div>

                    <!-- Ô nhập bình luận -->
                    <div class="comment-input">
                        <textarea name="comment" id="comment" placeholder="Nhập đánh giá của bạn..."></textarea>
                    </div>

                    <!-- Nút gửi -->
                    <button class="submit-review" type="submit">Gửi đánh giá</button>
                </form>
            </div>

            <!-- Danh sách đánh giá -->
            <div class="review-list">
                <h3>Đánh giá trước đó</h3>
                <% List<RateDTO> rates = (List<RateDTO>) request.getAttribute("rates"); %>
                <% if (rates != null && !rates.isEmpty()) { %>
                <% for (RateDTO rate : rates) {%>
                <div class="review-item">
                    <p><strong><%= rate.getUsername()%></strong> - <%= rate.getRateStar()%> sao</p>
                    <p><%= rate.getComment()%></p>
                </div>
                <% } %>
                <% } else { %>
                <p>Chưa có đánh giá nào.</p>
                <% } %>
            </div>

            <% } else { %>
            <p style="color: red; text-align: center;">Không tìm thấy thông tin sách.</p>
            <% }%>
        </div>
    </body>
</html>
