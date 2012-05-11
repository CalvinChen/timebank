package timebank.util.interceptor;


import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import timebank.business.admin.AdminManager;
import timebank.business.admin.AdminCookieManager;
import timebank.business.user.UserCookieManager;
import timebank.business.user.UserManager;
import timebank.model.admin.Admin;
import timebank.model.cookie.CookieAdmin;
import timebank.model.cookie.CookieUser;
import timebank.model.user.User;
import timebank.util.CookieUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AutoLoginInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		User user = ((User)ActionContext.getContext().getSession().get("userLogined"));
		if(user == null){
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if(cookies != null){
				String userId = new CookieUtil().getValueByName("userId", cookies);
				String sessionId = new CookieUtil().getValueByName("sessionId", cookies);
				CookieUser one = null;
				if(userId != null && sessionId != null){
					one = new UserCookieManager().readOne(userId, sessionId);
					if(one != null){
						user = new UserManager().getUserInfo(Integer.parseInt(userId));
						if(user != null){
							ActionContext.getContext().getSession().put("userLogined", user);
						}
					}
				}
			}
		}
		Admin admin = ((Admin)ActionContext.getContext().getSession().get("adminLogined"));
		if(admin == null){
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if(cookies != null){
				String adminId = new CookieUtil().getValueByName("adminId", cookies);
				String adminSessionId = new CookieUtil().getValueByName("adminSessionId", cookies);
				CookieAdmin one = null;
				if(adminId != null && adminSessionId != null){
					one = new AdminCookieManager().readOne(adminId, adminSessionId);
					if(one != null){
						admin = new AdminManager().readOne(Integer.parseInt(adminId));
						if(admin != null){
							ActionContext.getContext().getSession().put("adminLogined", admin);
						}
					}
				}
			}
		}
		return invocation.invoke();
	}

}
