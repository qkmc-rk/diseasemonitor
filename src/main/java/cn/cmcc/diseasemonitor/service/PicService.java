package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Pic;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface PicService {

    /**
     * 寻找一个图片
     *
     * @param picId
     * @return
     */
    Pic findById(Integer picId);

    /**
     * 上传一张图片
     *
     * @param multipartFile
     * @return
     */
    Pic savePic(String token, MultipartFile multipartFile);

    /**
     * 上传pdf
     *
     * @param multipartFile
     * @return
     */
    Pic saveFile(String token, MultipartFile multipartFile);

    List<String> findPicUrlListByIdIn(Collection collection);
}
