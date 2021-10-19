<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>显示所有用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <%--    <form action="<c:url value="/user"/>" method="post">--%>
    <%--        <input type="hidden" name="action" value="findAll">--%>
    <%--    </form>--%>
    <h3 style="text-align: center">显示所有用户</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>地址</th>
            <th>昵称</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%
            if (request.getAttribute("list") == null) {
        %>
        <script>
                location.href = "/user?action=findAll"
        </script>
        <%
            }
        %>
        <%--使用forEach标签遍历--%>

        <c:forEach items="${list}" var="linkman" varStatus="vst">
            <tr>
                <td>${vst.count}</td>
                <td>${linkman.username}</td>
                <td>${linkman.password}</td>
                <td>${linkman.address}</td>
                <td>${linkman.nickname}</td>
                <td>${linkman.gender}</td>
                <td>${linkman.email}</td>
                <td>
                    <a class="btn btn-default btn-sm"
                       href="<c:url value="/user?action=findOne&id=${linkman.id}"/>">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:;"
                       onclick="deleteLinkMan('${linkman.username}','${linkman.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="<c:url value="/add.jsp"/>">添加联系人</a></td>
        </tr>
    </table>

    <script>
        //声明一个删除联系人的方法
        function deleteLinkMan(name, id) {
            //1. 弹出一个确认框
            var flag = confirm("你确定要删除" + name + "吗?");
            //2. 判断是否要删除
            if (flag) {
                //确定要删除，则发送请求，并且携带要删除的联系人的id
                location.href = "/user?action=delete&id=" + id
            }
        }

        // onload = () => {
        //     location.href = "/user?action=findAll"
        // }
    </script>
</div>
</body>
</html>
