package tk.business.other;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.WithdrawRecord;
import timebank.model.suggestion.UserSuggestion;
import timebank.persistence.user.UserDao;
import tk.persistence.AdminDao;
import tk.persistence.FeedbackDao;
import tk.persistence.impl.jdbc.BankInfoDaoImpl;
import tk.util.bean.Values;

@Service
public class FeedbackManager {

//	@Resource
	private FeedbackDao feedbackDao;
	@Resource
	private UserDao userDao;
//	@Resource
	private AdminDao adminDao;

	/**
	 * @return the feedbackDao
	 */
	public FeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	/**
	 * @param feedbackDao the feedbackDao to set
	 */
	public void setFeedbackDao(FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the adminDao
	 */
	public AdminDao getAdminDao() {
		return adminDao;
	}

	/**
	 * @param adminDao the adminDao to set
	 */
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public String addFeedbackRecord(int userId, String feedbackTitle,
			String feedbackContent, String feedbackPicture) {
		return feedbackDao.createOne(userId, feedbackTitle, feedbackContent, feedbackPicture);
	}

	public ArrayList<UserSuggestion> getFeedbackListByUserId(int userId) {
		ArrayList<UserSuggestion> list = feedbackDao.readSomeByUserId(userId);
		UserSuggestion one = null;
		for(int i = 0; i < list.size(); i++){
			one = list.get(i);
//			one.setRelatedPicture(userDao.readPhotoById(one.getUserId()));
		}
		return list;
	}

	public UserSuggestion getFeedbackRecordById(int getFeedbackId, int userId) {
		UserSuggestion fbr = feedbackDao.readOneById(getFeedbackId);
		if(fbr.getSuggestUser().getId() != userId){
			return null;
		}else{
			return fbr;
		}
	}

	/**
	 * 根据反馈ID获得某条反馈的相关信息
	 * @param feedbackId 该条反馈的编号
	 * @return 该条反馈的相关信息
	 */
	public UserSuggestion getFeedbackRecordById(int feedbackId) {
		UserSuggestion fbr =  feedbackDao.readOneById(feedbackId);
//		String username =  userDao.readUsernameByUserId(fbr.getUserId());
//		username =  adminDao .readUsernameById(fbr.getAdminId());
//		fbr.setAdminUsername(username);
		return fbr;
	}

	/**
	 * 获得所有已经处理了的反馈信息
	 * @param p 
	 * @return 所有已处理反馈信息
	 */
	public ArrayList<UserSuggestion> getHandledFeedbackList(int p) {
		ArrayList<UserSuggestion> list =  feedbackDao.readSomeByIsHandledLimit(Values.FEEDBACK_HANDLED, p);
		UserSuggestion one = null;
		for(int i = 0; i < list.size(); i++){
			one = list.get(i);
//			one.setRelatedPicture( userDao.readPhotoById(one.getUserId()));
		}
		return list;
	}

	/**
	 * 获得所有未处理的反馈信息
	 * @return 所有未处理的反馈信息
	 */
	public ArrayList<UserSuggestion> getUnhandleFeedbackList(int p) {
		ArrayList<UserSuggestion> list = feedbackDao.readSomeByIsHandledLimit(Values.FEEDBACK_NOT_HANDLED, p);
		UserSuggestion one = null;
		for(int i = 0; i < list.size(); i++){
			one = list.get(i);
//			one.setRelatedPicture( userDao.readPhotoById(one.getUserId()));
		}
		return list;
	}

	/**
	 * 管理员回复反馈
	 * @param feedbackId 该条反馈的编号
	 * @param adminId  管理员的编号
	 * @param answerContent  回复的内容
	 * @return 回复结果
	 */
	public String commentFeedback(int feedbackId, int adminId,
			String answerContent) {
		return feedbackDao.updateOne(feedbackId, adminId, answerContent);
	}

	/**
	 * 获得是否处理了的反馈信息的总数
	 * @return 总数
	 */
	public int readCountByIsHandled(int isHandled) {
		return feedbackDao.readCountByIsHandled(isHandled);
	}

	/**
	 * 获得今天是否处理了的反馈信息的总数
	 * @return 总数
	 */
	public int readTodayCountByIsHandled(int isHandled) {
		return feedbackDao.readTodayCountByIsHandled(isHandled);
	}
}
