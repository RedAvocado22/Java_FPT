<%@page import="pe.book.BookDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hồ sơ cá nhân</title>
    <link rel="stylesheet" href="css/profile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<body>
    <jsp:include page="/menu.jsp" flush="true" />
    
    <div class="profile-container">
        <!-- Sidebar -->
        <div class="sidebar">
            
            <ul>
                <li class="active"><i class="fas fa-user"></i> Thông tin tài khoản</li>
                <li><i class="fas fa-id-card"></i> Hồ sơ cá nhân</li>
                <li><i class="fas fa-bell"></i> Thông báo</li>
                <li><a href="MainController?action=resetPassword"><i class="fas fa-lock"></i> Đổi mật khẩu</a></li>
                <li><i class="fas fa-history"></i> Lịch sử mượn</li>
                <li><i class="fas fa-star"></i> Đánh giá</li>
                <li><a href="MainController?action=logout"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
            </ul>
        </div>

        <!-- Form Hồ sơ cá nhân -->
        <div class="profile-form">
            <h2>Hồ sơ cá nhân</h2>
            <form action="MainController" method="POST">
                <div class="form-group">
                    <label>Họ *</label>
                    <input type="text" name="lastName" placeholder="Nhập họ" required>
                </div>
                <div class="form-group">
                    <label>Tên *</label>
                    <input type="text" name="firstName" placeholder="Nhập tên" required>
                </div>
                <div class="form-group">
                    <label>Số điện thoại</label>
                    <input type="text" name="phone" placeholder="Số điện thoại">
                    <a href="#" class="edit-link">Thay đổi</a>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" placeholder="Chưa có email">
                    <a href="#" class="edit-link">Thêm mới</a>
                </div>
                <div class="form-group gender-group">
                    <label>Giới tính</label>
                    <input type="radio" name="gender" value="Nam"> Nam
                    <input type="radio" name="gender" value="Nữ"> Nữ
                </div>
                <div class="form-group">
                    <label>Mã số sinh viên:</label>
                    <input type="text" name="studentID">
                </div>
               
                <button type="submit" class="save-btn">Lưu thay đổi</button>
            </form>
        </div>
    </div>
</body>
</html>
