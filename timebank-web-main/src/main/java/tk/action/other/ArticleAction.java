package tk.action.other;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import timebank.model.article.Article;
import tk.business.other.ArticleManager;
import tk.util.Tester;
import tk.util.bean.Values;

@Namespace(value = "/other/article")
@Results(value = {
		@Result(name = "list_news", location = "/view/other/article/list_news.jsp"),
		@Result(name = "list_notification", location = "/view/other/article/list_notification.jsp"),
		@Result(name = "list_timebank", location = "/view/other/article/list_timebank.jsp"),
		@Result(name = "list", location = "/view/other/article/list.jsp"),
		@Result(name = "view", location = "/view/other/article/view.jsp")
})
@Controller
public class ArticleAction {
	@Resource
	private ArticleManager articleManager;
	private List articleList;
	private timebank.model.article.Article article;
	private int articleId;
	
	public List getArticleList() {
		return articleList;
	}

	public void setArticleList(List articleList) {
		this.articleList = articleList;
	}

	public ArticleManager getArticleManager() {
		return articleManager;
	}

	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}

	public timebank.model.article.Article getArticle() {
		return article;
	}

	public void setArticle(timebank.model.article.Article article) {
		this.article = article;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	/**
	 * view a list of all articles.
	 */
	@Action(value = "list")
	public String list(){
		articleList = articleManager.getAllArticles();
		return "list";
	}
	
	/**
	 * view an article.
	 */
	@Action(value = "view")
	public String view(){
		article = articleManager.getArticleById(articleId);
		article.setArticleClickCount(article.getArticleClickCount() + 1);
		String result = articleManager.setArticle(article);
		if(result.equals(Values.SUCCESS) == false){
			Tester.markHere("文章计数器失效！");
		}
		return "view";
	}
	
	/**
	 * view a list of notification articles.
	 */
	@Action(value = "list_notification")
	public String listNotification(){
		articleList = articleManager.getArticlesByType(Values.TYPE_NOTIFICATION);
		return "list_notification";
	}
	
	/**
	 * view a list of news articles.
	 */
	@Action(value = "list_news")
	public String listNews(){
		articleList = articleManager.getArticlesByType(Values.TYPE_NEWS);
		return "list_news";
	}
	
	/**
	 * view a list of articles about timebank.
	 */
	@Action(value = "list_timebank")
	public String listTimebank(){
		articleList = articleManager.getArticlesByType(Values.TYPE_TIME_BANK);
		return "list_timebank";
	}
}
