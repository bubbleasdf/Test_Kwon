<%@page import="com.kh.petner.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%


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
		<title>회원 가입</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>
	<body>
			<%@ include file="../common/header.jsp" %> 
			
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
						<h1 class="h4 text-gray-900 mb-4">비밀번호 찾기</h1>
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  <form class="user" id="joinForm" action="/PETNER/pwdsearch" method="post">
						<div class="form-group row">
						</div>
						<div class="form-group">
						  <input type="email" class="form-control form-control-user" name="userEmail" id="SearchEmail" 
						  		 placeholder="이메일을 입력하세요.*" required>
						</div>
						<div class="form-group">
<!-- 							<input type="text" class="form-control form-control-user" name="userPwdHintSelect" id="userPwdHintSelect" 
								   placeholder="비밀번호 힌트 선택.*" required> -->
					 <select class="form-control" id="searchCondition" name="userPwdHintSelect">
								<option>비밀번호 힌트를 선택하세요</option>
                     			<option value="1">첫 해외여행 나라</option>
                     			<option value="2">졸업한 초등학교 이름</option>
                     			<option value="3">졸업 중학교</option>
                     			<option value="4">졸업 고등학교</option>
                     </select>	   
						</div>
						<div class="form-group">
						<input type="text" class="form-control form-control-user" name="userPwdHint" id="SearchPwdHint" 
						       placeholder="힌트 정답 입력*" required>
	
						</div>		
						<a href="#" onclick="PwdSearch();" class="btn btn-primary btn-user btn-block" style="background:#008000">
							찾아보기
						  </a>
	
					  </form>
					  <hr>
	
					  <div class="text-center">
						<a class="small" href="#" data-target="#modal-login" data-toggle="modal">이미 계정이 있으신가요? 로그인!</a>
					  </div>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		</div>
			

		<script>    
			function PwdSearch(){
				<%-- location.href="<%=request.getContextPath()%>/pwdsearch?userEmail="+$('#SearchEmail').val();
				location.href="<%=request.getContextPath()%>/pwdsearch?userPwdHint="+$('#SearchPwdHint').val(); --%>
				$('#joinForm').submit()
			
			}
		</script>
			
			
			
			
			
			
			
			
			
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>