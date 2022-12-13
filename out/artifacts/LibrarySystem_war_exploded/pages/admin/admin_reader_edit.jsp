<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>编辑读者信息《 ${requestScope.readerInfo.reader_id}》</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/admin_reader_edit.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 80px"></div>
<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary">
        <div class="panel-heading" style="background-color: #40E0D0">
            <h3 class="panel-title">编辑读者信息《 ${requestScope.readerInfo.reader_id}》</h3>
        </div>
        <div class="panel-body">
            <form action="manager/readerServlet" method="post" id="update">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="reader_id" value="${requestScope.readerInfo.reader_id}">
                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${requestScope.readerInfo.name}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex"  value="${requestScope.readerInfo.sex}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">生日</span>
                    <input type="text" class="form-control" name="birth" id="birth"  value="${requestScope.readerInfo.birth}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" id="address"  value="${requestScope.readerInfo.address}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone" value="${requestScope.readerInfo.phone}" >
                </div>
                <input type="submit" value="确定修改" class="btn btn-success btn-sm" class="text-left" style="margin-top: 10px">
                <script>
                    $("#readeredit").submit(function () {
                        if($("#name").val()==''||$("#sex").val()==''||$("#birth").val()==''||$("#address").val()==''||$("#phone").val()==''){
                            alert("请填入完整读者信息！");
                            return false;
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
