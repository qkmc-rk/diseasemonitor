package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

    @Query(value = "select user.user_name as userName, laboratory.phone, user.create_time as createTime" +
            " from user left join laboratory on user.id = laboratory.user_id where user.id = ?1",
            nativeQuery = true)
    Optional<Map<String, Object>> findUserInfoAndPhone(Integer id);
}
