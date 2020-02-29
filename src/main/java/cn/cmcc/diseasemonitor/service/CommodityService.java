package cn.cmcc.diseasemonitor.service;


import java.util.List;
import java.util.Map;

public interface CommodityService {
    List<Map<String, Object>> findCommodities();
}
