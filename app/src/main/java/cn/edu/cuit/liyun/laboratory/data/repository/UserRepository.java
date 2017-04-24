package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;

import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * 用户相关接口
 * Created  on 2017/4/15.
 */

public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }

    /**
     * 用户登录接口
     * @param userName
     * @param password
     * @return
     */
   public User login(String userName, String password) {
        try {
            return AVUser.logIn(userName, password, User.class);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 用户注册接口
     * @param userName
     * @param password
     * @return
     */
    public User signUp(String userName, String password, User.Role role) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setRole(role);
        try {
            user.signUp();
            return user;
        } catch (AVException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 退出登录
     */
    public void logout() {
        AVUser.logOut();
    }

    /**
     * 获取当前用户
     * @return
     */
    public User getCurrentUser() {
        return AVUser.getCurrentUser(User.class);
    }
}
