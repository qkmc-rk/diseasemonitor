package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Report;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query(value = "SELECT report.url FROM report WHERE report.order_id = ?1 AND report.`status` = 1",
            nativeQuery = true)
    List<String> findAllReportUrlByOrderId(Integer id);

    /**
     * 通过url寻找report
     * @param url
     * @return
     */
    Optional<Report> findByUrl(String url);
}
