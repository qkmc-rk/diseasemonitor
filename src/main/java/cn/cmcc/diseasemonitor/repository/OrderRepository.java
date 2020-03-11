package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

    @Query(value = "SELECT `mobile_user`.`wechat`,`mobile_user`.`nickname`,`order`.`sample_ids`," +
            "`mobile_user`.`phone`,`order`.`order_sn`,`order`.`id`,`order`.payable,`order`.`status`," +
            "`mobile_user`.`company`,`mobile_user`.province,`mobile_user`.city,`mobile_user`.district," +
            "`mobile_user`.address,`mobile_user`.`name`,`order`.instruction,`order`.`laboratory_id`," +
            "`order`.`pay_type`, `order`.logistics_num AS logistics_sn " +
            "FROM `order` JOIN `mobile_user` on `order`.order_sn = ?1 AND `order`.buyer_id = `mobile_user`.id",
            nativeQuery = true)
    Optional<Map<String, Object>> findOrderInfoByOrderSn(String sn);

    Optional<Order> findByOrderSn(String sn);

    @Query(value = "SELECT " +
            "`order`.order_sn, " +
            "mobile_user.phone, " +
            "`order`.logistics_num AS logistics_sn, " +
            "`order`.payable, " +
            "mobile_user.company, " +
            "`order`.create_time, " +
            "`order`.`status`  " +
            "FROM " +
            "`order` " +
            "JOIN mobile_user ON `order`.buyer_id = mobile_user.id  " +
            "WHERE " +
            "`order`.laboratory_id = ?1  " +
            "AND ( `order`.`status` = ?2 OR ?2 IS NULL )  " +
            "AND ( `order`.order_sn = ?3 OR ?3 IS NULL )  " +
            "AND ( `order`.logistics_num = ?4 OR ?4 IS NULL )  " +
            "AND ( `order`.payable = ?5 OR ?5 IS NULL )  " +
            "AND ( `order`.create_time BETWEEN ?6 AND ?7 OR ?6 IS NULL OR ?7 IS NULL )  " +
            "AND ( mobile_user.phone = ?8 OR ?8 IS NULL )  " +
            "AND ( mobile_user.company = ?9 OR ?9 IS NULL) " +
            "",
            countQuery = "SELECT COUNT(*)" +
                    "FROM " +
                    "`order` " +
                    "JOIN mobile_user ON `order`.buyer_id = mobile_user.id  " +
                    "WHERE " +
                    "`order`.laboratory_id = ?1  " +
                    "AND ( `order`.`status` = ?2 OR ?2 IS NULL )  " +
                    "AND ( `order`.order_sn = ?3 OR ?3 IS NULL )  " +
                    "AND ( `order`.logistics_num = ?4 OR ?4 IS NULL )  " +
                    "AND ( `order`.payable = ?5 OR ?5 IS NULL )  " +
                    "AND ( `order`.create_time BETWEEN ?6 AND ?7 OR ?6 IS NULL OR ?7 IS NULL )  " +
                    "AND ( mobile_user.phone = ?8 OR ?8 IS NULL )  " +
                    "AND ( mobile_user.company = ?9 OR ?9 IS NULL)",
            nativeQuery = true)
    Page<Map<String, Object>> findByConditions(Integer labId, String status, String orderSn, String logisticsSn,
                                               Float payable, Long startTime, Long endTime,
                                               String phone, String company, Pageable pageable);

    /**
     * 找到是否进行过通知的订单信息
     * @param labId 实验室id
     * @param notified 是否被通知
     * @return
     */
    List<Order> findAllByLaboratoryIdAndNotified(Integer labId, Boolean notified);
}
