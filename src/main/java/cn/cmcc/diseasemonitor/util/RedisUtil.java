package cn.cmcc.diseasemonitor.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * redis操作的工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static RedisUtil redisUtil;

    @PostConstruct
    public void init(){
        redisUtil = this;
    }

    public String readDataFromRedis(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void setDataToRedis(String key, String value, Integer min) {
        System.out.println("嘿嘿： " + stringRedisTemplate);
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value, min, TimeUnit.MINUTES);
    }

    public Boolean tokenToRedis(Integer userId, String token, Integer period) {
        setDataToRedis("token" + userId, token, period);
        setDataToRedis(token, String.valueOf(userId), period);
        return true;
    }

    public static RedisUtil getInstance(){
        return redisUtil;
    }

}
