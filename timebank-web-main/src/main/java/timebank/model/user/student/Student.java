package timebank.model.user.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import timebank.model.Values;
import timebank.model.user.User;

/**
 * an user who is also a student.
 * @author Calvin Chen
 * @createTime Apr 11, 2012
 */
@Entity
public class Student extends User{
	
	/**
	 * study class.
	 */
	@ManyToOne
	@JoinColumn(name = "study_class_id", nullable = true, unique = false)
	private StudyClass studyClass;
	
	/**
	 * student id used in school.
	 * must be unique.
	 */
	@Column(name = "student_id", length = Values.NORMAL_NAME_LENGTH,
			nullable = true, unique = true)
	private String studentId;
	
	/**
	 * live zone of the student.
	 */
	@ManyToOne
	@JoinColumn(name = "live_zone_id", nullable = true, unique = false)
	private LiveZone liveZone;

	public StudyClass getStudyClass() {
		return studyClass;
	}

	public void setStudyClass(StudyClass studyClass) {
		this.studyClass = studyClass;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public LiveZone getLiveZone() {
		return liveZone;
	}

	public void setLiveZone(LiveZone liveZone) {
		this.liveZone = liveZone;
	}

}
