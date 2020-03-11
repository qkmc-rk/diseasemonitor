package cn.cmcc.diseasemonitor.util;

public interface Constant {

    Integer SUCCESS_CODE = 1;
    //public final static is default
    Integer FAILURE_CODE = -1;

    String MSG_CLIENT_DATA_ERROR = "客户端数据错误";

    String MSG_SUCCESS = "响应成功";

    String MSG_SERVER_ERROR = "服务器故障";

    String MSG_INVALID_OPERATION = "非法操作";

    //登录时要用的CODE

    //成功登录
    Integer LOGIN_SUCCESS = 1;

    //未注册
    Integer LOGIN_NO_USER = 0;

    //传入code 有误登录失败
    Integer LOGIN_CODE_ERROR = -1;

    //传入的code已经被使用了
    Integer LOGIN_CODE_USED = -2;

    //服务器在处理一些操作的时候发生了异常
    Integer LOGIN_SERVER_ERROR = -3;

    Integer LOGIN_BLACK_USER = -4;

    //注册时要用的CODE

    //成功注册
    Integer REGISTER_SUCCESS = 1;

    //已经注册过了
    Integer REGISTER_ALREADY_DOWN = 0;

    //传入code 有误注册失败
    Integer REGISTER_CODE_ERROR = -1;

    //传入的code已经被使用了
    Integer REGISTER_CODE_USED = -2;

    //服务器在处理一些操作的时候发生了异常
    Integer REGISTER_SERVER_ERROR = -3;


    //登录时微信返回的code
    //已经被使用的code
    Integer WX_USED_CODE = 40163;
    Integer WX_ERROR_CODE = 40029;

    //使用aop处理时抛出了异常
    Integer AOP_SERVER_ERROR = -4;

    Integer AUTH_ERROR = 403;

    //product 操作
    Integer PRODUCT_ERROR = -1;
    Integer PRODUCT_SUCCESS = 1;

    //字符转换操作
    Integer FORMAT_SUCCESS = 1;
    Integer FORMAT_ERROR = -1;

    //单次交易最多能使用多少积分
    Integer MAX_CREDIT = 100;


    /**
     * 登录时需要的参数
     */
    Integer NO_USER = -3;
    Integer ERROR_PWD = -2;
    Integer NO_PERMISSION = -1;
    Integer UNKNOWN_ERROR = -100;
    Integer VERIFYCODE_ERROR = -101;
    Integer VERIFYCODE_NONE = -102;
    Integer PHONE_WRONG = -103;
    Integer LEVEL1 = 1;
    Integer LEVEL2 = 2;
    Integer LEVEL3 = 3;
    Integer LEVEL4 = 4;
    Integer LEVEL5 = 5;

    Integer SOCKET_QUERY = 1;
}
