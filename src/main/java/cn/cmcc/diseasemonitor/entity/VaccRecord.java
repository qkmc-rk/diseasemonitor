package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 疫苗种类？？？
 */
@Entity
@Table(name = "vacc_record")
@DynamicInsert
@DynamicUpdate
public class VaccRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 日龄
    private String age;
    // 疫苗种类
    @Column(name = "vacc_type")
    private String vaccType;
    // 厂商
    private String manufacturer;
    // 关联订单
    @Column(name = "order_id")
    private Integer orderId;
    // 1正常
    private boolean status;
    //
    @Column(name = "create_time")
    private long createTime;

    @Column(name = "update_time")
    private long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getVaccType() {
        return vaccType;
    }

    public void setVaccType(String vaccType) {
        this.vaccType = vaccType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "VaccRecord{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", vaccType='" + vaccType + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", orderId=" + orderId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
