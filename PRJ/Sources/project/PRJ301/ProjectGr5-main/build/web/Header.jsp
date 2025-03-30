<%-- 
    Document   : Header
    Created on : 25 Oct 2024, 15:43:40
    Author     : Anh Tuan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header class="header">
            <nav class="nav container">
                <a href="home" class="nav__logo">
                    <img
                        class="nav__logo-img"
                        src="assets/img/logo.svg"
                        alt="website logo"
                        />
                </a>
                <div class="nav__menu" id="nav-menu">
                    <div class="nav__menu-top">
                        <a href="index.html" class="nav__menu-logo">
                            <img src="./assets/img/logo.svg" alt="">
                        </a>
                        <div class="nav__close" id="nav-close">
                            <i class="fi fi-rs-cross-small"></i>
                        </div>
                    </div>
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="home" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="shop" class="nav__link">Shop</a>
                        </li>
                        <li class="nav__item">
                            <a href="account" class="nav__link">My Account</a>
                        </li>
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                <a>Hello, ${sessionScope.user.username}</a>
                                <a href="${pageContext.request.contextPath}/logout">Sign out</a>
                            </c:when>
                            <c:otherwise>
                                <li class="nav__item">
                                    <a href="Login_Register.jsp" class="nav__link">Login</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                    <form action="shop">
                        <div class="header__search">
                            <input name="search"
                                   type="text"
                                   placeholder="Search For Items..."
                                   class="form__input"
                                   />
                            <button type="submit" class="search__btn">
                                <img src="assets/img/search.png" alt="search icon" />
                            </button>
                        </div>
                    </form>
                </div>
                <div class="header__user-actions">
                    <a href="cart" class="header__action-btn" title="Cart">
                        <img src="assets/img/icon-cart.svg" alt="" />
                        <span class="count">3</span>
                    </a>
                    <div class="header__action-btn nav__toggle" id="nav-toggle">
                        <img src="./assets//img/menu-burger.svg" alt="">
                    </div>
                </div>
            </nav>
        </header>
    </body>
</html>
