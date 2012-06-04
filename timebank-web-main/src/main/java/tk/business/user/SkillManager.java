/**
 * @Project TimeBank
 * @CreatedTime 2011-10-22 上午09:36:00 
 * @Author CK
 * @Todo TODO
 */
package tk.business.user;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.reserve.ReserveSkill;
import timebank.model.user.User;
import timebank.util.lang.convertor.Convertor;
import tk.persistence.SkillDao;
import tk.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class SkillManager {
//	@Resource
	private SkillDao skillDao;

	/**
	 * @return the skillDao
	 */
	public SkillDao getSkillDao() {
		return skillDao;
	}

	/**
	 * @param skillDao the skillDao to set
	 */
	public void setSkillDao(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

	/**
	 * @param range1
	 * @param range2
	 * @param range3
	 * @param range4
	 * @param range5
	 * @param range6
	 * @param range7
	 * @param range8
	 * @param range9
	 * @param range10
	 * @param range11
	 * @param range12
	 * @param range13
	 * @param range14
	 * @param range15
	 * @return
	 */
	public String updateSkill(int userId, ArrayList<ReserveSkill> range1,
			ArrayList<ReserveSkill> range2, ArrayList<ReserveSkill> range3,
			ArrayList<ReserveSkill> range4, ArrayList<ReserveSkill> range5,
			ArrayList<ReserveSkill> range6, ArrayList<ReserveSkill> range7,
			ArrayList<ReserveSkill> range8, ArrayList<ReserveSkill> range9,
			ArrayList<ReserveSkill> range10, ArrayList<ReserveSkill> range11,
			ArrayList<ReserveSkill> range12, ArrayList<ReserveSkill> range13,
			ArrayList<ReserveSkill> range14, ArrayList<ReserveSkill> range15) {
		ArrayList<ReserveSkill> list = new ArrayList<ReserveSkill>();
		ArrayList<ReserveSkill> range = null;
		ReserveSkill one = null;
		String result = Values.SUCCESS;

		range = range1;
		loadRange(userId, list, range);
		range = range2;
		loadRange(userId, list, range);
		range = range3;
		loadRange(userId, list, range);
		range = range4;
		loadRange(userId, list, range);
		range = range5;
		loadRange(userId, list, range);
		range = range6;
		loadRange(userId, list, range);
		range = range7;
		loadRange(userId, list, range);
		range = range8;
		loadRange(userId, list, range);
		range = range9;
		loadRange(userId, list, range);
		range = range10;
		loadRange(userId, list, range);
		range = range11;
		loadRange(userId, list, range);
		range = range12;
		loadRange(userId, list, range);
		range = range13;
		loadRange(userId, list, range);
		range = range14;
		loadRange(userId, list, range);
		range = range15;
		loadRange(userId, list, range);
		
		//存入数据库
		for (int i = 0; i < list.size(); i++) {
			one = list.get(i);
//			if(skillDao.readOneIsHave(one.getUserId(), one.getClassFirst(), one.getClassSecond()) == false){
//				if(skillDao.createOne(list.get(i)).equals(Values.SUCCESS) == false){
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
	private void loadRange(int userId, ArrayList<ReserveSkill> list,
			ArrayList<ReserveSkill> range) {
		ReserveSkill one;
//		for (int i = 1; i < range.size(); i++) {
//			one = new ReserveSkill();
//			one.setClassFirst(range.get(0).getClassFirst());
//			one.setClassSecond(range.get(i).getClassSecond());
//			one.setUserId(userId);
//			one.setCreateTime(Convertor.changeDateTimeToString(new Date()));
//			list.add(one);
//		}
	}
	


	/**
	 * 获得数据库中指定用户的所有技能信息
	 * @param userId 
	 * @return
	 */
	public ArrayList<ReserveSkill> readSomeByUserIdAndClass1(long userId, String class1) {
		return skillDao.readSomeByUserIdAndClass1(userId, class1);
	}
	
	/**
	 * 获得数据库中指定用户的所有技能信息的总数
	 * @param userId 
	 * @return
	 */
	public int readCountByUserId(int userId) {
		return skillDao.readCountByUserId(userId);
	}



	/**
	 * @param sid
	 * @return
	 */
	public ReserveSkill readOne(int sid) {
		return skillDao.readOneById(sid);
	}



	/**
	 * @param sid
	 * @return
	 */
	public String deleteOne(int sid) {
		ReserveSkill one = skillDao.readOneById(sid);
////		int count = skillDao.readCountByUserId(one.getUserId());
//		if(count <= Values.MIN_COUNT_SKILL){
//			return "抱歉，请您将【技能储备】保持" + Values.MIN_COUNT_SKILL + "条以上！";
//		}
		return skillDao.deleteOne(sid);
	}

}