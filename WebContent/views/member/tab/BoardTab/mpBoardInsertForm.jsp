<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)session.getAttribute("member");
%>


<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="/PETNER/resources/js/member/tab/jquery-te-1.4.0.min.js"></script>
<script src="/PETNER/resources/js/vendor/bootstrap.min.js"></script>
<link rel="stylesheet" href="/PETNER/resources/css/member/tab/jquery-te-1.4.0.css">
<link rel="stylesheet" href="/PETNER/resources/css/member/tab/bootstrap.min.css">



<style>
	.img-banner-area{
		background: pink;
		background-repeat: no-repeat;
		background-size: cover;
		width: 100%;
		height: 100%;
	}
</style>

<script>


	 function uploadFile(){
	 	$('#b_file').click();
	 }

	 function LoadImg(value){
		 if(value.files && value.files[0])
		 {
			var reader=new FileReader();
			
			reader.onload=function(e){
				$('.img-banner-area').css('background','white');
				$('#img-banner-area').attr('src',e.target.result).css('display','block');
				$('h1.text-center').hide();
			}
			reader.readAsDataURL(value.files[0]);
		 }//if
	 }


</script>

<body>

		<form action="/PETNER/mpInsert.bo" id="bInsertForm" method="POST" 
			enctype="multipart/form-data">
			  <div style="padding-top:20px;"></div>
			<div class="row" style="background-color: rgba( 200, 200, 200, 0.2);">
			<div class="col-md-6">
				<div class="img-banner-area"> <!-- 요기에 이미지를 넣는다.-->
					<img id="img-banner-area" width="100%" style="display: none">
					<div class="container">
						<a href="#" id="aForInput" style="color: black;" onclick="uploadFile()">
							<h1 class="text-center" style="padding: 100px;">
								이미지를 &nbsp;&nbsp;&nbsp;&nbsp;
								<br> 업로드 
								<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 해주세염
							</h1>
						</a>	
						<input type="file" name="b_file" id="b_file" accept=".gif, .jpg, .png" style="display: none;" onchange="LoadImg(this)"/>
					</div>
				</div>
			</div> <!-- col-md-6 -->

		<div class="col-md-6">
			<div class="form-group">
			 <div class="row">
			 	<div class="col-md-3">
				 	<label class="form-control">작성자</label>
				 	<label class="form-control">카테고리</label>
			 	</div>
			 	<div class="col-md-8">
				 	<input type="text" name="userName" value="<%=m.getUserName() %>" readonly class="form-control" style="margin-bottom:8px">
				 	<input type="hidden" name="userEmail" value="<%= m.getUserEmail()%>">
					<select name="Type" id="" required class="form-control">
						<option value="" selected>공유 설정</option>
						<option value="1">전체 공유</option>
						<option value="2">나만 공유</option>
					</select>
			 	</div>
			 	
			 </div>
				
				
				
			</div>	<!-- form-group -->
		
			<div class="form-group">
				<input type="text" name="bTitle" class="form-control" placeholder="제목을 입력해주세요" required>
				<div class='textArea' name="jqteArea"></div> <!-- jquery text editor -->
			</div>
			
			<div class="form-group text-center">
				<button class="btn btn-primary" type="submit">글쓰기</button>
			</div>
		</div> <!-- col-md-6 -->
		</div> <!-- row -->
	</form>
	
	
	
</body>

<Script>
	
		$(".textArea").jqte({indent: false,
		link: false, linktypes: ["Web URL", "E-mail", "Picture"],
		source: false,sub: false, remove: false});
		
		$('.jqte_editor').css("cssText","height: 300px; resize: none;");
		
</Script>

