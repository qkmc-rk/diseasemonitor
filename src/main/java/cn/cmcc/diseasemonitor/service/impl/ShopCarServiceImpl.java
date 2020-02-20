package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.ShopCar;
import cn.cmcc.diseasemonitor.service.ShopCarService;
import cn.cmcc.diseasemonitor.repository.ShopCarRepository;

@Service
public class ShopCarServiceImpl implements ShopCarService {
	@Autowired
	private ShopCarRepository resp;
}
