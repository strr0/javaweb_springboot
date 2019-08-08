<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="box">
    <div class="blank"></div>
    <div class="show_item">
        <font size="5">图片上传</font>
        <div class="blank"></div>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="uploadFile" accept="image/*" />
            <input type="submit" value="上传" />
        </form>
    </div>
    <div class="blank"></div>
</div>
</body>
</html>
