<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
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
						<h1 class="h4 text-gray-900 mb-4">REGISTER</h1>
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  <form class="user" id="joinForm" action="/PETNER/PmInsert.me" method="post">
						<div class="form-group row">
						</div>
						<div class="form-group">
						  <input type="email" class="form-control form-control-user" id="userEmail" name="userEmail" placeholder="이메일을 입력하세요.*" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control form-control-user" id="userPwd" name="userPwd" placeholder="비밀번호를 입력하세요.*" required>
						</div>
						<div class="form-group">
						<input type="password" class="form-control form-control-user" id="userPwd2" name="userPwd2" placeholder="비밀번호를 다시 한 번 입력해주세요.*" required>
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
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0" >
								<input type="text" class="form-control form-control-user" id="userName" name="userName" placeholder="이름은 한글로 2글자 이상*" required>
							</div>
							<div class="col-sm-6 mb-3 mb-sm-0" style="padding-top:3px">
								<label>연락처</label>
								<input type="text" name="tel1" id="tel1" maxlength="3" style="width:20%"> - 
								<input type="text" name="tel2" id="tel2" maxlength="4" style="width:25%"> - 
					            <input type="text" name="tel3" id="tel3" maxlength="4" style="width:25%">
							</div>
						</div>
		
						<a href="#" onclick="Pjoin();" class="btn btn-primary btn-user btn-block" style="background:#008000">
							Join
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
			function Pjoin(){

				//유효성 검사 변수들
				var email=$('#userEmail');
				var pass=$('#userPwd');
				var pass2 =$('#userPwd2');
				var name = $('#userName');
				var tel1 = $('#tel1');
				var tel2 = $('#tel2');
				var tel3 = $('#tel3');


				//Email.검사
				if((email.val()==null && (email.val()).equals(""))){
					alert("이메일을 입력해주세요");
					return false;
				}


                //비밍번호 확인
                //비밀번호와 비밀번호 확인값이 일치
                if((pass.val())!=(pass2.val())){
                    alert ('비밀번호 확인');
                    return false;
                }

                //이름 검사
                //2글자 이상, 한글
                if(!chk(/^[가-힣]{2,}$/,name,"이름은 한글로 2글자 이상")){
                    alert('이름 확인');
                    return false
                }

                //전번 검사
                //전번 앞자리는 2~3자리 숫자
                //두번째 자리는 3~4자리숫자
                //세번째 자리는 4자리 숫자
                if(!chk(/^0(2|1[01679])/,tel1,"전번 앞자리 오류")){
                    return false;
                }
                if(!chk(/^[0-9]{3,4}$/,tel2,"전번 중간 오류")){
                    return false;
                }if(!chk(/^[0-9]{4}$/,tel3,"전번 마지막 오류")){
                    return false;
                }


				//유효성 검사 종료 후 submit
				$('#joinForm').submit();
			}

			function chk(re, ele, msg){
                if(!re.test(ele.val())){
                    alert(msg);
                    ele.select();

                    return false;
                }
                    return true;
            }//chk
		</script>

			
			
			
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>