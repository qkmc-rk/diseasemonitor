package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 *
 * 微信小程序用户信息表
 *
 */
@Entity
@Table(name = "mobile_user")
@DynamicUpdate
@DynamicInsert
public class MobileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // openid
    private String openid;
    // 微信号
    private String wechat;
    // 微信昵称
    private String nickname;
    // 姓名
    private String name;
    // 电话
    private String phone;
    // 公司
    private String company;
    // 所在区域
    private String location;
    // 详细地址
    private String address;
    // 纳税人识别号
    @Column(name = "taxpayer_identity_num")
    private String taxpayerIdentityNum;
    // 创建时间
    private long create_time;
    // 更新时间
    private long update_time;
    // 状态 ‘0’删除，‘1’正常
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaxpayerIdentityNum() {
        return taxpayerIdentityNum;
    }

    public void setTaxpayerIdentityNum(String taxpayerIdentityNum) {
        this.taxpayerIdentityNum = taxpayerIdentityNum;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MobileUser{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", wechat='" + wechat + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", taxpayerIdentityNum='" + taxpayerIdentityNum + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", status='" + status + '\'' +
                '}';
    }
}
