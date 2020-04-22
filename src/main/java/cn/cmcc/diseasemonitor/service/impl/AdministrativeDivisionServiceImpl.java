package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.AdministrativeDivision;
import cn.cmcc.diseasemonitor.repository.AdministrativeDivisionRepository;
import cn.cmcc.diseasemonitor.service.AdministrativeDivisionService;
import cn.cmcc.diseasemonitor.util.Constant;
import cn.cmcc.diseasemonitor.util.HttpUtils;
import cn.cmcc.diseasemonitor.util.SnCal;
import cn.cmcc.diseasemonitor.vo.ExpressVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AdministrativeDivisionServiceImpl implements AdministrativeDivisionService {

    @Value("${baidu.map.ak}")
    private String ak;

    @Value("${baidu.map.sk}")
    private String sk;

    @Value("${baidu.map.url}")
    private String url;

    @Autowired
    AdministrativeDivisionRepository repository;

    @Override
    public List<AdministrativeDivision> getDistrict(Integer level, String parentCode) {
        boolean valid = level == Constant.LEVEL1
                || level == Constant.LEVEL2
                || level == Constant.LEVEL3
                || level == Constant.LEVEL4
                || level == Constant.LEVEL5;

        if (valid && level == Constant.LEVEL1) {
            return repository.findAllByLevel(Constant.LEVEL1);
        } else if (valid && null != parentCode) {
            return repository.findAllByLevelAndParentCode(level, parentCode);
        } else if (valid && null == parentCode) {
            return repository.findAllByLevel(level);
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> gecoding(String address) {
        Map<String, Object> rs = new HashMap<>();
        try {
            String sn = SnCal.generateSn(address, ak, sk);
            log.info("sn: {}", sn);
            // 若使用hashmap, querys里的数据的次序会被打乱，用linkedhashmap比较好
            Map<String, String> querys = new LinkedHashMap<>();
            querys.put("address", address);// !!! 请求参数
            querys.put("output", "json");// !!! 请求参数
            querys.put("ak", ak);// !!! 请求参数
            querys.put("sn", sn);// !!! 请求参数
            HttpResponse response = HttpUtils.doGet(url, null, null, querys,false);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            log.info("查询经纬度的content:{}", content);
            rs.put("SUCCESS", JSON.parse(content));
            return rs; //输出json
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }
}
