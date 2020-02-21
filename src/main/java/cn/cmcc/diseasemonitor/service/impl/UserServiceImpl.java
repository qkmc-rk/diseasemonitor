package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.util.Constant;
import cn.cmcc.diseasemonitor.util.MD5Util;
import cn.cmcc.diseasemonitor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.repository.UserRepository;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository resp;

	@Override
	public Integer login(String username, String password) {
		User user = resp.findByUserName(username);
		if (null == user){
			// 没有找到用户
			return Constant.NO_USER;
		}
		password = MD5Util.trueMd5(password).toUpperCase();
		String password2 = user.getPasswd().toUpperCase();
		if (!password.equals(password2)){
			//密码不正确
			return Constant.ERROR_PWD;
		}
		// 查询权限相关,取消权限这一块
		if(false){
			return Constant.NO_PERMISSION;
		}
		//生成token存到redis,返回登录成功
		String token = MD5Util.trueMd5(Long.toString(new Date().getTime()));
		boolean rs = RedisUtil.redisUtil.tokenToRedis(user.getId(),token,15);
		if (rs){
			return user.getId();
		}else {
			return Constant.UNKNOWN_ERROR;
		}
	}
}
