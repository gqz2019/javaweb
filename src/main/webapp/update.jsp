<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <base href="<%=basePath%>"/>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改联系人</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <jsp:useBean id="linkman" scope="request"
                 type="com.gqz.chapter9.pojo.User"/>
    <form action="<c:url value="/user"/>" method="post">
        <input type="hidden" name="id" value="${linkman.id}">
        <input type="hidden" name="action" value="update">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="username"
                   value="${linkman.username}" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" value="${linkman.password}" id="password" name="password">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <input type="text" id="address" value="${linkman.address}" class="form-control" name="address"
                   placeholder="请输入地址"/>
        </div>

        <div class="form-group">
            <label for="nickname">昵称：</label>
            <input type="text" id="nickname" value="${linkman.nickname}" class="form-control" name="nickname"
                   placeholder="请输入昵称"/>
        </div>
        <div class="form-group">
            <label for="gender">性别：</label>
            <c:if test="${linkman.gender == '男'}">
                <input type="radio" name="gender" value="男" checked/>男
                <input type="radio" name="gender" value="女"/>女
            </c:if>
            <c:if test="${linkman.gender == '女'}">
                <input type="radio" name="gender" value="男"/>男
                <input type="radio" name="gender" value="女" checked/>女
            </c:if>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" value="${linkman.email}" class="form-control" name="email"
                   placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>