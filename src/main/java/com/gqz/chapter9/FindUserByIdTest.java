package com.gqz.chapter9;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

import java.sql.SQLException;

public class FindUserByIdTest {
	public static void main(String[] args) {
		UsersDao usersDao = new UsersDao();
		User user = null;
		try {
			user = usersDao.find(11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("id为11的User对象的name值为：" + user.getUsername());
	}
}
