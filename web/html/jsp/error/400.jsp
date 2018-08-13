<%--
  Created by IntelliJ IDEA.
  User: luxinxin
  Date: 2018/8/13
  Time: 上午9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>错误页面</title>
    <link rel="stylesheet" href="/html/css/bootstrap.min.css" type="text/css">
</head>
<body>
<div class="container">
    <h4 class="text-danger">用户不存在，禁止登陆！</h4>
    <button class="btn btn-info" onclick="back()">返回</button>
</div>
<script rel="script" src="/html/js/jquery-3.3.1.min.js"></script>
<script rel="script" src="/html/js/bootstrap.min.js"></script>
<script>
    function back() {
        history.go(-1);
    }
</script>
</body>
</html>
