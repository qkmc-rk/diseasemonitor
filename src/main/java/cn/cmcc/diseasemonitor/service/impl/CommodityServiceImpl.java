package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Commodity;
import cn.cmcc.diseasemonitor.service.CommodityService;
import cn.cmcc.diseasemonitor.repository.CommodityRepository;

@Service
public class CommodityServiceImpl implements CommodityService {
	@Autowired
	private CommodityRepository resp;
}
