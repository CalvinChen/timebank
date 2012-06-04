package tk.action.other;

import org.springframework.stereotype.Controller;

@Controller
public class ContactAction {
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String view(){
		return "view";
	}
	
	public String forgetPSW(){
		message = "请在下面任选一种联系方式与我们取得联系，以便重置或取回您的密码！";
		return "forgetPSW";
	}
}
