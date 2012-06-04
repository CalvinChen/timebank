package tk.util.interceptor;

import timebank.model.user.User;
import tk.business.bank.BankInfoManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class GetBalanceInteceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		double balance = new BankInfoManager().getBalanceByUserId(user.getId());
		ActionContext.getContext().getSession().put("balance", balance);
		return invocation.invoke();
	}
}
