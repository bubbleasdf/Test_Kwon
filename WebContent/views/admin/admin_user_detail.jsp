<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.member.model.vo.*"%>
	
<%
	MemberDetail md = (MemberDetail)request.getAttribute("MemberDetail");
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
					<h1 class="h4 text-gray-900 mb-4">회원 정보 수정</h1>


				</div>
				<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
				<br>
				<br>
				<form class="user">

					
					&nbsp;&nbsp;&nbsp;<b>회원이름</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="userName" value=<%= md.getUserName() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>이메일</b>
					<div class="form-group">
						<input type="email" class="form-control form-control-user"
							id="userEmail" value=<%= md.getUserEmail() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>전화번호</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="userPhone" value=<%= md.getUserPhone()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>회원등급</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="userRoles" value=<%= md.getUserRoleName()%> readonly> 
					</div>
					&nbsp;&nbsp;&nbsp;<b>펫 이름</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="petName" value=<%=md.getPetName() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>펫 프로필</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="petProfile" value=<%=md.getPetProfile() %> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>펫 타입</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="petType" value=<%= md.getPetType()%> readonly>
					</div>
					&nbsp;&nbsp;&nbsp;<b>가입일</b>
					<div class="form-group">
						<input type="text" class="form-control form-control-user"
							id="enDate" value=<%= md.getEnDate()%> readonly>
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
					</a> <a href="/PETNER/userList.ad"
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