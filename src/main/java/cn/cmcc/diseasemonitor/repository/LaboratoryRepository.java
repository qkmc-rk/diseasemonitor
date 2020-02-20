package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer>{

}
