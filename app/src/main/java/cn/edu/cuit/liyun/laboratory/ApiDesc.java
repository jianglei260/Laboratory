package cn.edu.cuit.liyun.laboratory;

/**
 * Created by jianglei on 2017/4/16.
 */

public class ApiDesc {
    public static class UserRepository {
        public static final String getInstance_ = "cn.edu.cuit.liyun.laboratory.data.repository.UserRepository#getInstance@";
        public static final String login_userName_password = "cn.edu.cuit.liyun.laboratory.data.repository.UserRepository#login@String@String";
        public static final String signUp_userName_password_role = "cn.edu.cuit.liyun.laboratory.data.repository.UserRepository#signUp@String@String@Role";
        public static final String logout_ = "cn.edu.cuit.liyun.laboratory.data.repository.UserRepository#logout@";
    }
}
