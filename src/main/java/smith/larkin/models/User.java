package smith.larkin.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uId;
	@Column(unique = true, nullable = false)
	@NotNull(message = "Field is required!")
	private String username;
	@Column
	private String uPassword;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private Integer zipCode;
	@Column
	private String country;
	@Column(nullable = false)
	//comma deliminated list in string form
	private String uRole;
	private Integer status;
	@OneToMany(mappedBy = "ownerUserId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	List<UserSavedComparison> ownedComparisons;

	// default constructor
	public User() {

	}


	public User(@NotNull(message = "Field is required!") String username, String uPassword, String firstName,
			String lastName, Integer zipCode, String country) {
		super();
		this.username = username;
		this.uPassword = uPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.uRole = "USER";
		this.status = 1;
		this.ownedComparisons = new ArrayList<UserSavedComparison>();
	}




	public void setuId(Long uId) {
		this.uId = uId;
	}

	public Long getuId() {
		return uId;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuPassword() {
		return uPassword;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	public String getuRole() {
		return uRole;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public List<String> getuRoles() {
		return Arrays.stream(this.uRole.split(",")).collect(Collectors.toList());
	}

	public void setOwnedComparisons(List<UserSavedComparison> ownedComparisons) {
		this.ownedComparisons = ownedComparisons;
	}

	public List<UserSavedComparison> getOwnedComparisons() {
		return ownedComparisons;
	}

	@Override
	public String toString() {
		return "User Id:" + uId + ", Username: " + username + ", Password: " + uPassword + ", Role: " + uRole
				+ ", status: " + status;
	}

}
