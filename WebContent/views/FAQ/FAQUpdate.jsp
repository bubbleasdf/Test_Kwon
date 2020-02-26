
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.petner.FAQ.model.vo.FAQ" %>

<%
		FAQ f = (FAQ)request.getAttribute("FAQ");
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
	<title>FAQ Update</title>
	
	
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
				
			<!--  메뉴바랑 겹치는 부분 제거 -->
 <% if(m != null && m.getUserRoles() == 777){ %>
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
						<h1 class="h4 text-gray-900 mb-4">FAQ 수정</h1> 
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  
					   <form class="user" id="joinForm" action="<%=request.getContextPath() %>/fUp.go" method="post">
						<div class="form-group row">
						</div>
						
						<div class="form-group">제목 :<span><input type="hidden" name="fno" value="<%=f.getFno() %>"></span>
						  <textarea class="form-control form-control-user" id="readwhite" name ="ftitle" style ="resize :none;" ><%=f.getTitle()%></textarea>
						</div>
						<div class="form-group"> 내용:
						<textarea class="form-control" id="summernote" name ="fcontent"></textarea>
						</div>				
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<button type="submit" class="form-control btn-danger">작성완료</button>
							</div>
							
							<div class="col-sm-6">
								<button onclick="deleteFAQ();" class="form-control btn-danger">삭제하기</button>
							</div>
						</div>
						<script>
						function deleteFAQ(){
							$('#joinForm').attr("action","<%=request.getContextPath() %>/fDel.go")
						}
						</script>
						</form>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		</div>
		<% } else {
		request.setAttribute("msg", "댓글 작성자 외에 접근이 불가능한 페이지입니다.");
		request.getRequestDispatcher("view/common/errorPage.jsp").forward(request, response);
	 } %>
	 
	 <script>
				
				
				console.log(markupStr);
		 		$('#summernote').summernote({
		
		
        tabsize: 5,
        height: 300,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['view', ['fullscreen', 'codeview', 'help']],
        ]
      });
	$('#summernote').summernote('code');	 		
	
	var markupStr = '<%=f.getContent()%>';
	$('#summernote').summernote("code",markupStr) ;
	
       
    </script>
		
		
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>