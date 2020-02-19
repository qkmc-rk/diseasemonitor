package cn.cmcc.diseasemonitor.entity;

import javax.persistence.*;

/**
 * 实验室信息
 */
@Entity
@Table(name = "laboratory")
public class Laboratory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 实验室
    private String laboratory;
    // 归属公司
    private String company;
    // 区域
    private String location;
    // 详细地址
    private String address;
    // 联系电话
    @Column(name = "contact_num")
    private String contactNum;
    // 简介
    private String intro;
    // 实验室logo
    private Integer logo;
    // 营业执照
    @Column(name = "business_license")
    private Integer businessLicense;
    // 收货人
    private String receiver;
    // 收件人地址
    @Column(name = "receiver_address")
    private String receiverAddress;
    // 收货人手机号
    private String phone;
    // 创建时间
    @Column(name = "create_time")
    private long createTime;
    // 修改时间
    @Column(name = "update_time")
    private long updateTime;
    // 创建人
    @Column(name = "user_id")
    private Integer userId;
    // 1正常，0删除
    private String status;
    // 省
    private String province;
    // 市
    private String city;
    // 区
    private String district;
    // 经纬度
    @Column(name = "longitude_and_latitude")
    private String longitudeAndLatitude;
    // 标签
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
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

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public Integer getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(Integer businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLongitudeAndLatitude() {
        return longitudeAndLatitude;
    }

    public void setLongitudeAndLatitude(String longitudeAndLatitude) {
        this.longitudeAndLatitude = longitudeAndLatitude;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "id=" + id +
                ", laboratory='" + laboratory + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", intro='" + intro + '\'' +
                ", logo=" + logo +
                ", businessLicense=" + businessLicense +
                ", receiver='" + receiver + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", longitudeAndLatitude='" + longitudeAndLatitude + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
