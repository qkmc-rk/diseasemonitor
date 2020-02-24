package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.OrderRecord;
import cn.cmcc.diseasemonitor.entity.Pic;
import cn.cmcc.diseasemonitor.service.*;
import cn.cmcc.diseasemonitor.util.constant.LogisticsStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Order;
import cn.cmcc.diseasemonitor.repository.OrderRepository;

import javax.persistence.criteria.*;
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

    @Override
    public Page<Order> findAllByTimeAndStatus(Long startTime, Long endTime, String status,
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
                Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime");
                // 设置查询条件
                Specification<Order> specification = new Specification<Order>() {
                    @Override
                    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Path<Integer> labIdPath = root.get("laboratoryId");
                        // 匹配实验室ID
                        Predicate predicate = criteriaBuilder.equal(labIdPath, labId);

                        /* 筛选时间段 */
                        if (startTime != null && endTime != null) {
                            Path<Long> createTimePath = root.get("createTime");
                            Predicate createTimeBetween = criteriaBuilder.between(createTimePath, startTime, endTime);
                            predicate = criteriaBuilder.and(predicate, createTimeBetween);
                        }

                        /* 筛选订单状态 */
                        if (status != null && !status.isEmpty()) {
                            Path<String> statusPath = root.get("status");
                            Predicate statusEq = criteriaBuilder.equal(statusPath, status);
                            predicate = criteriaBuilder.and(predicate, statusEq);
                        }
                        return criteriaBuilder.and(predicate);
                    }
                };
                return resp.findAll(specification, pageable);
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
    public Order searchOrder(String type, String sn, String token) {
        // 获取实验室ID
        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        if (laboratoryId.isPresent()) {
            if (type.equals("logistics")) {
                return resp.findByLogisticsNumAndLaboratoryId(sn, laboratoryId.get());
            } else if (type.equals("order")) {
                return resp.findByOrderSnAndLaboratoryId(sn, laboratoryId.get());
            }
        }
        return null;
    }


    @Override
    public Integer received(Integer id, String token) {
        Optional<Order> orderOptional = resp.findById(id);
        Optional<Integer> laboratoryId = Optional.ofNullable(userService.findUserIdByToken(token).map(
                (v) -> laboratoryService.findByUserId(v).map(
                        (k) -> k.getId()).orElse(null)).orElse(null));
        if (orderOptional.isPresent() && laboratoryId.isPresent()) {
            Order order = orderOptional.get();
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
                orderRecord.setTime(System.currentTimeMillis());
                orderRecordService.save(orderRecord);
                return 1;
            }
        }
        return -1;
    }


    @Override
    public Optional<Order> findById(Integer id) {
        return resp.findById(id);
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
                baseMap.remove("id");
                baseMap.remove("laboratory_id");
                baseMap.remove("sample_ids");
                map.put("info", baseMap);
            }
        });
        if (map.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(map);
    }


}
