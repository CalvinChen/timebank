package tk.persistence;

import timebank.model.cookie.CookieAdmin;

public interface CookieAdminDao {

	/**
	 * 向数据库中新增一则cookies记录
	 * @param one
	 * @return
	 */
	public abstract String createOne(CookieAdmin one);

	public abstract CookieAdmin readOne(CookieAdmin one);

	public abstract String deleteOne(String adminId);

	/**
	 * @param adminId
	 * @return
	 */
	public abstract int readIsHaveAdminId(String adminId);

}