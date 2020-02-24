package cn.cmcc.diseasemonitor.service;


import cn.cmcc.diseasemonitor.entity.Order;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;


public interface OrderService {

    /**
     * 查询订单列表
     *
     * @param startTime : 起始时间
     * @param endTime   : 结束时间
     * @param status    : 订单状态
     * @return: java.util.Optional
     */
    Page<Order> findAllByTimeAndStatus(Long startTime, Long endTime, String status,
                                       Integer pageNum, Integer pageSize, String token);

    /**
     * 搜索订单
     *
     * @param type  : 编号类型
     * @param sn    : 编号
     * @param token :
     * @return: org.springframework.data.domain.Page<cn.cmcc.diseasemonitor.entity.Order>
     */
    Order searchOrder(String type, String sn, String token);

    /**
     * 确认收样
     *
     * @param id    : orderId
     * @param token :
     * @return: java.lang.Integer
     */
    Integer received(String sn, String token);

    /**
     * @param id :
     * @return: java.util.Optional<cn.cmcc.diseasemonitor.entity.Order>
     */
    Optional<Order> findById(Integer id);

    /**
     * 获取订单所有信息
     *
     * @param sn    : 订单编号
     * @param token :
     * @return: java.util.Optional
     */
    Optional<Map<String, Object>> findOrderInfoByOrderSn(String sn, String token);
}
