package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
