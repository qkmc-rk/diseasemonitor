package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.VaccRecord;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VaccRecordRepository extends JpaRepository<VaccRecord, Integer>{

}
