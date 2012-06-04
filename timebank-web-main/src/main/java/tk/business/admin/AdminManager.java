package tk.business.admin;


import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.admin.Admin;
import timebank.model.user.User;
import timebank.persistence.user.UserDao;
import tk.persistence.AdminDao;
import tk.util.bean.Values;
@Service
public class AdminManager {
//	@Resource
	private AdminDao adminDao;
	@Resource
	private UserDao userDao;
	
	/**
	 * @return the adminDao
	 */
	public AdminDao getAdminDao() {
		return adminDao;
	}
	/**
	 * @param adminDao the adminDao to set
	 */
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}
	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 管理员登录方法
	 * @param oneInput 要登录的管理账号
	 * @return 已登录的管理账号
	 */
	public Admin login(Admin oneInput) {
		Admin oneDatabase = adminDao.readOne(oneInput.getLoginName());
		if(oneDatabase == null || 
				oneDatabase.getPassword().equals(oneInput.getPassword()) == false){
			return null;
		}else{
			return oneDatabase;
		}
	}
	/**
	 * @param p
	 * @return
	 */
	public ArrayList<Admin> readAllbyPage(int p) {
		return adminDao.readSomeByPage(p);
	}
	/**
	 * @return
	 */
	public int readCountAll() {
		return adminDao.readCountAll();
	}

	public String createOne(Admin one){
		String username = one.getLoginName();
		if(adminDao.readOne(username) == null){
			return adminDao.createOne(one);
		}else return "用户名重复！";
	}
	/**
	 * @param adminId
	 * @return
	 */
	public Admin readOne(int adminId) {
		return adminDao.readOne(adminId);
	}
	/**
	 * @param one
	 * @return
	 */
	public String updateOne(Admin one) {
		Admin oldOne = adminDao.readOne(one.getId());
		if(one.getPassword() == null || one.getPassword().length() == 0){
			one.setPassword(oldOne.getPassword());
		}
//		one.setLinkedUserId(oldOne.getLinkedUserId());
		return adminDao.updateOne(one);
	}
	/**
	 * @param uid
	 * @return
	 */
	public String promote(int uid) {
		User user = userDao.select(uid);
		Admin admin = adminDao.readOne(user.getLoginName());
		if(admin != null){
			return "此用户名重复！可能已经是管理员了。";
		}
		admin = new Admin();
//		admin.setAdminLevel(Values.ADMIN_NORMAL);
//		admin.setLinkedUserId(user.getUserId());
		admin.setPassword(user.getPassword());
		admin.setLoginName(user.getLoginName());
		return adminDao.createOneByPromote(admin);
	}
	/**
	 * @param aid
	 * @return
	 */
	public String deleteOne(int aid) {
		return adminDao.deleteOne(aid);
	}
	/**
	 * @param aid
	 * @return
	 */
	public String removeLink(int aid) {
		Admin admin = adminDao.readOne(aid);
//		admin.setLinkedUserId(0);
		return adminDao.updateOne(admin);
	}
}
