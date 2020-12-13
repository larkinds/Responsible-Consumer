package smith.larkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smith.larkin.dao.ParentCompanyInterface;
import smith.larkin.models.ParentCompany;

@Service
public class ParentCompanyService {
	@Autowired
	ParentCompanyInterface parentCompanyRepo;
	
	public void save(ParentCompany pCompany) {
		parentCompanyRepo.save(pCompany);
	}
	
	public ParentCompany findBypcName(String pcName) {
		return parentCompanyRepo.findBypcName(pcName);
	}
	
	public ParentCompany findById(Long pcId) {
		return parentCompanyRepo.findBypcId(pcId);
	}
}
