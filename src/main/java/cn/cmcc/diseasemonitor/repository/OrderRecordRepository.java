package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.OrderRecord;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Integer>{

}
