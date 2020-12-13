package smith.larkin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smith.larkin.dao.CompanyInterface;
import smith.larkin.models.Company;

@Service
public class CompanyService {
	@Autowired
	CompanyInterface companyRepo;
	
	public void save(Company company) {
		companyRepo.save(company);
	}
	
	public Optional<Company> findById (Long cId) {
		if (companyRepo.existsById(cId)) {
			return companyRepo.findById(cId);
		} else {
			return null;
		}
	}
	
	public Company findBycName(String cName) {
		return companyRepo.findBycName(cName);
	}
	
	public Company findByParentCompanyName(String parentCompanyName) {
		return companyRepo.findByParentCompanyName(parentCompanyName);
	}
	
	
}