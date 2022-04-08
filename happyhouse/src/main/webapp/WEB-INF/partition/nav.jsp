<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="/">HAPPY HOUSE</a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link" href="/board/items">공지사항</a></li>
                <li class="nav-item"><a class="nav-link" href="/place/stores">주변 상가</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="/place/items">관심 지역 설정</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <a
                                class="nav-link"
                                href="#"
                                role="button"
                                id="dropdownMenuLink"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                        >
                            ⫶
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenuLink">
                            <c:if test="${empty loginId}">
                                <li id="anchor-join-link" class="nav-item">
                                    <a class="nav-link" href="/member/join">JOIN</a>
                                </li>
                                <li id="anchor-login-link" class="nav-item">
                                    <a class="nav-link" href="/member/login">LOGIN</a>
                                </li>
                            </c:if>
                            <c:if test="${!empty loginId}">
                                <li id="anchor-member-link" class="nav-item">
                                    <a class="nav-link" href="/member/item">회원정보</a>
                                </li>
                                <li id="anchor-logout-link" class="nav-item">
                                    <a class="nav-link" href="/member/logout">Logout</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>