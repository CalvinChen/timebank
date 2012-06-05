package timebank.model.cookie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.admin.Admin;

/**
 * cookie for admin
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "cookie_admin")
public class CookieAdmin {
	
	/**
	 * cookie admin id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * owner of the cookie is a admin.
	 */
	@ManyToOne
	@JoinColumn(name = "cookie_admin_id", nullable = false, unique = false)
	private Admin cookieOwner;
	
	/**
	 * session id content of the cookie
	 */
	@Column(name = "session_id_content", length = Values.SMALL_CONTENT_LENGTH,
			nullable = false, unique = false)
	private String sessionIdContent;
	
	public CookieAdmin(){
	}	

	public CookieAdmin(Admin cookieOwner, String sessionIdContent) {
		this.cookieOwner = cookieOwner;
		this.sessionIdContent = sessionIdContent;
	}


	public int getId() {
		return id;
	}

	public void setId(int cookieAdminId) {
		this.id = cookieAdminId;
	}

	public Admin getCookieOwner() {
		return cookieOwner;
	}

	public void setCookieOwner(Admin cookieOwner) {
		this.cookieOwner = cookieOwner;
	}

	public String getSessionIdContent() {
		return sessionIdContent;
	}

	public void setSessionIdContent(String sessionIdContent) {
		this.sessionIdContent = sessionIdContent;
	}	
}
