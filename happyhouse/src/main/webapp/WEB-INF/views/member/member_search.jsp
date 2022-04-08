<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 회원 정보 조회</title>
    <!-- Favicon-->
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${pageContext.request.contextPath}/static/css/styles.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션 -->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더 -->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>
<!-- 삭제 -->
<script>
    window.onload = function () {
        let btn = document.querySelector("#delete-btn");

        btn.addEventListener('click', function () {
            if (confirm("정말로 탈퇴하시겠습니까?")) {
                document.querySelector("#delete-form").submit();
            }
        })
    }
</script>
<!-- 회원정보 -->
<div class="row justify-content-center">
    <div class="col-md-4 m-3 p-3">
        <div class="title-font">회원 정보</div>
        <form id="delete-form" class="form-check row g-3" action="/member/delete" method="post">
            <div class="col-auto">
                <label for="name" class="form-label">이름</label>
                <input
                        type="text"
                        class="form-control"
                        id="name"
                        name="name"
                        value="${member.name}"
                        readonly
                />
            </div>
            <div class="col-auto">
                <label for="id" class="form-label">아이디</label>
                <input
                        type="text"
                        class="form-control"
                        id="id"
                        name="id"
                        value="${member.id}"
                        readonly
                />
            </div>
            <div class="col-auto">
                <label for="nickname" class="form-label">닉네임</label>
                <input
                        type="text"
                        class="form-control"
                        id="nickname"
                        name="nickname"
                        value="${member.nickname}"
                        readonly
                />
            </div>
            <div class="col-auto">
                <label for="tel" class="form-label">전화번호</label>
                <input
                        type="tel"
                        class="form-control"
                        id="tel"
                        name="tel"
                        value="${member.tel}"
                        readonly
                />
            </div>
            <div class="col-auto">
                <label for="email" class="form-label">이메일</label>
                <input
                        type="text"
                        class="form-control"
                        id="email"
                        name="email"
                        value="${member.email}"
                        readonly
                />
            </div>
            <div class="col-auto">
                <a href="${root}/member/update" class="btn btn-primary">수정</a>
            </div>
            <div class="col-auto">
                <button id="delete-btn" type="button" class="btn btn-danger">탈퇴</button>
            </div>
        </form>
    </div>
</div>
<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
</body>
</html>
