package timebank.model.user.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "study_class")
public class StudyClass {

	/**
	 * class database id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * class number.
	 */
	@Column(name = "class_number", nullable = false, unique = false)
	private int classNumber;
	
	/**
	 * grade.
	 */
	@ManyToOne
	@JoinColumn(name = "grade_id", nullable = false, unique = false)
	private Grade grade;
	
	/**
	 * major.
	 */
	@ManyToOne
	@JoinColumn(name = "major_id", nullable = false, unique = false)
	private Major major;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
}
