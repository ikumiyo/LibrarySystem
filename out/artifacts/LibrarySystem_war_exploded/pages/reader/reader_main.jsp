<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!--	写base标签，永远固定相对路径-->
<base href="<%=basePath%>">
<html>
<head>
    <title>${sessionScope.reader}的主页</title>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/reader_main.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>

</body>
</html>
