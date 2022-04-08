<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
* 1. 메인화면
* 셀렉트 박스로 주소를 입력받고 getDongPrice.html로 이동한다. (쿼리 파라미터로 주소 정보를 보낸다.)
*
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House</title>
    <c:import url="partition/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/header.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="partition/nav.jsp"/>
<!-- 헤더-->
<header class="masthead">
    <div class="address-container">
        <div class="row justify-content-center">
            <h1 class="option-font">검색하고 싶은 주소를 입력해주세요!</h1>
        </div>
        <div class="row justify-content-center">
            <div class="col-lg-auto">
                <select
                        id="state"
                        class="form-control-lg"
                        name="stateCode"
                        style="font-family: 'Nanum Gothic', sans-serif"
                ></select>
                <select
                        id="city"
                        class="form-control-lg"
                        name="cityCode"
                        style="font-family: 'Nanum Gothic', sans-serif"
                >
                    <option value="">구군선택</option>
                </select>
            </div>
        </div>
    </div>
</header>
<!-- 푸터-->
<c:import url="partition/footer.jsp"/>

<script src="${pageContext.request.contextPath}/static/js/index.js"></script>
</body>
</html>
