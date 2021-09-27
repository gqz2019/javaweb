package com.gqz.chapter4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/requestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //设置request对象的解码方式
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:" + name);
        System.out.println("密  码:" + password);
        // 获取参数名为“hobby”的值
        String[] hobbys = request.getParameterValues("hobby");
        System.out.print("爱好:");
        for (String hobby : hobbys) {
            System.out.print(hobby + ",");
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
