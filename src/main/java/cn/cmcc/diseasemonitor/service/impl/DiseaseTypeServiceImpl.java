package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.DiseaseType;
import cn.cmcc.diseasemonitor.service.DiseaseTypeService;
import cn.cmcc.diseasemonitor.repository.DiseaseTypeRepository;

@Service
public class DiseaseTypeServiceImpl implements DiseaseTypeService {
	@Autowired
	private DiseaseTypeRepository resp;
}
