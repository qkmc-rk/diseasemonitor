package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 订单记录
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "order_record")
public class OrderRecord {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 操作时间
	 * default value: null
	 */
	@Column(name = "time", nullable = false)
	private Long time;

	/**
	 * 操作类型，0创建，1付款，2寄出样品，4确认收样，5订单完成
	 * default value: null
	 */
	@Column(name = "type", nullable = false)
	private String type;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "order_id", nullable = false)
	private Integer orderId;
}
