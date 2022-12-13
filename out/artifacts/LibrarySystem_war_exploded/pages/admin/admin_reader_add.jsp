<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>添加读者</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/readeradd.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative">
    <div class="panel panel-primary">
        <div class="panel-heading" style="background-color: #40E0D0">
            <h3 class="panel-title">添加读者</h3>
        </div>
        <div class="panel-body">
            <form action="manager/readerServlet" method="post" id="add">
                <input type="hidden" name="action" value="add">
                <div class="input-group" style="padding-top: 5px;">
                    <span  class="input-group-addon">密码</span>
                    <input  type="password" class="form-control" name="password" id="password" >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span  class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex" >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">生日</span>
                    <input type="text" class="form-control" name="birth" id="birth"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span  class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" id="address"  >
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone"  >
                </div>
                <input style="align-items: center;margin-top: 15" type="submit" value="添加读者" class="btn btn-success btn-sm"
                       class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#readeredit").submit(function () {
                        if($("#password").val()==''||$("#name").val()==''||$("#sex").val()==''||$("#birth").val()==''||$("#address").val()==''||$("#phone").val()==''){
                            alert("请填入完整读者信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
