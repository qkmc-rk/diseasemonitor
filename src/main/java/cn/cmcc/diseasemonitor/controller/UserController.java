package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息接口", notes = "request header需携带token")
    public ResponseEntity info(@RequestHeader("token") String token) {
        Optional<Map<String, Object>> userOptional = userService.findUserInfoAndPhone(token);
        return userOptional.map(ControllerUtil::getSuccessResultBySelf
        ).orElse(ControllerUtil.getFalseResultMsgBySelf("token无效"));
    }

    @PostMapping("/username")
    @ApiOperation(value = "修改用户名", notes = "传入用户名")
    public ResponseEntity updateUserName(@RequestHeader("token") String token, @RequestParam String username) {
        return userService.updateUserName(token, username).map((v) ->
                ControllerUtil.getSuccessResultBySelf("修改成功")
        ).orElse(ControllerUtil.getFalseResultMsgBySelf("token无效"));
    }

    @PostMapping("/password")
    @ApiOperation(value = "修改用户密码", notes = "传入旧密码与新密码")
    public ResponseEntity updatePassword(@RequestHeader("token") String token,
                                         @RequestParam String oldPassword,
                                         @RequestParam String newPassword) {
        return userService.updatePassword(token, oldPassword, newPassword).map((v) -> {
            if (v == 1) return ControllerUtil.getSuccessResultBySelf("修改成功");
            else return ControllerUtil.getFalseResultMsgBySelf("原密码错误");
        }).orElse(ControllerUtil.getFalseResultMsgBySelf("token无效"));
    }

    @PostMapping("/phone")
    @ApiOperation(value = "修改联系电话")
    public ResponseEntity updatePhone(@RequestHeader("token") String token,
                                      @RequestParam String phone) {
        return userService.updatePhone(token, phone).map((v) ->
                ControllerUtil.getSuccessResultBySelf("修改成功")).orElse(
                ControllerUtil.getFalseResultMsgBySelf("修改失败"));
    }
}
