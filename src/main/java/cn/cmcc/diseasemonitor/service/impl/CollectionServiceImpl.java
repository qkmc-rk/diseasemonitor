package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Collection;
import cn.cmcc.diseasemonitor.service.CollectionService;
import cn.cmcc.diseasemonitor.repository.CollectionRepository;

@Service
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionRepository resp;
}
