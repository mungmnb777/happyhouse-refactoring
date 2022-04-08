<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Happy House | 회원 가입</title>
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp" />
        <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet" />
        <c:if test="${!empty msg}">
        <script>
        	alert("${msg}");
        </script>
        </c:if>
    </head>
    <body id="page-top">
        <!-- 네비게이션-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
        <!-- 헤더-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

        <!-- 회원가입 --->
        <div class="row justify-content-center">
            <div class="col-md-4 m-3 p-3">
                <div class="title-font">회원가입</div>
                <form class="form-check row g-3" action="/member/join" method="post">
                    <div class="col-auto">
                        <label for="name" class="form-label">이름</label>
                        <input
                            type="text"
                            class="form-control"
                            id="name"
                            name="name"
                            placeholder="이름를 입력해주세요"
                            value="${member.name}"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="id" class="form-label">아이디</label>
                        <input
                            type="text"
                            class="form-control"
                            id="id"
                            name="id"
                            placeholder="아이디를 입력해주세요"
                            value="${member.id}"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="password" class="form-label">비밀번호</label>
                        <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="비밀번호를 입력해주세요"
                            value="${member.password}"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="nickname" class="form-label">닉네임</label>
                        <input
                            type="text"
                            class="form-control"
                            id="nickname"
                            name="nickname"
                            placeholder="닉네임을 입력해주세요"
                            value="${member.nickname}"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="tel" class="form-label">전화번호</label>
                        <input
                            type="tel"
                            class="form-control"
                            id="tel"
                            name="tel"
                            placeholder="전화번호를 입력해주세요"
                            value="${member.tel}"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="email" class="form-label">이메일</label>
                        <input
                            type="text"
                            class="form-control"
                            id="email"
                            name="email"
                            placeholder="이메일을 입력해주세요"
                            value="${member.email}"
                        />
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">JOIN</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- 푸터-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
        <!-- 회원가입 JS 로직 -->
        <script src="${pageContext.request.contextPath}/static/js/join.js"></script>
    </body>
</html>

