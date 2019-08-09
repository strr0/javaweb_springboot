<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7
  Time: 15:05
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
    <c:set var="user" value="${requestScope.userKey}"></c:set>
    <div class="blank"></div>
    <div class="home_bt"><a href="index.jsp">返回</a></div>
    <form action="UserChangeServlet" method="post" id="change_form" onsubmit="return changeCheck()">
        <div class="input_item">
            <font size="5">修改信息</font>
        </div>
        <c:if test="${!empty user}">
            <div class="input_item">
                <div class="input_field">用户名: </div>
                <div class="input_field">
                    <input type="text" name="name" value="${user.name}" readonly />
                </div>
            </div>
            <div class="input_item">
                <div class="input_field">性别: </div>
                <div class="input_field">
                    <input type="radio" id="sex" name="sex" value="男" ${user.sex.contains("男")?"":"checked"}>男</input>
                    <input type="radio" id="sex" name="sex" value="女" ${user.sex.contains("女")?"":"checked"}>女</input>
                </div>
            </div>
            <div class="input_item">
                <div class="input_field">年龄: </div>
                <div class="input_field">
                    <input type="text" name="age" id="age" onblur="isAge(this.value)" value="${user.age}" />
                </div>
                <div class="input_error" id="age_error"></div>
            </div>
            <div class="input_item">
                <div class="input_field">爱好：</div>
                <div class="input_field">
                    <input type="checkbox" name="like" value="撩妹" onblur="isLike()" ${user.like.contains("撩妹")?"":"checked"}>撩妹</input>
                    <input type="checkbox" name="like" value="写代码" onblur="isLike()" ${user.like.contains("写代码")?"":"checked"}>写代码</input>
                    <input type="checkbox" name="like" value="篮球" onblur="isLike()" ${user.like.contains("篮球")?"":"checked"}>篮球</input>
                    <input type="checkbox" name="like" value="足球" onblur="isLike()" ${user.like.contains("足球")?"":"checked"}>足球</input>
                </div>
                <div class="input_error" id="like_error"></div>
            </div>
            <div class="input_item">
                <div class="input_field">个性签名：</div>
                <div class="input_field"><textarea form="change_form" id="tag" name="tag" onblur="isTag(this.value)">${user.tag}</textarea></div>
                <div class="input_error" id="tag_error"></div>
            </div>
            <div class="input_item">
                <div class="input_field">
                    <input type="submit" value="确认" />
                </div>
            </div>
        </c:if>
    </form>
    <div class="blank"></div>
</div>
<script src="js/dataCheck.js"></script>
</body>
</html>
