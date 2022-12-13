<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>全部图书信息</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/books.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>

<div style="padding: 70px 550px 10px">
    <form method="post" action="manager/bookServlet" class="form-inline" id="searchform">
        <input type="hidden" name="action" value="queryBookByCondition">
        <div class="input-group">
            <input type="text" placeholder="请输入图书名/作者" class="form-control" id="search" name="searchWord"
                   class="form-control" style="width: 380px" >
            <span class="input-group-btn">
                <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        $("#searchform").submit(function () {
            var val = $("#search").val();
            if (val == '') {
                alert("请输入关键字");
                return false;
            }
        })
    </script>
</div>

<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部图书
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>ISBN</th>
                <th>价格</th>
                <th>剩余数量</th>
                <th>详情</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.books}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.publish}</td>
                    <td><"${book.ISBN}"></td>
                    <td>${book.price}</td>
                    <td>${book.number}</td>
                    <td><a href="manager/bookServlet?action=getBookDetails&book_id=${book.book_id}">
                        <button type="button" class="btn btn-success btn-xs">详情</button>
                    </a></td>
                    <td><a href="manager/bookServlet?action=editBook&book_id=${book.book_id}">
                        <button type="button" class="btn btn-info btn-xs">编辑</button>
                    </a></td>
                    <td><a href="manager/bookServlet?action=delete&book_id=${book.book_id}">
                        <button type="button" class="btn btn-danger btn-xs">删除</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
