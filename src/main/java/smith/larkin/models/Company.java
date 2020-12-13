package smith.larkin.models;


import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	@Column
	private String cName;
	@Column
	private Integer environmentScore;
	@Column
	private Integer humanRightsScore;
	@Column
	private Integer animalRightsScore;
	@Column
	private Integer workersRightsScore;
	@Column
	private Integer diversityScore;
	@Column
	// comma deliminited list in string form - translated into an array list below
	private String political_contributions;
//	@Column
	//(for future versions)
//	private String products;
	@ManyToOne
	@JoinColumn(name = "pcId")
	private ParentCompany parentCompanyId;
	@Column
	private String parentCompanyName;

	public Company() {}

	//one constructor for companies without parent companies
	public Company(String cName, int environmentScore, int humanRightsScore, int animalRightsScore,
			int workersRightsScore, int diversityScore, String political_contributions) {
		this.cName = cName;
		this.environmentScore = environmentScore;
		this.humanRightsScore = humanRightsScore;
		this.animalRightsScore = animalRightsScore;
		this.workersRightsScore = workersRightsScore;
		this.diversityScore = diversityScore;
		this.political_contributions = political_contributions;
	}
	
	//one constructor for companies with parent companies
	public Company(String cName, Integer environmentScore, Integer humanRightsScore, Integer animalRightsScore,
			Integer workersRightsScore, Integer diversityScore, String political_contributions,
			ParentCompany parentCompanyId, String parentCompanyName) {
		super();
		this.cName = cName;
		this.environmentScore = environmentScore;
		this.humanRightsScore = humanRightsScore;
		this.animalRightsScore = animalRightsScore;
		this.workersRightsScore = workersRightsScore;
		this.diversityScore = diversityScore;
		this.political_contributions = political_contributions;
		this.parentCompanyId = parentCompanyId;
		this.parentCompanyName = parentCompanyName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getEnvironmentScore() {
		return environmentScore;
	}

	public void setEnvironmentScore(Integer environmentScore) {
		this.environmentScore = environmentScore;
	}

	public Integer getHumanRightsScore() {
		return humanRightsScore;
	}

	public void setHumanRightsScore(Integer humanRightsScore) {
		this.humanRightsScore = humanRightsScore;
	}

	public Integer getAnimalRightsScore() {
		return animalRightsScore;
	}

	public void setAnimalRightsScore(Integer animalRightsScore) {
		this.animalRightsScore = animalRightsScore;
	}

	public Integer getWorkersRightsScore() {
		return workersRightsScore;
	}

	public void setWorkersRightsScore(Integer workersRightsScore) {
		this.workersRightsScore = workersRightsScore;
	}

	public Integer getDiversityScore() {
		return diversityScore;
	}

	public void setDiversityScore(Integer diversityScore) {
		this.diversityScore = diversityScore;
	}

	public String getPolitical_contributions() {
		return political_contributions;
	}

	public void setPolitical_contributions(String political_contributions) {
		this.political_contributions = political_contributions;
	}
	
	//method to allow us to get all product names into a list, which will help with querying down the line
		public List<String> getPoliticalCongtributionsList() {
			List<String> contributionsList = Arrays.asList(this.political_contributions.split(","));
			return contributionsList;
		}
	
//	for future version
//	public void setProducts(String products) {
//		this.products = products;
//	}
//
//	public String getProducts() {
//		return products;
//	}
//
//	//method to allow us to get all product names into a list, which will help with querying down the line
//	public List<String> getProductsList() {
//		List<String> productList = Arrays.asList(this.products.split(","));
//		return productList;
//	}

	public ParentCompany getParentCompanyId() {
		return parentCompanyId;
	}

	public void setParentCompanyId(ParentCompany parentCompanyId) {
		this.parentCompanyId = parentCompanyId;
	}

	public String getParentCompanyName() {
		return parentCompanyName;
	}

	public void setParentCompanyName(String parentCompanyName) {
		this.parentCompanyName = parentCompanyName;
	}

	public Long getcId() {
		return cId;
	}
	

}
