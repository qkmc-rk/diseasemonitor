package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Pic;
import cn.cmcc.diseasemonitor.service.PicService;
import cn.cmcc.diseasemonitor.repository.PicRepository;

@Service
public class PicServiceImpl implements PicService {
	@Autowired
	private PicRepository resp;
}
