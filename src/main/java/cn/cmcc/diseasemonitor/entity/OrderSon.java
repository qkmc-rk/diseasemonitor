package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 订单儿子就订单儿子吧
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "order_son")
public class OrderSon {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "commodity_id", nullable = true)
	private Integer commodityId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "count", nullable = true)
	private Integer count;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "buy_id", nullable = true)
	private Integer buyId;

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
	 * null
	 * default value: null
	 */
	@Column(name = "status", nullable = true)
	private String status;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "payable", nullable = true)
	private Double payable;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "order_id", nullable = true)
	private Integer orderId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "repertory_id", nullable = true)
	private Integer repertoryId;
}
