package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Report;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

}
