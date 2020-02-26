<%@page import="com.kh.petner.market.model.vo.*, java.util.*, com.kh.petner.QComment.model.vo.*,
				com.kh.petner.Review.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Market mk = (Market)request.getAttribute("market");
	MarketDetail md = (MarketDetail)request.getAttribute("marketDetail");
	ArrayList<QComment> qlist = (ArrayList<QComment>)request.getAttribute("qlist");
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist");
	int star = (Integer)request.getAttribute("star");
	System.out.println("MArket Mapx : " + md.getMapx());
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>Petner+</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=l0qqr826cq"></script>
    
<style>
.overlay {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
}

.home-banner-area2 {
	background: url(../img/dogcat.jpg) no-repeat center fixed;
	background-size: cover;
}

.banner-area2 {
	background: url(/PETNER/resources/img/<%=mk.getMarketType()%>.jpg) no-repeat center;
	background-size: cover;
	min-height: 420px;
}

.blog-banner-area2 {
	background: url(/PETNER/resources/img/bath.jpg) no-repeat center fixed;
	background-size: cover;
	min-height: 420px;
}

.blog-banner-area2 .banner-content h1 {
	font-size: 48px;
	line-height: 54px !important;
	margin: 0;
}

@media ( max-width : 768px) {
	.blog-banner-area2 .banner-content h1 {
		font-size: 35px;
		line-height: 40px !important;
	}
}

@media ( max-width : 414px) {
	.blog-banner-area2 .banner-content h1 {
		font-size: 30px;
	}
}

.blog-banner-area2 .banner-content p {
	font-size: 16px;
	margin: 40px 20px;
}

@media ( max-width : 768px) {
	.blog-banner-area2 .banner-content p {
		margin: 10px;
	}
}

.blog-banner-area2 .banner-content .primary-btn {
	background: #fff;
	color: #222222;
}

.blog-banner-area2 .banner-content .primary-btn:hover {
	background: #3face4;
	color: #ffffff;
}

.fullscreen {
	height: 740px;
}

@media ( max-width : 767.98px) {
	.fullscreen {
		height: 600px !important;
	}
}

@media ( max-width : 768px) {
	.fullscreen {
		height: 400px !important;
	}
}

.overlay-bg {
	background-color: rgba(34, 34, 34, 0.27);
}

.banner-content h1 {
	color: #fff;
	font-size: 72px;
	font-weight: 100;
	line-height: 77px !important;
	margin-top: 20px;
	margin-bottom: 20px;
}

@media ( max-width : 768px) {
	.banner-content h1 {
		font-size: 35px;
		line-height: 40px !important;
	}
}

@media ( max-width : 414px) {
	.banner-content h1 {
		font-size: 30px;
	}
}

.banner-content p {
	max-width: 900px;
}

.header-btn {
	border: 1px solid transparent;
	background-color: #008000;
}

.header-btn:hover {
	border: 1px solid #008000;
	background: transparent;
	color: #008000;
}

.banner-img {
	text-align: right;
}

@media ( max-width : 767px) {
	.banner-img {
		width: 60%;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
	}
}
/****************** 여기추가했음 **************/
.ffont-style {
	padding-left:15px;
	font-weight: bold;
	font-size: 14px;
}
.btn-reply:hover {
    background-color: #008000 !important;
    color: #fff; 
}

.text-style {
	font-size: 14px; 
	border: none; 
	width: 800px; 
	margin-top: 20px;
	margin-left: 40px;
	resize: none;
}

.text22-style {
	font-size: 14px; 
	width: 800px; 
	margin-top: 20px;
	margin-left: 60px;
	resize: none;
}

.button1 {
 	border: none;
    margin-left: 40px !important;
    font-size: 11px;
    background-color:cornflowerblue;
    color: snow;
}



/* 별점 */
.starR{
  background: url(/PETNER/resources/img/ico_review.png) no-repeat right 0;
  background-size: auto 100%;
  width: 30px;
  height: 30px;
  display: inline-block;
  text-indent: -9999px;
  cursor: pointer;
}
.starR.on{background-position:0 0;}

