<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.petner.FAQ.model.vo.FAQ, java.util.ArrayList"%>
   <% ArrayList<FAQ> list = (ArrayList<FAQ>)request.getAttribute("list"); %>
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


	<link rel="stylesheet" href="/PETNER/resources/css/hr.css">
    <!--FAQ CSS-->
    <link href="/PETNER/resources/css/board_faq.css" rel="stylesheet" type="text/css">
    
    <style>
      .blog-banner-area {
      background: url(/PETNER/resources/img/board/faq2.jpg) no-repeat bottom fixed !important;
      background-size: cover;
      min-height:420px;
      }

      .wrap {
          font-size: 14px;
          color: #5b5b5b;
          background-color: #fff;
          width: 1300px;
          margin: 0 auto;	
      }
    </style>
</head>

<body>
	<% Member m1 = (Member)session.getAttribute("member"); 
	%>
        <!--######## Start Header Area ########-->
		<%@ include file="../common/header.jsp" %> 
		<!--  메뉴바랑 겹치는 부분 제거 -->
		<div style="padding-top:150px;"></div>
        <!--######## End Header Area ########-->
    
        <!--######## start banner Area ########-->
        <section class="blog-banner-area relative" id="home">
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row text-left d-flex align-items-center justify-content-center">
                    <div class="about-content col-lg-12">
                        <h1 class="text-white text-uppercase  ">
                            FAQ
                        </h1>
                    </div>
                </div>
            </div>
        </section>
        <!--######## End banner Area ########-->
    
       <!--FAQ-->
       <div class="wrap" style="margin: 0 auto;">
            <div class="contain">
                    <div class="main-title text-center">
                            <h1 style="font-weight: 300; margin-top: 50px;">FAQ</h1>
                            
                             <% if(m1 != null){if(m1.getUserRoles() == 777) { %>
                            <button class="btn-primary btn-lg" onclick="location.href='views/FAQ/FAQInsert.jsp'">글 등록하기</button>
                              <%}} %>  
                    </div>
                    
                 <div class="tab">
                  <button class="tablinks" onclick="openfaq(event, 'faq1' , value)" value = 1 id="defaultOpen">호텔관련</button>
                  <button class="tablinks" onclick="openfaq(event, 'faq2', value)" value = 2 >병원관련</button>
                  <button class="tablinks" onclick="openfaq(event, 'faq3', value)" value = 3 >미용관련</button>
                  <button class="tablinks" onclick="openfaq(event, 'faq4', value)" value = 4 >회원관련</button>
                 </div>
                 
                <div id="faq1" class="tabcontent">
               <% 
                int hotelCount = 0;
                for(FAQ f : list) {
                  if(f.getFtype() ==1){
                	  hotelCount++;
                %> 
                <input type="hidden" name="fno" value="<%=f.getFno() %>" />
                <button class="accordion"><span class="accornumber"><%=hotelCount%></span><span class="accorq"><%=f.getTitle() %></span>
                </button>
                <div class="panel">
                <p class="accora"> <%=f.getContent()%></p>
                         <% if(m1 != null){if(m1.getUserRoles() == 777) { %>
                   
                <button onclick ="location.href='fUpno.go?fno=<%=f.getFno()%>'">수정하기</button>
               		
               			  <%}} %>  
                </div>

        
                 <%} }%> 
                
                             </div>
        <script>
        var acc = document.getElementsByClassName("accordion");
        var i;
        
        for (i = 0; i < acc.length; i++) {
          acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
              panel.style.maxHeight = null;
            } else {
              panel.style.maxHeight = panel.scrollHeight + "px";
            } 
          });
        }
        </script>

                
                
                
                <div id="faq2" class="tabcontent">
                 <% 
                int beautyCount = 0;
                for(FAQ f : list) {
               
                  if(f.getFtype() ==2){
                	  
                	  beautyCount++;
                %> 
                <input type="hidden" name="fno" value="<%=f.getFno() %>" />
                <button class="accordion accordion2"><span class="accornumber"><%=beautyCount%></span><span class="accorq"><%=f.getTitle() %></span></button>
                <div class="panel">
                <p class="accora"><%=f.getContent()%></p>
                <% if(m1 != null){if(m1.getUserRoles() == 777) { %>
                <button onclick ="location.href='fUpno.go?fno=<%=f.getFno()%>'">수정하기</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                
               			 <%}} %>  
                </div>
        
                
                 <%} }%> 
               
        <script>
        var acc = document.getElementsByClassName("accordion2");
        var i;
        
        for (i = 0; i < acc.length; i++) {
          acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
              panel.style.maxHeight = null;
            } else {
              panel.style.maxHeight = panel.scrollHeight + "px";
            } 
          });
        }
        </script>
                </div>
        
                <div id="faq3" class="tabcontent">
                
                  <% 
                int groomingCount = 0;
                for(FAQ f : list) {
               
                  if(f.getFtype() ==3){
                	  
                	  groomingCount++;
                %> 
                <button class="accordion accordion3"><span class="accornumber"><%=groomingCount %></span><span class="accorq"><%=f.getTitle() %></span></button>
                <div class="panel">
                <p class="accora"><%= f.getContent() %></p>
                <% if(m1 != null){if(m1.getUserRoles() == 777) { %>
                <button onclick ="location.href='fUpno.go?fno=<%=f.getFno()%>'">수정하기</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <%}} %>
                </div>
                
                 <%} }%> 
                  
                
        <script>
        var acc = document.getElementsByClassName("accordion3");
        var i;
        
        for (i = 0; i < acc.length; i++) {
          acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
              panel.style.maxHeight = null;
            } else {
              panel.style.maxHeight = panel.scrollHeight + "px";
            } 
          });
        }
        </script>
                </div>
                
                <div id="faq4" class="tabcontent">
                 <% 
                		int memberCount = 0;
               			 for(FAQ f : list) {
               
                  if(f.getFtype() ==4){
                	  
                	  memberCount++;
                %> 
                <button class="accordion accordion4"><span class="accornumber"><%=memberCount%></span><span class="accorq"><%=f.getTitle() %> </span></button>
                <div class="panel">
                <p class="accora"> <%=f.getContent() %>  </p>
                	<% if(m1 != null){if(m1.getUserRoles() == 777) { %>
                <button onclick ="location.href='fUpno.go?fno=<%=f.getFno()%>'">수정하기</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <%}} %>
               		
                </div>   
                
                 <%} }%>   
              
                
        <script>
        var acc = document.getElementsByClassName("accordion4");
        var i;
        
        for (i = 0; i < acc.length; i++) {
          acc[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight){
              panel.style.maxHeight = null;
            } else {
              panel.style.maxHeight = panel.scrollHeight + "px";
            } 
          });
        }
        </script>
                </div>

 
        <script>
        function openfaq(evt, faqName, value) {
          var i, tabcontent, tablinks;
          tabcontent = document.getElementsByClassName("tabcontent");
          for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
          }
          tablinks = document.getElementsByClassName("tablinks");
          for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
          }
          document.getElementById(faqName).style.display = "block";
          evt.currentTarget.className += " active";
          
          
          
        }
        
           document.getElementById("defaultOpen").click();
       
     
       
       
        </script>
                <section>
                <div class="bottom_box"></div>
                </section>
            </div> <!--.contain -->
        </div> <!--.wrap 끝2-->
    <!--FAQ 끝-->
   
        <!--######## start footer Area ########-->
		<%@ include file="../common/footer.jsp" %>
      
    

    </body>
    

</html>