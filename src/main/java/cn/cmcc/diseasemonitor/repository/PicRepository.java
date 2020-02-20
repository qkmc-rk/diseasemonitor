package cn.cmcc.diseasemonitor.repository;

import cn.cmcc.diseasemonitor.entity.Pic;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PicRepository extends JpaRepository<Pic, Integer>{

}
