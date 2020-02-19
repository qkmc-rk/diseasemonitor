package cn.cmcc.diseasemonitor.entity;

import javax.persistence.*;

/**
 * 订单儿子
 * 数据库没有注释，该注释由mrruan添加注释
 */
@Entity
@Table(name = "order_son")
public class OrderSon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 商品Id
    @Column(name = "commodity_id")
    private Integer commodityId;
    // 数量
    private Integer count;
    // ???
    @Column(name = "buy_id")
    private Integer buyId;

    @Column(name = "update_time")
    private long updateTime;
    @Column(name = "create_time")
    private long createTime;
    // 状态 0删除 1未删除
    private String status;
    // ???
    private double payable;
    // 订单号码
    @Column(name = "order_id")
    private Integer orderId;
    // 仓库ID？？？
    @Column(name = "repertory_id")
    private Integer repertoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
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

    public double getPayable() {
        return payable;
    }

    public void setPayable(double payable) {
        this.payable = payable;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    @Override
    public String toString() {
        return "OrderSon{" +
                "id=" + id +
                ", commodityId=" + commodityId +
                ", count=" + count +
                ", buyId=" + buyId +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", payable=" + payable +
                ", orderId=" + orderId +
                ", repertoryId=" + repertoryId +
                '}';
    }
}
