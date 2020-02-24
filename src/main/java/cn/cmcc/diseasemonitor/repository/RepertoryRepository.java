package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Repertory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface RepertoryRepository extends JpaRepository<Repertory, Integer>{

    /**
     *  找到所有repetory
     * @param labId
     * @return
     */
    List<Repertory> findAllByLaboratoryId(Integer labId);

}
