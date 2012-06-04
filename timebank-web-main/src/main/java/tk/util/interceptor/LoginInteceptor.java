package tk.util.interceptor;


import timebank.model.user.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInteceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		if(user != null){
			return invocation.invoke();
		}else{
			ActionContext.getContext().getSession().put("messageLoginedFailure", "请登录之后再访问相关页面！");
			return "failureUnlogin";
		}
	}

}
