
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.petner.notice.model.vo.Notice" %>

<%
	Notice n = (Notice)request.getAttribute("notice");
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
	<title>Notice Insert</title>
	
	
	<style>
	textarea{
		height: 200px;
		width: 530px;
		
	}
	#readwhite{
	background: white;
	}	
	
	</style>
	
	</head>
	<body>
			<%@ include file="../common/header.jsp" %> 
			
			
					
	<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
				
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
						<h1 class="h4 text-gray-900 mb-4">공지사항 내용</h1> 
					  </div>
					  <!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
					  
					   
						<div class="form-group row">
						</div>
						<div class="form-group">제목 :
						  <input type="text" class="form-control form-control-user" id="readwhite" value = <%=n.getNtitle()%> readonly>
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0"> E-mail :
								<input type="text" value = <%=n.getNemail()%> class="form-control form-control-user" id="readwhite" readonly>
							</div>
							<div class="col-sm-6"> 등록일 : 
								<input type="text" value=<%=n.getNdate()%> class="form-control form-control-user" id="readwhite" readonly>
							</div>
						</div>
						<div class="form-group"> 내용:
						<textarea class="form-control" id="summernote"></textarea>
						

						</div>								
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<button onclick="location.href='NoticeList.go'" class="form-control btn-danger" name="nemail" >공지사항</button>
							</div>
							<% if( m != null && m.getUserRoles()==777) { %>
							<div class="col-sm-6">
								<button onclick="location.href='nUpnno.go?nno=<%=n.getNno()%>'" class="form-control btn-danger">수정하기</button>
							</div>
							<% } %>
						</div>
					</div>
				  </div>
				</div>
			  </div>
			</div>
		</div>
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
	var markupStr = '<%=n.getnContent()%>';
	$('#summernote').summernote("code",markupStr) ;
	$('#summernote').summernote('disable');
		 		
       
    </script>
		
		
			<%@ include file="../common/footer.jsp" %>
	</body>
</html>