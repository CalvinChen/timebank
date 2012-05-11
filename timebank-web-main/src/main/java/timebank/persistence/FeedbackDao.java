package timebank.persistence;

import java.util.ArrayList;

import timebank.model.suggestion.UserSuggestion;

public interface FeedbackDao {

	/**
	 * 获得所有已经处理了的反馈信息
	 * @param p 
	 * @return 所有已处理反馈信息
	 */
	public abstract ArrayList<UserSuggestion> readSomeByIsHandledLimit(
			int isHandled, int p);

	/**
	 * 获得是否处理了的反馈信息的总数
	 * @return 总数
	 */
	public abstract int readCountByIsHandled(int isHandled);

	/**
	 * 获得今天是否处理了的反馈信息的总数
	 * @return 总数
	 */
	public abstract int readTodayCountByIsHandled(int isHandled);

	/**
	 * 管理员回复反馈
	 * @param feedbackId 该条反馈的编号
	 * @param adminId 管理员的编号
	 * @param answerContent 回复的内容
	 * @return 回复结果
	 */
	public abstract String updateOne(int feedbackId, int adminId,
			String answerContent);

	/**
	 * 增加一条反馈信息
	 * @param userId 反馈用户的编号
	 * @param feedbackTitle 反馈的标题
	 * @param feedbackContent 反馈的内容
	 * @param feedbackPicture 反馈的截图
	 * @return 反馈提交的结果
	 */
	public abstract String createOne(int userId, String feedbackTitle,
			String feedbackContent, String feedbackPicture);

	/**
	 * 获得某个用户的所有反馈历史
	 * @param userId 该用户的编号
	 * @return 该用户的所有反馈历史
	 */
	public abstract ArrayList<UserSuggestion> readSomeByUserId(int userId);

	/**
	 * 根据反馈ID获得某条反馈的相关信息
	 * @param getFeedbackId 该条反馈的编号
	 * @return 该条反馈的相关信息
	 */
	public abstract UserSuggestion readOneById(int getFeedbackId);

}