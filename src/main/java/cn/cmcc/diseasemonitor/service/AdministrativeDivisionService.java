package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.AdministrativeDivision;

import java.util.List;
import java.util.Map;

public interface AdministrativeDivisionService {

    /**
     * 通过level和parentCode返回地址列表
     * @param level
     * @param parentCode
     * @return
     */
    List<AdministrativeDivision> getDistrict(Integer level, String parentCode);

    /**
     * 通过city和addr得到经纬度
     * @param address
     * @return
     */
    Map<String, Object> gecoding(String address);
}
