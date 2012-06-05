package timebank.model.suggestion;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.user.User;

/**
 * suggestion post by user, waiting for admin to answer.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "user_suggestion")
public class UserSuggestion {

	/**
	 * user suggestion id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * user who suggest this.
	 */
	@ManyToOne
	@JoinColumn(name = "suggest_user_id", nullable = false, unique = false)
	private User suggestUser;
	
	/**
	 * picture about the suggestion uploaded by user to show more information.
	 * can be null if there's no.
	 */
	@Column(name = "related_picture", length = Values.NORMAL_PICTURE_URL_LENGTH,
			nullable = true, unique = false)
	private String relatedPicture;
	
	/**
	 * when did this post?
	 */
	@Column(name = "post_time", nullable = false, unique = false)
	private Date postTime;
	
	/**
	 * the title of the suggestion.
	 */
	@Column(name = "suggestion_title", length = Values.NORMAL_TITLE_LENGTH,
			nullable = false, unique = false)
	private String title;
	
	/**
	 * the content of the suggestion.
	 */
	@Column(name = "suggestion_content", length = Values.NORMAL_CONTENT_LENGTH,
			nullable = false, unique = false)
	private String content;
	
	/**
	 * is this answered by admin?
	 * default value is false.
	 */
	@Column(name = "is_answered", nullable = false, unique = false)
	private Boolean isAnswered = false;
	
	/**
	 * answer information.
	 * can be null if the admin have not answered yet.
	 */
	@OneToOne
	@JoinColumn(name = "suggestion_answer_id", nullable = true, unique = true)
	private UserSuggestionAnswer answerInfo;

	public int getId() {
		return id;
	}

	public void setId(int userSuggestionId) {
		this.id = userSuggestionId;
	}

	public User getSuggestUser() {
		return suggestUser;
	}

	public void setSuggestUser(User suggestUser) {
		this.suggestUser = suggestUser;
	}

	public String getRelatedPicture() {
		return relatedPicture;
	}

	public void setRelatedPicture(String relatedPicture) {
		this.relatedPicture = relatedPicture;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public UserSuggestionAnswer getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(UserSuggestionAnswer answerInfo) {
		this.answerInfo = answerInfo;
	}
}
