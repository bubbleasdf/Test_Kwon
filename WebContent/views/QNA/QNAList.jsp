
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList ,com.kh.petner.QNA.model.vo.*" %>
    
     <% ArrayList<QNA> list = (ArrayList<QNA>)request.getAttribute("list");
     	ArrayList<QNA> searchList = (ArrayList<QNA>)request.getAttribute("searchList");
     		
     	 
     	 String cnd = (String)session.getAttribute("caregory");
     	 String searchValue = (String)session.getAttribute("keyword");
     	 
      	  QNAPageinfo qpi = (QNAPageinfo)request.getAttribute("qpi");
    	int Pagecount = qpi.getListCount();
    	int currentPage = qpi.getCurrentPage();
    	int maxPage = qpi.getMaxPage();
    	int srartPage = qpi.getStartPage();
    	int endPage = qpi.getEndPage();
    	
    	
    	ArrayList<QNA> searAndlist = new ArrayList<QNA>();
    	
    	if(list!=null){
    		searAndlist = list;
    		
    	}else if(searchList!=null){
    		searAndlist = searchList;
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


	<link rel="stylesheet" href="/PETNER/resources/css/hr.css">
	
	<style>
	.hiddeee{
		display:none;
	}
	</style>

</head>

<body>
	<!--######## Start Header Area ########-->
	<%@ include file="../common/header.jsp" %> 
	<!--######## start banner Area ########-->
	<!--  메뉴바랑 겹치는 부분 제거 -->
	<div style="padding-top:150px;"></div>
	<!--######## End Header Area ########-->

	<!--######## start banner Area ########-->
	<section class="notice-banner-area relative" id="home">
		<div class="overlay overlay-bg"></div>
		<div class="container">
			<div class="row tesxt-left d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white text-uppercase  ">
						QNA
					</h1>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->

	

	<!--######## Start Latest News Area ########-->
	<section class="latest-news-area section-gap-hr">
		<div class="container">
			<div class="row">
				<div class="col-12 marg45">
					<div class="main-title text-center">
						<h1 style="font-weight: 300;">QNA</h1>
					</div>
					<div class="card">

					
					
					
						<!-- /.card-header -->
						
						<div class="card-body table-responsive p-0">
						
						  <table class="table table-hover" id ="noticeArea">
							<thead>
							  <tr>
							  	<th class ="hiddeee">nno</th>
								<th>Num</th>
								<th>E-mail</th>
								<th>Title</th>
								<th>Date</th>
							  </tr>
							</thead>
							<tbody>
							
							
							<% for(QNA q : searAndlist){ %>

							  <tr>
							  	<td class ="hiddeee"><%=q.getQno()%></td>
								<td><%=q.getRnun()%></td>
								<td><%=q.getQemail() %></td>
								<td><%=q.getQtitle()%></td>
								<td><%= q.getNdate() %></td>
							  </tr>
							  <% } %>
							</tbody>
						  </table>
						  
						</div>
						<!-- /.card-body -->
						<% if(m!=null){ %>
						<button onclick="location.href='views/QNA/QNAInsertForm.jsp'" class = "btn-primary btn-lg">문의하기 click me</button>
						<% } %>
					  </div>
					  <!-- /.card -->
				</div>

				<!-- 페이징 부분1 -->
				 <% if(list != null){ %>
				  <nav class="col-sm-12 blog-pagination justify-content-center d-flex" style ="padding:20px">
               <ul class="pagination">
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-left"></span>
                        </span>
                     </a>
                  </li>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/QNAlist.go?currentPage=1'" class="page-link"><<</a></li>
                  <%  if(currentPage <= 1){  %>
                  <li class="page-item hiddeee"><a href="#" class="page-link"><</a></li>
                  <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/QNAlist.go?currentPage=<%=currentPage - 1 %>'" class="page-link"><</a></li>
                  <%  } %>
                  
                  
                  <% for(int p = srartPage; p <= endPage; p++){
						 if(p == currentPage){	 
					%>
                 	  <li class="page-item" id ="noclick"><a href="#" class="page-link"><%= p %></a></li> 
                  <%      }else{ %> 
                   		<li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/QNAlist.go?currentPage=<%= p %>'" class="page-link"><%= p %></a></li>
                   <%      } %>
				   <% } %>
			
					<%  if(currentPage >= maxPage){  %>
					<li class="page-item hiddeee"><a href="#" class="page-link">></a></li>
					<%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/QNAlist.go?currentPage=<%=currentPage + 1 %>'" class="page-link">></a></li>
                  <%  } %>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/QNAlist.go?currentPage=<%= maxPage %>'" class="page-link">>></a></li>
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-right"></span>
                        </span>
                     </a>
                  </li>
               </ul>
            </nav>             
            <br>
            <%} %>
            
            
            <!-- 페이징 부분2 -->
				<% if( searchList != null){ %>
				  <nav class="col-sm-12 blog-pagination justify-content-center d-flex" style ="padding:20px">
               <ul class="pagination">
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-left"></span>
                        </span>
                     </a>
                  </li>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/QNASearch.go?currentPage=1&caregory=<%=cnd%>&searchValue=<%=searchValue%>'" class="page-link"><<</a></li>
                  <%  if(currentPage <= 1){  %>
                  <li class="page-item hiddeee"><a href="#" class="page-link"><</a></li>
                  <%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/QNASearch.go?currentPage=<%=currentPage - 1 %>&currentPage=1&caregory=<%=cnd%>&searchValue=<%=searchValue%>'" class="page-link"><</a></li>
                  <%  } %>
                  
                  
                  <% for(int p = srartPage; p <= endPage; p++){
						 if(p == currentPage){	 
					%>
                 	  <li class="page-item" id ="noclick"><a href="#" class="page-link"><%= p %></a></li> 
                  <%      }else{ %> 
                   		<li class="page-item "><a onclick="location.href='<%= request.getContextPath() %>/QNASearch.go?currentPage=<%= p %>&currentPage=1&caregory=<%=cnd%>&searchValue=<%=searchValue%>'" class="page-link"><%= p %></a></li>
                   <%      } %>
				   <% } %>
			
					<%  if(currentPage >= maxPage){  %>
					<li class="page-item hiddeee"><a href="#" class="page-link">></a></li>
					<%  }else{ %>
                  <li class="page-item"><a onclick="location.href='<%= request.getContextPath() %>/QNASearch.go?currentPage=<%=currentPage + 1 %>&currentPage=1&caregory=<%=cnd%>&searchValue=<%=searchValue%>'" class="page-link">></a></li>
                  <%  } %>
                  <li class="page-item active"><a onclick="location.href='<%= request.getContextPath() %>/QNASearch.go?currentPage=<%= maxPage %>&currentPage=1&caregory=<%=cnd%>&searchValue=<%=searchValue%>'" class="page-link">>></a></li>
                  <li class="page-item">
                     <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">
                           <span class="lnr lnr-chevron-right"></span>
                        </span>
                     </a>
                  </li>
               </ul>
            </nav>             
            <br>
            <%} %> 
            
            
            	<div class="col-sm-12 justify-content-center d-flex row" align="center">
					<select id="searchCondition" name="searchCondition">
							<option>---</option>
							<option value="email">작성자</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
					</select>&nbsp;&nbsp;&nbsp;
					<input type="search" id="searchValue">&nbsp;&nbsp;&nbsp;
						<button onclick="search();">검색하기</button>
		 	 	</div>
            
            
            
         </div>
      </div>
   </section>
   

	<!--######## End Latest News Area ########-->

	<!--######## start footer Area ########-->
	
	<script>  
		 $(function(){
			
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
		 
		 
		 
		 function search(){
				location.href="<%=request.getContextPath()%>/QNASearch.go?caregory="+$('#searchCondition').val()+"&searchValue="+$('#searchValue').val();
			}
		</script>
	
		<%@ include file="../common/footer.jsp" %>
		
	<!--######## End footer Area ########-->

</body>

</html>