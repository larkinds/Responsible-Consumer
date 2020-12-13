package smith.larkin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smith.larkin.models.User;

@Repository
public interface UserRepoInterface extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
