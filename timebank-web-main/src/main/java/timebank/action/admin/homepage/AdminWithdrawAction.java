package timebank.action.admin.homepage;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import timebank.business.bank.WithdrawManager;
import timebank.model.WithdrawRecord;
import timebank.util.Methods;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

@Namespace(value = "/admin/homepage/withdraw")
@Results(value = {
		@Result(name = "list_expired", location = "/view/admin/homepage/withdraw/list_expired.jsp"),
		@Result(name = "list_seeked", location = "/view/admin/homepage/withdraw/list_seeked.jsp"),
		@Result(name = "list_unmatched", location = "/view/admin/homepage/withdraw/list_unmatched.jsp"),
		@Result(name = "list", location = "/view/admin/homepage/withdraw/list.jsp"),
		@Result(name = "view", location = "/view/admin/homepage/withdraw/view.jsp")
})
@Controller
public class AdminWithdrawAction {
	@Resource
	private WithdrawManager withdrawManager;
	private WithdrawRecord withdraw;
	private int withdrawId;
	private ArrayList<String> days;
	private String message;
	private int page;
	private ArrayList<WithdrawRecord> seekedWithdrawList;
	private int count;
	private int pages;
	private ArrayList<WithdrawRecord> unmatchedWithdrawList;
	private ArrayList<WithdrawRecord> expiredWithdrawList;
	private int countUnmatched;
	private int countExpired;
	private int countSeeked;

	public int getCountUnmatched() {
		return countUnmatched;
	}

	public void setCountUnmatched(int countUnmatched) {
		this.countUnmatched = countUnmatched;
	}

	public int getCountExpired() {
		return countExpired;
	}

	public void setCountExpired(int countExpired) {
		this.countExpired = countExpired;
	}

	public int getCountSeeked() {
		return countSeeked;
	}

	public void setCountSeeked(int countSeeked) {
		this.countSeeked = countSeeked;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ArrayList<WithdrawRecord> getSeekedWithdrawList() {
		return seekedWithdrawList;
	}

	public void setSeekedWithdrawList(ArrayList<WithdrawRecord> seekedWithdrawList) {
		this.seekedWithdrawList = seekedWithdrawList;
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

	public ArrayList<WithdrawRecord> getUnmatchedWithdrawList() {
		return unmatchedWithdrawList;
	}

	public void setUnmatchedWithdrawList(
			ArrayList<WithdrawRecord> unmatchedWithdrawList) {
		this.unmatchedWithdrawList = unmatchedWithdrawList;
	}

	public ArrayList<WithdrawRecord> getExpiredWithdrawList() {
		return expiredWithdrawList;
	}

	public void setExpiredWithdrawList(ArrayList<WithdrawRecord> expiredWithdrawList) {
		this.expiredWithdrawList = expiredWithdrawList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getWithdrawId() {
		return withdrawId;
	}

	public void setWithdrawId(int withdrawId) {
		this.withdrawId = withdrawId;
	}

	public ArrayList<String> getDays() {
		return days;
	}

	public void setDays(ArrayList<String> days) {
		this.days = days;
	}

	public WithdrawRecord getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(WithdrawRecord withdraw) {
		this.withdraw = withdraw;
	}

	public WithdrawManager getWithdrawManager() {
		return withdrawManager;
	}

	public void setWithdrawManager(WithdrawManager withdrawManager) {
		this.withdrawManager = withdrawManager;
	}
	
	private void getWithdrawList() {
		page = Methods.correctPage(page);
		seekedWithdrawList = withdrawManager.getWithdrawsByStatus(StatusOfRecord.SEEKED,page);
		countSeeked = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.SEEKED);
		
		expiredWithdrawList = withdrawManager.getWithdrawsByStatus(StatusOfRecord.EXPIRED,page);
		countExpired = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.EXPIRED);
		
		unmatchedWithdrawList = withdrawManager.getWithdrawsByStatus(StatusOfRecord.UNMATCHED,page);
		countUnmatched = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.UNMATCHED);
	}
	
	/**
	 * delete a withdraw.
	 */
	@Action(value = "delete")
	public String delete(){
		String result = withdrawManager.deleteOne(withdrawId);
		if(result.equals(Values.SUCCESS) == false){
			message = "删除出错！请联系开发人员。";
		}else{
			message = "删除成功！";
		}
		getWithdrawList();
		return "list";
	}

	/**
	 * view a withdraw.
	 */
	@Action(value = "view")
	public String view(){
		withdraw = withdrawManager.getOneWithdrawByWithdrawId(withdrawId);
		days = new Methods().readDays();
		return "view";
	}
	
	/**
	 * view the list of withdraw records.
	 */
	@Action(value = "list")
	public String viewWithdraws(){
		getWithdrawList();
		return "list";
	}
	
	/**
	 * view the list of expired withdraws.
	 */
	@Action(value = "list_expired")
	public String listExpired(){
		page = Methods.correctPage(page);
		expiredWithdrawList = withdrawManager.getWithdrawsByStatus(StatusOfRecord.EXPIRED, page);
		count = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.EXPIRED);
		pages = Methods.readPages(count);
		return "list_expired";
	}
	/**
	 * view the list of seeked withdraws.
	 */
	@Action(value = "list_seeked")
	public String listSeeked(){
		page = Methods.correctPage(page);
		seekedWithdrawList = withdrawManager.getWithdrawsByStatus(StatusOfRecord.SEEKED, page);
		count = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.SEEKED);
		pages = Methods.readPages(count);
		return "list_seeked";
	}
	/**
	 * view the list of unmatched withdraws.
	 */
	@Action(value = "list_unmatched")
	public String listUnmatched(){
		page = Methods.correctPage(page);
		unmatchedWithdrawList = withdrawManager .getWithdrawsByStatus(StatusOfRecord.UNMATCHED, page);
		count = withdrawManager.getCountWithdrawsByStatus(StatusOfRecord.UNMATCHED);
		pages = Methods.readPages(count);
		return "list_unmatched";
	}
	
	/**
	 * modify a withdraw.
	 */
	@Action(value = "modify")
	public String modify(){
		String result = withdrawManager.updateOneById(withdraw);
		if(result.equals(Values.SUCCESS) == false){
			message = "修改出错！请联系开发人员。";
		}else{
			message = "修改成功！";
		}
		withdraw = withdrawManager.getOneWithdrawByWithdrawId(withdraw.getBankCoreBusinessId());
		return "view";
	}
}
