package timebank.model.user.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.Values;

@Entity
@Table(name = "major_table")
public class Major {
	
	/**
	 * major id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * major name.
	 */
	@Column(name = "major_name", length = Values.NORMAL_NAME_LENGTH,
			nullable = false, unique = false)
	private String name;
	
	/**
	 * belong to which college.
	 */
	@ManyToOne
	@JoinColumn(name = "belonged_college_id", nullable = false, unique = false)
	private College belongedCollege;
	
	/**
	 * description of major.
	 */
	@Column(name = "major_description", length = Values.SMALL_CONTENT_LENGTH,
			nullable = true, unique = false)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public College getBelongedCollege() {
		return belongedCollege;
	}

	public void setBelongedCollege(College belongedCollege) {
		this.belongedCollege = belongedCollege;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
