package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.VaccRecord;
import cn.cmcc.diseasemonitor.service.VaccRecordService;
import cn.cmcc.diseasemonitor.repository.VaccRecordRepository;

@Service
public class VaccRecordServiceImpl implements VaccRecordService {
	@Autowired
	private VaccRecordRepository resp;
}
