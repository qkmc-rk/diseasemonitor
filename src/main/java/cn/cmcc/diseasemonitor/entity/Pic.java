package cn.cmcc.diseasemonitor.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * 图片存储，存储图片的地址等信息
 */
@Entity
@Table(name = "pic")
@DynamicUpdate
@DynamicInsert
public class Pic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String url;

    @Column(name = "create_time")
    private long createTime;
    @Column(name = "update_time")
    private long updateTime;
    @Column(name = "upload_user")
    private Integer uploadUser;
    @Column(name = "upload_user_type")
    private String uploadUserType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(Integer uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getUploadUserType() {
        return uploadUserType;
    }

    public void setUploadUserType(String uploadUserType) {
        this.uploadUserType = uploadUserType;
    }

    @Override
    public String toString() {
        return "Pic{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", uploadUser=" + uploadUser +
                ", uploadUserType='" + uploadUserType + '\'' +
                '}';
    }
}
