<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>      

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
	<title>호텔 결제 완료</title>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
	</head>
	<body>
		
		<%@ include file="/views/common/header.jsp" %> 
			
	<!--  메뉴바랑 겹치는 부분 제거 -->
	<div style="padding-top:150px;">
	
	</div>
		<div class="container">
			<div class="card o-hidden border-0 shadow-lg my-5">
			  <div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
				  <div class="col-lg-7" style="margin: auto;">
					<div class="p-5">
					  <div class="text-center">
						<h1 class="h4 text-gray-900 mb-4" style="padding-top:50px;">
							<span style="text-weight:bold; font-size:22px;"><%= m.getUserName() %></span>님의 호텔예약이 결제가 전액 완료되었습니다.</h1>
						<hr style="padding-bottom:30px;">
						<h5 style="padding-bottom:50px;">특별 요청 사항이 있으시다면 <br>고객센터 혹은 Q&A로 문의 부탁드립니다.<br><br>
							예약하신 내역은 <span style="font-weight:bold;">*마이페이지>호텔 예약 조회</span>를 통해 <br>확인하실 수 있습니다. 
						</h5>
						
						<a href="/PETNER/index.jsp" class="btn btn-primary btn-user" 
							style="width:250px; background:#008000; color:white; 
							width:150px; margin-bottom:40px; margin-right:10px;">HOME</a>
						<a href="/PETNER/mpServlet.mp" class="btn btn-primary btn-user" 
							style="width:250px; background:#008000; color:white; 
							width:150px; margin-bottom:40px;">MyPage</a>
						
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
				
		<%@ include file="/views/common/footer.jsp" %>
	</body>
</html>