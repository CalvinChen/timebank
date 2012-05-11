package timebank.persistence;

import java.util.ArrayList;

import timebank.model.reserve.ReserveIdleTime;

public interface IdleTimeDao {

	/**
	 * 向数据库中新增一项空闲时间
	 * @param one
	 * @return
	 */
	public abstract String createOne(ReserveIdleTime one);

	/**
	 * 获得数据库中指定用户指定天的所有空闲信息
	 * @param userId 
	 * @return
	 */
	public abstract ArrayList<ReserveIdleTime> readSomeByUserIdAndDay(
			int userId, String idleDay);

	/**
	 * 获得数据库中指定用户的所有空闲信息的总数
	 * @param userId 
	 * @return
	 */
	public abstract int readCountByUserId(int userId);

	public abstract ReserveIdleTime readOneById(int idleTimeId);

	/**
	 * 根据信息查看用户有没有这条空闲时间
	 * @param userId 用户编号
	 * @param day 空闲天
	 * @param hour 空闲时
	 * @return
	 */
	public abstract boolean readOneIsHave(int userId, String day, String hour);

	public abstract String deleteOne(int idleTimeId);

	/**
	 * 根据关键字找出用户时间储备里面含有的记录
	 * @param someInfo
	 * @param p 页码
	 * @return
	 */
	public abstract ArrayList<Integer> readUserIdBySomeTimeLimit(
			String idleDay, String idleHour, int p);

	/**
	 * 根据关键字找出用户时间储备里面含有的记录
	 * @param someInfo
	 * @param p 页码
	 * @return
	 */
	public abstract ArrayList<Integer> readUserIdBySomeTime(String idleDay,
			String idleHour);

	public abstract ArrayList<Integer> readUserIdsByIdleDayAndSoOn(
			String idleDay, String andSoNo, int p);

	public abstract ArrayList<Integer> readUserIdsForUnion(String idleDay,
			String andSoNo);

	/**
	 * 根据关键字找出用户时间储备里面含有的记录
	 * @param someInfo
	 * @param p 页码
	 * @return
	 */
	public abstract ArrayList<Integer> readUserIdByHaveTimes(int p);

	/**
	 * 根据关键字找出用户时间储备里面含有的记录的总数
	 * @param someInfo
	 * @param string 
	 * @param p
	 * @return
	 */
	public abstract int readCountUserIdBySomeTime(String idleDay,
			String idleHour);

	/**
	 * 读出所有有填写空闲时间的用户的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public abstract int readCountUserIdByHaveTimes();

	/**
	 * 读出所有时间储备的总数
	 * @return
	 */
	public abstract int readCountTimes();

	/**
	 * @param idleDay
	 * @param string
	 * @return
	 */
	public abstract int readCountUserIdsByIdleDayAndSoOn(String idleDay,
			String sql);

}