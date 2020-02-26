<%@page import="com.kh.petner.market.model.vo.Market"%>
<%@page import="com.kh.petner.hotel.model.vo.HotelPageInfo"%>
<%@page import="com.kh.petner.hotel.model.vo.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  ArrayList<Market> list = (ArrayList)request.getAttribute("list");

    ArrayList<Market> dblist = (ArrayList)request.getAttribute("dblist");
    
    String Market = (String)request.getAttribute("Market");
    		
	HotelPageInfo hpi = (HotelPageInfo)request.getAttribute("hpi");
	int listCount = hpi.getListCount();
	int currentPage = hpi.getCurrentPage();
	int maxPage = hpi.getMaxPage();
	int startPage = hpi.getStartPage();
	int endPage = hpi.getEndPage();
	
	ArrayList<Market> aalist = new ArrayList<Market>();
	
	if(list != null){
		aalist = list;	
	}else if(dblist != null){
		aalist = dblist;
	}
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
	<title>Petner+</title>

	<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
	<!--
			CSS
			============================================= -->
	<link rel="stylesheet" href="../../resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="../../resources/css/bootstrap.css">
    <link rel="stylesheet" href="../../resources/css/main.css">
    <script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
    <style id="myobject">
    
		
    .overlay {
        position: absolute;
        left: 0;
        right: 0;
        top: 0;
        bottom: 0; }

    .blog-banner-area  {
     /* background: url(/PETNER/resources/img/hotel/HOTEL.jpg) no-repeat center fixed !important;  */
     	background:  no-repeat center fixed; 
     	background-size: cover;
        min-height:500px; 
        }
  .blog-banner-area .banner-content h1 {
    font-size: 48px;
    line-height: 54px;
    margin: 0; }
    @media (max-width: 768px) {
      .blog-banner-area .banner-content h1 {
        font-size: 35px;
        line-height: 40px; } }
    @media (max-width: 414px) {
      .blog-banner-area .banner-content h1 {
        font-size: 30px; } }
  .blog-banner-area .banner-content p {
    font-size: 16px;
    margin: 40px 20px; }
    @media (max-width: 768px) {
      .blog-banner-area .banner-content p {
        margin: 10px; } }
  .blog-banner-area .banner-content .primary-btn {
    background: #fff;
    color: #222222; }
    .blog-banner-area .banner-content .primary-btn:hover {
      background: #3face4;
      color: #ffffff; }

    .fullscreen {
    height: 740px; }
    @media (max-width: 767.98px) {
        .fullscreen {
        height: 600px; } }
    @media (max-width: 768px) {
        .fullscreen {
        height: 400px; } }

    .overlay-bg {
    background-color: rgba(34, 34, 34, 0.27); }

    </style>
</head>

<body>
		<script>
        $(function(){
            /* alert("제가 최종 축약형 제이쿼리입니다."); */
           $(".blog-banner-area").css('background-image','url(/PETNER/resources/img/hotel/<%=request.getParameter("Market")%>.jpg)'); 
		});
		</script> 

		<%@ include file="../common/header.jsp" %> 
		<!--######## start banner Area ########-->
		<!--  메뉴바랑 겹치는 부분 제거 -->
		<div style="padding-top:150px;"></div>
		
	<!--######## Start Header Area ########-->

	<!--######## End Header Area ########-->




	<!--######## start banner Area ########-->
	<section class="blog-banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row text-left d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
				<!-- <button style="background : pink;" onclick="kimsunin()" > <h1>HOTEL</h1> </button> -->
				<a href="/PETNER/sunin.go"><h1><%=request.getParameter("Market")%></h1></a>
<!-- 					<h1 class="text-white text-uppercase  ">
						HOTEL
					</h1> -->
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->

	<script>
		function kimsunin(){
	
		}
	</script>


	<!-- Start CheckBox -->
	<section class="whole-wrap">
		<div class="container">

			<div class="section-top-border">
				<div class="row">
					<div class="col-lg-12 col-md-12">
						<h3 class="mb-30">지역찾기</h3>
						<div class="checkbox-background">
							<br>&nbsp;&nbsp;
							<input type="radio" name="location" id="gangnam"  value="강남,송파,서초">
							<label for="gangnam">강남,송파,서초</label>
							&nbsp;&nbsp;
							<input type="radio" name="location" id="gangseo" value="영등포,강서">
							<label for="gangseo" >영등포,강서</label>
							&nbsp;&nbsp;
							<input type="radio" name="location" id="hongdae" value="홍대,용산,종로">
							<label for="hongdae" >홍대,용산,종로</label>
							&nbsp;&nbsp;
							<input type="radio" name="location" id="other" value="기타">
							<label for="other" >기타</label>
							<button class="search-btn" onclick="searchLocation()">검색</button>
							<br>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 marg30">
						<div class="search-div">
							<input type="text" class="search-input" placeholder="검색어를 입력하세요.">
							<button class="search-btn" onclick="searchName()" >검색</button>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 marg45 ">
						<div class="recent-completed-project1">
							<div class="filters project-filter">
								<ul>
									<li><button class="page-item" value = "temp1" onclick="selecttemp(value)" >최근등록순</button></li>
									<li><button class="page-item" value = "temp2" onclick="selecttemp(value)" >평점순</button></li>
									<li><button class="page-item" value = "temp3" onclick="selecttemp(value)" >후기순</button></li>
									<%-- <li class="page-item "><a id="sunin"  onclick= "selecttemp(tem1);"></a>
									<li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?Market=<%=request.getParameter("Market")%>'" >평점순</a></li>|
									<li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?Market=<%=request.getParameter("Market")%>'" >후기순</a></li> --%>
								</ul>
							</div>
						</div>
					</div>

					<div class="col-md-12 col">
						<hr>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End checkBox -->
	<script>
	function searchLocation(){
		location.href="<%=request.getContextPath()%>/searchHotel?loc="+$('input[type=radio]:checked').val() +"&Market=<%=request.getParameter("Market") %>";
	}
	function searchName(){
		location.href="<%=request.getContextPath()%>/searchHotel?hon="+$('.search-input').val()+"&Market=<%=request.getParameter("Market") %>";
		<%-- location.href="<%=request.getContextPath()%>/searchHotel?hon="+$('.search-input').val(); --%>
	}
	function selecttemp(value){
		var temp = value
		console.log("temp : " + temp);
		location.href="<%=request.getContextPath()%>/hotelDbServlet?Market=<%=request.getParameter("Market")%>&temp="+temp;
		
	}

	</script>

	<!--######## Start Latest News Area ########-->
	<section class="latest-news-area section-gap-hr">
		<div class="container">
			<div class="row">
			 <% for(Market h : aalist) { %> 
				<div class="col-md-6">
					<div class="single-newss card">
						<img class="card-top-img " height="400px" src="/PETNER/resources/adminUploadFiles/<%=h.getMarketMainPhoto()%>" alt="hospital image">
						<div class="card-body">
							<h4 class="card-title">
								<a href="hotel_information.html">
									 <%=h.getMarketName()%> 
								</a>
							</h4>
							<%-- <% for(int i=0; i<h.getHotel_star(); i++) { %> --%>
							<!-- <i class="fa fa-star star"></i> -->
							
							<!-- Integer.parseInt(request.getAttribute("star")); -->
							<% for(int i=0; i < h.getMarketStar() ; i++) { %>
							<span class="fa fa-star star" style="width:15px; height:15px;"></span> 
							<% } %>
<%-- 							<% for(int i=0; i< h.getMarketStar() ; i++) { %>
							<span class="fa fa-star star" style="width:15px; height:15px;"></span> 
							<% } %> --%>
							
							
							
							<%-- <% } %> --%>
								<span>&nbsp&nbsp후기 <%=h.getReviewCount()%>개</span>
							<p class="card-text">
								<br>
								<img src="/PETNER/resources/img/hotel/pin.png" width="15px" height="15px">
								<%=h.getMarketPlace()%>
<!-- 								<br>이용시간 평일 00:00 ~ 24:00<br>
								연중휴무</p> -->
								<a href="MarketIN.mk?mno=<%=h.getMarketId() %>" class="primary-btn header-btn text-capitalize mt-10" style="float: right;">예약하기</a>
						</div>    
					</div>
				</div>
				<% } %>


		
				<!-- 페이징 부분 -->
			<%  if(list != null){  %>
			<nav class="col-md-12 blog-pagination justify-content-center d-flex">
               <ul class="pagination">
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-left"></span>
                        </span>
                     </a>
                  </li>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/searchHotel?currentPage=1 &hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>'" class="page-link"><<</a></li>
                  <%  if(currentPage <= 1){  %>
                  <li class="page-item hiddeee"><a href="#" class="page-link"><</a></li>
                  <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/searchHotel?currentPage=<%=currentPage - 1 %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>'" class="page-link"><</a></li>
                  <%  } %>
                  
                  
                  <% for(int p = startPage; p <= endPage; p++){
                   if(p == currentPage){    
               %>
                      <li class="page-item" id ="noclick"><a href="#" class="page-link" style="background : pink;"><%= p %></a></li> 
                  <%      }else{ %> 
                         <li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/searchHotel?currentPage=<%= p %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>'" class="page-link"><%= p %></a></li>
                   <%      } %>
               <% } %>
         
               <%  if(currentPage >= maxPage){  %>
               <li class="page-item hiddeee"><a href="#" class="page-link">></a></li>
               <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/searchHotel?currentPage=<%=currentPage + 1 %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>'" class="page-link">></a></li>
                  <%  } %>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/searchHotel?currentPage=<%= maxPage %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>'" class="page-link">>></a></li>
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-right"></span>
                        </span>
                     </a>
                  </li>
               </ul>
            </nav>
            <%  } %>
            				<!-- 페이징 부분 -->
			<% if(dblist != null){  %>
			<nav class="col-md-12 blog-pagination justify-content-center d-flex">
               <ul class="pagination">
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-left"></span>
                        </span>
                     </a>
                  </li>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?currentPage=1 &hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>&temp=<%=request.getParameter("temp")%>'" class="page-link"><<</a></li>
                  <%  if(currentPage <= 1){  %>
                  <li class="page-item hiddeee"><a href="#" class="page-link"><</a></li>
                  <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?currentPage=<%=currentPage - 1 %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>&temp=<%=request.getParameter("temp")%>'" class="page-link"><</a></li>
                  <%  } %>
                  
                  
                  <% for(int p = startPage; p <= endPage; p++){
                   if(p == currentPage){    
               %>
                      <li class="page-item" id ="noclick"><a href="#" class="page-link" style="background : pink;"><%= p %></a></li> 
                  <%      }else{ %> 
                         <li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?currentPage=<%= p %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>&temp=<%=request.getParameter("temp")%>'" class="page-link"><%= p %></a></li>
                   <%      } %>
               <% } %>
         
               <%  if(currentPage >= maxPage){  %>
               <li class="page-item hiddeee"><a href="#" class="page-link">></a></li>
               <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?currentPage=<%=currentPage + 1 %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>&temp=<%=request.getParameter("temp")%>'" class="page-link">></a></li>
                  <%  } %>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/hotelDbServlet?currentPage=<%= maxPage %>&hon=<%=request.getParameter("hon") %>&Market=<%=request.getParameter("Market") %>&temp=<%=request.getParameter("temp")%>'" class="page-link">>></a></li>
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-right"></span>
                        </span>
                     </a>
                  </li>
               </ul>
            </nav>
            <%  } %>
			</div>
		</div>
	</section>
	
	<!--######## End Latest News Area ########-->





	<!--######## start footer Area ########-->

	<!--######## End footer Area ########-->


	<%@ include file="../common/footer.jsp" %>



</body>

</html>