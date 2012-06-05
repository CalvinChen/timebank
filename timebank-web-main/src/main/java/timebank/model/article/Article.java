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

import timebank.model.Values;
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
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * admin who post it.
	 */
	@ManyToOne
	@JoinColumn(name = "admin_id", nullable = false, unique = false)
	private Admin author;
	
	/**
	 * when post and when update.
	 */
	@Column(name = "post_time", nullable = false, unique = false)
	private Date postTime;
	
	/**
	 * article type, to be enumerated.
	 */
	@ManyToOne
	@JoinColumn(name = "article_type_id", nullable = false, unique = false)
	private ArticleType articleType;
	
	/**
	 * title of the article.
	 */
	@Column(name = "article_title", length = Values.NORMAL_TITLE_LENGTH, nullable = false, unique = false)
	private String articleTitle;
	
	/**
	 * content of the article.
	 */
	@Column(name = "article_content", length = Values.LARGE_CONTENT_LENGTH, nullable = false, unique = false)
	private String articleContent;
	
	/**
	 * count how much time the article is clicked.
	 * initially to be 0.
	 */
	@Column(name = "article_click_count", nullable = false, unique = false)
	private int articleClickCount = 0;

	public int getId() {
		return id;
	}

	public void setId(int articleId) {
		this.id = articleId;
	}

	public Admin getAuthor() {
		return author;
	}

	public void setAuthor(Admin admin) {
		this.author = admin;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public ArticleType getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleType articleType) {
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
