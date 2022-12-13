<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!--	写base标签，永远固定相对路径-->
<base href="<%=basePath%>">
<nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand " href="pages/reader/reader_main.jsp"><p class="text-primary" style="font-family: 华文行楷; font-size: 200%; ">我的图书馆</p></a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li class="active">
                    <a href="clientBookServlet?action=bookAndLendList&readerId=${sessionScope.Id}">
                        图书查询
                    </a>
                </li>
                <li>
                    <a href="clientBookServlet?action=getReaderInfoById&readerId=${sessionScope.Id}" >
                        个人信息
                    </a>
                </li>
                <li >
                    <a href="clientBookServlet?action=getMyLendList&readerId=${sessionScope.Id}" >
                        我的借还
                    </a>
                </li>
                <li >
                    <a href="pages/reader/reader_repasswd.jsp" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a>${sessionScope.reader}, 已登录</a></li>
                <li><a href="loginServlet?action=logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
