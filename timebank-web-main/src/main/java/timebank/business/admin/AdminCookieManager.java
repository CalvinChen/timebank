/**
 * @Project TimeBank
 * @CreatedTime 2011-10-24 下午07:16:54 
 * @Author CK
 * @Todo TODO
 */
package timebank.business.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import timebank.model.cookie.CookieAdmin;
import timebank.persistence.CookieAdminDao;

/**
 * @author CK	
 *
 */
@Service
public class AdminCookieManager {
//	@Resource
	private CookieAdminDao cookieAdminDao;

	/**
	 * @return the cookieAdminDao
	 */
	public CookieAdminDao getCookieAdminDao() {
		return cookieAdminDao;
	}

	/**
	 * @param cookieAdminDao the cookieAdminDao to set
	 */
	public void setCookieAdminDao(CookieAdminDao cookieAdminDao) {
		this.cookieAdminDao = cookieAdminDao;
	}

	/**
	 * @param adminId
	 * @param sessionId
	 * @return
	 */
	public String createOne(String adminId, String sessionId) {
		CookieAdmin one = new CookieAdmin();
//		one.setAdminId(adminId);
//		one.setAdminSessionId(sessionId);
		int count = cookieAdminDao.readIsHaveAdminId(adminId);
		if(count != 0){
			cookieAdminDao.deleteOne(adminId);
		}
		return cookieAdminDao.createOne(one); 
	}

	/**
	 * @param userId
	 * @param sessionId
	 * @return
	 */
	public CookieAdmin readOne(String adminId, String sessionId) {
		CookieAdmin one = new CookieAdmin();
//		one.setAdminId(adminId);
//		one.setAdminSessionId(sessionId);
		return cookieAdminDao.readOne(one);
	}

	/**
	 * @param adminId
	 * @return
	 */
	public String deleteOne(int adminId) {
		return cookieAdminDao.deleteOne(adminId + "");
	}
	
}
