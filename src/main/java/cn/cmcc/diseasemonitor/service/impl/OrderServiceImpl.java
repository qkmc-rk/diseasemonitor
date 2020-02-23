package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Laboratory;
import cn.cmcc.diseasemonitor.entity.User;
import cn.cmcc.diseasemonitor.service.LaboratoryService;
import cn.cmcc.diseasemonitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Order;
import cn.cmcc.diseasemonitor.service.OrderService;
import cn.cmcc.diseasemonitor.repository.OrderRepository;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository resp;

    @Autowired
    UserService userService;

    @Autowired
    LaboratoryService laboratoryService;

    @Override
    public Page<Order> findAllByTimeAndStatus(Long startTime, Long endTime, String status,
                                              Integer pageNum, Integer pageSize, String token) {
        Optional<Integer> userIdOpt = userService.findUserIdByToken(token);
        // 如果token有效 查询用户是否有实验室 代码太长 用lambda看的头晕
        if (userIdOpt.isPresent()) {
            Optional<Laboratory> laboratoryOpt = laboratoryService.findByUserId(userIdOpt.get());
            // 有实验室 开始条件筛选
            if (laboratoryOpt.isPresent()) {
                // 先拿到实验Id
                Integer labId = laboratoryOpt.get().getId();
                // 设置分页信息
                Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "createTime");
                // 设置查询条件
                Specification<Order> specification = new Specification<Order>() {
                    @Override
                    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Path<Integer> labIdPath = root.get("laboratoryId");
                        // 匹配实验室ID
                        Predicate predicate = criteriaBuilder.equal(labIdPath, labId);

                        /* 筛选时间段 */
                        if (startTime != null && endTime != null) {
                            Path<Long> createTimePath = root.get("createTime");
                            Predicate createTimeBetween = criteriaBuilder.between(createTimePath, startTime, endTime);
                            predicate = criteriaBuilder.and(predicate, createTimeBetween);
                        }

                        /* 筛选订单状态 */
                        if (status != null && !status.isEmpty()) {
                            Path<String> statusPath = root.get("status");
                            Predicate statusEq = criteriaBuilder.equal(statusPath, status);
                            predicate = criteriaBuilder.and(predicate, statusEq);
                        }
                        return criteriaBuilder.and(predicate);
                    }
                };
                return resp.findAll(specification, pageable);
            } else {
                // 没有实验室 拜拜
                return null;
            }
        } else {
            // token无效 白白
            return null;
        }
    }
}
