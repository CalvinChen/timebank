package timebank.action.user;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import timebank.business.user.UserCookieManager;
import timebank.business.user.UserManager;
import timebank.model.admin.Admin;
import timebank.model.user.User;
import timebank.util.Tester;
import timebank.util.bean.Values;

//@ParentPackage("struts-default")  //用于指定默认的包,继承的作用
@Controller
public class LoginAction extends ActionSupport {
	@Resource
	private UserCookieManager userCookieManager;
	@Resource
	private UserManager userManager;
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

	/**
	 * @return the userCookieManager
	 */
	public UserCookieManager getUserCookieManager() {
		return userCookieManager;
	}

	/**
	 * @param userCookieManager the userCookieManager to set
	 */
	public void setUserCookieManager(UserCookieManager userCookieManager) {
		this.userCookieManager = userCookieManager;
	}

	private User user;
	private String message;
	private String autoLogin;
	
	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//--------------------setter and getter------------------------
	public String verifyExecute(){
		String result = Values.SUCCESS;
		if(user.getUsername() == null || user.getUsername().length() < 2 || user.getUsername().length() > 20){
			return "用户名不合格！";
		}
		if(user.getPassword() == null || user.getPassword().length() < 2 || user.getPassword().length() > 20){
			return "密码不合格！";
		}
		return result;
	}

	@Action(value = "")
	public String execute() {
		Tester.markHere("Login.execute");
		
		//是否是已登录用户想要退出
		if(message != null && message.equals("quit")){
			message = "";
			
			int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
			Admin admin = ((Admin)ActionContext.getContext().getSession().get("adminLogined"));
			if(admin == null){
				//清除cookies
				String result = userCookieManager.deleteOne(userId);
				if(result.equals(Values.SUCCESS) == false){
					message = "Cookies清除失败！";
				}	
			}
			
			//清除session
			ActionContext.getContext().getSession().remove("userLogined");
			ActionContext.getContext().getSession().remove("floatMessage");
			
			return "view";
		}
		
		String result = verifyExecute(); 
		if(!result.equals(Values.SUCCESS)){
			message = result;
			return "failureLoginError";
		}
		
		//验证登录合法性
		User userLogined = userManager.login(user);
		if(userLogined != null){
			Tester.markHere("userLogined != null");
			//登录合法，将用户编号存入session做标记
			ActionContext.getContext().getSession().put("userLogined", userLogined);
			
			//看是否需要自动登录
			if(autoLogin != null && autoLogin.equals("Yes")){
				String userId = userLogined.getUserId() + "";
				String sessionId = ServletActionContext.getRequest().getSession().getId();
				Cookie ckUserId = new Cookie("userId", userId);
				Cookie ckSessionId = new Cookie("sessionId", sessionId);
				ckUserId.setMaxAge(60*60*24*30);
				ckSessionId.setMaxAge(60*60*24*30);
				ServletActionContext.getResponse().addCookie(ckUserId);
				ServletActionContext.getResponse().addCookie(ckSessionId);
				String result1 = userCookieManager.createOne(userId, sessionId);
				if(result1.equals(Values.SUCCESS) == false){
					message = "自动登录设置失败！";
				}
			}
			return "success";
		}else{
			Tester.markHere("else");
			//登录失败
			message = "账号或密码输入有错误！";
			return "failureLoginError";
		}
		
	}
	
	public String regSucc() {
		ActionContext.getContext().put("message", "恭喜您注册成功，请登录！");
		return "view";
	}
	

	
}
