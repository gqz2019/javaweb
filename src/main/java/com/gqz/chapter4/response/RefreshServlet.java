package com.gqz.chapter4.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/refreshServlet")
public class RefreshServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        // 2秒后刷新并跳转到传智播客官网首页
        response.setHeader("Refresh", "2;URL=http://www.itcast.cn");
        // 每隔3秒定时刷新当前页面
        //response.setHeader("Refresh", "3");
        response.getWriter().println(new java.util.Date());// 输出当前时间

    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
