package cn.cmcc.diseasemonitor.entity;

import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 权限表
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "permission")
public class Permission {

	/**
	 * null
	 * default value: null
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * url地址
	 * default value: null
	 */
	@Column(name = "url", nullable = false)
	private String url;

	/**
	 * 权限
	 * default value: null
	 */
	@Column(name = "permission", nullable = false)
	private String permission;

	/**
	 * 权限名
	 * default value: null
	 */
	@Column(name = "name", nullable = true)
	private String name;
}
