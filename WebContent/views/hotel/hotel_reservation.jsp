<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.member.pet.model.vo.Pet,com.kh.petner.market.model.vo.MarketDetail, java.util.*" %>
<%
	
	MarketDetail marD = (MarketDetail)request.getAttribute("MarketDetail");
	System.out.println("으아아아앜ㅋㅋㅋㅋㅋ" + marD);
	/* Pet hotelRevPet = (Pet)request.getAttribute("hotelRevPet");  */

%>

<!DOCTYPE html>
<html>
<!-- 

	header와 footer만 달아놓은 기본폼입니다 
	포함 : CSS / JS등등.. head부분에 추가적인 내용이 없는이상 넣을 필요 없습니다
	이제 body 태그 안에 만들어놓은 내용을 집어넣으면 됩니다.

-->
<head>


</head>

<body>
	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/hyun.jsp"%>
	
	<div style="padding-top:180px;"></div>
	
<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-9" style="margin: auto;">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-4 marg45" style="font-size:22px;">호텔 예약하기</h1>	
						<h4 style="margin-bottom:40px;">Hotel Reservation</h4>	  
					</div>
					<div class="card card-outline card-info col-md-9 " style="margin: auto;">
					<form class="hotelreserve" id="hotelreserveForm" action="<%= request.getContextPath()%>/insertReserve.re" method="post">
						
						<div class="form-group">
							<input type="hidden" id="marketId" value=<%=marD.getMarketId() %> name="marketId">
						</div>
						
						<div class="form-group" style="margin-top:30px;">
							<input type="text" class="form-control form-control-user" id="market_Name" placeholder="마켓이름"
							 value="<%= marD.getMarketName()%>" name="market_Name" style="background:#eee;" readonly>
						</div>
						
						<div class="form-group" style="margin-top:30px;">
							<input type="text" class="form-control form-control-user" id="user_Name" placeholder="예약자명"
							value="<%= m.getUserName() %>" name="user_Name" style="background:#eee;" readonly>
						</div>
						
						<div class="form-group" style="margin-top:30px;">
							<input type="email" class="form-control form-control-user" id="user_Email" placeholder="이메일"
							value="<%= m.getUserEmail() %>" name="user_Email" style="background:#eee;" readonly>
						</div>
						
						<div class="form-group" style="margin-top:30px;">
							<input type="text" class="form-control form-control-user" id="user_Phone" placeholder="휴대폰 번호"
							value="<%= m.getUserPhone() %>" name="user_Phone" style="background:#eee;" readonly>
						</div>
						
						<div class="form-group row" style="margin-top:30px;">
							<div class="col-sm-6 mb-3 mb-sm-0">
							  <input type="date" class="form-control form-control-user" id="s_date" name="s_date" value="s_date" onchange="daySub()"> <!--시작날짜-->
							</div>
							<div class="col-sm-6">
							  <input type="date" class="form-control form-control-user" id="e_date" name="e_date" value="e_date" onchange="daySub()"><!--끝 날짜-->
							</div>
						</div>
						
						<!-- 날짜 차이 계산 스크립트 -->
						<script>
						function daySub() {
							var sdate = document.getElementById("s_date").value;
							var edate = document.getElementById("e_date").value; 
							var ar1 = sdate.split('-');
							var ar2 = edate.split('-'); 
							var date1 = new Date(ar1[0], ar1[1], ar1[2]);
							var date2 = new Date(ar2[0], ar2[1], ar2[2]); 
							var date3 = date2 - date1; 
							var cDay = 24 * 60 * 60 * 1000; // 시 * 분 * 초 * 밀리세컨 
							
							if(sdate && edate) {
									document.getElementById('sub_date').value = parseInt(date3/cDay);
									document.getElementById('sum_price').value = 
										parseInt((parseInt(date3/cDay)) * (document.getElementById('marketPrice').value));
								}
							}
						</script>
						
						<div class="form-group" style="">
							숙박일수(일)<input type="text" class="form-control form-control-user" id="sub_date" name="sub_date" readonly>
						</div>
						
						<div class="form-group" style="">
							1박당 요금<input type="text" class="form-control form-control-user" id="marketPrice" value="<%= marD.getMarketPrice() %>"
							 name="marketPrice" placeholder="1박당 요금" readonly>
						</div>
						
						
						<div class="form-group">
							총 결제금액<input type="text" class="form-control form-control-user" id="sum_price" value="" name="sum_price" readonly>
						</div>
						
						<!-- <div class="form-group">
							<input type="hidden" id="pet_Id" value="" name="pet_Id">
						</div> -->
						 
						<div class="form-group" style="">
							<input type="text" class="form-control form-control-user" id="pet_Name" name="pet_Name" placeholder="Pet 이름을 입력하세요.">
						</div>
						
						<div class="form-group" style="">
							<input type="text" class="form-control form-control-user" id="pet_Type" name="pet_Type" placeholder="Pet 타입을 입력하세요.">
							
						</div>
						
						<div style="text-align: center; padding-bottom:50px;" >
							<button type="submit" class="btn btn-primary btn-user " style="width:200px; background: #008000; color:white; margin-right:30px;">결제하기</button>
							<a href="/PETNER/MarketIN.mk?mno=<%=marD.getMarketId() %>" class="btn btn-primary btn-user" style="width:200px; background:#008000; color:white;">이전페이지로</a>
						</div>
					</form>
					<!-- /.card-body -->
					</div>
					<!-- /.card-footer -->
				</div>
			</div>
	</section>
	<!-- /.content -->
	<br><br><br><br>
		<%@ include file="/views/common/footer.jsp"%>
	</body>
</html>

