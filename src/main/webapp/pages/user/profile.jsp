<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            未登录
        </c:if>
    </div>
    <div class="show_item">
        <div style="float: right; margin-top: 10px;">
            <c:set var="users" value="${applicationScope.usersKey}"></c:set>
            <c:if test="${!empty users}">
                <table>
                    <tr>
                        <th>好友列表</th>
                    </tr>
                    <c:forEach var="username" items="${users}">
                        <tr>
                            <td><a href="ProfileServlet?name=${username.name}">${username.name}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <c:set var="user" value="${requestScope.userKey}"></c:set>
        <c:if test="${!empty user}">
            <div style="margin-left: 20px">
                <table>
                    <tr>
                        <th>用户名: </th>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <th>性别: </th>
                        <td>${user.sex}</td>
                    </tr>
                    <tr>
                        <th>年龄: </th>
                        <td>${user.age}</td>
                    </tr>
                    <tr>
                        <th>爱好: </th>
                        <td>${user.like}</td>
                    </tr>
                    <tr>
                        <th>个人签名: </th>
                        <td>${user.tag}</td>
                    </tr>
                </table>
            </div>
        </c:if>
    </div>
    <a href="MessageBoardServlet">留言板</a>
    <div class="blank"></div>
</div>
<script src="js/dataCheck.js"></script>
</body>
</html>
