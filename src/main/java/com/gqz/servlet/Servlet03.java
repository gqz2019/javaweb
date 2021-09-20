package com.gqz.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet03 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ServletContext context = this.getServletContext();

        Enumeration<String> paramNames = context.getInitParameterNames();

        out.println("all the paramName and paramValue are following:");

        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String value = context.getInitParameter(name);
            out.println(name + ": " + value);
            out.println("<br>");
        }
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
