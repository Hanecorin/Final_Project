package pdt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pdt.dao.PostRepository;
import pdt.service.PostServiceImp;

@SpringBootTest
class PdtProjectApplicationTests {

	@Autowired
	PostServiceImp postService;

	@Autowired
	PostRepository postRepository;

	@Test
	void contextLoads() {
		

	}

}
