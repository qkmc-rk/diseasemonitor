package cn.cmcc.diseasemonitor.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // 关联订单
    @Column(name = "order_id")
    private Integer orderId;
    // 通知信息类型：0新订单
    private Boolean type;
    // 0新消息，1已查看
    @Column(name = "if_new")
    private Boolean ifNew;

    // 创建时间
    @Column(name = "create_time")
    private Long createTime;

    // 0删除，1正常
    private Boolean status;

}
