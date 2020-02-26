<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="com.kh.petner.member.model.vo.Member"%>      
<%
	String username = (String)request.getAttribute("user_Name");	
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
	<title>호텔 예약 완료</title>
	
	<!-- jQuery -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>	
	
	<!-- 아임포트 결제 -->
	<script>
	// 호출된 결제창을 통해 구매자가 결제 프로세스를 완료
	$(function() { 
	$("#pay_module").click(function(){
		 var IMP = window.IMP; 
		 IMP.init('imp07139288'); // 가맹점 식별코드 
		 IMP.request_pay({
			    pg : 'html5_inicis', // 이니시스 표준!
			    pay_method : 'card', // 신용카드
			    merchant_uid : 'merchant_' + new Date().getTime(),
			    name : 'PETNER HOTEL 결제', // 결제창에서 보여질 이름
			    amount : 1000, // 가격(진짜 높은 금액을 결제할 순 없으니 계속 1000원으로 고정)
			    buyer_email : 'hyoona_s2@naver.com', 
			    buyer_name : 'user',
			    buyer_tel : 'phone',
			    buyer_addr : 'PETNER HOTEL 역삼',
			    buyer_postcode : '123-456'
		 }, function(rsp) {
			    if ( rsp.success ) {
			    	// 1) 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기 
			    	jQuery.ajax({
			    		url: "/payments/complete", //cross-domain error가 발생하지 않도록 동일한 도메인으로 전송
			    		type: 'POST',
			    		dataType: 'json',
			    		data: {
				    		imp_uid : rsp.imp_uid
				    		//기타 필요한 데이터가 있으면 추가 전달
			    		}
			    	}).done(function(data) {
			    		// 2)  서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
			    		if ( everythings_fine ) {
			    			var msg = '결제가 완료되었습니다.';
			    			msg += '\n고유ID : ' + rsp.imp_uid;
			    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
			    			msg += '\결제 금액 : ' + rsp.paid_amount;
			    			msg += '카드 승인번호 : ' + rsp.apply_num;

			    			alert(msg);
			    		} else {
			    			// 3) 아직 제대로 결제가 되지 않았습니다.
			    			// 4)결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
			    		}
			    	}); 
			    	// 성공시 이동할 페이지
			    	location.href="hotel_paySuccess.jsp";
			    } else {
			        var msg = '';
			        msg += '' + rsp.error_msg;
					// 실패시 이동할 페이지
					location.href="hotel_reserveSuccess.jsp";
			        alert(msg);
			    }
			});  
	}); 
	}); 
	</script>
		
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		
	</head>
	<body>
		
		<%@ include file="/views/common/header.jsp" %> 
			
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
						<h1 class="h4 text-gray-900 mb-4" style="padding-top:50px;">
							<span style="text-weight:bold; font-size:22px;"><%= m.getUserName() %></span>님의 호텔 예약이 완료되었습니다.</h1>
						<hr style="padding-bottom:50px;">
						<h4>저희 <span style="color:#008000;">PETNER+</span>를 이용해주셔서 감사합니다.</h4><br><br>
						<h5 style="padding-bottom:80px;">예약이 완료되었으나 결제는 <span style="font-weight:bold;">현장 결제 </span>부탁드립니다.<br><br>
							바로 결제를 원하시면 <span style="font-weight:bold;">바로결제</span> 버튼을 클릭해주세요.<br><br>
							예약 내역은 마이페이지를 통해 확인하실 수 있습니다.<br>
							더 자세한 문의사항은 Q&A게시판 이용을 부탁드립니다. 
						</h5>
						
						<a href="/PETNER/index.jsp" class="btn btn-primary btn-user" 
							style="width:250px; background:#008000; color:white; 
							width:150px; margin-bottom:40px;">HOME</a>
						<button id="pay_module" type="button" class="btn btn-primary btn-user" style="width:250px; background:#008000; color:white; width:150px; margin-bottom:40px; margin-left:20px;">바로결제</button>
					  	
					  </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
				
		<%@ include file="/views/common/footer.jsp" %>
	</body>
</html>