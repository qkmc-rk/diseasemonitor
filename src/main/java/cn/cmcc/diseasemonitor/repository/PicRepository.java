package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Pic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PicRepository extends JpaRepository<Pic, Integer> {

    @Query(value = "select url from  pic where id in ?1",
            nativeQuery = true)
    List<String> findPicsByIdIn(Collection collection);
}
