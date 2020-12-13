package smith.larkin.future;
//package smith.larkin.future;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//
//@Entity
//public class UserSavedComparison {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long comparisonId;
//	@Column
//	@NotNull(message = "field is required")
//	private String company1;
//	@Column
//	private String company2;
//	@Column
//	private String company3;
//	@ManyToOne
//	@JoinColumn(name = "userId")
//	private User ownerUserId;
//
//	// default constructor
//	public UserSavedComparison() {
//	}
//
//	// a constructor for a comparison with only 1 saved company
//	public UserSavedComparison(Long comparisonId, User ownerUserId,
//			@NotNull(message = "field is required") String company1) {
//		this.comparisonId = comparisonId;
//		this.ownerUserId = ownerUserId;
//		this.company1 = company1;
//	}
//
//	// a constructor for a comparison with 2 saved companies
//	public UserSavedComparison(Long comparisonId, User ownerUserId,
//			@NotNull(message = "field is required") String company1, String company2) {
//		this.comparisonId = comparisonId;
//		this.ownerUserId = ownerUserId;
//		this.company1 = company1;
//		this.company2 = company2;
//	}
//
//	// a constructor for a comparison with 3 saved companies
//	public UserSavedComparison(Long comparisonId, User ownerUserId,
//			@NotNull(message = "field is required") String company1, String company2, String company3) {
//		this.comparisonId = comparisonId;
//		this.ownerUserId = ownerUserId;
//		this.company1 = company1;
//		this.company2 = company2;
//		this.company3 = company3;
//	}
//
//	public Long getComparisonId() {
//		return comparisonId;
//	}
//
//	public User getOwnerUserId() {
//		return ownerUserId;
//	}
//	
//	public void setOwnerUserId(User ownerUserId) {
//		this.ownerUserId = ownerUserId;
//	}
//
//	public void setCompany1(String company1) {
//		this.company1 = company1;
//	}
//
//	public String getCompany1() {
//		return company1;
//	}
//
//	public void setCompany2(String company2) {
//		this.company2 = company2;
//	}
//
//	public String getCompany2() {
//		return company2;
//	}
//
//	public void setCompany3(String company3) {
//		this.company3 = company3;
//	}
//
//	public String getCompany3() {
//		return company3;
//	}
//	
//
//	@Override
//	public String toString() {
//		return "------------" + "/n company1:" + company1 + "/n company2:" + company2
//				+ "/n company3:" + company3 + "/n ownerUserId:" + ownerUserId + "-------------";
//	}
//	
//	
//
//}
