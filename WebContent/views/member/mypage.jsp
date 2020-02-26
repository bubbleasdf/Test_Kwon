<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member mp = (Member)session.getAttribute("member"); 
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
		
		<title>My Page</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
		<script src="/PETNER/resources/js/vendor/bootstrap.min.js" type="text/javascript"></script>
		
		<link rel="stylesheet" href="/PETNER/resources/css/main_hyon.css" type="text/css">
		
		<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightgallery/1.6.11/css/lightgallery.min.css">
	
	
		<link rel="stylesheet" href="/PETNER/resources/css/font-awesome.min.css">
		<link rel="stylesheet" href="/PETNER/resources/css/bootstrap.css" type="text/css">
		<link rel="stylesheet" href="/PETNER/resources/css/main.css" type="text/css">
		
		
	</head>
	
	
	<body>
		<%@ include file="/views/common/header.jsp" %> 
	<!--######## start banner Area ########-->
	<!--  메뉴바랑 겹치는 부분 제거 -->
	<div style="padding-top:150px;"></div>
	
    <!--tap-->
    <script>

     $('document').ready(function () {
    	 
    	 var $row = $('<div class="row>"');
    	 var $p = $('<p>').text('textValue');
    	 
    	 
    	 $row.append($p);
    	 
    	 
    	 console.log($row);
    	 
    	 
    	$('#tab_container').load("tab/tab1.jsp");

    	// $('.tab_Chat').load("tab/chat.jsp");

    	
    	//tab을 눌렀을 때
        $("ul.tabs li").click(function () {
        	$("#tab_container").html("");

            $("ul.tabs li").removeClass("active").css("color", "#333");
            $(this).addClass("active").css("color", "green");

            console.log($(this).attr('rel'));
            console.log($('ul.tabs li.active').attr('rel'));

            var taburl="tab/"+$('ul.tabs li.active').attr('rel')+".jsp?userEmail=<%= mp.getUserEmail() %>";
			var userEmail = '<%= mp.getUserEmail() %>';
            
            if($('ul.tabs li.active').attr('rel') == 'tab3'){
				console.log("tab2");
				console.log('<%= mp.getUserEmail() %>');
				console.log(userEmail);
				
				/* 
				$("#tab_container")
				.load('/PETNER/QNAUserlist.go?userEmail='+userEmail);
				$.ready
				$("#tab_container").load("tab/tab3.jsp");
				 */
			 
				 $.ajax({
					 url:"/PETNER/QNAUserlist.go"
					 , method: "post"
					 , data:{userEmail:userEmail}
				 	, success:function(data){
				 		$("#tab_container").load("tab/tab3.jsp",function(){
							console.log('tab3.jsp 켜졌어염.!!!!!!!!!!!!!!');
							$("#noticeArea td").mouseenter(function(){
								$(this).parent().css({"background":"#BBDEFB", "cursor":"pointer"});
							}).mouseout(function(){
								$(this).parent().css({"background":"white"});
							}).click(function(){
								/* console.log($(this).parent().children().eq(0)text()); */
								var qno = $(this).parent().children().eq(0).text();
								location.href="<%=request.getContextPath()%>/QNASelectOne.go?qno="+qno;
							});
						});
						 $("#noclick").bind('click', false);
				 	}
				 	, error:function(data){
				 		console.log("에라에라 data : "+data);
				 	}
				 }); //ajax
				
				
				
				
			}else if($('ul.tabs li.active').attr('rel') == 'tab2'){
				console.log("Tab2");
				console.log('<%= mp.getUserEmail() %>');
				
				
				<%-- 
				$("#tab_container").load('/PETNER/rList.me?userEmail=<%=mp.getUserEmail()%>');
				$("#tab_container").load("tab/tab2.jsp");
		
				 --%>
				
				 $.ajax({
					 url:"/PETNER/rList.me"
					 , method: "post"
					 , data:{userEmail:userEmail}
				 	, success:function(data){
				 		$("#tab_container").load("tab/tab2.jsp",function(){
							console.log('tab2.jsp 켜졌어염.!!!!!!!!!!!!!!');
							$("#noticeArea td").mouseenter(function(){
								$(this).parent().css({"background":"#BBDEFB", "cursor":"pointer"});
							}).mouseout(function(){
								$(this).parent().css({"background":"white"});
							}).click(function(){
								/* console.log($(this).parent().children().eq(0)text()); */
								var qno = $(this).parent().children().eq(0).text();
								location.href="<%=request.getContextPath()%>/QNASelectOne.go?qno="+qno;
							});
						});
				 	}//success
				 	, error:function(data){
				 		console.log("에라에라 data : "+data);
				 	}
				 }); //ajax
				
				
				
				
				
			}else if($('ul.tabs li.active').attr('rel') == 'tab1'){
				console.log("tab1")
				$('#tab_container').load("tab/tab1.jsp");
			}
            
            //$("#tab_container").load("tab/"+$('ul.tabs li.active').attr('rel')+".jsp");
            
			
            $("#tab_container").fadeIn();

        });
    });


        //펫 정보 수정 페이지로 이동
        function updatePet(petName){
        	location.href="<%=request.getContextPath()%>/pSel.pe?petName="+petName;
        }


        //펫 삭제
        function deletePet(petName){

        	location.href="/PETNER/pDelete.pe?petName="+petName;
        }
        
        //채팅창 띄우기
        function tab_Chat(){
        	$(this).hide();
        }

    </script>
    <!--tap end-->


    <!-- Start Align Area -->
    <section class="whole-wrap">
        <div class="container" >


 <!--start tab area-->
    
    	<div class="container" style="width:100%;">
	        <ul class="tabs" style="width:100%;">
	            <li rel="tab1">회원 정보 관리</li>
	            <li rel="tab2">호텔 예약 조회</li>
	            <li rel="tab3">1:1 문의 내역</li>
	            
	            <!-- 
	            <li rel="tab5">
	            펫트너 월드
	            <a class="btn btn-default" href="tab/chat.jsp" onclick="tab_Chat(); window.open(this.href,'','width=370, height=720'); return false;">Open</a>
	            </li>
	             -->
	             
	        </ul>
    	</div> <!-- container.tabs -->

	    <div class="container">
	        <div id="tab_container" style="width:100%;">
		        	<!-- 요기에 불러옴 -->
	
	        </div> <!-- .tab_container -->
	    </div><!-- container -->
	
	

</div> <!-- container -->
</section>


<script>
	function deleteMember(){
		 if (confirm("정말 탈퇴하시겠습니까??") == true){    //확인
			 $('#delForm').submit();
		 }else{   //취소
		     return false;
		 }
		 
	}//deleteMember
	

</script>

</body>

</html>