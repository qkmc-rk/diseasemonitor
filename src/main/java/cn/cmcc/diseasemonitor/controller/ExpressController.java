package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.util.ExpressUtil;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/express")
public class ExpressController {

    @GetMapping("")
    @ApiOperation(value = "查询快递，number是快递单号, type是哪家公司(可以不传)")
    public ResponseEntity queryExpress(
            @RequestParam String number
            ,@RequestParam(required = false) String type){
        return ControllerUtil.getDataResult(ExpressUtil.getInstance().queryExpress(number,type));
    }
}
