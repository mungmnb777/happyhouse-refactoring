<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
*
* 관심 지역 추가 페이지
*
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 관심 지역 추가</title>
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

<!-- 여기에 바디 구현-->

<div class="row justify-content-center">
    <div class="col-lg-auto">
        <div class="title-font">관심 지역</div>
        <form class="form-check row g-3" action="/place/insert" method="post">
            <div class="col-auto">
                <select
                        name="sido"
                        id="state"
                        class="form-control-sm"
                        style="font-family: 'Nanum Gothic', sans-serif"
                >
                    <option value="">시도선택</option>
                </select>
                <select
                        name="gugun"
                        id="city"
                        class="form-control-sm"
                        style="font-family: 'nanum Gothic', sans-serif"
                >
                    <option value="">구군선택</option>
                </select>
                <select
                        name="dong"
                        id="dong"
                        class="form-control-sm"
                        style="font-family: 'Nanum Gothic', sans-serif"
                >
                    <option value="">동선택</option>
                </select>
                <button
                        type="submit"
                        class="btn btn-primary"
                >등록
                </button
                >
            </div>
        </form>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-md-6">
        <table class="table table-hover">
            <tbody id="place-table-body">
            <tr class="text-center">
                <th class="col-md-9">관심 지역</th>
                <th class="col-md-3">삭제</th>
            </tr>
            <c:if test="${empty list}">
                <tr class="text-center">
                    <td colspan="2">
                        <h3 class="empty-content-font">관심지역 정보가 없습니다!</h3>
                    </td>
                </tr>
            </c:if>
            <c:forEach var="item" items="${list}">
                <tr class="text-center">
                    <td class="col-md-9">${item.dong.city.state.name} ${item.dong.city.name} ${item.dong.name}</td>
                    <td class="col-md-3"><a href="javascript:deletePlace('${item.id}')" class="btn btn-outline-danger">삭제</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <c:set var="url" value="${pageContext.request.requestURI}"/>
        <c:if test="${!empty list}">
            <ul class="pagination justify-content-center">
                <li class="page-item">
                    <a class="page-link" href="${root}/place/items?pg=${paging.prevBlock}">이전</a>
                </li>
                <c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}">
                    <li class="page-item">
                        <a class="page-link" href="${root}/place/items?pg=${page}">${page}</a>
                    </li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="${root}/place/items?pg=${paging.nextBlock}">다음</a>
                </li>
            </ul>
        </c:if>
    </div>
</div>

<!-- 여기에 바디 구현-->

<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
<!-- 시도, 구군, 동 JS 로직 -->
<script src="${pageContext.request.contextPath}/static/js/fplace_list.js"></script>
</body>
</html>
