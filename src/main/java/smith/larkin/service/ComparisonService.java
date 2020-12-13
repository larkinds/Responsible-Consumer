package smith.larkin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import smith.larkin.dao.UserSavedComparisonInterface;
import smith.larkin.models.User;
import smith.larkin.models.UserSavedComparison;

@Service
public class ComparisonService {
	@Autowired
	UserSavedComparisonInterface userSavedComparisonRep;
	
	public void save(UserSavedComparison userSavedComparison) {
		userSavedComparisonRep.save(userSavedComparison);
	}
	
	
	public List<UserSavedComparison> findByOwnerUserId(User user) {
		return userSavedComparisonRep.findByOwnerUserId(user);
	}
	
	public UserSavedComparison findByCompany1(String cName) {
		return userSavedComparisonRep.findByCompany1(cName);
	}
	
	@Transactional
	public void deleteByComparisonId(Long comparisonId) {
		userSavedComparisonRep.deleteByComparisonId(comparisonId);	
	}
	
	
	
}
