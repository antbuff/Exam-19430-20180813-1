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
    <title>编辑页面</title>
    <link rel="stylesheet" href="/html/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form method="post" action="/film/edit">
        <div class="form-group">
            <label>Film ID：</label>
            <input type="text" class="form-control" name="filmId" value="${film.filmId}" readonly>
        </div>
        <div class="form-group">
            <label>Title：</label>
            <input type="text" class="form-control" name="title" value="${film.title}">
        </div>
        <div class="form-group">
            <label >Description：</label>
            <textarea class="form-control" name="description">${film.description}</textarea>
        </div>
        <div class="form-group">
            <label>Release year：</label>
            <input type="text" class="form-control" value="${film.releaseYear}" readonly>
        </div>
        <div class="form-group">
            <label>Language：</label>
            <select class="form-control" name="languageId">
                <c:forEach items="${languages}" var="item" varStatus="vs">
                    <c:choose>
                        <c:when test="${item.languageId == film.languageId}">
                            <option value="${item.languageId}" selected>${item.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${item.languageId}">${item.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Original language id：</label>
            <input type="text" class="form-control" value="${film.originalLanguageId}" readonly>
        </div>
        <div class="form-group">
            <label>Rental duration：</label>
            <input type="text" class="form-control" value="${film.rentalDuration}" readonly>
        </div>
        <div class="form-group">
            <label>Rental rate：</label>
            <input type="text" class="form-control" value="${film.rentalRate}" readonly>
        </div>
        <div class="form-group">
            <label>Length：</label>
            <input type="text" class="form-control" value="${film.length}" readonly>
        </div>
        <div class="form-group">
            <label>Replacement cost：</label>
            <input type="text" class="form-control" value="${film.replacementCost}" readonly>
        </div>
        <div class="form-group">
            <label>Rating：</label>
            <input type="text" class="form-control" value="${film.rating}" readonly>
        </div>
        <div class="form-group">
            <label>Special features：</label>
            <input type="text" class="form-control" value="${film.specialFeatures}" readonly>
        </div>
        <div class="form-group">
            <label>Last update：</label>
            <input type="text" class="form-control" value="${film.lastUpdate}" readonly>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="/html/js/jquery-3.3.1.min.js"></script>
<script src="/html/js/bootstrap.min.js"></script>
</body>
</html>
