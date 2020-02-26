<%-- 공용 자랑 게시판 입니다. --%>


<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <% 
        	Member m = (Member)session.getAttribute("member");
        
        	System.out.println("Member : "+m);
        
        %>
        

<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">

  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core JavaScript -->
  <script src="/PETNER/resources/css/member/tab/jquery.min.js"></script>
  <script src="/PETNER/resources/css/member/tab/bootstrap.bundle.min.js"></script>
  <script src="/PETNER/resources/js/member/tab/jquery-te-1.4.0.min.js"></script>
  
	<link rel="stylesheet" href="/PETNER/resources/css/bootstrap.css" type="text/css">
  <!-- Bootstrap core CSS -->
  <link href="/PETNER/resources/css/member/tab/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/PETNER/resources/css/member/tab/jquery-te-1.4.0.css">


<script>

function chnBtn() {
	
//	alert("head 띠바 왜 안보여");
	
	var user1 = $('input[name=userName]').val();
	var user2 = '<%= m.getUserEmail()%>';

	//작성자 및 관리자인지 확인하고
	if(    user1!=user2     &&  user1!="admin@a.com"      ) {
		alert('작성자(혹은 관리자)만 수정이 가능합니다. ');
	}else{
		//버튼 이름 바꿔주고
		$('#chBtn').text('수정 완료');
		
		//삭제 버튼 보여줌
		$delBtn = $('<div class="btn btn-warning"  onclick="delDetail();" id="delBtn" >').text('삭제');
		$('div.form-group.text-center').append($delBtn);

		//form태그 파일 전송 가능하게 수정
		$('#bUpdateForm').attr('enctype',"multipart/form-data");
		
		//readonly등을 수정가능하게 바꿔줌.
		//카테고리 수정
		$('#selType').attr('disabled',false);
		
		//타이틀 수정
		$('input[name=bTitle]').attr("readonly",false);

		//내용 수정
		$('.jqte_editor').attr("contenteditable","true").css("cssText","height: 300px; resize: none;");

		//이미지 수정 버튼 등장
		$('input[name=n_file]').css('display','block');
		
		$('#chBtn').click(function(){
			$('#bUpdateForm').submit(); 
		});
		
		
	}//if else


}//changeBtn

function delDetail() {
	
	
	
	var user1 = $('input[name=userName]').val();
	var user2 = '<%= m.getUserEmail()%>';

	//작성자 및 관리자인지 확인하고
	if(    user1==user2     &&  user1=="admin@a.com"      ) {
		//작성자 혹은 관리자라면
		
		if(   confirm("정말 삭제하시겠슴미까?") ==true    ){
			$('#bUpdateForm').attr('action','/PETNER/delBoard.bo');
			$('#bUpdateForm').submit();
			
		}	else{
			
			return false;
			
		}
		
	}else{
		alert('작성자(혹은 관리자)만 수정이 가능합니다. ');
	}
		
}//delDetail



