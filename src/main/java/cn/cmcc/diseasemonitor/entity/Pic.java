package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 图片
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "pic")
public class Pic {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 图片地址
	 * default value: null
	 */
	@Column(name = "url", nullable = true)
	private String url;

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
	 * null
	 * default value: null
	 */
	@Column(name = "upload_user", nullable = true)
	private Integer uploadUser;

	/**
	 * ‘0’为mobile端，‘1’为web端
	 * default value: null
	 */
	@Column(name = "upload_user_type", nullable = true)
	private String uploadUserType;
}
