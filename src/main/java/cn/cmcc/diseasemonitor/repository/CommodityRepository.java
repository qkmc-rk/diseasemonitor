package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Commodity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer>{

}
