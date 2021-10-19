package com.gqz.chapter9.service;

import com.gqz.chapter9.dao.UsersDao;
import com.gqz.chapter9.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * <p></p>
 *
 * @author gqz20
 * @create 2021-10-14 08:55
 **/
public class UserService {
    private UsersDao usersDao=new UsersDao();

    public List<User> findAll() throws SQLException {
        List<User> all = usersDao.findAll();

        return all;
    }

    public User findById(Integer id) throws SQLException {
        User user = usersDao.find(id);

        return user;
    }

    public Boolean insertUser(User user){
        boolean b = usersDao.insert(user);
        return b;
    }

    public Boolean deleteUser(Integer id) throws SQLException {
        boolean b = usersDao.delete(id);
        return b;
    }

    public Boolean updateUser(User user) throws SQLException {
        boolean b = usersDao.update(user);
        return b;
    }
}
