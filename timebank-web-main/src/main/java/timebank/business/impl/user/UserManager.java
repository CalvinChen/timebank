package timebank.business.impl.user;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import timebank.business.user.IUserManager;
import timebank.model.user.User;
import timebank.persistence.impl.hibernate.user.HUserDao;
import timebank.persistence.user.UserDao;
import timebank.util.database.HibernateUtil;
import timebank.util.lang.collection.ListUtil;
import timebank.util.lang.exception.NoSuchUserException;
import timebank.util.lang.exception.PasswordConfirmException;

@Service
@Transactional
public class UserManager implements IUserManager{
	@Resource
	private UserDao userDao;
	
	@Resource
	private HibernateUtil dao;
	
	/* business method */

	public int register(User user) {
		dao.save(user.getBankInfo());
		dao.save(user.getUserInfo());
		int id = add(user);
		return id;
	}

	@Override
	public int register(User user, String passwordConfirm) throws PasswordConfirmException {
		if(passwordConfirm.equals(user.getPassword()) == false){
			throw new PasswordConfirmException(user.getPassword(), passwordConfirm);
		}
		return register(user);
	}

	@Override
	public User login(User user, boolean addCookie) {
		List<User> list = userDao.select(
				Restrictions.eq("loginName", user.getLoginName()),
				Restrictions.eq("password", user.getPassword()));
		if(ListUtil.isEmpty(list)){
			throw new NoSuchUserException(user.getLoginName(), user.getPassword());
		}
		return list.get(0);
	}
	
	@Override
	public boolean checkEmailDuplicate(String email){
		List<User> list = userDao.select(Restrictions.eq("loginName", email));
		if(ListUtil.isEmpty(list)){
			return true;
		}
		return false;
	}	
	
	@Override
	public boolean checkDisplayNameDuplicate(String displayName){
		List<User> list = userDao.select(Restrictions.eq("displayName", displayName));
		if(ListUtil.isEmpty(list)){
			return true;
		}
		return false;
	}
	
	/* atom method */
	
	public int add(User t) {
		return userDao.save(t);
	}

	public void remove(User t) {
		userDao.delete(t);
	}

	public void remove(int id) {
		userDao.delete(id);
	}

	public User get(int id) {
		return userDao.select(id);
	}

	public void update(User t) {
		userDao.update(t);
	}

	/* getter and setter */
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public HibernateUtil getDao() {
		return dao;
	}

	public void setDao(HibernateUtil dao) {
		this.dao = dao;
	}

	
}
