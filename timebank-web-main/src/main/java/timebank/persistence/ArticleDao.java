package timebank.persistence;

import java.util.ArrayList;
import java.util.List;

import timebank.model.article.Article;

/**
 * article dao interface.
 * @author Calvin Chen
 * @createTime Apr 11, 2012
 */
public interface ArticleDao {

	/**
	 * insert an article row.
	 * @param article
	 * @return
	 */
	public abstract String insert(Article article);

	/**
	 * select all articles.
	 * @param userId 
	 * @return
	 */
	public abstract List selectAll();

	/**
	 * select a list of articles which their type is pointed.
	 * @param articleType 
	 * @return
	 */
	public abstract ArrayList<Article> selectListByType(int articleType);

	/**
	 * update an article
	 * @param article
	 * @return
	 */
	public abstract String update(Article article);

	/**
	 * select an article according to its id.
	 * @param articleId
	 * @return
	 */
	public abstract Article select(int articleId);

	/**
	 * delete an article according to its id.
	 * @param articleId
	 * @return
	 */
	public abstract String delete(int articleId);
}