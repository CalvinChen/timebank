package timebank.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	/**
	 * user id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private int userId;
	
	/**
	 * user name, for login and display to other users.
	 */
	@Column(name = "user_name", length = 20, nullable = false, unique = true)
	private String username;
	
	/**
	 * password
	 */
	@Column(name = "password_column", length = 50, nullable = false)
	private String password;
	
	/**
	 * user's information
	 */
	@OneToOne()
	@JoinColumn(name = "user_info_id", nullable = false, unique = true)
	private UserInfo userInfo;
	
	/**
	 * is this guy verified by admin to user timebank business?
	 */
	@Column(name = "is_verified", nullable = false, unique = false)
	private Boolean isVerified = false;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
}
