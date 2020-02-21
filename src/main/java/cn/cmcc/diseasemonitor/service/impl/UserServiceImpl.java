package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.util.Constant;
import cn.cmcc.diseasemonitor.util.MD5Util;
import cn.cmcc.diseasemonitor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository resp;

    @Override
    public Integer login(String username, String password) {
        User user = resp.findByUserName(username);
        if (null == user) {
            // 没有找到用户
            return Constant.NO_USER;
        }
        password = MD5Util.trueMd5(password).toUpperCase();
        String password2 = user.getPasswd().toUpperCase();
        if (!password.equals(password2)) {
            //密码不正确
            return Constant.ERROR_PWD;
        }
        // 查询权限相关,取消权限这一块
        if (false) {
            return Constant.NO_PERMISSION;
        }
        //生成token存到redis,返回登录成功
        String token = MD5Util.trueMd5(Long.toString(new Date().getTime()));
        boolean rs = RedisUtil.redisUtil.tokenToRedis(user.getId(), token, 15);
        if (rs) {
            return user.getId();
        } else {
            return Constant.UNKNOWN_ERROR;
        }
    }


    @Override
    public Optional findUserInfoAndPhone(String token) {
        return findUserByToken(token).map((v) -> resp.findUserInfoAndPhone(v.getId())).orElse(Optional.empty());
    }


    @Override
    public Optional<User> findUserByToken(String token) {
        /* 获取用户ID */
        Optional<String> idOpt = Optional.ofNullable(
                RedisUtil.getInstance().readDataFromRedis(token));
        /* 返回用户信息 */
        return idOpt.map((v) ->
                resp.findById(Integer.valueOf(v))
        ).orElse(Optional.empty());
    }


    @Override
    public Optional findById(Integer id) {
        return resp.findById(id);
    }

    @Override
    public Integer updateUserName(String token, String username) {
        return this.findUserByToken(token).map((v) -> {
            v.setUserName(username);
            resp.save(v);
            return 1;
        }).orElse(-1);
    }
}
