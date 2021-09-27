package com.gqz.chapter4.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)throws ServletException, IOException {
		    String data = "itcast";

			PrintWriter print = response.getWriter(); 
			print.write(data); // 输出信息

			
		}
		@Override
		public void doPost(HttpServletRequest request,
						   HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}
	}
