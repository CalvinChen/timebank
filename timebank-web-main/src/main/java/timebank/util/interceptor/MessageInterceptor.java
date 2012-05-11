package timebank.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import timebank.business.other.MessageManager;
import timebank.model.user.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MessageInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		if(user != null){
			int[] list = new MessageManager().getUnreadCountByUserId(user.getUserId());
			ActionContext.getContext().getSession().put("floatMessage", list);	
		}
		return invocation.invoke();
	}

}
