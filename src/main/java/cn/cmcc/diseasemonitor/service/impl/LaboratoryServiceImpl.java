package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {
	@Autowired
	private LaboratoryRepository resp;
}
