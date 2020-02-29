package cn.cmcc.diseasemonitor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.service.CommodityService;
import cn.cmcc.diseasemonitor.repository.CommodityRepository;

import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository resp;

    @Override
    public List<Map<String, Object>> findCommodities() {
        return resp.findCommodities();
    }
}
