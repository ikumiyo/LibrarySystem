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
    <title>密码修改</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/readerPasswd.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header"></div>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;margin-top: 50px">
    <div class="panel panel-primary ">
        <div class="panel-heading" >
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
            <form action="clientBookServlet" method="post" id="repasswd">
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
            $("#tishi").text("提示:两次输入的新密码不同，请检查!");
        } else {
            $("#tishi").text("");
        }
    })

    $("#repasswd").submit(function () {
        if ($("#oldPassword").val() == '' || $("#newPassword").val() == '' || $("#reNewPassword").val() == '') {
            $("#tishi").text("提示:请填写完整!");
            return false;
        } else if ($("#newPassword").val() != $("#reNewPassword").val()) {
            $("#tishi").text("提示:两次输入的新密码不同，请检查!");
            return false;
        }
    })
</script>


</body>
</html>
