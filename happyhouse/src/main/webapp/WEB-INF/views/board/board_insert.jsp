<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
    *   
    *   공지사항 추가 페이지
    *
 -->
<!DOCTYPE html>
<html lang="en">
    <head>
    	<meta charset="UTF-8">
        <title>Happy House | 공지사항 작성</title>
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/head.jsp" />
        <link href="${pageContext.request.contextPath}/static/css/font.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- 네비게이션-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/nav.jsp" />
        <!-- 헤더-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/header.jsp" />


    
        <!-- 여기에 바디 구현-->
        <div class="container col-md-4">
            <div class="row justify-content-center">
                <div class="col-auto">
                    <p class="title-font">글 쓰기</p>
                </div>
            </div>
			<form id="write-form" action="/board/insert" method = "post">
	            <div class="row justify-content-center my-2">
	                <label for="title">제목</label>
	                <input type="text" id="title" name="title" class="form-control" />
	            </div>
	
	            <div class="row justify-content-center my-2">
	                <label for="content">내용</label>
	                <textarea id="content" name="content" class="form-control" rows="10"></textarea>
	            </div>
	
	            <div class="row justify-content-center">
	                <button type="button" class="btn btn-primary col-auto mx-2" id = "insertArticle">저장</button>
	                <a class="btn btn-secondary col-auto mx-2" href="${root}/board/items"> 취소 </a>
	            </div>
	        </form>
        </div>

        <!-- 여기에 바디 구현-->
        <!-- 푸터-->
        <c:import url="${pageContext.request.contextPath}/WEB-INF/partition/footer.jsp" />
        <!-- 공지사항 관련 JS 로직 -->
        		<!-- 공지사항 관련 JS 로직 -->
		<script type="text/javascript">
	        $(document).ready(function () {
	            $("#insertArticle").click(function () {
	                if (!$("#title").val()) {
	                    alert("제목 입력!!!!");
	                    return;
	                } else if (!$("#content").val()) {
	                    alert("내용 입력!!!!");
	                    return;
	                } else {
	                    $("#write-form").submit();
	                }
	            });
	        });
   		</script>
    </body>
</html>
