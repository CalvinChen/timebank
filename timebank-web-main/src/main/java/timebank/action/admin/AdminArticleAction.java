package timebank.action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.other.ArticleManager;
import timebank.model.admin.Admin;
import timebank.model.article.Article;
import timebank.util.Tester;
import timebank.util.bean.Values;

@Namespace(value = "/admin/article")
@Results(value = {
		@Result(name = "add", location = "/view/admin/article/add.jsp"),
		@Result(name = "modify", location = "/view/admin/article/modify.jsp"),
		@Result(name = "list", location = "/view/other/article/list.jsp"),
		@Result(name = "view", location = "/view/other/article/view.jsp")
})
@Controller
public class AdminArticleAction {
	@Resource
	private ArticleManager articleManager;
	private int articleId;
	private Article article;
	private String message;
	private List articleList;
	private Admin admin;

	public List getArticleList() {
		return articleList;
	}

	public void setArticleList(List articleList) {
		this.articleList = articleList;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArticleManager getArticleManager() {
		return articleManager;
	}

	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	/**
	 * enter a page to add an article.
	 */
	@Action(value = "adding")
	public String adding(){
		admin = ((Admin)ActionContext.getContext().getSession().get("adminLogined"));
		return "add";
	}
	
	/**
	 * add an article.
	 */
	@Action(value = "add")
	public String add(){
		String result = articleManager.addArticle(article);
		if(result.equals(Values.SUCCESS)){
			message = "发布新文章成功！";
			articleList = articleManager.getAllArticles();
			return "list";
		}else{
			message = "发布失败，请检查输入内容！";
			admin = ((Admin)ActionContext.getContext().getSession().get("adminLogined"));
			return "add";
		}
	}

	/**
	 * delete an article.
	 */
	@Action(value = "delete")
	public String delete(){
		String result = articleManager.deleteArticle(articleId);
		if(result.equals(Values.FAILURE) == true){
			message = "删除失败！请联系管理员。";
			return "view";
		}else{
			message = "删除成功！";
			articleList = articleManager.getAllArticles();
			return "list";
		}
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
	 * view a list of all articles.
	 */
	@Action(value = "list")
	public String list(){
		articleList = articleManager.getAllArticles();
		return "list";
	}
	
	/**
	 * enter a page to modify an article, not the submit action.
	 */
	@Action(value = "modifying")
	public String modifying(){
		article = articleManager.getArticleById(articleId);
		return "modify";
	}
	
	/**
	 * submit modification of an article.
	 */
	@Action(value = "modify")
	public String modify(){
		String result = articleManager.updateArticle(article);
		if(result.equals(Values.FAILURE) == true){
			message = "更新失败！请联系管理员。";
			return "modify";
		}else{
			message = "更新成功！";
			return "view";
		}
	}
}
