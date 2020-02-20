package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 微信小程序用户信息表
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "mobile_user")
public class MobileUser {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 微信的用户唯一标识
	 * default value: null
	 */
	@Column(name = "openid", nullable = true)
	private String openid;

	/**
	 * 微信名
	 * default value: null
	 */
	@Column(name = "wechat", nullable = true)
	private String wechat;

	/**
	 * 微信昵称
	 * default value: null
	 */
	@Column(name = "nickname", nullable = true)
	private String nickname;

	/**
	 * 姓名
	 * default value: null
	 */
	@Column(name = "name", nullable = true)
	private String name;

	/**
	 * 电话
	 * default value: null
	 */
	@Column(name = "phone", nullable = true)
	private String phone;

	/**
	 * 公司
	 * default value: null
	 */
	@Column(name = "company", nullable = true)
	private String company;

	/**
	 * 所在区域
	 * default value: null
	 */
	@Column(name = "location", nullable = true)
	private String location;

	/**
	 * 详细地址
	 * default value: null
	 */
	@Column(name = "address", nullable = true)
	private String address;

	/**
	 * 纳税人识别号
	 * default value: null
	 */
	@Column(name = "taxpayer_identity_num", nullable = true)
	private String taxpayerIdentityNum;

	/**
	 * 创建时间
	 * default value: null
	 */
	@Column(name = "create_time", nullable = true)
	private Long createTime;

	/**
	 * 更新时间
	 * default value: null
	 */
	@Column(name = "update_time", nullable = true)
	private Long updateTime;

	/**
	 * ‘0’删除，‘1’正常
	 * default value: null
	 */
	@Column(name = "status", nullable = true)
	private String status;
}
