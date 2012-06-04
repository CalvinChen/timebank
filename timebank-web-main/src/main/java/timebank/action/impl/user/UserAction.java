package timebank.action.impl.user;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.json.annotations.JSONFieldBridge;
import org.apache.struts2.json.annotations.JSONParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.action.impl.IndexAction;
import timebank.action.user.IUserAction;
import timebank.business.user.IUserManager;
import timebank.model.user.User;
import timebank.util.lang.bean.Message;
import timebank.util.lang.exception.NoSuchUserException;
import timebank.util.lang.exception.PasswordConfirmException;
import timebank.util.web.action.ActionUtil;

@Namespace(value = "/user")
@ParentPackage(value = "json-default")
@Results(value = {
		@Result(name = IndexAction.INDEX, location = IndexAction.INDEX_LOCATION),
		@Result(name = UserAction.REGISTER, location = UserAction.REGISTER_LOCATION),
		@Result(name = UserAction.INDEX_ACTION, location = UserAction.INDEX_ACTION_LOCATION,
				type = "redirectAction"),
		@Result(name = UserAction.CHECK_RESULT, type = "json")
})
@Controller
public class UserAction implements IUserAction {

	public static final String REGISTER = "register";
	public static final String REGISTER_LOCATION = "/view/user/login/register.jsp";
	
	public static final String INDEX_ACTION = "indexAction";
	public static final String INDEX_ACTION_LOCATION = "../" + IndexAction.INDEX;
	
	public static final String CHECK_RESULT = "checkResult"; 
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	@Resource
	private IUserManager userManager;
	
	private UserForm form;
	
	private Message message;
	
	@Action(value = "register")
	public String register(){
		message = ActionUtil.removeMessage();
		return REGISTER;
	}
	
	@Action(value = "submitRegister")
	public String submitRegister(){
		try {
			userManager.register(form.getUser(), form.getPasswordConfirm());
		} catch (PasswordConfirmException e) {
			ActionUtil.set(new Message(Message.FAILURE, "两次密码输入不一致！"));
			return REGISTER;
		} catch (Exception e) {
			ActionUtil.set(new Message(Message.FAILURE, "注册失败！请稍后再试。"));
			return REGISTER;
		}
		ActionUtil.set(new Message(Message.SUCCESS, "注册成功！请登录。"));
		return INDEX_ACTION;
	}
	
	@Action(value = "submitLogin")
	@Override
	public String submitLogin() {
		try {
			User user = userManager.login(form.getUser(), form.isAddCookie());
			ActionUtil.setCurrentUser(user);
			ActionUtil.set(new Message(Message.SUCCESS, "登录成功！欢迎。"));
			return INDEX_ACTION;
		} catch(NoSuchUserException e){
			ActionUtil.set(new Message(Message.FAILURE, "登录失败！账户名或密码有误。"));
			return INDEX_ACTION;
		}
	}
	
	@Action(value = "quit")
	@Override
	public String quit(){
		ActionUtil.removeCurrentUser();
		return INDEX_ACTION;
	}

	@Override
	@Action(value = "checkEmailDuplicate")
	public String checkEmailDuplicate() {
		String email = form.getUser().getLoginName();
		boolean result = userManager.checkEmailDuplicate(email);
		form.setCheckDuplicateResult(result);
		return CHECK_RESULT;
	}
	
	@Override
	@Action(value = "checkDisplayNameDuplicate")
	public String checkDisplayNameDuplicate() {
		String displayName = form.getUser().getDisplayName();
		try {
			displayName = new String(displayName.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.debug("The display name to be checked is {}", displayName);
		boolean result = userManager.checkDisplayNameDuplicate(displayName);
		form.setCheckDuplicateResult(result);
		return CHECK_RESULT;
	}

	@JSON(serialize = false)
	public IUserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}

	@JSON(serialize = true)
	public UserForm getForm() {
		return form;
	}

	public void setForm(UserForm form) {
		this.form = form;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
