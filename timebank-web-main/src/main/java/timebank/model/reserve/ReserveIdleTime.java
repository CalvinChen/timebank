package timebank.model.reserve;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.user.User;

/**
 * idle time reserved by the user
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "reserve_idle_time")
public class ReserveIdleTime {
	/**
	 * idle time id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idle_time_id", nullable = false, unique = true)
	private int idleTimeId;
	
	/**
	 * user who own this idle time.
	 */
	@ManyToOne
	@JoinColumn(name = "idle_time_user_id", nullable = false, unique = false)
	private User user;
	
	/**
	 * what day of a week have idle hours?
	 */
	@Column(name = "idle_day", nullable = false, unique = false)
	private Short idleDay;
	
	/**
	 * what hours of a day is idle?
	 */
	@Column(name = "idle_hour", nullable = false, unique = false)
	private Short idleHour;
	
	/**
	 * description of the idle time.
	 * can be null if there's no.
	 */
	@Column(name = "idle_time_description", length = 200, nullable = true, unique = false)
	private String description;

	public int getIdleTimeId() {
		return idleTimeId;
	}

	public void setIdleTimeId(int idleTimeId) {
		this.idleTimeId = idleTimeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Short getIdleDay() {
		return idleDay;
	}

	public void setIdleDay(Short idleDay) {
		this.idleDay = idleDay;
	}

	public Short getIdleHour() {
		return idleHour;
	}

	public void setIdleHour(Short idleHour) {
		this.idleHour = idleHour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}