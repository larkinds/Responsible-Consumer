package smith.larkin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smith.larkin.models.ParentCompany;

@Repository
public interface ParentCompanyInterface extends JpaRepository<ParentCompany, Long> {
	ParentCompany findBypcName(String pcName);
	
	ParentCompany findBypcId(Long pcId);
}
