package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.UserRole;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

}
