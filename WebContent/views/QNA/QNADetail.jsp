
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.petner.QNA.model.vo.*, com.kh.petner.QNAComment.model.vo.*, java.util.ArrayList"%>
    
   <% QNA q = (QNA)request.getAttribute("QNA");
   	ArrayList<QNAComment> clist = (ArrayList<QNAComment>)request.getAttribute("QNAComment");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QANDetail</title>


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
	
	.hide{
	display: non
	}
	
	.replyList1 td{	background : lavenderblush; }
	.replyList2 td{	background : honeydew; }
	.replyList3 td{ background : aliceblue; }
	
	
	
	</style>
	
</head>

<body>

<%@ include file="../common/header.jsp" %> 
   
    
<div style="padding-top:150px;"></div>

<section class="post-content-area single-post-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 posts-list">
					<div class="single-post row">
						<div class="col-lg-3  col-md-3 meta-details">
							<div class="user-details row">
								<p class="user-name col-lg-12"><span class="lnr lnr-user"><%=q.getQemail()%></span></p>
								<p class="date col-lg-12"><span class="lnr lnr-calendar-full"><%=q.getNdate()%></span></p>
								<p class="col-lg-12 btn btn-primary" onclick="location.href='QNAlist.go'">QNA 메뉴<span class="lnr lnr-bubble"></span></p>
							 <% if(m != null && m.getUserEmail().equals(q.getQemail())){ %> 
								<p class="col-lg-12 btn btn-success" onclick="location.href='qUpno.go?qno=<%=q.getQno()%>'">QNA 수정<span class="lnr lnr-bubble"></span></p>
								
							 <% } %>
								
							</div>
						</div>
						<div class="col-lg-9 col-md-9">
							<a class="posts-title"><h3><%=q.getQtitle() %></h3></a>
								<blockquote class="generic-blockquote">
									<%=q.getQcontent()%>
								</blockquote>							
						</div>	
				</div>
				
				<!-- ------------------------------------------------------------------------------------------------------------------------------- -->
					<!-- 댓글 입력 구역 영역 -->
					 <% if(m != null){ %> 
					<div class="comment-form">
						<form action="<%= request.getContextPath() %>/QNAInsertComment.go" method="post">
							<h1>댓글 입력</h1>
							<div class="form-group">
							<input type="hidden" name="qemail" value="<%=m.getUserEmail()%>"/>
							<input type="hidden" name="qno" value="<%=q.getQno() %>" />
							<input type="hidden" name="refcno" value="0" />
							<input type="hidden" name="clevel" value="1" />
								
							<textarea cols ="110" rows="3" name="qcomment" style="resize:none"></textarea>
							</div>
							<button type ="submit" class="btn btn-dark col-sm-6">댓글 등록</button>
						</form>
					</div>
					<% } %>
					<!-- 댓글 입력 구역 영역 끝 -->
					
					
					
					
					<!-- 섬머노트 적용 구역 뎃글 작성 영역-->
					
					
					<!--  코멘트 시작  -->
					
						<div class="comments-area">
							 <h4><%=clist.size()%> Comments</h4>
							 <hr> 
							 <div style= "padding-left:150px; padding-right:150px;">
							<% if (clist != null) { %>
								<% for(QNAComment qc : clist) { %>
									<table id="replySelectTable" 
	     								 	style="margin-left : <%= (qc.getClevel()-1) * 15 %>px;
	      	 								width : <%= 800 - ((qc.getClevel()-1) * 15)%>px; align='center'"
	      									class="replyList<%=qc.getClevel()%>">
		  									<tr>
		  										
												<td><b>E-MAIL : </b> <%= qc.getCemail() %></td>
												<td><b>등록일 :  </b><%= qc.getCdate() %></td>
												<td align="center">
 													<%if(m.getUserEmail().equals(qc.getCemail())) { %>
													<input type="hidden" name="cno" value="<%=qc.getCno()%>"/>
													<button type="button" class="updateBtn" onclick="updateReply(this);">수정하기</button>
													<button type="button" class="updateConfirm" onclick="updateConfirm(this);" style="display:none;" >수정완료</button> &nbsp;&nbsp;
													<button type="button" class="deleteBtn" onclick="deleteReply(this);">삭제하기</button>
							
									<% } else if( qc.getClevel() < 3) { %>
													<input type="hidden" name="cemail" value="<%=m.getUserEmail()%>"/>
													<input type="hidden" name="refcno" value="<%= qc.getCno() %>" />
													<input type="hidden" name="clevel" value="<%=qc.getClevel() %>" />
													<button type="button" class="insertBtn" onclick="reComment(this);">댓글 달기</button>&nbsp;&nbsp;
													<button type="button" class="insertConfirm" onclick="reConfirm(this);" style="display:none;" >댓글 추가 완료</button> 
							
									<% } else {%>
													<span> 여기까지야~!</span>
									<% } %>
												</td>
											</tr>
											<tr class="replyList<%=qc.getClevel()%>">
												<td colspan="3">
												<textarea class="reply-content" cols="105" rows="3" readonly="readonly" style="resize:none"><%= qc.getCcontent() %></textarea>
												</td>
											</tr>
									</table>
			
								<% } }  %>
						</div>
			</div>
		</div> 
	</div>
	<script>
	function updateReply(obj) {
		
		$(obj).parent().parent().next().find('textarea')
		.removeAttr('readonly');
		
		
		$(obj).siblings('.updateConfirm').css('display','inline');
		
		$(obj).css('display', 'none');
	}
	
	function updateConfirm(obj) {
		
		var content
		  = $(obj).parent().parent().next().find('textarea').val();
		
		
		var cno = $(obj).siblings('input').val();
		
	
		var qno = '<%=q.getQno()%>';
		
		location.href="QNAUpdateCommen.go?"
				 +"cno="+cno+"&qno="+qno+"&content="+content;
	}
	
	function deleteReply(obj) {
		
		var cno = $(obj).siblings('input').val();
		
		var qno = '<%=q.getQno()%>';
		
		location.href="QNADeleteComment.go?cno="+cno+"&qno="+qno;
	}
	
	function reComment(obj){
		
		$(obj).siblings('.insertConfirm').css('display','inline');
		
		
		$(obj).css('display', 'none');
		
		
		var htmlForm = 
			'<tr>'
				+'<td colspan="3">'
					+ '<textarea class="reply-content" style="background:ivory; resize:none " cols="105" rows="3"></textarea>'
				+ '</td>'
			+ '</tr>';
		
		$(obj).parents('table').append(htmlForm);
		
	}
	
	function reConfirm(obj) {
		
		
		
		var refcno = $(obj).siblings('input[name="refcno"]').val();
		var level = Number($(obj).siblings('input[name="clevel"]').val()) + 1;
		
		
		var qno = '<%=q.getQno()%>';
		
		var parent = $(obj).parent();
		var grandparent = parent.parent();
		var siblingsTR = grandparent.siblings().last();
		
		var content = siblingsTR.find('textarea').val();
		
		//console.log(content);
		
		
		location.href='QNAInsertComment.go'
		           + '?qemail=<%= m.getUserEmail() %>' 
		           + '&qcomment=' + content
		           + '&qno=' + qno
		           + '&refcno=' + refcno
		           + '&clevel=' + level;
	   
	}
	</script>
							 
						 
					   </div>
				</div>
			</div>
		</div>
	</section>
	
	
    
</body>
</html>