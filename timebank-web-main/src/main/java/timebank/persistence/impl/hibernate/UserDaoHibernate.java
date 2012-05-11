package timebank.persistence.impl.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import timebank.model.user.User;
import timebank.persistence.UserDao;

@Repository
public class UserDaoHibernate implements UserDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	private Session session;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	
	@Override
	public User select(int uid) {
		session = getSession();
		User user = (User)session.get(User.class, uid + "");
		session.close();
		return user;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List selectWithOneCondition(String key, String value) {
		session = getSession();
		@SuppressWarnings("unchecked")
		List<User> list = session.createQuery("select u from User u where u." + key + " = :value")
				.setString("value", value + "")
				.list();
		session.close();
		return list;
	}

	@Override
	public User readOneByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readOneByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(User user) {
		session = getSession();
		session.save(user.getUserInfo());
		Integer pk = (Integer) session.save(user);
		session.close();
		return pk;
	}

	@Override
	public String updateUserInfo(int userId, String name, String studentId,
			String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readIdByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String readPasswordById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserInfoByUserId(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAllInfoByUserId(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserContactByUserId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateVerifiedTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserPSWByUserId(int userId, String psw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readUsernameByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePhoto(int userId, String picture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String readPhotoById(int helpedUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String verifyInfo(String name, String studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOne(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<User> readSomeByType(int isInfoUsed, int isUserVerified,
			int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> readSomeByIsRegistered(int isRegistered, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readCountByIsRegistered(int isRegistered) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readCountByIsRegisteredToday(int isRegistered) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<User> readSomeByIsRegistered(int isRegistered) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readCountByType(int isInfoUsed, int isUserVerified) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readCountVerifiedToday() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updateUserStatus(int uid, int userVerified, Date verifiedTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUserIsUsed(int uid, int isUsed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> readSomeByType(int isInfoUsed, int isUserVerified) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> readSomeBySomeInfo(String someInfo, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> readSomeByCollege(int cid, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readCountSomeByCollege(int cid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readCountSomeByCollegeAndIsVerified(int cid, int isVerified) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readCountSomeByCollegeAndIsUsed(int cid, int isUsed) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int readCountSomeBySomeInfo(String someInfo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
