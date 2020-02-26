
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.petner.notice.model.vo.*, java.util.*"%>

<%
	Qna q = (Qna)request.getAttribute("qna");
	System.out.println(q);
%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css"> /* 게시판에서 텍스트가 길어질 경우 ... 으로 줄어들게 해준다 */
td {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	max-width: 50px;
}
.note-toolbar{
	display:none;
}
.note-resizebar {
	display:none;
}
</style>


</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<div style="padding-top: 150px;"></div>

	<hr style="margin: 0px;">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<%@ include file="/views/admin/admin_sidebar.jsp"%>

		<link
			href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css"
			rel="stylesheet">
		<script
			src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>


		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<div class="container">
					<div class="card o-hidden border-0 shadow-lg my-5">
						<div class="card-body p-0">
							<!-- Nested Row within Card Body -->
							<div class="row">
								<div class="col-lg-7" style="margin: auto; max-width: 700px;">
									<div class="p-5">
										<div class="text-center">
											<h1 class="h4 text-gray-900 mb-4">QNA 내용</h1>
										</div>
										<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->


										<div class="form-group row"></div>
										<div class="form-group">
											제목 : <input type="text"
												class="form-control form-control-user" id="readwhite"
												value=<%=q.getQtitle()%> readonly>
										</div>
										<div class="form-group row">
											<div class="col-sm-6 mb-3 mb-sm-0">
												E-mail : <input type="text" value=<%=q.getQemail()%>
													class="form-control form-control-user" id="readwhite"
													readonly>
											</div>
											<div class="col-sm-6">
												등록일 : <input type="text" value=<%=q.getNdate()%>
													class="form-control form-control-user" id="readwhite"
													readonly>
											</div>
										</div>
										<div class="form-group">
											내용:
											<textarea class="form-control" id="summernote"></textarea>

										</div>
										<%-- <div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<button onclick="location.href='NoticeList.go'" class="form-control btn-danger" name="nemail" >공지사항</button>
							</div>
							<% if( m != null && m.getUserRoles()==777) { %>
							<div class="col-sm-6">
								<button onclick="location.href='nUpnno.go?nno=<%=n.getNno()%>'" class="form-control btn-danger">수정하기</button>
							</div>
							<% } %>
						</div> --%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	<%@ include file="/views/common/footer.jsp"%>

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
		var markupStr = '<%=q.getQcontent()%>';
		$('#summernote').summernote("code", markupStr);
		$('#summernote').summernote('disable');
	</script>


</body>
</html>