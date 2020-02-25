package cn.cmcc.diseasemonitor.util;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 存放验证码的池子
 * 全局只有一个 所有验证码存到这里
 *
 */
public abstract class VerifyCodePool {

    private static final Logger logger = LoggerFactory.getLogger(VerifyCodePool.class);

    private VerifyCodePool(){}

    //验证码池
    //怎么存？ <验证码,过期时间>   //初始化大小为1200,永远不会满，因为
    /**
     * 放入一个验证码
     * @param code
     */
    public static void setVerifyCode(String ip, String code){
        RedisUtil.getInstance().setDataToRedis(ip + "verifycode",code,15);
    }

    /**
     * 验证并删除一个验证码
     * @param code
     * @return
     */
    public static boolean verify(String ip, String code){
        String code2 = RedisUtil.getInstance().readDataFromRedis(ip + "verifycode");
        if (code2.equals(code)){
            return true;
        }else {
            return false;
        }

    }


}
