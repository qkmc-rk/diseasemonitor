package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 订单表
 */

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "order")
public class Order {

	/**
	 * 订单号
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 运单号
	 * default value: null
	 */
	@Column(name = "logistics_num", nullable = true)
	private String logisticsNum;

	/**
	 * 快递
	 * default value: null
	 */
	@Column(name = "logistics", nullable = true)
	private String logistics;

	/**
	 * 采样图片id
	 * default value: null
	 */
	@Column(name = "sample_ids", nullable = false)
	private String sampleIds;

	/**
	 * 购买人id
	 * default value: null
	 */
	@Column(name = "buyer_id", nullable = false)
	private Integer buyerId;

	/**
	 * 已付款
	 * default value: 0.00
	 */
	@Column(name = "payed", nullable = false)
	private Double payed;

	/**
	 * 应付款
	 * default value: 0.00
	 */
	@Column(name = "payable", nullable = false)
	private Double payable;

	/**
	 * 付款方式
	 * default value: null
	 */
	@Column(name = "pay_type", nullable = true)
	private String payType;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "update_time", nullable = true)
	private Long updateTime;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "create_time", nullable = true)
	private Long createTime;

	/**
	 * 订单状态，1待付款，2待寄送，3运输中，4检测中，5已完成，0已取消
	 * default value: '1'
	 */
	@Column(name = "status", nullable = false)
	private String status;

	/**
	 * 实验室id
	 * default value: null
	 */
	@Column(name = "laboratory_id", nullable = true)
	private Integer laboratoryId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "instruction", nullable = true)
	private String instruction;

	/**
	 * 付款时间
	 * default value: null
	 */
	@Column(name = "pay_time", nullable = true)
	private Long payTime;

	/**
	 * 报告
	 * default value: null
	 */
	@Column(name = "report", nullable = true)
	private String report;

	/**
	 * 订单编号
	 * default value: null
	 */
	@Column(name = "order_sn", nullable = true)
	private String orderSn;
}
