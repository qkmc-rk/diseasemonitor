package cn.cmcc.diseasemonitor.entity;

import javax.persistence.*;

/**
 * 微信小程序用户的地址
 */
@Entity
@Table(name = "mobile_address")
public class MobileAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 收件人姓名
    private String name;
    // 手机号
    private String phone;
    // 所在地区
    private String location;
    // 创建人Id
    @Column(name = "user_id")
    private Integer userId;
    // 详细地址
    private String address;
    // '1'正常，'0'删除
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MobileAddress{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
