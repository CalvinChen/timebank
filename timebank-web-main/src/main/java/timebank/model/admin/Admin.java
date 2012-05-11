package timebank.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name = "admin_id", nullable = false, unique = true)
	private int adminId;
	
	/**
	 * admin's username.
	 */
	@Column(name = "username_column", length = 20, nullable = false, unique = true)
	private String username;
	
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
	@Column(name = "admin_level", nullable = false, unique = false)
	private Short adminLevel;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public User getLinkedUser() {
		return linkedUser;
	}

	public void setLinkedUser(User linkedUser) {
		this.linkedUser = linkedUser;
	}

	public Short getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(Short adminLevel) {
		this.adminLevel = adminLevel;
	}
}
