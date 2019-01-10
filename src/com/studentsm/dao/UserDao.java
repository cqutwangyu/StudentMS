package com.studentsm.dao;

import com.studentsm.entity.User;

import java.sql.SQLException;

/**
 * 用户类的持久层接口
 */
public interface UserDao {
    /**
     * 插入一条用户信息
     * @param u 用户对象
     * @return
     */
    int add(User u);

    /**
     * 查询用户
     * @param username 用户名字段的值
     * @return 返回一个用户对象
     */
    User queryUser(String username);
}
