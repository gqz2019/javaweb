package com.gqz.chapter4.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
          // 获取PrintWriter对象用于输出信息
			PrintWriter out = response.getWriter();
			// 获取request请求对象中保存的数据
			String company = (String) request.getAttribute("company");
			if (company != null) {
				out.println("公司名称：" + company + "<br>");
			}
		}
		@Override
		public void doPost(HttpServletRequest request,
						   HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}
	}
