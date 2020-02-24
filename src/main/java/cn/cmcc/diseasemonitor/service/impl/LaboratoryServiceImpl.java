package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Pic;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.repository.PicRepository;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;

import java.util.Optional;

import javax.swing.text.html.parser.Entity;
import java.util.Date;
import java.util.Optional;

@Service
public class LaboratoryServiceImpl implements LaboratoryService {
    @Autowired
    private LaboratoryRepository resp;


    @Autowired
    UserService userService;

    @Autowired
    PicRepository picRepository;

    @Override
    public Optional<Laboratory> findById(Integer id) {
        return resp.findById(id);
    }

    @Override
    public Optional<Laboratory> findByUserId(Integer id) {
        return resp.findByUserId(id);
    }

    @Override
    public Laboratory findLaboratory(String token) {
        User user = userService.findUserByToken(token).get();
        Optional<Laboratory> lab = resp.findTopByUserIdAndStatus(user.getId(), "1");
        return lab.isPresent() ? lab.get() : null;
    }

    @Override
    public Pic getLogo(String token) {
        Laboratory lab = findLaboratory(token);
        return picRepository.findById(lab.getLogo()).get();
    }

    @Override
    public Laboratory save(Laboratory laboratory) {
        if (null == laboratory.getId() || laboratory.getId() < 1) {
            return null;
        } else {
            Optional<Laboratory> lab = resp.findById(laboratory.getId());
            if (!lab.isPresent()) {
                System.out.println("没有找到lab: " + laboratory.getId());
                return null;
            }
            Laboratory old = lab.get();
            EntityUtil.update(laboratory, old);
            //更新时间
            laboratory.setUpdateTime(new Date().getTime());
            return resp.save(laboratory);
        }
    }
}
