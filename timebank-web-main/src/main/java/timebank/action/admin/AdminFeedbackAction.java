package timebank.action.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.admin.AdminManager;
import timebank.business.other.FeedbackManager;
import timebank.business.user.UserManager;
import timebank.model.admin.Admin;
import timebank.model.suggestion.UserSuggestion;
import timebank.model.user.User;
import timebank.util.Methods;
import timebank.util.bean.Values;

@Namespace(value = "/admin/feedback")
@Results(value = {
		@Result(name = "index", location = "/view/admin/feedback/index.jsp"),
		@Result(name = "list_unhandle", location = "/view/admin/feedback/list_unhandle.jsp"),
		@Result(name = "list", location = "/view/admin/feedback/list.jsp"),
		@Result(name = "view", location = "/view/admin/feedback/view.jsp")
})
@Controller
public class AdminFeedbackAction {
	@Resource
	private FeedbackManager feedbackManager;
	@Resource
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public FeedbackManager getFeedbackManager() {
		return feedbackManager;
	}
	public void setFeedbackManager(FeedbackManager feedbackManager) {
		this.feedbackManager = feedbackManager;
	}

	private ArrayList<UserSuggestion> unhandleFeedbackList;
	private ArrayList<UserSuggestion> handledFeedbackList;
	private UserSuggestion feedback;
	private User user;
	private String message;
	private int todayHandOn;
	private int todayReply;
	private int allHandOn;
	private int allReply;
	private int allUnhandle;
	private int p;
	private int pages;
	
	public int getAllUnhandle() {
		return allUnhandle;
	}
	public void setAllUnhandle(int allUnhandle) {
		this.allUnhandle = allUnhandle;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getAllHandOn() {
		return allHandOn;
	}
	public void setAllHandOn(int allHandOn) {
		this.allHandOn = allHandOn;
	}
	public int getAllReply() {
		return allReply;
	}
	public void setAllReply(int allReply) {
		this.allReply = allReply;
	}
	public int getTodayHandOn() {
		return todayHandOn;
	}
	public void setTodayHandOn(int todayHandOn) {
		this.todayHandOn = todayHandOn;
	}
	public int getTodayReply() {
		return todayReply;
	}
	public void setTodayReply(int todayReply) {
		this.todayReply = todayReply;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserSuggestion getFeedback() {
		return feedback;
	}
	public void setFeedback(UserSuggestion feedback) {
		this.feedback = feedback;
	}
	private int feedbackId;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public ArrayList<UserSuggestion> getHandledFeedbackList() {
		return handledFeedbackList;
	}
	public void setHandledFeedbackList(ArrayList<UserSuggestion> handledFeedbackList) {
		this.handledFeedbackList = handledFeedbackList;
	}

	public ArrayList<UserSuggestion> getUnhandleFeedbackList() {
		return unhandleFeedbackList;
	}

	public void setUnhandleFeedbackList(
			ArrayList<UserSuggestion> unhandleFeedbackList) {
		this.unhandleFeedbackList = unhandleFeedbackList;
	}

	@Action(value = "index")
	public String index(){
		todayReply = feedbackManager.readTodayCountByIsHandled(Values.YES);
		todayHandOn = todayReply + feedbackManager.readTodayCountByIsHandled(Values.NO);
		allReply = feedbackManager.readCountByIsHandled(Values.YES);
		allHandOn = allReply + feedbackManager.readCountByIsHandled(Values.NO);
		return "index";
	}
	
	@Action(value = "list_unhandle")
	public String list_unhandle(){
		p = Methods.correctPage(p);
		unhandleFeedbackList = feedbackManager.getUnhandleFeedbackList(p);
		allUnhandle = feedbackManager.readCountByIsHandled(Values.NO);
		pages = Methods.readPages(allUnhandle);
		return "list_unhandle";
	}
	
	@Action(value = "list")
	public String list(){
		p = Methods.correctPage(p);
		handledFeedbackList = feedbackManager.getHandledFeedbackList(p);
		allReply = feedbackManager.readCountByIsHandled(Values.YES);
		pages = Methods.readPages(allReply);
		return "list";
	}
	
	@Action(value = "view")
	public String view(){
		feedback = feedbackManager.getFeedbackRecordById(feedbackId);
		user = new User();
//		user = userManager.getUserInfo(feedback.getUserId());
		return "view";
	}
	
	public boolean verifySubmit(){
//		String answerContent = feedback.getAnswerContent();
//		if(answerContent == null || answerContent.length() < 2 || answerContent.length() > 500){
//			message = "回复内容太长或太短，请检查！";
//			feedback = feedbackManager.getFeedbackRecordById(feedbackId);
//			feedback.setAnswerContent(answerContent);
//			user = new User();
//			user = userManager.getUserInfo(feedback.getUserId());
//			return false;
//		}
		return true;
	}
	
	@Action(value = "submit")
	public String submit(){
		if(verifySubmit() == false){
			return "view";
		}
		
		Admin admin = (Admin)ActionContext.getContext().getSession().get("adminLogined");
//		String result = feedbackManager.commentFeedback(
//				feedbackId, admin.getAdminId(), feedback.getAnswerContent());
//		if(result.equals("success")){
//			message = "回复成功！";
//		}else{
//			message = "回复失败！";
//		}
//		feedback = feedbackManager.getFeedbackRecordById(feedbackId);
//		user = new User();
//		user = userManager.getUserInfo(feedback.getUserId());
		return "view";
	}
}
