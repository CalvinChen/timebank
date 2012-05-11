package timebank.model.article;

import java.util.Date;

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
 * comment of an article.
 * @author Calvin Chen
 * @createTime Apr 13, 2012
 */
@Entity
@Table(name = "article_comment")
public class ArticleComment {
	
	/**
	 * article comment id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_comment_id", nullable = false, unique = true)
	private int articleCommentId;
	
	/**
	 * who make this comment?
	 */
	@ManyToOne
	@JoinColumn(name = "commenter_id", nullable = false, unique = false)
	private User commenter;
	
	/**
	 * the content of the comment.
	 */
	@Column(name = "comment_content", length = 200, nullable = false, unique = false)
	private String commentContent;
	
	/**
	 * comment date and time.
	 */
	@Column(name = "comment_time", nullable = false, unique = false)
	private Date commentTime;

	public int getArticleCommentId() {
		return articleCommentId;
	}

	public void setArticleCommentId(int articleCommentId) {
		this.articleCommentId = articleCommentId;
	}

	public User getCommenter() {
		return commenter;
	}

	public void setCommenter(User commenter) {
		this.commenter = commenter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
}
