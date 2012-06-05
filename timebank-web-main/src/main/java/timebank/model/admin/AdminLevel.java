package timebank.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import timebank.model.Values;

/**
 * represents the level of admin.
 * @author Calvin Chen
 */
@Entity
@Table(name = "admin_level")
public class AdminLevel {
	
	/**
	 * admin level id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * level name.
	 */
	@Column(name = "level_name", length = Values.NORMAL_NAME_LENGTH, nullable = false, unique = false)
	private String levelName;
	
	/**
	 * level number.
	 */
	@Column(name = "level_number", nullable = false, unique = false)
	private int levelNumber;

	public int getId() {
		return id;
	}

	public void setId(int adminLevelId) {
		this.id = adminLevelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
}
