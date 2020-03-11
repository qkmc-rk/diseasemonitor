package cn.cmcc.diseasemonitor.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class ResponseEntity<T> implements Serializable {

    @JsonProperty("status")
    private Integer status = 10000000;
    @JsonProperty("message")
    private String message = "default";
    @JsonProperty("data")
    private T data;

    @JsonProperty("timestamp")
    private Date timestamp = new Date();

    public  void success(T data){
        this.status = Constant.SUCCESS_CODE;
        this.message = Constant.MSG_SUCCESS;
        this.data = data;
    }

    public  void serverError(){
        this.status = Constant.FAILURE_CODE;
        this.message = Constant.MSG_SERVER_ERROR;
    }

    public  void clientError(){
        this.status = Constant.FAILURE_CODE;
        this.message = Constant.MSG_CLIENT_DATA_ERROR;
    }

    /**
     * 自定义错误状态
     * @param status 错误码
     * @param message 错误信息
     * @param data 错误时的数据
     */
    public void error(Integer status, String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;

    }

    /**
     * 自定义成功状态
     * @param status 成功代码
     * @param message 成功信息
     * @param data 成功时的数据
     */
    public void success(Integer status, String message,T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
