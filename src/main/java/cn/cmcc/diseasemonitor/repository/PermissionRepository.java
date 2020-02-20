package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Permission;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
