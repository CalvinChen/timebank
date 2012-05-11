package timebank.action.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import timebank.business.bank.BankInfoManager;
import timebank.business.bank.HelpRecordManager;
import timebank.business.other.MessageManager;
import timebank.business.user.UserManager;
import timebank.model.bank.BankCompleteRecord;
import timebank.model.message.UserMessageFromSystem;
import timebank.model.user.User;
import timebank.util.Convertor;
import timebank.util.Methods;
import timebank.util.Tester;
import timebank.util.bean.Values;

@Controller
public class HomepageAction {
	@Resource
	private HelpRecordManager helpRecordManager;
	@Resource
	private BankInfoManager bankInfoManager;
	@Resource
	private MessageManager messageManager;
	@Resource
	private UserManager userManager;
	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}
	/**
	 * @param userManager the userManager to set
	 */
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	/**
	 * @return the messageManager
	 */
	public MessageManager getMessageManager() {
		return messageManager;
	}
	/**
	 * @param messageManager the messageManager to set
	 */
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}
	/**
	 * @return the bankInfoManager
	 */
	public BankInfoManager getBankInfoManager() {
		return bankInfoManager;
	}
	/**
	 * @param bankInfoManager the bankInfoManager to set
	 */
	public void setBankInfoManager(BankInfoManager bankInfoManager) {
		this.bankInfoManager = bankInfoManager;
	}
	/**
	 * @return the helpRecordManager
	 */
	public HelpRecordManager getHelpRecordManager() {
		return helpRecordManager;
	}
	/**
	 * @param helpRecordManager the helpRecordManager to set
	 */
	public void setHelpRecordManager(HelpRecordManager helpRecordManager) {
		this.helpRecordManager = helpRecordManager;
	}
	private User user;
	private String message;
	private String target;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm;
	private File picture;
	private String pictureFileName;
	private double balance;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public File getPicture() {return picture;}
	public void setPicture(File picture) {this.picture = picture;}
	public String getPictureFileName() {return pictureFileName;}
	public void setPictureFileName(String pictureFileName) {this.pictureFileName = pictureFileName;}
	public String getOldPassword() {return oldPassword;}
	public void setOldPassword(String oldPassword) {this.oldPassword = oldPassword;}
	public String getNewPassword() {return newPassword;}
	public void setNewPassword(String newPassword) {this.newPassword = newPassword;}
	public String getNewPasswordConfirm() {return newPasswordConfirm;}
	public void setNewPasswordConfirm(String newPasswordConfirm) {this.newPasswordConfirm = newPasswordConfirm;}
	public String getTarget() {return target;}
	public void setTarget(String target) {this.target = target;}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
		//--------------------viewRecords---------------------------
	private ArrayList<BankCompleteRecord> list;
	public ArrayList<BankCompleteRecord> getList() {return list;}
	public void setList(ArrayList<BankCompleteRecord> list) {this.list = list;}
	
	//-----------------------viewOne-----------------------
	private int recordId;
	private BankCompleteRecord one;
	private User userHelped;
	private User userToHelp;

	public User getUserHelped() {return userHelped;}
	public void setUserHelped(User userHelped) {this.userHelped = userHelped;}
	public User getUserToHelp() {return userToHelp;}
	public void setUserToHelp(User userToHelp) {this.userToHelp = userToHelp;}
	public int getRecordId() {return recordId;}
	public void setRecordId(int recordId) {this.recordId = recordId;}
	public BankCompleteRecord getOne() {return one;}
	public void setOne(BankCompleteRecord one) {this.one = one;}

	//------------------------viewMessage------------------------------------------
	private int count;
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	private ArrayList<UserMessageFromSystem> myMessages;	
	public ArrayList<UserMessageFromSystem> getMyMessages() {return myMessages;}
	public void setMyMessages(ArrayList<UserMessageFromSystem> myMessages) {this.myMessages = myMessages;}
	//------------------------viewOneMsg--------------------------------------------
	private int mid;
	public int getMid() {return mid;}
	public void setMid(int mid) {this.mid = mid;}
	private UserMessageFromSystem oneMsg;
	public UserMessageFromSystem getOneMsg() {return oneMsg;}
	public void setOneMsg(UserMessageFromSystem oneMsg) {this.oneMsg = oneMsg;}
	//------------------------getter and setter-------------------------------------
	public String view() {
		Tester.markHere("Homepage.view");
		getUserFromUserLogined();
		if (user != null) {
			long percentage = Methods.getUserInfoPercentage(user);
			ActionContext.getContext().getSession().put("percentage",
					percentage);
			return "success";
		} else {
			return "failure";
		}
	}

	private void getUserFromUserLogined() {
		user = (User) ActionContext.getContext().getSession().get("userLogined");
		balance = bankInfoManager.getBalanceByUserId(user.getUserId());
	}

	public String viewPic() {
		getUserFromUserLogined();
		return "viewPic";
	}

	public String viewInfo() {
		getUserFromUserLogined();
		return "viewInfo";
	}

	public String viewContact() {
		getUserFromUserLogined();
		return "viewContact";
	}

	public String viewPSW() {
		getUserFromUserLogined();
		return "viewPSW";
	}

	public String viewMessage(){
		User user = ((User)ActionContext.getContext().getSession().get("userLogined"));
		myMessages = messageManager.getOnesMessage(user.getUserId());
		getUnreadMsgCount();
		return "viewMessage";
	}
	/**
	 * @param user
	 */
	private void getUnreadMsgCount() {
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		int[] counti = messageManager.getUnreadCountByUserId(userId);
		if(counti != null){count = 0;
			for (int i = 0; i < counti.length; i++) {
				count += counti[i];
			}	
		}
	}
	
	public String viewOneMsg(){
		oneMsg = messageManager.getOneById(mid);
//		if(oneMsg.getIsRead() == Values.NO){
//			String result = messageManager.setOneRead(mid);
//			if(result.equals(Values.SUCCESS) == false){
//				Tester.markHere("setOneRead failure!");
//			}
//			int[] list = (int[])ActionContext.getContext().getSession().get("floatMessage");
//			if(oneMsg.getType() == Values.MSG_NOTICE){
//				list[Values.MSG_NOTICE]--;
//			}
//			if(oneMsg.getType() == Values.MSG_MESSAGE){
//				list[Values.MSG_MESSAGE]--;
//			}
//			ActionContext.getContext().getSession().put("floatMessage", list);	
//		}
		getUnreadMsgCount();
		return "viewOneMsg";
	}
	
	public String verifyInfoSubmit(){
		
		if (target.equals("info")) {
			
		} else if (target.equals("contact")) {
			if(user.getUserInfo().getWeiboUrl() != null && user.getUserInfo().getWeiboUrl().trim().length() != 0){
				if(user.getUserInfo().getWeiboUrl().startsWith("http://weibo.com/") == false && 
						user.getUserInfo().getWeiboUrl().startsWith("http://t.qq.com/") == false ){
					return "微博填写方式请参照提示填写！";
				}
			}
		} else if (target.equals("PSW")) {
			
		}
		return Values.SUCCESS;
	}
	
	public String infoSubmit() {
		Tester.markHere("=infoSubmit");
		String result1 = verifyInfoSubmit();
		if(result1.equals(Values.SUCCESS) == false){
			message = result1;
			if (target.equals("info")) {
				return "viewInfo";
			} else if (target.equals("contact")) {
				return "viewContact";
			} else if (target.equals("PSW")) {
				return "viewPSW";
			} else
				return "success";
		}
		String result = Values.FAILURE;
		if (target.equals("info")) {
			result = userManager.updateUserInfoByUserId(user);
		} else if (target.equals("contact")) {
			result = userManager.updateUserContactByUserId(user);
		} else if (target.equals("PSW")) {
			if (newPassword.equals(newPasswordConfirm)) {
				user.setPassword(newPassword);
				result = userManager.updateUserPSWByUserId(user, oldPassword);
			} else {
				message = "新密码两次输入不一致。";
				return "viewPSW";
			}
		}

		if (result.equals(Values.SUCCESS)) {
			Tester.markHere("result == true");
			Tester.markHere("newPassword:" + newPassword);
			User userLogined = (User) ActionContext.getContext().getSession()
					.get("userLogined");
			if (target.equals("PSW")) {
				userLogined.setPassword(newPassword);
			}
			userLogined = userManager.login(userLogined);
			ActionContext.getContext().getSession().put("userLogined",
					userLogined);
			getUserFromUserLogined();
			long percentage = Methods.getUserInfoPercentage(user);
			ActionContext.getContext().getSession().put("percentage",
					percentage);
			message = "更新成功！";
		} else {
			Tester.markHere("else");
			message = "更新失败！请联系管理员。";
		}

		if (target.equals("info")) {
			return "viewInfo";
		} else if (target.equals("contact")) {
			return "viewContact";
		} else if (target.equals("PSW")) {
			return "viewPSW";
		} else
			return "success";
	}

	public String picSubmit() {
		Tester.markHere("Homepage.picSubmit");
		message = "更新失败！";

		if (picture != null) {
			Tester.markHere(picture.getAbsolutePath());
			try {
				String savedDirectory = "/Photo/User/"; // 准备存放图片的保存目录
				Date date = new Date();//构成文件名的日期时间
				Random r = new Random();//构成文件名的随机数
				String fileName = Convertor.changeTimeStamp(date) + r.nextInt(1000);//文件的名字
				String ext = pictureFileName.substring(pictureFileName.lastIndexOf("."));//图片文件的后缀
				String fileNameAll = "/TimeBank" + savedDirectory + fileName + ext;
				Tester.markHere(fileNameAll);
				
				String realpath = ServletActionContext.getServletContext().getRealPath(savedDirectory) + "/" +fileName + ext;
				
				Tester.markHere(realpath);
				File savedFile = new File(realpath);
				user = (User) ActionContext.getContext().getSession().get("userLogined");
				getUserFromUserLogined();
				UserManager.deleteUserPicture(user.getUserInfo().getUserPhoto());
				boolean result = userManager.updatePhoto(user.getUserId(),	fileNameAll);
				if (result == true) {
					Tester.markHere("result == true");
					// 头像更新成功
					try {

						// 上传文件保存到指定的目录下
						FileUtils.copyFile(picture, savedFile);
						message = "更新成功！";
						Tester.markHere("更新成功！");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (java.lang.SecurityException e) { // 捕获上传非法文件时抛出的异常
				Tester.markHere(e.toString());
				message = "更新失败！上传的图片类型只允许为：jpa,gif,bmp,jpeg。";
			} catch (Exception e) {
				Tester.markHere(e.toString());
				message = "更新失败！";
			}
		}else{
			Tester.markHere("没有选择要上传的文件！");
		}
		getUserFromUserLogined();
		return "viewPic";

	}
	
	/**
	 * 查看“互助记录”页面
	 * @return
	 */
	public String viewRecords(){
		getUserFromUserLogined();
		list = helpRecordManager .readSomeByUid(user.getUserId());
		return "viewRecords";
	}
	
	/**
	 * 查看“查看互助记录”页面
	 * @return
	 */
	public String viewOne(){
		getUserFromUserLogined();
		one = helpRecordManager.readOneById(recordId);
//		userHelped = userManager.getUserInfo(one.getHelpedUserId());
//		userToHelp = userManager.getUserInfo(one.getToHelpUserId());
		return "viewOne";
	}

	/**
	 * 帮助者提交互助反馈
	 * @return
	 */
//	public String toHelpFeedback(){
//		
//		//获得对方的ID，评价对方
//		int userId = helpRecordManager.readOneById(one.getBankCompleteRecordId()).getHelpedUserId();
//		String result = helpRecordManager.updateFBpartById(Values.REQUIRE_BY_TO_HELP, userId, 
//				one.getBankCompleteRecordId(), one.getUserToHelpScore(), one.getUserToHelpFeedback());
//		if(result.equals(Values.SUCCESS)){
//			message = "提交成功！感谢您的反馈。";
//		}else{
//			message = "提交失败！请联系我们。";
//		}
//		getUserFromUserLogined();
//		one = helpRecordManager.readOneById(one.getBankCompleteRecordId());
//		userHelped = userManager.getUserInfo(one.getHelpedUserId());
//		userToHelp = userManager.getUserInfo(one.getToHelpUserId());
//		return "viewOne";
//	}
	/**
	 * 求助者提交互助反馈
	 * @return
	 */
//	public String helpedFeedback(){
//		
//		//获得对方ID，评价对方
//		int userId = helpRecordManager.readOneById(one.getBankCompleteRecordId()).getToHelpUserId();
//		String result = helpRecordManager.updateFBpartById(Values.REQUIRE_BY_HELPED, userId,
//				one.getBankCompleteRecordId(), one.getUserHelpedScore(), one.getUserHelpedFeedback());
//		if(result.equals(Values.SUCCESS)){
//			message = "提交成功！感谢您的反馈。";
//		}else{
//			message = "提交失败！请联系我们。";
//		}
//		getUserFromUserLogined();
//		one = helpRecordManager.readOneById(one.getBankCompleteRecordId());
//		userHelped = userManager.getUserInfo(one.getHelpedUserId());
//		userToHelp = userManager.getUserInfo(one.getToHelpUserId());
//		return "viewOne";
//	}
	
	/**
	 * 任何一方提交互助失败反馈
	 * @return
	 */
//	public String helpFailed(){
//		String result = helpRecordManager.updateFailPartById(one.getBankCompleteRecordId(), one.getWhyFailure(), one.getFailureBy());
//		if(result.equals(Values.SUCCESS)){
//			message = "提交成功！感谢您的反馈。";
//		}else{
//			message = "提交失败！请联系我们。";
//		}
//		getUserFromUserLogined();
//		one = helpRecordManager.readOneById(one.getBankCompleteRecordId());
//		userHelped = userManager.getUserInfo(one.getHelpedUserId());
//		userToHelp = userManager.getUserInfo(one.getToHelpUserId());
//		return "viewOne";
//	}
}
