<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/7/30
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>Title</title>
    <style>
        td{
            border:1px solid;
        }
    </style>
</head>
<%!
    class Person{
        public String id;
        public String name;
        public String sex;
        public String age;
        public String password;
        public String phone;
        public String [] hobby;
        public String qinamin;
    }
    Vector<Person> p = new Vector<>();
%>
<%
    request.setCharacterEncoding("UTF-8");
    Person pn = new Person();
    pn.id = request.getParameter("name");
    pn.name = request.getParameter("name2");
    pn.sex = request.getParameter("sex");
    pn.age = request.getParameter("age");
    pn.password = request.getParameter("password");
    pn.phone = request.getParameter("phone");
    pn.hobby = request.getParameterValues("hobby");
    pn.qinamin = request.getParameter("qianmin");

    p.add(pn);
%>
<body>
<div style="width:1000;margin:auto;background:aliceblue;">
    <p style="width:200px; margin:auto;font-size:300%">后端页面</p><br/>
    <table style="width:800;margin:auto;border:1px solid;border-collapse: collapse">
        <tr><td>用户名</td><td>真实姓名</td><td>性别</td><td>年龄</td><td>密码</td><td>电话号码</td><td>爱好</td><td>个性签名</td></tr>
        <% for(int i=0;i<p.size();i++){ %>
        <tr><td><%= p.elementAt(i).id%></td><td><%= p.elementAt(i).name%></td><td><%= p.elementAt(i).sex%></td><td><%= p.elementAt(i).age%></td><td><%= p.elementAt(i).password%></td><td><%= p.elementAt(i).phone%></td><td>
            <% for(int j=0;j<p.elementAt(i).hobby.length;j++) {%>
            <%= p.elementAt(i).hobby[j]%>
            <%}%>
        </td><td><%= p.elementAt(i).qinamin%></td></tr>
        <%}%>
    </table>
</div>
</body>
</html>
