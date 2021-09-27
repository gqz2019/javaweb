package com.gqz.chapter4.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gqz20
 */
@WebServlet("/requestForward")
public class RequestForwardServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 将数据存储到request对象中
			request.setAttribute("company", "北京传智播客教育有限公司");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/result");
			dispatcher.forward(request, response);
		}
		@Override
		public void doPost(HttpServletRequest request,
						   HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}
	}
