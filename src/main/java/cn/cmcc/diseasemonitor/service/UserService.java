package cn.cmcc.diseasemonitor.service;

public interface UserService {

    /**
     * 实验室人员登录, 返回登录是否成功,
     * @param username 用户名
     * @param password 密码
     * @return token 没有用户返回-3，密码错误返回-2，没有权限返回-1，登录成功返回userId,
     * 未知错误返回-100
     */
    Integer login(String username, String password);
}
