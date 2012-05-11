package timebank.model.log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import timebank.model.admin.Admin;
import timebank.model.user.User;

/**
 * admin's operation log
 * @author Calvin Chen
 */
@Entity
@Table(name = "admin_operation_log")
public class AdminOperationLog {
	/**
	 * admin's operation log id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_operation_log_id", nullable = false, unique = true)
	private int adminOperationLogId;
	
	/**
	 * the admin who conduct this operation.
	 */
	@ManyToOne
	@JoinColumn(name = "admin_conducted_id", nullable = false, unique = false)
	private Admin adminConducted;
	
	/**
	 * the user who involved. can be null if there's none.
	 */
	@ManyToOne
	@JoinColumn(name = "user_involved_id", nullable = true, unique = false)
	private User userInvolved;
	
	/**
	 * when did this log to be logged?
	 */
	@Column(name = "logged_time", nullable = false, unique = false)
	private Date loggedTime;
	
	/**
	 * what's the type of this log?
	 */
	@Column(name = "operation_type", nullable = false, unique = false)
	private String operation;
	
	/**
	 * some extra information, like why verify to true, or to false 
	 */
	@Column(name = "description_column", nullable = false, unique = false)
	private String description;

	public int getAdminOperationLogId() {
		return adminOperationLogId;
	}

	public void setAdminOperationLogId(int adminOperationLogId) {
		this.adminOperationLogId = adminOperationLogId;
	}

	public Admin getAdminConducted() {
		return adminConducted;
	}

	public void setAdminConducted(Admin adminConducted) {
		this.adminConducted = adminConducted;
	}

	public User getUserInvolved() {
		return userInvolved;
	}

	public void setUserInvolved(User userInvolved) {
		this.userInvolved = userInvolved;
	}

	public Date getLoggedTime() {
		return loggedTime;
	}

	public void setLoggedTime(Date loggedTime) {
		this.loggedTime = loggedTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
