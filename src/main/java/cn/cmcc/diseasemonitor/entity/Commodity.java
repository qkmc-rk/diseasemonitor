package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 商品表
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "commodity")
public class Commodity {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 商品名
	 * default value: null
	 */
	@Column(name = "disease_id", nullable = true)
	private Integer diseaseId;

	/**
	 * 疫苗种类
	 * default value: null
	 */
	@Column(name = "name", nullable = true)
	private String name;

	/**
	 * 采样说明
	 * default value: null
	 */
	@Column(name = "sampling_instruction", nullable = true)
	private String samplingInstruction;

	/**
	 * 检测说明
	 * default value: null
	 */
	@Column(name = "deletection_instruction", nullable = true)
	private String deletectionInstruction;

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
	@Column(name = "status", nullable = true)
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

	/**
	 * 0一般商品，1套餐
	 * default value: null
	 */
	@Column(name = "type", nullable = true)
	private String type;
}
