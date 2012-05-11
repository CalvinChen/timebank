package timebank.action.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.bank.BankInfoManager;
import timebank.business.bank.DepositManager;
import timebank.business.bank.HelpRecordManager;
import timebank.business.bank.WithdrawManager;
import timebank.business.user.UserManager;
import timebank.model.BankInfoRecord;
import timebank.model.WithdrawRecord;
import timebank.model.bank.BankCompleteRecord;
import timebank.model.bank.BankCoreBusiness;
import timebank.model.user.User;
import timebank.util.Convertor;
import timebank.util.Methods;
import timebank.util.Tester;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

@Controller
public class DepositAction {
	@Resource
	private WithdrawManager withdrawManager;
	@Resource
	private HelpRecordManager helpRecordManager;
	@Resource
	private DepositManager depositManager;
	@Resource
	private BankInfoManager bankInfoManager;
	
	/**
	 * @return the bankInfoManager
	 */
	public BankInfoManager getBankInfoManager() {
		return bankInfoManager;
	}
	/**
	 * @param bankInfoManager the bankInfoManager to set
	 */
	public void setBankInfoManager(BankInfoManager bankInfoManager) {
		this.bankInfoManager = bankInfoManager;
	}
	/**
	 * @return the withdrawManager
	 */
	public WithdrawManager getWithdrawManager() {
		return withdrawManager;
	}
	/**
	 * @param withdrawManager the withdrawManager to set
	 */
	public void setWithdrawManager(WithdrawManager withdrawManager) {
		this.withdrawManager = withdrawManager;
	}
	/**
	 * @return the helpRecordManager
	 */
	public HelpRecordManager getHelpRecordManager() {
		return helpRecordManager;
	}
	/**
	 * @param helpRecordManager the helpRecordManager to set
	 */
	public void setHelpRecordManager(HelpRecordManager helpRecordManager) {
		this.helpRecordManager = helpRecordManager;
	}
	/**
	 * @return the depositManager
	 */
	public DepositManager getDepositManager() {
		return depositManager;
	}
	/**
	 * @param depositManager the depositManager to set
	 */
	public void setDepositManager(DepositManager depositManager) {
		this.depositManager = depositManager;
	}
	//-------------guide页面提交参数-----------------------------------------
	private int select;
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	//-------------uncertain页面显示使用-------------------------------------
	private String addDesc;

	public String getAddDesc() {
		return addDesc;
	}
	public void setAddDesc(String addDesc) {
		this.addDesc = addDesc;
	}
	private ArrayList<WithdrawRecord> recordList;
	private ArrayList<WithdrawRecord> topList;

	public ArrayList<WithdrawRecord> getTopList() {
		return topList;
	}
	public void setTopList(ArrayList<WithdrawRecord> topList) {
		this.topList = topList;
	}
	public ArrayList<WithdrawRecord> getRecordList() {
		return recordList;
	}
	public void setRecordList(ArrayList<WithdrawRecord> recordList) {
		this.recordList = recordList;
	}
	
	

	//-------------Withdraw_selectSubmit页面提交参数-------------------------
	private int withdrawId;
	
	public int getWithdrawId() {
		return withdrawId;
	}
	public void setWithdrawId(int withdrawId) {
		this.withdrawId = withdrawId;
	}

	//-----------viewOne------------------------------------------
	private WithdrawRecord withdrawRecord;
	private int myUserId;
	public WithdrawRecord getWithdrawRecord() {
		return withdrawRecord;
	}
	public void setWithdrawRecord(WithdrawRecord withdrawRecord) {
		this.withdrawRecord = withdrawRecord;
	}
	public int getMyUserId() {
		return myUserId;
	}
	public void setMyUserId(int myUserId) {
		this.myUserId = myUserId;
	}
	//--------------addDetail---------------------------------------
	public String[] zone;
	public String[] range;
	public String addedDescription;
	
	public String[] getZone() {
		return zone;
	}
	public void setZone(String[] zone) {
		this.zone = zone;
	}
	public String[] getRange() {
		return range;
	}
	public void setRange(String[] range) {
		this.range = range;
	}
	public String getAddedDescription() {
		return addedDescription;
	}
	public void setAddedDescription(String addedDescription) {
		this.addedDescription = addedDescription;
	}
	//--------------viewList----------------------------------------
	private ArrayList<BankCoreBusiness> myDepositTime;
	public ArrayList<BankCoreBusiness> getMyDepositTime() {
		return myDepositTime;
	}
	public void setMyDepositTime(ArrayList<BankCoreBusiness> myDepositTime) {
		this.myDepositTime = myDepositTime;
	}
	//--------------view--------------------------------------------
	private BankInfoRecord oneB;
	private ArrayList<String> days;
	private String message;
	private BankCoreBusiness one;
	private int did;
	private int p;
	private int count;
	private int pages;
	private ArrayList<WithdrawRecord> top2List;
	
