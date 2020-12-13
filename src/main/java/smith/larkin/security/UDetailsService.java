package smith.larkin.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import smith.larkin.dao.UserRepoInterface;
import smith.larkin.models.User;

@Service
public class UDetailsService implements UserDetailsService {
	@Autowired
	private UserRepoInterface userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepo.findByUsername(email);
		UDetails userDetails = new UDetails(user);

		return userDetails;
	}
}
