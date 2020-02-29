package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Report;

import java.util.List;

public interface ReportService {
    List<String> findAllReportUrlByOrderId(Integer id);

    Report save(String token, String url, Integer orderId, String name, Integer type);

    String del(String token, Integer id);

}
