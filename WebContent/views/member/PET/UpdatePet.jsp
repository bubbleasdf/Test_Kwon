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
	
	<%
		
		Pet p = (Pet)request.getAttribute("p");
	
	%>
	
	
	
	<script>
	
	$(function(){
		
		var pType= '<%=p.getPetType()%>';
		var pWeight= '<%=p.getPetWeight() %>';
		
		$('[name=petType]').each(function(index,item){
			if($(item).val() == pType){
				$(this).attr('checked',true);
			}//if
		});

		//select부분 petWeight
		$('select[name=petWeight]>option').each(function(index,item){
			
			if($(item).val() == pWeight){
				$(this).parent().prop('selectedIndex', $(this).prop('index'));
			}//if
		});
		
	});


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
					<div class="p-4">
					  <div class="text-center">
						<h1 class="h4 text-gray-900 mb-4"> <%= p.getPetName() %> 의 상세사항</h1>
					  </div>
				
					  <form class="user" id="updateForm" 
					  			action="/PETNER/pUpdate.pe" method="POST" 
					  			enctype="multipart/form-data">
						
						<div class="form-group row">
						
							<input type="hidden" name="userEmail" value="<%=m.getUserEmail()%>">
							
							<div class="col-sm-6 mb-3 mb-sm-0" >
								<div id="asle" style="height:248px; width:248px; border:2px solid balck">

									<img class="card-top-img " height="248px" width="248px" alt="프로필사진" style="border:1px sold black"
										id="profilePic" src="resources/img/member/pet/<%=p.getPetPic() %>">		
									
									<br>
									<input type="hidden" name="petPic" value="<%=p.getPetPic() %>"/>
									<input type="file" name="npetPic" id="npetPic"   accept=".gif, .jpg, .png" onchange="LoadImg(this);" value="<%=p.getPetPic() %>"/>
									
									
								</div>
							</div>
							
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" name="petName"  required value="<%=p.getPetName() %>" readOnly/>
								<br>
								<input type="date" class="form-control form-control-user" name="petBirth" required value="<%=p.getPetBirth()%>"/> 
								<br>		
								<input type="text" class="form-control form-control-user" name="petProfile" required value="<%=p.getPetProfile()%>">
								
								<br>
								
								<div>
									<input type="radio" name="petType" value='b'>대형 &nbsp;
									<input type="radio" name="petType" value='m'>중형 &nbsp;
									<input type="radio" name="petType" value='s'>소형 &nbsp;
								</div>
								<br>
								
								<div>
									<select name="petWeight">
										<option value="21" >20kg 이상</option>
										<option value="20">15kg ~ 20kg</option>
										<option value="15" >10kg ~ 15kg</option>
										<option value="10"  selected>5kg ~ 10kg</option>
										<option value="5" >5kg 이하</option>
									</select>
								</div>
							</div>
						</div>
						
						
						<br>

							<div class="row">
								<div class="col-sm-6">
									<a href="#" onclick="Pjoin();" style="background:#008000; width: 250px;"
									class="btn btn-primary btn-user btn-block">
										수정
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
				$('#updateForm').submit();
			}

			function Preset(){
				$('#updateForm').click(function(){
					window.history.back();
				});
			}
			
		</script>
			
			
			
			
			
			
			
			
			
			<%@ include file="../../common/footer.jsp" %>
	</body>
</html>