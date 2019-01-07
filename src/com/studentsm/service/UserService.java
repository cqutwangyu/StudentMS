package com.studentsm.service;

import com.studentsm.dao.UserDao;
import com.studentsm.entity.User;

/**
 * @author WangYu
 */
public class UserService {
    /**
     * 注册帐号
     * @param u 用户名
     * @param p 密码
     * @return 是否注册成功
     */
    public static boolean register(String u, String p) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        if (ifUserNameNotExist(u)){
            result = UserDao.add(new User(u, p)) > 0;
        }else {
            result=false;
        }
        return result;
    }

    /**
     * 验证用户名是否可注册
     * @param u 用户名
     * @return 如果用户名不存在为true，否则为false
     */
    public static boolean ifUserNameNotExist(String u){
        boolean result;
        // 返回的是一个user对象，如果这个对象为空则表示用户名不存在
        result= UserDao.queryUser(u) == null;
        return result;
    }

    /**
     * 登录帐号
     * @param u 用户名
     * @param p 密码
     * @return 用户名和密码是否正确
     */
    public static boolean login(String u, String p) {
        boolean result;
        User user = UserDao.queryUser(u);
        if (user.getUsername() != null) {
            result = u.equals(user.getUsername()) && p.equals(user.getPassword());
        } else {
            result = false;
        }
        return result;
    }
}
