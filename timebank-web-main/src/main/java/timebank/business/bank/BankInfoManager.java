package timebank.business.bank;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.*;
import timebank.persistence.BankInfoDao;
import timebank.persistence.HelpRecordDao;
import timebank.persistence.UserDao;
@Service
public class BankInfoManager {

//	@Resource
	private HelpRecordDao helpRecordDao;
//	@Resource
	private BankInfoDao bankInfoDao;
	@Resource
	private UserDao userDao;
	
	/**
	 * @return the helpRecordDao
	 */
	public HelpRecordDao getHelpRecordDao() {
		return helpRecordDao;
	}

	/**
	 * @param helpRecordDao the helpRecordDao to set
	 */
	public void setHelpRecordDao(HelpRecordDao helpRecordDao) {
		this.helpRecordDao = helpRecordDao;
	}

	/**
	 * @return the bankInfoDao
	 */
	public BankInfoDao getBankInfoDao() {
		return bankInfoDao;
	}

	/**
	 * @param bankInfoDao the bankInfoDao to set
	 */
	public void setBankInfoDao(BankInfoDao bankInfoDao) {
		this.bankInfoDao = bankInfoDao;
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
	 * 获取某个用户的时间币余额
	 * @param userId 该用户的ID
	 * @return 用户余额
	 */
	public double getBalanceByUserId(int userId) {
		return bankInfoDao.readBalanceByUserId(userId);
	}
	
	public BankInfoRecord getOnesBankInfo(int userId) {
		BankInfoRecord one = bankInfoDao.readOneByUserId(userId);
		return one;
	}
}
