package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Commodity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    @Query(value = "SELECT " +
            "commodity.id, " +
            "commodity.`name`, " +
            "commodity.sampling_instruction, " +
            "commodity.deletection_instruction, " +
            "commodity.tag, " +
            "commodity.type, " +
            "pic.url AS logo, " +
            "disease_type.`name` AS disease  " +
            "FROM " +
            "commodity " +
            "JOIN disease_type ON commodity.disease_id = disease_type.id " +
            "JOIN pic ON commodity.logo = pic.id",
            nativeQuery = true)
    List<Map<String, Object>> findCommodities();
}
