package timebank.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import timebank.model.user.User;

public interface UserDao {

	/**
	 * select the user with the pk.
	 * @param pk 
	 * @return the user
	 */
	public abstract User select(int pk);	
	
	/**
	 * select the user with the key value.
	 * @param key 
	 * @return the user
	 */
	public abstract List selectWithOneCondition(String key, String value);	
	
	/**
	 * add an user row to database
	 * @param user the new user
	 * @return result
	 */
	public abstract Integer insert(User user);
	
	/**
	 * 用户登录
	 * @param username 要登录的用户
	 * @return 如果返回null，说明数据库中没有这个用户，登录失败；否则返回一个user对象。
	 */
	public abstract User readOneByUsername(String username);

	/**
	 * 用户登录
	 * @param username 要登录的用户
	 * @return 如果返回null，说明数据库中没有这个用户，登录失败；否则返回一个user对象。
	 */
	public abstract User readOneByStudentId(String studentId);



	/**
	 * 向数据库中新关联一个用户信息记录，此方法在用户注册时调用
	 * @param userToReg
	 * @return
	 */
	public abstract String updateUserInfo(int userId, String name,
			String studentId, String email);

	/**
	 * 找出username对应的userId，若结果为0，表示找不到。
	 * @param username
	 * @return
	 */
	public abstract int readIdByUsername(String username);



	/**
	 * 通过userId获得该user的密码
	 * @param userId
	 * @return
	 */
	public abstract String readPasswordById(int userId);

	public abstract String updateUserInfoByUserId(User u);

	public abstract String updateAllInfoByUserId(User u);

	public abstract String updateUserContactByUserId(User user);

	public abstract String updateVerifiedTime();

	/**
	 * 传递user，依据其userId在数据库中将原始密码改为user.password。
	 * @param userId
	 * @return
	 */
	public abstract String updateUserPSWByUserId(int userId, String psw);

	public abstract String readUsernameByUserId(int userId);

	public abstract boolean updatePhoto(int userId, String picture);

	/**
	 * 根据用户编号获得用户头像地址
	 * @param helpedUserId 用户编号
	 * @return 用户头像地址
	 */
	public abstract String readPhotoById(int helpedUserId);

	/**
	 * 验证访问者输入的学号和姓名是否存在于数据库
	 * @param name 姓名
	 * @param studentId 学号
	 * @return 验证结果
	 */
	public abstract String verifyInfo(String name, String studentId);

	public abstract void deleteOne(int userId);

	public abstract ArrayList<User> readSomeByType(int isInfoUsed,
			int isUserVerified, int page);

	/**
	 * 读取所有会员信息
	 * @return
	 */
	public abstract ArrayList<User> readAll();

	public abstract ArrayList<User> readSomeByIsRegistered(int isRegistered,
			int page);

	public abstract int readCountByIsRegistered(int isRegistered);

	public abstract int readCountByIsRegisteredToday(int isRegistered);

	public abstract ArrayList<User> readSomeByIsRegistered(int isRegistered);

	/**
	 * 读取指定类型用户的总数目
	 * @param isInfoUsed
	 * @param isUserVerified
	 * @return
	 */
	public abstract int readCountByType(int isInfoUsed, int isUserVerified);

	/**
	 * 读取今天内验证用户的总数目
	 * @param isInfoUsed
	 * @param isUserVerified
	 * @return
	 */
	public abstract int readCountVerifiedToday();

	public abstract String updateUserStatus(int uid, int userVerified,
			Date verifiedTime);

	public abstract String updateUserIsUsed(int uid, int isUsed);

	/**
	 * @param infoUsed
	 * @param userVerified
	 */
	public abstract ArrayList<User> readSomeByType(int isInfoUsed,
			int isUserVerified);

	/**
	 * @param someInfo
	 * @param page
	 * @return
	 */
	public abstract ArrayList<User> readSomeBySomeInfo(String someInfo, int page);

	/**
	 * 根据学院取出用户
	 * @param cid
	 * @param page
	 * @return
	 */
	public abstract ArrayList<User> readSomeByCollege(int cid, int page);

	/**
	 * 根据学院取出用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	public abstract int readCountSomeByCollege(int cid);

	/**
	 * 根据学院取出的是否验证用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	public abstract int readCountSomeByCollegeAndIsVerified(int cid,
			int isVerified);

	/**
	 * 根据学院取出的注册或未注册用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	public abstract int readCountSomeByCollegeAndIsUsed(int cid, int isUsed);

	/**
	 * @param someInfo
	 * @param page
	 * @return
	 */
	public abstract int readCountSomeBySomeInfo(String someInfo);

}