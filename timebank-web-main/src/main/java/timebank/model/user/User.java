package timebank.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.bank.BankInfo;

@Entity
@Table(name = "user_table")
public class User {

	/**
	 * user id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * user name, for login only.
	 */
	@Column(name = "login_name", length = Values.LARGE_NAME_LENGTH, nullable = false, unique = true)
	private String loginName;
	
	/**
	 * user name for displaying.
	 */
	@Column(name = "display_name", length = Values.NORMAL_NAME_LENGTH,
			nullable = false, unique = true)
	private String displayName;
	
	/**
	 * password
	 */
	@Column(name = "password_column", length = Values.NORMAL_PASSWORD_LENGTH,
			nullable = false, unique = false)
	private String password;
	
	/**
	 * user's information
	 */
	@OneToOne()
	@JoinColumn(name = "user_info_id", nullable = false, unique = true)
	private UserInfo userInfo = new UserInfo();
	
	/**
	 * user's bank information
	 */
	@OneToOne
	@JoinColumn(name = "bank_info_id", nullable = false, unique = true)
	private BankInfo bankInfo = new BankInfo();
	
	/**
	 * is this guy verified by admin to user timebank business?
	 */
	@Column(name = "is_verified", nullable = false, unique = false)
	private Boolean isVerified = false;
	
	public User(){
	}
	
	public User(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int userId) {
		this.id = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String username) {
		this.loginName = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public BankInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
}
