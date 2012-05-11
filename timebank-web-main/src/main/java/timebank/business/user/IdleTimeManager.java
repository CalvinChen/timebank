/**
 * @Project TimeBank
 * @CreatedTime 2011-10-22 上午09:36:00 
 * @Author CK
 * @Todo TODO
 */
package timebank.business.user;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.reserve.ReserveIdleTime;
import timebank.persistence.IdleTimeDao;
import timebank.util.Convertor;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class IdleTimeManager {
//	@Resource
	private IdleTimeDao idleTimeDao;

	/**
	 * @return the idleTimeDao
	 */
	public IdleTimeDao getIdleTimeDao() {
		return idleTimeDao;
	}

	/**
	 * @param idleTimeDao the idleTimeDao to set
	 */
	public void setIdleTimeDao(IdleTimeDao idleTimeDao) {
		this.idleTimeDao = idleTimeDao;
	}

	/**
	 * @param day1
	 * @param day2
	 * @param day3
	 * @param day4
	 * @param day5
	 * @param day6
	 * @param day7
	 * @return
	 */
	public String updateIdleTime(int userId, ArrayList<ReserveIdleTime> day1,
			ArrayList<ReserveIdleTime> day2, ArrayList<ReserveIdleTime> day3,
			ArrayList<ReserveIdleTime> day4, ArrayList<ReserveIdleTime> day5,
			ArrayList<ReserveIdleTime> day6, ArrayList<ReserveIdleTime> day7) {
		ArrayList<ReserveIdleTime> list = new ArrayList<ReserveIdleTime>();
		ArrayList<ReserveIdleTime> range = null;
		ReserveIdleTime one = null;
		String result = Values.SUCCESS;

		range = day1;
		loadRange(userId, list, range);
		range = day2;
		loadRange(userId, list, range);
		range = day3;
		loadRange(userId, list, range);
		range = day4;
		loadRange(userId, list, range);
		range = day5;
		loadRange(userId, list, range);
		range = day6;
		loadRange(userId, list, range);
		range = day7;
		loadRange(userId, list, range);
		
		//存入数据库
		for (int i = 0; i < list.size(); i++) {
			one = list.get(i);
//			if(idleTimeDao.readOneIsHave(one.getUserId(), one.getIdleDay(), one.getIdleHour()) == false){
//				if(idleTimeDao.createOne(list.get(i)).equals(Values.SUCCESS) == false){
//					result = Values.FAILURE;
//				}	
//			}
		}
		return result;
	}



	/**
	 * @param userId
	 * @param list
	 * @param range
	 */
	private void loadRange(int userId, ArrayList<ReserveIdleTime> list,
			ArrayList<ReserveIdleTime> range) {
		ReserveIdleTime one;
		for (int i = 1; i < range.size(); i++) {
			one = new ReserveIdleTime();
			one.setIdleDay(range.get(0).getIdleDay());
			one.setIdleHour(range.get(i).getIdleHour());
//			one.setUserId(userId);
//			one.setCreateTime(Convertor.changeDateTimeToString(new Date()));
			list.add(one);
		}
	}
	


	/**
	 * 获得数据库中指定用户的所有技能信息
	 * @param userId 
	 * @return
	 */
	public ArrayList<ReserveIdleTime> readSomeByUserIdAndIdleDay(int userId, String idleDay) {
		return idleTimeDao.readSomeByUserIdAndDay(userId, idleDay);
	}
	
	/**
	 * 获得数据库中指定用户的所有技能信息的总数
	 * @param userId 
	 * @return
	 */
	public int readCountByUserId(int userId) {
		return idleTimeDao.readCountByUserId(userId);
	}



	/**
	 * @param sid
	 * @return
	 */
	public ReserveIdleTime readOne(int sid) {
		return idleTimeDao.readOneById(sid);
	}

	/**
	 * @param sid
	 * @return
	 */
	public String deleteOne(int sid) {
		ReserveIdleTime one = idleTimeDao.readOneById(sid);
//		int count = idleTimeDao.readCountByUserId(one.getUserId());
//		if(count <= Values.MIN_COUNT_IDLETIME){
//			return "抱歉，请您将【时间储备】保持" + Values.MIN_COUNT_IDLETIME + "条以上！";
//		}
		return idleTimeDao.deleteOne(sid);
	}

}