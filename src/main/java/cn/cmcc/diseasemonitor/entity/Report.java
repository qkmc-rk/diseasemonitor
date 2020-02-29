package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 检测报告
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "report")
public class Report {

    /**
     * null
     * default value: null
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 订单id
     * default value: null
     */
    @Column(name = "order_id", nullable = true)
    private Integer orderId;

    /**
     * 文件链接
     * default value: null
     */
    @Column(name = "url", nullable = true)
    private String url;

    /**
     * 报告类型，0文件，1图片
     * default value: null
     */
    @Column(name = "type", nullable = true)
    private Integer type;

    /**
     * 检测结果名
     * default value: null
     */
    @Column(name = "name", nullable = true)
    private String name;

    /**
     * 下单人id
     * default value: null
     */
    @Column(name = "buyer_id", nullable = true)
    private Integer buyerId;

    /**
     * null
     * default value: null
     */
    @Column(name = "create_time", nullable = true)
    private Long createTime;

    /**
     * null
     * default value: null
     */
    @Column(name = "update_time", nullable = true)
    private Long updateTime;

    /**
     * 上传用户
     * default value: null
     */
    @Column(name = "upload_user", nullable = true)
    private Integer uploadUser;

    /**
     * 1正常，0删除
     * default value: null
     */
    @Column(name = "status", nullable = true)
    private Integer status;
}
