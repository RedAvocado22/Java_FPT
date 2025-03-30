<%-- 
    Document   : Header
    Created on : 25 Oct 2024, 15:43:40
    Author     : Anh Tuan
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header class="header">
            <nav class="nav container">
                <a href="index.html" class="nav__logo">
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
                            <a href="index.html" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="shop.html" class="nav__link">Shop</a>
                        </li>
                        <li class="nav__item">
                            <a href="accounts.html" class="nav__link">My Account</a>
                        </li>
                        <li class="nav__item">
                            <a href="compare.html" class="nav__link">Compare</a>
                        </li>
                        <li class="nav__item">
                            <a href="login-register.html" class="nav__link">Login</a>
                        </li>
                    </ul>
                    <div class="header__search">
                        <input
                            type="text"
                            placeholder="Search For Items..."
                            class="form__input"
                            />
                        <button class="search__btn">
                            <img src="assets/img/search.png" alt="search icon" />
                        </button>
                    </div>
                </div>
                <div class="header__user-actions">
                    <a href="wishlist.html" class="header__action-btn" title="Wishlist">
                        <img src="assets/img/icon-heart.svg" alt="" />
                        <span class="count">3</span>
                    </a>
                    <a href="cart.html" class="header__action-btn" title="Cart">
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
