<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luxinxin
  Date: 2018/8/13
  Time: 上午11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Film列表</title>
    <link rel="stylesheet" href="/html/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">FilmID</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Language</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="item" varStatus="vs">
            <tr>
                <th scope="row">${item.film.filmId}</th>
                <td>${item.film.title}</td>
                <td>${item.film.description}</td>
                <td>${item.language.name}</td>
                <td>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-info" onclick="edit(${item.film.filmId})">编辑</button>
                        <button type="button" class="btn btn-danger" onclick="remove(${item.film.filmId})">删除</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentpage == 1}">
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=3">3</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage == 2}">
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=3">3</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage == 3}">
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=2">2</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=3">3</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=4">4</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage >= 4 && currentpage<=pagesize-3}">
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage-1}">${currentpage-1}</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=${currentpage}">${currentpage}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">${currentpage+1}</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage == pagesize-2 }">
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage-1}">${currentpage-1}</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=${currentpage}">${currentpage}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize-1}">${pagesize-1}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage == pagesize-1}">
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize-2}">${pagesize-2}</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=${currentpage}">${currentpage}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize}">${pagesize}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
            <c:when test="${currentpage == pagesize}">
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage-1}">前一页</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=1">1</a></li>
                <li class="page-item"><a class="page-link">......</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize-2}">${pagesize-2}</a></li>
                <li class="page-item"><a class="page-link" href="/film/list.html?page=${pagesize-1}">${pagesize-1}</a></li>
                <li class="page-item active"><a class="page-link" href="/film/list.html?page=${currentpage}">${currentpage}</a></li>
                <li class="page-item disabled"><a class="page-link" href="/film/list.html?page=${currentpage+1}">后一页</a></li>
            </c:when>
        </c:choose>
    </ul>
</div>
<script src="/html/js/jquery-3.3.1.min.js"></script>
<script src="/html/js/bootstrap.min.js"></script>
<script>
    function edit(id) {
        window.location.href = "/film/edit.html?id=" + id + "&backurl="+window.location.href;
    }

    function remove(id) {
        if (confirm("确定要删除？不可恢复")) {
            window.location.href = "/film/delete?id=" + id + "&backurl=" + window.location.href;
        }
    }
</script>
</body>
</html>