	public ArrayList<WithdrawRecord> getTop2List() {
		return top2List;
	}
	public void setTop2List(ArrayList<WithdrawRecord> top2List) {
		this.top2List = top2List;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public BankCoreBusiness getOne() {
		return one;
	}
	public void setOne(BankCoreBusiness one) {
		this.one = one;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<String> getDays() {
		return days;
	}
	public void setDays(ArrayList<String> days) {
		this.days = days;
	}
	public BankInfoRecord getOneB() {
		return oneB;
	}
	public void setOneB(BankInfoRecord oneB) {
		this.oneB = oneB;
	}
	//--------------end---------------------------------------------
	public String view(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		oneB = bankInfoManager.getOnesBankInfo(userId);
		return "view";
	}
	
	/**
	 * 查看一条提取记录
	 * @return
	 */
	public String viewOne(){
		WithdrawRecord one = withdrawManager .getOneWithdrawByWithdrawId(withdrawId);
		if(one != null){
			withdrawRecord = one;
			return "viewOne";
		}else{
			message = "读取出错！";
			return "viewOne";
		}
	}

	public String guide(){
		return "guide";
	}
	public String certainSub(){
		return "certainSucc";
	}
	
	public String selectSubmit() {
		String forward = "";
		if(select == Values.GIUDE_UNCERTAIN){
			forward = "uncertain";
		}
		if(select == Values.GUIDE_CERTAIN){
			forward = "certain";
			days = new Methods().readDays();
		}
		return forward;
	}
	
	/**
	 * 查看最近需要帮助的时间清单，主要由选择向导重定向调用
	 * @return
	 */
	public String viewWs(){
		beforeViewWs();
		return "viewWs";
	}
	/**
	 * 
	 */
	private void beforeViewWs() {
		p = Methods.correctPage(p);
		recordList = withdrawManager.getNormalWithdrawsByStatusLimit(StatusOfRecord.UNMATCHED, p);
		if(p == 1){
			topList = withdrawManager.getTopAndDetailedWithdrawsByStatus(StatusOfRecord.UNMATCHED);
			top2List = withdrawManager.getTopAndNotDetailedWithdrawsByStatus(StatusOfRecord.UNMATCHED);	
		}
		count = withdrawManager.getCountNormalWithdrawsByStatus(StatusOfRecord.UNMATCHED);
		pages = Methods.readPages(count);
	}

	
	public String validateRequire() {
		if(addDesc == null || addDesc.length() < 5){
			return "请在输入框中填写至少5个字的内容描述。";
		}
		if(addDesc.length() > 500){
			return "请在输入框中简明扼要说明情况，不超过500字。";
		}
		return Values.SUCCESS;
	}
	
	public String require(){
		
		//验证补充内容的提交
		String result = validateRequire();
		if(result.equals(Values.SUCCESS) == false){
			message = result;
			withdrawRecord = withdrawManager.getOneWithdrawByWithdrawId(withdrawRecord.getBankCoreBusinessId());
			return "viewOne";
		}
		
		int toHelpUserId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		int helpedUserId = withdrawRecord.getUserId();
		WithdrawRecord one = withdrawManager.getOneWithdrawByWithdrawId(withdrawRecord.getBankCoreBusinessId());
		
		//增加新记录
		BankCompleteRecord newRecord = new BankCompleteRecord();
//		newRecord.setToHelpUserId(toHelpUserId);
//		newRecord.setHelpedUserId(helpedUserId);
//		newRecord.setDate(one.getTheDate());
//		newRecord.setTime(one.getTheTime());
//		newRecord.setZone(one.getZoneWithdraw());
//		newRecord.setRange(one.getRangeWithdraw());
//		newRecord.setDescriptionHelped(one.getDescription());
//		newRecord.setDescriptionToHelp(addDesc);
//		newRecord.setRequireBy(Values.REQUIRE_BY_TO_HELP);
//		newRecord.setLinkDepositId(0);
//		newRecord.setLinkWithdrawId(one.getBankCoreBusinessId());
		
		result = helpRecordManager.createOne(newRecord);
		if(result.equals(Values.SUCCESS)){
			return "redirectToSucc";
		}else{
			days = new Methods().readDays();
			return "viewOne";
		}
	}
	
	public String viewList(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		myDepositTime = depositManager .getOnesDeposit(userId);
		if(myDepositTime.size() == 0) myDepositTime = null;
		return "viewList";
	}
	
	public String addRecordSucc(){
		return "addRecordSucc";
	}
	
	//新增一条存储记录
	public String submit(){
		String result = validateSubmit(); 
		if(result.equals(Values.SUCCESS) == false){
			message = result;
			days = new Methods().readDays();
			return "certain";
		}
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		if(depositManager.addOneDeposit(one, user.getUserId()).equals(Values.SUCCESS)){
			return "succ";
		}else{
			message = "时间存入错误，请填写完整信息后重试！若情况依旧请联系管理员。";
			days = new Methods().readDays();
			return "certain";
		}
	}

	//新增一条存储记录中的数据验证
	public String validateSubmit() {
		if(one.getDescription() == null || one.getDescription().length() < 10){
			return "为了让他人更好地了解您的状况，请在“详细说明”中至少填写10个字的内容。";
		}
		if(one.getDescription().length() > 5000){
			return "请在“详细说明”中简明扼要说明情况，不超过5000字。";
		}
		return Values.SUCCESS;
	}
	
	public String succ(){
		return "succ";
	}
	
	/**
	 * 关闭某条求助记录
	 * @return
	 */
	public String closeDeposit(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
//		String result = depositManager.closeDeposit(userId, did);
//		if(result.equals(Values.SUCCESS)){
//			message = "关闭成功！";
//		}else{
//			message = result;
//		}
//		myDepositTime = depositManager .getOnesDeposit(userId);
//		if(myDepositTime.size() == 0) myDepositTime = null;
		return "viewList";
	}
}
