package timebank.persistence;

import timebank.model.cookie.CookieUser;

public interface CookieDao {

	/**
	 * 向数据库中新增一则cookies记录
	 * @param one
	 * @return
	 */
	public abstract String createOne(CookieUser one);

	public abstract CookieUser readOne(CookieUser one);

	public abstract String deleteOne(String userId);

	/**
	 * @param userId
	 * @return
	 */
	public abstract int readIsHaveUserId(String userId);

}