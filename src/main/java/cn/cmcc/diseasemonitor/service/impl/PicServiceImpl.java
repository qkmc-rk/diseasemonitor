package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.util.MD5Util;
import cn.cmcc.diseasemonitor.util.QiNiuFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Pic;
import cn.cmcc.diseasemonitor.service.PicService;
import cn.cmcc.diseasemonitor.repository.PicRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private PicRepository resp;

    @Override
    public Pic findById(Integer picId) {
        Optional<Pic> pic = resp.findById(picId);
        return pic.isPresent() ? pic.get() : null;
    }

    @Override
    public Pic savePic(MultipartFile multipartFile) {
        String picUrl = QiNiuFileUtil.uploadImageToQiNiu(multipartFile);
        Pic pic = new Pic();
        pic.setCreateTime(new Date().getTime());
        pic.setUpdateTime(new Date().getTime());
        pic.setUrl(picUrl);
        return resp.save(pic);
    }

    @Override
    public Pic savePdf(MultipartFile multipartFile) {
        String key = MD5Util.trueMd5(new Long(new Date().getTime()).toString()) + ".pdf";
        try {
            String pdfUrl = QiNiuFileUtil.uploadFileToQiNiu(multipartFile.getInputStream(), key);
            Pic pic = new Pic();
            pic.setCreateTime(new Date().getTime());
            pic.setUpdateTime(new Date().getTime());
            pic.setUrl(pdfUrl);
            return resp.save(pic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> findPicUrlListByIdIn(Collection collection) {
        return resp.findPicsByIdIn(collection);
    }
}
