package timebank.business.user;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import timebank.model.message.UserMessageFromSystem;
import timebank.model.reserve.ReserveIdleTime;
import timebank.model.user.Student;
import timebank.model.user.User;
import timebank.persistence.BankInfoDao;
import timebank.persistence.IdleTimeDao;
import timebank.persistence.MessageDao;
import timebank.persistence.SkillDao;
import timebank.persistence.UserDao;
import timebank.persistence.impl.hibernate.UserDaoHibernate;
import timebank.util.Tester;
import timebank.util.bean.Message;
import timebank.util.bean.Values;

import com.opensymphony.xwork2.ActionContext;

@Service
public class UserManager {
	@Resource
	private UserDao userDao;
//	@Resource
	private BankInfoDao bankInfoDao;
//	@Resource
	private SkillDao skillDao;
//	@Resource
	private IdleTimeDao idleTimeDao;
//	@Resource
	private MessageDao messageDao;
	
	/**
	 * @return the messageDao
	 */
	public MessageDao getMessageDao() {
		return messageDao;
	}

	/**
	 * @param messageDao the messageDao to set
	 */
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

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
	 * @return the bankInfoDao
	 */
	public BankInfoDao getBankInfoDao() {
		return bankInfoDao;
	}

	/**
	 * @param bankInfoDao the bankInfoDao to set
	 */
	public void setBankInfoDao(BankInfoDao bankInfoDao) {
		this.bankInfoDao = bankInfoDao;
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
	 * 用户登录模块
	 * @param oneInput
	 * @return
	 */
	public User login(User oneInput) {
		
		//先在数据库中寻找是否有用户名为此的用户
		User oneDatabase = userDao.readOneByUsername(oneInput.getUsername());
		
		if(oneDatabase != null && 
			oneDatabase.getPassword().equals(oneInput.getPassword()) == true 
//			&&oneDatabase.getIsUsed() == Values.INFO_USED
			){
			//如果有而且密码和数据库中一致，返回该用户
			return oneDatabase;
		}else{
			
			//查询是否为存在学号
			oneDatabase = userDao.readOneByStudentId(oneInput.getUsername());
			if(oneDatabase != null && 
					oneDatabase.getPassword().equals(oneInput.getPassword()) == true 
//					&&oneDatabase.getIsUsed() == Values.INFO_USED
					){
				
				//如果返回结果不为null且密码与输入一致，返回该用户
				return oneDatabase;
			}
			return null;
		}
	}
	
	public User getOneByUsername(String username){
		return userDao.readOneByUsername(username);
	}

	/**
	 * register an user.
	 * first, check for duplicate username in database.
	 * if not, do register.
	 * @param user
	 * @return
	 */
	public Message registerUser(User user) {
		/* check if there's duplicate username or email */
		if(userDao.selectWithOneCondition("username", user.getUsername()).size() != 0){
			return new Message(false, "用户名已被注册");
		}
		if(userDao.selectWithOneCondition("userInfo.email", user.getUserInfo().getEmail()).size() != 0){
			return new Message(false, "Email已被注册");
		}
		
		/* do the actual register */
		Integer pk = userDao.insert(user);
		if (pk != null) {
			return new Message("注册成功");
		} else {
			return new Message(false, "注册失败");
		}
//		Student one = (Student)user;
//		//查询数据库，看是否有此用户名
//		int userId = userDao.readIdByUsername(one.getUsername());
//		
//		if(userId != 0){
//			//已经有此用户名了，无法注册
//			return "此用户名已被注册！";
//		}
//		
//		//否则可以注册
//		String result = userDao.add(one);
//		userId = userDao.readOneByStudentId(one.getStudentId()).getUserId();
//		one.setUserId(userId);
//		
//		if(result.equals(Values.SUCCESS)){			
//			//user表增加记录成功后，bankInfo表做相应增加
//			String resultBankInfo = bankInfoDao.createOne(userId);
//			if(resultBankInfo.equals(Values.FAILURE)){
//				Tester.markHere("resultBankInfo == false");
//				return Values.FAILURE;
//			}
//			//读取通知草稿箱中现有的通知
//			ArrayList<MessageRecord> list = messageDao.readAllTemplate();
//			for (MessageRecord msg : list) {
//				msg.setOwner(one.getUsername());
//				msg.setOwnerId(one.getUserId());
//				if(messageDao.createOne(msg).equals(Values.FAILURE)){
//					return Values.FAILURE;
//				}
//			}
//		}else{
//			result = Values.FAILURE;
//		}
//		return result;
	}

	public User getUserInfo(int userId) {
		User user = userDao.select(userId);
//		user.setUpdateTime(user.getUpdateTime().substring(0, 16));
		return user;
	}

	public String updateUserInfoByUserId(User user) {
		User userFull = (User)ActionContext.getContext().getSession().get("userLogined");
//		userFull.setZone(user.getUserInfo().getZone());
		return userDao.updateUserInfoByUserId(userFull);
	}

	public String updateAllInfoByUserId(User user){
		String result = userDao.updateAllInfoByUserId(user);
//		if(user.getIsVerified() == Values.USER_VERIFIED){
//			updateUserStatus(user.getUserId(), user.getIsVerified());
//		}
		return result;
	}
	
	public String updateUserContactByUserId(User user) {
		return userDao.updateUserContactByUserId(user);
	}

	public String updateUserPSWByUserId(User user, String oldPassword) {
		Tester.markHere("UserBO.updateUserPSWByUserId");
		String pswDatabase = userDao.readPasswordById(user.getUserId());
		if(pswDatabase.equals("") || !oldPassword.equals(pswDatabase)){
			Tester.markHere("true");
			return Values.FAILURE;
		}else{
			Tester.markHere("false");
			return userDao.updateUserPSWByUserId(user.getUserId(), user.getPassword());	
		}
	}

	public String getUsernameByUserId(int userId) {
		String result = userDao.readUsernameByUserId(userId);
		return result;
	}

	public static boolean deleteUserPicture(String picture) {
		if(picture.equals(Values.DEFAULT_PHOTO)){
			return true;
		}
		String realpath = ServletActionContext.getServletContext().getRealPath(picture.substring(picture.indexOf("/", 3)));
		File fileToDel = new File(realpath);
		if(fileToDel.exists() && fileToDel.isFile()){
			fileToDel.delete();
			return true;
		}else{
			return false;
		}
	}
	
	public boolean updatePhoto(int userId, String picture) {
		
		return userDao.updatePhoto(userId, picture);
	}

	public String getPhotoByUserId(int helpedUserId) {
		return userDao.readPhotoById(helpedUserId);
	}

	public String verifyInfo(String name, String studentId) {
		String result = userDao.verifyInfo(name, studentId);
		return result;
	}

	public ArrayList<User> getUsersByType(int isInfoUsed, int isUserVerified, int page) {
		if(page <= 0){
			page = 1;
		}
		ArrayList<User> list = userDao.readSomeByType(isInfoUsed, isUserVerified, page);
		return list;
	}

	public int readCountByType(int isInfoUsed, int isUserVerified) {
		int count = userDao.readCountByType(isInfoUsed, isUserVerified);
		return count;
	}
	
	public ArrayList<User> getUnregisterUsers(int p) {
		if(p <= 0){
			p = 1;
		}
		ArrayList<User> list = userDao.readSomeByIsRegistered(Values.INFO_NOT_USED, p);
		return list;
	}

	public int getUnregisteredUserCount() {
		int count = userDao.readCountByIsRegistered(Values.INFO_NOT_USED);
		return count;
	}

	public String updateUserStatus(int uid, int userVerified) {
		User user = userDao.select(uid);
		String result = "";
		if(userVerified == Values.USER_NOT_VERIFIED){
//			try {
				result = userDao.updateUserStatus(
						uid, userVerified, null
//						SimpleDateFormat.getDateTimeInstance().parse(user.getVerifiedTime())
						);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
		}else {
			result = userDao.updateUserStatus(uid, userVerified, new Date());
		}
		return result;
	}
	public String updateUserIsUsed(int uid, int isUsed) {
		String result = userDao.updateUserIsUsed(uid, isUsed);
		return result;
	}

	/**
	 * @param someInfo
	 * @return
	 */
	public ArrayList<User> getUsersBySomeInfo(String someInfo, int page) {
		ArrayList<User> list = userDao.readSomeBySomeInfo(someInfo,page);
		return list;
	}

	/**
	 * @param someInfo
	 * @return
	 */
	public int getCountUsersBySomeInfo(String someInfo) {
		return userDao.readCountSomeBySomeInfo(someInfo);
	}
	
	public int readCountByIsRegisteredToday(int isRegister){
		return userDao.readCountByIsRegisteredToday(isRegister);
	}

	/**
	 * @param uid
	 * @param sid
	 */
	public String updatePswByUserId(int uid, String sid) {
		return userDao.updateUserPSWByUserId(uid, sid);
	}

	/**
	 * @param userId
	 * @return
	 */
	public String resetPsw(int userId) {
		Student one = (Student)userDao.select(userId);
		return userDao.updateUserPSWByUserId(userId, one.getStudentId());
	}

	/**
	 * @return
	 */
	public int readCountVerifiedToday() {
		return userDao.readCountVerifiedToday();
	}

	/**
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public ArrayList<User> getSkillMenBySomeInfo(String someInfo, int p) {
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		ArrayList<Integer> listUserId = skillDao.readUserIdBySomeSkill(someInfo, p);
		for (int i = 0; i < listUserId.size(); i++) {
			one = userDao.select(listUserId.get(i));
			list.add(one);
		}
		return list;
	}
	

	/**
	 * 找出有技能储备的用户记录
	 * @param p 页码
	 * @return
	 */
	public ArrayList<User> readUserIdByHaveSkills(int p) {
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		ArrayList<Integer> listUserId = skillDao.readUserIdByHaveSkills(p);
		for (int i = 0; i < listUserId.size(); i++) {
			one = userDao.select(listUserId.get(i));
			list.add(one);
		}
		return list;
	}

	/**
	 * @param someInfo
	 * @return
	 */
	public int getSkillMenCountBySomeInfo(String someInfo) {
		int count = skillDao.readCountUserIdBySomeSkill(someInfo);
		return count;
	}

	/**
	 * 读出所有有填写爱好技能的用户的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public int readCountUserIdByHaveSkills() {
		return skillDao.readCountUserIdByHaveSkills();
	}


	/**
	 * 读出所有爱好技能的总数
	 * @param someInfo
	 * @param p
	 * @return
	 */
	public int readCountSkills() {
		return skillDao.readCountSkills();
	}

	/**
	 * @param cid
	 * @param p
	 * @return
	 */
	public ArrayList<User> getSomeByCollege(int cid, int p) {
		return userDao.readSomeByCollege(cid, p);
	}

	/**
	 * @param cid
	 * @return
	 */
	public int getSomeCountByCollege(int cid) {
		return userDao.readCountSomeByCollege(cid);
	}
	


	/**
	 * 根据学院取出的注册或未注册用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	public int readCountSomeByCollegeAndIsUsed(int cid, int isUsed) {
		return userDao.readCountSomeByCollegeAndIsUsed(cid, isUsed);
	}
	

	/**
	 * 根据学院取出的是否验证用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	public int readCountSomeByCollegeAndIsVerified(int cid, int isVerified) {
		return userDao.readCountSomeByCollegeAndIsVerified(cid, isVerified);
	}

	/**
	 * 读出所有有填写空闲时间段的用户数
	 * @return
	 */
	public int readCountUserIdByHaveIdleTimes() {
		return idleTimeDao.readCountUserIdByHaveTimes();
	}

	/**
	 * @return
	 */
	public int readCountIdleTimes() {
		return idleTimeDao.readCountTimes();
	}

	/**
	 * 找出数据库中有空闲时间的用户
	 * @param p
	 * @return
	 */
	public ArrayList<User> readUserIdByHaveIdleTimes(int p) {
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		ArrayList<Integer> listUserId = idleTimeDao.readUserIdByHaveTimes(p);
		for (int i = 0; i < listUserId.size(); i++) {
			one = userDao.select(listUserId.get(i));
			list.add(one);
		}
		return list;
	}

	/**
	 * 分页读取含有指定空闲时间的用户列表
	 * @param idleTime
	 * @param p
	 * @return
	 */
	public ArrayList<User> getIdleTimeMenBySomeInfo(ReserveIdleTime idleTime, int p) {
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		ArrayList<Integer> listUserId = null;
//		if(idleTime.getIdleHour().equals("整个上午")){
//			listUserId = idleTimeDao.readUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节') group by userId having count(userId) = 2", p);
//		}else if(idleTime.getIdleHour().equals("整个下午")){
//			listUserId = idleTimeDao.readUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"(idleHour='第07-08节' or idleHour='第09-10节') group by userId having count(userId) = 2", p);
//		}else if(idleTime.getIdleHour().equals("整个白天")){
//			listUserId = idleTimeDao.readUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节') group by userId having count(userId) = 5", p);
//		}else if(idleTime.getIdleHour().equals("整天")){
//			listUserId = idleTimeDao.readUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节' or idleHour='第11-12节') group by userId having count(userId) = 6", p);
//		}else listUserId = idleTimeDao.readUserIdBySomeTimeLimit(idleTime.getIdleDay(), idleTime.getIdleHour(), p);
//		for (int i = 0; i < listUserId.size(); i++) {
//			one = userDao.select(listUserId.get(i));
//			list.add(one);
//		}
		return list;
	}

	/**
	 * @param someInfo
	 * @return
	 */
	public int getIdleTimeMenCountBySomeInfo(ReserveIdleTime idleTime) {
		int count = 0;
//		if(idleTime.getIdleHour().equals("整个上午")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime where idleDay=? and (idleHour='第01-02节' or idleHour='第03-04节') group by userId having count(userId) = 2) qq");
//		}else if(idleTime.getIdleHour().equals("整个下午")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第07-08节' or idleHour='第09-10节'" +
//			") group by userId having count(userId) = 2) qq");
//		}else if(idleTime.getIdleHour().equals("整个白天")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节'" +
//			") group by userId having count(userId) = 5) qq");
//		}else if(idleTime.getIdleHour().equals("整天")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节' or idleHour='第11-12节'" +
//			") group by userId having count(userId) = 6) qq");
//		}else count = idleTimeDao.readCountUserIdBySomeTime(idleTime.getIdleDay(), idleTime.getIdleHour());
		return count;
	}

	/**
	 * @param idleTime
	 * @param someSkills
	 * @param p
	 * @return
	 */
	public ArrayList<User> getIdleTimeMenByUnion(ReserveIdleTime idleTime,
			String someSkills, int p) {
		
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		ArrayList<Integer> listUserId = null;
//		if(idleTime.getIdleHour().equals("整个上午")){
//			listUserId = idleTimeDao.readUserIdsForUnion(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节') group by userId having count(userId) = 2");
//		}else if(idleTime.getIdleHour().equals("整个下午")){
//			listUserId = idleTimeDao.readUserIdsForUnion(idleTime.getIdleDay(), 
//			"(idleHour='第07-08节' or idleHour='第09-10节') group by userId having count(userId) = 2");
//		}else if(idleTime.getIdleHour().equals("整个白天")){
//			listUserId = idleTimeDao.readUserIdsForUnion(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节') group by userId having count(userId) = 5");
//		}else if(idleTime.getIdleHour().equals("整天")){
//			listUserId = idleTimeDao.readUserIdsForUnion(idleTime.getIdleDay(), 
//			"(idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节' or idleHour='第11-12节') group by userId having count(userId) = 6");
//		}else listUserId = idleTimeDao.readUserIdBySomeTime(idleTime.getIdleDay(), idleTime.getIdleHour());
		
		int userId = 0;
		for (int i = 0; i < listUserId.size(); i++) {
			userId = listUserId.get(i);
			if(skillDao.readOneIsHave(userId, someSkills) == true){
				one = userDao.select(userId);
				list.add(one);
			}
		}
		return list;
	}

	/**
	 * @param idleTime
	 * @param someSkills
	 * @return
	 */
	public int getCountIdleTimeMenByUnion(ReserveIdleTime idleTime,
			String someSkills) {
		int count = 0;
//		if(idleTime.getIdleHour().equals("整个上午")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime where idleDay=? and (idleHour='第01-02节' or idleHour='第03-04节') group by userId having count(userId) = 2) qq");
//		}else if(idleTime.getIdleHour().equals("整个下午")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第07-08节' or idleHour='第09-10节'" +
//			") group by userId having count(userId) = 2) qq");
//		}else if(idleTime.getIdleHour().equals("整个白天")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节'" +
//			") group by userId having count(userId) = 5) qq");
//		}else if(idleTime.getIdleHour().equals("整天")){
//			count = idleTimeDao.readCountUserIdsByIdleDayAndSoOn(idleTime.getIdleDay(), 
//			"select count(qq.userId) from (select userId from idletime  where idleDay=? and (" +
//			"idleHour='第01-02节' or idleHour='第03-04节' or idleHour='第05-06节' or idleHour='第07-08节' or idleHour='第09-10节' or idleHour='第11-12节'" +
//			") group by userId having count(userId) = 6) qq");
//		}else count = idleTimeDao.readCountUserIdBySomeTime(idleTime.getIdleDay(), idleTime.getIdleHour());
		return count;
	}
}
