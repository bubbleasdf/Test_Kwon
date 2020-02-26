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

	
	<h1>여기다가 에러 페이지를 만들면 될 것 같다?!</h1>
	<h1>403 에러!!</h1>


	<%@ include file="../views/common/footer.jsp" %>
	
</body>

</html>