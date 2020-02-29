package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.entity.Commodity;
import cn.cmcc.diseasemonitor.service.CommodityService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/commodity")
@CrossOrigin
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @PostMapping("/list")
    public ResponseEntity newCommodity() {
        return ControllerUtil.getDataResult(commodityService.findCommodities());
    }
}
