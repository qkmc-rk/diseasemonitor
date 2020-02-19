package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 订单记录，这是干嘛的
 */
@Entity
@Table(name = "order_record")
@DynamicUpdate
@DynamicInsert
public class OrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 操作时间
    private long time;
    // 操作类型，0创建，1付款，2寄出样品，4确认收样，5订单完成
    private String type;
    @Column(name = "order_id")
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "id=" + id +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
