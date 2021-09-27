package com.gqz.chapter4.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/including")
public class IncludingServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request
					.getRequestDispatcher("/Included?p1=abc");
			out.println("before including" + "<br>");
			rd.include(request, response);
			out.println("after including" + "<br>");
		}
		@Override
		public void doPost(HttpServletRequest request,
						   HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}
	}
