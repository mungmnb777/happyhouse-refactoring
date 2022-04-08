<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Happy House | 동별 아파트 실거래 현황 조회</title>
    <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/house_list.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- 네비게이션-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp"/>
<!-- 헤더-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp"/>

<!-- 메인 컨테이너 - 왼쪽에는 아파트 거래 정보, 오른쪽에는 구글 지도 API가 들어간다.-->
<section class="main-container">
    <div class="house-info-container">
        <h3 class="house-info-title">거래 정보</h3>
        <div class="row justify-content-center">
            <div
                    id="house-info-list"
                    class="col-md-8 p-5 border-start border-end border-warning"
            >
                <c:if test="${empty houseList}">
                    <h3 class="text-center house-name mb-5">아파트 정보가 없습니다!</h3>
                </c:if>
                <c:forEach var="house" items="${houseList}">
                    <div class="house-info">
                        <div class="house-name">${house.name}</div>
                        <div class="house-address">
                            <span>${house.city.state.name}</span>
                            <span>${house.city.name}</span>
                            <span>${house.roadName}</span>
                            <span>${house.mainRoadNo}</span>
                        </div>
                        <div class="house-price">
                            <div>
                                <span class="price-label">실거래가</span>
                                <span class="house-deal-date">
	                    					${house.dealYear}.${house.dealMonth}.${house.dealDay}
	                    				</span>
                            </div>
                            <div>
                                <span class="house-deal-price">${house.price}</span>
                                <span class="house-deal-price-unit">만원</span>
                            </div>
                        </div>
                        <div class="house-area">
                            <div class="area-label">면적</div>
                            <div>
                                <span class="house-area-value">${house.area}</span>
                                <span class="house-area-unit">
	                    					<span>m</span>
	                    					<sup>2</sup>
	                    				</span>
                            </div>
                        </div>
                        <div class="btn-detail">
                            <a href="javascript:getLocationByAddress('${house.city.state.name}', '${house.city.name}', '${house.roadName}', '${house.mainRoadNo}')"
                               class="btn btn-outline-warning"
                            >
                                지도 보기
                            </a>
                        </div>
                        <hr>
                    </div>
                </c:forEach>
                <div class="row">
                    <c:set var="url" value="${pageContext.request.requestURI}"/>
                    <c:if test="${!empty houseList}">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link"
                                   href="${root}/items?cityCode=${param.cityCode}&pg=${paging.prevBlock}">이전</a>
                            </li>
                            <c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="${root}/items?cityCode=${param.cityCode}&pg=${page}">${page}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item">
                                <a class="page-link"
                                   href="${root}/items?cityCode=${param.cityCode}&pg=${paging.nextBlock}">다음</a>
                            </li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <!-- 카카오 맵 -->
    <div class="map-container">
        <div style="height: 100px">
            <h3 class="house-info-title">지도</h3>
        </div>
        <div id="map" style="width: 100%; height: 1000px"></div>
    </div>
</section>

<!-- 푸터-->
<c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp"/>
<!-- 카카오 맵 API -->
<script
        type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=786ea11e71ca9d8b2f94bb6cbd905330&libraries=services"
></script>

<script src="${pageContext.request.contextPath}/static/js/house_list_map.js"></script>
</body>
</html>

