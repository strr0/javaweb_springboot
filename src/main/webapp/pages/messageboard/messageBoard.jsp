<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="box">
    <div class="blank"></div>
    <div style="float: right; margin-right: 10px;">
        <c:set var="login" value="${sessionScope.nameKey}"></c:set>
        <c:if test="${!empty login}" var="flag">
            ${login} <a href="LogoutServlet">注销</a>
        </c:if>
        <c:if test="${not flag}">
            <p onclick="location.href='LoginServlet'">未登录</p>
        </c:if>
    </div>
    <div class="show_item">
        <div><font size="5">留言板</font></div>
        <div class="blank"></div>
        <c:set var="messages" value="${requestScope.messageBoardKey}"></c:set>
        <c:set var="admin" value="${sessionScope.adminKey}"></c:set>
        <c:if test="${!empty messages}" var="flag">
            <c:forEach var="message" items="${messages}">
                <div class="board_wrap">
                    <div class="board">
                        <div>${message.mName}: ${message.mData}</div>
                        <div style="float: right;"><font size="2">${message.mTime}</font></div>
                    </div>
                    <c:if test="${!empty admin}">
                        <div style="float: left;">
                            <button class="bt_delete" onclick="location.href='MessageBoardDeleteServlet?id=${message.mId}'">删除</button>
                        </div>
                    </c:if>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${not flag}">
            暂无留言信息
        </c:if>
        <div class="blank"></div>
        <div>
            <form action="MessageBoardServlet" method="post" id="messages">
                <textarea form="messages" name="data"></textarea>
                <input type="submit" value="提交">
            </form>
        </div>
    </div>
    <div class="blank"></div>
</div>
</body>
</html>
