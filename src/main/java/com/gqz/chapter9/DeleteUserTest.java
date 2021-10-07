 package com.gqz.chapter9;

 import com.gqz.chapter9.dao.UsersDao;

 import java.sql.SQLException;

 public class DeleteUserTest{
 	public static void main(String[] args) {
 		// 删除操作
 		UsersDao usersDao = new UsersDao();
		boolean b = false;
		try {
			b = usersDao.delete(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(b);
 	}
 }
