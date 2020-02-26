<%-- 회원 정보가 출력되는 탭 입니다.  --%>

<%@page import="com.kh.petner.market.model.vo.HotelReserve"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.petner.member.pet.model.vo.Pet"%>
<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.HotelReserve, java.util.*"%>
<%

	System.out.println("tab2jsp임당!!!!!!!!!!!!!!!!!!!!!!!!");
		ArrayList<HotelReserve> list = (ArrayList<HotelReserve>)session.getAttribute("rList");
   	 	Member mp = (Member)session.getAttribute("member"); 
		
%>
    <script>
    	$(function(){	//사라지게 하기
    		console.log("tab2임당!!!!!!!!!!!!!");
    		$('div.tab_content').fadeIn();
    	});
    </script>
      <style type="text/css"> /* 게시판에서 텍스트가 길어질 경우 ... 으로 줄어들게 해준다 */
	td{
		text-overflow:ellipsis; overflow:hidden; white-space:nowrap;
		max-width:50px;
	}
</style>
  <!-- Custom fonts for this template -->
  <link href="/PETNER/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <!-- <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet"> -->

  <!-- Custom styles for this template admin페이지 CSS-->
  <link href="/PETNER/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page 테이블 CSS --> 
  <link href="/PETNER/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

  <!-- Core plugin JavaScript-->
  <script src="/PETNER/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/PETNER/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="/PETNER/resources/vendor/datatables/jquery.dataTables.js"></script>
  <script src="/PETNER/resources/vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Page level custom scripts -->
  <script src="/PETNER/resources/js/demo/datatables-demo.js"></script>
    
 			<div id="tab2" class="tab_content"><br>
				
				<!-- Content Wrapper -->
	





		<!-- Content Wrapper -->
		<!-- <div id="content-wrapper" class="d-flex flex-column">  -->

			<!-- Main Content -->
			<div id="content">

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<br>
					<h1 class="h3 mb-2 text-gray-800">예약 목록</h1>
					<p class="mb-4">
							예약 목록을 보여드립니다.
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
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
										<!-- 	<th width="100px">상세보기</th>  -->
										</tr>
									</thead>
									<tbody>
										<!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
										<%if( list != null){ %>
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
											
											<!--  <td style="padding:7px; text-align:center;"> 
												<div  class="btn1 btn btn-secondary btn-icon-split"
												style="font-size: 14px; padding:0.1px;!important;">
								                    <span class="text">상세보기 불가</span>
						                  		</div>
						                  </td>
						                   -->
										</tr>
										<% } %>
										<%} %>
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
