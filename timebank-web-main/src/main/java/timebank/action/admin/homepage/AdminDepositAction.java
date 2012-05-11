package timebank.action.admin.homepage;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import timebank.business.bank.DepositManager;
import timebank.model.bank.BankCoreBusiness;
import timebank.util.Methods;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

@Namespace(value = "/admin/homepage/deposit")
@Results(value = {
		@Result(name = "list_expired", location = "/view/admin/homepage/deposit/list_expired.jsp"),
		@Result(name = "list_seeked", location = "/view/admin/homepage/deposit/list_seeked.jsp"),
		@Result(name = "list_unmatched", location = "/view/admin/homepage/deposit/list_unmatched.jsp"),
		@Result(name = "list", location = "/view/admin/homepage/deposit/list.jsp"),
		@Result(name = "view", location = "/view/admin/homepage/deposit/view.jsp")
})
@Controller
public class AdminDepositAction {
	@Resource
	private DepositManager depositManager;
	private BankCoreBusiness deposit;
	private int depositId;
	private String message;
	private int page;
	private ArrayList<BankCoreBusiness> seekedDepositList;
	private int count;
	private int pages;
	private ArrayList<BankCoreBusiness> unmatchedDepositList;
	private ArrayList<BankCoreBusiness> expiredDepositList;
	private int countSeeked;
	private int countExpired;
	private int countUnmatched;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ArrayList<BankCoreBusiness> getSeekedDepositList() {
		return seekedDepositList;
	}

	public void setSeekedDepositList(ArrayList<BankCoreBusiness> seekedDepositList) {
		this.seekedDepositList = seekedDepositList;
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

	public ArrayList<BankCoreBusiness> getUnmatchedDepositList() {
		return unmatchedDepositList;
	}

	public void setUnmatchedDepositList(
			ArrayList<BankCoreBusiness> unmatchedDepositList) {
		this.unmatchedDepositList = unmatchedDepositList;
	}

	public ArrayList<BankCoreBusiness> getExpiredDepositList() {
		return expiredDepositList;
	}

	public void setExpiredDepositList(ArrayList<BankCoreBusiness> expiredDepositList) {
		this.expiredDepositList = expiredDepositList;
	}

	public int getCountSeeked() {
		return countSeeked;
	}

	public void setCountSeeked(int countSeeked) {
		this.countSeeked = countSeeked;
	}

	public int getCountExpired() {
		return countExpired;
	}

	public void setCountExpired(int countExpired) {
		this.countExpired = countExpired;
	}

	public int getCountUnmatched() {
		return countUnmatched;
	}

	public void setCountUnmatched(int countUnmatched) {
		this.countUnmatched = countUnmatched;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDepositId() {
		return depositId;
	}

	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}

	public BankCoreBusiness getDeposit() {
		return deposit;
	}

	public void setDeposit(BankCoreBusiness deposit) {
		this.deposit = deposit;
	}

	public DepositManager getDepositManager() {
		return depositManager;
	}

	public void setDepositManager(DepositManager depositManager) {
		this.depositManager = depositManager;
	}
	
	/**
	 * 取得“处理存储”首页需要的各个List。
	 */
	public void getDepositList(){
		page = Methods.correctPage(page);
		seekedDepositList = depositManager.getDepositsByStatusLimit(StatusOfRecord.SEEKED,page);
		countSeeked = depositManager.getCountDepositsByStatus(StatusOfRecord.SEEKED);
		
		expiredDepositList = depositManager.getDepositsByStatusLimit(StatusOfRecord.EXPIRED,page);
		countExpired = depositManager.getCountDepositsByStatus(StatusOfRecord.EXPIRED);
		
		unmatchedDepositList = depositManager.getDepositsByStatusLimit(StatusOfRecord.UNMATCHED,page);
		countUnmatched = depositManager.getCountDepositsByStatus(StatusOfRecord.UNMATCHED);
	}

	@Action(value = "view")
	public String view(){
		deposit = depositManager.getOneDepositByDepositId(depositId);
		return "view";
	}
	
	/**
	 * view the list of deposit records.
	 */
	@Action(value = "list")
	public String list(){
		getDepositList();
		return "list";
	}
	
	/**
	 * delete a deposit record.
	 */
	@Action(value = "delete")
	public String delete(){
		String result = depositManager.deleteOne(depositId);
		if(result.equals(Values.SUCCESS) == false){
			message = "删除出错！请联系开发人员。";
		}else{
			message = "删除成功！";
		}
		getDepositList();
		return "list";
	}
	
	/**
	 * view a list of expired deposits.
	 */
	@Action(value = "list_expired")
	public String listExpired(){
		page = Methods.correctPage(page);
		expiredDepositList = depositManager.getDepositsByStatusLimit(StatusOfRecord.EXPIRED, page);
		count = depositManager.getCountDepositsByStatus(StatusOfRecord.EXPIRED);
		pages = Methods.readPages(count);
		return "list_expired";
	}
	
	/**
	 * view a list of seeked deposits.
	 */
	@Action(value = "list_seeked")
	public String listSeeked(){
		page = Methods.correctPage(page);
		seekedDepositList = depositManager.getDepositsByStatusLimit(StatusOfRecord.SEEKED, page);
		count = depositManager.getCountDepositsByStatus(StatusOfRecord.SEEKED);
		pages = Methods.readPages(count);
		return "list_seeked";
	}
	/**
	 * view a list of unmatched deposits.
	 */
	@Action(value = "list_unmatched")
	public String listUnmatched(){
		page = Methods.correctPage(page);
		unmatchedDepositList = depositManager .getDepositsByStatusLimit(StatusOfRecord.UNMATCHED, page);
		count = depositManager.getCountDepositsByStatus(StatusOfRecord.UNMATCHED);
		pages = Methods.readPages(count);
		return "list_unmatched";
	}
	
	/**
	 * modify a deposit.
	 */
	@Action(value = "modify")
	public String modify(){
//		String result = depositManager.updateOneById(deposit);
//		if(result.equals(Values.SUCCESS) == false){
//			message = "修改出错！请联系开发人员。";
//		}else{
//			message = "修改成功！";
//		}
		deposit = depositManager.getOneDepositByDepositId(deposit.getBankCoreBusinessId());
		return "view";
	}
}
