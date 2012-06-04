/**
 * @Project TimeBank
 * @CreatedTime 2011-10-24 下午07:16:54 
 * @Author CK
 * @Todo TODO
 */
package tk.business.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import timebank.business.BaseManager;
import timebank.model.cookie.CookieAdmin;
import tk.persistence.CookieAdminDao;

/**
 * @author CK	
 *
 */
@Service
public class AdminCookieManager implements BaseManager<CookieAdmin>, AdminCookieManagerImpl{
//	@Resource
	private CookieAdminDao cookieAdminDao;

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#getCookieAdminDao()
	 */
	@Override
	public CookieAdminDao getCookieAdminDao() {
		return cookieAdminDao;
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#setCookieAdminDao(timebank.persistence.CookieAdminDao)
	 */
	@Override
	public void setCookieAdminDao(CookieAdminDao cookieAdminDao) {
		this.cookieAdminDao = cookieAdminDao;
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#createOne(java.lang.String, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#readOne(java.lang.String, java.lang.String)
	 */
	@Override
	public CookieAdmin readOne(String adminId, String sessionId) {
		CookieAdmin one = new CookieAdmin();
//		one.setAdminId(adminId);
//		one.setAdminSessionId(sessionId);
		return cookieAdminDao.readOne(one);
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#deleteOne(int)
	 */
	@Override
	public String deleteOne(int adminId) {
		return cookieAdminDao.deleteOne(adminId + "");
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#add(timebank.model.cookie.CookieAdmin)
	 */
	@Override
	public int add(CookieAdmin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#remove(timebank.model.cookie.CookieAdmin)
	 */
	@Override
	public void remove(CookieAdmin t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#remove(int)
	 */
	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#get(int)
	 */
	@Override
	public CookieAdmin get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see timebank.business.admin.AdminCookieManagerImpl#update(timebank.model.cookie.CookieAdmin)
	 */
	@Override
	public void update(CookieAdmin t) {
		// TODO Auto-generated method stub
		
	}
	
}
