package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.UserRole;
import cn.cmcc.diseasemonitor.service.UserRoleService;
import cn.cmcc.diseasemonitor.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleRepository resp;
}
