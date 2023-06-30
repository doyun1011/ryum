<%@page import="dao.TestDAO"%>
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


	<script type="text/javascript">
		var page = document.querySelectorAll(".page");

		for (var i = 0; i < page.length; i++) {
			page[i].addEventListener("click", paging);
		}

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
	</script>

</body>
</html>