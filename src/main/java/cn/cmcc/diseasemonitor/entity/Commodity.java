package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 商品表
 * 每一种商品对应一条记录
 */
@Entity
@Table(name = "commodity")
@DynamicUpdate
@DynamicInsert
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 商品名
    @Column(name = "disease_id")
    private Integer diseaseId;

    // 疫苗种类
    private String name;

    // 采样说明
    @Column(name = "sampling_instruction")
    private String samplingInstruction;

    // 检测说明
    @Column(name = "deletection_instruction")
    private String deletectionInstruction;

    // 创建时间
    @Column(name = "create_time")
    private long createTime;

    // 修改时间
    @Column(name = "update_time")
    private long updateTime;

    // 创建人
    @Column(name = "user_id")
    private Integer userId;

    // ‘1’上架，‘0’下架
    @Column(name = "status")
    private String status;


    private Integer logo;

    // 标签
    private String tag;

    // 0一般商品，1套餐
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Integer diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSamplingInstruction() {
        return samplingInstruction;
    }

    public void setSamplingInstruction(String samplingInstruction) {
        this.samplingInstruction = samplingInstruction;
    }

    public String getDeletectionInstruction() {
        return deletectionInstruction;
    }

    public void setDeletectionInstruction(String deletectionInstruction) {
        this.deletectionInstruction = deletectionInstruction;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", diseaseId=" + diseaseId +
                ", name='" + name + '\'' +
                ", samplingInstruction='" + samplingInstruction + '\'' +
                ", deletectionInstruction='" + deletectionInstruction + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", logo=" + logo +
                ", tag='" + tag + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
