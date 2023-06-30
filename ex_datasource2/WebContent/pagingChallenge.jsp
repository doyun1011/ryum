<%@page import="dao.BoarderDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 게시물 list 불러오기  -->
	<c:set var="dao" value="<%=new BoarderDAO()%>" />
	<c:set var="blist" value="${dao.getAll()}" />
	<c:set var="doneLoop" value="false" />
	
	<!-- 페이지 설정  -->
	<c:set var="pageUnit" value="10" />
	<c:set var="pageCutUnit" value="5" />
	
	<table border="1">
		<tr>
			<th>게시판 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>댓글 수</th>
			<th>작성 날짜</th>
			<th>수정 날짜</th>
		</tr>
		
		<!-- 페이지 번호, pre, next 클릭시 보여줄 게시물 설정하기  -->
		<c:choose>
			<c:when test="${not empty sessionScope.initPage}">
				<c:set var="initPage" value="${sessionScope.initPage}" />
				<c:set var="i" value="${sessionScope.initPage-1}" />
			</c:when>
			<c:otherwise>
				<c:set var="initPage" value="1" />
			</c:otherwise>
		</c:choose>
		
		
			<c:if test="${not empty sessionScope.page}">
				<c:set var="i" value="${sessionScope.page - 1}" />
				<c:set var="temp" value="${i % pageCutUnit}" />
				<c:set var="initPage" value="${i - temp + 1}" />
			</c:if>
		
		
		<!--현재의 마지막 페이지와 게시물 시작 번호 설정  -->
		<c:set var="endPage" value="${initPage + pageCutUnit - 1}" />
		<c:set var="index" value="${pageUnit*i}" />

		<!-- 시작 index 부터  pageUnit 만큼 게시물 출력하기 -->
		<c:forEach var="row" items="${blist}" varStatus="vs">
			<c:if test="${vs.count >= index + 1 && not doneLoop}">
				<tr>
					<td><a href="detail?num=${row.num}">${row.num}</a></td>
					<td>${row.title}</td>
					<td>${row.writer}</td>
					<c:if test="${empty row.rp}">
						<c:set target="${row}" property="rp" value="0" />
					</c:if>
					<td>${row.rp}</td>
					<td>${row.date}</td>
					<td>${row.mdDate}</td>
				</tr>
			</c:if>
			<c:if test="${vs.count - index == pageUnit}">
				<c:set var="doneLoop" value="true" />
			</c:if>
		</c:forEach>
	</table>

	<div style="margin-left:120px; margin-top:10px;">
	
	
		<!-- 마지막 페이지와 마지막 initPage 설정-->	
		<c:set var="lastPage" value="${blist.size()/pageUnit}"/>
		<c:set var="temp2" value="${lastPage%pageCutUnit}"/>
		<c:set var="last" value="${lastPage - temp2}"/>
		
		<!-- pre 버튼 visible 설정-->	
		<c:choose>
				<c:when test="${initPage} != 1">
					<div class="pre" style="display: none"><이전></div>
				</c:when>
				<c:otherwise>
					<div class="pre" style="display: inline-block;"><이전></div>
				</c:otherwise>
		</c:choose>
		
		<!-- page 번호 출력하기-->	
		<c:forEach begin="${initPage}" end="${endPage}" varStatus="vs">
			<div class="page" style="display: inline-block;">
			<c:if test="${vs.index <= lastPage}">
				<c:out value="${vs.index}" />
			</c:if>
			</div>
		</c:forEach>
	
		<!-- next 버튼 visible 설정-->	
		<c:choose>
			<c:when test="${initPage > last -1}">
				<div class="next" style="display: none;"><다음></div>
			</c:when>
			<c:otherwise>
				<div class="next" style="display: inline-block;"><다음></div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<script type="text/javascript">
		var page = document.querySelectorAll(".page");
		var pre = document.querySelector(".pre");
		var next = document.querySelector(".next");

		for (var i = 0; i < page.length; i++) {
			page[i].addEventListener("click", paging);
		}

		<!-- 페이지 클릭시  해당 페이지 게시물 번호 전송 -->	
		function paging(e) {
			var target = e.target;
			var value = target.innerText;

			var x = new XMLHttpRequest();

			x.open("POST", "page", true);
			x.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			x.send("page=" + value);
			location.reload();
		}
		
		pre.addEventListener("click",prePage);
		next.addEventListener("click",nextPage);
		
		<!-- 이전 버튼 수행시 보여 줄 initPage 값 전송  -->	
		function prePage(){
			var initPage = ${initPage - pageCutUnit};
			var x = new XMLHttpRequest();

			x.open("POST", "page", true);
			x.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			x.send("initPage=" + initPage);
			location.reload();
		}
		
		<!-- 다음 버튼 수행시 보여 줄 initPage 값 전송  -->	
		function nextPage(){
			var initPage = ${initPage + pageCutUnit};
			var x = new XMLHttpRequest();

			x.open("POST", "page", true);
			x.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			x.send("initPage=" + initPage);
			location.reload();
		}
		
	</script>

</body>
</html>