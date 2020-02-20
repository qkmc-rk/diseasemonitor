package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 仓库，commodity有多少都存在仓库里面，这个仓库还
 */
@Entity
@Table(name = "repertory")
@DynamicInsert
@DynamicUpdate
public class Repertory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 实验室id
    @Column(name = "laboratory_id")
    private Integer laboratoryId;
    // 商品名
    @Column(name = "disease_id")
    private Integer diseaseId;
    //
    @Column(name = "commodity_id")
    private Integer commodityId;
    // 价格
    private double price;
    //
    private Integer inventory;
    @Column(name = "create_time")
    private long createTime;
    @Column(name = "update_time")
    private long updateTime;
    // 创建人
    @Column(name = "user_id")
    private Integer userId;
    // ‘1’上架，‘0’下架
    private String status;

    private Integer logo;
    // 标签
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
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

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Repertory{" +
                "id=" + id +
                ", laboratoryId=" + laboratoryId +
                ", diseaseId=" + diseaseId +
                ", commodityId=" + commodityId +
                ", price=" + price +
                ", inventory=" + inventory +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", logo=" + logo +
                ", tag='" + tag + '\'' +
                '}';
    }
}
