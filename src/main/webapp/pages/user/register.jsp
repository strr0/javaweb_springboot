<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <title></title>
</head>
<body>

<div class="box">
    <div class="blank"></div>
    <div style="float: right; margin-right: 10px;"><a href="index.jsp">返回</a></div>
    <form action="RegisterServlet" method="post" id="register_form" onsubmit="return formCheck()">
        <div class="input_item">
            <font size="5" id="admin" onclick="adminChange()">注册用户</font>
            <input type="hidden" id="adminValue" name="admin" value="no" />
        </div>
        <div class="input_item">
            <div class="input_field">用户名：</div>
            <div class="input_field"><input type="text" id="name" name="name" onblur="isName(this.value)" placeholder="请输入用户名" autocomplete="off" /></div>
            <div class="input_error" id="name_error"></div>
        </div>

        <div class="input_item">
            <div class="input_field">性别：</div>
            <div class="input_field">
                <input type="radio" id="sex" name="sex" value="男" onchange="isSex()">男</input>
                <input type="radio" id="sex" name="sex" value="女" onchange="isSex()">女</input>
            </div>
            <div class="input_error" id="sex_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">年龄：</div>
            <div class="input_field"><input type="text" id="age" name="age" onblur="isAge(this.value)" placeholder="请输入年龄" autocomplete="off" /></div>
            <div class="input_error" id="age_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">密码：</div>
            <div class="input_field"><input type="password" id="pwd" name="password" onblur="isPassword(this.value)" placeholder="请输入密码" autocomplete="off" /></div>
            <div class="input_error" id="password_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">确认密码：</div>
            <div class="input_field"><input type="password" id="comfirm_pwd" name="comfirm_pwd" onblur="isComfirmPWD(this.value)" placeholder="请确认密码" autocomplete="off" /></div>
            <div class="input_error" id="comfirm_pwd_error"></div>
        </div>

        <div class="input_item">
            <div class="input_field">爱好：</div>
            <div class="input_field">
                <input type="checkbox" name="like" value="撩妹" onchange="isLike()">撩妹</input>
                <input type="checkbox" name="like" value="写代码" onchange="isLike()">写代码</input>
                <input type="checkbox" name="like" value="篮球" onchange="isLike()">篮球</input>
                <input type="checkbox" name="like" value="足球" onchange="isLike()">足球</input>
            </div>
            <div class="input_error" id="like_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">个性签名：</div>
            <div class="input_field"><textarea form="register_form" id="tag" name="tag" onblur="isTag(this.value)" placeholder="请输入个性签名" autocomplete="off"></textarea></div>
            <div class="input_error" id="tag_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">
                <input type="submit" class="bt1" value="注册" />
            </div>
            <div class="input_field">
                <input type="button" class="bt1" onclick="window.location.href='RegisterServlet'" value="取消" />
            </div>
        </div>
    </form>
    <div class="blank"></div>
</div>

<script src="js/dataCheck.js"></script>
</body>
</html>

