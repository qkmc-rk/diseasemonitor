package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Repertory;
import cn.cmcc.diseasemonitor.service.RepertoryService;
import cn.cmcc.diseasemonitor.repository.RepertoryRepository;

@Service
public class RepertoryServiceImpl implements RepertoryService {
	@Autowired
	private RepertoryRepository resp;
}
