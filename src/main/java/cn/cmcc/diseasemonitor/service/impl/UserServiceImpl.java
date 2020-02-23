package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;
import cn.cmcc.diseasemonitor.util.Constant;
import cn.cmcc.diseasemonitor.util.IpUtils;
import cn.cmcc.diseasemonitor.util.MD5Util;
import cn.cmcc.diseasemonitor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository resp;

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Override
    public Integer login(String username, String password, String verifyCode, String ip) {
        //检测是否需要验证码
        String timeStr = RedisUtil.getInstance().readDataFromRedis(ip);
        if (null == timeStr){

        } else {
            Integer time = Integer.parseInt(timeStr);
            if (null != time && time >= 3){
                // 需要验证码 生成的验证码存到 redis  key: ip + verifycode,   value: verifycode
                String verifyCode2 = RedisUtil.getInstance().readDataFromRedis(ip+"verifycode");
                if (null == verifyCode2 || verifyCode == null){
                    return Constant.VERIFYCODE_NONE;
                }
                if (!verifyCode.equals(verifyCode2)) {
                    return Constant.VERIFYCODE_ERROR;
                }
            }
        }
        User user = resp.findByUserName(username);
        if (null == user) {
            // 没有找到用户
            addWrongLoginTime(ip);
            return Constant.NO_USER;
        }
        password = MD5Util.trueMd5(password).toUpperCase();
        String password2 = user.getPasswd().toUpperCase();
        if (!password.equals(password2)) {
            //密码不正确
            addWrongLoginTime(ip);
            return Constant.ERROR_PWD;
        }
        // 查询权限相关,取消权限这一块
        if (false) {
            addWrongLoginTime(ip);
            return Constant.NO_PERMISSION;
        }
        //生成token存到redis,返回登录成功
        String token = MD5Util.trueMd5(Long.toString(new Date().getTime()));
        boolean rs = RedisUtil.redisUtil.tokenToRedis(user.getId(), token, 15);
        if (rs) {
            // 登录成功需要清除登录次数记录
            clearWrongLoginTime(ip);
            return user.getId();
        } else {
            addWrongLoginTime(ip);
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
        return this.findUserByToken(token).map((v) -> {
            return laboratoryRepository.findByUserId(v.getId()).map(
                    (k) -> {
                        k.setPhone(phone);
                        laboratoryRepository.save(k);
                        return Optional.of(1);
                    }
            ).orElse(Optional.empty());
        }).orElse(Optional.empty());
    }

    @Override
    public Boolean needVerifyCode(HttpServletRequest request) {
        return isNeedVerifyCode(IpUtils.getIpAddr(request));
    }

    @Override
    public String generateSMScode(String ipAddr, String verifyCode, String phone) {
        return null;
    }

    /**
     * 如果登录错误次数大于等于3次就要返回需要验证码
     * @param ip
     * @return
     */
    private boolean isNeedVerifyCode(String ip){
        String timeStr = RedisUtil.getInstance().readDataFromRedis(ip);
        if (null == timeStr){
            return false;
        }
        int time = Integer.parseInt(timeStr);
        if (time >= 3){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 增加一次登录出错记录在redis中
     * @param ip
     */
    private void addWrongLoginTime(String ip){
        if (null != RedisUtil.getInstance().readDataFromRedis(ip)){
            Integer time = Integer.parseInt(RedisUtil.getInstance().readDataFromRedis(ip));
            Integer time2 = time + 1;
            RedisUtil.getInstance().setDataToRedis(ip, time2.toString(), 15);
        } else {
            RedisUtil.getInstance().setDataToRedis(ip, "1", 15);
        }
        System.out.println("redisIp : " + ip + ",value: " + RedisUtil.getInstance().readDataFromRedis(ip));
    }

    /**
     * 清除登录错误的次数记录
     * @param ip
     */
    private  void clearWrongLoginTime(String ip){
        RedisUtil.getInstance().setDataToRedis(ip,"0", 15);
    }
}
