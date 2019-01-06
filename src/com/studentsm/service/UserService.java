package com.studentsm.service;

import com.studentsm.dao.UserDao;
import com.studentsm.entity.User;

/**
 * @author WangYu
 */
public class UserService {
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

    public static boolean ifUserNameNotExist(String u){
        boolean result;
        result= UserDao.queryUser(u) == null;
        return result;
    }

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
