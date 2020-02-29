package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.OrderRecord;

import java.util.List;
import java.util.Map;

public interface OrderRecordService {
    void save(OrderRecord orderRecord);
    List<Map<String,Object>> findAllByOrderId(Integer id);
}
