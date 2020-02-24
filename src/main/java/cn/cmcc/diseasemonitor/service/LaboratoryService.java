package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Laboratory;

import javax.swing.text.LabelView;
import java.util.Optional;


import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.Pic;

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

    /**
     * 找到实验室的信息并返回
     * @param token
     * @return 实验室记录 或者 null
     */
    Laboratory findLaboratory(String token);

    /**
     * 这个logo获取可真是够曲折的，不过也方面静态资源的管理
     * @param token
     * @return
     */
    Pic getLogo(String token);

    /**
     * 保存一个lab
     * @param laboratory
     * @return
     */
    Laboratory save(Laboratory laboratory);

}
