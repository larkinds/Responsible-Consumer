package smith.larkin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UDetailsService uDetailsService;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uDetailsService);
	}
	
	
	//specifies what type of user has access to which pages
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("httpSecurity auth");
		http
		.authorizeRequests()
		.antMatchers("/savedcomparisons", "/edituser").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin.html").hasRole("ADMIN")
		
		.and()
		.formLogin().loginPage("/login").loginProcessingUrl("/login/authenticate")
		.failureUrl("/login?error=true").defaultSuccessUrl("/").usernameParameter("username")
		.passwordParameter("uPassword")
		
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}
	
	
	//provide access to the the password encoding functionality, from BCrypt
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(this.passwordEncoder());
		daoAuthProvider.setUserDetailsService(this.uDetailsService);
		return daoAuthProvider;
	}
	
}