</style>
</head>
<body>



	<%@ include file="/views/common/header.jsp"%>
	<%@ include file="/views/common/hyun.jsp"%>
	
	<!--image slide-->
		<script>
			$(document).ready(function() {
				var main = $('.bxslider').bxSlider({
					mode : 'fade',
					auto : true, //자동으로 슬라이드 
					controls : false, //좌우 화살표   
					autoControls : false, //stop,play 
					pager : true, //페이징 
					pause : 3000,
					autoDelay : 0,
					slideWidth : 800,
					speed : 500,
					stopAutoOnclick : true
				});

				$(".bx-stop").click(function() { // 중지버튼 눌렀을때 
					main.stopAuto();
					$(".bx-stop").hide();
					$(".bx-start").show();
					return false;
				});

				$(".bx-start").click(function() { //시작버튼 눌렀을때 
					main.startAuto();
					$(".bx-start").hide();
					$(".bx-stop").show();
					return false;
				});

				$(".bx-start").hide(); //onload시 시작버튼 숨김. 

			});

			function lic() {
				// $(".bxslider").click(function(){
				$("#modal1").modal();
				// });
			}
		</script>
	

	<!--######## start banner Area ########-->
	<section class="banner-area2 relative" id="home">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-black text-uppercase">
						Petner+ <span style="font-weight: 200;"><%=mk.getMarketType() %></span>
					</h1>
					<p class="text-black link-nav">We are always with you</p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	<hr>

	<!--hyon_경로표시부분-->
	<div class="way_wrap">
		<a href="/PETNER/index.jsp"><img
			src="/PETNER/resources/img/home_icon.png"> HOME </a>> <a
			href="hotel_home.jsp"><span><%=mk.getMarketType() %></span></a> > <a
			href="hotel_information.jsp"><span><%=mk.getMarketName() %></a>
	</div>

	<!-- 경로표시 끝-->

	<!--######## Portfolio Details Area ########-->
	<section class="portfolio_details_area section-gap">
		<div class="container">
			<div class="portfolio_details_inner">
				<div class="row">
					<div class="col-md-6">
						<div style="height: 400px; width: 500px;">
							<ul class="bxslider">
								<li><img src="/PETNER/resources/adminUploadFiles/<%=md.getMarketSubPhoto01()%>"
									style="height: 400px; width: 500px;" /></li>
								<li><img src="/PETNER/resources/adminUploadFiles/<%=md.getMarketSubPhoto02()%>"
									style="height: 400px; width: 500px;" /></li>
								<li><img src="/PETNER/resources/adminUploadFiles/<%=md.getMarketSubPhoto03()%>"
									style="height: 400px; width: 500px;" /></li>

							</ul>
						</div>
					</div>
					
					<div class="offset-md-1 col-md-5" style="margin-top:10px;">
						<div class="portfolio_right_text mt-30">

							<h4 style="font-weight: bold;"><%=mk.getMarketName() %></h4>

							<hr>
							<p style="text-align: right;">* 예약 상담 필수</p>
							<p>
								<!--이미지 슬라이드 적용시켜야함-->
							<ul>
							<%
								String check = md.getMarketCheck();
								String[] array_check;
								
								array_check = check.split(",");
								
								for(int i=0; i<array_check.length; i++){
							%>
							<li><img class="plus" src="/PETNER/resources/img/plus2.png">&nbsp;
									<%=array_check[i] %></li>
									
							<% } %>
