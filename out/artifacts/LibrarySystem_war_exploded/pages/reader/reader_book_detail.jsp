<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>《 ${requestScope.bookDetails.name}》</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/bookdetails.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">《 ${requestScope.bookDetails.name}》</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="15%">书名</th>
                    <td>${requestScope.bookDetails.name}</td>
                </tr>
                <tr>
                    <th>作者</th>
                    <td>${requestScope.bookDetails.author}</td>
                </tr>
                <tr>
                    <th>出版社</th>
                    <td>${requestScope.bookDetails.publish}</td>
                </tr>
                <tr>
                    <th>ISBN</th>
                    <td>${requestScope.bookDetails.ISBN}</td>
                </tr>
                <tr>
                    <th>简介</th>
                    <td>${requestScope.bookDetails.introduction}</td>
                </tr>
                <tr>
                    <th>语言</th>
                    <td>${requestScope.bookDetails.language}</td>
                </tr>
                <tr>
                    <th>价格</th>
                    <td>${requestScope.bookDetails.price}</td>
                </tr>
                <tr>
                    <th>出版日期</th>
                    <td>${requestScope.bookDetails.pub_date}</td>
                </tr>
                <tr>
                    <th>分类号</th>
                    <td>${requestScope.bookDetails.class_id}</td>
                </tr>
                <tr>
                    <th>状态</th>
                    <c:if test="${requestScope.bookDetails.number>1}">
                        <td>在馆</td>
                    </c:if>
                    <c:if test="${requestScope.bookDetails.number==0}">
                        <td>借出</td>
                    </c:if>

                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
