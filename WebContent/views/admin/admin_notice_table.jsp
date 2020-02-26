<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.notice.model.vo.*, java.util.*"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
		<div style="padding-top:150px;"></div>
	
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
					<h1 class="h3 mb-2 text-gray-800">NOTICE 목록</h1>
					<p class="mb-4">
						<!-- DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>. -->
							
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary"></h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0"> <!-- style="text-align:center;" -->
									<thead>
										<tr>
											<th width="120px">공지번호</th>
											<th width="120px">글쓴이</th>
											<th width="300px">제목</th>
											<th>내용</th>
											<th width="100px">조회수</th>
											<th width="150px">작성일</th>
										</tr>
									</thead>
									<tbody>
										<!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
										<% for(Notice n : list){ %> 
										<tr>
											<td><%= n.getNno() %></td>
											<td><%= n.getNemail() %></td>
											<td><%= n.getNtitle() %></td>
											<td class="btn1" onclick="selectOne();"><u><%= n.getnContent()%></u></td>
											<td><%= n.getnCount() %></td>
											<td><%= n.getNdate() %></td>
											<!-- <td><a href="admin_market_modify.jsp"><button>수정</button></a></td> -->
											<!-- <td><button class="btn1" onclick="selectOne();">수정</button></a></td> -->
						                  </td>
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
	<!-- End of Page Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	<%@ include file="/views/common/footer.jsp"%>
	
		<script>
	        $(function selectOne(){
	           $("#dataTable td").click(function(){
	              //console.log($(this).parent().children().eq(0).text());
	              var Nno = $(this).parent().children().eq(0).text();
	              location.href="<%=request.getContextPath()%>/selectNoticeOne.ad?Nno=" + Nno;
	           });
	        });
	        
	        $("span").on({
				click:function(){
				$(".btn1").click(function(){
			              //console.log($(this).parent().children().eq(0).text());
	              var Qno = $(this).parent().children().eq(0).text();
	              location.href="<%=request.getContextPath()%>/selectQnaOne.ad?Qno=" + Qno;
			           });
				}
			});
			<%-- $(function selectOne(){
				$("#dataTable td").click(function(){
					//console.log($(this).parent().children().eq(0).text());
					var marketId = $(this).parent().children().eq(0).text();
					location.href="<%=request.getContextPath()%>/selectOne.ad?marketId=" + marketId;
				});
			}); --%>
		</script>
	

</body>
</html>