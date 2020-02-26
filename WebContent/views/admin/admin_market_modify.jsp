<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.Market" %>
<%
	Market market = (Market)request.getAttribute("market");
%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=l0qqr826cq&submodules=geocoder"></script>

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
				<div class="p-5" style="margin-left: 20%; margin-right: 20%;">
					<form class="user" action="/PETNER/updateMarket.ad" method="POST"  
					enctype="multipart/form-data" onsubmit="return validate();">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">매장 수정하기 입니다</h1>
							<div>
								<div id="div-radio" required
									style="display: inline-block; margin: 20px; font-size: 25px;">
									<!-- 나중에 CSS 파일에 class: div-radio 만들어서 넣어줄 것! -->
									<input type="radio" id="hotel" name="marketType" value="HOTEL" 
									class="marketRatio" onclick='hotelBtn();'> <label for="hotel">호텔</label>
								</div>
								<div id="div-radio"
									style="display: inline-block; margin: 20px; font-size: 25px;">
									<input type="radio" id="beauty" name="marketType" value="BEAUTY"
										class="marketRatio" onclick='beautyBtn();'> <label
										for="beauty">미용</label>
								</div id="div-radio">
								<div id="div-radio"
									style="display: inline-block; margin: 20px; font-size: 25px;">
									<input type="radio" id="hospital" name="marketType" value="HOSPITAL"
										class="marketRatio" onclick='hospitalBtn();'> <label
										for="hospital">병원</label>
								</div>
							</div>
							
					</div>
					<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
						<!-- name="market~~~" // id="mark~~~" -->
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;매장 고유번호</b>
							<input type="text" name="marketId"
								class="form-control form-control-user" id="markId"
								placeholder="매장 고유번호" value="<%=market.getMarketId()%>" readonly>
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;매장 이름</b>
							<input type="text" name="marketName"
								class="form-control form-control-user" id="markName"
								placeholder="marketName" value="<%=market.getMarketName()%>" required>
						</div><b>&nbsp;&nbsp;&nbsp;비밀번호</b>
						<div class="form-group row">
						
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="password" name="marketPwd"
									class="form-control form-control-user" id="marketPwd"
									placeholder="Password*" required> 
							</div>
							<div class="col-sm-6">
								<input type="password" name="marketPwd2"
									class="form-control form-control-user" id="marketPwd2"
									placeholder="Password check*" required>
							</div>
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;이메일</b>
							<input type="email" name="marketEmail"
								class="form-control form-control-user" id="markEmail"
								placeholder="Email Address*" value="<%=market.getMarketEmail()%>" required>
						</div>
						<b>&nbsp;&nbsp;&nbsp;매장 전화번호 / 대표 휴대폰번호</b>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" name="marketTel"
									class="form-control form-control-user" id="markTel"
									placeholder="Tel*" value="<%=market.getMarketTel()%>" required> 
							</div>
							<div class="col-sm-6">
								<input type="text" name="marketCellPhone"
									class="form-control form-control-user" id="markCellPhone"
									placeholder="Phone" value="<%=market.getMarketCellPhone()%>"> 
							</div>
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;주소</b>
							<input type="text" name="marketAddress"
								class="form-control form-control-user" id="markAddress"
								placeholder="Address*" value="<%=market.getMarketAddress()%>" required> 
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;지역</b>
							<input type="text" name="marketPlace"
								class="form-control form-control-user" id="markPlace"
								placeholder="지역">
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;활성화 상태</b>
							<input type="text" name="status"
								class="form-control form-control-user" id="status"
								placeholder="" value="<%=market.getStatus()%>" readonly>
						</div>
						
					<div style="max-width:700px; padding:10px;">
					<table style="border: 1px solid black; padding:10px;">
					<tr>
						<td style="padding-left:30px; padding-right:20px;"><b>대표 이미지</b></td>
						<td colspan="3">
							<div id="titleImgArea" style="margin:10px;">
								<img id="titleImg" width="400" height="220">
							</div>
						</td>
					</tr>
					</table>
					</div>
					<div class="fileArea" id="fileArea">
		      		<input type="file" id="marketMainPhoto"
		      				name="marketMainPhoto" onchange="loadImg(this, 1);" />
		      		
		      		</div>
						
						<br> 
							<input type="submit" value="수정하기" href="admin_market_table.jsp" 
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; max-width: 500px; margin: 25px;">
						<a href="/PETNER/marketList.ad"
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; max-width: 125px; margin: 25px; background: gray;">
						 취소
						</a> 
						<a href="#"
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; max-width: 125px; margin: 25px; background: crimson;"
							onclick="deleteBtn();">활성화 변경
							</a>
					</form>
						
						<br> <br> <br> <br> <br> <br>
						<br> <br> <br>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	<%@ include file="/views/common/footer.jsp"%>
	
	<!-- 스크립트를 넣었는데 $ 가 undefined.... 이거 JQuery 연결 안 돼있나??? 봐야겠다 -->
	<!-- 희창曰 : 스크립트를 아래쪽에 넣으니 undeifined가 뜨지.. 절차지향 -> 스크립트는 헤더나 맨 위쪽에 선언해놓아야 한다 -->
	<script>
		
		
		function validate() {
	        var pwd1 = $("#marketPwd").val();
	        var pwd2 = $("#marketPwd2").val();
            if(pwd1 != pwd2){
                alert("비밀번호가 서로 다릅니다.");
                $("#marketPwd2").select();
                return false;
            }
		}
		
		function deleteBtn() {
			var markName = $('#markName').val();
			var marketId = $('#markId').val();
			var status = $('#status').val();
			if (confirm(markName + ' :  활성화 변경하시겠습니까?') == true) {
				location.href="<%=request.getContextPath()%>/deleteMarket.ad?marketId="+marketId+"&status="+status;
			} else {
				return;
			}
		}
		
		/* naver.maps.Service.geocode({ address: '이목로24' }, function(status, response) {
		    if (status === naver.maps.Service.Status.ERROR) {
		        return alert('Something wrong!');
		    }

		    // 성공 시의 response 처리
		});
		naver.maps.Service.geocode({
	        address: '불정로 6'
	    }, function(status, response) {
	        if (status !== naver.maps.Service.Status.OK) {
	            return alert('Something wrong!');
	        }

	        var result = response.result, // 검색 결과의 컨테이너
	            items = result.items; // 검색 결과의 배열

	        // do Something
	    });
 */

 $(function(){
		$('#fileArea').hide();
		
		$('#titleImgArea').click(() => {
			$('#marketMainPhoto').click();
		});
		
	});
	
	function loadImg(value, num){
		
		if(value.files && value.files[0])  {
			
			var reader = new FileReader();
			
			reader.onload = function(e){
				
				switch(num) {
				case 1 : $('#titleImg').attr('src', e.target.result);
					break;
				case 2 : $('#contentImg1').attr('src', e.target.result);
					break;
				case 3 : $('#contentImg2').attr('src', e.target.result);
					break;
				case 4 : $('#contentImg3').attr('src', e.target.result);
					break;
				}
			}
			reader.readAsDataURL(value.files[0]);
		}
	}

	</script>

</body>
</html>