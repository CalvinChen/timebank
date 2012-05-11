/**
 * @Project TimeBank
 * @CreatedTime 2011-10-24 下午07:16:54 
 * @Author CK
 * @Todo TODO
 */
package timebank.business.user;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.cookie.CookieUser;
import timebank.persistence.CookieDao;

/**
 * @author CK
 *
 */
@Service
public class UserCookieManager {
//	@Resource
	private CookieDao cookieDao;

	/**
	 * @return the cookieDao
	 */
	public CookieDao getCookieDao() {
		return cookieDao;
	}

	/**
	 * @param cookieDao the cookieDao to set
	 */
	public void setCookieDao(CookieDao cookieDao) {
		this.cookieDao = cookieDao;
	}

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public String createOne(String userId, String sessionId) {
		CookieUser one = new CookieUser();
//		one.setUserId(userId);
//		one.setSessionId(sessionId);
		int count = cookieDao.readIsHaveUserId(userId);
		if(count != 0){
			cookieDao.deleteOne(userId);
		}
		return cookieDao.createOne(one); 
	}

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CookieUser readOne(String userId, String sessionId) {
		CookieUser one = new CookieUser();
//		one.setUserId(userId);
//		one.setSessionId(sessionId);
		return cookieDao.readOne(one);
	}

	/**
	 * @param userId
	 * @return
	 */
	public String deleteOne(int userId) {
		return cookieDao.deleteOne(userId + "");
	}
	
}
