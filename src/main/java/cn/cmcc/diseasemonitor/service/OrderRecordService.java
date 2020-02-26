package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.OrderRecord;

import java.util.List;

public interface OrderRecordService {
    void save(OrderRecord orderRecord);
    List<OrderRecord> findAllByOrderId(Integer id);
}
