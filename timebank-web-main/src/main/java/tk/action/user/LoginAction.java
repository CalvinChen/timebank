package tk.action.user;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import timebank.business.impl.cookie.UserCookieManagerImpl;
import timebank.business.impl.user.UserManagerImpl;
import timebank.model.admin.Admin;
import timebank.model.user.User;
import timebank.util.lang.string.StringUtil;
import timebank.util.log.LogUtil;
import timebank.util.web.action.ActionUtil;
import timebank.util.web.cookie.CookieUtil;
import tk.util.Tester;
import tk.util.bean.Values;

@Namespace(value = "/user/login/")
@Results(value = {
		@Result(name = "index", location = "/view/index.jsp"),
		@Result(name = "homepage", location = "/view/user/homepage/homepage.jsp")
})
@Controller
public class LoginAction extends ActionSupport {
	
	private static final Logger log = LoggerFactory.getLogger(LoginAction.class); 
	
	@Resource
	private UserCookieManagerImpl userCookieManager;
	@Resource
	private UserManagerImpl userManager;
	
	private LoginParam param;
	
	public LoginParam getParam() {
		return param;
	}

	public void setParam(LoginParam param) {
		this.param = param;
	}

	/**
	 * @return the userManager
	 */
	public UserManagerImpl getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}

	/**
	 * @return the userCookieManager
	 */
	public UserCookieManagerImpl getUserCookieManager() {
		return userCookieManager;
	}

	/**
	 * @param userCookieManager the userCookieManager to set
	 */
	public void setUserCookieManager(UserCookieManagerImpl userCookieManager) {
		this.userCookieManager = userCookieManager;
	}


	//--------------------setter and getter------------------------
	public String verifyExecute(){
		String result = Values.SUCCESS;
		if(param.getUser().getLoginName() == null || param.getUser().getLoginName().length() < 2 || param.getUser().getLoginName().length() > 20){
			return "用户名不合格！";
		}
		if(param.getUser().getPassword() == null || param.getUser().getPassword().length() < 2 || param.getUser().getPassword().length() > 20){
			return "密码不合格！";
		}
		return result;
	}
	
	/**
	 * user submit the login form.
	 * @return "homepage" if login successfully or "index" if failed.
	 */
	@Action(value = "login")
	public String login() {
		/* try to get the user from database */
		User user = userManager.login(
				param.getUser().getLoginName(), param.getUser().getPassword());
		
		if(null != user){
			/* login successfully */
			ActionUtil.setCurrentUser(user);
			
			/* if auto login checkbox is checked, add cookie */
			if(null != param.getAutoLogin() && param.getAutoLogin().equals(StringUtil.YES)){
				CookieUtil.addCookie(param.getUser().getId(), StringUtil.USER);
			}
			
			log.info(LogUtil.INFO_USER_1_HAS_LOGINED, user.getLoginName());
			return "homepage";
		}else{
			//登录失败
			param.setMessage("账号或密码输入有错误！");
			return "failureLoginError";
		}
		
	}
	
	public String regSucc() {
		ActionContext.getContext().put("message", "恭喜您注册成功，请登录！");
		return "view";
	}
	
	@Action(value = "exit")
	public String exit(){
		ActionUtil.removeCurrentUser();
		return "index";
	}
	

	
}
