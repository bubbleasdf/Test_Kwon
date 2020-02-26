<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.petner.member.pet.model.vo.*"%>
<%
	Pet pet = (Pet) request.getAttribute("Pet");
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
			<div id="content">
				<!-- Begin Page Content -->
				<div class="p-5" style="margin-left: 20%; margin-right: 20%;">
					<form class="user" action="/PETNER/updateMarketDetail.ad"
						method="POST" enctype="multipart/form-data" onsubmit="">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">펫 상세페이지</h1>


						</div>
						<!-- 필수정보는 required 나중에 필수로 넣어줄 것! -->
						<!-- name="market~~~" // id="mark~~~" -->
						<div id="pic11" style="max-width: 900px; padding: 10px; align:center;" >
							<table style="border: 1px solid black; padding: 10px;">
								<tr>
									<td style="padding-left: 30px; padding-right: 20px;"><b>사진!</b></td>
									<td colspan="3">
										<div id="titleImgArea" style="margin: 10px;">
											<img id="titleImg" width=auto height=auto
												src="/PETNER/resources/img/member/pet/<%=pet.getPetPic()%>"
												alt="펫 사진">
										</div>
									</td>
								</tr>

							</table>
						</div>
						<br>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;애기들 고유번호</b><br> <input type="text"
								name="petId" class="form-control form-control-user" id="petId"
								placeholder="" value=<%=pet.getPetId()%> readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 이름</b><br> <input type="text"
								name="petName" class="form-control form-control-user"
								id="petName" placeholder="" value="<%=pet.getPetName()%>"
								readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;주인 EMAIL</b><br> <input type="text"
								name="petEmail" class="form-control form-control-user"
								id="petEmail" placeholder="" value="<%=pet.getUserEmail()%>"
								readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 프로필</b><br> <input type="text"
								name="petProfile" class="form-control form-control-user"
								id="petProfile" placeholder="" value="<%=pet.getPetProfile()%>"
								readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 이름</b><br> <input type="text"
								name="petWeight" class="form-control form-control-user"
								id="petWeight" placeholder=""
								value="약 <%=pet.getPetWeight()%>kg" readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 타입</b><br> <input type="text"
								name="petType" class="form-control form-control-user"
								id="petType" value="<%=pet.getPetType()%> 사이즈" placeholder=""
								readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 생년월일</b><br> <input type="text"
								name="petBirth" class="form-control form-control-user"
								id="petBirth" placeholder="" value="<%=pet.getPetBirth()%>"
								readonly>
						</div>
						<div class="form-group">
							<b>&nbsp;&nbsp;&nbsp;펫 등록일</b><br> <input type="text"
								name="petType" class="form-control form-control-user"
								id="petType" value="<%=pet.getPetDate()%>" placeholder=""
								readonly>
						</div>





						<br> <br> <br> <a href="admin_user_table.jsp"
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; width: 250px; margin: 25px; visibility: hidden;"
							onclick='submitBtn1();'> <!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... -->
							완료 <!-- 이걸 submit 버튼으로 바꿔야 할 것 같은데.......--> <script>
							function submitBtn1() {
								alert('수정 완료')
							}
						</script>
						</a> <a href="/PETNER/petList.ad"
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; width: 250px; margin: 25px; background: gray;">
							<!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... --> 확인
						</a> <a href="admin_user_table.jsp"
							class="btn btn-primary btn-user btn-block"
							style="display: inline-block; width: 250px; margin: 25px; background: crimson; visibility: hidden;"
							onclick="deleteBtn();"> <!-- 버튼이 너무 길어보인다? 가운데에다 사이즈 줄일까... -->
							삭제 <script>
							function deleteBtn() {
								if (confirm('정말 삭제하시겠습니까?') == true) {
									alert('삭제되었습니다');
								} else {
									return;
								}
							}
						</script>

						</a><br> <br>
					</form>

					<br> <br> <br> <br> <br> <br> <br>
					<br> <br>
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
				
				$('#titleImgArea').click(() => {
					$('#marketMainPhoto').click();
				});
				
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


	</script>

</body>
</html>