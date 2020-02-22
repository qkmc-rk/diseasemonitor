package cn.cmcc.diseasemonitor.service;


import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.Pic;

public interface LaboratoryService {

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
