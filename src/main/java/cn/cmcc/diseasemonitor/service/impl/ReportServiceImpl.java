package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Order;
import cn.cmcc.diseasemonitor.entity.Report;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.OrderService;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.TimeUtil;
import cn.cmcc.diseasemonitor.util.constant.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.service.ReportService;
import cn.cmcc.diseasemonitor.repository.ReportRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository resp;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Override
    public List<String> findAllReportUrlByOrderId(Integer id) {
        return resp.findAllReportUrlByOrderId(id);
    }

    @Override
    public Report save(String token, String url, Integer orderId, String name, Integer type) {
        return userService.findUserIdByToken(token).map((v) -> {
            Report report = new Report();
            report.setCreateTime(TimeUtil.getTime());
            report.setUpdateTime(TimeUtil.getTime());
            report.setUploadUser(v);
            report.setUrl(url);
            // 此处通过name获取文件后缀 从而得到文件类型
            // 后续版本中移除上面传入的type
            String[] son = url.split(".");
            String fileType = son[son.length - 1];
            Integer t = 0;
            if (fileType.equals("png") ||
                    fileType.equals("gif") ||
                    fileType.equals("jpeg") ||
                    fileType.equals("jpg") ||
                    fileType.equals("bmp")){
                t = 0;
            } else {
                t = 1;
            }

            report.setType(t);
            Optional<Order> orderOptional = orderService.findById(orderId);
            if (!orderOptional.isPresent()){
                return null;
            }
            report.setBuyerId(orderOptional.get().getBuyerId());
            report.setOrderId(orderId);
            report.setName(name);
            report.setStatus(1);
            return resp.save(report);
        }).orElse(null);
    }

    @Override
    public String del(String token, Integer id) {
        return userService.findUserIdByToken(token).map((v) -> {
            return resp.findById(id).map((x) -> {
                x.setStatus(0);
                resp.save(x);
                return "删除成功";
            }).orElse(null);
        }).orElse(null);

    }

    @Override
    public String delByUrl(String token, String url) {
        return userService.findUserIdByToken(token).map((v) -> {
            return resp.findByUrl(url).map((x) -> {
                x.setStatus(0);
                resp.save(x);
                return "删除成功";
            }).orElse(null);
        }).orElse(null);
    }
}
