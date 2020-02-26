package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.OrderRecord;
import cn.cmcc.diseasemonitor.service.OrderRecordService;
import cn.cmcc.diseasemonitor.repository.OrderRecordRepository;

import java.util.List;

@Service
public class OrderRecordServiceImpl implements OrderRecordService {
    @Autowired
    private OrderRecordRepository resp;

    @Override
    public void save(OrderRecord orderRecord) {
        resp.save(orderRecord);
    }

    @Override
    public List<OrderRecord> findAllByOrderId(Integer id) {
        return resp.findAllByOrderId(id);
    }
}
