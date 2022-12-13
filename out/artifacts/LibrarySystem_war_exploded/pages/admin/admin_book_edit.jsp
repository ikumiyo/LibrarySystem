<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <!--	写base标签，永远固定相对路径-->
    <base href="<%=basePath%>">
    <title>编辑《 ${requestScope.bookDetails.name}》</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery-3.2.1.js"></script>
    <script src="static/js/bootstrap.min.js" ></script>
    <script>
        $(function () {
            $('#header').load('pages/admin/admin_header.jsp');
        })
    </script>
</head>
<body background="static/img/bookdetails.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header" style="padding-bottom: 80px"></div>

<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary">
        <div class="panel-heading" style="background-color:#40E0D0">
            <h3 class="panel-title">编辑《 ${requestScope.bookDetails.name}》</h3>
        </div>
        <div class="panel-body">
            <form action="manager/bookServlet" method="post" id="update">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="book_id" value="${requestScope.bookDetails.book_id}">
                <div class="input-group">
                    <span  class="input-group-addon" >书名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${requestScope.bookDetails.name}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">作者</span>
                    <input type="text" class="form-control" name="author" id="author" value="${requestScope.bookDetails.author}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="publish" id="publish"  value="${requestScope.bookDetails.publish}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">ISBN</span>
                    <input type="text" class="form-control" name="ISBN" id="ISBN"  value="${requestScope.bookDetails.ISBN}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">简介</span>
                    <input type="text" class="form-control" name="introduction" id="introduction"  value="${requestScope.bookDetails.introduction}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">语言</span>
                    <input type="text" class="form-control" name="language" id="language" value="${requestScope.bookDetails.language}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="price"  id="price" value="${requestScope.bookDetails.price}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版日期</span>
                    <input type="text" class="form-control" name="pub_date" id="pub_date" value="${requestScope.bookDetails.pub_date}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="class_id" id="class_id" value="${requestScope.bookDetails.class_id}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">数量</span>
                    <input type="text" class="form-control" name="number"  id="number" value="${requestScope.bookDetails.number}">
                </div>
                <input type="submit" value="确定修改" class="btn btn-success btn-sm" class="text-right " style="margin-top: 15px">
                <script>
                    $("#addbook").submit(function () {
                        if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubstr").val()==''||$("#classId").val()==''||$("#number").val()==''){
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
