<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/1
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <title></title>
</head>
<body>
<div class="box">
    <form action="success.jsp" method="post" id="register_form" onsubmit="return formCheck()">
        <div class="input_item" style="margin: 20px;">
            <font size="5">注册用户</font>
        </div>
        <div class="input_item">
            <div class="input_field">用户名：</div>
            <div class="input_field"><input type="text" id="name" name="name" onblur="isName(this.value)" placeholder="请输入用户名" autocomplete="off" /></div>
            <div class="input_error" id="name_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">真实姓名：</div>
            <div class="input_field"><input type="text" id="real_name" name="real_name" onblur="isRealName(this.value)" placeholder="请输入真实姓名" autocomplete="off" /></div>
            <div class="input_error" id="real_name_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">性别：</div>
            <div class="input_field">
                <input type="radio" id="sex" name="sex" value="male" onchange="isSex()">男</input>
                <input type="radio" id="sex" name="sex" value="female" onchange="isSex()">女</input>
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
            <div class="input_field">电话号码：</div>
            <div class="input_field"><input type="tel" name="tel" id="tel" onblur="isTel(this.value)" placeholder="请输入电话号码" autocomplete="off" /></div>
            <div class="input_error" id="tel_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">邮箱地址：</div>
            <div class="input_field"><input type="text" name="email" id="email" onblur="isEmail(this.value)" placeholder="请输入邮箱" autocomplete="off" /></div>
            <div class="input_error" id="email_error"></div>
        </div>
        <div class="input_item">
            <div class="input_field">爱好：</div>
            <div class="input_field">
                <input type="checkbox" name="like" value="girl" onchange="isLike()">撩妹</input>
                <input type="checkbox" name="like" value="code" onchange="isLike()">写代码</input>
                <input type="checkbox" name="like" value="basketball" onchange="isLike()">篮球</input>
                <input type="checkbox" name="like" value="soccer" onchange="isLike()">足球</input>
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
                <input type="submit" value="注册" />
            </div>
            <div class="input_field">
                <input type="button" value="取消" />
            </div>
        </div>
    </form>
</div>

<script src="../js/dataCheck.js"></script>
</body>
</html>

