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

import timebank.model.Values;
import timebank.model.user.User;

/**
 * user's operation log
 * @author Calvin Chen
 */
@Entity
@Table(name = "user_operation_log")
public class UserOperationLog {
	/**
	 * user's operation log id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * the user who conduct this operation.
	 */
	@ManyToOne
	@JoinColumn(name = "user_conducted_id", nullable = false, unique = false)
	private User userConducted;
	
	/**
	 * the user who involved, like making friend. can be null if there's none.
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
	@Column(name = "operation_type", length = Values.NORMAL_NAME_LENGTH, 
			nullable = false, unique = false)
	private String operation;
	
	/**
	 * some extra information, like why verify to true, or to false 
	 */
	@Column(name = "description_column", length = Values.SMALL_CONTENT_LENGTH,
			nullable = false, unique = false)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int userOperationLogId) {
		this.id = userOperationLogId;
	}

	public User getUserConducted() {
		return userConducted;
	}

	public void setUserConducted(User userConducted) {
		this.userConducted = userConducted;
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
