<%--
  Created by IntelliJ IDEA.
  User: luxinxin
  Date: 2018/8/13
  Time: 上午11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="/html/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <form method="post" action="/user/login">
        <div class="form-group">
            <label for="first_name">First Name:</label>
            <input name="firstName" type="text" class="form-control" id="first_name" placeholder="Enter first name">
            <small class="form-text text-muted text-danger">${errorMsg}</small>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</div>

<script src="/html/js/jquery-3.3.1.min.js"></script>
<script src="/html/js/bootstrap.min.js"></script>
</body>
</html>
