package cn.cmcc.diseasemonitor.service;


import cn.cmcc.diseasemonitor.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
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
                                       Integer pageNum, Integer pageSize,String token);

}
