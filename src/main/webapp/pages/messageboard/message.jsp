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
                    <th style="width: 100px;">用户名</th>
                    <th style="width: 100px;">性别</th>
                    <th style="width: 100px;">年龄</th>
                    <th style="width: 120px;">爱好</th>
                    <th style="width: 80px;"></th>
                </tr>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td><c:out value="${user.sex}"></c:out></td>
                        <td><c:out value="${user.age}"></c:out></td>
                        <td><c:out value="${user.like}"></c:out></td>
                        <td>
                            <div style="overflow: hidden; width: 80px;">
                                <div style="float: left; width: 40px;">
                                    <form action="UserChangeServlet" method="post" style="margin: 0;">
                                        <input type="hidden" name="nameChange" value="${user.name}" />
                                        <input type="submit" style="width: 40px;" value="修改" />
                                    </form>
                                </div>
                                <div style="float: left; width: 40px;">
                                    <form action="UserDeleteServlet" method="post" style="margin: 0;">
                                        <input type="hidden" name="nameDelete" value="${user.name}" />
                                        <input type="submit" style="width: 40px;" value="删除" />
                                    </form>
                                </div>
                            </div>
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
