package tk.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;

import timebank.business.impl.cookie.UserCookieManagerImpl;
import timebank.model.admin.Admin;
import timebank.model.user.User;
import tk.business.admin.AdminCookieManagerImpl;
import tk.business.admin.AdminManager;
import tk.util.Tester;
import tk.util.bean.Values;

import com.opensymphony.xwork2.ActionContext;
@Namespace(value = "/admin/login")
@Controller
public class AdminLoginAction {
	@Resource
	private AdminManager adminManager;
	@Resource
	private AdminCookieManagerImpl adminCookieManager;

	public AdminCookieManagerImpl getAdminCookieManager() {
		return adminCookieManager;
	}
	public void setAdminCookieManager(AdminCookieManagerImpl adminCookieManager) {
		this.adminCookieManager = adminCookieManager;
	}
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	private String message;
	private Admin admin;
	private String autoLogin;
	public String getAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
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

	@Action(value = "login")
	public String login(){
		Tester.markHere("LoginAdmin.login");
		
		//是否是已登录管理员想要退出
		if(message != null && message.equals("quit")){
			message = "";
			int adminId = ((Admin)ActionContext.getContext().getSession().get("adminLogined")).getId();
			//清除cookies
			adminCookieManager.deleteOne(adminId);
			//清除session
			ActionContext.getContext().getSession().remove("adminLogined");
			return "view";
		}
		//验证登录合法性
		Admin adminLogined = adminManager.login(admin);
		if(adminLogined != null){
			Tester.markHere("adminLogined != null");
			//登录合法，将用户编号存入session做标记
			ActionContext.getContext().getSession().put("adminLogined", adminLogined);
			//看是否需要自动登录
			if(autoLogin != null && autoLogin.equals("Yes")){
				String adminId = adminLogined.getId() + "";
				String adminSessionId = ServletActionContext.getRequest().getSession().getId();
				Cookie ckAdminId = new Cookie("adminId", adminId);
				Cookie ckSessionId = new Cookie("adminSessionId", adminSessionId);
				ckAdminId.setMaxAge(60*60*24*30);
				ckSessionId.setMaxAge(60*60*24*30);
				ServletActionContext.getResponse().addCookie(ckAdminId);
				ServletActionContext.getResponse().addCookie(ckSessionId);
				String result1 = adminCookieManager.createOne(adminId, adminSessionId);
				if(result1.equals(Values.SUCCESS) == false){
					message = "自动登录设置失败！";
				}
			}
			return "success";
		}else{
			Tester.markHere("else");
			//登录失败
			message = "您输入的账号或密码有错误，请重新输入！";
			return "failureLoginError";
		}
	}
	
	@Action(value = "view")
	public String view(){
		return "view";
	}
}
