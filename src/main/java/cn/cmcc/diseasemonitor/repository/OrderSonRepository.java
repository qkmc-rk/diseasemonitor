package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.OrderSon;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderSonRepository extends JpaRepository<OrderSon, Integer>{

}
