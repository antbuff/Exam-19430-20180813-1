<%@ page import="com.lxx.exam.domain.Customer" %><%--
  Created by IntelliJ IDEA.
  User: luxinxin
  Date: 2018/8/13
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer ct = (Customer)request.getAttribute("user");
%>
<html>
<head>
    <title>电影租赁系统</title>
    <link rel="stylesheet" href="html/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <ul class="list-group">
        <li class="list-group-item disabled"><%="Welcome, "+ct.getFirstName()+" "+ ct.getLastName()%></li>
        <li class="list-group-item"><a href="/user/logout">注销</a></li>
        <li class="list-group-item"><a href="/film/list.html">查看</a></li>
        <li class="list-group-item"><a href="/film/add.html">添加</a></li>
    </ul>
</div>
<script rel="script" src="html/js/jquery-3.3.1.min.js"></script>
<script rel="script" src="html/js/bootstrap.min.js"></script>
</body>
</html>
