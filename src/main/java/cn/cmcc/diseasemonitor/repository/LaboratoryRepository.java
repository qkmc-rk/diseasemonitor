package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {
    Optional<Laboratory> findByUserId(Integer id);
}
