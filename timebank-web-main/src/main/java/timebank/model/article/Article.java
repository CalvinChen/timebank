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

import timebank.model.admin.Admin;

/**
 * article that post by admin to show information to user.
 * @author Calvin Chen
 * @createTime Apr 11, 2012
 */
@Entity
@Table(name = "article_table")
public class Article {
	/**
	 * article id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id", nullable = false, unique = true)
	private int articleId;
	
	/**
	 * admin who post it.
	 */
	@ManyToOne
	@JoinColumn(name = "admin_id", nullable = false, unique = false)
	private Admin admin;
	
	/**
	 * when post and when update.
	 */
	@Column(name = "post_time", nullable = false, unique = false)
	private Date postTime;
	
	/**
	 * article type, to be enumerated.
	 */
	@Column(name = "article_type", nullable = false, unique = false)
	private Short articleType;
	
	/**
	 * title of the article.
	 */
	@Column(name = "article_title", length = 50, nullable = false, unique = false)
	private String articleTitle;
	
	/**
	 * content of the article.
	 */
	@Column(name = "article_content", length = 10000, nullable = false, unique = false)
	private String articleContent;
	
	/**
	 * count how much time the article is clicked.
	 * initially to be 0.
	 */
	@Column(name = "article_click_count", nullable = false, unique = false)
	private int articleClickCount = 0;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public Short getArticleType() {
		return articleType;
	}

	public void setArticleType(Short articleType) {
		this.articleType = articleType;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public int getArticleClickCount() {
		return articleClickCount;
	}

	public void setArticleClickCount(int articleClickCount) {
		this.articleClickCount = articleClickCount;
	}
}
