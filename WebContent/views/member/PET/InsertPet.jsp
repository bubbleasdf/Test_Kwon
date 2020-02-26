<%@page import="com.kh.petner.member.pet.model.vo.Pet"%>
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
		<title>PET 등록</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	</head>
	<body>
			<%@ include file="../../common/header.jsp" %> 
			
			<!--  메뉴바랑 겹치는 부분 제거 -->
	<div style="padding-top:150px;">
	
	<script>
	function LoadImg(value) 
	{
		if(value.files && value.files[0]) 
		{
			var reader = new FileReader();

			reader.onload = function (e) {
				$('#profilePic').attr('src', e.target.result);
			}
		
			reader.readAsDataURL(value.files[0]);
		}
	}
	</script>
	
	</div>
		<div class="container">
			<div class="card o-hidden border-0 shadow-lg my-5">
			  <div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
				  <div class="col-lg-7" style="margin: auto;">
					<div class="p-5">
					  <div class="text-center">
						<h1 class="h4 text-gray-900 mb-4"> <%=m.getUserName() %> 의 가족을 등록해주세염 </h1>
					  </div>
				
					  <form class="user" id="joinForm" 
					  			action="/PETNER/PInsert.pe" method="POST" 
					  			enctype="multipart/form-data">
						
						<div class="form-group row">
						
							<input type="hidden" name="userEmail" value="<%=m.getUserEmail()%>">
							
							<div class="col-sm-6 mb-3 mb-sm-0" > <!-- 이름 -->
								<div id="asle" style="height:248px; width:248px; border:2px solid balck">

									<img class="card-top-img " height="248px" width="208px" alt="프로필사진" style="border:1px sold black"
										id="profilePic" src="../../../resources/img/member/pet/default.jpg">		
									
									<br>
									<input type="file" name="petPic" id="petPic" accept=".gif, .jpg, .png" onchange="LoadImg(this);"/>
									
								</div>
							</div>
							
							<div class="col-sm-6">
							<input type="text" class="form-control form-control-user" name="petName" placeholder="이름을 입력해주세요.*" required><br>
								<input type="date" class="form-control form-control-user" name="petBirth" placeholder="생일을 입력해주세요" required> <br>		
								<input type="text" class="form-control form-control-user" name="petProfile" placeholder="종 혹은 간단한 소개.*" required>
								
								<br>
								
								<div>
									<input type="radio" name="petType" value='b' checked="checked">대형 &nbsp;
									<input type="radio" name="petType" value='m'>중형 &nbsp;
									<input type="radio" name="petType" value='s'>소형 &nbsp;
								</div>
								<br>
								<div>
									<select name="petWeight">
										<option value="21">20kg 이상</option>
										<option value="20">15kg ~ 20kg</option>
										<option value="15">10kg ~ 15kg</option>
										<option value="10" selected>5kg ~ 10kg</option>
										<option value="5">5kg 이하</option>
									</select>
								</div>
							</div>
						</div>
						
						
						<br>
						
						<div class="row">
							<div class="col-sm-6">
								<a href="#" onclick="Pjoin();" style="background:#008000; width: 250px;"
								class="btn btn-primary btn-user btn-block">
									가족 등록
								</a>
							</div>
							<div class="col-sm-6">
								<a href="#" onclick="Preset();" style="background:#008000; width: 250px; "
								class="btn btn-primary btn-user btn-block">
									취소
								</a>
							</div>
						</div>
					  </form>
					  <hr>
	
					</div>
				  </div>
				</div>
			  </div>
			</div>
		</div>
			

		<script>
			function Pjoin(){
				$('#joinForm').submit();
			}

			function Preset(){
				$('#joinForm').reset();
			}
		</script>
			
			
			
			
			
			
			
			
			
			<%@ include file="../../common/footer.jsp" %>
	</body>
</html>