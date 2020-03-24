package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{


    /**
     * 最近六条未读未删除的消息
     * @param userId
     * @return
     */
    @Query(value = " select `order`.buyer_id as buyer, `order`.order_sn, notice.id, notice.create_time, notice.if_new, notice.order_id,notice.`status`, notice.type " +
            " from user " +
            " LEFT JOIN laboratory on `user`.id=laboratory.user_id " +
            " LEFT JOIN `order` ON laboratory.id=`order`.laboratory_id " +
            " LEFT JOIN notice on `order`.id=notice.order_id  " +
            " where user.id=?1 and notice.`status`=1 and notice.if_new=0 and notice.id is not NULL " +
            " ORDER BY notice.create_time DESC" +
            " LIMIT 6", nativeQuery = true)
    List<Map<String, Object>> selectLastSixNotice(Integer userId);

    @Query(value = " select `order`.buyer_id as buyer, `order`.order_sn, notice.id, notice.create_time, notice.if_new, notice.order_id, notice.`status`, notice.type " +
            " from `user` " +
            " LEFT JOIN laboratory on `user`.id=laboratory.user_id " +
            " LEFT JOIN `order` ON laboratory.id=`order`.laboratory_id " +
            " LEFT JOIN notice on `order`.id=notice.order_id " +
            " where user.id=?1 and notice.`status`=1 and notice.id is not NULL " +
            " ORDER BY notice.create_time DESC", nativeQuery = true)
    Page<Map<String, Object>> findPageByUserId(Integer userId, Pageable pageable);

    @Query(value = "select * from `notice` where id in (:ids)", nativeQuery = true)
    List<Notice> selectByIds(List<Integer> ids);
}
