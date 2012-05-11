/**
 * @Project TimeBank
 * @CreatedTime 2011-10-13 下午11:56:58 
 * @Author CK
 * @Todo TODO
 */
package timebank.action.other;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import timebank.business.other.ArticleManager;
import timebank.model.article.Article;
import timebank.util.Tester;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Controller
public class DocumentAction {
	@Resource
	private ArticleManager articleManager;
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
	
	private int aid;
	public int getAid() {return aid;}
	public void setAid(int aid) {this.aid = aid;}
	private Article one;
	public Article getOne() {return one;}
	public void setOne(Article one) {this.one = one;}
	
	public String view(){
		one = articleManager.getArticleById(aid);
		one.setArticleClickCount(one.getArticleClickCount() + 1);
		String result = articleManager.setArticle(one);
		if(result.equals(Values.SUCCESS) == false){
			Tester.markHere("文章计数器失效！");
		}
		return "view";
	}
}
