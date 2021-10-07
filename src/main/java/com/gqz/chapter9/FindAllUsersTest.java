package com.gqz.chapter9;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

import java.sql.SQLException;
import java.util.List;

public class FindAllUsersTest{
	public static void main(String[] args) {
		//创建一个名称为usersDao的对象
		UsersDao usersDao = new UsersDao();
		//将UsersDao对象的findAll()方法执行后的结果放入list集合
		List<User> list = null;
		try {
			list = usersDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//循环输出集合中的数据
		for (int i = 0; i < list.size(); i++) {
				System.out.println("第" + (i + 1) + "条数据的username值为:"
						+ list.get(i).getUsername());
			}
		}
}
