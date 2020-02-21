package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.User;

import java.util.Map;
import java.util.Optional;

public interface UserService {

    /**
     * 实验室人员登录, 返回登录是否成功,
     *
     * @param username 用户名
     * @param password 密码
     * @return token 没有用户返回-3，密码错误返回-2，没有权限返回-1，登录成功返回userId,
     * 未知错误返回-100
     */
    Integer login(String username, String password);

    /**
     * 获取登录用户信息和电话号码
     *
     * @param token :
     * @return: cn.cmcc.diseasemonitor.entity.User
     */
    Optional<Map<String, Object>> findUserInfoAndPhone(String token);

    /**
     * 获取登录用户
     *
     * @param token :
     * @return: java.util.Optional
     */
    Optional<User> findUserByToken(String token);

    /**
     * 查找用户信息
     *
     * @param id : 用户ID
     * @return: cn.cmcc.diseasemonitor.entity.User
     */
    Optional<User> findById(Integer id);

    /**
     * 修改用户名
     *
     * @param token    :
     * @param username :
     * @return: java.lang.Integer
     */
    Integer updateUserName(String token, String username);
}
