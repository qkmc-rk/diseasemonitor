package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.service.OrderSonService;
import cn.cmcc.diseasemonitor.repository.OrderSonRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderSonServiceImpl implements OrderSonService {
    @Autowired
    private OrderSonRepository resp;

    @Override
    public List<Map<String,Object>> findAllByOrderId(Integer id) {
        return resp.findOrderSonListByOrderId(id);
    }
}