<!-- 								<li><img class="plus" src="/PETNER/resources/img/plus2.png">&nbsp;
									산책서비스</li>
								<li><img class="plus" src="/PETNER/resources/img/plus2.png">&nbsp;
									목욕</li>
								<li><img class="plus" src="/PETNER/resources/img/plus2.png">&nbsp;
									스파</li>
								<li><img class="plus" src="/PETNER/resources/img/plus2.png">&nbsp;
									24시 운영</li> -->
							</ul>
							</p>

							<hr>

							<ul class="list">
								<!--별점 부분-->
								<li>
									<!-- Integer.parseInt(request.getAttribute("star")); -->
									<% for(int i=0; i < star ; i++) { %>
											<span class="starR on" style="width:15px; height:15px;"></span> 
										<% } %>
										<% for(int i=0; i< 5-star ; i++) { %>
											<span class="starR" style="width:15px; height:15px;"></span> 
										<% } %>
								</li>
							</ul>

							<!--button-->
							<div style="margin-top:20px;">
								<%if(m !=null && mk.getMarketType().equals("HOTEL")) { %>
								<a href="/PETNER/hotelReserve.re?marketId=<%=mk.getMarketId()%>&userEmail=<%=m.getUserEmail()%>">
									<button style="float: right;" class="primary-btn header-btn">예약하기</button>
								</a>
								<% } %>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>






		
	</section>
	<!--######## End Portfolio Details Area ########-->








	<hr>

	<!--start tab area-->
	<div id="t_container">
		<ul class="tabs">
			<li class="active" rel="tab1">병원상세정보</li>
			<li rel="tab2">후기</li>
			<li rel="tab3">문의</li>
		</ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<br>
				<div id="map"></div> 
				<!-- <div id="map" style="width:100%;height:400px;"></div> -->
				
				
				<br>

				<div class="map_text">
					<br>
					<br> ＊오시는 길<br>
					<br> [주소]<br><%=mk.getMarketAddress() %><br>
					<br> [대표전화]<br><%=mk.getMarketTel() %><br>
					<br> [이메일]<br><%=mk.getMarketEmail() %><br>
					<br> 지하철을 이용하시는 분<br> →<%=md.getMarketSub() %><br>
					<br> 버스를 이용하시는 분<br> →<%=md.getMarketBus() %><br>
					<br> 자가용을 이용하시는 분<br> →<%=md.getMarketCar() %><br>
					<br> 매장 간단 소개<br> →<%=md.getMarketIntro() %><br>
				</div>
	
			</div>
			<!-- #tab1 -->
			<div id="tab2" class="tab_content">
				<p class="text1">후기</p>
				<!--######## Start post-content Area ########-->
				<section class="post-content-area single-post-area">
					<div class="container">
						<div class="row">
							<div class="posts-list">
								<div class="comments-area" style="padding:40px 50px !important;">
									<% if(rlist != null) { %>
									<% for(Review rv : rlist) { %>
									<div id="reviewww" class="comment-list" style="padding-bottom: 0px !important;">
										<div class="single-comment justify-content-between d-flex" style="padding-top:10px !important;">
											<div class="user justify-content-between d-flex">
											<% if(rv.getRlevel() == 1) {%>
												<div class="thumb">
													<img src="/PETNER/resources/img/user_icon.png">
												</div>
											<% } %>
											<% if(rv.getRlevel() == 2) { %>
												<div class="thumb" style="margin-left:40px !important" >
													<img src="/PETNER/resources/img/shop_icon2.png">
												</div>
											<% } %>
												<div class="desc">
													<a><span class="ffont-style" style="padding-left:0px !important;"><%=rv.getRname() %></span>
														&nbsp;&nbsp;&nbsp;&nbsp;<%=rv.getRdate() %></a>
													<p class="reviewstar" style="margin-left: 0px !important; margin-top: 10px !important;">
														<% if(rv.getRlevel() != 2) { %>
														<% for(int i=0; i< rv.getRstar(); i++) { %>
															<span class="starR on" style="width:15px; height:15px;"></span> 
														<% } %>
														<% for(int i=0; i< 5-rv.getRstar(); i++) { %>
															<span class="starR" style="width:15px; height:15px;"></span> 
														<% } } %>
													
													</p>
												</div>
											</div>
											<% if(m != null && m.getUserEmail().equals(rv.getRemail())) { %>
											<div class="reply-btn">
												<input type="hidden" name="rno" value="<%=rv.getRno()%>" />
												<input type="button" class="updateRe primary-btn header-btn " style="padding-left:6px; line-height: 30px;
												width:40px; height:30px;" onclick="updateReview(this);" value="수정" />
												<input type="button" class="updateReConfirm primary-btn header-btn " style="padding-left:6px; line-height: 30px;
												width:65px; height:30px; display:none;" onclick="updateReConfirm(this);" 
														 value="수정완료"/>
												<input type="button" class="deleteRe primary-btn header-btn " style="padding-left:6px; line-height: 30px;
												width:40px; height:30px;" onclick="deleteReview(this);" value="삭제" />
											</div>
											<% } %>
											<% if( m != null && m.getUserRoles() == 200 && rv.getRlevel() != 2 && mk.getMarketEmail().equals(m.getUserEmail())) { %>
											<div class="reply-btn">
												<input type="hidden" name="rname" value="<%=m.getUserName()%>" />
												<input type="hidden" name="refrno" value="<%=rv.getRno() %>" />
												<input type="hidden" name="rlevel" value="<%=rv.getRlevel()%>"/>
												<input type="button" class="reRe primary-btn header-btn"
												style="padding-left:6px; line-height: 30px; width:40px; height:30px;" onclick="reReview(this);" value="답글" />
												<input type="button" class="replyMarket primary-btn header-btn " style="padding-left:6px; line-height: 30px;
												width:65px; height:30px; display:none;" onclick="replyMarket(this);" value="답글완료"/>
											</div>
											<% } %>
										</div>
									<textarea class="comment text-style" 
									style="<%if(rv.getRlevel() != 2) { %>margin-left:45px !important;<% } %> 
									<%if(rv.getRlevel() != 1) { %>margin-left:85px !important;<% } %>
									margin-top: 10px !important;" readonly="readonly"><%=rv.getRcontent() %></textarea>
									<hr>
									</div>
									<% } } %>
								</div>
								<%if(m != null && m.getUserRoles() != 200) { %>
								<div class="comment-form" style="width: 1000px !important;">
                                    <h4>후기 작성</h4>
                                    <form id="reviewdiv" action="/PETNER/reviewIn.rv" method="post">
                                    	<input type="hidden" name="rmno" value="<%=mk.getMarketId()%>"/>
                                    	<input type="hidden" name="refrno" value="0" />
                                    	<input type="hidden" name="rlevel" value="1" />
                                    	<input type="hidden" id="rstar" name="rstar" value="0" />
                                        <div class="form-group form-inline">
                                            <div class="form-group col-lg-6 col-md-12 name">
                                                <input type="text" class="form-control" name="rname" value="<%=m.getUserName() %>" readonly>
                                            </div>
                                            <div class="form-group col-lg-6 col-md-12 email">
                                                <input type="email" class="form-control" name="remail" value="<%=m.getUserEmail()%>" readonly>
                                            </div>
											<div class="starRev">
												<span class="starR"></span> 
												<span class="starR"></span>
												<span class="starR"></span> 
												<span class="starR"></span>
												<span class="starR"></span> 
											</div>
										</div>
                                        <div class="form-group">
                                            <textarea class="form-control mb-10" rows="5" name="rmessage" placeholder="Messege" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'"
                                            required=""></textarea>
                                        </div>
                                        <button type="reset" class="com_btn">작성 취소</button>
                                        <button type="submit" class="com_btn" onclick="reviewin(this)">작성 완료</button>
                                    </form>
                                </div>
                                <% } %>
							</div>
						</div>
					</div>
				</section>
				<!--######## End post-content Area ########-->
			</div>
			<!-- #tab2 -->

			<div id="tab3" class="tab_content" style="padding-left:-10px;" >
				<p class="text1" style="padding-top:40px !important;">문의 및 상담</p>
				<div class="qna_notice">
					<br>
					<p>
						* 이 곳은 간단한 날짜 상담 혹은 호텔에 오기 전 오시기 힘드실 때 문의 및 상담하는 곳입니다. 자세한 문의가
						필요하신 분께서는 전화 상담 부탁드립니다. <br>
						<br> * 답변은 1~3 일 이내 작성됩니다.<br>
						<br> * 가급적 전화/카카오톡/게시판 문의로 날짜 상담 후 예약메뉴 이용 부탁드립니다. <br>
						<br> * 카카오톡, 전화 문의가 조금 더 빠르니 이용하시길 바랍니다.
					</p>
				</div>
				
				<hr style="width: 1000px;">
				<% if(qlist != null) { %>
				<div class="qna_wrap">
				<% for(QComment qco : qlist){ %>
					<div class="que_box" style="width:1000px;" id="divv">
						<!-- <img src="img/que.jpg">&nbsp;&nbsp;&nbsp;&nbsp; -->
						<% if(qco.getClevel() == 1) {%>
						<button onclick="">질문</button>
						<% } else if(qco.getClevel() == 2 ) { %>
						<button class="button1">답변</button>
						<% } %>
						<span class="ffont-style"><%= qco.getCname() %></span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= qco.getCdate() %>
							<span >
							<% if(m != null && m.getUserEmail().equals(qco.getCemail())) { %>
								<input type="hidden" name="cno" value="<%=qco.getCno() %>">
                            	<input type="button" class="updateBtn primary-btn header-btn " style="margin-left:5px; padding-left:6px; line-height: 30px;
												width:40px; height:30px;" onclick="updateReply(this);"  value="수정">
                            	<input type="button" class="updateConfirm primary-btn header-btn " style="margin-left:5px; padding-left:6px; line-height: 30px;
												width:65px; height:30px; display:none;" onclick="updateConfirm(this);" value="수정완료">
                            	<input type="button" class="deleteBtn primary-btn header-btn " style="padding-left:6px; line-height: 30px;
												width:40px; height:30px;" onclick="deleteReply(this);" value="삭제">
								
                            	
                            	
                            	
							<% }else if(m!= null && m.getUserRoles() == 200 && qco.getClevel() < 3 && mk.getMarketEmail().equals(m.getUserEmail())) {%>
								<input type="hidden" name="name" value="<%=m.getUserName() %>"/>
								<input type="hidden" name="refcno" value="<%=qco.getCno() %>" />
								<input type="hidden" name="clevel" value="<%=qco.getClevel() %>" />
								<input type="button" id = "reBtn" class="insertBtn primary-btn header-btn " style="margin-left:5px; padding-left:6px; line-height: 30px;
												width:40px; height:30px;" onclick="reComment(this);"
								value = "답글">
								<input type="button" class="insertConfirm primary-btn header-btn " 
								style="margin-left:5px; padding-left:6px; line-height: 30px; width:65px; height:30px; display:none;" onclick="reConfirm(this);" value="답글완료">
								
							<% } %>
							
							</span>
							<br>
							<!-- ######################################################################################## -->
						<%-- <textarea class="text-style" id="comment-text" readonly="readonly">
						<%= qco.getCcontent() %>
						</textarea>  textArea 안에 탭이 들어가 있어서 그것까지 인식해 버렸네요 --%>
						<textarea class="text-style 
						<% if(qco.getClevel() == 2) {%>text22-style<% } %>"
						 id="comment-text" readonly="readonly"><%= qco.getCcontent() %></textarea>
						<hr style="width: 1000px;">
					</div>
					<%-- <div class="ans_box">
						<button onclick="">답변</button>
						<input type="hidden" name="name" value="<%=qco.getCname() %>">
						<input type="hidden" name="email" value="<%=qco.getCemail() %>">
						&nbsp;&nbsp;&nbsp;&nbsp; <span> <%=qco.getCname() %>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=qco.getCdate() %>
							</span><br>
						<br>
						<textarea class="text-style" id="comment-text" readonly="readonly"><%= qco.getCcontent() %></textarea>
						<hr style="width: 1000px;">
					</div> --%>
					<%} }else { %>
					<p style="text-align:center;">문의가 없습니다. 문의를 작성해주세요!</p>
					<% } %>
					<% if(m != null && m.getUserRoles() != 200) {%>
					 <div class="comment-form" style="width: 1000px;">
                        <h4>문의 작성</h4>
                        <form action="/PETNER/insert.qc" method="post">
                        	<input type="hidden" name="mno" value="<%=mk.getMarketId()%>"/>
							<input type="hidden" name="refcno" value="0" />
							<input type="hidden" name="clevel" value="1" />
                            <div class="form-group form-inline">
                                <div class="form-group col-lg-6 col-md-12 name">
                                    <input type="text" class="form-control" id="name" name="name" value="<%= m.getUserName()%>" readonly>
                                </div>
                                <div class="form-group col-lg-6 col-md-12 email">
                                    <input type="email" class="form-control" id="email" name="email" value="<%=m.getUserEmail()%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <textarea class="form-control mb-10" rows="5" name="message" placeholder="Messege" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'"
                                required=""></textarea>
                            </div>
                            <button type="reset" class="com_btn">작성 취소</button>
                            <button type="submit" class="com_btn">작성 완료</button>
                        </form>
                    </div>
                    <% } %>
				</div>
			</div>
			<!-- #tab3 -->
		</div>
		<!-- .tab_container -->
	</div>
	<!-- #container -->

	<div type="text" id="mapX" value="<%=md.getMapx()%>" hidden></div>
	<div type="text" id="mapY" value="<%=md.getMapy()%>" hidden></div>
	


	<!--map-->
	<script>
	
	/*** 별점 ****************************************************/
	$('.starRev span').click(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  
			var star = $('div.starRev').children('span.starR.on').length;
			
			var rstartext = document.getElementById('rstar');
			
			rstartext.value=star;
		  
		  return false;
		});
	
	/* 별점 보여주기 */
