/**
 * @Project TimeBank
 * @CreatedTime 2011-10-22 上午08:13:51 
 * @Author CK
 */
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
 * reserve skills of user.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "reserve_skill")
public class ReserveSkill {
	/**
	 * skill id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * user who own this skill.
	 */
	@ManyToOne
	@JoinColumn(name = "skill_owner_user_id", nullable = false, unique = false)
	private User user;
	
	/**
	 * skill's big range.
	 */
	@Column(name = "range_big", length = 20, nullable = false, unique = false)
	private String rangeBig;
	
	/**
	 * skill's small range.
	 */
	@Column(name = "range_small", length = 20, nullable = false, unique = false)
	private String rangeSmall;
	
	/**
	 * description of the skill.
	 * can be null if the user had not filled up.
	 */
	@Column(name = "skill_description", length = 100, nullable = true, unique = false)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int skillId) {
		this.id = skillId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRangeBig() {
		return rangeBig;
	}

	public void setRangeBig(String rangeBig) {
		this.rangeBig = rangeBig;
	}

	public String getRangeSmall() {
		return rangeSmall;
	}

	public void setRangeSmall(String rangeSmall) {
		this.rangeSmall = rangeSmall;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
