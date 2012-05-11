package timebank.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import timebank.business.other.ArticleManager;
import timebank.business.other.QuoteManager;
import timebank.business.user.UserManager;
import timebank.model.article.Article;
import timebank.model.user.User;
import timebank.util.bean.Quote;

import com.opensymphony.xwork2.ActionContext;

@Namespace(value = "/")
@Results(value = {
		@Result(name = "index", location = "/view/index.jsp")
})
@Controller
public class IndexAction {
	@Resource
	private ArticleManager articleManager;
	@Resource
	private QuoteManager quoteManager;
	@Resource
	private UserManager userManager;
	
	/**
	 * @return the articleManager
	 */
	public ArticleManager getArticleManager() {
		return articleManager;
	}

	/**
	 * @param articleManager the articleManager to set
	 */
	public void setArticleManager(ArticleManager articleManager) {
		this.articleManager = articleManager;
	}

	/**
	 * @return the quoteManager
	 */
	public QuoteManager getQuoteManager() {
		return quoteManager;
	}

	/**
	 * @param quoteManager the quoteManager to set
	 */
	public void setQuoteManager(QuoteManager quoteManager) {
		this.quoteManager = quoteManager;
	}

	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	private String message;
	private User user;
	private List articleList;
	private int COUNT_OF_NEW_USER_SHOW_IN_INDEX = 6;
	private ArrayList<User> newUserList;

	public List getArticleList() {
		return articleList;
	}

	public void setArticleList(List articleList) {
		this.articleList = articleList;
	}

	public ArrayList<User> getNewUserList() {
		return newUserList;
	}

	public void setNewUserList(ArrayList<User> newUserList) {
		this.newUserList = newUserList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * view the index.jsp
	 * @return index.jsp
	 */
	@Action(value = "index")
	public String index(){
		/* if the user have logined, get the information */
		User userLogined = (User)ActionContext.getContext().getSession().get("userLogined");
		if(userLogined != null){
			int userId = userLogined.getUserId();
			user = userManager.getUserInfo(userId);
		}
		
		/* get all the information the index.jsp needed to display */
		articleList = articleManager.getAllArticles();
//		newUserList = userManager.getNewUserList(COUNT_OF_NEW_USER_SHOW_IN_INDEX);
//		list1 = quoteManager.getQuotes();
		
		/* if the user was sent here because logined failed, show the message */
		message = (String)ActionContext.getContext().getSession().get("messageLoginedFailure");
		ActionContext.getContext().getSession().remove("messageLoginedFailure");
		return "index";
	}
}
