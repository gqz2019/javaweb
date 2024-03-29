package com.gqz.chapter5.session;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
     * 添加了验证码
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("check_code");
        String savedCode = (String) request.getSession().getAttribute(
                "check_code");
        PrintWriter pw = response.getWriter();
        if (("itcast").equals(username) && ("123").equals(password)
                && checkCode.equals(savedCode)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/index");
        } else if (checkCode.equals(savedCode)) {
            pw.write("用户名或密码错误，登录失败");
        } else {
            pw.write("验证码错误");
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
