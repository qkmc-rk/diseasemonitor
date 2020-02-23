package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;

import java.util.Optional;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {
    @Autowired
    private LaboratoryRepository resp;

    @Override
    public Optional<Laboratory> findById(Integer id) {
        return resp.findById(id);
    }

    @Override
    public Optional<Laboratory> findByUserId(Integer id) {
        return resp.findByUserId(id);
    }
}
