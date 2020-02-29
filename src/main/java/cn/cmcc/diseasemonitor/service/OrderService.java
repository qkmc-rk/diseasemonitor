package cn.cmcc.diseasemonitor.service;


import cn.cmcc.diseasemonitor.entity.Order;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;


public interface OrderService {

    /**
     * 查询订单列表
     *
     * @return: java.util.Optional
     */
    Page<Map<String,Object>> findByConditions(String status, String orderSn, String logisticsSn,
                                              Float payable, Long startTime, Long endTime,
                                              String phone, String company, Integer pageNum,
                                              Integer pageSize, String token);

    /**
     * 确认收样
     *
     * @param sn    :
     * @param token :
     * @return: java.lang.Integer
     */
    Integer receive(String sn, String token);

    /**
     * 完成订单
     *
     * @param sn    :
     * @param token :
     * @return: java.lang.Integer
     */
    Integer complete(String sn, String token);

    /**
     * 取消订单
     *
     * @param sn    :
     * @param token :
     * @return: java.lang.Integer
     */
    Integer cancel(String sn, String token);

    /**
     * 获取订单所有信息
     *
     * @param sn    : 订单编号
     * @param token :
     * @return: java.util.Optional
     */
    Optional<Map<String, Object>> findOrderInfoByOrderSn(String sn, String token);

    Optional<Order> findById(Integer id);
}
