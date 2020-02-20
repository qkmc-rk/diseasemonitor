package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.RolePermission;
import cn.cmcc.diseasemonitor.service.RolePermissionService;
import cn.cmcc.diseasemonitor.repository.RolePermissionRepository;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionRepository resp;
}
