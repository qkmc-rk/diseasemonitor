package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Permission;
import cn.cmcc.diseasemonitor.service.PermissionService;
import cn.cmcc.diseasemonitor.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionRepository resp;
}
