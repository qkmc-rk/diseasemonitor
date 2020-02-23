package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Laboratory;

import javax.swing.text.LabelView;
import java.util.Optional;

public interface LaboratoryService {

    /**
     * 查询实验室信息
     *
     * @param id :
     * @return: java.util.Optional<cn.cmcc.diseasemonitor.entity.Laboratory>
     */
    Optional<Laboratory> findById(Integer id);

    /**
     * 根据用户Id查询实验室信息
     *
     * @param id : userId
     * @return: java.util.Optional<cn.cmcc.diseasemonitor.entity.Laboratory>
     */
    Optional<Laboratory> findByUserId(Integer id);
}
