<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.MarketDetail" %>
<%
	MarketDetail md = (MarketDetail)request.getAttribute("MarketDetail");
	System.out.println((String)(request.getAttribute("marketAddress")));
%>
<!DOCTYPE html>
<html>
<head>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f5297b836f7bcdf0f45ab31e1bdc4607&libraries=services"></script>

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
					<form class="user" action="/PETNER/updateMarketDetail.ad" method="POST"  
					enctype="multipart/form-data" onsubmit="">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">매장 DETAIL</h1>
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
									<input type="radio" id="hospital" name="marketType" value="HOSIPITAL"
										class="marketRatio" onclick='hospitalBtn();'> <label
										for="hospital">병원</label>
								</div>
							</div>
							
					</div>
					<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
						<!-- name="market~~~" // id="mark~~~" -->
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;매장 고유번호</b><br>
							<input type="text" name="marketId"
								class="form-control form-control-user" id="markId"
								placeholder="매장 고유번호" value="<%=md.getMarketId()%>" readonly>
						</div>
						<div class="form-group">
						<b>&nbsp;&nbsp;&nbsp;매장 이름</b><br>
							<input type="text" name="marketName"
								class="form-control form-control-user" id="markName"
								placeholder="매장이름" value="<%=md.getMarketName()%>" readonly>
						</div>
						
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;지하철 정보</b><br>
							<input type="textArea" name="marketSub"
								class="form-control form-control-user" id="markSub" value="<%=md.getMarketSub()%>"
								placeholder="지하철로 오는 방법을 써주시면 됩니다.">
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;버스 정보</b><br>
							<input type="textArea" name="marketBus"
								class="form-control form-control-user" id="marBus" value="<%=md.getMarketBus()%>"
								placeholder="버스로 오는 방법을 써주시면 됩니다.">
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;자동차 정보</b><br>
							<input type="textArea" name="marketCar"
								class="form-control form-control-user" id="markCar" value="<%=md.getMarketCar() %>"
								placeholder="자동차로 오시는 방법을 써주시면 됩니다.">
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;간단한 매장 소개</b><br>
							<input type="textArea" name="marketIntro"
								class="form-control form-control-user" id="markIntro" value="<%=md.getMarketIntro() %>"
								placeholder="간단한 소개">
						</div>
						<div class="form-group">
							<input type="text" name="marketPrice"
								class="form-control form-control-user" id="markPrice" style="display: none;"
								placeholder="호텔 1박당 가격">
						</div>
						<br> <br>

						<div id="marketCheckHotel" style="display: none;">
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<!-- CSS 추가 id="marketCheck"-->
								<input type="checkbox" name="marketCheckData" id="a111" value="산책 서비스"><label for="a111">&nbsp;산책 서비스</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a222" value="목욕"><label for="a222">&nbsp;목욕</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a333" value="스파"><label for="a333">&nbsp;스파</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a444" value="고양이 가능"><label for="a444">&nbsp;고양이 가능</label>
							</div>
							<br>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a555" value="24시간 운영"><label for="a555">&nbsp;24시간 운영</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a666" value="픽업 가능"><label for="a666">&nbsp;픽업 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a777" value="특수동물 가능"><label for="a777">&nbsp;특수동물 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="a888" value="그 외 기타등등"><label for="a888">&nbsp;그 외 기타등등</label>
							</div>
						</div>
						
						
						<div id="marketCheckBeauty" style="display: none;">
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b111" value="가위컷"><label for="b111">&nbsp;가위컷</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b222" value="곰돌이컷"><label for="b222">&nbsp;곰돌이컷</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b333" value="서머스페샬"><label for="b333">&nbsp;서머스페샬</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b444" value="바리깡"><label for="b444">&nbsp;바리깡</label>
							</div>
							<br>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b555" value="24시간 운영"><label for="b555">&nbsp;24시간 운영</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b666" value="픽업 가능"><label for="b666">&nbsp;픽업 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b777" value="특수동물 가능"><label for="b777">&nbsp;특수동물 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="b888" value="그 외 기타등등"><label for="b888">&nbsp;그 외 기타등등</label>
							</div>
						</div>
						
						
						<div id="marketCheckHospital" style="display: none;">
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c111" value="24시 운영"><label for="c111">&nbsp;24시 운영</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c222" value="응급실 운영"><label for="c222">&nbsp;응급실 운영</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c333" value="대형견 가능"><label for="c333">&nbsp;대형견 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c444" value="고양이 가능"><label for="c444">&nbsp;고양이 가능</label>
							</div>
							<br>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c555" value="48시간 운영"><label for="c555">&nbsp;48시간 운영</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c666" value="픽업 가능"><label for="c666">&nbsp;픽업 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c777" value="특수동물 가능"><label for="c777">&nbsp;특수동물 가능</label>
							</div>
							<div id="martketCheck"
								style="display: inline-block; margin: 20px; font-size: 20px;">
								<input type="checkbox" name="marketCheckData" id="c888" value="그 외 기타등등"><label for="c888">&nbsp;그 외 기타등등</label>
							</div>
						</div>
						
						
						좌표값 안 누르면 에러뜸!<br>
						<input type="text" id="marketAddress" style="width:500px;" value="<%= (String)(request.getAttribute("marketAddress")) %>"></input>
						<input type="button" value="좌표값 검색" onclick="addressChk()">
						<div id="map" style="width:100%;height:450px;" hidden></div>
						
						
						<div id="coordX" name="mapx" value=""></div>
						<div id="coordY" name="mapy" value=""></div>
						
						
						
						
					<div style="max-width:700px; padding:10px;">
					<table style="border: 1px solid black; padding:10px;">
					
					<tr>
						<td style="padding-left:30px; padding-right:20px;"><b>슬라이드 사진</b></td>
						<td>
							<div id="contentImgArea1" style="margin:9px;">
								<img id="contentImg1" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea2" style="margin:9px;">
								<img id="contentImg2" width="120" height="100">
							</div>
						</td>
						<td>
							<div id="contentImgArea3" style="margin:9px;">
								<img id="contentImg3" width="120" height="100">
							</div>
						</td>
					</tr>
					</table>
					</div>
					<div class="fileArea" id="fileArea">
		      		<input type="file" id="marketMainPhoto"
		      				name="marketMainPhoto" onchange="loadImg(this, 1);" />
		      				
		      		<input type="file" id="marketSubPhoto01"
		      				name="marketSubPhoto01" onchange="loadImg(this, 2);" />
		      				
		      		<input type="file" id="marketSubPhoto02"
		      				name="marketSubPhoto02" onchange="loadImg(this, 3);" />
		      				
		      		<input type="file" id="marketSubPhoto03"
		      				name="marketSubPhoto03" onchange="loadImg(this, 4);" />
		      		</div>
						
						<br> 
							<input type="submit" value="수정하기" href="/PETNER/updateMarketDetail.ad" 
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
							onclick="deleteBtn();">삭제
						</a>
						
						<input id="coordXX" name="mapx" value="" hidden></input>
						<input id="coordYY" name="mapy" value="" hidden></input>
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
		function hotelBtn() {
			if ($('#hotel').prop('checked')) {
				$('#marketCheckHotel').css('display',
						'block');
				$('#marketCheckBeauty').css('display',
				'none');
				$('#marketCheckHospital').css('display',
				'none');
				$('#markPrice').css('display','block');
			}
		};
		function beautyBtn() {
			if ($('#beauty').prop('checked')) {
					$('#marketCheckBeauty').css('display',
							'block');
					$('#marketCheckHotel').css('display',
					'none');
					$('#marketCheckHospital').css('display',
					'none');
					$('#markPrice').css('display','none');
			}
		}
		function hospitalBtn() {
			if ($('#hospital').prop('checked')) {
					$('#marketCheckHospital').css('display',
							'block');
					$('#marketCheckBeauty').css('display',
					'none');
					$('#marketCheckHotel').css('display',
					'none');
					$('#markPrice').css('display','none');
			} 
		}
		
		/* function validate() {
	        var pwd1 = $("#marketPwd").val();
	        var pwd2 = $("#marketPwd2").val();
            if(pwd1 != pwd2){
                alert("비밀번호가 서로 다릅니다.");
                $("#marketPwd2").select();
                return false;
            }
		} */
		
		function deleteBtn() {
			var markName = $('#markName').val();
			var marketId = $('#markId').val();
			if (confirm(markName + ' :  정말 삭제하시겠습니까?') == true) {
				location.href="<%=request.getContextPath()%>/deleteMarket.ad?marketId=" + marketId;
			} else {
				return;
			}
		}
		
		$('input[type="textArea"]').keydown(function() {
			  if (event.keyCode === 13) {
			    event.preventDefault();
			  };
			});
			
		/* document.addEventListener('keydown', function(event) {
			  if (event.keyCode === 13) {
			    event.preventDefault();
			  };
			}, true); */

			// 사진 게시판 미리보기 기능 지원 스크립트
			$(function(){
				$('#fileArea').hide();
			
				$('#contentImgArea1').click(() => {
					$('#marketSubPhoto01').click();
				});
				
				$('#contentImgArea2').click(() => {
					$('#marketSubPhoto02').click();
				});

				$('#contentImgArea3').click(() => {
					$('#marketSubPhoto03').click();
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
			
			var address      = document.getElementById("marketAddress");
			var mapContainer = document.getElementById("map");
			var coordX   = document.getElementById("coordX");
			var coordY   = document.getElementById("coordY");
			var coordXX   = document.getElementById("coordXX");
			var coordYY   = document.getElementById("coordYY");
			var mapOption;
			var map;
			var x = "";
			var y = "";

			if (address.value=="") {

			 mapOption = {
			  center: new daum.maps.LatLng(33.450701, 126.570667), // 임의의 지도 중심좌표 , 제주도 다음본사로 잡아봤다.
			        level: 4            // 지도의 확대 레벨

			 };
			}

			// 지도 생성
			map = new daum.maps.Map(mapContainer, mapOption);


			function addressChk() {
			 var gap = address.value; // 주소검색어
			 if (gap=="") {
			  alert("주소 검색어를 입력해 주십시오.");
			  address.focus();
			  return;
			 }
			 
			 // 주소-좌표 변환 객체를 생성
			 var geocoder = new daum.maps.services.Geocoder();


			 // 주소로 좌표를 검색
			 geocoder.addressSearch(gap, function(result, status) {
			  
			  // 정상적으로 검색이 완료됐으면,
			  if (status == daum.maps.services.Status.OK) {
			   
			   var coords = new daum.maps.LatLng(result[0].y, result[0].x);

			   y = result[0].x;
			   x = result[0].y;
	   
			   coordX.innerHTML = "<br>X좌표 : " + x;
			   coordY.innerHTML = "<br>Y좌표 : " + y;
			   coordXX.value = x;
			   coordYY.value = y;

			  
			  }
			 });
			}




	</script>

</body>
</html>