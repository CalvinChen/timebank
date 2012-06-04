/**
 * @Project TimeBank
 * @CreatedTime 2011-10-24 下午07:27:41 
 * @Author CK
 * @Todo TODO
 */
package timebank.util.web.cookie;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import timebank.business.cookie.AdminCookieManager;
import timebank.business.cookie.UserCookieManager;
import timebank.model.admin.Admin;
import timebank.model.cookie.CookieAdmin;
import timebank.model.cookie.CookieUser;
import timebank.model.user.User;
import timebank.util.lang.string.StringUtil;
import timebank.util.web.action.ActionUtil;

/**
 * @author CK
 *
 */
public class CookieUtil {

	public static final String ADMIN_ID = "adminId";
	public static final String USER_ID = "userId";
	public static final String ADMIN_SESSION_ID = "adminSessionId";
	public static final String USER_SESSION_ID = "userSessionId";
	
	public static final int COOKIE_AGE_ONE_MONTH = 60*60*24*30;

	@Resource
	private static UserCookieManager userCookieManager;
	
	@Resource
	private static AdminCookieManager adminCookieManager;

	public static UserCookieManager getUserCookieManager() {
		return userCookieManager;
	}

	public static void setUserCookieManager(UserCookieManager userCookieManager) {
		CookieUtil.userCookieManager = userCookieManager;
	}

	public String getValueByName(String name, Cookie[] list){
		int length = list.length;
		Cookie one = null;
		String value = null;
		for (int i = 0; i < length; i++) {
			one = list[i];
			if(one.getName().equals(name)){
				value = one.getValue();
			}
		}
		return value;
	}
	
	/**
	 * add cookie to both client side and server side.
	 * @param id usually to be user id or admin id.
	 * @param identityType must be {@link StringUtil#USER} or {@link StringUtil#ADMIN}
	 */
	public static void addCookie(int id, String identityType){
		String sessionId = ActionUtil.getSessionId();
		
		String propertyId = null;
		String propertySessionId = null;
		if(identityType.equals(StringUtil.USER)){
			propertyId = USER_ID;
			propertySessionId = USER_SESSION_ID;
		} else {
			propertyId = ADMIN_ID;
			propertySessionId = ADMIN_SESSION_ID;
		}
		
		Cookie idCookie = new Cookie(propertyId, id + "");
		Cookie sessionIdCookie = new Cookie(propertySessionId, sessionId);
		idCookie.setMaxAge(COOKIE_AGE_ONE_MONTH);
		sessionIdCookie.setMaxAge(COOKIE_AGE_ONE_MONTH);
		ActionUtil.addCookieToClient(idCookie);
		ActionUtil.addCookieToClient(sessionIdCookie);
		
		if(StringUtil.USER.equals(identityType)){
			User user = new User(id);
			CookieUser cookieUser = new CookieUser(user, sessionId);
			userCookieManager.add(cookieUser);	
		} else {
			Admin admin = new Admin(id);
			CookieAdmin cookieAdmin = new CookieAdmin(admin, sessionId);
			adminCookieManager.add(cookieAdmin);
		}
	}
}
