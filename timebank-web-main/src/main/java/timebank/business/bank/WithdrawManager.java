/**
 * @Project TimeBank
 * @CreatedTime 2011-10-15 下午04:43:11 
 * @Author CK
 * @Todo TODO
 */
package timebank.business.bank;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timebank.model.BankInfoRecord;
import timebank.model.WithdrawRecord;
import timebank.model.bank.BankCoreBusiness;
import timebank.persistence.BankInfoDao;
import timebank.persistence.WithdrawDao;
import timebank.persistence.impl.jdbc.UserDaoImpl;
import timebank.util.Tester;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class WithdrawManager {

//	@Resource
	private WithdrawDao withdrawDao;
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
	 * @return the withdrawDao
	 */
	public WithdrawDao getWithdrawDao() {
		return withdrawDao;
	}

	/**
	 * @param withdrawDao the withdrawDao to set
	 */
	public void setWithdrawDao(WithdrawDao withdrawDao) {
		this.withdrawDao = withdrawDao;
	}

	/**
	 * 根据提取编号取出一条提取记录
	 * @param withdrawId 提取编号
	 * @return 提取记录
	 */
	public WithdrawRecord getOneWithdrawByWithdrawId(int withdrawId) {
		WithdrawRecord one = withdrawDao.readOneById(withdrawId);
		return one;
	}

	/**
	 * 获得某个用户所有的提取记录
	 * @param userId 该用户的用户编号
	 * @return 该用户所有的提取记录表
	 */
	public ArrayList<WithdrawRecord> getOnesWithdraw(int userId) {
		ArrayList<WithdrawRecord> result = withdrawDao.readSomeByUserId(userId);
		return result;
	}

	/**
	 * 获得所有未配对的提取记录
	 * @param p 
	 * @return 数据库中所有未配对的提取记录
	 */
	public ArrayList<WithdrawRecord> getAllUnmatchWithdraw(int p) {
		ArrayList<WithdrawRecord> result = withdrawDao.readSomeByIsMatched(StatusOfRecord.UNMATCHED, p);
		return result;
	}

	/**
	 * 增加一条用户的预提取记录
	 * @param one 预提取记录的详细内容
	 * @param userId 用户的编号
	 * @return 增加的结果
	 */
	public String addOneWithdraw(WithdrawRecord one, int userId) {
		one.setUserId(userId);
		if(one.getMode() == Values.MODE_EXPIRE){
			one.setSeekLeft(0);
			one.setSeekNumber(0);
		}
		//增加记录
		String result = withdrawDao.createOne(one);
		if(result.equals(Values.SUCCESS)){
			
			//更新统计数据
			String re = bankInfoDao.updateOne(userId, 0, 0, 0, 1, 0, 0);
			if(re.equals(Values.SUCCESS) == false){
				return "更新统计数据出错";
			}
		}
		return result;
	}
	

	/**
	 * 获得所有对应状态的提取记录
	 * @return 数据库中所有对应状态的提取记录
	 */
	public ArrayList<WithdrawRecord> getWithdrawsByStatus(int status, int p) {
		ArrayList<WithdrawRecord> result = withdrawDao .readSomeByStatusLimit(status, p);
		return result;
	}

	/**
	 * @param newW
	 * @return
	 */
	public String updateOneById(WithdrawRecord newW) {
		
		//逻辑问题，保证已申请人数不变
		WithdrawRecord oldW = withdrawDao.readOneById(newW.getBankCoreBusinessId());
		int seeked = oldW.getSeekNumber() - oldW.getSeekLeft();
		int newNumber = seeked + newW.getSeekLeft();
		newW.setSeekNumber(newNumber);
		
		//从未匹配到匹配好，及相反等
		if(oldW.getStatus() == StatusOfRecord.UNMATCHED && newW.getSeekLeft() == 0 &&
				(newW.getMode() == Values.MODE_SEEK || newW.getMode() == Values.MODE_BOTH)){
			withdrawDao.updateStatusById(newW.getBankCoreBusinessId(), StatusOfRecord.SEEKED);
		}else if(oldW.getStatus() != StatusOfRecord.UNMATCHED && newW.getSeekLeft() != 0 &&
				(newW.getMode() == Values.MODE_SEEK || newW.getMode() == Values.MODE_BOTH)){
			withdrawDao.updateStatusById(newW.getBankCoreBusinessId(), StatusOfRecord.UNMATCHED);
		}
		
		String result = withdrawDao.updateOneById(newW); 
		updateExpired();
		return result;
	}

	/**
	 * 根据ID删除一条提取记录
	 * @param wid 提取记录的ID
	 * @return
	 */
	public String deleteOne(int wid) {
		return withdrawDao.deleteOne(wid);
	}


	public int readTodayNewCount() {
		return withdrawDao.readTodayNewCount();
	}

	/**
	 * @param verified
	 * @return
	 */
	public int getCountWithdrawsByStatus(int verified) {
		return withdrawDao.readCountSomeByStatus(verified);
	}
	public void updateExpired() {
		int count = withdrawDao.updateExpired();
		Tester.markHere("处理了" + count + "条过期记录！");
		count = withdrawDao.updateNotExpired();
		Tester.markHere("处理了" + count + "条重新生效记录！");
	}

	/**
	 * @param userId
	 * @param wid
	 * @return
	 */
	public String closeWithdraw(int userId, int wid) {
		WithdrawRecord one = withdrawDao.readOneById(wid);
		if(one.getUserId() != userId){
			return "请勿非法关闭不属于自己的记录！";
		}
		int validNumber = one.getSeekNumber() - one.getSeekLeft();
		String result = withdrawDao.updateModesById(wid, Values.MODE_SEEK, 0, validNumber);
		String result1 = withdrawDao.updateStatusById(wid, StatusOfRecord.SEEKED);
		if(result.equals(Values.SUCCESS) && result1.equals(Values.SUCCESS)){
			return Values.SUCCESS;
		}else return "关闭记录出错！请向我们反馈。";
	}

	/**
	 * @return
	 */
	public int getCountAllUnmatchWithdraw() {
		return withdrawDao.readCountSomeByStatus(StatusOfRecord.UNMATCHED);
	}

	public ArrayList<WithdrawRecord> getTopAndDetailedWithdrawsByStatus(int status) {
		return withdrawDao.getDisplayWithdrawsByStatus(status, Values.YES, Values.YES);
	}
	public ArrayList<WithdrawRecord> getTopAndNotDetailedWithdrawsByStatus(int status) {
		return withdrawDao.getDisplayWithdrawsByStatus(status, Values.YES, Values.NO);
	}

	/**
	 * @param unmatched
	 * @param p
	 * @return
	 */
	public ArrayList<WithdrawRecord> getNormalWithdrawsByStatusLimit(
			int status, int p) {
		return withdrawDao.getDisplayWithdrawsByStatusLimit(status, Values.NO, Values.NO, p);
	}

	/**
	 * @param unmatched
	 * @return
	 */
	public int getCountNormalWithdrawsByStatus(int status) {
		return withdrawDao.getCountDisplayWithdrawsByStatus(status, Values.NO, Values.NO);
	}
}
