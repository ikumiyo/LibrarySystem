<%@ page contentType="text/html;charset=UTF-8"  language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <title>图书馆首页</title>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script src="static/js/js.cookie.js"></script>
    <style>
        #login{
           height: 40%;
            width: 28%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
            position: center;
        }

        .form-group {
            margin-bottom: 0;
        }
        * {
            padding:0;
            margin:0;
        }
    </style>
</head>
<body background="static/img/index.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<c:if test="${!empty error}">
    <script>
            alert("${error}");
            window.location.href="login.html";
</script>
</c:if>
<h2 style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">图 书 管 理 系 统</h2>

<div class="panel panel-default" id="login">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">请登录</h3>
    </div>
    <div class="panel-body">
        <form action="loginServlet" method="post">
            <input type="hidden" name="action" value="login">
        <div class="form-group">
            <label for="id">账号</label>
            <input type="text" class="form-control" id="id" placeholder="请输入账号" name="Id" value="${requestScope.Id}">
        </div>
        <div class="form-group">
            <label for="passwd">密码</label>
            <input type="password" class="form-control" id="passwd" placeholder="请输入密码" name="password">
        </div>

        <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>

        <button id="loginButton"  class="btn btn-primary  btn-block">登陆</button>
            <div class="msg_cont">
                <b></b>
                <span class="errorMsg" style="color: red">
                    ${empty requestScope.msg?"":requestScope.msg}
                </span>
            </div>
        </form>
    </div>
</div>
<script>
    $("#id").keyup(
        function () {
            if(isNaN($("#id").val())){
                $("#info").text("提示:账号只能为数字");
            }
            else {
                $("#info").text("");
            }
        }
    )

    $("#loginButton").click(function () {
        var id =$("#id").val();
        var passwd=$("#passwd").val();
        if (id == '') {
            $("#info").text("提示:账号不能为空");
        }
        else if( passwd ==''){
            $("#info").text("提示:密码不能为空");
        }
        else if(isNaN( id )){
            $("#info").text("提示:账号必须为数字");
        }
    })

</script>

</body>
</html>
