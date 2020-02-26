<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kh.petner.member.model.vo.Member, java.util.*"%>
<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
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
					<h1 class="h3 mb-2 text-gray-800">유저 목록</h1>
					<p class="mb-4">
						DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>.
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">DataTables
								Example</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th width="300px">유저이메일</th>
											<th width="200px">닉네임</th>
											<th width="200px">전화번호</th>
											<th width="200px">회원등급</th>
											<th width="150px">가입일</th>
											<th width="100px">DETAIL</th>
										</tr>
									</thead>
									<tbody>
										<!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
										<%
											for (Member member : list) {
										%>
										<tr>
											<td><%=member.getUserEmail()%></td>
											<td><%=member.getUserName()%></td>
											<td><%=member.getUserPhone()%></td>
											<td><%=member.getUserRolesName()%></td>
											<td><%=member.getEnDate()%></td>
											<!-- <td><a href="admin_market_modify.jsp"><button>수정</button></a></td> -->
											<td style="padding: 7px; text-align: center;"><a
												href="#" onclick="selectOne();"
												class="btn1 btn btn-secondary btn-icon-split"
												style="font-size: 14px; padding: 0.1px;!important;"> <span
													class="text">세부사항</span>
											</a></td>
										</tr>
										<%
											}
										%>


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
			
			$("span").on({
				click:function(){
					$(".btn1").click(function(){
			              //console.log($(this).parent().children().eq(0).text());
			              var userEmail = $(this).parent().parent().children().eq(0).text();
							location.href="<%=request.getContextPath()%>/selectUserOne.ad?userEmail="+ userEmail;
												});
							}
						});
	</script>

</body>
</html>