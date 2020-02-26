<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/small_logo.jpg">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>P e t n e r +</title>

	<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
	<!-- CSS
			============================================= -->
	<link rel="stylesheet" href="/petner/resources/css/linearicons.css">
	<link rel="stylesheet" href="/petner/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/petner/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/petner/resources/css/magnific-popup.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/1.6.11/css/lightgallery.min.css">
	<link rel="stylesheet" href="/petner/resources/css/nice-select.css">
	<link rel="stylesheet" href="/petner/resources/css/animate.min.css">
	<link rel="stylesheet" href="/petner/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="/petner/resources/css/main.css">

	<!-- Custom fonts for this template-->
	<link href="/petner/resources/vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	
	<link href="/petner/resources/css/sb-admin-2.min.css" rel="stylesheet">

	<script src="/petner/resources/js/vendor/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	 crossorigin="anonymous"></script>
	<script src="/petner/resources/js/vendor/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
	<script src="/petner/resources/js/easing.min.js"></script>
	<script src="/petner/resources/js/hoverIntent.js"></script>
	<script src="/petner/resources/js/superfish.min.js"></script>
	<script src="/petner/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="/petner/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="/petner/resources/js/owl.carousel.min.js"></script>
	<script src="/petner/resources/js/isotope.pkgd.min.js"></script>
	<script src="/petner/resources/js/owl.carousel.min.js"></script>
	<script src="/petner/resources/js/jquery.nice-select.min.js"></script>
	<script src="/petner/resources/js/jquery.lightbox.js"></script>
	<script src="/petner/resources/js/mail-script.js"></script>
  	<script src="/petner/resources/js/main.js"></script>
  
  
  <script src="/petner/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="/petner/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <script src="/petner/resources/js/demo/datatables-demo.js"></script>

</head>
<body>
<!--################ Start Header Area ########-->
	<header id="header" id="home">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-4 no-padding">
						<div class="header-top-left"  style="border-right: none;">
							<a href="">
								<i class="fa fa-phone"></i>
								02-777-7777
							</a>
						</div>
					</div>
					<div class="col-lg-6 col-sm-6 col-8 header-top-right no-padding">
						
						<ul style="border-right: none;">
							<li>
								<a href="views/admin/admin.jsp">Admin Page</a> |&nbsp;&nbsp; <a href="#" data-target="#modal" data-toggle="modal">login</a> | <a style="padding-left:10px;" href="views/main/register.jsp"> Join</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>


		<!-- 로그인 모달-->
		<div class="row" style="position: relative;">
			<div class="modal" id="modal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">

							  <div class="card-body">
								<!-- Nested Row within Card Body -->
								<div class="row">
								  
								  <div class="col-md-12">
										<div class="">  <!-- 로그인 창 사이즈 변경은 여기서 하자...-->
										  <div class="text-center ">
											<h1 class="h4 text-gray-900 mb-4">LOGIN</h1>
										  </div>

						<div class="modal-body" style="text-align: center;">
							<form class="user" action="로그인 페이지로 이동?" method="post">
								<div class="form-group">
								  <input type="email" class="form-control form-control-user" id="exampleInputEmail" 
								  aria-describedby="emailHelp" placeholder="이메일을 입력해주세요.">
								</div>
								<div class="form-group">
								  <input type="password" class="form-control form-control-user" id="exampleInputPassword" 
								  placeholder="비밀번호를 입력해주세요.">
								</div>
								<div class="form-group">
								  <div class="custom-control custom-checkbox small">
									<input type="checkbox" class="custom-control-input" id="customCheck">
									<label class="custom-control-label" for="customCheck">아이디 저장</label>
								  </div>
								</div>
								<a href="index.jsp class="btn btn-primary btn-user btn-block" style="background:#008000">
								  Login
								</a>
							</form>
							  <hr>
							  <div class="text-center">
								  <br>
								<a href="forgot-password.html" style="padding-right: 20px;">비밀번호 찾기</a>  
								<a href="views/main/register.jsp" style="padding-left: 20px;">회원가입</a>
							  </div>
						</div>
					</div>
				</div>
			</div>
		</div>




					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="/petner/index.jsp"><img style="width: 100px;"src="/petner/resources/img/petner_logo.jpg" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li><a href="/petner/index.jsp">Home</a></li>
						<li><a href="views/main/about.jsp">ABOUT</a></li>
						<li><a href="views/hotel/Hotel-home.jsp">HOTEL</a></li>
						<li><a href="views/hotel/Hospital-home.jsp">HOSPITAL</a>
						</li>
						<li><a href="views/beauty/Beauty-home.jsp">BEAUTY</a></li>
						<li class="menu-has-children"><a href="notice.jsp">NOTICE</a>
							<ul>
								<li><a href="/views/notice/notice.jsp">NOTICE</a></li>
								<li><a href="/views/notice/petner_faq.jsp">FAQ</a></li>
								<li><a href="/views/notice/qna.jsp">Q&A</a></li>
							</ul>
						</li>
					</ul>
				</nav>
				<!--######## #nav-menu-container -->
			</div>
		</div>
	</header>
	<!--######## End Header Area ########-->



	<hr style="margin: 0px;">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="admin2.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">관리자페이지</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>메인 페이지</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        나중에 지울거
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Components</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Components:</h6>
            <a class="collapse-item" href="buttons.html">Buttons</a>
            <a class="collapse-item" href="cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="utilities-color.html">Colors</a>
            <a class="collapse-item" href="utilities-border.html">Borders</a>
            <a class="collapse-item" href="utilities-animation.html">Animations</a>
            <a class="collapse-item" href="utilities-other.html">Other</a>
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        메뉴
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
            <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="admin_market_add.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>매장 추가</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="admin_market_table.html">
          <i class="fas fa-fw fa-table"></i>
          <span>매장 목록</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="admin_user_table.html">
          <i class="fas fa-fw fa-table"></i>
          <span>유저 목록</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

		
        

      </div>
      <!-- End of Main Content -->

     
    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->
<%@ include file="/views/common/footer.jsp" %>

</body>
</html>