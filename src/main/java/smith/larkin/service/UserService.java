package smith.larkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smith.larkin.dao.UserRepoInterface;
import smith.larkin.models.User;

@Service
public class UserService {

	@Autowired
	UserRepoInterface userRepo;
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public User findByID(Long id) {
		return userRepo.findById(id).get();
	}
	
	
	public User findByUsername(String email) {
		return userRepo.findByUsername(email);
	}
}
