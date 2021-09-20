package com.gqz.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author gqz20
 */
public class Servlet04 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        // 通过setAttribute()方法设置属性值
        context.setAttribute("data", "this servlet save data");
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
