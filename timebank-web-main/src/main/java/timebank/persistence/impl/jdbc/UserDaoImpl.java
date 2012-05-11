package timebank.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import timebank.model.user.Student;
import timebank.model.user.User;
import timebank.persistence.UserDao;
import timebank.util.Convertor;
import timebank.util.DBConnection;
import timebank.util.Tester;
import timebank.util.bean.DatabaseTable;
import timebank.util.bean.Values;

public class UserDaoImpl {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 用户登录
	 * @param username 要登录的用户
	 * @return 如果返回null，说明数据库中没有这个用户，登录失败；否则返回一个user对象。
	 */
	
	public User readOneByUsername(String username) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		User user = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				user = readOneProcess();
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return user;
	}
	/**
	 * 用户登录
	 * @param username 要登录的用户
	 * @return 如果返回null，说明数据库中没有这个用户，登录失败；否则返回一个user对象。
	 */
	
	public User readOneByStudentId(String studentId) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		User user = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where studentId=?");
			ps.setString(1, studentId);
			rs = ps.executeQuery();
			if(rs.next()){
				user = readOneProcess();
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return user;
	}

	/**
	 * 向数据库中user表新增一条记录
	 * @param newUser
	 * @return
	 */
	
	public Boolean insert(User user) {
		Student one = (Student)user;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		Boolean flag = false;
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER + 
				" set username=?,password=?,name=?,studentId=?,email=?,createTime=?,isUsed=?" +
				" where name=? and studentId=?");
			int i = 1;
			ps.setString(i++, one.getUsername());
			ps.setString(i++, one.getPassword());
			ps.setString(i++, one.getUserInfo().getTrueName());
			ps.setString(i++, one.getStudentId());
			ps.setString(i++, one.getUserInfo().getEmail());
			ps.setString(i++, Convertor.changeDateTimeToString(new Date()));
			ps.setInt(i++, Values.INFO_USED);
			
			ps.setString(i++, one.getUserInfo().getTrueName());
			ps.setString(i++, one.getStudentId());
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}		
		return flag;
	}
	
	/**
	 * 向数据库中新关联一个用户信息记录，此方法在用户注册时调用
	 * @param userToReg
	 * @return
	 */
	
	public String updateUserInfo(int userId, String name, String studentId, String email) {
		Tester.markHere("UserDAO.updateUserInfo");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER + 
					" set userId=?,email=?,isUsed=? where name=? and studentId=?");
			ps.setInt(1, userId);
			ps.setString(2, email);
			ps.setInt(3, Values.INFO_USED);
			ps.setString(4, name);
			ps.setString(5, studentId);
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
				flag = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}

	/**
	 * 找出username对应的userId，若结果为0，表示找不到。
	 * @param username
	 * @return
	 */
	
	public int readIdByUsername(String username) {
		Tester.markHere("UserDAO.getUserIdByUsername");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int userId = 0;
		try {
			ps = conn.prepareStatement("select userId from " + DatabaseTable.USER + " where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				userId = rs.getInt("userId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return userId;
	}

	/**
	 * 通过userId获得该用户的所有个人信息
	 * @param uid 
	 * @return
	 */
	
	public User select(int uid) {
		Tester.markHere("UserDAO.getUserInfo");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where userId=?");
			ps.setLong(1, uid);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return one;
	}
	
	/**
	 * 通过userId获得该user的密码
	 * @param userId
	 * @return
	 */
	
	public String readPasswordById(int userId) {
		Tester.markHere("UserDAO.getUserPSW");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String password = "";
		try {
			ps = conn.prepareStatement("select password from " + DatabaseTable.USER + " where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				password = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return password;
	}

	
	public String updateUserInfoByUserId(User u) {
		Student user = (Student)u;
		Tester.markHere("updateUserInfoByUserId");
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER
					+ " set grade=?," 
					+ "college=?,major=?,classId=?," 
					+ "zone=?"
					+ " where userId=?");
			ps.setInt(1, user.getGrade());
			ps.setInt(2, user.getCollege());
			ps.setString(3, user.getMajor());
			ps.setInt(4, user.getClassId());
			ps.setString(5, user.getUserInfo().getZone());
			ps.setLong(6, user.getUserId());
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}
	
	public String updateAllInfoByUserId(User u) {
		Student user = (Student)u;
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER
					+ " set username=?,email=?,name=?,qq=?,weibo=?,blog=?,sex=?," 
					+ "grade=?,college=?,major=?,classId=?,studentId=?,address=?," 
					+ "zone=?,phoneLong=?,phoneShort=?,isVerified=?"
					+ " where userId=?");
			int i = 1;
			ps.setString(i++, user.getUsername());
			ps.setString(i++, user.getUserInfo().getEmail());
			ps.setString(i++, user.getUserInfo().getTrueName());
			ps.setString(i++, user.getUserInfo().getQqId());
			ps.setString(i++, user.getUserInfo().getWeiboUrl());
			ps.setString(i++, user.getUserInfo().getBlogUrl());
			ps.setString(i++, user.getUserInfo().getSex());
			ps.setInt(i++, user.getGrade());
			ps.setInt(i++, user.getCollege());
			ps.setString(i++, user.getMajor());
			ps.setInt(i++, user.getClassId());
			ps.setString(i++, user.getStudentId());
			ps.setString(i++, user.getUserInfo().getAddress());
			ps.setString(i++, user.getUserInfo().getZone());
			ps.setString(i++, user.getUserInfo().getPhoneLong());
			ps.setString(i++, user.getUserInfo().getPhoneShort());
			ps.setBoolean(i++, user.getIsVerified());
			ps.setLong(i++, user.getUserId());
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}

	
	public String updateUserContactByUserId(User user) {
		Tester.markHere("updateUserInfoByUserId");
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER
					+ " set email=?,qq=?,weibo=?,blog=?," 
					+ "address=?,phoneLong=?,phoneShort=?"
					+ " where userId=?");
			ps.setString(1, user.getUserInfo().getEmail());
			ps.setString(2, user.getUserInfo().getQqId());
			ps.setString(3, user.getUserInfo().getWeiboUrl());
			ps.setString(4, user.getUserInfo().getBlogUrl());
			ps.setString(5, user.getUserInfo().getAddress());
			ps.setString(6, user.getUserInfo().getPhoneLong());
			ps.setString(7, user.getUserInfo().getPhoneShort());
			ps.setLong(8, user.getUserId());
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}

	
	public String updateVerifiedTime() {
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER
					+ " set verifiedTime=createTime ");
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}
	
	/**
	 * 传递user，依据其userId在数据库中将原始密码改为user.password。
	 * @param userId
	 * @return
	 */
	
	public String updateUserPSWByUserId(int userId, String psw) {
		Tester.markHere("UserDAO.updateUserPSWByUserId");
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER
					+ " set password=? where userId=?");
			ps.setString(1, psw);
			ps.setInt(2, userId);
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}

	
	public String readUsernameByUserId(int userId) {
		Tester.markHere("UserDAO.getUsernameByUserId");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String username = "";
		try {
			ps = conn.prepareStatement("select username from " + DatabaseTable.USER + " where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return username;
	}

	
	public boolean updatePhoto(int userId, String picture) {
		Tester.markHere("UserDAO.updatePhoto");
		boolean flag = false;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER + " set picture=?  where userId=?");
			ps.setString(1, picture);
			ps.setInt(2, userId);			
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}

	/**
	 * 根据用户编号获得用户头像地址
	 * @param helpedUserId 用户编号
	 * @return 用户头像地址
	 */
	
	public String readPhotoById(int helpedUserId) {
		Tester.markHere("UserDAO.getPhotoByUserId");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String picture = "";
		try {
			ps = conn.prepareStatement("select picture from " + DatabaseTable.USER + " where userId=?");
			ps.setInt(1, helpedUserId);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				picture = rs.getString("picture");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return picture;
	}
	
	/**
	 * 验证访问者输入的学号和姓名是否存在于数据库
	 * @param name 姓名
	 * @param studentId 学号
	 * @return 验证结果
	 */
	
	public String verifyInfo(String name, String studentId) {
		Tester.markHere("UserDAO.verifyInfo");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("select name,studentId,isUsed from " + DatabaseTable.USER + " where name=? and studentId=?");
			ps.setString(1, name);
			ps.setString(2, studentId);
			rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getInt("isUsed") == Values.INFO_NOT_USED){
					flag = Values.SUCCESS;
				}else if(rs.getInt("isUsed") == Values.INFO_USED){
					flag = "此用户信息已被注册！若为他人冒用，请联系我们报告此情况，谢谢。";
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}

	
	public void deleteOne(int userId) {
		Tester.markHere("UserDAO.deleteUser");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("delete from " + DatabaseTable.USER + " where userId=?");
			ps.setInt(1, userId);
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
	}

	
	public ArrayList<User> readSomeByType(int isInfoUsed, int isUserVerified, int page) {
		Tester.markHere("UserDAO.getUsersByType");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where isVerified=? and isUsed=? ORDER BY updateTime DESC limit ?,?");
			ps.setInt(1, isUserVerified);
			ps.setInt(2, isInfoUsed);
			ps.setInt(3, (page - 1) * Values.PAGE_SIZE);
			ps.setInt(4, Values.PAGE_SIZE);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 读取所有会员信息
	 * @return
	 */
	
	public ArrayList<User> readAll() {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER);
			rs = ps.executeQuery();
			while(rs.next()){
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	private User readOneProcess() throws SQLException {
		User one;
		one = new User();
		one.setUserId(rs.getInt("userId"));
		one.setUsername(rs.getString("username"));
		one.setPassword(rs.getString("password"));
//		one.setEmail(rs.getString("email"));
//		one.setName(rs.getString("name"));
//		one.setSex(rs.getString("sex"));
//		one.setQq(rs.getString("qq"));
//		one.setWeibo(rs.getString("weibo"));
//		one.setBlog(rs.getString("blog"));
//		one.setGrade(rs.getInt("grade"));
//		one.setCollege(rs.getInt("college"));
//		one.setMajor(rs.getString("major"));
//		one.setClassId(rs.getInt("classId"));
//		one.setStudentId(rs.getString("studentId"));
//		one.setAddress(rs.getString("address"));
//		one.setZone(rs.getString("zone"));
//		one.setPhoneLong(rs.getString("phoneLong"));
//		one.setPhoneShort(rs.getString("phoneShort"));
//		one.setPicture(rs.getString("picture"));
//		one.setIsUsed(rs.getInt("isUsed"));
//		one.setIsVerified(rs.getInt("isVerified"));
//		one.setUpdateTime(Convertor.changeDateTimeToString(rs.getTimestamp("updateTime")));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		one.setVerifiedTime(Convertor.changeDateTimeToString(rs.getTimestamp("verifiedTime")));
		return one;
	}

	
	
	public ArrayList<User> readSomeByIsRegistered(int isRegistered, int page) {
		Tester.markHere("UserDAO.getUnregisterUsersByType");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where isUsed=? ORDER BY studentId limit ?,?");
			ps.setInt(1, isRegistered);
			ps.setInt(2, (page - 1) * Values.PAGE_SIZE);
			ps.setInt(3, Values.PAGE_SIZE);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}
	
	public int readCountByIsRegistered(int isRegistered) {
		Tester.markHere("UserDAO.getUnregisteredUserCount");
		int count = -1;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + " where isUsed=?");
			ps.setInt(1, isRegistered);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	
	public int readCountByIsRegisteredToday(int isRegistered) {
		Tester.markHere("UserDAO.getUnregisteredUserCount");
		int count = -1;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + 
					" where isUsed=? and timestampdiff(day ,createTime,now())=0 ");
			ps.setInt(1, isRegistered);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	
	
	public ArrayList<User> readSomeByIsRegistered(int isRegistered) {
		Tester.markHere("UserDAO.getUnregisterUsersByType");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where isUsed=? ORDER BY studentId");
			ps.setInt(1, isRegistered);
			rs = ps.executeQuery();
			while(rs.next()){
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 读取指定类型用户的总数目
	 * @param isInfoUsed
	 * @param isUserVerified
	 * @return
	 */
	
	public int readCountByType(int isInfoUsed, int isUserVerified) {
		int count = -1;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER +
					" where isVerified=? and isUsed=?");
			ps.setInt(1, isUserVerified);
			ps.setInt(2, isInfoUsed);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	
	/**
	 * 读取今天内验证用户的总数目
	 * @param isInfoUsed
	 * @param isUserVerified
	 * @return
	 */
	
	public int readCountVerifiedToday() {
		int count = 0;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER +
					" where isVerified=? and timestampdiff(day ,verifiedTime,now())=0");
			ps.setInt(1, Values.USER_VERIFIED);
			rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}

	
	public String updateUserStatus(int uid, int userVerified, Date verifiedTime) {
		Tester.markHere("UserDAO.updateUserStatus");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER + 
					" set isVerified=?,verifiedTime=? where userId=?");
			int i = 1;
			ps.setInt(i++, userVerified);
			ps.setTimestamp(i++, new Timestamp(verifiedTime.getTime()));
			ps.setInt(i++, uid);
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
				flag = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}
	
	public String updateUserIsUsed(int uid, int isUsed) {
		Tester.markHere("UserDAO.updateUserIsUsed");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.USER + 
					" set isUsed=? where userId=?");
			ps.setInt(1, isUsed);
			ps.setInt(2, uid);
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
				flag = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}

	/**
	 * @param infoUsed
	 * @param userVerified
	 */
	
	public ArrayList<User> readSomeByType(int isInfoUsed, int isUserVerified) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + " where isVerified=? and isUsed=? ORDER BY updateTime DESC");
			ps.setInt(1, isUserVerified);
			ps.setInt(2, isInfoUsed);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}
	/**
	 * @param someInfo
	 * @param page
	 * @return
	 */
	
	public ArrayList<User> readSomeBySomeInfo(String someInfo, int page) {
		Tester.markHere("UserDAO.readSomeBySomeInfo");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + 
					" where username like ? or email like ? or name like ? " +
					"or qq like ? or weibo like ? or blog like ? " +
					"or major like ? or studentId like ? or address like ? " +
					"or zone like ? or phoneLong like ? or phoneShort like ? " +
					"ORDER BY isVerified desc, isUsed desc, studentId limit ?,?");
			int i = 1;
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setInt(i++, (page - 1) * Values.PAGE_SIZE);
			ps.setInt(i++, Values.PAGE_SIZE);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 根据学院取出用户
	 * @param cid
	 * @param page
	 * @return
	 */
	
	public ArrayList<User> readSomeByCollege(int cid, int page) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<User> list = new ArrayList<User>();
		User one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.USER + 
					" where college=? " +
					"ORDER BY isVerified desc, isUsed desc, studentId limit ?,?");
			int i = 1;
			ps.setInt(i++, cid);
			ps.setInt(i++, (page - 1) * Values.PAGE_SIZE);
			ps.setInt(i++, Values.PAGE_SIZE);
			rs = ps.executeQuery();
			while(rs.next()){
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 根据学院取出用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	
	public int readCountSomeByCollege(int cid) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + 
					" where college=? ");
			int i = 1;
			ps.setInt(i++, cid);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	/**
	 * 根据学院取出的是否验证用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	
	public int readCountSomeByCollegeAndIsVerified(int cid, int isVerified) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + 
					" where college=? and isVerified=?");
			int i = 1;
			ps.setInt(i++, cid);
			ps.setInt(i++, isVerified);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	

	/**
	 * 根据学院取出的注册或未注册用户的总数
	 * @param cid
	 * @param page
	 * @return
	 */
	
	public int readCountSomeByCollegeAndIsUsed(int cid, int isUsed) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + 
					" where college=? and isUsed=?");
			int i = 1;
			ps.setInt(i++, cid);
			ps.setInt(i++, isUsed);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	
	/**
	 * @param someInfo
	 * @param page
	 * @return
	 */
	
	public int readCountSomeBySomeInfo(String someInfo) {
		Tester.markHere("UserDAO.readSomeBySomeInfo");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.USER + 
					" where username like ? or email like ? or name like ? " +
					"or qq like ? or weibo like ? or blog like ? " +
					"or major like ? or studentId like ? or address like ? " +
					"or zone like ? or phoneLong like ? or phoneShort like ? ");
			int i = 1;
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			ps.setString(i++, "%" + someInfo + "%");
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}
	
	public List selectWithOneCondition(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
