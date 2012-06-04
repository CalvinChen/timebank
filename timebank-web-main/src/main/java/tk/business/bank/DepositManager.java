/**
 * @Project TimeBank
 * @CreatedTime 2011-10-15 下午04:42:56 
 * @Author CK
 * @Todo TODO
 */
package tk.business.bank;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.WithdrawRecord;
import timebank.model.bank.BankInfo;
import timebank.model.bank.SideRecord;
import timebank.util.database.DBConnection;
import tk.persistence.BankInfoDao;
import tk.persistence.DepositDao;
import tk.persistence.impl.jdbc.UserDaoImpl;
import tk.util.Tester;
import tk.util.bean.DatabaseTable;
import tk.util.bean.StatusOfRecord;
import tk.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class DepositManager {

//	@Resource
	private DepositDao depositDao;
//	@Resource
	private BankInfoDao bankInfoDao;

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
	 * @return the depositDao
	 */
	public DepositDao getDepositDao() {
		return depositDao;
	}

	/**
	 * @param depositDao the depositDao to set
	 */
	public void setDepositDao(DepositDao depositDao) {
		this.depositDao = depositDao;
	}

	/**
	 * 获得某个用户所有的存储记录
	 * @param userId 该用户的用户编号
	 * @return 该用户所有的存储记录表
	 */
	public ArrayList<SideRecord> getOnesDeposit(int userId) {
		ArrayList<SideRecord> result = depositDao.readSomeByUserId(userId);
		return result;
	}

	/**
	 * 根据存储编号取得一条存储记录
	 * @param depositId 存储编号
	 * @return 欲取得的存储记录
	 */
	public SideRecord getOneDepositByDepositId(int depositId) {
		SideRecord one = depositDao.readOneById(depositId);
		return one;
	}

	/**
	 * 获得所有对应状态的存储记录
	 * @return 数据库中所有对应状态的存储记录
	 */
	public ArrayList<SideRecord> getDepositsByStatusLimit(int status, int p) {
		ArrayList<SideRecord> result = depositDao.readSomeByStatusLimit(status, p);
		return result;
	}
	/**
	 * 获得所有对应状态的存储记录
	 * @param p 
	 * @return 数据库中所有对应状态的存储记录
	 */
	public ArrayList<SideRecord> getDepositsByStatus(int status, int p) {
		ArrayList<SideRecord> result = depositDao.readSomeByStatusLimit(status, p);
		return result;
	}

	/**
	 * 增加一名用户的预存储时间
	 * @param one 预存储时间的详细信息
	 * @param userId 用户的编号
	 * @return 结果
	 */
	public String addOneDeposit(SideRecord one, int userId) {
		//增加记录
//		one.setUserId(userId);
//		if(one.getMode() == Values.MODE_EXPIRE){
//			one.setSeekLeft(0);
//			one.setSeekNumber(0);
//		}
		String result = depositDao.createOne(one);
		
		if(result.equals(Values.SUCCESS)){
			
			//更新统计数据
			String re = bankInfoDao.updateOne(userId, 0, 1, 0, 0, 0, 0);
			if(re.equals(Values.SUCCESS) == false){
				return "更新统计数据出错";
			}
		}
		return result;
	}

	/**
	 * @param depositRecord
	 * @return
	 */
//	public String updateOneById(BankCoreBusiness newD) {
//
//		//逻辑问题，保证已申请人数不变
//		BankCoreBusiness oldD = depositDao.readOneById(newD.getBankCoreBusinessId());
//		int seeked = oldD.getSeekNumber() - oldD.getSeekLeft();
//		int newNumber = seeked + newD.getSeekLeft();
//		newD.setSeekNumber(newNumber);
//		
//		//更新模式1\2相关状态变动
//		if(oldD.getStatus() == StatusOfRecord.UNMATCHED && newD.getSeekLeft() == 0 &&
//				(newD.getMode() == Values.MODE_SEEK || newD.getMode() == Values.MODE_BOTH)){
//			depositDao.updateStatusById(newD.getBankCoreBusinessId(), StatusOfRecord.SEEKED);
//		}else if(oldD.getStatus() != StatusOfRecord.UNMATCHED && newD.getSeekLeft() != 0 &&
//				(newD.getMode() == Values.MODE_SEEK || newD.getMode() == Values.MODE_BOTH)){
//			depositDao.updateStatusById(newD.getBankCoreBusinessId(), StatusOfRecord.UNMATCHED);
//		}
//		
//		String result = depositDao.updateOneById(newD);
//		updateExpired();
//		return result;
//	}
	

	/**
	 * 根据ID删除一条存储记录
	 * @param did 存储记录的ID
	 * @return
	 */
	public String deleteOne(int did) {
		return depositDao.deleteOne(did);
	}
	

	public int readTodayNewCount() {
		return depositDao.readTodayNewCount();
	}

	/**
	 * @param verifying
	 * @return
	 */
	public int getCountDepositsByStatus(int verifying) {
		return depositDao.readCountDepositsByStatus(verifying);
	}

	/**
	 * 
	 */
	public void updateExpired() {
		int count = depositDao.updateExpired();
		Tester.markHere("处理了" + count + "条过期记录！");
		count = depositDao.updateNotExpired();
		Tester.markHere("处理了" + count + "条重新生效记录！");
		
	}

	/**
	 * @param userId
	 * @param did
	 * @return
	 */
//	public String closeDeposit(int userId, int did) {
//		BankCoreBusiness one = depositDao.readOneById(did);
//		if(one.getUserId() != userId){
//			return "请勿非法关闭不属于自己的记录！";
//		}
//		int validNumber = one.getSeekNumber() - one.getSeekLeft();
//		String result = depositDao.updateModesById(did, Values.MODE_SEEK, 0, validNumber);
//		String result1 = depositDao.updateStatusById(did, StatusOfRecord.SEEKED);
//		if(result.equals(Values.SUCCESS) && result1.equals(Values.SUCCESS)){
//			return Values.SUCCESS;
//		}else return "关闭记录出错！请向我们反馈。";
//	}

	/**
	 * @param status
	 * @return
	 */
	public ArrayList<SideRecord> getTopAndDetailedDepositsByStatus(int status) {
		return depositDao.getDisplayDepositsByStatus(status, Values.YES, Values.YES);
	}
	public ArrayList<SideRecord> getTopAndNotDetailedDepositsByStatus(int status) {
		return depositDao.getDisplayDepositsByStatus(status, Values.YES, Values.NO);
	}

	/**
	 * @param status
	 * @param p
	 * @return
	 */
	public ArrayList<SideRecord> getNormalDepositsByStatusLimit(
			int status, int p) {
		return depositDao.getDisplayDepositsByStatusLimit(status, Values.NO, Values.NO, p);
	}

	/**
	 * @param unmatched
	 * @return
	 */
	public int getCountNormalDepositsByStatus(int status) {
		return depositDao.getCountDisplayDepositsByStatus(status,Values.NO, Values.NO);
	}
}
