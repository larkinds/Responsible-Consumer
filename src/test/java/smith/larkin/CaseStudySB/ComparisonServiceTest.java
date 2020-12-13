package smith.larkin.CaseStudySB;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import smith.larkin.models.User;
import smith.larkin.models.UserSavedComparison;
import smith.larkin.service.ComparisonService;
import smith.larkin.service.UserService;

@SpringBootTest
class ComparisonServiceTest {
	@Autowired
	ComparisonService cs;
	
	@Autowired
	UserService us;
    
//	@Test
//	void findByOwnerId() {
//		User user = us.findByUsername("testUser@gmail.com");
//		List <UserSavedComparison> usc = cs.findByOwnerUserId(user);
//		
//		//tomorrow, save 2 comparisons to test@gmail.com's savedComparisons
//		assertTrue(usc.size() == 3);
//	}
//	
//	@Test
//	void findBycName() {
//		UserSavedComparison usc = cs.findByCompany1("test");
//		assertTrue("test".equals(usc.getCompany1()));
//	}
	
	
	@Test
	void deleteByComparisonId() {
		Long compId = (long) 2;
		System.out.println(compId);
		cs.deleteByComparisonId(compId);
		assertFalse(cs.findByCompany1("test") != null);
	}
}



