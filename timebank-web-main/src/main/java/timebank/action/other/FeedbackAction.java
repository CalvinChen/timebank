package timebank.action.other;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import timebank.business.other.FeedbackManager;
import timebank.business.user.UserManager;
import timebank.model.suggestion.UserSuggestion;
import timebank.model.user.User;
import timebank.util.Convertor;
import timebank.util.Tester;
import timebank.util.bean.Values;

import com.opensymphony.xwork2.ActionContext;

@Controller
public class FeedbackAction {
	@Resource
	private FeedbackManager feedbackManager;
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
	 * @return the feedbackManager
	 */
	public FeedbackManager getFeedbackManager() {
		return feedbackManager;
	}

	/**
	 * @param feedbackManager the feedbackManager to set
	 */
	public void setFeedbackManager(FeedbackManager feedbackManager) {
		this.feedbackManager = feedbackManager;
	}

	private timebank.model.suggestion.UserSuggestion feedback;
	private ArrayList<UserSuggestion> feedbackList;
	private String message;
	private int getFeedbackId;
	private User user;
	private File picture;
	private String pictureFileName;
	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public int getGetFeedbackId() {
		return getFeedbackId;
	}

	public void setGetFeedbackId(int getFeedbackId) {
		this.getFeedbackId = getFeedbackId;
	}

	public ArrayList<UserSuggestion> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(ArrayList<UserSuggestion> feedbackList) {
		this.feedbackList = feedbackList;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public timebank.model.suggestion.UserSuggestion getFeedback() {
		return feedback;
	}

	public void setFeedback(timebank.model.suggestion.UserSuggestion feedback) {
		this.feedback = feedback;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String view(){
		getUserFromUserLogined();
		return "view";
	}
	
	public String viewList(){
		user = (User)ActionContext.getContext().getSession().get("userLogined");
		int userId = user.getUserId();
		feedbackList = feedbackManager.getFeedbackListByUserId(userId);
		return "viewList";
	}
	
	public String viewOne(){
		getUserFromUserLogined();
		feedback = feedbackManager.getFeedbackRecordById(getFeedbackId, user.getUserId());
		return "viewOne";
	}
	
	private boolean verifySubmit(){
		if(feedback.getTitle() == null || feedback.getTitle().length() < 2
						|| feedback.getTitle().length() > 20){
			message = "主题填写不符合要求！";
			getUserFromUserLogined();
			return false;
		}
//		if(feedback.getFeedbackContent() == null || feedback.getFeedbackContent().length() < 2
//						|| feedback.getFeedbackContent().length() > 5000){
//			message = "内容填写不符合要求！";
//			getUserFromUserLogined();
//			return false;
//		}
		return true;
	}
	

	private void getUserFromUserLogined() {
		user = (User) ActionContext.getContext().getSession()
				.get("userLogined");
		String username = user.getUsername();
		user = userManager.getUserInfo(user.getUserId());
		user.setUsername(username);
	}
	
	public String submit(){
		if(verifySubmit() == false){
			return "view";
		}
		
		if (picture != null) {
			Tester.markHere(picture.getAbsolutePath());
			try {
				String savedDirectory = "/Photo/Feedback/"; // 准备存放图片的保存目录
				Date date = new Date();//构成文件名的日期时间
				Random r = new Random();//构成文件名的随机数
				String fileName = Convertor.changeTimeStamp(date) + r.nextInt(1000);//文件的名字
				String ext = pictureFileName.substring(pictureFileName.lastIndexOf("."));//图片文件的后缀
				String fileNameAll = "/TimeBank" + savedDirectory + fileName + ext;
				Tester.markHere(fileNameAll);
				
				String realpath = ServletActionContext.getServletContext().getRealPath(savedDirectory) + "/" +fileName + ext;
				
				Tester.markHere(realpath);
				File savedFile = new File(realpath);
				FileUtils.copyFile(picture, savedFile);
				feedback.setRelatedPicture(fileNameAll);
			} catch (java.lang.SecurityException e) { // 捕获上传非法文件时抛出的异常
				Tester.markHere(e.toString());
				message = "截图上传失败！上传的图片类型只允许为：jpa,gif,bmp,jpeg。";
			} catch (Exception e) {
				Tester.markHere(e.toString());
				message = "截图上传失败！";
			}
		}
		String result = Values.FAILURE;
		if(message == null || message.trim().length() == 0){
			User user = (User)ActionContext.getContext().getSession().get("userLogined");
//			result = feedbackManager.addFeedbackRecord(user.getUserId(), 
//				feedback.getTitle(), 
////				feedback.getFeedbackContent(),
//				feedback.getRelatedPicture());
		}
		
		if(result.equals(Values.SUCCESS)){
			feedback = null;
			message = "提交成功，感谢您的反馈！";
		}else{
			message = "提交失败！";
		}
		getUserFromUserLogined();
		return "view";
	}
}
