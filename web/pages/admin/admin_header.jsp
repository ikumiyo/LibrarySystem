<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!--	写base标签，永远固定相对路径-->
<base href="<%=basePath%>">
<nav style="position:fixed;z-index: 999;width: 100%;background-color: #40E0D0" class="navbar navbar-default"
     role="navigation">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="pages/admin/admin_main.jsp" style="font-family: 华文行楷; font-size: 250%; color: white">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="manager/bookServlet?action=booklist">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="pages/admin/admin_book_add.jsp">增加图书</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        读者管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="manager/readerServlet?action=readerList">全部读者</a></li>
                        <li class="divider"></li>
                        <li><a href="pages/admin/admin_reader_add.jsp">增加读者</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        借还管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="manager/readerServlet?action=lendList">借还日志</a></li>
                    </ul>
                </li>
                <li >
                    <a href="pages/admin/admin_repasswd.jsp" style="color: white">
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a style="color: white">${sessionScope.admin}, 已登录</a></li>
                <li><a href="loginServlet?action=logout" style="color: white">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
