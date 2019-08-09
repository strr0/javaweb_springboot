<%@ page language="java"  pageEncoding="UTF-8"%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>首页</title>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <style>
    body{
      background-color: gray;
    }
    .box{
      width: 550px;
      background-color: lavenderblush;
      margin: auto;
    }
    .blank{
      height: 20px;
    }
    .show_item{
      width: 500px;
      margin: 10px 20px 0px;
      overflow: hidden;
    }
  </style>
</head>

<body>
<div class="box">
  <div class="blank"></div>
  <div class="show_item" style="text-align: center;">
    <h1>神州优车训练营网站</h1>
    <div class="blank" style="overflow: hidden;">
      <div style="float: right">
        <a href="UploadServlet">upload</a> <a href="DownloadServlet">download</a>
      </div>
    </div>
    <div>
      <a href="RegisterServlet">注册</a> | <a href="LoginServlet">登录</a>
    </div>
  </div>
  <div class="blank"></div>
</div>

</body>
</html>
