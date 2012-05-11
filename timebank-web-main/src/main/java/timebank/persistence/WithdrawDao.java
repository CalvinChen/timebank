package timebank.persistence;

import java.util.ArrayList;

import timebank.model.WithdrawRecord;

public interface WithdrawDao {

	/**
	 * 将一条提取记录的状态改变为指定的状态
	 * @param withdrawId 该条提取记录的编号 
	 * @param status 要将之改变成的状态
	 * @return 更新的结果
	 */
	public abstract String updateStatusById(int withdrawId, int status);

	public abstract String updateSeekLeftById(int withdrawId, int seekLeft);

	public abstract String updateSeekNumberById(int withdrawId, int seekNumber);

	public abstract String updateModesById(int withdrawId, int mode,
			int seekLeft, int seekNumber);

	/**
	 * 将一条提取记录的状态改变为指定的状态
	 * @param withdrawId 该条提取记录的编号 
	 * @param status 要将之改变成的状态
	 * @return 更新的结果
	 */
	public abstract String updateOneById(WithdrawRecord one);

	/**
	 * 根据提取编号取出一条提取记录
	 * @param withdrawId 提取编号
	 * @return 提取记录
	 */
	public abstract WithdrawRecord readOneById(int withdrawId);

	/**
	 * 获得某个用户所有的存储记录
	 * @param userId 该用户的用户编号
	 * @return 该用户所有的存储记录表
	 */
	public abstract ArrayList<WithdrawRecord> readSomeByUserId(int userId);

	/**
	 * 获得所有未配对的提取记录
	 * @param p 
	 * @return 数据库中所有未配对的提取记录
	 */
	public abstract ArrayList<WithdrawRecord> readSomeByIsMatched(
			int isMatched, int p);

	/**
	 * 增加一条用户的预提取记录
	 * @param one 预提取记录的详细内容
	 * @param userId 用户的编号
	 * @return 增加的结果
	 */
	public abstract String createOne(WithdrawRecord one);

	/**
	 * @param status
	 * @return
	 */
	public abstract ArrayList<WithdrawRecord> readSomeByStatus(int status);

	/**
	 * @param status
	 * @return
	 */
	public abstract ArrayList<WithdrawRecord> readSomeByStatusLimit(int status,
			int page);

	/**
	 * 根据ID删除一条提取记录
	 * @param wid 提取记录的ID
	 * @return
	 */
	public abstract String deleteOne(int wid);

	/**
	 * 获得今天新的记录
	 * @return 今天记录数
	 */
	public abstract int readTodayNewCount();

	public abstract String updateLinkedById(int withdrawId, int key);

	/**
	 * @param verified
	 * @return
	 */
	public abstract int readCountSomeByStatus(int status);

	public abstract int updateExpired();

	public abstract int updateNotExpired();

	/**
	 * @param status
	 * @param yes
	 * @param yes2
	 * @return
	 */
	public abstract ArrayList<WithdrawRecord> getDisplayWithdrawsByStatus(
			int status, int isToTop, int isDetailed);

	/**
	 * @param status
	 * @param no
	 * @param no2
	 * @param p
	 * @return
	 */
	public abstract ArrayList<WithdrawRecord> getDisplayWithdrawsByStatusLimit(
			int status, int isToTop, int isDetailed, int p);

	/**
	 * @param status
	 * @param no
	 * @param yes
	 * @return
	 */
	public abstract int getCountDisplayWithdrawsByStatus(int status,
			int isToTop, int isDetailed);

}