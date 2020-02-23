package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.OrderService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/list/fiter")
    @ApiOperation(value = "获取订单列表", notes = "startTime endTime、status为可选参数,全部为空则获取实验室所有订单")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "status", value = "订单状态，1提交订单/待付款，2完成付款/待寄样，3寄出样品/运输中，4确认收样/开始检测、检测中，5订单完成/报告上传，6退款中，0已取消"))
    public ResponseEntity getOrderList(Long startTime, Long endTime,
                                       String status, @RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize, @RequestHeader("token") String token) {
        return ControllerUtil.getDataResult(orderService.findAllByTimeAndStatus(startTime, endTime, status,
                pageNum, pageSize, token));
    }

//    @GetMapping("/search/{type}/{sn}")
//    @ApiOperation(value = "订单编号查找和运单号查找")
//    public ResponseEntity findOrder(@PathVariable String type, @PathVariable String sn,
//                                    @RequestHeader("token") String token) {
//
//    }
}
