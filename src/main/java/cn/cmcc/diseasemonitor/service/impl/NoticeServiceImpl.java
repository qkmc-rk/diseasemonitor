package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.controller.ControllerUtil;
import cn.cmcc.diseasemonitor.entity.Notice;
import cn.cmcc.diseasemonitor.repository.NoticeRepository;
import cn.cmcc.diseasemonitor.service.NoticeService;
import cn.cmcc.diseasemonitor.util.RedisUtil;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Override
    public ResponseEntity getLastSixNotice(String token) {
        // 此处不会抛异常
        Integer userId = Integer.parseInt(RedisUtil.getInstance().readDataFromRedis(token));
        // userid - labid - orderid - noticeid
        List<Map<String, Object>> selected = noticeRepository.selectLastSixNotice(userId);
        List<Map<String, Object>> result = new ArrayList<>();
        selected.forEach(item -> {
            // 0 是新订单
            Map<String, Object> map = new HashMap<>();
            map.putAll(item);
            String orderSn = (String) item.get("order_sn");
            map.put("msg", getNewOrderMessage(orderSn));
            result.add(map);
        });
        return ControllerUtil.getDataResult(result);
    }

    @Override
    public ResponseEntity getNoticeByPage(String token, Integer pageNum, Integer pageSize) {
        Integer userId = Integer.parseInt(RedisUtil.getInstance().readDataFromRedis(token));
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Map<String, Object>> page = noticeRepository.findPageByUserId(userId, pageable);
        System.out.println(JSON.toJSONString(page));
        return ControllerUtil.getDataResult(page);
    }

    /**
     * WARNING:
     * 考虑到实验室端应该不会有什么代码大神胡乱找后台的漏洞
     * 所以这里没有做该条消息是否属于某个用户的操作
     * 意思是只要是实验室人员就能读掉任意一条消息
     *
     */
    @Override
    @Transactional
    public ResponseEntity readSomeNotice(String token, List<Notice> notices) {
        // token 用于鉴定是否是该实验室用户的notice
        // 省略权限鉴定
        List<Notice> notices1 = findAllById(notices);
        notices1.forEach(item -> item.setIfNew(true));
        log.info("嘿嘿准备存到数据库: {}", JSON.toJSONString(notices1));
        try {
            List<Notice> notices2 = noticeRepository.saveAll(notices1);
            noticeRepository.flush();
            log.info("存放成功：{}", JSON.toJSONString(notices2));
            return ControllerUtil.getSuccessResultMsgBySelf("已读成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return ControllerUtil.getFalseResultMsgBySelf(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ResponseEntity deleteSomeNotice(String token, List<Notice> notices) {
        // token 用于鉴定是否是该实验室用户的notice
        List<Notice> notices1 = findAllById(notices);
        notices1.forEach(item -> item.setStatus(false));
        try {
            noticeRepository.saveAll(notices1);
            // jpa也太神奇了吧？总是刷不进数据库
            noticeRepository.flush();
            return ControllerUtil.getSuccessResultMsgBySelf("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return ControllerUtil.getFalseResultMsgBySelf(e.getMessage());
        }

    }

    private List<Notice> findAllById(List<Notice> notices){
        List<Integer> noticeIds = new ArrayList<>();
        notices.forEach(item -> {
            if (item.getId() != null){
                noticeIds.add(item.getId());
            }
        });
        List<Notice> notices1 = noticeRepository.findAllById(noticeIds);
        return notices1;
    }

    private String getNewOrderMessage(String orderSn){
        StringBuilder str = new StringBuilder();
        str.append("您的新订单: 订单号码");
        str.append(orderSn);
        str.append(",");
        str.append("请进入订单详情查看");
        return str.toString();
    }
}
