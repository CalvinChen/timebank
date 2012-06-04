package timebank.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import timebank.model.user.User;

@Entity
@Table(name = "admin_table")
public class Admin {
	/**
	 * admin id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * admin's login name.
	 */
	@Column(name = "login_name", length = 20, nullable = false, unique = true)
	private String loginName;
	
	/**
	 * admin's display name.
	 */
	@Column(name = "display_name", length = 20, nullable = false, unique = true)
	private String displayName;
	
	/**
	 * password.
	 */
	@Column(name = "password_column", length = 50, nullable = false, unique = false)
	private String password;
	
	/**
	 * linked user, can be null.
	 */
	@OneToOne
	@JoinColumn(name = "linked_user_id", nullable = true, unique = true)
	private User linkedUser;
	
	/**
	 * admin level, determine what an admin can do.
	 */
	@ManyToOne
	@JoinColumn(name = "admin_level_id", nullable = false, unique = false)
	private AdminLevel adminLevel;
	
	public Admin(){
	}
	
	public Admin(int adminId){
		this.id = adminId;
	}

	public int getId() {
		return id;
	}

	public void setId(int adminId) {
		this.id = adminId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
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

	public User getLinkedUser() {
		return linkedUser;
	}

	public void setLinkedUser(User linkedUser) {
		this.linkedUser = linkedUser;
	}

	public AdminLevel getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(AdminLevel adminLevel) {
		this.adminLevel = adminLevel;
	}

}
