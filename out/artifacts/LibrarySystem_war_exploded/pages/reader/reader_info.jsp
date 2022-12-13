<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!--	写base标签，永远固定相对路径-->
<base href="<%=basePath%>">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${requestScope.readerInfo.name}的主页</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/myinfo.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 80px"></div>
<c:if test="${!empty succ}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${succ}
    </div>
</c:if>
<c:if test="${!empty error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${error}
    </div>
</c:if>
<div class="col-xs-5 col-md-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                我的信息
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th width="20%">读者证号</th>
                    <td>${requestScope.readerInfo.reader_id}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${requestScope.readerInfo.name}</td>
                </tr>
                <tr>
                    <th>性别</th>
                    <td>${requestScope.readerInfo.sex}</td>
                </tr>
                <tr>
                    <th>生日</th>
                    <td>${requestScope.readerInfo.birth}</td>
                </tr>
                <tr>
                    <th>地址</th>
                    <td>${requestScope.readerInfo.address}</td>
                </tr>
                <tr>
                    <th>电话</th>
                    <td>${requestScope.readerInfo.phone}</td>
                </tr>
                </tbody>
            </table>
            <a class="btn btn-success btn-sm" href="clientBookServlet?action=getEditReaderInfo&readerId=${sessionScope.Id}" role="button" style="margin-left: 5px">修改个人信息</a>
        </div>
    </div>
</div>


</body>
</html>
