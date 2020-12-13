//package smith.larkin.future;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import smith.larkin.dao.UserSavedComparisonInterface;
//import smith.larkin.models.Company;
//import smith.larkin.models.ParentCompany;
//import smith.larkin.models.User;
//import smith.larkin.models.UserSavedComparison;
//import smith.larkin.service.CompanyService;
//import smith.larkin.service.ComparisonService;
//import smith.larkin.service.ParentCompanyService;
//import smith.larkin.service.UserService;
//
//@Controller
//public class ComparisonControllerFuture {
//	private Integer companyNumber = 0;
//	
//	@Autowired
//	UserService userService;
//	
//	@Autowired
//	ParentCompanyService parentCompanyService;
//	
//	@Autowired
//	CompanyService companyService;
//	
//	@Autowired
//	ComparisonService comparisonService;
//	
//	@GetMapping("/search")
//	public String search() {
//		return "public/search";
//	}
//	
//	@Autowired
//	UserSavedComparisonInterface savedComparisonRepo;
//
//	@GetMapping("/searchresults")
//	public String searchPage(@Param("companySearch") String companySearch, Model meow) {
//		// first, search for matching company
//		Company c = companyService.findBycName(companySearch);
//		//pre-load search for parent company that matches the search string passed in
//		ParentCompany pc = parentCompanyService.findBypcName(companySearch);
//		
//		// if company was found, find the parent company
//		if (c != null) {
//			// if matching company, search parent table using the parent field
//			// return information about company & parent company
//			pc = parentCompanyService.findBypcName(c.getParentCompanyName());
//			meow.addAttribute("company", c);
//			meow.addAttribute("parentCompany", pc); 
//			meow.addAttribute("results", "both");
//		} else if (pc != null) {                                    
//			// if no matching company, search parent table (this search is done prematurely on line 42)
//			// return information about company & parent company
//			meow.addAttribute("parentCompany", pc);
//			meow.addAttribute("results", "parentOnly");
//		} else {
//			// if no matching parent company, set an error attribute
//			meow.addAttribute("results", "nothing");
//		}
//
//		return "/public/searchresults";
//		
//	}
//	
//
//	@GetMapping("/savedComparisons")
//	public String savedComparisons(Principal principal, Model model) {
//		System.out.println("---------in saved comparisons mapping---------");
//		User user = userService.findByUsername(principal.getName());
//		System.out.println(user.getUsername());
//
//		List<UserSavedComparison> savedComparisons =  savedComparisonRepo.findByOwnerUserId(user);
//		
//		ArrayList<ArrayList<Company>> savedCompanyComparisonsList = new ArrayList<ArrayList<Company>>();
//		ArrayList<ArrayList<ParentCompany>> savedParentCompanyComparisonsList = new ArrayList<ArrayList<ParentCompany>>();
//		LinkedHashMap<Integer, LinkedHashMap<Company, ParentCompany>> outerCompanyMap = new LinkedHashMap<Integer, LinkedHashMap<Company, ParentCompany>>();
//		
//		
//		savedComparisons.forEach(comparison -> {
//			System.out.println("_____________forEach in savedComparison Handler Method_____________");
//			//declare an arraylist to save company objects into & an arraylist to save parentCompany objects into
//			ArrayList <Company> companyList = new ArrayList<Company>();
//			ArrayList<ParentCompany> parentCompanyList = new ArrayList<ParentCompany>();
//			LinkedHashMap<Company, ParentCompany> innerCompanyMap = new LinkedHashMap<Company, ParentCompany>();
//
//
//			//get the first (and only required) company in the saved comparison & add company into an arraylist
//			Company c1 = companyService.findBycName(comparison.getCompany1());
//			//get the corresponding parentCompany
//			ParentCompany p1 = parentCompanyService.findBypcName(c1.getParentCompanyName());
//
//			companyList.add(c1);
//			parentCompanyList.add(p1);
//			innerCompanyMap.put(c1, p1);
//			
//			System.out.println(companyList.get(0).getcName());
//			
//			//get each additional company & parentCompany in the savedComparisons obj && add into their own arraylist(s)
//			if (comparison.getCompany2() != null) {
//				Company c2 = companyService.findBycName(comparison.getCompany2());
//				ParentCompany p2 = parentCompanyService.findBypcName(c2.getParentCompanyName());
//				innerCompanyMap.put(c1, p1);
//				companyList.add(c2);
//				parentCompanyList.add(p2);
//				if (comparison.getCompany3() != null) {
//					Company c3 = companyService.findBycName(comparison.getCompany3());
//					ParentCompany p3= parentCompanyService.findBypcName(c3.getParentCompanyName());
//					companyList.add(c3);
//					parentCompanyList.add(p3);
//					innerCompanyMap.put(c1, p1);
//				}
//			}
//
//			//add the arraylist into the savedComparisonsList
//			savedCompanyComparisonsList.add(companyList);
//			savedParentCompanyComparisonsList.add(parentCompanyList);
////			outerCompanyMap.put(mapNumber, innerCompanyMap);
//		
//		});
//		
//		
//		System.out.println("-----------------------------------------");
//		
//		model.addAttribute("bothList", outerCompanyMap);
//		model.addAttribute("companyList", savedCompanyComparisonsList);
//		model.addAttribute("parentCoList", savedParentCompanyComparisonsList);
//
//		
//		return "user/savedComparisons";
//	}
//
//}
