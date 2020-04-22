package cn.cmcc.diseasemonitor.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class SmsUtil {


    private static String CORP_ID;

    private static String PWD;

    private static final String API_URL = "https://sdk2.028lk.com/sdk2/BatchSend2.aspx";

    // 短信模板的标签
    private static final String CODE = "{code}";

    private static final String OPERATION_NAME = "{operation}";

    private static final String SMS_TEMPLATE = "验证码：{code}，实验室用户，您正在进行{operation}操作 。（验证码告知他人将导致帐号被盗，请勿泄露）";


    static {
        Properties properties = new Properties();
        InputStream inputStream = QiNiuFileUtil.class.getClassLoader()
                .getResourceAsStream("sms.properties");
        try {
            properties.load(inputStream);
            CORP_ID = properties.getProperty("corpID");
            PWD = properties.getProperty("password");
        } catch (IOException e) {
            log.error("sms load properties[name:sms.properties] in classpath failed.");
            e.printStackTrace();
        }
    }

    public static boolean send(String code, String operation, String phone) {
        String smsText = SMS_TEMPLATE.replace(CODE, code).replace(OPERATION_NAME, operation);
        String result = null;
        Map<String, String> params = new HashMap<>();
        params.put("CorpID", CORP_ID);
        params.put("Pwd", PWD);
        params.put("Mobile", phone);
        params.put("Content", smsText);
        try {
            HttpResponse response = HttpUtils.doGet(API_URL, null, null, params, true);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            int resultInt = Integer.parseInt(result);
            // 小于0是接口返回的错误代码
            return resultInt > 0;
        } catch (Exception e) {
            log.error("短信发送失败,响应结果:{},ErrorMessage:{}", result, e.getMessage());
            return false;
        }
    }
}
