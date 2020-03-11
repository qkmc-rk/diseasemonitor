package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.util.MD5Util;
import cn.cmcc.diseasemonitor.util.QiNiuFileUtil;
import cn.cmcc.diseasemonitor.util.TimeUtil;
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

    @Autowired
    UserService userService;

    @Override
    public Pic findById(Integer picId) {
        Optional<Pic> pic = resp.findById(picId);
        return pic.isPresent() ? pic.get() : null;
    }

    @Override
    public Pic savePic(String token, MultipartFile multipartFile) {
        return userService.findUserIdByToken(token).map((k) -> {
            String picUrl = QiNiuFileUtil.uploadImageToQiNiuWithHttps(multipartFile);
            Pic pic = new Pic();
            pic.setCreateTime(TimeUtil.getTime());
            pic.setUpdateTime(TimeUtil.getTime());
            pic.setUrl(picUrl);
            pic.setUploadUserType("1");
            pic.setUploadUser(k);
            return resp.save(pic);
        }).orElse(null);
    }
    @Override
    public Pic saveFile(String token, MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(suffix);
        String key = MD5Util.trueMd5(new Long(new Date().getTime()).toString()) + "." + suffix;
        Optional<Integer> userId = userService.findUserIdByToken(token);
        if (!userId.isPresent()) return null;
        try {
            String pdfUrl = QiNiuFileUtil.uploadFileToQiNiuWithHttps(multipartFile.getInputStream(), key);
            Pic pic = new Pic();
            pic.setCreateTime(TimeUtil.getTime());
            pic.setUpdateTime(TimeUtil.getTime());
            pic.setUrl(pdfUrl);
            pic.setUploadUserType("1");
            pic.setUploadUser(userId.get());
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
