package com.gqz.chapter9;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

public class JdbcInsertTest{
	public static void main(String[] args) {
         // 向users表插入一个用户信息
		UsersDao ud = new UsersDao();
		User user=new User();
			user.setUsername("hl");
			user.setPassword("123");
			user.setEmail("hl@sina.com");
			user.setAddress("河北省石家庄市灵寿县岔头镇小县城");
			user.setGender("男");
			user.setNickname("gqz2019");
			boolean b=ud.insert(user);
			System.out.println(b);
		}
}
