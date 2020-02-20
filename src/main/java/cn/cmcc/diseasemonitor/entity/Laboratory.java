package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 实验室信息
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "laboratory")
public class Laboratory {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 实验室
	 * default value: null
	 */
	@Column(name = "laboratory", nullable = false)
	private String laboratory;

	/**
	 * 归属公司
	 * default value: null
	 */
	@Column(name = "company", nullable = false)
	private String company;

	/**
	 * 区域
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
	 * 联系电话
	 * default value: null
	 */
	@Column(name = "contact_num", nullable = true)
	private String contactNum;

	/**
	 * 简介
	 * default value: null
	 */
	@Column(name = "intro", nullable = true)
	private String intro;

	/**
	 * 实验室logo
	 * default value: null
	 */
	@Column(name = "logo", nullable = true)
	private Integer logo;

	/**
	 * 营业执照
	 * default value: null
	 */
	@Column(name = "business_license", nullable = true)
	private Integer businessLicense;

	/**
	 * 收货人
	 * default value: null
	 */
	@Column(name = "receiver", nullable = true)
	private String receiver;

	/**
	 * 收件人地址
	 * default value: null
	 */
	@Column(name = "receiver_address", nullable = true)
	private String receiverAddress;

	/**
	 * 收件人手机号
	 * default value: null
	 */
	@Column(name = "phone", nullable = true)
	private String phone;

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
	 * 1正常，0删除
	 * default value: null
	 */
	@Column(name = "status", nullable = true)
	private String status;

	/**
	 * 省
	 * default value: null
	 */
	@Column(name = "province", nullable = true)
	private String province;

	/**
	 * 市
	 * default value: null
	 */
	@Column(name = "city", nullable = true)
	private String city;

	/**
	 * 区
	 * default value: null
	 */
	@Column(name = "district", nullable = true)
	private String district;

	/**
	 * 经纬度
	 * default value: null
	 */
	@Column(name = "longitude_and_latitude", nullable = true)
	private String longitudeAndLatitude;

	/**
	 * null
	 * default value: null
	 */
	@Column(name = "tag", nullable = true)
	private String tag;
}
