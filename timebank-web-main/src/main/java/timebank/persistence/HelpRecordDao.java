package timebank.persistence;

import java.util.ArrayList;

import timebank.model.bank.BankCompleteRecord;

public interface HelpRecordDao {

	/**
	 * 获得某个用户所有的互助记录
	 * @param userId 该用户的用户编号
	 * @return 该用户所有的互助记录表
	 */
	public abstract ArrayList<BankCompleteRecord> readSomeByUserId(int userId);

	/**
	 * 获得某条互助记录
	 * @param helpRecordId 该条互助记录的编号
	 * @return 该条互助记录
	 */
	public abstract BankCompleteRecord readOne(int helpRecordId);

	//--------------------------------------About Helprecord------------------------------------
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
	public abstract int createOne(BankCompleteRecord one);

	/**
	 * 获得所有由参数status指定状态的互助记录
	 * @param status 互助记录的状态
	 * @return 所有符合要求的互助记录
	 */
	public abstract ArrayList<BankCompleteRecord> readSomeByStatus(int status, int page);

	/**
	 * 根据互助记录编号获得该互助记录
	 * @param helpRecordId 该条互助记录的编号
	 * @return 该条互助记录的所有信息
	 */
	public abstract BankCompleteRecord readOneById(int helpRecordId);

	/**
	 * 设置互助记录的状态
	 * @param helpRecordId 该条互助记录的编号
	 * @param status 该条互助记录的新的状态
	 * @return
	 */
	public abstract String updateStatusById(int helpRecordId, int status);

	/**
	 * 获得由参数status指定状态的互助记录的总数
	 * @param status 互助记录的状态
	 * @return 所有符合要求的互助记录的总数
	 */
	public abstract int readCountByStatus(int status);

	/**
	 * @param helpRecordId
	 * @param userScore
	 * @param userFeedback
	 * @return
	 */
	public abstract String updateToHelpPartById(int helpRecordId,
			double userScore, String userFeedback);

	/**
	 * @param helpRecordId
	 * @param userScore
	 * @param userFeedback
	 * @return
	 */
	public abstract String updateHelpedPartById(int helpRecordId,
			double userScore, String userFeedback);

	/**
	 * @param helpRecordId
	 * @param whyFailure
	 * @param failureBy
	 * @return
	 */
	public abstract String updateWhyFailureById(int helpRecordId,
			String whyFailure, int failureBy);

	/**
	 * 更新互助记录的验证失败部分
	 * @param helpRecordId
	 * @param whyVerifyFailure
	 * @return
	 */
	public abstract String updateVerifyPartById(int helpRecordId,
			String verifier, String whyVerifyFailure);

	/**
	 * 获得今天新的记录
	 * @return 今天记录数
	 */
	public abstract int readTodayNewCount();

}