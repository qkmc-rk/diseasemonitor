package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 购物车
 */
@Entity
@Table(name = "shop_car")
@DynamicInsert
@DynamicUpdate
public class ShopCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    // 购物者id
    @Column(name = "user_id")
    private Integer userId;
    // 仓库Id
    @Column(name = "repertory_id")
    private Integer repertoryId;
    // 数量
    private Integer num;
    //
    @Column(name = "create_time")
    private long createTime;
    @Column(name = "update_time")
    private long updateTime;
    // 状态 0取消，1正常，2下单
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "id=" + id +
                ", userId=" + userId +
                ", repertoryId=" + repertoryId +
                ", num=" + num +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
