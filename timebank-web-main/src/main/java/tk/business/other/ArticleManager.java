package tk.business.other;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

import timebank.model.admin.Admin;
import timebank.model.article.Article;
import timebank.util.lang.convertor.Convertor;
import tk.persistence.ArticleDao;
import tk.persistence.impl.hibernate.ArticleDaoHibernate;

@Service
public class ArticleManager {
	@Resource(type = ArticleDaoHibernate.class)
	private ArticleDao articleDao;

	/**
	 * @return the articleDao
	 */
	public ArticleDao getArticleDao() {
		return articleDao;
	}

	/**
	 * @param articleDao the articleDao to set
	 */
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List getAllArticles() {
		List list = articleDao.selectAll();
		return list;
	}
	
	public ArrayList<Article> getArticlesByType(int articleType){
		ArrayList<Article> list = articleDao.selectListByType(articleType);
		return list;
	}

	public String addArticle(Article article) {
		Admin admin = ((Admin)ActionContext.getContext().getSession().get("adminLogined"));//获取当前管理员对象
//		article.setAdmin(admin);//完善管理员ID
//		if(article.getAuthor().trim().equals("")){
//			article.setAuthor(admin.getUsername());//完善作者，如果有填写
//		}
//		article.setCreateTime(Convertor.changeDateTimeToString(new Date()));//完善更新时间
		article.setArticleClickCount(0);//完善文章点击数，初始为0
		String result = articleDao.insert(article);
		return result;
	}

	public Article getArticleById(int articleId) {
		Article one = articleDao.select(articleId);
		return one;
	}

	public String setArticle(Article one) {
		String result = articleDao.update(one);
		return result;
	}

	public String updateArticle(Article one) {
		one.setPostTime(new Date());//更新更新时间
		String result = articleDao.update(one);
		return result;
	}

	public String deleteArticle(int articleId) {
		String result = articleDao.delete(articleId);
		return result;
	}
	
}
