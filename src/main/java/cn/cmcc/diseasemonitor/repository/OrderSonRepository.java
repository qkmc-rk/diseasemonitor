package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.OrderSon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface OrderSonRepository extends JpaRepository<OrderSon, Integer> {

    @Query(value = "SELECT commodity.`name`,repertory.price,order_son.count,order_son.payable " +
            "FROM order_son JOIN commodity ON order_son.order_id = ?1 AND order_son.commodity_id = commodity.id " +
            "JOIN repertory ON order_son.repertory_id = repertory.id",
            nativeQuery = true)
    List<Map<String, Object>> findOrderSonListByOrderId(Integer id);


}
