<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
*
* 공지사항 조회 페이지
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
<form id="delete-form" action="/board/delete" method="post">
    <input type="hidden" name="boardId" value="${board.id}"/>
    <div id="article-container" class="container col-md-4">
        <div class="row justify-content-center">
            <p class="title-font">${board.id}번째 글</p>
        </div>
        <div class="row justify-content-center my-2">
            <label for="title"></label>
            <input class="form-control" type="text" id="title" value="${board.title}" readonly>
        </div>
        <div class="row justify-content-center my-2">
            <label for="content"></label>
            <textarea class="form-control" type="text" id="content" rows="10" readonly>${board.content}</textarea>
        </div>
    </div>
    <c:if test="${board.member.id eq loginId}">
        <div class="row justify-content-center">
            <a class="btn btn-primary col-auto mx-2" href="/board/update?boardId=${board.id}">수정</a>
            <a id="delete-btn" class="btn btn-danger col-auto mx-2">삭제</a>
        </div>
    </c:if>
</form>
<!-- 여기에 바디 구현-->

<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>

<script>
    window.onload = function () {
        let btn = document.querySelector("#delete-btn");

        btn.addEventListener('click', function () {
            if (confirm("정말로 삭제하시겠습니까?")) {
                document.querySelector("#delete-form").submit();
            }
        })
    }
</script>
</body>
</html>

