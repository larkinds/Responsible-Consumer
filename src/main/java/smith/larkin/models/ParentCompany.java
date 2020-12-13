package smith.larkin.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ParentCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pcId;
	@Column
	private String pcName;
	@Column
	private Integer environment;
	@Column
	private Integer human_rights;
	@Column
	private Integer animal_rights;
	@Column
	private Integer workers_rights;
	@Column
	private Integer diversity;
	@Column
	private String political_contributions;
	@OneToMany(mappedBy = "parentCompanyId", fetch = FetchType.LAZY)
	List<Company> ownedCompanies;

	public ParentCompany() {
	}

	public ParentCompany(Integer environment, Integer human_rights, Integer animal_rights, Integer workers_rights,
			Integer diversity, String political_contributions, String products) {
		this.environment = environment;
		this.human_rights = human_rights;
		this.animal_rights = animal_rights;
		this.workers_rights = workers_rights;
		this.diversity = diversity;
		this.political_contributions = political_contributions;
		this.ownedCompanies = new ArrayList<Company>();
	}

	public Long getPcId() {
		return pcId;
	}
	

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public void setEnvironment(Integer environment) {
		this.environment = environment;
	}

	public Integer getEnvironment() {
		return environment;
	}

	public void setHuman_rights(Integer human_rights) {
		this.human_rights = human_rights;
	}

	public Integer getHuman_rights() {
		return human_rights;
	}

	public void setAnimal_rights(Integer animal_rights) {
		this.animal_rights = animal_rights;
	}

	public Integer getAnimal_rights() {
		return animal_rights;
	}

	public void setWorkers_rights(Integer workers_rights) {
		this.workers_rights = workers_rights;
	}

	public Integer getWorkers_rights() {
		return workers_rights;
	}

	public void setDiversity(Integer diversity) {
		this.diversity = diversity;
	}

	public Integer getDiversity() {
		return diversity;
	}

	public void setPolitical_contributions(String political_contributions) {
		this.political_contributions = political_contributions;
	}

	public String getPolitical_contributions() {
		return political_contributions;
	}

	public void setOwnedCompanies(List<Company> ownedCompanies) {
		this.ownedCompanies = ownedCompanies;
	}

	public List<Company> getOwnedCompanies() {
		return ownedCompanies;
	}

}
