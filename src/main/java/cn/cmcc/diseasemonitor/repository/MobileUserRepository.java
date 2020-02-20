package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.MobileUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MobileUserRepository extends JpaRepository<MobileUser, Integer>{

}
