package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.ReportService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/new")
    @ApiOperation("保存报告 类型type:0文件 1图片")
    public ResponseEntity newReport(@RequestHeader("token") String token, String url, Integer orderId, String name, Integer type) {
        return ControllerUtil.getDataResult(reportService.save(token, url, orderId, name, type));
    }

    @DeleteMapping("/del")
    @ApiOperation("删除报告")
    public ResponseEntity del(@RequestHeader("token") String token, Integer id) {
        return ControllerUtil.getDataResult(reportService.del(token, id));
    }

    @DeleteMapping("/delbyUrl")
    @ApiOperation("铜鼓url删除报告")
    public ResponseEntity delByUrl(@RequestHeader("token") String token, String url) {
        return ControllerUtil.getDataResult(reportService.delByUrl(token, url));
    }
}
