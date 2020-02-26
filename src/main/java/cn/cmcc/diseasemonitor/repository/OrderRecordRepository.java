package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.OrderRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Integer> {
    List<OrderRecord> findAllByOrderId(Integer id);
}
