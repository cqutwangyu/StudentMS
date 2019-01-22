package com.wangyu.studentms.service.impl;

import com.wangyu.studentms.dao.UserDao;
import com.wangyu.studentms.dao.impl.UserDaoImpl;
import com.wangyu.studentms.entity.User;
import com.wangyu.studentms.service.UserService;

/**
 * 用户类业务实现
 * @author WangYu
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    /**
     * 注册帐号
     * @param u 用户名
     * @param p 密码
     * @return 是否注册成功
     */
    @Override
    public boolean register(String u, String p) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        if (ifUserNameNotExist(u)){
            result = userDao.add(new User(u, p)) > 0;
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
    @Override
    public boolean ifUserNameNotExist(String u){
        boolean result;
        // 返回的是一个user对象，如果这个对象为空则表示用户名不存在
        result= userDao.queryUser(u) == null;
        return result;
    }

    /**
     * 登录帐号
     * @param u 用户名
     * @param p 密码
     * @return 用户名和密码是否正确
     */
    @Override
    public boolean login(String u, String p) {
        boolean result;
        User user = userDao.queryUser(u);
        if (user.getUsername() != null) {
            result = u.equals(user.getUsername()) && p.equals(user.getPassword());
        } else {
            result = false;
        }
        return result;
    }
}
