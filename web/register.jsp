<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/7/30
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <style>
        label{
            color: red;
        }
    </style>
</head>
<body>
<div style="width:600px; margin:auto;background:aliceblue" >
    <form name="form1" onsubmit="return sub()" action="success.jsp" method="post">
        <p style="width:200px; margin:auto;font-size:300%">注册页面</p>
        <br/>
        <table>
            <tr><td>用户名：</td><td><input type="text" name="name" onblur="nameF()" style="margin: auto"></td><td><label id="name">*{为必填}</label></td></tr>
            <tr><td>真实姓名：</td> <td><input type="text" name="name2"></td><td></td></tr>
            <tr><td>性别：</td><td>男<input type="radio" name="sex" value="男" onblur="sexF()">女<input type="radio" name="sex" value="女" onblur="sexF()"></td><td><label id="sex">*{为必填}</label></td></tr>
            <tr><td>年龄：</td><td><input type="text" name="age" onblur="ageF()"></td><td><label id="age">*{为必填}</label></td></tr>
            <tr><td>密码：</td><td><input type="password" name="password" onblur="passwordF()"></td><td><label id="password">*{为必填}</label></td></tr>
            <tr><td>确认密码：</td><td><input type="password" name="password2" onblur="password2F()"></td><td><label id="password2">*{为必填}</label></td></tr>
            <tr><td> 电话号码：</td><td><input type="text" name="mail"></td><td></td></tr>
            <tr><td>爱好：</td><td>唱<input type="checkbox" name="hobby" value="唱" onblur="hobbyF()"> 跳<input type="checkbox" name="hobby" value="跳" onblur="hobbyF()"> 篮球<input type="checkbox" name="hobby" value="篮球" onblur="hobbyF()">
        rap<input type="checkbox" name="hobby" value="rap" onblur="hobbyF()"></td><td><label id="hobby">*{为必填}</label></td></tr>
            <tr><td>个性签名：</td><td><textarea rows="10" cols="30" name="qianmin" onblur="qianminF()"></textarea></td><td><label id="qianmin">*{为必填}</label></td></tr>
        <tr><td><input type="submit" value="注册"></td><td><input type="reset" value="取消"></td><td></td></tr>
        </table>
    </form>
    </div>
<script>
    var x1 = 0,x2 = 0,x3 = 0,x4 = 0,x5 = 0,x6 = 0,x7 = 0;
    function nameF(){
        var p = document.getElementById("name");
        var i = document.form1.name;
       if(i.value.length<6 || i.value.length>16){
           p.innerHTML="长度6——16字符且只能是数字和字母";
           x1 = 0;
       }
       else{
           var flag = 1;
           for(x=0;x<i.value.length;x++){
               if(!((i.value[x]>='0' && i.value[x]<='9') || (i.value[x]>='a' && i.value[x]<='z') || (i.value[x]>='A' && i.value[x]<='Z'))){
                   p.innerHTML="长度6——16字符且只能是数字和字母";
                   x1 = 0;
                   flag = 0;
                   break;
               }
           }
           if(flag == 1){
               p.innerHTML= "";
               x1 = 1;
           }
       }
    }
    function sexF(){
        var p = document.getElementById("sex");
        var i = document.form1.sex;
        if(i.value == "男" || i.value=="女"){
            p.innerHTML="";
            x2 = 1;
        }
    }
    function ageF() {
        var p = document.getElementById("age");
        var i = document.form1.age;
        var s = Number(i.value);
        if((s<1 || s>150) && !isNaN(s)){
            p.innerHTML = "1-——150之间";
            x3 = 0;
        }
        else if(isNaN(s)){
            p.innerHTML = "请输入数字";
            x3 = 0;
        }
        else{
            p.innerHTML="";
            x3=1;
        }

    }
    function passwordF() {
        var p = document.getElementById("password");
        var i = document.form1.password;
        if(i.value.length<6 || i.value.length>18){
            p.innerHTML="长度6——18字符且只能是数字和字母";
            x4 = 0;
        }
        else{
            var flag = 1;
            for(x=0;x<i.value.length;x++){
                if(!((i.value[x]>='0' && i.value[x]<='9') || (i.value[x]>='a' && i.value[x]<='z') || (i.value[x]>='A' && i.value[x]<='Z'))){
                    p.innerHTML="长度6——18字符且只能是数字和字母";
                    x4 = 0;
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                p.innerHTML= "";
                x4 = 1;
            }
        }
    }
    function password2F() {
        var p = document.getElementById("password2");
        var i = document.form1.password2;
        var father = document.form1.password;
        if(i.value == father.value){
            x5 = 1;
            p.innerHTML = "";
        }
        else{
            x5 = 0;
            p.innerHTML = "前后密码不一致";
        }
    }
    function hobbyF() {
        var p = document.getElementById("hobby");
        var i = document.form1.hobby;
        var x = 0;
        p.innerHTML = i[1].checked;
        for(s=0;s<i.length;s++){
            if(i[s].checked) x++;
        }
        if(x>0){
            p.innerHTML = "";
            x6 = 1;
        }
        else{
            p.innerHTML = "至少选择一个爱好";
            x6 = 0;
        }
    }
    function qianminF() {
        var p = document.getElementById("qianmin");
        var i = document.form1.qianmin;
        if(i.value==""){
            p.innerHTML="签名不能为空";
            x7 = 0;
        }
        else{
            p.innerHTML = "";
            x7 = 1;
        }
    }
    function sub() {
        if(x1 && x2 && x3 && x4 && x5 && x6 && x7) return true;
        else return false;
}
</script>
</body>
</html>
