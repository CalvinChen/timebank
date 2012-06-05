package timebank.model.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import timebank.model.Values;
import timebank.model.admin.Admin;

/**
 * represents the type of article.
 * @author Calvin Chen
 */
@Entity
@Table(name = "article_type")
public class ArticleType {
	
	/**
	 * article type id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	/**
	 * type name.
	 */
	@Column(name = "type_name", length = Values.NORMAL_NAME_LENGTH, nullable = false, unique = true)
	private String name;
	
	/**
	 * type description.
	 */
	@Column(name = "type_description", length = Values.NORMAL_CONTENT_LENGTH, nullable = true, unique = false)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int articleTypeId) {
		this.id = articleTypeId;
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
