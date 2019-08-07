<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2
  Time: 11:05
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
        <a href="LogoutServlet">注销</a>
    </div>
    <c:set var="users" value="${applicationScope.usersKey}"></c:set>
    <c:set var="adminName" value="${sessionScope.nameKey}"></c:set>
    <div class="input_item">
        <font size="5"> 欢迎登录, ${adminName}</font>
    </div>
    <div class="show_item">
        <c:if test="${!empty users}" var="flag">
            用户列表
            <table border="1">
                <tr>
                    <th>用户名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>爱好</th>
                    <th style="width: 60px;"></th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td><c:out value="${user.sex}"></c:out></td>
                        <td><c:out value="${user.age}"></c:out></td>
                        <td><c:out value="${user.like}"></c:out></td>
                        <td style="width: 60px;">
                            <form action="UserDeleteServlet" method="post">
                                <input type="hidden" name="name" value="${user.name}" />
                                <input type="submit" value="删除" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${not flag}">
            暂无用户注册
        </c:if>
    </div>
    <div class="blank"></div>
</div>
</body>
</html>
