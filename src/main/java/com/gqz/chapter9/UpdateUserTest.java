package com.gqz.chapter9;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

import java.sql.SQLException;

public class UpdateUserTest{
	public static void main(String[] args) {
         // 修改User对象的数据
		UsersDao usersDao = new UsersDao();
		User user = new User();
			user.setId(4);
			user.setUsername("zhaoxiaoliu");
			user.setPassword("456");
			user.setEmail("zhaoxiaoliu@sina.com");

		boolean b = false;
		try {
			b = usersDao.update(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(b);
		}
}
