package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 疫苗记录
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "vacc_record")
public class VaccRecord {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 日龄
	 * default value: null
	 */
	@Column(name = "age", nullable = true)
	private String age;

	/**
	 * 疫苗种类
	 * default value: null
	 */
	@Column(name = "vacc_type", nullable = true)
	private String vaccType;

	/**
	 * 厂商
	 * default value: null
	 */
	@Column(name = "manufacturer", nullable = true)
	private String manufacturer;

	/**
	 * 关联订单
	 * default value: null
	 */
	@Column(name = "order_id", nullable = true)
	private Integer orderId;

	/**
	 * 1正常
	 * default value: 1
	 */
	@Column(name = "status", nullable = true)
	private Integer status;

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
}
