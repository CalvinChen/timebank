package timebank.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.dispatcher.StreamResult;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.user.UserManager;
import timebank.model.user.User;
import timebank.util.Tester;
import timebank.util.Verifier;
import timebank.util.bean.Values;
@Namespace(value = "/user/register")
@Results(value = {
		@Result(name = "index", location = "/view/index.jsp"),
		@Result(name = "register", location = "/view/user/login/register.jsp")
})
@Controller
public class RegisterAction {
	@Resource
	private UserManager userManager;

	/**
	 * an user who want to register.
	 */
	private User user;
	
	private String passwordConfirm;
	private String agree;
	private String message;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * go to the register page
	 */
	@Action(value = "register")
	public String register() {
		System.out.println("go to the register page");
		return "register";
	}
	
	/**
	 * do the register submit.
	 * @throws IOException 
	 */
	@Action(value = "do_register")
	public StreamResult doRegister() throws IOException{
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		writer.write(userManager.registerUser(user).toString());
		writer.close();
		return null;
	}
	
	/**
	 * 转到验证华农学生信息界面
	 * @return
	 */
	public String verify() {
		return "verify";
	}
	
	/**
	 * 处理填写好的验证信息
	 * @return
	 */
	public String verifySubmit() {
		//数据合法性验证
//		if(Verifier.verifyInfo(user.getUserInfo().getTrueName(), user.getStudentId()) == false){
//			message = "输入验证信息不合格！";
//			return "verify";
//		}
//		
		String result = "";
//		result = userManager.verifyInfo(user.getName(), user.getStudentId());
		if(result.equals(Values.SUCCESS)){
			message = "验证成功，请注册！";
			return "reg";
		}else if(result.equals(Values.FAILURE)){
			message = "抱歉，无此学生信息！";
			return "verify";
		}else {
			message = result;
			return "verify";
		}
	}
}
