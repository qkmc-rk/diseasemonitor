package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Integer> {
    Optional<Laboratory> findByUserId(Integer id);

    /**
     * 通过status和userId找到
     * @param userId
     * @param status
     * @return
     */
    Optional<Laboratory> findTopByUserIdAndStatus(Integer userId, String status);
}
