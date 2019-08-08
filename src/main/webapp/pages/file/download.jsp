<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8
  Time: 10:14
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
    <div class="show_item">
        <div>
            <font size="5">图片下载</font>
        </div>
        <div class="blank"></div>
        <c:set var="filenames" value="${requestScope.fileNamesKey}"></c:set>
        <c:if test="${!empty filenames}">
            <c:forEach var="filename" items="${filenames}">
                <div style="float: left; margin-right: 10px;">
                    <img src="upload/${filename}" width="100px" height="100px"><br/>
                    <a href="DownloadServlet?name=${filename}">下载</a>
                </div>
            </c:forEach>
        </c:if>
    </div>
    <div class="blank"></div>
</div>
</body>
</html>
