package tk.util.interceptor;

import timebank.business.impl.user.UserManagerImpl;
import timebank.model.user.User;
import tk.util.bean.Values;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class BankInteceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		if(user.getIsVerified() == true){//身份验证
			user = new UserManagerImpl().getUserInfo(user.getId());
			if((user.getUserInfo().getPhoneLong() != null && user.getUserInfo().getPhoneLong().trim().length() != 0 ) ||
				(user.getUserInfo().getPhoneShort() !=null && user.getUserInfo().getPhoneShort().trim().length() != 0)){//联系方式不为空
				return invocation.invoke();
			}else{
				return "homepage";
			}
		}else{
			return "homepage";
		}
	}

}
