package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.AdministrativeDivision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministrativeDivisionRepository extends JpaRepository<AdministrativeDivision, String> {

    /**
     * 通过等级找
     * @param level
     * @return
     */
    List<AdministrativeDivision> findAllByLevel(Integer level);

    /**
     * 通过父ID和level找
     * @param level
     * @param parentCode
     * @return
     */
    List<AdministrativeDivision> findAllByLevelAndParentCode(Integer level, String parentCode);


    /**
     * 通过parentId找
     * @param parentCode
     * @return
     */
    List<AdministrativeDivision> findAllByParentCode(String parentCode);

}
