package com.gqz.chapter9.servlet;

import com.gqz.chapter9.pojo.User;
import com.gqz.chapter9.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author gqz20
 */
@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        Class<? extends UserServlet> aClass = this.getClass();
        try {
            Method methods = aClass.getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            methods.invoke(this,request,response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private UserService userService =new UserService();
    /**
     * 查询所有用户
     */
    private void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            List<User> linkManList = userService.findAll();
            request.setAttribute("list",linkManList);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //查询失败
            response.getWriter().write("查询所有用户失败");
        }
    }
    /**
     * 修改用户的方法
     * @param request
     * @param response
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1. 获取所有请求参数封装到LinkMan对象中
            Map parameterMap = request.getParameterMap();
            User linkMan = new User();
            BeanUtils.populate(linkMan,parameterMap);

            //2. 调用业务层的方法，修改联系人信息
            userService.updateUser(linkMan);

            //3. 如果修改成功，则跳转到查询所有
            response.sendRedirect("/user?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("修改失败");
        }
    }

    /**
     * 根据id查询联系人
     * @param request
     * @param response
     */
    private void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            User linkMan = userService.findById(id);
            request.setAttribute("linkman",linkMan);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("数据回显失败");
        }

    }
    /**
     * 删除联系人
     * @param request
     * @param response
     * @throws IOException
     */
    private void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            userService.deleteUser(id);
            response.sendRedirect("/user?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("删除失败");
        }

    }

    /**
     * 添加联系人
     * @param request
     * @param response
     * @throws IOException
     */
    private void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            Map parameterMap = request.getParameterMap();
            User linkMan = new User();
            BeanUtils.populate(linkMan,parameterMap);
            userService.insertUser(linkMan);
            response.sendRedirect("/user?action=findAll");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("添加失败");
        }
    }

}
