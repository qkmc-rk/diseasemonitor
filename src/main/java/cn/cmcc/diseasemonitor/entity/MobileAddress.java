package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 微信小程序用户的地址
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "mobile_address")
public class MobileAddress {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 收件人姓名
	 * default value: null
	 */
	@Column(name = "name", nullable = true)
	private String name;

	/**
	 * 手机号
	 * default value: null
	 */
	@Column(name = "phone", nullable = true)
	private String phone;

	/**
	 * 所在地区
	 * default value: null
	 */
	@Column(name = "location", nullable = true)
	private String location;

	/**
	 * 创建人
	 * default value: null
	 */
	@Column(name = "user_id", nullable = true)
	private Integer userId;

	/**
	 * 详细地址
	 * default value: null
	 */
	@Column(name = "address", nullable = true)
	private String address;

	/**
	 * '1'正常，'0'删除
	 * default value: null
	 */
	@Column(name = "status", nullable = true)
	private String status;
}
