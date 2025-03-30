<%-- 
    Document   : Detail
    Created on : 25 Oct 2024, 15:53:39
    Author     : Anh Tuan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li><span class="breadcrumb__link"></span>/</li>
                    <li><span class="breadcrumb__link">Fashion</span></li>
                    <li><span class="breadcrumb__link"></span>/</li>
                    <li><span class="breadcrumb__link">${detail.title}</span></li>
                </ul>
            </section>

            <!--=============== DETAILS ===============-->
            <section class="details section--lg">
                <div class="details__container container grid">
                    <div class="details__group">
                        <img
                            src="${detail.thumbnail}"
                            alt=""
                            class="details__img"
                            />
                        <div class="details__small-images grid">
                            <img
                                src="${detail.imageMore}"
                                alt=""
                                class="details__small-img"
                                />
                            <img
                                src="${detail.imageMore}"
                                alt=""
                                class="details__small-img"
                                />
                            <img
                                src="${detail.imageMore}"
                                alt=""
                                class="details__small-img"
                                />
                        </div>
                    </div>
                    <div class="details__group">
                        <h3 class="details__title">${detail.title}</h3>
                        <p class="details__brand">Brand: <span>${detail.brandName}</span></p>
                        <div class="details__price flex">
                            <span class="new__price">$${detail.price}</span>
                            <!--                            <span class="old__price">$200.00</span>
                                                        <span class="save__price">25% Off</span>-->
                        </div>
                        <p class="short__description">
                            ${detail.description}
                        </p>
                        <ul class="products__list">
                            <li class="list__item flex">
                                <i class="fi-rs-crown"></i> 1 Year Al Jazeera Brand Warranty
                            </li>
                            <li class="list__item flex">
                                <i class="fi-rs-refresh"></i> 30 Days Return Policy
                            </li>
                            <li class="list__item flex">
                                <i class="fi-rs-credit-card"></i> Cash on Delivery available
                            </li>
                        </ul>
                        <div class="details__color flex">
                            <span class="details__color-title">Quantity</span>
                            <ul class="color__list">
                                <li>
                                    ${detail.quantity}
                                </li>

                            </ul>
                        </div>
                        <div class="details__size flex">
                            <span class="details__size-title">Size</span>
                            <ul class="size__list">
                                <li>
                                    <a href="#" class="size__link size-active">${detail.sizeName}</a>
                                </li>

                            </ul>
                        </div>
                        <div class="details__action">
                            <input type="number" class="quantity" value="3" />
                            <a href="#" class="btn btn--sm">Add To Card</a>
                            <a href="#" class="details__action-btn">
                                <i class="fi fi-rs-heart"></i>
                            </a>
                        </div>
                        <!--                        <ul class="details__meta">
                                                    <li class="meta__list flex"><span>SKU:</span>FWM15VKT</li>
                                                    <li class="meta__list flex">
                                                        <span>Tags:</span>Clothes, Women, Dress
                                                    </li>
                                                    <li class="meta__list flex">
                                                        <span>Availability:</span>8 Items in Stock
                                                    </li>
                                                </ul>-->
                    </div>
                </div>
            </section>

            <!--=============== DETAILS TAB ===============-->



            <!--=============== PRODUCTS ===============-->
            <section class="products container section--lg">
                <h3 class="section__title"><span>Related</span> Products</h3>
                <div class="products__container grid">
                    <c:forEach items="${listRelated}" var="p">
                        <div class="product__item">
                            <div class="product__banner">
                                <a href="product?service=detail&productId=${p.productID}" class="product__images">
                                    <img
                                        src="${p.thumbnail}"
                                        alt=""
                                        class="product__img default"
                                        />
                                    <img
                                        src="${p.thumbnail}"
                                        alt=""
                                        class="product__img hover"
                                        />
                                </a>
                                <div class="product__actions">
                                    <a href="product?service=detail&productId=${p.productID}" class="action__btn" aria-label="Quick View">
                                        <i class="fi fi-rs-eye"></i>
                                    </a>
                                    <a
                                        href="#"
                                        class="action__btn"
                                        aria-label="Add to Wishlist"
                                        >
                                        <i class="fi fi-rs-heart"></i>
                                    </a>
                                    <a href="#" class="action__btn" aria-label="Compare">
                                        <i class="fi fi-rs-shuffle"></i>
                                    </a>
                                </div>
                                <div class="product__badge light-pink">Hot</div>
                            </div>
                            <div class="product__content">
                                <span class="product__category">Clothing</span>
                                <a href="details.html">
                                    <h3 class="product__title">${p.title}</h3>
                                </a>
                                <div class="product__rating">
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                    <i class="fi fi-rs-star"></i>
                                </div>
                                <div class="product__price flex">
                                    <span class="new__price">$${p.price}</span>
                                </div>
                                <a
                                    href="#"
                                    class="action__btn cart__btn"
                                    aria-label="Add To Cart"
                                    >
                                    <i class="fi fi-rs-shopping-bag-add"></i>
                                </a>
                            </div>
                        </div>
                    </c:forEach>


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

