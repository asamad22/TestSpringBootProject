package bd.com.dipti.testspring;

import bd.com.dipti.testspring.entity.Student;
import bd.com.dipti.testspring.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private Student s;

	@Autowired
	private StudentRepository sr;


}
