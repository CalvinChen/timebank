package timebank.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * an user who is also a student.
 * @author Calvin Chen
 * @createTime Apr 11, 2012
 */
@Entity
public class Student extends User{
	
	/**
	 * what college.
	 */
	@Column(name = "college_column", nullable = true, unique = false)
	private Short college;
	
	/**
	 * what major.
	 */
	@Column(name = "major_column", length = 40, nullable = true, unique = false)
	private String major;
	
	/**
	 * what grade.
	 */
	@Column(name = "grade_column", nullable = true, unique = false)
	private Integer grade;
	
	/**
	 * which class.
	 */
	@Column(name = "class_id", nullable = true, unique = false)
	private Integer classId;
	
	/**
	 * student id used in school.
	 * must be unique.
	 */
	@Column(name = "student_id", length = 20, nullable = true, unique = true)
	private String studentId;

	public Short getCollege() {
		return college;
	}

	public void setCollege(Short college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
}