// 각 menu를 눌렀을 때 ListPage가 바뀌게 해주는 스크립트
 //시작하면 우측 리스트 화면 띄우기
	
 	$(function(){
 		listFunction('1','1');
 	});
 
 			// 좌측 메뉴 버튼
          function listFunction(menu, page){
        	  console.log('listFunction 실행 : '+menu);

             $.ajax({
                  url:"/PETNER/selectList.bo",
                  type:"get",
                  data: { type:menu, currentPage:page},
                  
                  // 리스트 만들어 주기.
                  success:function(data){
                	  
                	  
                	  
                	  /* 
                	  console.log("테스트 값 : "+menu+", "+page);
                	  console.log("테스트 page+1 : "+(page+1));
                	  console.log("테스트 parseInt(page)+1 : "+(parseInt(page)+1));
                	   */
					 
                	   
                	   console.log("성공 : "+data);
                	   
                	   if(data==0){
   						alert("다음페이지 없듬");
   						 return;
   					 }
                	   
                    //페이지 첫화면 load
                    $('#pageArea').load('tab/BoardTab/mpBoardListForm.jsp');
                    
                 	//리스트 초기화
                    $('#listDiv').html("");
                   
                 	var i;
                 	//pagenum 계산을 위한 변수
                 	
                 	
                 	//Index값 확욘이요
                 	var endIndex;
                 	
                 	
                 	
                 	if(parseInt(page)<4){
                 		i=0;	
                 	}else{
                 		i=-2;
                 	}
                    
                 	//pagenum을 붙일 div
                    var $divP = $('<div class="container">').attr('id','pNumDiv');
                 	
                 	
                 	
                 	
                 	
                 	/////////////////////////////////////
                 	
                 	//반복문
                    $.each(data, function(index, item){
                      var $1div1 = $('<div class="col-lg-4 col-md-6 mb-4">');
                      var $2div2 = $('<div class="card h-100">');
                      
                      console.log("이미지 경로 테스트 : "+ item.boardfile);
                      
                      
                      
                      //img와 h4의 a태그에 모달 링크를 넣어줘야 한다. data-target="#modal-login" data-toggle="modal"
                      //빈 modal을 띄우고 ajax로 처리해야 할지도?
                      
                    		  //<a class="btn btn-default" data-target="#modal" data-toggle="modal">자세히 알아보기</a>
                    		  
                    		  
                    		  //data-target으로 modal 불러오는거 실패
//                      var $3a = $('<a>').attr('class','btn btn-default').data('target','#mpBoardModal').data('toggle','modal');										// a태그에 detail부분을
                      var $3a = $('<a>').attr({class:'btn btn-default', href:'javascript:openModal('+item.bno+');'});										// a태그에 detail부분을
                    	  									
                      var $4img = $('<img class="card-img-top">').attr('src','/PETNER/resources/img/member/mpBoard/'+item.boardfile); //getPetPic() 
                      $3a.append($4img);
						

                      var $3div3 = $('<div class="card-body">');

                      var $4h4 = $('<h4 class="card-title">');
                      var $5a = $('<a>').attr('class','btn btn-default').data('target','#mpBoardModal').data('toggle','modal').text(item.btitle);     //  글제목 detail부분을 넣자.
                      $4h4.append($5a);
                      
                      var $4h5 = $('<h5>');
                      var $4p = $('<p class="card-text">').text("작성자 : "+ item.bwriter +"의 글입니다.");               // 
                      $4h5.append($4p);
                      $3div3.append($4h4);

                      $3div3.append($4h5);



                      var $3div4 = $('<div clas="card-footer">');
                      
                      
                      //hidden으로 글번호 값을 저장한다.
                      var $4input = $('<input type="hidden" id="hiddenBno" value='+item.bno+'>');
                      
                      
                      
                      var text="";
                      for(k=0; k<5; k++){
                    	  if(item.starCount>0){
                    		  text+="&#9733;";
                    		  item.starCount = (item.starCount-1);
                    	  }else{
                    		  text+="&#9734;";
                    	  } // if else
                      }//for
                      
                      
                      
                      var $4small = $('<small class="text-muted">').html(text);  // 동적으로 수정해줄 필요가 있다.
                      $3div4.append($4small);
                      
                      
                      //이 div에 글번호 input hidden을 붙인다.
                      $3div4.append($4input);

                      
                      $2div2.append($3a);
                      $2div2.append($3div3);
                      $2div2.append($3div4);

                      $1div1.append($2div2);
                      
                      console.log("$1div1 : " + $1div1);
                      
                      $('#listDiv').append($1div1);
                    
                      
                      
                      ////////////////////////////////////////////////
                    //pageDiv를 위한 작업  
                    console.log("parseInt(page) : "+parseInt(page));
                  	console.log("i : "+i);
                  	console.log("페이지 번호 : "+(parseInt(page)+i));
                  	
                  	
                  	
                  	//페이지 번호가 4미만일 때, 즉 1,2,3 일때는 페이지를 처음부터 만들어준다.
                  	
                  	if(parseInt(page)<4){
	                  	//페이지 번호 저장 변수
	                  	var pnum=(parseInt(page)+i);
							
	                  	//a태그에 페이지번호를 넣어준다.
	                  	var $apage = $('<a>').text(pnum+" ");
	                  	
	                  	//a태그를 기본 버튼 형식으로
	                  	$apage.attr('class', 'btn btn-default');
	                  	
	                  	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
							if(pnum==page){	
	                  		$apage.css('background','hotpink');	
	                  	}
							
	                  	//각 a태그 버튼에 onclick으로 메소드를 불러옴
	                  	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
							
	                  	$divP.append($apage);
	                  	
	                  	i++;
	                  	
                  	}else {
                  		//페이지 값이 4이상일 때는
                  		
                  	//페이지 번호 저장 변수
	                  	var pnum=(parseInt(page)+i);
							
	                  	//a태그에 페이지번호를 넣어준다.
	                  	var $apage = $('<a>').text(pnum+" ");
	                  	
	                  	//a태그를 기본 버튼 형식으로
	                  	$apage.attr('class', 'btn btn-default');
	                  	
	                  	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
							if(pnum==page){	
	                  		$apage.css('background','hotpink');	
	                  		}
							
	                  	//각 a태그 버튼에 onclick으로 메소드를 불러옴
	                  	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
							
	                  	$divP.append($apage);
	                  	
	                  	i++;
                  	}
                  	
                  	
                  	console.log("index값 : "+index);
                  	
                  	/////////////////////////////////////////////
                    //index가 6개 이상이고
                  	//페이지 값이 1이면 맨 처음이니 페이지번호를 만들어준다.
                  	 if(index==5 && parseInt(page)==1){
                  		 console.log("if(index=6 && parseInt(page)==1){ 실행");
                    	  $('#listDiv').append($divP);
                      }
                  	
                      
                  	//index가 6개 이상이고  
                    //현재 페이지값이 4페이지 이상일때부터 페이지 값을 바꿔준다. 
                      if(  index==5 && !(parseInt(page)<4) ){
                    	console.log("if(  index=6 && !(parseInt(page)<4) ){ 실행");
                    	  $('#listDiv').append($divP);
                      }
                  	
                    	endIndex = index;
                    	console.log("endIndex 값 : "+ endIndex);
                    	
                    }); //each 
                    
                    
                    
                    
                    
                    //최종 인덱스 값이 6미만이면 
            		console.log("반복문 바깥 endIndex : "+endIndex);
                    
                    if(endIndex <5){
                    	console.log("endIndex가 5보다 작습니다. ")
              			
                    	//div태그 초기화
              			$divP.html("");
                    	i=-2;
                    	
                    	while(i<1){
                    		console.log("while문 진입합니다. i값 : "+ i);
                    	
                    		var pnum=(parseInt(page)+i);
							
                    		if( pnum<1){
                    			console.log("pnum 값이 1보다 작습니다. break : "+ pnum);
                    			//a태그에 페이지번호를 넣어준다.
								i++;
                    			continue;
                    		}//if
                    		var $apage = $('<a>').text(pnum+" ");	
  	                  	//a태그를 기본 버튼 형식으로
  	                  			$apage.attr('class', 'btn btn-default');
  	                  	
  	                  	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
  							if(pnum==page){	
  	                  			$apage.css('background','hotpink');	
  	                  		}
  							
  	                  	//각 a태그 버튼에 onclick으로 메소드를 불러옴
  	                  	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
  							
  	                  	$divP.append($apage);
  	                  	
  	                  	i++;	
  	                  	
              			}//while
        				
              			$('#listDiv').append($divP);
              			
              		}//if
                    
                    
                  }//success
                  
                  
                  
                  , error:function(data){
                    console.log('에러에러에러에러 : '+data);
                    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                  }
              });  //ajax
          }  //listFunction
          
          //글쓰기
          function insertBoard(){
        	  
        	  $('#listArea').html("");	//현재 목록화면 가리기
        	  $('#listDiv').html("");	//현재 리스트화면 가리기
        	  
        	  
        	  
        	  $('#pageArea').load("tab/BoardTab/mpBoardInsertForm.jsp");
        	  
          } // insertBoard
          
          
          
          // 검색창 아직 안만듬

          
      	function searchBoard(){
    		console.log('searchBoard 실행');
    		var page = $('#pNumDiv a[style]').text();
    		console.log("받아온 page값 : "+page);
            $.ajax({
                 url:"/PETNER/mpBoard.se",
                 type:"get",
                 data: {},
                 
                 // 리스트 만들어 주기.
                 success:function(data){
               	  
               	   
               	  console.log("테스트 값 : "+page);
               	  console.log("테스트 page+1 : "+(page+1));
               	  console.log("테스트 parseInt(page)+1 : "+(parseInt(page)+1));
               	   
               	   
               	   console.log("성공 : "+data);
               	   
               	   if(data==0){
    						alert("다음페이지 없듬");
    						 return;
    					 }
               	   
                   //페이지 첫화면 load
                   $('#pageArea').load('tab/BoardTab/mpBoardListForm.jsp');
                   
                	//리스트 초기화
                   $('#listDiv').html("");
                  
                	var i;
                	//pagenum 계산을 위한 변수
                	
                	
                	//Index값 확욘이요
                	var endIndex;
                	
                	
                	
                	if(parseInt(page)<4){
                		i=0;	
                	}else{
                		i=-2;
                	}
                   
                	//pagenum을 붙일 div
                   var $divP = $('<div class="container">').attr('id','pNumDiv');
                	
                	
                	
                	
                	
                	/////////////////////////////////////
                	
                	//반복문
                   $.each(data, function(index, item){
                     var $1div1 = $('<div class="col-lg-4 col-md-6 mb-4">');
                     var $2div2 = $('<div class="card h-100">');
                     
                     console.log("이미지 경로 테스트 : "+ item.boardfile);
                     
                     
                     
                     //img와 h4의 a태그에 모달 링크를 넣어줘야 한다. data-target="#modal-login" data-toggle="modal"
                     //빈 modal을 띄우고 ajax로 처리해야 할지도?
                     
                   		  //<a class="btn btn-default" data-target="#modal" data-toggle="modal">자세히 알아보기</a>
                   		  
                   		  
                   		  //data-target으로 modal 불러오는거 실패
//                     var $3a = $('<a>').attr('class','btn btn-default').data('target','#mpBoardModal').data('toggle','modal');										// a태그에 detail부분을
                     var $3a = $('<a>').attr({class:'btn btn-default', href:'javascript:openModal('+item.bno+');'});										// a태그에 detail부분을
                   	  									
                     var $4img = $('<img class="card-img-top">').attr('src','/PETNER/resources/img/member/mpBoard/'+item.boardfile); //getPetPic() 
                     $3a.append($4img);
    					

                     var $3div3 = $('<div class="card-body">');

                     var $4h4 = $('<h4 class="card-title">');
                     var $5a = $('<a>').attr('class','btn btn-default').data('target','#mpBoardModal').data('toggle','modal').text(item.btitle);     //  글제목 detail부분을 넣자.
                     $4h4.append($5a);
                     
                     var $4h5 = $('<h5>');
                     var $4p = $('<p class="card-text">').text("작성자 : "+ item.bwriter +"의 글입니다.");               // 
                     $4h5.append($4p);
                     $3div3.append($4h4);

                     $3div3.append($4h5);



                     var $3div4 = $('<div clas="card-footer">');
                     
                     
                     //hidden으로 글번호 값을 저장한다.
                     var $4input = $('<input type="hidden" id="hiddenBno" value='+item.bno+'>');
                     
                     
                     
                     var text="";
                     for(k=0; k<5; k++){
                   	  if(item.starCount>0){
                   		  text+="&#9733;";
                   		  item.starCount = (item.starCount-1);
                   	  }else{
                   		  text+="&#9734;";
                   	  } // if else
                     }//for
                     
                     
                     
                     var $4small = $('<small class="text-muted">').html(text);  // 동적으로 수정해줄 필요가 있다.
                     $3div4.append($4small);
                     
                     
                     //이 div에 글번호 input hidden을 붙인다.
                     $3div4.append($4input);

                     
                     $2div2.append($3a);
                     $2div2.append($3div3);
                     $2div2.append($3div4);

                     $1div1.append($2div2);
                     
                     console.log("$1div1 : " + $1div1);
                     
                     $('#listDiv').append($1div1);
                   
                     
                     
                     ////////////////////////////////////////////////
                   //pageDiv를 위한 작업  
                   console.log("parseInt(page) : "+parseInt(page));
                 	console.log("i : "+i);
                 	console.log("페이지 번호 : "+(parseInt(page)+i));
                 	
                 	
                 	
                 	//페이지 번호가 4미만일 때, 즉 1,2,3 일때는 페이지를 처음부터 만들어준다.
                 	
                 	if(parseInt(page)<4){
                     	//페이지 번호 저장 변수
                     	var pnum=(parseInt(page)+i);
    						
                     	//a태그에 페이지번호를 넣어준다.
                     	var $apage = $('<a>').text(pnum+" ");
                     	
                     	//a태그를 기본 버튼 형식으로
                     	$apage.attr('class', 'btn btn-default');
                     	
                     	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
    						if(pnum==page){	
                     		$apage.css('background','hotpink');	
                     	}
    						
                     	//각 a태그 버튼에 onclick으로 메소드를 불러옴
                     	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
    						
                     	$divP.append($apage);
                     	
                     	i++;
                     	
                 	}else {
                 		//페이지 값이 4이상일 때는
                 		
                 	//페이지 번호 저장 변수
                     	var pnum=(parseInt(page)+i);
    						
                     	//a태그에 페이지번호를 넣어준다.
                     	var $apage = $('<a>').text(pnum+" ");
                     	
                     	//a태그를 기본 버튼 형식으로
                     	$apage.attr('class', 'btn btn-default');
                     	
                     	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
    						if(pnum==page){	
                     		$apage.css('background','hotpink');	
                     		}
    						
                     	//각 a태그 버튼에 onclick으로 메소드를 불러옴
                     	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
    						
                     	$divP.append($apage);
                     	
                     	i++;
                 	}
                 	
                 	
                 	console.log("index값 : "+index);
                 	
                 	/////////////////////////////////////////////
                   //index가 6개 이상이고
                 	//페이지 값이 1이면 맨 처음이니 페이지번호를 만들어준다.
                 	 if(index==5 && parseInt(page)==1){
                 		 console.log("if(index=6 && parseInt(page)==1){ 실행");
                   	  $('#listDiv').append($divP);
                     }
                 	
                     
                 	//index가 6개 이상이고  
                   //현재 페이지값이 4페이지 이상일때부터 페이지 값을 바꿔준다. 
                     if(  index==5 && !(parseInt(page)<4) ){
                   	console.log("if(  index=6 && !(parseInt(page)<4) ){ 실행");
                   	  $('#listDiv').append($divP);
                     }
                 	
                   	endIndex = index;
                   	console.log("endIndex 값 : "+ endIndex);
                   	
                   }); //each 
                   
                   
                   
                   
                   
                   //최종 인덱스 값이 6미만이면 
           		console.log("반복문 바깥 endIndex : "+endIndex);
                   
                   if(endIndex <5){
                   	console.log("endIndex가 5보다 작습니다. ")
             			
                   	//div태그 초기화
             			$divP.html("");
                   	i=-2;
                   	
                   	while(i<1){
                   		console.log("while문 진입합니다. i값 : "+ i);
                   	
                   		var pnum=(parseInt(page)+i);
    						
                   		if( pnum<1){
                   			console.log("pnum 값이 1보다 작습니다. break : "+ pnum);
                   			//a태그에 페이지번호를 넣어준다.
    							i++;
                   			continue;
                   		}//if
                   		var $apage = $('<a>').text(pnum+" ");	
    	                  	//a태그를 기본 버튼 형식으로
    	                  			$apage.attr('class', 'btn btn-default');
    	                  	
    	                  	// 현재 선택된 페이지 번호의 백그라운드 바꿔줌
    							if(pnum==page){	
    	                  			$apage.css('background','hotpink');	
    	                  		}
    							
    	                  	//각 a태그 버튼에 onclick으로 메소드를 불러옴
    	                  	$apage.attr('onclick','listFunction('+menu+','+pnum+')');
    							
    	                  	$divP.append($apage);
    	                  	
    	                  	i++;	
    	                  	
             			}//while
       				
             			$('#listDiv').append($divP);
             			
             		}//if
                   
                   
                 }//success
                 
                 
                 
                 , error:function(data){
                   console.log('에러에러에러에러 : '+data);
                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                 }
             });  //ajax
    		$('#searchForm').submit();
    		
    	}//searchBoard
          
          
    	




    	function LoadImg(value){
    		 if(value.files && value.files[0])
    		 {
    			var reader=new FileReader();
    			
    			reader.onload=function(e){
    				$('.img-banner-area').css('background','white');
    				$('#img-banner-area').attr('src',e.target.result).css('display','block');
    				$('h1.text-center').hide();
    			}
    			reader.readAsDataURL(value.files[0]);
    		 }//if
    	}

    	
    	//수정 버튼을 누르면 readonly가 풀리고 각종 내용을 수정할수 있게 된다.



    	//모달창 동적으로 만들어서 띄우자
    	
    	function openModal(bno){
    		console.log("openModal 실행 : "+bno);
    		  $.ajax({
    			  url: "/PETNER/bSelect.bo"
    			  , type:"get"
    			  , data:{ bno:bno}
    		  
    		  
    			  , success:function(data){
    				  console.log("받아온 data : "+data);
    				  console.log("받아온 data : "+data.btype);
    				  
    				  
    				  //값을 만들어서 모달을 만들어 띄우자
    				  
    				  
    				  //input type=hidden에 글번호 값을 저장
    				  $('input[name=mpbNo]').val(data.bno);
    				  
    				  //이미지 띄우기 전에 초기화
    				  var $img = $('<img>').attr({
    					  id:"img-banner-area",width:"100%", src:"/PETNER/resources/img/member/mpBoard/"+data.boardfile
    				  }).css("max-height","590px");
    				  
    				  //append하기 전에 초기화
    				  $('div.img-banner-area').html("");
    				  $('div.img-banner-area').append($img);
    				  
    				  //초기화
    				  var $input1="";
    				  $input1=$('<input type="text" name="userName" value='+data.bwriter+' class="form-control" style="margin-bottom:8px">')
    				  .attr('readonly',true);
    				  
    				  
    				  var $select1="";
    				  var $select1=$('<select name="Type" id="selType" required class="form-control">');
    				  
    				  var $option1="";
    				  var $option2="";
    				  var $option1=$('<option value="1" >전체 공유</option>');
    				  var $option2=$('<option value="2" >나만 공유</option>');
    				  
    				  
    				  
    				  if(data.btype== 1){
    					$option1.attr('selected',true);	
    				  }else if(data.btype==2){
    					  $option2.attr('selected',true);  
    				  }else if(data.btype==3){
    					  
    				  }else{
    					  alert("타입을 알 수 없는 글 입니다. ")
    				  }
    				  
    				  
    				  
    				  $select1.html("");
    				  $select1.append($option1);
    				  $select1.append($option2);
    				  
    				  $select1.attr('disabled',true);
    				  
    				  
    				  $('div.col-md-8').html("");
    				  $('div.col-md-8').append($input1);
    				  $('div.col-md-8').append($select1);
    				  
    				  $('div.modal-header').html("<h3 align='center'>"+data.btitle+"</h3>");
    				  
    				  
    				  //제목 지정
    				  $('input[name=bTitle]').val(data.btitle).attr("readonly",true);
    				  
    					//jqte를 띄우는 부분
    				  	$(".textArea").jqte({indent: false,
    						link: false, linktypes: ["Web URL", "E-mail", "Picture"],
    						source: false,sub: false, remove: false});
    					$('.jqte_editor').attr("contenteditable","false").css("cssText","height: 300px; resize: none;");
    			  		$('.jqte_editor').jqteVal(data.bcontent);
    				  
    				  
    			  		//button 세팅
    			  		//버튼 이름 세팅 및 초기화
    					$('#chBtn').text('수정하기');
    					
    					//삭제 버튼이 존재할수도 있으니 삭제
    					$('#delBtn').remove();
    				
    					
    					//이미지 수정 버튼 안보이게 세팅
    					$('input[name=n_file]').css('display','none');
    			  		
    			  		
    			  		
    			  		
    				  //modal 세팅완료
    				  
    				  
    				  
    				  
    				  
    				  
    			  }//success
    			  
    			  , error:function(request,status,error){
    				  console.log("에라에러에러 : ");
    				  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    			  } //errorfunction
    			  
    			  
    		  });
    		  
    		// modal 띄움
    		$('#modalPage').show();
    		  $('#mpBoardModal').modal();
    		  
    		
    		
    	}//openModal
    	
    	
		function insertComment(){
    		
    	}//insertComment
    	
    	
        
    	
		function commentBtn(){
    		console.log("commentBtn실행 : ");
  		  $.ajax({
  			  url: "/PETNER/coList.co"
  			  , type:"get"
  			  , data:{ }
  		  	  , success:function(data){
  		  		  console.log("commnetBtn 석세스 석세스");
  		  		  
  		  		  //모달 우측부분 가려줌
  		  		  $('#modalPage').hide();
  		  		  
  		  		  //초기화
  		  		  $('#rPage').html('');
  		  		  
  		  			var $th1=$('<th>').text("작성자");
		  			var $th2=$('<th>').text("내용");
		  			var $th3=$('<th>').text("별점");
		  			var $thead=$('<thead>');
		  			$thead.append($th1);
		  			$thead.append($th2);
		  			$thead.append($th3);
		  			
		  			var $table=$('<table border=1px black>');
		  			$table.append($thead);
	
		  			//기본적인 테이블 형태 완성
  		  			//이제부터 불러온 리스트를 이용해서 만든 tr,td를 $table에 append해준다.

		  			
  		  		  //불러온 리스트 반복문
  		  		  $.each(data, function(index, item){
  		  			  
  		  			  
  		  			 //불러온 리스트를 테이블에 만들어 넣어준다.
  		  		  	var $tr=$('<tr>')
  		  		  	var $td1=$('<td>').text(item.bc_email);
  		  		  	var $td2=$('<td>').text(item.bc_content);
  		  		  	var $td3=$('<td>').text(item.bc_starcount);
  		  			var $a1	=$('<a>').html("");
  		  			var $a2	=$('<a>').html("");
  		  			var $a3	=$('<a>').html("");
  		  			//안보이게 글번호 저장
  		  		  	var $inputhidden=$('<input type="hidden">').val(item.b_no);
  		  		  	var $inputhidden=$('<input type="hidden">').val(item.bc_no);
  		  			
  		  		  	
  		  		  	//a태그로 메소드에 링크를 걸어준다 매개변수는 코멘트 넘버
  		  			$a1.attr('onclick','insertComment('+item.bc_no+')');
  		  		  	$a2.attr('onclick','insertComment('+item.bc_no+')');
  		  		  	$a3.attr('onclick','insertComment('+item.bc_no+')');
  		  			
  		  			
  		  			$a1.append($td1);
  		  			$a2.append($td2);
  		  			$a3.append($td3);
  		  			
	  		  		  $tr.append($td1);
	  		  		  $tr.append($td2);
	  		  		  $tr.append($td3);
  		  		  
	  		  		  $a.append($tr);
	  		  		  
  		  			$('#rPage').append($inputhidden);
  		  			$('#rPage').append($tr);
  		  			
  		  		  }); // each반복문
  		  		  
  		  		 
  		  		  
  		  	  }//success
  			  , error:function(data){
  				  console.log("commentBtn 에러에러에러");
  			  }
    	}); //ajax
    	
    	} //commentBtn
          
    	
    	
    	
    	
    	
    	
    	
    	
          
        </script>


