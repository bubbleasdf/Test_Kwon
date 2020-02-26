<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.*" %>
<%
	HotelReserve hr = (HotelReserve)request.getAttribute("HotelReserve");
%>
<!DOCTYPE html>
<html>
<head>


</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
		<div style="padding-top:150px;"></div>
	
	<hr style="margin: 0px;">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="/views/admin/admin_sidebar.jsp"%>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content"></div>
			<!-- End of Main Content -->

			<!-- Begin Page Content -->
			<div class="p-5" style="margin-left: 20%; margin-right: 20%;">
				<div class="text-center">
					<h1 class="h4 text-gray-900 mb-4">예약 상세보기</h1>


				</div>
				<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
				<br>
				<br>
				<form class="user">

					
					&nbsp;&nbsp;&nbsp;<b>예약번호</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="revId" value=<%= hr.getReserveId() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>회원명</b>
					<div class="form-group">
						<input type="email" class="form-control form-control-user"
							id="userName" value=<%= hr.getUserName() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>회원 이메일</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="userEmail" value=<%= hr.getUserEmail()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>회원 전화번호</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="userPhone" value=<%= hr.getUserPhone()%> readonly> 
					</div>
					&nbsp;&nbsp;&nbsp;<b>펫 이름</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="petName" value=<%=hr.getPetName() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>펫 타입</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="petType" value=<%= hr.getPetType()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>매장이름</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="marketName" value=<%= hr.getMarketName()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>매장 전화번호</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="marketPhone" value=<%= hr.getMarketPhone()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>총 금액</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="allPrice" value=<%= hr.getMarketPrice() * hr.getTerm()+"원" %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>예약 시작일</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="SDATE" value=<%= hr.getS_date()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>예약 종료일</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="EDATE" value=<%= hr.getE_date()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>기간</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="term" value=<%= hr.getTerm()+"일"%> readonly>
					</div>
					
					<br>
					<br>

					
					<br> <a href="admin_user_table.jsp"
						class="btn btn-primary btn-user btn-block"
						style="display: inline-block; width: 250px; margin: 25px;  visibility: hidden;"
						onclick='submitBtn1();' > <!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... -->
						완료 <!-- 이걸 submit 버튼으로 바꿔야 할 것 같은데.......--> <script>
							function submitBtn1() {
								alert('수정 완료')
							}
						</script>
					</a> <a href="/PETNER/reserveList.ad"
						class="btn btn-primary btn-user btn-block"
						style="display: inline-block; width: 250px; margin: 25px; background: gray;">
						<!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... --> 확인
					</a> <a href="admin_user_table.jsp"
						class="btn btn-primary btn-user btn-block"
						style="display: inline-block; width: 250px; margin: 25px; background: crimson;  visibility: hidden;"
						onclick="deleteBtn();"> <!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... -->
						삭제 <script>
							function deleteBtn() {
								if (confirm('정말 삭제하시겠습니까?') == true) {
									alert('삭제되었습니다');
								} else {
									return;
								}
							}
						</script>

					</a><br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<!-- <hr>
              <a href="index.html" class="btn btn-google btn-user btn-block">
                <i class="fab fa-google fa-fw"></i> Register with Google
              </a>
              <a href="index.html" class="btn btn-facebook btn-user btn-block">
                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
              </a>
            </form>
            <hr>
            <div class="text-center">
              <a class="small" href="forgot-password.html">Forgot Password?</a>
            </div>
            <div class="text-center">
              <a class="small" href="login.html">Already have an account? Login!</a>
            </div> -->
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>