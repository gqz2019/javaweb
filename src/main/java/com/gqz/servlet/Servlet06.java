package com.gqz.servlet;

import java.io.*;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * @author gqz20
 */
public class Servlet06 extends HttpServlet {
    /**
     * 绝对路径
     */
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletContext context = this.getServletContext();

//        InputStream is = context.getResourceAsStream("itcast.properties");

        InputStream is = Servlet06.class.getClassLoader().getResourceAsStream("itcast.properties");

        System.out.println(is);

//        String realPath = context.getRealPath("itcast.properties");
//        FileInputStream is = new FileInputStream(url);

        Properties pros = new Properties();
        pros.load(is);
        out.println("Company=" + pros.getProperty("Company") + "<br>");
        out.println("Address=" + pros.getProperty("Address") + "<br>");

        System.out.println("Company=" + pros.getProperty("Company") + "<br>");
        System.out.println("Address=" + pros.getProperty("Address") + "<br>");

    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