<!-- 모달 창 가운데로 모으는 스타일 -->
<style>

	.modal {
        text-align: center;
	}
 
	.modal-content {
	        display: inline-block;
	        text-align: left;
	        vertical-align: middle;
	}
	@media screen and (min-width: 768px) { 
	        .modal:before {
	                display: inline-block;
	                vertical-align: middle;
	                content: " ";
	                height: 100%;
	        }
	}

</style>



</head>

<body>

  <!-- Page Content -->
  <!-- menu -->



  <div class="container">
      <div style="padding-top:20px;"></div>
    <div class="row" style="width:1300px;">
      <div class="col-lg-3">
        <h1 class="my-4"><%=m.getUserName() %></h1>
        <div class="list-group">
          <a href="#" class="list-group-item" onclick="listFunction('1','1')">전체</a>
          <a href="#" class="list-group-item" onclick="listFunction('3','1')">인기</a>
          <a href="#" class="list-group-item" onclick="listFunction('2','1')">내거</a>
          <br>
        <div style="padding-left: 10px;, padding-right: 10px;">
	          <button class="btn btn-info" onclick="insertBoard();">글쓰기</button> 
	          <br>
        </div>
        
        <div style="padding-left: 10px;, padding-right: 10px;">
        
        	<form action="/PETNER/mpBoard.se" method="get" id="searchForm">
        	<select name="sel_category">
        		<option value="1">제목</option>
        		<option value="2">이메일</option>
        	</select>
        	<input type="text" name="searchId">
	          <a class="btn btn-info"  onclick="searchBoard();">검색</a>
	          <!-- onclick="searchBoard();" -->
	          </form> 
        </div>
        
        </div>
      </div>  <!-- /.col-lg-3 -->


      <!-- right display -->


      <!-- 협찬,추천,이벤트 배너 -->
      <div class="col-lg-9" >
      
	      <div id="pageArea">
	      
	      
	      </div> <!-- pageArea -->
	      
	      <!-- 글 ListPage -->
	      <!-- 글 만큼 반복문 -->
	      <div class="row" id="listDiv">                                          
	
	       
	      </div> <!-- /.row #listDiv-->
      

      </div>  <!-- /.col-lg-9 #pageArea-->
