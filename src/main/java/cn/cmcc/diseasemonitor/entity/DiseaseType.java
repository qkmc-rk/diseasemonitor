package cn.cmcc.diseasemonitor.entity;

import javax.persistence.*;

/**
 * 疾病类型
 */
@Entity
@Table(name = "disease_type")
public class DiseaseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 疾病名称
    private String name;

    // 状态  0 不可见, 1可见
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DiseaseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
