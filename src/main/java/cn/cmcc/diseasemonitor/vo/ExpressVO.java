package cn.cmcc.diseasemonitor.vo;

import lombok.Data;

import java.util.Map;

@Data
public class ExpressVO {

    private String status;
    private String msg;
    private Map<String, Object> result;
}
