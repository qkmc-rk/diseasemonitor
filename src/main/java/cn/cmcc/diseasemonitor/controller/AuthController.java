package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.Constant;
import cn.cmcc.diseasemonitor.util.RedisUtil;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 不知道怎么取名字 实验室人员相关接口： 登录 个人信息  修改个人信息等
 */
@RestController
@RequestMapping("/lab")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/token")
    @ApiOperation(value = "登录接口", notes = "传入用户名密码")
    public ResponseEntity login(@RequestParam String username, @RequestParam String password){
        //校验密码
        Integer rs = userService.login(username, password);
        if (null == rs){
            rs = Constant.UNKNOWN_ERROR;
        }
        if (rs > 0){
            //登录成功
            String token = RedisUtil.getInstance().readDataFromRedis("token" + rs.intValue());
            return ControllerUtil.getSuccessResultBySelf(token);
        }else if (rs == Constant.UNKNOWN_ERROR){
            return ControllerUtil.getFalseResultMsgBySelf("未知错误");
        }else if (rs == Constant.NO_USER){
            return ControllerUtil.getFalseResultMsgBySelf("没有找到该用户");
        }else if (rs == Constant.ERROR_PWD){
            return ControllerUtil.getFalseResultMsgBySelf("密码错误");
        }else if (rs == Constant.NO_PERMISSION){
            return ControllerUtil.getFalseResultMsgBySelf("权限错误");
        }else{
            return ControllerUtil.getFalseResultMsgBySelf("权限错误2");
        }
    }
}
