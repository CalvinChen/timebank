package tk.persistence;

import java.util.ArrayList;

import timebank.model.message.UserMessageFromSystem;

public interface MessageDao {

	/**
	 * 向数据库中新增一则消息
	 * @param one
	 * @return
	 */
	public abstract String createOne(UserMessageFromSystem one);

	/**
	 * 根据one的messageId更新文章内容
	 * @param one
	 * @return
	 */
	public abstract String updateOne(UserMessageFromSystem one);

	/**
	 * 根据message的ID读取消息
	 * @param messageId
	 * @return
	 */
	public abstract UserMessageFromSystem readOneById(int messageId);

	/**
	 * 根据message的ID删除消息
	 * @param messageId
	 * @return
	 */
	public abstract String deleteOne(int messageId);

	/**
	 * 根据message的ID读取消息，读出所有的草稿
	 * @param messageId
	 * @return
	 */
	public abstract ArrayList<UserMessageFromSystem> readAllTemplate();

	/**
	 * @return
	 */
	public abstract int readCountUnreadByIdByType(int isRead, int userId,
			int type);

	/**
	 * @return
	 */
	public abstract int readCountIsRead(int isRead, int type);

	/**
	 * @param userId
	 * @return
	 */
	public abstract ArrayList<UserMessageFromSystem> readSomeByOwnerId(int userId);

	/**
	 * @param isRead
	 */
	public abstract String updateOneIsRead(int mid, int isRead);

}