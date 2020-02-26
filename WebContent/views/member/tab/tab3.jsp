<%-- 아마도 예약 정보? 출력되는 탭 입니다.  --%>


<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@page import="com.kh.petner.QNA.model.vo.QNAPageinfo"%>
<%@page import="com.kh.petner.QNA.model.vo.QNA"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


     <% 
     System.out.println("tab3들어왔다.");
     
     ArrayList<QNA> list = (ArrayList<QNA>)session.getAttribute("QNAUserlist");
     System.out.println("tab3 list 값 : "+list);
     
     	Member m =(Member)request.getAttribute("member");
     		
     	 
     	 String cnd = (String)session.getAttribute("caregory");
     	 String searchValue = (String)session.getAttribute("keyword");
     	 
/*       	  QNAPageinfo qpi = (QNAPageinfo)request.getAttribute("qpi");
    	int Pagecount = qpi.getListCount();
    	int currentPage = qpi.getCurrentPage();
    	int maxPage = qpi.getMaxPage();
    	int srartPage = qpi.getStartPage();
    	int endPage = qpi.getEndPage(); */
    	
    	
    	ArrayList<QNA> searAndlist = new ArrayList<QNA>();
    	
		if(list!=null)
    		searAndlist = list;
		
		System.out.println("tab3 list 값 : "+searAndlist);

    	
    	
    	
    	
    %> 
    
	<style>
	.hiddeee{
		display:none;
	}
	</style>

  <!-- Bootstrap core JavaScript -->
  <script src="/PETNER/resources/css/member/tab/jquery.min.js"></script>
  <script src="/PETNER/resources/css/member/tab/bootstrap.bundle.min.js"></script>
  <script src="/PETNER/resources/js/member/tab/jquery-te-1.4.0.min.js"></script>
  
	<link rel="stylesheet" href="/PETNER/resources/css/bootstrap.css" type="text/css">
  <!-- Bootstrap core CSS -->
  <link href="/PETNER/resources/css/member/tab/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/PETNER/resources/css/member/tab/jquery-te-1.4.0.css">


    <script>
    	$(function(){	//사라지게 하기
    		$('div.tab_content').fadeIn();
    	});
    </script>

    
 			<div id="tab3" class="tab_content"><br>



	

	<!--######## Start Latest News Area ########-->
	<section class="latest-news-area section-gap-hr">
		<div class="container">
			<div class="row">
				<div class="col-12 marg45">
					<div class="main-title text-center">
						<h1 style="font-weight: 300;">나으 문의</h1>
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
            
            
            
         </div>
      </div>
   </section>
   
</div>
	<!--######## End Latest News Area ########-->

	<!--######## start footer Area ########-->

	<script>  
		 $.(function(){
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
		 
		 
		</script>
	

</body>

</html>