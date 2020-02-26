<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>

<!DOCTYPE html>
<html>

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Favicon-->
	<link rel="shortcut icon" href="/PETNER/resources/img/common/small_logo.jpg">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Petner+</title>
</head>
<style>
	.home-banner-area {
  background: url(/PETNER/resources/img/dogcat.jpg) no-repeat center fixed;
  background-size: cover; }
</style>


<body>

	<%@ include file="../views/common/header.jsp" %> 
	<!--######## start banner Area ########-->
	<!--  메뉴바랑 겹치는 부분 제거 -->
	<div style="padding-top:150px;"></div>

	
	<div style="text-align:center;">
		<img alt="에러페이지" src="/PETNER/resources/img/404error.png" style="max-width:1024px;">
	</div>


	<%@ include file="../views/common/footer.jsp" %>
	
</body>

</html>