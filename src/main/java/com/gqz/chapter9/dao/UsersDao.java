package com.gqz.chapter9.dao;

import com.gqz.chapter9.pojo.User;
import com.gqz.chapter9.utils.DruidUtil;
import com.gqz.chapter9.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class UsersDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    // 添加用户的操作
    public boolean insert(User user) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtils.getConnection();
            // 获得Statement对象
//            stmt = conn.createStatement();
            // 发送SQL语句
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "insert into user(id, username, password, address, nickname, gender, email)" +
                    "values(null,?,?,?,?,?,?)";

//            int num = stmt.executeUpdate(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getNickname());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getEmail());
            int num = ps.executeUpdate();

            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    // 查询所有的User对象
    public List<User> findAll() throws SQLException {
        String sql = "select * from user";
        List<User> list = queryRunner.query(sql, new BeanListHandler<>(User.class));
        return list;
    }

    // 根据id查找指定的user
    public User find(int id) throws SQLException {
        String sql = "select * from user where id =?";
        User query = queryRunner.query(sql, new BeanHandler<>(User.class), id);
        return query;
    }

    // 删除用户
    public boolean delete(int id) throws SQLException {
        String sql = "delete from user where id=?";
        int i = queryRunner.update(sql,id);

        return i > 0;
    }

    // 修改用户
    public boolean update(User user) throws SQLException {
        String sql = "update user set username=?,password=?,address=?,nickname=?,gender=?,email=? where id=?";
        int i = queryRunner.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getAddress(),
                user.getNickname(),
                user.getGender(),
                user.getEmail(),
                user.getId());
        return i > 0;
    }
}
