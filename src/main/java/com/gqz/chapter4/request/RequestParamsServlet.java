package com.gqz.chapter4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/requestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:" + name);
        System.out.println("密  码:" + password);

        String[] hobbys = request.getParameterValues("hobby");
        System.out.print("爱好:");
        for (String hobby : hobbys) {
            System.out.print(hobby + ",");
        }

        PrintWriter writer = response.getWriter();

        writer.write("username:"+name+"<br>");
        writer.write("password:"+password+"<br>");

        Arrays.stream(hobbys).forEach(hobby-> writer.write("hobby:"+hobby+"<br>"));


    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
