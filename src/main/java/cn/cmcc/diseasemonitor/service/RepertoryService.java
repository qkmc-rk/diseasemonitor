package cn.cmcc.diseasemonitor.service;

import cn.cmcc.diseasemonitor.entity.Repertory;
import cn.cmcc.diseasemonitor.vo.TestItem;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface RepertoryService {
    /**
     * 找到所有上架的实验室检测项目
     *
     * @param token
     * @return
     */
    List<TestItem> findAllOnSaleServe(String token);

    List<TestItem> findAllOffSaleServe(String token);


    Page<Map<String, Object>> findAllOnSaleServe(String token, Integer pageNum, Integer pageSize);

    Page<Map<String, Object>> findAllOffSaleServe(String token, Integer pageNum, Integer pageSize);


    /**
     * 通过仓库id查找这个详细信息
     *
     * @param token
     * @param repertoryId
     * @return
     */
    TestItem findOneByRepertoryId(String token, Integer repertoryId);

    /**
     * 根据repertory
     *
     * @param repertoryId
     * @param price
     * @param inventory
     * @return
     */
    Repertory modifyPriceAndInventory(Integer repertoryId, Double price, Integer inventory);

    /**
     * 改变仓库的状态 上架 下架等操作
     *
     * @param repertoryId
     * @param s
     * @return
     */
    Repertory changeRepertoryStatus(Integer repertoryId, String s);

    String save(String token, Repertory repertory);
}
