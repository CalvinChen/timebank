/**
 * @Project TimeBank
 * @CreatedTime 2011-10-15 下午04:43:29 
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
import timebank.model.bank.BankCompleteRecord;
import timebank.model.bank.BankCoreBusiness;
import timebank.persistence.BankInfoDao;
import timebank.persistence.DepositDao;
import timebank.persistence.HelpRecordDao;
import timebank.persistence.UserDao;
import timebank.persistence.WithdrawDao;
import timebank.util.Tester;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class HelpRecordManager {

//	@Resource
	private HelpRecordDao helpRecordDao;
//	@Resource
	private BankInfoDao bankInfoDao;
	@Resource
	private UserDao userDao;
//	@Resource
	private DepositDao depositDao;
//	@Resource
	private WithdrawDao withdrawDao;

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
	 * 将互助记录置为失败的部分
	 * @param helpRecordId
	 * @param whyFailure
	 * @param failureBy
	 */
	public String updateFailPartById(int helpRecordId, String whyFailure, int failureBy) {
		String result = helpRecordDao.updateWhyFailureById(helpRecordId, whyFailure, failureBy);
		if(result.equals(Values.SUCCESS)){
			
			//反馈失败没问题，那么就将链接的记录的状态更新为失败！
			helpRecordDao.updateStatusById(helpRecordId, StatusOfRecord.FAILURE);
//			HelpRecord h = helpRecordDao.readOne(helpRecordId);
//			if(h.getLinkDepositId() != 0){
//				depositDao.updateStatusById(h.getLinkDepositId(), StatusOfRecord.FAILURE);
//			}
//			if(h.getLinkWithdrawId() != 0){
//				withdrawDao.updateStatusById(h.getLinkWithdrawId(), StatusOfRecord.FAILURE);
//			}
			
			helpRecordDao.updateStatusById(helpRecordId, StatusOfRecord.FAILURE);
		}
		return result;
	}

	/**
	 * 更新互助记录反馈的部分
	 * @param requireByToHelp
	 * @param helpRecordId
	 * @param userToHelpScore
	 * @param userToHelpFeedback
	 * @return
	 */
	public String updateFBpartById(int requireBy, int userId ,int helpRecordId, double userScore, String userFeedback) {
		String result = Values.FAILURE;
		
		//读出被评价者的银行资料
		BankInfoRecord b = bankInfoDao.readOneByUserId(userId);
		double sum = b.getDepositCountValid() + b.getWithdrawCountValid(); 
		double newScore = (sum * b.getAverageScore() + userScore) / (sum + 1);
		b.setAverageScore(newScore);//计算新的好评度
		
		if(requireBy == Values.REQUIRE_BY_TO_HELP){
			//如果这是帮助者提交的反馈
			result = helpRecordDao.updateToHelpPartById(helpRecordId, userScore, userFeedback);
			b.setWithdrawCountValid(b.getWithdrawCountValid() + 1);
			b.setBalance(b.getBalance() - 1 + userScore/10);
			result = bankInfoDao.updateOne(b);

		}else{
			//如果这是求助者提交的反馈
			result = helpRecordDao.updateHelpedPartById(helpRecordId, userScore, userFeedback);
			b.setDepositCountValid(b.getDepositCountValid() + 1);//有效的帮助次数加1
			b.setBalance(b.getBalance() + 1 + userScore/10);//时间币加1加星级分
			result = bankInfoDao.updateOne(b);
		}
		if(result.equals(Values.SUCCESS)){
			//反馈更新没问题，那么就将状态更新为成功！
			helpRecordDao.updateStatusById(helpRecordId, StatusOfRecord.SUCCESS);
//			HelpRecord h = helpRecordDao.readOne(helpRecordId);
//			if(h.getLinkDepositId() != 0){
//				depositDao.updateStatusById(h.getLinkDepositId(), StatusOfRecord.SUCCESS);
//			}
//			if(h.getLinkWithdrawId() != 0){
//				withdrawDao.updateStatusById(h.getLinkWithdrawId(), StatusOfRecord.SUCCESS);
//			}
		}
		return result;
	}

	/**
	 * 【核心】将指定编号的互助记录的状态设置为指定状态
	 * @param helpRecordId 指定的互助记录的编号
	 * @param status 要设置的状态
	 * @return 设置结果
	 */
	public String updateStatusById(int helpRecordId, int status, int score, String whyVerifyFailure, String verifier) {
		//更新状态
		String result =  helpRecordDao.updateStatusById(helpRecordId, status);
		//取出记录，用于看是否有链接记录
		BankCompleteRecord one =  helpRecordDao.readOneById(helpRecordId);
//		if(one.getLinkDepositId() != 0){
//			//将链接的存储记录变为成功
//			String re = depositDao.updateStatusById(one.getLinkDepositId(), status);
//			if(re.equals(Values.FAILURE)){
//				return "链接存储记录状态更改有问题！";
//			}
//		}
//		if(one.getLinkWithdrawId() != 0){
//			//将链接的提取记录变为成功
//			String re = withdrawDao.updateStatusById(one.getLinkWithdrawId(), status);
//			if(re.equals(Values.FAILURE)){
//				return "链接提取记录状态更改有问题！";
//			}
//		}
		
		//如果是【互助成功】------------------------------------------------------
//		if(result == Values.SUCCESS && status == StatusOfRecord.SUCCESS){
//			if(one.getLinkDepositId() != 0){
//				//将会员的银行数据中的【存储有效数+1】
//				String re =  bankInfoDao  .updateOne(one.getToHelpUserId(), 1, 0, 1, 0, 0, 0);
//				if(re.equals(Values.FAILURE)){
//					return "用户银行数据更改有问题！";
//				}
//			}
//			if(one.getLinkWithdrawId() != 0){
//				//将会员的银行数据中的【提取有效数+1】
//				String re =  bankInfoDao.updateOne(one.getHelpedUserId(), -1, 0, 0, 0, 1, 0);
//				if(re.equals(Values.FAILURE)){
//					return "用户银行数据更改有问题！";
//				}
//			}
//		}
		
		//如果是【互助失败】------------------------------------------------------
//		if(result == Values.SUCCESS && status == StatusOfRecord.FAILURE){
//			if(one.getLinkDepositId() != 0){
//				//将会员的银行数据中的【存储有效数+1】
//				String re =  bankInfoDao  .updateOne(one.getToHelpUserId(), 1, 0, 1, 0, 0, 0);
//				if(re.equals(Values.FAILURE)){
//					return "用户银行数据更改有问题！";
//				}
//			}
//			if(one.getLinkWithdrawId() != 0){
//				//将会员的银行数据中的【提取有效数-1】
//				String re =  bankInfoDao.updateOne(one.getHelpedUserId(), -1, 0, 0, 0, -1, 0);
//				if(re.equals(Values.FAILURE)){
//					return "用户银行数据更改有问题！";
//				}
//			}
//		}

		//如果是【已确认，并通过】--------------------------------------------------
		if(result == Values.SUCCESS && status == StatusOfRecord.VERIFIED){
			//设置审核人
			String re = helpRecordDao.updateVerifyPartById(helpRecordId, verifier, "");
			if(re.equals(Values.FAILURE)){
				return "验证原因提交有问题！";
			}
			//发送站内消息
		}
		
		//如果是【已确认，不通过】--------------------------------------------------
		if(result == Values.SUCCESS && status == StatusOfRecord.VERIFIED_FAILURE){
			//发送站内消息
			String re = helpRecordDao.updateVerifyPartById(helpRecordId, verifier, whyVerifyFailure);
			if(re.equals(Values.FAILURE)){
				return "验证原因提交有问题！";
			}
		}
		return result;
	}

	/**
	 * 获取某个用户的所有互助记录
	 * @param userId 该用户的ID
	 * @return 该用户所有的互助记录
	 */
	public ArrayList<BankCompleteRecord> readSomeByUid(int userId) {
		ArrayList<BankCompleteRecord> list = helpRecordDao.readSomeByUserId(userId);
		return list;
	}

	/**
	 * 根据所指示的状态取出所有该状态的互助记录
	 * @param status 所指示的状态
	 * @return 所有该状态的互助记录列表 
	 */
	public ArrayList<BankCompleteRecord> readSomeByStatus(int status, int page) {
		ArrayList<BankCompleteRecord> list = helpRecordDao.readSomeByStatus(status, page);
		return list;
	}

	/**
	 * 【原子】根据记录编号取出该互助记录，并补全姓名
	 * @param helpRecordId 要取出的记录的编号
	 * @return 该互助记录
	 */
	public BankCompleteRecord readOneById(int helpRecordId) {
		//取出记录
		BankCompleteRecord helpRecord = helpRecordDao .readOneById(helpRecordId);
		return helpRecord;
	}

	/**
	 * 增加一条互助记录
	 * @param toHelpUserId 帮助者的用户编号
	 * @param helpedUserId 求助者的用户编号
	 * @param helpTime 互助的时间
	 * @param zoneHelp 互助的区域
	 * @param rangeHelp 互助的范围
	 * @param descriptionToHelp 帮助者的详细说明
	 * @param descriptionHelped 求助者的详细说明
	 * @param requireBy 此条互助记录是由谁申请的
	 * @param linkDepositId 此条互助记录是由哪条存储记录合成的
	 * @param linkWithdrawId 此条互助记录是由哪条提取记录合成的
	 * @return 增加的结果
	 */
	public String createOne(BankCompleteRecord one){
//		if(one.getLinkDepositId() != 0){
//			BankCoreBusiness depo = depositDao.readOneById(one.getLinkDepositId());
//			if(depo.getMode() != Values.MODE_EXPIRE){//过期模式不用管次数
//				if(depo.getSeekLeft() == 0){
//					return "抱歉，此记录已被别人匹配完了！";
//				}
//				if(depo.getSeekLeft() == 1){//剩余1，还可匹配，不过要置状态为“已达匹配次数”，并置次数为0
//					depositDao.updateStatusById(depo.getBankCoreBusinessId(), StatusOfRecord.SEEKED);
//					depositDao.updateSeekLeftById(one.getLinkDepositId(), 0);
//				}
//				depositDao.updateSeekLeftById(one.getLinkDepositId(), depo.getSeekLeft() - 1);//次数减一
//			}else{
//				depositDao.updateSeekNumberById(one.getLinkDepositId(), depo.getSeekNumber() + 1);
//			}
//		}
//		if(one.getLinkWithdrawId() != 0){
//			WithdrawRecord with = withdrawDao.readOneById(one.getLinkWithdrawId());
//			if(with.getMode() != Values.MODE_EXPIRE){//过期模式不用管次数
//				if(with.getSeekLeft() == 0){
//					return "抱歉，此记录已被别人匹配完了！";
//				}
//				if(with.getSeekLeft() == 1){//剩余1，还可匹配，不过要置状态为“已达匹配次数”，并置次数为0
//					withdrawDao.updateStatusById(with.getBankCoreBusinessId(), StatusOfRecord.SEEKED);
//					withdrawDao.updateSeekLeftById(one.getLinkWithdrawId(), 0);
//				}
//				withdrawDao.updateSeekLeftById(one.getLinkWithdrawId(), with.getSeekLeft() - 1);//次数减一	
//			}else{
//				withdrawDao.updateSeekNumberById(one.getLinkWithdrawId(), with.getSeekNumber() + 1);
//			}
//		}
//		
//		int key = helpRecordDao.createOne(one);
//		if(key != 0){
//			//存储和提取时间的链接记录如果不等于零，说明有来源，要将来源改变标识
//			if(one.getLinkDepositId() != 0){
//				//depositDao.updateStatusById(one.getLinkDepositId(), StatusOfRecord.VERIFYING);
//				depositDao.updateLinkedById(one.getLinkDepositId(), key);
//			}
//			if(one.getLinkWithdrawId() != 0){
//				//withdrawDao.updateStatusById(one.getLinkWithdrawId(), StatusOfRecord.VERIFYING);
//				withdrawDao.updateLinkedById(one.getLinkWithdrawId(), key);
//			}
//			return Values.SUCCESS;
//		}
		return Values.FAILURE;
	}
	

	public int readTodayNewCount() {
		return helpRecordDao.readTodayNewCount();
	}

	/**
	 * @param verifying
	 * @return
	 */
	public int readCountByStatus(int verifying) {
		return helpRecordDao.readCountByStatus(verifying);
	}

}
