package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 商品仓库
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "repertory")
public class Repertory {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 实验室id
	 * default value: null
	 */
	@Column(name = "laboratory_id", nullable = true)
	private Integer laboratoryId;

	/**
	 * 商品名
	 * default value: null
	 */
	@Column(name = "disease_id", nullable = true)
	private Integer diseaseId;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "commodity_id", nullable = true)
	private Integer commodityId;

	/**
	 * 价格
	 * default value: null
	 */
	@Column(name = "price", nullable = true)
	private Double price;

	/**
	 * 存货
	 * default value: null
	 */
	@Column(name = "inventory", nullable = true)
	private Integer inventory;

	/**
	 * 创建时间
	 * default value: null
	 */
	@Column(name = "create_time", nullable = true)
	private Long createTime;

	/**
	 * 修改时间
	 * default value: null
	 */
	@Column(name = "update_time", nullable = true)
	private Long updateTime;

	/**
	 * 创建人
	 * default value: null
	 */
	@Column(name = "user_id", nullable = true)
	private Integer userId;

	/**
	 * ‘1’上架，‘0’下架
	 * default value: null
	 */
	@Column(name = "status", nullable = false)
	private String status;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "logo", nullable = true)
	private Integer logo;

	/**
	 * 标签
	 * default value: null
	 */
	@Column(name = "tag", nullable = true)
	private String tag;
}
