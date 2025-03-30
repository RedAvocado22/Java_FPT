<%-- 
    Document   : Cart
    Created on : 25 Oct 2024, 15:53:34
    Author     : Anh Tuan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!--=============== FLATICON ===============-->
        <link
            rel="stylesheet"
            href="https://cdn-uicons.flaticon.com/2.0.0/uicons-regular-straight/css/uicons-regular-straight.css"
            />

        <!--=============== SWIPER CSS ===============-->
        <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"
            />

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="./assets/css/styles.css" />

        <title>Ecommerce Website</title>
    </head>
    <body>
        <!--=============== HEADER ===============-->
        <%@include file="Header.jsp" %>
        <!--=============== MAIN ===============-->
        <main class="main">
            <!--=============== BREADCRUMB ===============-->
            <section class="breadcrumb">
                <ul class="breadcrumb__list flex container">
                    <li><a href="index.html" class="breadcrumb__link">Home</a></li>
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><span class="breadcrumb__link">Shop</span></li>
                    <li><span class="breadcrumb__link"></span>></li>
                    <li><span class="breadcrumb__link">Cart</span></li>
                </ul>
            </section>

            <!--=============== CART ===============-->
            <section class="cart section--lg container">
                <div class="table__container">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Subtotal</th>
                                <th>Rename</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <img
                                        src="./assets//img/product-1-2.jpg"
                                        alt=""
                                        class="table__img"
                                        />
                                </td>
                                <td>
                                    <h3 class="table__title">
                                        J.Crew Mercantile Women's Short-Sleeve
                                    </h3>
                                    <p class="table__description">
                                        Lorem ipsum dolor sit amet consectetur.
                                    </p>
                                </td>
                                <td>
                                    <span class="table__price">$110</span>
                                </td>
                                <td><input type="number" value="3" class="quantity" /></td>
                                <td><span class="subtotal">$220</span></td>
                                <td><i class="fi fi-rs-trash table__trash"></i></td>
                            </tr>
                            <tr>
                                <td>
                                    <img
                                        src="./assets//img/product-7-1.jpg"
                                        alt=""
                                        class="table__img"
                                        />
                                </td>
                                <td>
                                    <h3 class="table__title">Amazon Essentials Women's Tank</h3>
                                    <p class="table__description">
                                        Lorem ipsum dolor sit amet consectetur.
                                    </p>
                                </td>
                                <td>
                                    <span class="table__price">$110</span>
                                </td>
                                <td><input type="number" value="3" class="quantity" /></td>
                                <td><span class="subtotal">$220</span></td>
                                <td><i class="fi fi-rs-trash table__trash"></i></td>
                            </tr>
                            <tr>
                                <td>
                                    <img
                                        src="./assets//img/product-2-1.jpg"
                                        alt=""
                                        class="table__img"
                                        />
                                </td>
                                <td>
                                    <h3 class="table__title">
                                        Amazon Brand - Daily Ritual Women's Jersey
                                    </h3>
                                    <p class="table__description">
                                        Lorem ipsum dolor sit amet consectetur.
                                    </p>
                                </td>
                                <td>
                                    <span class="table__price">$110</span>
                                </td>
                                <td><input type="number" value="3" class="quantity" /></td>
                                <td><span class="subtotal">$220</span></td>
                                <td><i class="fi fi-rs-trash table__trash"></i></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="cart__actions">
                    <a href="#" class="btn flex btn__md">
                        <i class="fi-rs-shuffle"></i> Update Cart
                    </a>
                    <a href="#" class="btn flex btn__md">
                        <i class="fi-rs-shopping-bag"></i> Continue Shopping
                    </a>
                </div>

                <div class="divider">
                    <i class="fi fi-rs-fingerprint"></i>
                </div>

                <div class="cart__group grid">
                    <div class="cart__total">
                        <h3 class="section__title">Cart Totals</h3>
                        <table class="cart__total-table">
                            <tr>
                                <td><span class="cart__total-title">Cart Subtotal</span></td>
                                <td><span class="cart__total-price">$240.00</span></td>
                            </tr>
                            <tr>
                                <td><span class="cart__total-title">Shipping</span></td>
                                <td><span class="cart__total-price">$10.00</span></td>
                            </tr>
                            <tr>
                                <td><span class="cart__total-title">Total</span></td>
                                <td><span class="cart__total-price">$250.00</span></td>
                            </tr>
                        </table>
                        <a href="checkout.html" class="btn flex btn--md">
                            <i class="fi fi-rs-box-alt"></i> Proceed To Checkout
                        </a>
                    </div>
                </div>
            </section>

            <!--=============== NEWSLETTER ===============-->
            <section class="newsletter section">
                <div class="newsletter__container container grid">
                </div>
            </section>
        </main>

        <!--=============== FOOTER ===============-->
        <%@include file="Footer.jsp" %>
        <!--=============== SWIPER JS ===============-->
        <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

        <!--=============== MAIN JS ===============-->
        <script src="assets/js/main.js"></script>
    </body>
</html>

