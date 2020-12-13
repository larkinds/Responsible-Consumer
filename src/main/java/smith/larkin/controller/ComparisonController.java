package smith.larkin.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import smith.larkin.dao.UserSavedComparisonInterface;
import smith.larkin.exceptions.CompanyNotFoundException;
import smith.larkin.models.Company;
import smith.larkin.models.ParentCompany;
import smith.larkin.models.User;
import smith.larkin.models.UserSavedComparison;
import smith.larkin.service.CompanyService;
import smith.larkin.service.ComparisonService;
import smith.larkin.service.ParentCompanyService;
import smith.larkin.service.UserService;

@Controller
public class ComparisonController {
	@Autowired
	UserService userService;
	
	@Autowired
	ParentCompanyService parentCompanyService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ComparisonService comparisonService;
	
	//for checking if a company is already in the database
	boolean found = false;
	
	@GetMapping("/search")
	public String search() {
		return "public/search";
	}
	
	@Autowired
	UserSavedComparisonInterface savedComparisonRepo;

	@GetMapping("/searchresults")
	public String searchPage(@Param("companySearch") String companySearch, Model model) throws CompanyNotFoundException {
		try {
			// first, search for matching company
			Company c = companyService.findBycName(companySearch);
			
			//pre-load search for parent company that matches the search string passed in
			ParentCompany pc = parentCompanyService.findBypcName(companySearch);
			
			if (c != null) {
				// if matching company, search parent table using the parent field
				// return information about company & parent company
				pc = parentCompanyService.findBypcName(c.getParentCompanyName());
				model.addAttribute("company", c);
				model.addAttribute("parentCompany", pc); 
				model.addAttribute("results", "both");
			} else {
				throw new CompanyNotFoundException("That company does not exist in the database");
			}
			
		} catch (CompanyNotFoundException error) {
			model.addAttribute("results", "nothing");
		}

		return "/public/search_results";
	}
	

	@PostMapping("/searchresults")
	public String addComparison(@ModelAttribute("company") Company companyName, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		
		List<UserSavedComparison> savedComparisons =  savedComparisonRepo.findByOwnerUserId(user);
		
		
		//check if the company the user searched for is already in the database
		savedComparisons.forEach(comparison -> {
			if (comparison.getCompany1().equals(companyName.getcName())) {
				found = true;
			}
		});
		
		//if company is already in the database, reset the boolean and send user to their savedComparisons
		if (found) {
			found = false;
			return "redirect:savedComparisons";
		}
		
		
		
		UserSavedComparison savedComparison = new UserSavedComparison();
		
		savedComparison.setCompany1(companyName.getcName());
		savedComparison.setOwnerUserId(user);
		
		comparisonService.save(savedComparison);
		
		
		return "redirect:savedComparisons";
	}
	
	
	@GetMapping("/savedComparisons")
	public String savedComparisons(Principal principal, Model model) {
		System.out.println("---------in saved comparisons mapping---------");
		User user = userService.findByUsername(principal.getName());

		List<UserSavedComparison> savedComparisons =  savedComparisonRepo.findByOwnerUserId(user);
		
		//declare an LinkedHashMap to save company objects & parentCompany objects into
		LinkedHashMap<Company, ParentCompany> comparisonMap = new LinkedHashMap<Company, ParentCompany>();
		
		savedComparisons.forEach(comparison -> {
			System.out.println("_____________forEach in savedComparison Handler Method_____________");
			
			//get the company in the saved comparison
			Company c1 = companyService.findBycName(comparison.getCompany1());
			//get the corresponding parentCompany 
			ParentCompany p1 = parentCompanyService.findBypcName(c1.getParentCompanyName());
			comparisonMap.put(c1, p1);
		});
		
		model.addAttribute("comparisonMap", comparisonMap);

		
		return "/user/saved_comparisons";
	}
	
	@PostMapping("/deleteComparison")
	public String deleteComparison(@RequestParam("cName") String cName, Principal principal, Model model) {
		System.out.println("MEOW MEOW MEOW MEOW MEOW MEOW MEOW");
		System.out.println("cName from delete button: " + cName);
		UserSavedComparison comparisonToDelete = comparisonService.findByCompany1(cName);
		Long comparisonId = comparisonToDelete.getComparisonId();
		System.out.println("comparisonId from delete button: " + comparisonId);
		comparisonService.deleteByComparisonId(comparisonId);
		
		System.out.println("22222222222 in saved comparisons mapping 2222222222");
		User user = userService.findByUsername(principal.getName());

		List<UserSavedComparison> savedComparisons =  savedComparisonRepo.findByOwnerUserId(user);
		
		//declare an LinkedHashMap to save company objects & parentCompany objects into
		LinkedHashMap<Company, ParentCompany> comparisonMap = new LinkedHashMap<Company, ParentCompany>();
		
		savedComparisons.forEach(comparison -> {
			System.out.println("_____________forEach in savedComparison Handler Method_____________");
			
			//get the company in the saved comparison
			Company c1 = companyService.findBycName(comparison.getCompany1());
			//get the corresponding parentCompany 
			ParentCompany p1 = parentCompanyService.findBypcName(c1.getParentCompanyName());
			comparisonMap.put(c1, p1);
		});
		
		model.addAttribute("comparisonMap", comparisonMap);
		
		
		return "/user/saved_comparisons";
	}
	
	

}
