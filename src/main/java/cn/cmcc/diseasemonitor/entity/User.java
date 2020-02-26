package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 用户
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class User {

	/**
	 * 主键
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@JoinColumn(name = "id",referencedColumnName = "user_id")
	private Integer id;

	/**
	 * 用户名
	 * default value: null
	 */
	@Column(name = "user_name", nullable = false)
	private String userName;

	/**
	 * 密码
	 * default value: null
	 */
	@Column(name = "passwd", nullable = false)
	private String passwd;

	/**
	 * 创建时间
	 * default value: null
	 */
	@Column(name = "create_time", nullable = false)
	private Long createTime;

	/**
	 * 是否有效 1：有效  0：锁定
	 * default value: null
	 */
	@Column(name = "status", nullable = false)
	private String status;
	@Column(name = "phone", nullable = true)
	private String phone;
	@Column(name = "nickname", nullable = true)
	private String nickname;
	@Column(name = "mail", nullable = true)
	private String mail;
}
