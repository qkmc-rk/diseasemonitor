package cn.cmcc.diseasemonitor.util;

import cn.cmcc.diseasemonitor.vo.ExpressVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 快递查询工具类 用于查询快递
 * @Author mrruan
 */
@Component
@Slf4j
public class ExpressUtil {

    @Value("${ali.express.appkey}")
    private String appkey;
    @Value("${ali.express.secret}")
    private String secret;
    @Value("${ali.express.appcode}")
    private String appcode;
    @Value("${ali.express.host}")
    private String host;
    @Value("${ali.express.path}")
    private String path;


    public static ExpressUtil expressUtil;

    @PostConstruct
    public void init(){
        expressUtil = this;
    }


    /**
     * 查询快递啊
     * @param number 快递单号
     * @param type 类型
     * @return 查询结果
     */
    public Map<String, Object> queryExpress(String number,String type){
        log.info("查询快递：单号：{}，类型：{}",number, type);
        Map<String, Object> rs = new HashMap<>();
        String method = "GET";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        log.info("appcode:{}",appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("no", number);// !!! 请求参数
        querys.put("type", type);// !!! 请求参数
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/Tools.zip
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            log.info("快递查询结果：{}", content);
            ExpressVO expressVO = JSON.parseObject(content,ExpressVO.class);
            log.info("快递查询转换结果：{}", expressVO);
            rs.put("SUCCESS", expressVO);
            return rs; //输出json
        } catch (Exception e) {
            e.printStackTrace();
            rs.put("ERROR", e.getMessage());
            return rs;
        }
    }

    public static ExpressUtil getInstance(){
        return expressUtil;
    }
}
