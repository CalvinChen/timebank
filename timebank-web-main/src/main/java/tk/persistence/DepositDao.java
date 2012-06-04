package tk.persistence;

import java.util.ArrayList;

import timebank.model.bank.SideRecord;

public interface DepositDao {

	/**
	 * 根据存储编号取得一条存储记录
	 * @param depositId 存储编号
	 * @return 欲取得的存储记录
	 */
	public abstract SideRecord readOneById(int depositId);

	/**
	 * 将一条存储记录的状态改变为指定的状态
	 * @param depositId 该条存储记录的编号 
	 * @param status 要将之改变成的状态
	 * @return 更新的结果
	 */
	public abstract String updateStatusById(int depositId, int status);

	/**
	 * 更新匹配剩余次数
	 * @param depositId
	 * @param seekLeft
	 * @return
	 */
	public abstract String updateSeekLeftById(int depositId, int seekLeft);

	/**
	 * 更新匹配总次数
	 * @param depositId
	 * @param seekNumber
	 * @return
	 */
	public abstract String updateSeekNumberById(int depositId, int seekNumber);

	/**
	 * 将一条存储记录的链接互助记录改变为指定的记录
	 * @param depositId 该条存储记录的编号 
	 * @param key 要将之改变成的记录
	 * @return 更新的结果
	 */
	public abstract String updateLinkedById(int depositId, int key);

	/**
	 * 将一条存储记录的状态改变为指定的状态
	 * @param depositId 该条存储记录的编号 
	 * @param status 要将之改变成的状态
	 * @return 更新的结果
	 */
	public abstract String updateOneById(SideRecord one);

	/**
	 * 获得某个用户所有的存储记录
	 * @param userId 该用户的用户编号
	 * @return 该用户所有的存储记录表
	 */
	public abstract ArrayList<SideRecord> readSomeByUserId(int userId);

	/**
	 * 获得所有该类型的的存储记录
	 * @param status 该类型
	 * @param p 
	 * @return 数据库中所有该类型的存储记录
	 */
	public abstract ArrayList<SideRecord> readSomeByStatus(int status);

	/**
	 * 获得所有该类型的的存储记录，限制页数
	 * @param status 该类型
	 * @return 数据库中所有该类型的存储记录
	 */
	public abstract ArrayList<SideRecord> readSomeByStatusLimit(int status,
			int page);

	/**
	 * 获得今天新的记录
	 * @return 今天记录数
	 */
	public abstract int readTodayNewCount();

	/**
	 * 增加一名用户的预存储时间
	 * @param one 预存储时间的详细信息
	 * @param userId 用户的编号
	 * @return 结果
	 */
	public abstract String createOne(SideRecord one);

	/**
	 * 根据ID删除存储记录
	 * @param did 存储记录的ID
	 * @return
	 */
	public abstract String deleteOne(int did);

	/**
	 * @param verifying
	 * @return
	 */
	public abstract int readCountDepositsByStatus(int status);

	/**
	 * 
	 */
	public abstract int updateExpired();

	public abstract int updateNotExpired();

	/**
	 * @param did
	 * @param modeSeek
	 * @param i
	 * @param validNumber
	 * @return
	 */
	public abstract String updateModesById(int depositId, int mode,
			int seekLeft, int seekNumber);

	/**
	 * @param status
	 * @return
	 */
	public abstract ArrayList<SideRecord> getDisplayDepositsByStatus(
			int status, int isToTop, int isDetailed);

	/**
	 * @param status
	 * @param no
	 * @param no2
	 * @param p
	 * @return
	 */
	public abstract ArrayList<SideRecord> getDisplayDepositsByStatusLimit(
			int status, int isToTop, int isDetailed, int p);

	/**
	 * @param status
	 * @param no
	 * @param no2
	 * @return
	 */
	public abstract int getCountDisplayDepositsByStatus(int status,
			int isToTop, int isDetailed);

}