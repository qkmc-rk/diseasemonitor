package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.entity.Notice;
import cn.cmcc.diseasemonitor.service.NoticeService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 1. 查询最近六条消息
 * 2. 分页查询所有未删除消息
 * 3. 批量将消息标记为已读
 * 4. 批量删除消息
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/tip")
    @ApiOperation(value = "获取最近六条消息")
    public ResponseEntity getLastSixNotice(@RequestHeader String token){
        return noticeService.getLastSixNotice(token);
    }

    @GetMapping("")
    @ApiOperation(value = "分页获取一些消息, 传入分页参数")
    public ResponseEntity getSomeNotice(@RequestHeader String token,
                                        @RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize){
        return noticeService.getNoticeByPage(token, pageNum, pageSize);
    }

    /**
     *  same url same arguments with different http method with throw exception
     * @param token
     * @param notices
     * @return
     */
    @PostMapping("/read")
    @ApiOperation(value = "批量读取一些消息,只需要传入对象中包含id即可")
    public ResponseEntity readSomeNotice(@RequestHeader String token,@RequestBody List<Notice> notices){
        return noticeService.readSomeNotice(token, notices);
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "批量删除一些消息,只需要传入对象中包含id即可")
    public ResponseEntity deleteSomeNotice(@RequestHeader String token, @RequestBody List<Notice> notices){
        return noticeService.deleteSomeNotice(token, notices);
    }

}
