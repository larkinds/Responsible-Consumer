package smith.larkin.CaseStudySB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import smith.larkin.models.ParentCompany;
import smith.larkin.service.ParentCompanyService;

@SpringBootTest
class ParentCompanyServiceTest {
	ParentCompanyService psc;
	
	@BeforeEach
	void beforeEach() {
		psc = new ParentCompanyService();
	}

	
	void findBypcName() {
		ParentCompany pc = psc.findBypcName("testParent");
		assertEquals(6, pc.getHuman_rights());
	}
	
	void findById() {
		Long id = (long) 1;
		ParentCompany pc = psc.findById(id);
		assertEquals("testParent", pc.getPcName());
	}
}