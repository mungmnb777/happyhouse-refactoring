<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
*
* 공지사항 목록 조회 페이지
*
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 공지사항</title>
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

<!-- 여기에 바디 구현-->

<div class="my-5">
    <div class="row justify-content-center">
        <div class="col-auto">
            <p class="title-font">공지사항</p>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-9 text-center">
            <table class="table table-hover">
                <tbody id="article-table-body">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>날짜</th>
                    <th>작성자</th>
                </tr>
                <c:forEach var="article" items="${list}">
                    <tr>
                        <td>${article.id}</td>
                        <td><a href="${root}/board/item?boardId=${article.id}">${article.title}</a></td>
                        <td>${article.cdate}</td>
                        <td>${article.member.nickname}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty list}">
                    <tr>
                        <td colspan="4"><h3 class="empty-content-font">작성한 글이 없습니다.</h3></td>
                    </tr>
                </c:if>
                </tbody>
            </table>
            <c:if test="${!empty list}">
                <div class="row">
                    <ul class="pagination justify-content-center">
                        <li class="page-item">
                            <a class="page-link" href="${root}/board/items?pg=${paging.prevBlock}">이전</a>
                        </li>
                        <c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}">
                            <li class="page-item">
                                <a class="page-link" href="${root}/board/items?pg=${page}">${page}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item">
                            <a class="page-link" href="${root}/board/items?pg=${paging.nextBlock}">다음</a>
                        </li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-auto">
            <a href="${root}/board/insert" class="btn btn-primary">글쓰기</a>
        </div>
    </div>
</div>

<!-- 여기에 바디 구현-->

<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
</body>
</html>

