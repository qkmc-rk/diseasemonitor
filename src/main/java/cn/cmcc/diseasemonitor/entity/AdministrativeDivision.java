package cn.cmcc.diseasemonitor.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@DynamicInsert
@Table(name = "administrative_division")
public class AdministrativeDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //行政区划代码
    private String code;

    // 行政区划级别，1-国级，2-省级（省份、直辖市、自治区），3-地级（市），4-县级（区县），5-乡级（乡镇、街道）
    private Integer level;

    // 行政区划名称
    private String name;

    // 父级行政区划代码
    @Column(name = "parent_code")
    private String parentCode;

    // 不足6位的，在后面补0，主要是为了重构过程中，兼容之前的老数据，后面会废弃掉这个属性
    @Column(name = "complete_code")
    private String completeCode;


}
