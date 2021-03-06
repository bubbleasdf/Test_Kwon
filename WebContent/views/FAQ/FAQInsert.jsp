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
	<title>Petner+</title>
	<title>FAQ Insert</title>
	
	
	<style>
	textarea{
		height: 200px;
		width: 530px;
	}
	
	</style>
	
	</head>
	<body>
			<%@ include file="../common/header.jsp" %> 
			
			
	<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
			
		<% if(m != null) { if(m.getUserRoles()==777){ %>
			
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
						<h1 class="h4 text-gray-900 mb-4">QNA 작성</h1> 
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  <form class="user" id="joinForm" action="<%= request.getContextPath() %>/fInsert.go" method="post">
						<div class="form-group row">
						</div>
						<div class="form-group">제목 :
						  <input type="text" class="form-control form-control-user" name="ftitle">
						</div>
						<div class="form-group">
							<select class="form-control" id="searchCondition" name="searchCondition">
							<option value="1">호텔관련</option>
							<option value="2">병원관련</option>
							<option value="3">미용관련</option>
							<option value="4">회원관련</option>
							</select>
						</div>		
						<div class="form-group">
						<textarea class="form-control" id="summernote" name ="fcontent"></textarea>
						</div>								
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<button type="reset" class="form-control btn-danger">취소하기</button>
							</div>
							<div class="col-sm-6">
								<button type="submit" class="form-control btn-danger">등록하기</button>
							</div>
						</div>
						</form>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		</div>
		
		<% } }else {
		request.setAttribute("msg", "관리자만 사용가능한 메뉴 입니다.");
		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	} %>
	
	<script>
      $('#summernote').summernote({
    	
        tabsize: 5,
        height: 300,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
      
      $('#summernote').summernote('code');
      
    </script>
	
		
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>