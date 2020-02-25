package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

    Order findByLogisticsNumAndLaboratoryId(String sn, Integer id);

    Order findByOrderSnAndLaboratoryId(String sn, Integer id);

    @Query(value = "SELECT `mobile_user`.`wechat`,`mobile_user`.`nickname`,`order`.`sample_ids`," +
            "`mobile_user`.`phone`,`order`.`order_sn`,`order`.`id`,`order`.payable,`order`.`status`," +
            "`mobile_user`.`company`,`mobile_user`.province,mobile_user.city,mobile_user.district," +
            "mobile_user.address,mobile_user.`name`,`order`.report,`order`.`laboratory_id`,`order`.`pay_type` " +
            "FROM `order` JOIN mobile_user on `order`.order_sn = ?1 AND `order`.buyer_id = mobile_user.id",
            nativeQuery = true)
    Optional<Map<String, Object>> findOrderInfoByOrderSn(String sn);

    Optional<Order> findByOrderSn(String sn);
}
