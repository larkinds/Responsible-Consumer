package smith.larkin.CaseStudySB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import smith.larkin.models.Company;
import smith.larkin.service.CompanyService;
	
@SpringBootTest
class CompanyServiceTest {
	@Autowired
	private CompanyService cs;

	
	
	@Test
	void findById() {
		Long id = (long) 1;
		Optional<Company> c = cs.findById(id);
		System.out.println("MEOW");
		System.out.println(c.get().getcName());
		assertEquals("test", c.get().getcName());
	}
	
	@Test
	public void findBycName() {
		Company c = cs.findBycName("test");
		Assertions.assertEquals("testParent", c.getParentCompanyName());
	}
	
	@Test
	void findByParentCompanyName() {
		Company c = cs.findByParentCompanyName("testParent");
		assertEquals("test", c.getcName());
	}

}
