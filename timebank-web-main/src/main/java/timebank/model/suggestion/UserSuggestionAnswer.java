package timebank.model.suggestion;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import timebank.model.admin.Admin;

/**
 * answer of the user suggestion
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "user_suggestion_answer")
public class UserSuggestionAnswer {

	/**
	 * answer id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * the admin who answer the suggestion
	 */
	@ManyToOne
	@JoinColumn(name = "answered_admin_id", nullable = false, unique = false)
	private Admin adminAnswered;
	
	/**
	 * when did the admin answer?
	 */
	@Column(name = "answer_time", nullable = false, unique = false)
	private Date answerTime;
	
	/**
	 * answer content.
	 */
	@Column(name = "answer_content", length = 400, nullable = false, unique = false)
	private String answerContent;

	public int getId() {
		return id;
	}

	public void setId(int suggestionAnswerId) {
		this.id = suggestionAnswerId;
	}

	public Admin getAdminAnswered() {
		return adminAnswered;
	}

	public void setAdminAnswered(Admin adminAnswered) {
		this.adminAnswered = adminAnswered;
	}

	public Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
}