/* 	$(function(){
		var star = $('input[name="viewstar"]').val();
		
		var starhtml = "";
		
		for(var i=0; i<star; i++){
			starhtml += '<span class="starR on" style="width:15px; height:15px;"></span>';
		}
		for(var i=0; i<5-star; i++){
			starhtml += '<span class="starR" style="width:15px; height:15px;"></span>';
		}
		
		$('.reviewstar').append(starhtml);
	}); */
	/** 후기부분 *******************************************/
		function updateReview(obj){
		
		$(obj).parent().parent().parent().find('textarea')
		.removeAttr('readonly');
			/* $('#comment-text')
			.removeAttr('readonly');
 */
			// 수정 완료 버튼을 화면 보이게 하기
			$(obj).siblings('.updateReConfirm').css('display','inline');
		
			// 수정하기 버튼 숨기기
			$(obj).css('display', 'none');
	}
		
		// 후기 수정
		function updateReConfirm(obj) {
			var content = 
				$(obj).parent().parent().parent().find('textarea').val();
			
			var rno = $(obj).siblings('input').val();
			
			var rmno = '<%=mk.getMarketId()%>';
			
			location.href="/PETNER/reviewUp.rv?"
						+"rno="+rno+"&rmno="+rmno+"&rcontent="+content;
		}
		
		// 후기 삭제
		function deleteReview(obj) {
			
			if (confirm("정말 삭제하시겠습니까??") == true){    //확인
				var rno = $(obj).siblings('input').val();
				
				var rmno = '<%=mk.getMarketId()%>';
				
				location.href="/PETNER/reviewDel.rv?"
					+"rno="+rno+"&rmno="+rmno;

			}else{   //취소

			    return;
			}
			
		}
		
		// 후기 답글
		function reReview(obj) {
			$(obj).siblings('.replyMarket').css('display','inline');
			
			$(obj).css('display', 'none');
			
			//입력 공간 만들기
			var htmlForm =
				'<%if (m != null) {%>'
				+ '<img src="/PETNER/resources/img/shop_icon2.png" style="margin-left:20px; width:25px !important; height:25px !important;">'
				+ '<a><span class="ffont-style" style="padding-left:20px !important;">'
				+ '<%=m.getUserName()%>'
				+ '</span></a>'

				+ '<textarea id="rtextarea" class="text22-style" style="height: 60px;" cols="105" rows="3" placeholder="답글을 작성해주세요." required=""></textarea>'
				/* + '<td>'
				+ '<input type="button" style="height: 60px; margin-top: 15px;" class="insertConfirm" onclick="reConfirm(this);" value="답글완료">'
				+ '</td>' */
				+ '<hr>'
				+ '<%}%>'
			;
		
		$(obj).parents('#reviewww').append(htmlForm);
		}
		
		function replyMarket(obj) {
			<% if(m !=null) { %>
			var refrno = Number($(obj).siblings('input[name="refrno"]').val());
			var rlevel = Number($(obj).siblings('input[name="rlevel"]').val()) + 1;
			
			var rmno = '<%=mk.getMarketId()%>';
			
			var star = 0;
			
			var parent = $(obj).parent();
			var grandparent = parent.parent();
			var siblingsTR = grandparent.siblings().last();
			
			/* var content = siblingsTR.find('#rtextarea').val(); */
			var content = $('#rtextarea').val();
			
			
			location.href='/PETNER/reviewIn.rv'
		        	+ '?rname=<%=m.getUserName()%>'
		        	+ '&remail=<%=m.getUserEmail()%>' 
					+ '&rmessage=' + content
					+ '&rmno=' + rmno 
					+ '&refrno=' + refrno 
					+ '&rlevel=' + rlevel
					+ '&rstar=' + star;
			<% } %>

		}
		
	/** 문의부분 *******************************************/
		function updateReply(obj) {
			// 현재 위치와 가장 근접한 textarea 접근하기
		$(obj).parent().parent().find('textarea')
		.removeAttr('readonly');
			/* $('#comment-text')
			.removeAttr('readonly');
 */
			// 수정 완료 버튼을 화면 보이게 하기
			$(obj).siblings('.updateConfirm').css('display','inline');
		
			// 수정하기 버튼 숨기기
			$(obj).css('display', 'none');
		}
		
		function updateConfirm(obj) {
			// 댓글의 내용 가져오기
			
			var content
			  = $(obj).parent().parent().find('textarea').val();
			
			// 댓글의 번호 가져오기
			var cno = $(obj).siblings('input').val();
			
			// 게시글 번호 가져오기
			var mno = '<%=mk.getMarketId()%>';
			
			location.href="/PETNER/coUpdate.co?"
					 +"cno="+cno+"&mno="+mno+"&ccontent="+content;
		}
		
		function deleteReply(obj) {
			if (confirm("정말 삭제하시겠습니까??") == true){    //확인
				// 댓글의 번호 가져오기
				var cno = $(obj).siblings('input').val();
				
				// 게시글 번호 가져오기
				var mno = '<%=mk.getMarketId()%>';
				
				location.href="/PETNER/coDelete.co?"
				+"cno="+cno+"&mno="+mno;

			}else{   //취소

			    return;
			}
			
		}
		
		function reComment(obj){
			
			// 추가 완료 버튼을 화면 보이게 하기
			$(obj).siblings('.insertConfirm').css('display','inline');
			
			// 클릭한 버튼 숨기기
			$(obj).css('display', 'none');
			
			// 내용 입력 공간 만들기
			var htmlForm =
					'<% if(m!=null) {%>'
					+ '<table>'
					+ '<tr class="ans_box">'
					+ '<td>'
					+ '<button onclick="">답변</button>'
					+ '<span class="ffont-style">'
					+ '<%= m.getUserName()%>'
					+ '</span>'
					+ '</td>'
					+ '</tr>'
					+ '<tr>'
					+ '<td>'
					+ '<textarea id="ctextarea" class="text22-style" style="height: 60px;" cols="105" rows="3" placeholder="답글을 작성해주세요." required=""></textarea>'
					+ '</td>'
					/* + '<td>'
					+ '<input type="button" style="height: 60px; margin-top: 15px;" class="insertConfirm" onclick="reConfirm(this);" value="답글완료">'
					+ '</td>' */
					+ '</tr>'
					+ '</table>'
					+ '<hr style="width:1000px;">'
					+ '<% } %>'
				;
			
			$(obj).parents('#divv').append(htmlForm);
			
		}
		
		function reConfirm(obj) {
			<% if(m != null) { %>
			// 답글의 내용 가져오기
			
			// 참조할 댓글의 번호 가져오기
			/* var refcno = $("input[name=refcno]").val();
			var level = Number($("input[name=clevel]").val()) + 1;  */
 			var refcno = $(obj).siblings('input[name="refcno"]').val();
			var level = Number($(obj).siblings('input[name="clevel"]').val()) + 1;  
			
			// console.log(refcno + " : " + level);
			
			// 게시글 번호 가져오기
			var mno = '<%=mk.getMarketId()%>';
			
			var parent = $(obj).parent();
			var grandparent = parent.parent();
			var siblingsTR = grandparent.siblings().last();
			
			var content = siblingsTR.find('#ctextarea').val();
			var content = $('#ctextarea').val();
			
			
			location.href='/PETNER/insert.qc'
		           + '?name=<%= m.getUserName() %>'
		           + '&email=<%= m.getUserEmail() %>' 
		           + '&message=' + content
		           + '&mno=' + mno
		           + '&refcno=' + refcno
		           + '&clevel=' + level;
		 <% } %>          
		           
		}
		
		/* 구글 지도 */
