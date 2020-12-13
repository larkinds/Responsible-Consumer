package smith.larkin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smith.larkin.models.User;
import smith.larkin.models.UserSavedComparison;

@Repository
public interface UserSavedComparisonInterface extends JpaRepository<UserSavedComparison, Long> {
	//find ALL by user ID, saved into a List
	List <UserSavedComparison> findByOwnerUserId(User user);
	
	UserSavedComparison findByCompany1(String cName);
	
	void deleteByComparisonId(Long comparisonId);
	
	//method that returns a specific UserSavedComparison
//	UserSavedComparison findByOwnerUserIdAndComparisonId(Long ownerUserId, Long comparisonId);
}