`
		
    </div> <!-- /.row -->

  </div>
  <!-- /.container -->




<form action="/PETNER/mpUpdate.bo" id="bUpdateForm" method="POST" >
    <div class="row">
        <div class="modal" id="mpBoardModal" tabindex="-1"  > <!-- tabindex : ?????-->
                <div class="modal-content" style="width:975px; height:670px">
                    <div class="modal-header" style="align:center;">      <!--모달의 제목 부분-->

                        <button class="close" data-dismiss="modal">&times;</button>  <!-- 모달창을 닫을 수 있는 버튼-->
                    </div>
                                
                    
	<div class="row" style="width:100%; height:80%; background-color: rgba( 200, 200, 200, 0.2);">
			<div class="col-md-6" style="width:100%; height:100%;">
			<input type="file" name="n_file"accept=".gif, .jpg, .png" style="display: none;" onchange="LoadImg(this)">
				<div class="img-banner-area" style="max-width:100%; max-height:600px;">
					<!-- 요기에 이미지를 넣는다. -->
				</div>
			</div> <!-- col-md-6 -->

		<div class="col-md-6" style="width:100%; height:100%;">
		<div id="modalPage">
			<div class="form-group">
			 <div class="row">
			 	<div class="col-md-3">
				 	<label class="form-control">작성자</label>
				 	<label class="form-control">카테고리</label>
			 	</div>
			 	<div class="col-md-8">			 	
				 	
				 	<!--  요기에 온갖 input값 등을 넣는다. -->
					
			 	</div>
			 	
			 </div>
				
				
				
			</div>	<!-- form-group -->
		
			<div class="form-group">
				<input type="text" name="bTitle" class="form-control"  required> <!-- 제목부분 -->
				<div class='textArea' name="jqteArea"></div> <!-- jquery text editor -->
			</div>
			
			<div class="form-group text-center">
				<input type="hidden" name="mpbNo">
				<div class="btn btn-primary"   onclick="chnBtn()" id="chBtn" >수정하기</div>
				<div class="btn btn-primary"   onclick="commentBtn()" id="cBtn" >댓글확인</div>				
				<!--  --> 
			</div>
		</div> <!-- col-md-6 -->
		</div>
		<div id="rPage">
		
		</div>
		</div> <!-- row -->
		
		
		
                </div>   
        </div>
    </div>
    </form>
    <script>
  		  
    	//댓글 버튼을 누르면 해당 부분에 댓글 입력창을 띄워준다.
  		function insertComment(bc_no){
    		
    		$('#temp').remove();
    		
    		//insertForm를 만든다.
    		var $iform = $('<form>');
    		var $name=$('<label id="userEmail">').text('<%=m.getUserEmail()%>');
    		var $content=$('<input type=text" id="c_content">');
    		var $starCount = $('<input type="text" id="starCount" min="0" max="5" maxlength="1">').val('0');
    		var $btn=$('<span class="btn btn-primary" onclick="commentSubmit()">').text("입력");
	
    		$iform.append($name);
    		$iform.append($content);
    		$iform.append($starCount);
    		$iform.append($btn);
    		
    		//id가 temp인 tr을 만들어서 그곳에 td로 만들어진 form태그를 넣어준다.
    		var $tempTR=$('<tr id="temp">');
    		var $tempTD=$('<td colspan="3">');
    		$tempTD.append($iform);
    		
    		//클릭한 부분에 insertForm태그를 붙여준다.
    		//value값이 일치하는 곳의 td로 붙여준다.
			 	$('input[value='+bc_no+']').append($tempTD);
		 }
  		  
  		  
    </script>






</body>

</html>
