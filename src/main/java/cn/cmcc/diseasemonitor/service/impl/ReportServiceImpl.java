package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Report;
import cn.cmcc.diseasemonitor.service.ReportService;
import cn.cmcc.diseasemonitor.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportRepository resp;
}
