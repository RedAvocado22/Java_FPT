<%-- 
    Document   : Login_Register
    Created on : 25 Oct 2024, 15:55:52
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
                    <li><span class="breadcrumb__link">></span></li>
                    <li><span class="breadcrumb__link">Login / Register</span></li>
                </ul>
            </section>

            <!--=============== LOGIN-REGISTER ===============-->
            <section class="login-register section--lg">
                <div class="login-register__container container grid">
                    <div class="login">
                        <h3 class="section__title">Login</h3>
                        <form class="form grid">
                            <input
                                type="email"
                                placeholder="Your Email"
                                class="form__input"
                                />
                            <input
                                type="password"
                                placeholder="Your Password"
                                class="form__input"
                                />
                            <div class="form__btn">
                                <button class="btn">Login</button>
                            </div>
                        </form>
                    </div>
                    <div class="register">
                        <h3 class="section__title">Create an Account</h3>
                        <form class="form grid">
                            <input
                                type="text"
                                placeholder="Username"
                                class="form__input"
                                />
                            <input
                                type="email"
                                placeholder="Your Email"
                                class="form__input"
                                />
                            <input
                                type="password"
                                placeholder="Your Password"
                                class="form__input"
                                />
                            <input
                                type="password"
                                placeholder="Confirm Password"
                                class="form__input"
                                />
                            <div class="form__btn">
                                <button class="btn">Submit & Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </section>

            <!--=============== NEWSLETTER ===============-->
            <section class="newsletter section">
                <div class="newsletter__container container grid">
                    <h3 class="newsletter__title flex">
                        <img
                            src="./assets/img/icon-email.svg"
                            alt=""
                            class="newsletter__icon"
                            />
                        Sign in to Newsletter
                    </h3>
                    <p class="newsletter__description">
                        ...and receive $25 coupon for first shopping.
                    </p>
                    <form action="" class="newsletter__form">
                        <input
                            type="text"
                            placeholder="Enter Your Email"
                            class="newsletter__input"
                            />
                        <button type="submit" class="newsletter__btn">Subscribe</button>
                    </form>
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

