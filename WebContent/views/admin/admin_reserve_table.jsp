<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.HotelReserve, java.util.*"%>
<%
	ArrayList<HotelReserve> list = (ArrayList<HotelReserve>)request.getAttribute("list");
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
					<h1 class="h3 mb-2 text-gray-800">예약 목록</h1>
					<p class="mb-4">
						<!-- DataTables is a third party plugin that is used to generate the
						demo table below. For more information about DataTables, please
						visit the <a target="_blank" href="https://datatables.net">official
							DataTables documentation</a>. -->
							예약 목록을 보여드립니다.
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
											<th width="120px">예약번호</th>
											<th width="200px">고객명</th>
											<th width="200px">고객전화번호</th>
											<th width="200px">매장명</th>
											<th width="200px">매장전화번호</th>
											<th width="100px">시작일</th>
											<th width="100px">종료일</th>
											<th width="100px">총 금액</th>
											<th width="100px">상세보기</th>
										</tr>
									</thead>
									<tbody>
										<!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
										<% for(HotelReserve hr : list){ %> 
										<tr>
											<td><%= hr.getReserveId() %></td>
											<td><%= hr.getUserName() %></td>
											<td><%= hr.getUserPhone() %></td>
											<td><%= hr.getMarketName() %></td>
											<td><%= hr.getMarketPhone() %></td>
											<td><%= hr.getS_date() %></td>
											<td><%= hr.getE_date() %></td>
											<td><%= hr.getMarketPrice() * hr.getTerm() %> 원</td>
											<<td style="padding:7px; text-align:center;"> 
												<div  class="btn1 btn btn-secondary btn-icon-split"
												style="font-size: 14px; padding:0.1px;!important;">
								                    <span class="text">상세보기</span>
						                  		</div>
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
	        
	        $("span").on({
				click:function(){
					$(".btn1").click(function(){
			              //console.log($(this).parent().children().eq(0).text());
	              var ReserveId = $(this).parent().parent().children().eq(0).text();
	              location.href="<%=request.getContextPath()%>/selectRsvOne.ad?ReserveId=" + ReserveId;
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