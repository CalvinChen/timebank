package tk.util.interceptor;

import timebank.model.admin.Admin;
import timebank.model.user.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginAdminInteceptor implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Admin admin = (Admin)ActionContext.getContext().getSession().get("adminLogined");
		if(admin != null){
			return invocation.invoke();
		}else{
			return "failureUnlogin";
		}
	}

}
