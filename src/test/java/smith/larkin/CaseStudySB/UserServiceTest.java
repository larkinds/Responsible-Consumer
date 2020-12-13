package smith.larkin.CaseStudySB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import smith.larkin.models.User;
import smith.larkin.service.UserService;

@SpringBootTest
class UserServiceTest {
	@Autowired
	UserService us;

	
	@Test
	void findByUsername() {
		User userFromDatabase = us.findByUsername("testUser@gmail.com");
		Long uId = userFromDatabase.getuId();
		assertTrue(userFromDatabase.getFirstName().equals("test"));
	}
	
	@Test
	void findByID() {
		Long uId = (long) 2;
		User userFromDatabase = us.findByID(uId);
		assertEquals("test", userFromDatabase.getFirstName());
	}
}
