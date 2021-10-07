package com.gqz.chapter5.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
            throws ServletException, IOException {
        // 将Session对象中的User对象移除
        request.getSession().removeAttribute("user");
        response.sendRedirect("/index");
    }

    @Override
	public void doPost(HttpServletRequest request,
					   HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
