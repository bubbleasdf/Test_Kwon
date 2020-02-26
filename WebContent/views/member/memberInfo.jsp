<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Member m = (Member)session.getAttribute("member");
%>
<!--  회원 정보 변경 페이지 -->

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
		<title>정보 변경</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<link rel="stylesheet" href="/PETNER/resources/css/member/main_hyon.css" type="text/css">
		
		<link rel="stylesheet" href="/PETNER/resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="/PETNER/resources/css/bootstrap.css" type="text/css">
		<link rel="stylesheet" href="/PETNER/resources/css/main.css" type="text/css">
		
		<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
		<script src="/PETNER/resources/js/vendor/bootstrap.min.js" type="text/javascript"></script>
		
		
		
	</head>
	
	
	<body>


    <!--tap-->
    <script>

        $(function () {

            $(".tab_content").hide();
            $(".tab_content:first").show();

            $("ul.tabs li").click(function () {
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


    <!-- Start Align Area -->
    <section class="whole-wrap">
        <div class="container">


 <!--start tab area-->
    <div id="t_container">
        <div class="tab_container">
            <div id="tab1" class="tab_content"><br>
            
                <div class="map_text">
                    
                    <div class="progress-table-wrap" style="text-align: center;">
                        <form action="/PETNER/pUpdate.me" method="post" id="updateForm">
                            <div class="mt-10">
                                <input type="text" name="USER_EMAIL" required class="single-input" disabled
                                    style="background: lightgray;" value="<%=m.getUserEmail() %>">
                            </div>
                            <div class="mt-10">
                                <input type="text" name="USER_NAME" required class="single-input" value="<%=m.getUserName() %>">
                            </div>
                            
                            <div class="mt-10">
                                <input type="phone" name="USER_PHONE" required class="single-input"value="<%=m.getUserPhone() %>">
                            </div>
                            
                            <div class="mt-10">
                                <input type="password" name="userPwd" required class="single-input" placeholder="기존 비밀번호"  required>
                            </div>
                            <div class="mt-10">
                                <input type="password" name="usernPwd1" required class="single-input" placeholder="새로운 비밀번호">
                            </div>
                            <div class="mt-10">
                                <input type="password" name="usernPwd2" required class="single-input" placeholder="새로운 비밀번호 확인">
                            </div>
                            
                            
                            <br>
                            <a href="#" onclick="Pupdate();"  style="background: lightgray;" class="genric-btn success">수정완료</a>
                            <a href="mypage.jsp" style="background: lightgray;" class="genric-btn danger">취소</a>
                        </form>
                    </div>
                </div>
        </div>
        <!-- .tab_container -->
    </div>
    <!-- #container -->
</div>
	
	<script>
		function Pupdate(){
			
			//수정시에도 제약조건을 해준다.
			
			
			$('#updateForm').submit();
		}
	</script>



    <!--######## start footer Area ########-->
			<%@ include file="../common/footer.jsp" %>
    <!--######## End footer Area ########-->



</body>

</html>