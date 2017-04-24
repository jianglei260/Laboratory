package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;

import cn.edu.cuit.liyun.laboratory.data.entity.User;

/**
 * Created by jianglei on 2017/4/15.
 */

public class UserRepository {
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }

    public User login(String userName, String password) {
        try {
            return AVUser.logIn(userName, password, User.class);
        } catch (AVException e) {
            e.printStackTrace();
        }
        return null;
    }

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

    public void logout() {
        AVUser.logOut();
    }

    public User getCurrentUser() {
        return AVUser.getCurrentUser(User.class);
    }
}
