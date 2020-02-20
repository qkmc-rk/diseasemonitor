package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.MobileAddress;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MobileAddressRepository extends JpaRepository<MobileAddress, Integer>{

}
