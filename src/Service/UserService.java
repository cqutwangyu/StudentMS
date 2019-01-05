package Service;

import Dao.UserDao;
import Entity.User;

public class UserService {
    public static boolean register(String u, String p) {
        boolean result;
        //如果返回值大于0则为true，否则为false
        if (ifUserNameExist(u)){
            result = UserDao.add(new User(u, p)) > 0 ? true : false;
        }else {
            result=false;
        }
        return result;
    }

    public static boolean ifUserNameExist(String u){
        boolean result;
        result=UserDao.queryUser(u)==null?true:false;
        return result;
    }

    public static boolean login(String u, String p) {
        boolean result;
        User user = UserDao.queryUser(u);
        if (user.getUsername() != null) {
            if (u.equals(user.getUsername()) && p.equals(user.getPassword())) {
                result = true;
            } else {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }
}
