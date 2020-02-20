package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.DiseaseType;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DiseaseTypeRepository extends JpaRepository<DiseaseType, Integer>{

}
