<%@page import="com.kh.petner.member.model.vo.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  채팅창 크기 --> 
	 
    <!-- 로그인한 상태일 경우와 비로그인 상태일 경우의 chat_id설정 -->
<%--     
	<c:if test="${(login.id ne '') and !(empty login.id)}">
        <input type="hidden" value='${login.id }' id='chat_id' />
    </c:if>
    <c:if test="${(login.id eq '') or (empty login.id)}">
        <input type="hidden" value='<%=session.getId().substring(0, 6)%>'
            id='chat_id' />
    </c:if> 
    --%>
    
    <!-- 항상 로그인 상태이다. -->
    <!-- 익명으로 사용할 경우 -->
    <!--
    <input type="hidden" value='<%=session.getId().substring(0, 6)%>'
            id='chat_id' />
            -->
 		<script src="/PETNER/resources/js/vendor/jquery-3.4.1.min.js" type="text/javascript"></script>
 		           
            <!-- 익명이 아닌 경우 -->
    <input type="hidden" value='<%=((Member)session.getAttribute("member")).getUserName()%>'
            id='chat_id' />
    
    <!--     채팅창 -->
    <div id="_chatbox" style="display: none;">
        <fieldset>
            <div id="messageWindow" style="height:650px; overflow:scroll"  ></div>
            <br /> <input id="inputMessage" type="text" onkeyup="enterkey()" />
            <input type="submit" value="send" onclick="send()" />
        </fieldset>
    </div>
    <img class="chat" src="/PETNER/resources/img/member/tab/chat.jpg" />

<!-- 말풍선아이콘 클릭시 채팅창 열고 닫기 -->
<script>
    $(".chat").on({
        "click" : function() {
//            if ($(this).attr("src") == "/PETNER/resources/img/member/tab/chat.jpg") {
                $(".chat").css("display", "none");
                $("#_chatbox").css({
                	"display":"block"
                	, "height" : "500px"
                });
//            } else if ($(this).attr("src") == "/PETNER/resources/img/member/tab/chathide.jpg") {
//                $(".chat").attr("src", "/PETNER/resources/img/member/tab/chat.jpg");
//                $("#_chatbox").css("display", "none");
//            }
        }
    });
</script>


<script type="text/javascript">
    var textarea = document.getElementById("messageWindow");
    var webSocket = new WebSocket('ws://localhost:8888/PETNER/broadcasting');
    var inputMessage = document.getElementById('inputMessage');
    webSocket.onerror = function(event) {
        onError(event)
    };
    webSocket.onopen = function(event) {
        onOpen(event)
    };
    webSocket.onmessage = function(event) {
        onMessage(event)
    };
    function onMessage(event) {
        var message = event.data.split("|");
        var sender = message[0];
        var content = message[1];
        if (content == "") {
            
        } else {
            if (content.match("/")) {
                if (content.match(("/" + $("#chat_id").val()))) {
                    var temp = content.replace("/" + $("#chat_id").val(), "(귓속말) :").split(":");
                    if (temp[1].trim() == "") {
                    } else {
                        $("#messageWindow").html($("#messageWindow").html() + "<p class='whisper'>"
                            + sender + content.replace("/" + $("#chat_id").val(), "(귓속말) :") + "</p>");
                    }
                } else {
                }
            } else {
                if (content.match("!")) {
                    $("#messageWindow").html($("#messageWindow").html()
                        + "<p class='chat_content'><b class='impress'>" + sender + " : " + content + "</b></p>");
                } else {
                    $("#messageWindow").html($("#messageWindow").html()
                        + "<p class='chat_content'>" + sender + " : " + content + "</p>");
                }
            }
        }
    }
    function onOpen(event) {
        $("#messageWindow").html("<p class='chat_content'>채팅에 참여하였습니다.</p>");
    }
    function onError(event) {
        alert(event.data);
    }
    function send() {
        if (inputMessage.value == "") {
        } else {
            $("#messageWindow").html($("#messageWindow").html()
                + "<p class='chat_content'>나 : " + inputMessage.value + "</p>");
        }
        webSocket.send($("#chat_id").val() + "|" + inputMessage.value);
        inputMessage.value = "";
    }
    //     엔터키를 통해 send함
    function enterkey() {
        if (window.event.keyCode == 13) {
            send();
        }
    }
    //     채팅이 많아져 스크롤바가 넘어가더라도 자동적으로 스크롤바가 내려가게함
    window.setInterval(function() {
        var elem = document.getElementById('messageWindow');
        elem.scrollTop = elem.scrollHeight;
    }, 0);
</script>
