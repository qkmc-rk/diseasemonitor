package cn.cmcc.diseasemonitor.service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderSonService {

    /**
     * 查询订单的所包含的产品
     *
     * @param id :
     * @return: java.util.Optional<java.util.List < cn.cmcc.diseasemonitor.entity.OrderSon>>
     */
    List<Map<String, Object>> findAllByOrderId(Integer id);
}
