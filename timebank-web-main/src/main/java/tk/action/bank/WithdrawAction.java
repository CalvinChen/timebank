package tk.action.bank;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import timebank.business.impl.user.UserManagerImpl;
import timebank.model.WithdrawRecord;
import timebank.model.bank.BankInfo;
import timebank.model.bank.HelpRecord;
import timebank.model.bank.SideRecord;
import timebank.model.user.User;
import timebank.util.lang.convertor.Convertor;
import tk.business.bank.BankInfoManager;
import tk.business.bank.DepositManager;
import tk.business.bank.HelpRecordManager;
import tk.business.bank.WithdrawManager;
import tk.util.Methods;
import tk.util.Tester;
import tk.util.bean.StatusOfRecord;
import tk.util.bean.Values;

@Controller
public class WithdrawAction {
	@Resource
	private DepositManager depositManager;
	@Resource
	private HelpRecordManager helpRecordManager;
	@Resource
	private WithdrawManager withdrawManager;
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
	//-------------guide-----------------------------------------
	private String select;
	private int depositId;
	
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public int getDepositId() {
		return depositId;
	}
	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}
	//-------------uncertain页面显示使用-------------------------------------
	private String addDesc;
	

	public String getAddDesc() {
		return addDesc;
	}
	public void setAddDesc(String addDesc) {
		this.addDesc = addDesc;
	}
	private ArrayList<SideRecord> recordList;
	private ArrayList<SideRecord> topList;

	public ArrayList<SideRecord> getTopList() {
		return topList;
	}
	public void setTopList(ArrayList<SideRecord> topList) {
		this.topList = topList;
	}
	public ArrayList<SideRecord> getRecordList() {
		return recordList;
	}
	public void setRecordList(ArrayList<SideRecord> recordList) {
		this.recordList = recordList;
	}
	
	//-----------viewOne------------------------------------------
	private SideRecord depositRecord;
	private int myUserId;
	public SideRecord getDepositRecord() {
		return depositRecord;
	}
	public void setDepositRecord(SideRecord depositRecord) {
		this.depositRecord = depositRecord;
	}
	public int getMyUserId() {
		return myUserId;
	}
	public void setMyUserId(int myUserId) {
		this.myUserId = myUserId;
	}
	//--------------addDetail---------------------------------------
	private String[] zone;
	private String[] range;
	private String addedDescription;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	//offerTime.offerTimeId
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
	private ArrayList<WithdrawRecord> myWithdrawTime;

	public ArrayList<WithdrawRecord> getMyWithdrawTime() {
		return myWithdrawTime;
	}
	public void setMyWithdrawTime(ArrayList<WithdrawRecord> myWithdrawTime) {
		this.myWithdrawTime = myWithdrawTime;
	}
	//--------------view--------------------------------------------
	private BankInfo oneB;
	public BankInfo getOneB() {
		return oneB;
	}
	public void setOneB(BankInfo oneB) {
		this.oneB = oneB;
	}
	
	private ArrayList<String> days;
	private WithdrawRecord one;
	private int wid;
	private int p;
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	private int count;
	private int pages;
	private ArrayList<SideRecord> top2List;
	
	public ArrayList<SideRecord> getTop2List() {
		return top2List;
	}
	public void setTop2List(ArrayList<SideRecord> top2List) {
		this.top2List = top2List;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public WithdrawRecord getOne() {
		return one;
	}
	public void setOne(WithdrawRecord one) {
		this.one = one;
	}
	public ArrayList<String> getDays() {
		return days;
	}
	public void setDays(ArrayList<String> days) {
		this.days = days;
	}
	//--------------end---------------------------------------------
	public String view(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		oneB = bankInfoManager.getOnesBankInfo(userId);
		return "view";
	}
	public String viewOne(){
		SideRecord one = depositManager .getOneDepositByDepositId(depositId);
		if(one != null){
			depositRecord = one;
			myUserId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
			return "viewOne";
		}else{
			Tester.markHere("出错了！viewOne");
			return "viewOne";
		}
	}
	
	/**
	 * 通过此方法从查看“提供帮助信息”界面进入“信息细化”界面
	 * @return 结果视图
	 */
	public String askForHelp(){
		int depositId;
		if(depositRecord != null){
			//查看“提供帮助信息”界面中有此隐藏参数提交到这个方法，以确定要信息细化的帮助信息
			depositId = depositRecord.getId();
		}else{
			depositId = Integer.parseInt(ActionContext.getContext().getSession().get("depositId").toString());
			message = ActionContext.getContext().getSession().get("messageT").toString();
		}
		
		SideRecord one = depositManager.getOneDepositByDepositId(depositId);
		depositRecord = one;
		return "addDetail";
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
	
	/**
	 * 点击别人的记录申请
	 * @return
	 */
	public String require(){
		
		//验证补充内容的提交
		String result = validateRequire();
		if(result.equals(Values.SUCCESS) == false){
			message = result;
			depositRecord = depositManager .getOneDepositByDepositId(depositRecord.getId());
			return "viewOne";
		}
		
		//获得帮助者与求助者的ID
		int helpedUserId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		int toHelpUserId = depositRecord.getRequester().getId();
		
		SideRecord one = depositManager.getOneDepositByDepositId(depositRecord.getId());
		HelpRecord newRecord = new HelpRecord();
//		newRecord.setHelpedUserId(helpedUserId);
//		newRecord.setToHelpUserId(toHelpUserId);
//		newRecord.setTheDate(one.getTheDate());
//		newRecord.setTheTime(one.getTheTime());
//		newRecord.setZone(one.getZoneDeposit());
//		newRecord.setRange(one.getRangeDeposit());
//		newRecord.setDescriptionToHelp(one.getDescription());
//		newRecord.setDescriptionHelped(addDesc);
//		newRecord.setRequireBy(Values.REQUIRE_BY_HELPED);
//		newRecord.setLinkDepositId(one.getBankCoreBusinessId());
//		newRecord.setLinkWithdrawId(0);
		
		result = helpRecordManager.createOne(newRecord);
		if(result.equals(Values.SUCCESS) == true){
			return "redirectToSucc";
		}else {
			message = result;
			depositRecord = depositManager .getOneDepositByDepositId(depositRecord.getId());
			return "viewOne";
		}
	}

	public String guide(){
		return "guide";
	}
	public String certainSub(){
		return "certainSucc";
	}
	
	//提取向导提交选择
	public String selectSubmit() {
		String forward = "";
		if(select.equals("1")){
			forward = "uncertain";
		}
		if(select.equals("2")){
			//被动等待
			forward = "certain";
			days = new Methods().readDays();
		}
		return forward;
	}
	
	public String viewDs(){
		beforeViewDs();
		return "viewDs";
	}
	/**
	 * 在进入查看最近提供帮助列表前
	 */
	private void beforeViewDs() {
		p = Methods.correctPage(p);
		recordList = depositManager.getNormalDepositsByStatusLimit(StatusOfRecord.UNMATCHED, p);
		if(p == 1){
			topList = depositManager.getTopAndDetailedDepositsByStatus(StatusOfRecord.UNMATCHED);	
			top2List = depositManager.getTopAndNotDetailedDepositsByStatus(StatusOfRecord.UNMATCHED);
		}
		count = depositManager.getCountNormalDepositsByStatus(StatusOfRecord.UNMATCHED);
		pages = Methods.readPages(count);
	}

	/**
	 * 查看当前用户提取清单
	 * @return
	 */
	public String viewList(){
		//取得当前用户ID
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		
		//拿到他所有的提取记录
		myWithdrawTime = withdrawManager .getOnesWithdraw(userId);
		if(myWithdrawTime.size() == 0) myWithdrawTime = null;
		
		//返回视图
		return "viewList";
	}
	
	public String addRecordSucc(){
		return "addRecordSucc";
	}
	
	/**
	 * 添加新的提取记录提交
	 * @return
	 */
	public String submit(){
		String forward = "";
		
		//验证
		String result = validateSubmit(); 
		if(result.equals(Values.SUCCESS) == false){
			message = result;
			days = new Methods().readDays();
			return "certain";
		}
		
		//验证通过
		User user = (User)ActionContext.getContext().getSession().get("userLogined");
		if(withdrawManager.addOneWithdraw(one, user.getId()).equals(Values.SUCCESS)){
			forward = "succ";
		}else{
			message = "时间提取错误，请填写完整信息后重试！若情况依旧请联系管理员。";
			days = new Methods().readDays();
			forward = "certain";
		}
		return forward;
	}

	
	//验证内容字数即可
	public String validateSubmit() {
		if(one.getDescription() == null || one.getDescription().length() < 10){
			return "为了让他人更好地了解您的状况，请在“详细说明”中至少填写10个字的内容。";
		}else if(one.getDescription().length() > 5000){
			return "请在“详细说明”中简明扼要说明情况，不超过5000字。";
		}
		return Values.SUCCESS;
	}
	
	/**
	 * 关闭某条求助记录
	 * @return
	 */
	public String closeWithdraw(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		String result = withdrawManager.closeWithdraw(userId, wid);
		if(result.equals(Values.SUCCESS)){
			message = "关闭成功！";
		}else{
			message = result;
		}
		myWithdrawTime = withdrawManager.getOnesWithdraw(userId);
		if(myWithdrawTime.size() == 0) myWithdrawTime = null;
		return "viewList";
	}
}
