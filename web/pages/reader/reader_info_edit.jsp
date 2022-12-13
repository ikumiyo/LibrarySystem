<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!--	写base标签，永远固定相对路径-->
<base href="<%=basePath%>">
<html>
<head>
    <title>${readercard.name}的主页</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/reader/reader_header.jsp');
        })
    </script>
</head>
<body background="static/img/reader_info_edit.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<div id="header" style="padding-bottom: 80px"></div>
<div class="col-xs-5 col-md-offset-3">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                信息修改
            </h3>
        </div>
        <div class="panel-body">
            <form action="clientBookServlet" method="post" id="update">
                <input type="hidden" name="action" value="update">
                <div class="input-group">
                    <span  class="input-group-addon">读者证号</span>
                    <input type="text" readonly="readonly" class="form-control" name="reader_id" id="reader_id" value="${requestScope.readerInfo.reader_id}">
                </div>
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
                    <span  class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone"  value="${requestScope.readerInfo.phone}" >
                </div>
                <br/>
                <input type="submit" value="确定修改" class="btn btn-success btn-sm" class="text-left">
                <script>
                    $("#edit").submit(function () {
                        if($("#name").val()==''||$("#sex").val()==''||$("#birth").val()==''||$("#address").val()==''||$("#phone").val()==''){
                            alert("请填入完整图书信息！");
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
