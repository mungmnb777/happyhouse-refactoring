<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Happy House | 로그인</title>
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp" />
        <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- 네비게이션-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
        <!-- 헤더-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

        <!-- 로그인 - 현재는 서버를 붙이지 않았으므로 button type을 button으로 사용한다.-->
        <div class="row justify-content-center">
            <div class="col-md-4 m-3 p-3">
                <div class="title-font">로그인</div>
                <form class="form-check row g-3" action="/member/login" method="post">
                    <div class="col-auto">
                        <label for="id" class="form-label">ID</label>
                        <input
                            type="id"
                            class="form-control"
                            id="id"
                            name="id"
                            placeholder="아이디를 입력해주세요"
                        />
                    </div>
                    <div class="col-auto">
                        <label for="password" class="form-label">Password</label>
                        <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="비밀번호를 입력해주세요"
                        />
                    </div>
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary">LOGIN</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- 푸터-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
    </body>
</html>

