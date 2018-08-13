<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luxinxin
  Date: 2018/8/13
  Time: 下午6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
    <link rel="stylesheet" href="/html/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form method="post" action="/film/add">
        <div class="form-group">
            <label>Title：</label>
            <input type="text" name="title" class="form-control" placeholder="Enter title" value="Test post">
        </div>
        <div class="form-group">
            <label >Description：</label>
            <textarea class="form-control" name="description" placeholder="Enter description">Coming soon...</textarea>
        </div>
        <div class="form-group">
            <label>Release year：</label>
            <input type="text" class="form-control" name="releaseYear" placeholder="Enter release year">
        </div>
        <div class="form-group">
            <label>Language：</label>
            <select class="form-control" name="languageId">
                <c:forEach items="${languages}" var="item" varStatus="vs">
                    <option value="${item.languageId}">${item.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Rental duration：</label>
            <input type="text" class="form-control" name="rentalDuration" placeholder="Enter rental duration">
        </div>
        <div class="form-group">
            <label>Rental rate：</label>
            <input type="text" class="form-control" name="rentalRate" placeholder="Enter rental rate">
        </div>
        <div class="form-group">
            <label>Length：</label>
            <input type="text" class="form-control" name="length" placeholder="Enter length">
        </div>
        <div class="form-group">
            <label>Replacement cost：</label>
            <input type="text" class="form-control" name="replacementCost" placeholder="Enter replacement cost">
        </div>
        <div class="form-group">
            <label>Rating：</label>
            <input type="text" class="form-control" name="rating" placeholder="Enter rating">
        </div>
        <div class="form-group">
            <label>Special features：</label>
            <input type="text" class="form-control" name="specialFeatures" placeholder="Enter special features">
        </div>
        <div class="form-group">
            <label>Last update：</label>
            <input type="text" class="form-control" name="lastUpdate" placeholder="Enter last update">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="/html/js/jquery-3.3.1.min.js"></script>
<script src="/html/js/bootstrap.min.js"></script>
</body>
</html>
