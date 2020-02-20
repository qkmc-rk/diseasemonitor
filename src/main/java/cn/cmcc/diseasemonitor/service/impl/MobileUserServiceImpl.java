package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.MobileUser;
import cn.cmcc.diseasemonitor.service.MobileUserService;
import cn.cmcc.diseasemonitor.repository.MobileUserRepository;

@Service
public class MobileUserServiceImpl implements MobileUserService {
	@Autowired
	private MobileUserRepository resp;
}
