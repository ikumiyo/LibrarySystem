<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>图书信息添加</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <style>
        .form-group {
            margin-bottom: 0;
            color: #5cb85c;
        }
    </style>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/bookadd.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative;width: 700px">
<div class="panel panel-primary">
    <div class="panel-heading" style="background-color: #40E0D0">
        <h3 class="panel-title">添加图书</h3>
    </div>
<div style="position: center;padding-top: 10px; width: 90%;margin-left: 5%">
    <form action="manager/bookServlet" method="post" id="add">
        <input type="hidden" name="action" value="add">
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon" >图书名</span>
            <input  type="text" class="form-control" name="name" id="name" placeholder="请输入书名">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon" > 作  者 </span>
            <input  type="text" class="form-control" name="author" id="author" placeholder="请输入作者名">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 出版社 </span>
            <input  type="text" class="form-control" name="publish" id="publish" placeholder="请输入出版社">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> ISBN </span>
            <input  type="text" class="form-control" name="ISBN" id="ISBN" placeholder="请输入ISBN">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 简  介 </span>
            <textarea class="form-control" rows="3" name="introduction" id="introduction"
                      placeholder="请输入简介"></textarea>
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 语  言 </span>
            <input  type="text" class="form-control" name="language" id="language" placeholder="请输入语言">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 价  格 </span>
            <input  type="text" class="form-control" name="price" id="price" placeholder="请输入价格">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon">出版日期</span>
            <input  type="text" class="form-control" name="pub_date" id="pub_date" placeholder="请输入出版日期">
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 分 类 </span>
            <select name="class_id" id="class_id" class="form-control">
                <option value="none">--请选择图书分类--</option>
                <option value="1">马克思主义著作</option>
                <option value="2">哲学</option>
                <option value="3">社会科学总论</option>
                <option value="4">政治、法律</option>
                <option value="5">军事</option>
                <option value="6">经济</option>
                <option value="7">文化、科学、教育、体育</option>
                <option value="8">语言、文字</option>
                <option value="9">文学</option>
                <option value="10">艺术</option>
                <option value="11">历史、地理</option>
                <option value="12">自然科学总论</option>
                <option value="13">数理科学和化学</option>
                <option value="14">天文学、地球科学</option>
                <option value="15">生物科学</option>
                <option value="16">医药、卫生</option>
                <option value="17">农业科学</option>
                <option value="18">工业技术</option>
                <option value="19">交通运输</option>
                <option value="20">航空航天</option>
                <option value="21">环境科学</option>
                <option value="22">综合性图书</option>
            </select>
        </div>
        <div class="input-group" style="padding-top: 10px;">
            <span  class="input-group-addon"> 数 量 </span>
            <input  type="text" class="form-control" name="number" id="number" placeholder="请输入图书数量">
        </div>
        <input type="submit" value="添加图书" class="btn btn-success btn-sm" class="text-left" style="margin-top: 10px ;">
        <script>
            $("#addbook").submit(function () {
                if ($("#name").val() == '' || $("#author").val() == '' || $("#publish").val() == '' || $("#isbn").val() == '' || $("#introduction").val() == '' || $("#language").val() == '' || $("#price").val() == '' || $("#pubstr").val() == '' || $("#classId").val() == '' || $("#pressmark").val() == '' || $("#number").val() == '') {
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
