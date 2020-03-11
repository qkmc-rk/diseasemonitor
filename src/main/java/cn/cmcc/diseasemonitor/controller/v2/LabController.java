package cn.cmcc.diseasemonitor.controller.v2;

import cn.cmcc.diseasemonitor.controller.ControllerUtil;
import cn.cmcc.diseasemonitor.service.RepertoryService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v2/laboratory")
@Api("重写LabSettingController中的部分方法")
public class LabController {

    @Autowired
    RepertoryService repertoryService;

    @GetMapping("/item/offsale")
    @ApiOperation(value = "获取下架的库存信息")
    public ResponseEntity getOffSaleServe(@RequestHeader("token") String token, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return ControllerUtil.getDataResult(repertoryService.findAllOffSaleServe(token, pageNum, pageSize));
    }

    @GetMapping("/item/onsale")
    @ApiOperation(value = "获取上架的库存信息")
    public ResponseEntity getOnSaleServe(@RequestHeader("token") String token, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return ControllerUtil.getDataResult(repertoryService.findAllOnSaleServe(token, pageNum, pageSize));
    }

}
