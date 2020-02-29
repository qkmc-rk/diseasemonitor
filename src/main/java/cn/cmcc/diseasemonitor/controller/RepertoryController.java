package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.entity.Commodity;
import cn.cmcc.diseasemonitor.entity.Repertory;
import cn.cmcc.diseasemonitor.service.CommodityService;
import cn.cmcc.diseasemonitor.service.RepertoryService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/repertory")
@CrossOrigin
public class RepertoryController {

    @Autowired
    RepertoryService repertoryService;

    @PostMapping("/new")
    @ApiOperation(value = "实验室新增商品")
    public ResponseEntity newCommodity(@RequestHeader("token") String token, Repertory repertory) {
        return ControllerUtil.getDataResult(repertoryService.save(token, repertory));
    }
}
