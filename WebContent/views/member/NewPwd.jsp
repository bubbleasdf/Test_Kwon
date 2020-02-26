<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 Member m_pwd = (Member)request.getAttribute("m_pwd");
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
						<h1 class="h4 text-gray-900 mb-4">비밀 번호 변경</h1>
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  <form class="user" id="joinForm" action="/PETNER/pwdnewenter.do" method="post">
						<div class="form-group row">
						</div>
						<div class="form-group">
						아이디 : <input type="email" class="form-control form-control-user" name="userEmail" id="SearchEmail" 
						  			placeholder="" required readonly="readonly" value=<%=m_pwd.getUserEmail()%>></input>
						</div>
						<div class="form-group">
						인증코드 : <input type="text" class="form-control form-control-user" name="AuthenticationUser" id="AuthenticationUser" 
						  			placeholder=""></input>
						</div>
						<div class="form-group">
						비밀번호 :	<input type="password" class="form-control form-control-user" name="NewuserPwd" 
									placeholder="비밀번호 입력">
						</div>
						<div class="form-group">
						비밀번호 확인 :	<input type="password" class="form-control form-control-user" name="NewuserPwdConfirm" 
									placeholder="비밀번호 확인">
						</div>
						<a href="#" onclick="PwdSearch();" class="btn btn-primary btn-user btn-block" style="background:#008000">
							비밀번호 변경
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
				
<%-- 				<%String code = session.getAttribute("AuthenticationKey").toString();%>
				location.href="<%=request.getContextPath()%>/pwdsearch?userEmail="+$('#SearchEmail').val();
				location.href="<%=request.getContextPath()%>/pwdsearch?userPwdHint="+$('#SearchPwdHint').val();
				if(document.getElementById("AuthenticationUser") != '<%=code%>'){
					alert('너틀림');
				}
				else{
				$('#joinForm').submit();
				} --%>
				$('#joinForm').submit();
			}
		</script>
			
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>