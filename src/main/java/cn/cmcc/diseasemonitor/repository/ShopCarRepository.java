package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.ShopCar;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ShopCarRepository extends JpaRepository<ShopCar, Integer>{

}
