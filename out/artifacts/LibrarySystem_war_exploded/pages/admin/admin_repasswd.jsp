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
    <title>更改密码</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/adminPasswd.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 100px"></div>

<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary ">
        <div class="panel-heading" style="background-color: #40E0D0">
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
            <form action="manager/adminServlet" method="post" id="repasswd">
                <input type="hidden" name="action" value="resetPassword">
                <input type="hidden" name="Id" value="${sessionScope.Id}">
                <div class="input-group">
                    <input type="password" id="oldPassword" name="oldPassword" placeholder="输入旧密码" class="form-control"
                           class="form-control">
                    <input type="password" id="newPassword" name="newPassword" placeholder="输入新密码" class="form-control"
                           class="form-control">
                    <input type="password" id="reNewPassword" name="reNewPassword" placeholder="再次输入新密码"
                           class="form-control" class="form-control">
                    <em id="tishi" style="color: red"></em>
                    <br/>
                    <div class="msg_cont">
                        <b></b>
                        <span class="errorMsg" style="color: red">
                            ${empty requestScope.msg?"":requestScope.msg}
                        </span>
                    </div>
                    <span>
                            <input type="submit" value="确认修改" class="btn btn-default" style="margin-top: 10px">
                    </span>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).keyup(function () {
        if ($("#newPassword").val() != $("#reNewPassword").val() && $("#newPassword").val() != "" && $("#reNewPassword").val() != "" && $("#newPassword").val().length == $("#reNewPassword").val().length) {
            $("#tishi").text("两次输入的新密码不同，请检查");
        } else {
            $("#tishi").text("");
        }
    })

    $("#repasswd").submit(function () {
        if ($("#oldPassword").val() == '' || $("#newPassword").val() == '' || $("#reNewPassword").val() == '') {
            $("#tishi").text("请填写完毕后提交");
            return false;
        } else if ($("#newPassword").val() != $("#reNewPassword").val()) {
            $("#tishi").text("两次输入的新密码不同，请检查");
            return false;
        }
    })
</script>
</body>
</html>
