package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import io.lettuce.core.GeoArgs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer>, JpaSpecificationExecutor<Laboratory> {
    Optional<Laboratory> findByUserId(Integer id);
}
