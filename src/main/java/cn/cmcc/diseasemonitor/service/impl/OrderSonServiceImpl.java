package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.OrderSon;
import cn.cmcc.diseasemonitor.service.OrderSonService;
import cn.cmcc.diseasemonitor.repository.OrderSonRepository;

@Service
public class OrderSonServiceImpl implements OrderSonService {
	@Autowired
	private OrderSonRepository resp;
}
