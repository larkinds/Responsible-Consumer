package smith.larkin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smith.larkin.models.Company;

@Repository
public interface CompanyInterface extends JpaRepository<Company, Long>  {
	
	Company findBycName(String cName);
	
	Company findByParentCompanyName(String parentCompanyName);
	
	//add method findByProductName -- this one is tricky!!
	
	//add filtering methods like findByLowestEnvironmentScore;
}
