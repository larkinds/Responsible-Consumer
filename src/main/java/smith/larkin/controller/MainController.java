package smith.larkin.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import smith.larkin.models.User;
import smith.larkin.service.UserService;



@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	

	@GetMapping("/")
	public String homePage(Model model) {
		return "public/index";
	}
	
	@GetMapping("/login")
	public String loginPage() {	
		return "public/login";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		User newUser = new User();
		model.addAttribute("newUser", newUser);
		return "public/register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User enteredUser, BindingResult result) {
		if (result.hasErrors()) {
			return "public/register";
		}
		
		//encrypting the password
		String toSalt = enteredUser.getuPassword();
		enteredUser.setuPassword(BCrypt.hashpw(toSalt, BCrypt.gensalt()));
		
		//hard-code status & role instead of allowing user to choose
		enteredUser.setStatus(1);
		enteredUser.setuRole("ROLE_USER");
		userService.save(enteredUser);
		
		return "redirect:login";
	}
	
	@GetMapping("/edituser")
	public String editUserPage(Model model, Principal principal) {
		User existingUser = userService.findByUsername(principal.getName());
		model.addAttribute("existingUser", existingUser);
		
		return "user/edit_user";
	}
	
	@PostMapping("editUser")
	public String editUser(@Valid @ModelAttribute("existingUser") User existingUser, BindingResult result) {
		if (result.hasErrors()) {
			return "public/register";
		}
		
		
		User userInDB = userService.findByUsername(existingUser.getUsername());
		
		
		existingUser.setuId(userInDB.getuId());
		existingUser.setuPassword(userInDB.getuPassword());
		existingUser.setStatus(1);
		existingUser.setuRole("ROLE_USER");
		
		userService.save(existingUser);
		return "/public/index";
	}
	
	
	@GetMapping("about")
	public String aboutPage() {
		return "/public/about";
	}
	
	@GetMapping("admin")
	public String adminPage() {
		return "/admin/admin";
	}
	
	
}
