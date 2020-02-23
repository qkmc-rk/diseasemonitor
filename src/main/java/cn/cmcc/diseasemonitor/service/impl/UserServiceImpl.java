package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;
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
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository resp;

    @Autowired
    LaboratoryRepository laboratoryRepository;

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
    public Optional<Map<String, Object>> findUserInfoAndPhone(String token) {
        return findUserIdByToken(token).map(resp::findUserInfoAndPhone).orElse(Optional.empty());
    }


    @Override
    public Optional<Integer> findUserIdByToken(String token) {
        /* 获取用户ID */
        Optional<String> idOpt = Optional.ofNullable(
                RedisUtil.getInstance().readDataFromRedis(token));
        return idOpt.map((v) -> Optional.of(Integer.valueOf(v))).orElse(Optional.empty());
    }


    @Override
    public Optional<User> findUserByToken(String token) {
        return this.findUserIdByToken(token).map(resp::findById).orElse(Optional.empty());
    }


    @Override
    public Optional findById(Integer id) {
        return resp.findById(id);
    }

    @Override
    public Optional<Integer> updateUserName(String token, String username) {
        return this.findUserByToken(token).map((v) -> {
            v.setUserName(username);
            resp.save(v);
            return Optional.of(1);
        }).orElse(Optional.empty());
    }

    @Override
    public Optional<Integer> updatePassword(String token, String oldPassword, String newPassword) {
        String oldPasswordMD5 = MD5Util.trueMd5(oldPassword);
        String newPasswordMD5 = MD5Util.trueMd5(newPassword);
        return this.findUserByToken(token).map((v) -> {
            if (oldPasswordMD5.equals(v.getPasswd())) {
                v.setPasswd(newPasswordMD5);
                resp.save(v);
                return Optional.of(1);
            }
            return Optional.of(-1);
        }).orElse(Optional.empty());
    }

    @Override
    public Optional<Integer> updatePhone(String token, String phone) {
        return this.findUserIdByToken(token).map((v) -> {
            return laboratoryRepository.findByUserId(v).map(
                    (k) -> {
                        k.setPhone(phone);
                        laboratoryRepository.save(k);
                        return Optional.of(1);
                    }
            ).orElse(Optional.empty());
        }).orElse(Optional.empty());
    }
}
