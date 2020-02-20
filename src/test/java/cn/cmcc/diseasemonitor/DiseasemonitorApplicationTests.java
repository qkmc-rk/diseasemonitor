package cn.cmcc.diseasemonitor;

import cn.cmcc.diseasemonitor.repository.CollectionRepository;
import cn.cmcc.diseasemonitor.service.CollectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiseasemonitorApplicationTests {

	@Autowired
	CollectionRepository collectionRepository;

	@Test
	void contextLoads() {
		System.out.println(collectionRepository.findAll());
	}

}
