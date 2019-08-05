<%@ page import="java.util.List" %>
<%@ page import="com.ucar.training.User" %><%--
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
    <c:set var="users" value="${applicationScope.usersKey}"></c:set>
    <c:set var="uName" value="${sessionScope.nameKey}"></c:set>
    <c:if test="${!empty users}" var="flag">
        欢迎登录, ${uName}<br/>
        用户列表<br/>
        <table border="1">
            <tr>
                <th>用户名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>爱好</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <c:if test="${uName != user.name}">
                    <tr>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td><c:out value="${user.sex}"></c:out></td>
                        <td><c:out value="${user.age}"></c:out></td>
                        <td><c:out value="${user.like}"></c:out></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${not flag}">
        <h1>暂无用户注册</h1>
    </c:if>
</div>
</body>
</html>
