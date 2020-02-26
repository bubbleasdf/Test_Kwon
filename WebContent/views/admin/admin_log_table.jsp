<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.petner.market.model.vo.*, java.util.*"%>
<%
	ArrayList<AuditLog> list = (ArrayList<AuditLog>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
  <style type="text/css"> /* 게시판에서 텍스트가 길어질 경우 ... 으로 줄어들게 해준다 */
	td{
		text-overflow:ellipsis; overflow:hidden; white-space:nowrap;
		max-width:50px;
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

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<br>
					<h1 class="h3 mb-2 text-gray-800">SQL 로그 목록</h1>
					<p class="mb-4">
						
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary"></h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th width="100px">No.</th>
											<th width="200px">Log Date</th>
											<th width="200px">Method Name</th>
											<th>SQL문</th>
											<th width="150px">Do</th>
										</tr>
									</thead>
									<tbody>
										<!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
										<% for(AuditLog alog : list){ %> 
										<tr>
											<td><%= alog.getLogNo() %></td>
											<td><%= alog.getLogDate() %></td>
											<td><%= alog.getMethodName() %></td>
											<td><%= alog.getLogSql() %></td>
											<td><%= alog.getDoit() %></td>
											
										</tr>
										<% } %>
										

									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->
	</div>
	</div>
	<!-- End of Page Wrapper -->
	<%@ include file="/views/common/footer.jsp"%>

	<script>
			$(function selectOne(){
				
				$("#dataTable td").click(function(){
					//console.log($(this).parent().children().eq(0).text());
					var userEmail = $(this).parent().children().eq(0).text();
					location.href="<%=request.getContextPath()%>/selectUserOne.ad?userEmail="+ userEmail;
							});
		});
	</script>

</body>
</html>