<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, com.kh.petner.market.model.vo.*"%>
<%
	AdminMain am = (AdminMain) request.getAttribute("am");
	int hotelCnt = am.getHotel();
	int beautyCnt = am.getBeauty();
	int hospitalCnt = am.getHospital();
	int totalCnt = am.getTotalCnt();
	int todayCnt = am.getTodayCnt();
	int oneAgo = am.getOneAgo();
	int twoAgo = am.getTwoAgo();
	int threeAgo = am.getThreeAgo();
	int fourAgo = am.getFourAgo();
	int fiveAgo = am.getFiveAgo();
	int sixAgo = am.getSixAgo();
	// Ajax를 써야 되긴 하는데..... 바꾸기 귀찮닼ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
%>



<!DOCTYPE html>
<html>
<head>


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
			<!-- <div id="content"> -->
			<div id="content" style="background-color: ;">
			<!-- <div id="content" style="background-image: linear-gradient(180deg,crimson 1%,#f0ff0f 100%); !important;"> -->

				<!-- Content Row -->
				<div class="row" style="margin: 50px">
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<a href="/PETNER/marketList.ad" style="text-decoration: none; cursor: default;">
							<div class="card border-left-primary shadow h-100 py-2"
								style="border-color: red !important">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												총 매장 수</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=am.getSumMarket()%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<!-- <a href=selectHotel(); style="text-decoration: none; cursor: default;"> -->
						<div class="card border-left-success shadow h-100 py-2" onclick="selectHotel();">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-success text-uppercase mb-1">등록된
											호텔 개수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=hotelCnt%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
						<!-- </a> -->
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<div class="card border-left-info shadow h-100 py-2" onclick="selectBeauty();">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-info text-uppercase mb-1">등록된
											미용 개수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=beautyCnt%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<div class="card border-left-warning shadow h-100 py-2" onclick="selectHospital();">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-warning text-uppercase mb-1">등록된
											병원 개수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=hospitalCnt%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<a href="/PETNER/userList.ad" style="text-decoration: none; cursor: default;">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-warning text-uppercase mb-1">등록된
												고객 수</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"><%=am.getSumMember()%></div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<div class="card border-left-warning shadow h-100 py-2">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-warning text-uppercase mb-1">
											누적 접속자 수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=am.getTotalCnt()%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
					<a href="/PETNER/reserveList.ad" style="text-decoration: none; cursor: default;">
						<div class="card border-left-warning shadow h-100 py-2">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-warning text-uppercase mb-1">
											예약 건 수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=am.getRsvCnt()%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
						</a>
					</div>
					<!-- Earnings (Monthly) Card Example -->
					<div class="col-xl-3 col-md-6 mb-4" style="max-width: 350px">
						<a href="/PETNER/petList.ad" style="text-decoration: none; cursor: default;"><div class="card border-left-warning shadow h-100 py-2">
							<div class="card-body">
								<div class="row no-gutters align-items-center">
									<div class="col mr-2">
										<div
											class="text-xs font-weight-bold text-warning text-uppercase mb-1">
											펫 등록 수</div>
										<div class="h5 mb-0 font-weight-bold text-gray-800"><%=am.getPetCnt()%></div>
									</div>
									<div class="col-auto">
										<i class="fas fa-calendar fa-2x text-gray-300"></i>
									</div>
								</div>
							</div>
						</div>
						</a>
					</div>



					<!-- Content Row -->
				</div>
				<!-- End of Main Content -->
				<div class="row" style="margin: 50px">
					<div class="col-xl-8 col-lg-7" style="max-width: 900px;">

						<!-- Area Chart -->
						<div class="card shadow mb-4">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">접속자 수 현황</h6>
							</div>
							<div class="card-body">
								<div class="chart-area">
									<canvas id="myAreaChart"></canvas>
								</div>
								<hr>
								최근 일주일 간 접속자 수 현황입니다
							</div>
						</div>
					</div>


					<!-- Donut Chart -->
					<div class="col-xl-4 col-lg-5">
						<div class="card shadow mb-4">
							<!-- Card Header - Dropdown -->
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">매장 분포 현황</h6>
							</div>
							<!-- Card Body -->
							<div class="card-body">
								<div class="chart-pie pt-4">
									<canvas id="myPieChart"></canvas>
								</div>
								<hr>
								<div style="text-align: center;">
									<label class=text-success>호텔 : <%=hotelCnt%></label> / <label
										class=text-info>미용 : <%=beautyCnt%></label> / <label
										class=text-warning>병원 : <%=hospitalCnt%></label>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End of Content Wrapper -->
			</div>

		</div>

		<script>
			function selectHotel() {
				location.href="<%=request.getContextPath()%>/selectType.ad?marketType=HOTEL";
			}
			function selectBeauty() {
				location.href="<%=request.getContextPath()%>/selectType.ad?marketType=BEAUTY";
			}
			function selectHospital() {
				location.href="<%=request.getContextPath()%>/selectType.ad?marketType=HOSPITAL";
			}
		</script>

		<input type="hidden" id="hotelCnt" value=<%=hotelCnt%>></input> 
		<input type="hidden" id="beautyCnt" value=<%=beautyCnt%>></input> 
		<input type="hidden" id="hosiptalCnt" value=<%=hospitalCnt%>></input> 
		<input type="hidden" id="totalCnt" value=<%=totalCnt%>></input> 
		<input type="hidden" id="todayCnt" value=<%=todayCnt%>></input> 
		<input type="hidden" id="oneAgo" value=<%=oneAgo%>></input> 
		<input type="hidden" id="twoAgo" value=<%=twoAgo%>></input> 
		<input type="hidden" id="threeAgo" value=<%=threeAgo%>></input> 
		<input type="hidden" id="fourAgo" value=<%=fourAgo%>></input> 
		<input type="hidden" id="fiveAgo" value=<%=fiveAgo%>></input> 
		<input type="hidden" id="sixAgo" value=<%=sixAgo%>></input>

		<!-- End of Page Wrapper -->
	</div>
	<%@ include file="/views/common/footer.jsp"%>

	<script src="/PETNER/resources/vendor/chart.js/Chart.js"></script>
	<script src="/PETNER/resources/js/line-chart.js"></script>
	<script src="/PETNER/resources/js/pie-chart.js"></script>
</body>
</html>