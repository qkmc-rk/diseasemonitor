package cn.cmcc.diseasemonitor.util.constant;

public enum SmsType {
    LOGIN("登录"),
    FORGOT_PASSWORD("忘记密码"),
    CHANGE_PASSWORD("修改密码"),
    CHANGE_PHONE("修改手机号码");

    private String name;

    SmsType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
