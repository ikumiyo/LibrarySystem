<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>借还日志</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/lendlist.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>
<div class="panel panel-default" style="position:relative;top: 80px;width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
            借还日志
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>流水号</th>
                <th>图书号</th>
                <th>读者证号</th>
                <th>借出日期</th>
                <th>归还日期</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.lendList}" var="lendInfo">
                <tr>
                    <td>${lendInfo.ser_num}</td>
                    <td>${lendInfo.book_id}</td>
                    <td>${lendInfo.reader_id}</td>
                    <td>${lendInfo.lend_date}</td>
                    <td>${lendInfo.back_date}</td>
                    <td>
                        <a href="manager/readerServlet?action=deleteLendRecord&ser_num=${lendInfo.ser_num}">
                            <c:if test="${!empty lendInfo.back_date}">
                                <button type="button" class="btn btn-danger btn-xs">删除</button>
                            </c:if>
                            <c:if test="${empty lendInfo.back_date}">
                                <button type="button" class="btn btn-default btn-xs" disabled="disabled">删除</button>
                            </c:if>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
