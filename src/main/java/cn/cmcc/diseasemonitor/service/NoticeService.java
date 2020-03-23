package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Notice;
import cn.cmcc.diseasemonitor.util.ResponseEntity;

import java.util.List;

public interface NoticeService {

    /**
     *
     * 获取最近的六条消息
     * @param token 实验室人员的token
     * @return 最近六条订单信息
     *
     */
    ResponseEntity getLastSixNotice(String token);

    /**
     * 根据分页大小获取消息记录, ORDER BY create_time DESC
     * @param token
     * @param pageNum 分页数
     * @param pageSize 页大小
     * @return 消息
     */
    ResponseEntity getNoticeByPage(String token, Integer pageNum, Integer pageSize);

    /**
     *  使一些notice变为已读状态
     * @param token
     * @param notices
     * @return
     */
    ResponseEntity readSomeNotice(String token, List<Notice> notices);

    /**
     * 删除一些notice
     * @param token
     * @param notices
     * @return
     */
    ResponseEntity deleteSomeNotice(String token, List<Notice> notices);
}
