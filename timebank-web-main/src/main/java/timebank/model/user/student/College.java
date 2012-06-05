package timebank.model.user.student;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import timebank.model.Values;

@Entity
@Table(name = "college_table")
public class College {

	/**
	 * college id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * college name
	 */
	@Column(name = "college_name", length = Values.NORMAL_NAME_LENGTH,
			nullable = false, unique = true)
	private String name;
	
	/**
	 * description of college.
	 */
	@Column(name = "college_description", length = Values.SMALL_CONTENT_LENGTH,
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
