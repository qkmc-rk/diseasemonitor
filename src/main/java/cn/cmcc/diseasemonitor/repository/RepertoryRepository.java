package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Repertory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface RepertoryRepository extends JpaRepository<Repertory, Integer> {

    /**
     * 找到所有repetory
     *
     * @param labId
     * @return
     */
    List<Repertory> findAllByLaboratoryId(Integer labId);

    /**
     * 根据实验室Id和商品状态 返回实验室商品列表
     *
     * @param id
     * @param status
     * @param pageable
     * @return
     */
    @Query(value = "SELECT " +
            "repertory.id, " +
            "commodity.`name` AS commodityName, " +
            "disease_type.`name` AS disaseName, " +
            "repertory.price, " +
            "repertory.inventory, " +
            "repertory.update_time AS updateTime  " +
            "FROM " +
            "repertory " +
            "JOIN commodity ON repertory.laboratory_id = ?1 " +
            "AND repertory.`status` = ?2  " +
            "AND repertory.commodity_id = commodity.id " +
            "JOIN disease_type ON disease_type.id = repertory.disease_id",
            countQuery = "SELECT " +
                    "COUNT(*) " +
                    "FROM " +
                    "repertory " +
                    "JOIN commodity ON repertory.laboratory_id = ?1 " +
                    "AND repertory.`status` = ?2  " +
                    "AND repertory.commodity_id = commodity.id " +
                    "JOIN disease_type ON disease_type.id = repertory.disease_id",
            nativeQuery = true)
    Page<Map<String, Object>> findAllByLaboratoryIdAndRepertoryStatus(Integer id, String status, Pageable pageable);
}
