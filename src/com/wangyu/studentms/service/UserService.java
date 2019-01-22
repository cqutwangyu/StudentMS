package com.wangyu.studentms.service;

/**
 * 用户类的业务层接口
 */
public interface UserService {
        /**
         * 注册帐号
         * @param u 用户名
         * @param p 密码
         * @return 是否注册成功
         */
    boolean register(String u, String p);

        /**
         * 验证用户名是否可注册
         * @param u 用户名
         * @return 如果用户名不存在为true，否则为false
         */
    boolean ifUserNameNotExist(String u);

        /**
         * 登录帐号
         * @param u 用户名
         * @param p 密码
         * @return 用户名和密码是否正确
         */
      boolean login(String u, String p) ;
}
