package smith.larkin.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import smith.larkin.models.User;

public class UDetails implements UserDetails {	
	private User user;
	
	public UDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		this.user.getuRoles().forEach(role -> {
			GrantedAuthority authority = new SimpleGrantedAuthority(role);
			authorities.add(authority);
		});
		
		return authorities;
	}

	@Override
	public String getPassword() {
		System.out.println("UDetails password: " + this.user.getuPassword());
		return this.user.getuPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		//not in the scope of this project
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//not in the scope of this project
		return true;
		
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//not in the scope of this project
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
//		return (this.user.getStatus() == 1);
	}

}
