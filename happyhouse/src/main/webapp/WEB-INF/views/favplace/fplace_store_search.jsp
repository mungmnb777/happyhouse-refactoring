<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
*
* 관심지역 상가 조회 페이지
*
-->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 관심 지역 상가 조회</title>
    <!-- Favicon-->
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css"/>
    <link href="${pageContext.request.contextPath}/static/css/fplace_store.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/static/css/fplace_store_kakao_map.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

<!-- 여기에 바디 구현-->

<section class="main-container">
    <div class="place-info-container">
        <h3 class="title-font">관심 지역 목록</h3>
        <div class="row justify-content-center">
            <div
                    id="place-info-list"
                    class="col-md-8 p-5 border-start border-end border-warning"
            >
                <c:if test="${empty list}">
                    <h3 class="text-center empty-content-font mb-5">관심지역 정보가 없습니다!</h3>
                </c:if>
                <c:forEach var="item" items="${list}">
                    <div class="my-3">
                        <div class="place-address">
                            <div class="place-state">${item.dong.city.state.name}</div>
                            <span class="place-city">${item.dong.city.name}</span>
                            <span class="place-dong">${item.dong.name}</span>
                        </div>
                        <div class="mt-3">
                            <a class="btn btn-outline-primary"
                               href="javascript:moveMap('${item.dong.city.state.name}',
	            												 '${item.dong.city.name}', '${item.dong.name}')">
                                지도보기
                            </a>
                        </div>
                        <hr>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="row">
            <c:set var="url" value="${pageContext.request.requestURI}"/>
            <c:if test="${!empty list}">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="${root}/place/stores?pg=${paging.prevBlock}">이전</a>
                    </li>
                    <c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}">
                        <li class="page-item">
                            <a class="page-link" href="${root}/place/stores?pg=${page}">${page}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="${root}/place/stores?pg=${paging.nextBlock}">다음</a>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
    <!-- 카카오 맵 -->
    <div class="map-container">
        <div style="height: 100px">
            <h3 class="place-info-title">지도</h3>
        </div>
        <div class="map_wrap">
            <div
                    id="map"
                    style="width: 100%; height: 880px; position: relative; overflow: hidden"
            ></div>
            <ul id="category">
                <li id="BK9" data-order="0"><span class="category_bg bank"></span>은행</li>
                <li id="MT1" data-order="1"><span class="category_bg mart"></span>마트</li>
                <li id="PM9" data-order="2">
                    <span class="category_bg pharmacy"></span>약국
                </li>
                <li id="OL7" data-order="3"><span class="category_bg oil"></span>주유소</li>
                <li id="CE7" data-order="4"><span class="category_bg cafe"></span>카페</li>
                <li id="CS2" data-order="5">
                    <span class="category_bg store"></span>편의점
                </li>
            </ul>
        </div>
    </div>
</section>

<!-- 여기에 바디 구현-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>

<script>
    window.onload = function () {
        printPlace();
    };
</script>

<!-- 카카오 맵 API -->
<script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=786ea11e71ca9d8b2f94bb6cbd905330&libraries=services"
></script>

<script src="${pageContext.request.contextPath}/static/js/fplace_store_kakao_map.js"></script>
</body>
</html>
