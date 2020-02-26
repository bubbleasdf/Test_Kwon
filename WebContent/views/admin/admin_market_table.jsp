<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="com.kh.petner.market.model.vo.Market, java.util.*"%>
<%
   ArrayList<Market> list = (ArrayList<Market>)request.getAttribute("list");
%>   
   
<!DOCTYPE html>
<html>
<head>
  <style type="text/css"> /* 게시판에서 텍스트가 길어질 경우 ... 으로 줄어들게 해준다 */
   td{
      text-overflow:ellipsis; overflow:hidden; white-space:nowrap;
      max-width:50px;
   }
</style>

</head>
<body>
   <%@ include file="/views/common/header.jsp"%>
      <div style="padding-top:150px;"></div>
   
   <hr style="margin: 0px;">

   <!-- Page Wrapper -->
   <div id="wrapper">

      <%@ include file="/views/admin/admin_sidebar.jsp"%>

      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">

         <!-- Main Content -->
         <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">

               <!-- Page Heading -->
               <br>
               <h1 class="h3 mb-2 text-gray-800">매장 목록</h1>
               <p class="mb-4">
                  <!-- DataTables is a third party plugin that is used to generate the
                  demo table below. For more information about DataTables, please
                  visit the <a target="_blank" href="https://datatables.net">official
                     DataTables documentation</a>. -->
                     매장 목록을 보여드립니다.
               </p>

               <!-- DataTales Example -->
               <div class="card shadow mb-4">
                  <div class="card-header py-3">
                     <h6 class="m-0 font-weight-bold text-primary"></h6>
                  </div>
                  <div class="card-body">
                     <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%"
                           cellspacing="0"> <!-- style="text-align:center;" -->
                           <thead>
                              <tr>
                                 <th width="100px">번호</th>
                                 <th width="200px">매장명</th>
                                 <th width="600px">주소</th>
                                 <th width="140px">전화번호</th>
                                 <th width="80px">타입</th>
                                 <th width="120px">가입일</th>
                                 <th width="55px">활성화</th>
                                 <th width="55px">수정</th>
                                 <th width="55px">Detail</th>
                              </tr>
                           </thead>
                           <tbody>
                              <!-- 이런 식으로 필요한 변수를 하나하나 집어넣어 주는게 가능합니다. -->
                              <% for(Market market : list){ %> 
                              <tr>
                                 <td><%= market.getMarketId() %></td>
                                 <td><%= market.getMarketName() %></td>
                                 <td><%= market.getMarketAddress() %></td>
                                 <td><%= market.getMarketTel() %></td>
                                 <td><%= market.getMarketType() %></td>
                                 <td><%= market.getEnDate() %></td>
                                 <td style="text-align:center;"><%= market.getStatus() %></td>
                                 <!-- <td><a href="admin_market_modify.jsp"><button>수정</button></a></td> -->
                                 <!-- <td><button class="btn1" onclick="selectOne();">수정</button></a></td> -->
                                 <td style="padding:7px; text-align:center;"> 
                                    <div class="btn1 btn btn-secondary btn-icon-split"
                                    style="font-size: 14px; padding:0.1px;!important;">
                                            <span class="text">수정</span>
                                          </div>
                                    </td>
                                <td style="padding:7px; text-align:center;"> 
                                    <div class="btn2 btn btn-secondary btn-icon-split"
                                    style="font-size: 14px; padding:0.1px;!important;">
                                            <span class="text">세부</span>
                                          </div>
                                    </td>
                              </tr>
                              <% } %>
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>

            </div>
            <!-- /.container-fluid -->

         </div>
         <!-- End of Main Content -->

      </div>
      <!-- End of Content Wrapper -->

   </div>
   <!-- End of Page Wrapper -->

   </div>
   <!-- End of Page Wrapper -->
   <%@ include file="/views/common/footer.jsp"%>

   <script>
         $("span").on({
            click:function(){
               $(".btn1").click(function(){
                       //console.log($(this).parent().children().eq(0).text());
                       var marketId = $(this).parent().parent().children().eq(0).text();
                       location.href="<%=request.getContextPath()%>/selectMarketOne.ad?marketId=" + marketId;
                    });
            }
         });
      
         <%--   $(function selectOne(){
              $(".btn1").click(function(){
                 //console.log($(this).parent().children().eq(0).text());
                 var marketId = $(this).parent().parent().children().eq(0).text();
                 location.href="<%=request.getContextPath()%>/selectMarketOne.ad?marketId=" + marketId;
                 
              });
           });
            --%>
        
           
           $("span").on({
            click:function(){
               $(".btn2").click(function(){
                       //console.log($(this).parent().children().eq(0).text());
                  var marketId = $(this).parent().parent().children().eq(0).text();
                       location.href="<%=request.getContextPath()%>/selectMarketDetail.ad?marketId=" + marketId;
                    });
            }
         });
           
         <%-- $(function selectOne(){
            
            
            $("#dataTable td").click(function(){
               //console.log($(this).parent().children().eq(0).text());
               var marketId = $(this).parent().children().eq(0).text();
               location.href="<%=request.getContextPath()%>/selectOne.ad?marketId=" + marketId;
            });
         }); --%>
      </script>


</body>
</html>