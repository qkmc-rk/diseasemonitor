package cn.cmcc.diseasemonitor.vo;

import cn.cmcc.diseasemonitor.entity.Commodity;
import cn.cmcc.diseasemonitor.entity.DiseaseType;
import cn.cmcc.diseasemonitor.entity.Repertory;
import lombok.Data;

/**
 *
 * 检测项目
 * 每个库存item 包含疾病， commodity
 */
@Data
public class TestItem {
    /**
     * 仓库记录
     */
    private Repertory repertory;
    /**
     * 每条仓库记录有一个疾病类型
     */
    private DiseaseType diseaseType;
    /**
     * 每个仓库记录都有一个对应的商品信息
     */
    private Commodity commodity;
}
