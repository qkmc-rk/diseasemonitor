package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息接口", notes = "request header需携带token")
    public ResponseEntity info(@RequestHeader("token") String token) {
        Optional<Map<String, Object>> userOptional = userService.findUserInfoAndPhone(token);
        return userOptional.map(ControllerUtil::getSuccessResultBySelf
        ).orElse(
                ControllerUtil.getFalseResultMsgBySelf("Token无效"));
    }

    @PostMapping("/username")
    @ApiOperation(value = "修改用户名", notes = "传入用户名")
    public ResponseEntity updateUserName(@RequestHeader("token") String token, @RequestParam String username) {
        Integer status = userService.updateUserName(token, username);
        if (status == 1) {
            return ControllerUtil.getDataResult("修改成功");
        }
        return ControllerUtil.getFalseResultMsgBySelf("修改失败");
    }
}
