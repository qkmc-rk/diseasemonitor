package cn.cmcc.diseasemonitor.controller;

import cn.cmcc.diseasemonitor.service.PicService;
import cn.cmcc.diseasemonitor.util.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 这个controller主要用来上传下载图片等作用
 */
@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Autowired
    PicService picService;

    @GetMapping("/pic/{picId}")
    @ApiOperation(value = "没有权限要求，通过id获取图片地址")
    public ResponseEntity getPicInfo(@PathVariable Integer picId){
        return  ControllerUtil.getDataResult(picService.findById(picId));
    }

    @GetMapping("/pdf/{pdfId}")
    @ApiOperation(value = "没有权限要求，通过id获取pdf地址")
    public ResponseEntity getPdfInfo(@PathVariable Integer pdfId){
        return  ControllerUtil.getDataResult(picService.findById(pdfId));
    }

    /**
     * 图片上传 需要权限验证,token要放到header中
     * @param multipartFile
     * @return 上传后的pic记录
     */
    @PostMapping("/image")
    @ApiOperation(value = "图片上传接口")
    public ResponseEntity uploadPicture(MultipartFile multipartFile){
        return ControllerUtil.getDataResult(picService.savePic(multipartFile));
    }

    @PostMapping("/pdf")
    @ApiOperation(value = "pdf上传接口", notes = "pdf处理逻辑暂时与image处理方式相同")
    public ResponseEntity uploadPdf(MultipartFile multipartFile){
        return ControllerUtil.getDataResult(picService.savePdf(multipartFile));
    }
}
