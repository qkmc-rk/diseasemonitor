package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.controller.ControllerUtil;
import cn.cmcc.diseasemonitor.entity.*;
import cn.cmcc.diseasemonitor.entity.Order;
import cn.cmcc.diseasemonitor.service.*;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import cn.cmcc.diseasemonitor.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository resp;

    @Autowired
    UserService userService;

    @Autowired
    LaboratoryService laboratoryService;

    @Autowired
    OrderRecordService orderRecordService;

    @Autowired
    OrderSonService orderSonService;

    @Autowired
    PicService picService;

    @Autowired
    ReportService reportService;

    @Override
    public Page<Map<String, Object>> findByConditions(String status, String orderSn, String logisticsSn,
                                                      Float payable, Long startTime, Long endTime,
                                                      String phone, String company,
                                                      Integer pageNum, Integer pageSize, String token) {
        Optional<Integer> userIdOpt = userService.findUserIdByToken(token);
        // 如果token有效 查询用户是否有实验室 代码太长 用lambda看的头晕
        if (userIdOpt.isPresent()) {
            Optional<Laboratory> laboratoryOpt = laboratoryService.findByUserId(userIdOpt.get());
            // 有实验室 开始条件筛选
            if (laboratoryOpt.isPresent()) {
                // 先拿到实验Id
                Integer labId = laboratoryOpt.get().getId();
                // 设置分页信息
                Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "create_time");
                return resp.findByConditions(labId, status, orderSn, logisticsSn, payable, startTime,
                        endTime, phone, company, pageable);
            } else {
                // 没有实验室 拜拜
                return null;
            }
        } else {
            // token无效 白白
            return null;
        }
    }

    @Override
    public Integer receive(String sn, String token) {
        Optional<Order> orderOptional = resp.findByOrderSn(sn);
        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        if (orderOptional.isPresent() && laboratoryId.isPresent()) {
            Order order = orderOptional.get();
            String[] status = {"4", "5", "0"};
            // 已完成 已签收 已取消 退出
            if (Arrays.asList(status).contains(order.getStatus())) return -2;
            Integer labId = laboratoryId.get();
            // 检查实验室ID与订单中的实验室ID是否相同
            if (order.getLaboratoryId().equals(labId)) {
                // 修改订单状态 为已收样
                order.setStatus("4");
                resp.save(order);
                // 保存订单操作记录
                OrderRecord orderRecord = new OrderRecord();
                orderRecord.setType("4");
                orderRecord.setOrderId(order.getId());
                orderRecord.setTime(TimeUtil.getTime());
                orderRecordService.save(orderRecord);
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer complete(String sn, String token) {
        Optional<Order> orderOptional = resp.findByOrderSn(sn);
        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        if (orderOptional.isPresent() && laboratoryId.isPresent()) {
            Order order = orderOptional.get();
            String[] status = {"1", "2", "3", "5", "6", "0"};
            // 未签收 已完成 已取消  退款中 退出
            if (Arrays.asList(status).contains(order.getStatus())) return -2;
            Integer labId = laboratoryId.get();
            // 检查实验室ID与订单中的实验室ID是否相同
            if (order.getLaboratoryId().equals(labId)) {
                // 修改订单状态 为已完成
                order.setStatus("5");
                resp.save(order);
                // 保存订单操作记录
                OrderRecord orderRecord = new OrderRecord();
                orderRecord.setType("5");
                orderRecord.setOrderId(order.getId());
                orderRecord.setTime(TimeUtil.getTime());
                orderRecordService.save(orderRecord);
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer cancel(String sn, String token) {
        Optional<Order> orderOptional = resp.findByOrderSn(sn);
        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        if (orderOptional.isPresent() && laboratoryId.isPresent()) {
            Order order = orderOptional.get();
            String[] status = {"0", "3", "4", "5", "6"};
            // 已取消 已寄出 已收样 已完成  退款中 退出
            if (Arrays.asList(status).contains(order.getStatus())) return -2;
            Integer labId = laboratoryId.get();
            // 检查实验室ID与订单中的实验室ID是否相同
            if (order.getLaboratoryId().equals(labId)) {
                // 修改订单状态 已取消
                order.setStatus("0");
                resp.save(order);
                // 保存订单操作记录
                OrderRecord orderRecord = new OrderRecord();
                orderRecord.setType("0");
                orderRecord.setOrderId(order.getId());
                orderRecord.setTime(TimeUtil.getTime());
                orderRecordService.save(orderRecord);
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Optional<Map<String, Object>> findOrderInfoByOrderSn(String sn, String token) {

        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        // 用户token无效退出
        if (!laboratoryId.isPresent()) return Optional.empty();

        Map<String, Object> map = new HashMap<>();
        Optional<Map<String, Object>> baseInfoMap = resp.findOrderInfoByOrderSn(sn);
        baseInfoMap.ifPresent((v) -> {
            // A TupleBackedMap cannot be modified. 重新建一个
            Map<String, Object> baseMap = new HashMap<>();
            baseMap.putAll(v);
            Integer labId = (Integer) v.get("laboratory_id");
            // 用户ID与订单实验室ID不匹配就不再继续查询
            if (labId != null && labId.equals(laboratoryId.get())) {
                // 获取子订单列表
                map.put("commodities", orderSonService.findAllByOrderId((Integer) v.get("id")));
                // 订单状态记录
                map.put("statuses", orderRecordService.findAllByOrderId((Integer) v.get("id")));
                // 订单报告 url
                map.put("reports", reportService.findAllReportUrlByOrderId((Integer) v.get("id")));
                //获取pic id数组字符串
                String ids = (String) v.get("sample_ids");

                //如果不为空
                if (ids != null && ids.length() > 2) {
                    // 去掉中括号
                    ids = ids.substring(1, ids.length() - 1);
                    // 转成整型数组存到intList里面去
                    List<Integer> intList = new ArrayList<>();
                    List strList = Arrays.asList(ids.split(","));
                    strList.forEach((k) -> {
                        intList.add(Integer.valueOf((String) k));
                    });
                    map.put("images", picService.findPicUrlListByIdIn(intList));
                } else {
                    map.put("images", null);
                }
                // 删除多余字段
                baseMap.remove("laboratory_id");
                map.put("info", baseMap);
            }
        });
        if (map.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(map);
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return resp.findById(id);
    }

    @Override
    public List<Order> findByLaboratoryAndNotified(Integer id, boolean b) {
        return resp.findAllByLaboratoryIdAndNotified(id, b);
    }

    @Override
    @Transactional
    public ResponseEntity makeOrderNotified(String orderSn, String token) {
        Laboratory laboratory = laboratoryService.findLaboratory(token);
        Order order = resp.findByOrderSn(orderSn).orElse(null);
        if (laboratory == null || order == null || !order.getLaboratoryId().equals(laboratory.getId())){
            return ControllerUtil.getFalseResultMsgBySelf("用户与订单不匹配");
        }
        order.setNotified(true);
        if (resp.saveAndFlush(order) != null){
            return ControllerUtil.getSuccessResultBySelf(null);
        }else {
            return ControllerUtil.getFalseResultMsgBySelf("更新失败");
        }

    }


}
