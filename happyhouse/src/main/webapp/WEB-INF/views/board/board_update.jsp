<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
*
* 공지사항 수정 페이지
*
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 공지사항 조회</title>
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

<!-- 여기에 바디 구현-->
<div id="article-container" class="container col-md-4">
    <form method="post" action="/board/update">
        <input type="hidden" name="author" value="${board.member.id}"/>
        <input type="hidden" name="boardId" value="${board.id}"/>

        <div class="row justify-content-center">
            <p class="title-font">${board.id}번째글</p>
        </div>
        <div class="row justify-content-center my-2">
            <label for="title"></label>
            <input class="form-control" type="text" id="title" name="title" value="${board.title}">
        </div>
        <div class="row justify-content-center my-2">
            <label for="content"></label>
            <textarea class="form-control" type="text" id="content" name="content" rows="10">${board.content}</textarea>
        </div>
        <c:if test="${board.member.id eq loginId}">
            <div class="row justify-content-center">
                <button type="submit" class="btn btn-primary col-auto mx-2">완료</button>
            </div>
        </c:if>
    </form>

</div>
<!-- 여기에 바디 구현-->

<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
</body>
</html>

