package timebank.model.bank;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import timebank.model.Values;
/**
 * feedback of the help record.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "help_record_feedback")
public class HelpRecordFeedback {
	
	/**
	 * feedback id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * score given by the feedback user.
	 */
	@Column(name = "feedback_score", nullable = false, unique = false)
	private double Score;
	
	/**
	 * content of the feedback.
	 */
	@Column(name = "feedback_content", length = Values.NORMAL_CONTENT_LENGTH, nullable = false, unique = false)
	private String content;
	
	/**
	 * when did the feedback send.
	 */
	@Column(name = "feedback_time", nullable = false, unique = false)
	private Date FeedbackTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getScore() {
		return Score;
	}

	public void setScore(double score) {
		Score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getFeedbackTime() {
		return FeedbackTime;
	}

	public void setFeedbackTime(Date feedbackTime) {
		FeedbackTime = feedbackTime;
	}
}
