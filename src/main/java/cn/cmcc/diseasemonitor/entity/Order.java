package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 订单号
 */
@Entity
@Table(name = "order")
@DynamicInsert
@DynamicUpdate
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 订单号
    @Column(name = "logistics_num")
    private String logisticsNum;
    // 快递
    private String logistics;
    // 采样图片id
    @Column(name = "sample_ids")
    private String sampleIds;
    // 购买人id
    @Column(name = "buyer_id")
    private Integer buyerId;
    // 已付款
    private double payed;
    // 应付款
    private double payable;
    // 付款方式
    @Column(name = "pay_type")
    private String payType;
    //
    @Column(name = "update_time")
    private long updateTime;

    @Column(name = "create_time")
    private long createTime;
    // 订单状态，1待付款，2待寄送，3运输中，4检测中，5已完成，0已取消
    private String status;
    // 实验室id
    @Column(name = "laboratory_id")
    private Integer laboratoryId;
    // instruction
    private String instruction;
    // 付款时间
    @Column(name = "pay_time")
    private long payTime;
    // 报告
    private String report;
    // 订单编号
    @Column(name = "order_sn")
    private String orderSn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getSampleIds() {
        return sampleIds;
    }

    public void setSampleIds(String sampleIds) {
        this.sampleIds = sampleIds;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public double getPayed() {
        return payed;
    }

    public void setPayed(double payed) {
        this.payed = payed;
    }

    public double getPayable() {
        return payable;
    }

    public void setPayable(double payable) {
        this.payable = payable;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public long getPayTime() {
        return payTime;
    }

    public void setPayTime(long payTime) {
        this.payTime = payTime;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", logisticsNum='" + logisticsNum + '\'' +
                ", logistics='" + logistics + '\'' +
                ", sampleIds='" + sampleIds + '\'' +
                ", buyerId=" + buyerId +
                ", payed=" + payed +
                ", payable=" + payable +
                ", payType='" + payType + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", laboratoryId=" + laboratoryId +
                ", instruction='" + instruction + '\'' +
                ", payTime=" + payTime +
                ", report='" + report + '\'' +
                ", orderSn='" + orderSn + '\'' +
                '}';
    }
}
