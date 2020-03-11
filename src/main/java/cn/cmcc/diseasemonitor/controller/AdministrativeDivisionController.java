package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.AdministrativeDivisionService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/district")
@Api(value = "行政地区接口")
public class AdministrativeDivisionController {

    @Autowired
    AdministrativeDivisionService administrativeDivisionService;

    /**
     * 获取地址
     * @param level
     * @param parentCode
     * @return
     */
    @ApiOperation(value = "通过行政等级获取地址, 1-5, 1最高")
    @GetMapping("/level/{level}")
    public ResponseEntity getLevel(@PathVariable Integer level, @RequestParam(required = false) String parentCode){
        return ControllerUtil.getDataResult(administrativeDivisionService.getDistrict(level, parentCode));
    }

    @GetMapping("/gecoding")
    @ApiOperation(value = "输入地址, 返回经纬度, city为可选参数, 可以进行进准过滤")
    public ResponseEntity gecoding(String address){
        return ControllerUtil.getDataResult(administrativeDivisionService.gecoding(address));
    }
}
