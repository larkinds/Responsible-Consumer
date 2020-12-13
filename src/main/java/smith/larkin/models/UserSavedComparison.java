package smith.larkin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class UserSavedComparison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comparisonId;
	@Column
	@NotNull(message = "field is required")
	private String company1;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User ownerUserId;

	// default constructor
	public UserSavedComparison() {
	}

	// a constructor for a comparison with only 1 saved company
	public UserSavedComparison(Long comparisonId, User ownerUserId,
			@NotNull(message = "field is required") String company1) {
		this.comparisonId = comparisonId;
		this.ownerUserId = ownerUserId;
		this.company1 = company1;
	}


	public Long getComparisonId() {
		return comparisonId;
	}

	public User getOwnerUserId() {
		return ownerUserId;
	}
	
	public void setOwnerUserId(User ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public void setCompany1(String company1) {
		this.company1 = company1;
	}

	public String getCompany1() {
		return company1;
	}


	@Override
	public String toString() {
		return "------------" + "/n company:" + company1 + "/n ownerUserId:" + ownerUserId + "-------------";
	}
	
	

}
