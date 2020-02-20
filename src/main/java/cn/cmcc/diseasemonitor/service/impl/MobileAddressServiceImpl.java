package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.MobileAddress;
import cn.cmcc.diseasemonitor.service.MobileAddressService;
import cn.cmcc.diseasemonitor.repository.MobileAddressRepository;

@Service
public class MobileAddressServiceImpl implements MobileAddressService {
	@Autowired
	private MobileAddressRepository resp;
}