/* 		$(document)
				.ready(
						function() {

							var center = new google.maps.LatLng(37.549286,
									127.075156);

							var mapArea = document.querySelector('#map'); //google map은 jQuery사용안됨
							var map = new google.maps.Map(mapArea, {
								mapTypeId : google.maps.MapTypeId.ROADMAP,
								zoom : 17,
								center : center
							}); //어디에 지도를 뿌릴 것인지

							marker.setMap(map);
						}); */
						
						/* 네이버 지도 */
/* 						var mapx = $('#mapX').val();
						var mapy = $('#mapY').val();
 */						
 						var mapOptions = {
							    center: new naver.maps.LatLng(<%=md.getMapx()%>, <%=md.getMapy()%>),
							    zoom: 10
							};
 						var map = new naver.maps.Map('map', {
 						    center: new naver.maps.LatLng(<%=md.getMapx()%>, <%=md.getMapy()%>),
 						    zoom: 15
 						});

 						var marker = new naver.maps.Marker({
 						    position: new naver.maps.LatLng(<%=md.getMapx()%>, <%=md.getMapy()%>),
 						    map: map
						});
							
							/* 카카오 지도 */
/* 							var container = document.getElementById('map');
							var options = {
								center: new kakao.maps.LatLng(33.450701, 126.570667),
								level: 3
							};

							var map = new kakao.maps.Map(container, options); */
	</script>
	<!--map end-->
	
	
	
	<!--tap-->
	<script>
/* 		App::after(function($request, $response)
			{

			    $content = $response->getContent();

			    $contentLength = strlen($content);

			    $response->header('Content-Length', $contentLength);

			}); */
	
		$(function() {

			$(".tab_content").hide();
			$(".tab_content:first").show();

			$("ul.tabs li").click(function() {
				$("ul.tabs li").removeClass("active").css("color", "#333");
				//$(this).addClass("active").css({"color": "darkred","font-weight": "bolder"});
				$(this).addClass("active").css("color", "green");
				$(".tab_content").hide()
				var activeTab = $(this).attr("rel");
				$("#" + activeTab).fadeIn()
			});
		});
			

			
			
	</script>
	<!--tap end-->
	<%@ include file="/views/common/footer.jsp"%>


	<!--end tab area-->
</body>
</html>