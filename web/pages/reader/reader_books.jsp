<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
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
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/readerbooks.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>

<div style="padding: 20px 550px 10px">
    <form method="post" action="clientBookServlet" class="form-inline" id="searchform">
        <input type="hidden" name="action" value="queryBookByCondition">
        <div class="input-group">
            <input type="text" placeholder="输入图书名/作者" class="form-control" id="search" name="searchWord"
                   class="form-control" style="width: 380px">
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
                <th>借还</th>
                <th>详情</th>
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

                    <c:set var="flag" value="false"/>
                    <c:forEach var="lend" items="${myLendList}">
                        <c:if test="${lend.book_id eq book.book_id && empty lend.back_date}">
                            <c:set var="flag" value="true"/>
                        </c:if>
                    </c:forEach>
                    <c:if test="${flag}">
                        <td><a href="clientBookServlet?action=returnBook&bookId=${book.book_id}&readerId=${sessionScope.Id}">
                            <button type="button" class="btn btn-danger btn-xs">归还</button>
                        </a></td>
                    </c:if>
                    <c:if test="${not flag}">
                        <c:if test="${book.number>0}">
                            <td><a href="clientBookServlet?action=lendBook&bookId=${book.book_id}&readerId=${sessionScope.Id}">
                                <button type="button" class="btn btn-primary btn-xs">借阅</button>
                            </a></td>
                        </c:if>
                        <c:if test="${book.number==0}">
                            <td>
                                <button type="button" class="btn btn-defalut btn-xs" disabled="disabled">已空</button>
                            </td>
                        </c:if>
                    </c:if>
                    <td><a href="clientBookServlet?action=getBookDetails&bookId=${book.book_id}">
                        <button type="button" class="btn btn-success btn-xs">详情</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
