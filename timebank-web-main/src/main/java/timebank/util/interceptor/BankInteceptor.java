package timebank.util.interceptor;

import timebank.business.user.UserManager;
import timebank.model.user.User;
import timebank.util.bean.Values;

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
			user = new UserManager().getUserInfo(user.getUserId());
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
