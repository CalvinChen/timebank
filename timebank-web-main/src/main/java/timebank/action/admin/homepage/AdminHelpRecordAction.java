package timebank.action.admin.homepage;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.bank.HelpRecordManager;
import timebank.model.admin.Admin;
import timebank.model.bank.BankCompleteRecord;
import timebank.util.Methods;
import timebank.util.Tester;
import timebank.util.bean.StatusOfRecord;

@Namespace(value = "/admin/homepage/helprecord")
@Results(value = {
	@Result(name = "list_failure", location = "/view/admin/homepage/helprecord/list_failure.jsp"),
	@Result(name = "list_success", location = "/view/admin/homepage/helprecord/list_success.jsp"),
	@Result(name = "list_to_feedback", location = "/view/admin/homepage/helprecord/list_to_feedback.jsp"),
	@Result(name = "list_unhandled", location = "/view/admin/homepage/helprecord/list_unhandled.jsp"),
	@Result(name = "list_verified_failure", location = "/view/admin/homepage/helprecord/list_verified_failure.jsp"),
	@Result(name = "list", location = "/view/admin/homepage/helprecord/list.jsp"),
	@Result(name = "view", location = "/view/admin/homepage/helprecord/view.jsp")
})
@Controller
public class AdminHelpRecordAction {
	@Resource
	private HelpRecordManager helpRecordManager;
	private BankCompleteRecord helpRecord;
	private int helpRecordId;
	private String message;
	private String whyVerifyFailure;
	private int select;
	private int page;
	private int count;
	private int pages;
	private ArrayList<BankCompleteRecord> successRecordList;
	private ArrayList<BankCompleteRecord> failureRecordList;
	private ArrayList<BankCompleteRecord> verifiedFailureRecordList;
	private ArrayList<BankCompleteRecord> toFeedbackRecordList;
	private ArrayList<BankCompleteRecord> unhandleRecordList;
	private int countVerifying;
	private int countVerified;
	private int countVerifiedFailure;
	private int countSuccess;
	private int countFailure;

	public int getCountVerifying() {
		return countVerifying;
	}

	public void setCountVerifying(int countVerifying) {
		this.countVerifying = countVerifying;
	}

	public int getCountVerified() {
		return countVerified;
	}

	public void setCountVerified(int countVerified) {
		this.countVerified = countVerified;
	}

	public int getCountVerifiedFailure() {
		return countVerifiedFailure;
	}

	public void setCountVerifiedFailure(int countVerifiedFailure) {
		this.countVerifiedFailure = countVerifiedFailure;
	}

	public int getCountSuccess() {
		return countSuccess;
	}

	public void setCountSuccess(int countSuccess) {
		this.countSuccess = countSuccess;
	}

	public int getCountFailure() {
		return countFailure;
	}

	public void setCountFailure(int countFailure) {
		this.countFailure = countFailure;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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

	public ArrayList<BankCompleteRecord> getSuccessRecordList() {
		return successRecordList;
	}

	public void setSuccessRecordList(ArrayList<BankCompleteRecord> successRecordList) {
		this.successRecordList = successRecordList;
	}

	public ArrayList<BankCompleteRecord> getFailureRecordList() {
		return failureRecordList;
	}

	public void setFailureRecordList(ArrayList<BankCompleteRecord> failureRecordList) {
		this.failureRecordList = failureRecordList;
	}

	public ArrayList<BankCompleteRecord> getVerifiedFailureRecordList() {
		return verifiedFailureRecordList;
	}

	public void setVerifiedFailureRecordList(
			ArrayList<BankCompleteRecord> verifiedFailureRecordList) {
		this.verifiedFailureRecordList = verifiedFailureRecordList;
	}

	public ArrayList<BankCompleteRecord> getToFeedbackRecordList() {
		return toFeedbackRecordList;
	}

	public void setToFeedbackRecordList(ArrayList<BankCompleteRecord> toFeedbackRecordList) {
		this.toFeedbackRecordList = toFeedbackRecordList;
	}

	public ArrayList<BankCompleteRecord> getUnhandleRecordList() {
		return unhandleRecordList;
	}

	public void setUnhandleRecordList(ArrayList<BankCompleteRecord> unhandleRecordList) {
		this.unhandleRecordList = unhandleRecordList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getWhyVerifyFailure() {
		return whyVerifyFailure;
	}

	public void setWhyVerifyFailure(String whyVerifyFailure) {
		this.whyVerifyFailure = whyVerifyFailure;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public BankCompleteRecord getHelpRecord() {
		return helpRecord;
	}

	public void setHelpRecord(BankCompleteRecord helpRecord) {
		this.helpRecord = helpRecord;
	}

	public int getHelpRecordId() {
		return helpRecordId;
	}

	public void setHelpRecordId(int helpRecordId) {
		this.helpRecordId = helpRecordId;
	}

	public HelpRecordManager getHelpRecordManager() {
		return helpRecordManager;
	}

	public void setHelpRecordManager(HelpRecordManager helpRecordManager) {
		this.helpRecordManager = helpRecordManager;
	}
	
	/**
	 * utility method, to get all kinds of help records needed.
	 */
	public void getHelpRecordList(){
		page = Methods.correctPage(page);
		
		unhandleRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.VERIFYING, page);
		countVerifying = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFYING);
		
		toFeedbackRecordList = helpRecordManager.readSomeByStatus(StatusOfRecord.VERIFIED, page);
		countVerified = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFIED);

		verifiedFailureRecordList = helpRecordManager.readSomeByStatus(StatusOfRecord.VERIFIED_FAILURE, page);
		countVerifiedFailure = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFIED_FAILURE);
		
		successRecordList = helpRecordManager.readSomeByStatus(StatusOfRecord.SUCCESS, page);
		countSuccess = helpRecordManager.readCountByStatus(StatusOfRecord.SUCCESS);
		
		failureRecordList = helpRecordManager.readSomeByStatus(StatusOfRecord.FAILURE, page);
		countFailure = helpRecordManager.readCountByStatus(StatusOfRecord.FAILURE);
	}

	/**
	 * view a help record.
	 */
	@Action(value = "view")
	public String viewRecord(){
		helpRecord = helpRecordManager.readOneById(helpRecordId);
		return "view";
	}
	
	/**
	 * fail to update a help record, go back to list page with a error message.
	 */
	@Action(value = "list_with_fail")
	public String listWithFail(){
		Tester.markHere("HomepageAdmin.viewRecordFail");
		message = "更新状态失败！";
		getHelpRecordList();
		return "list";
	}
	
	/**
	 * view the list of help records.
	 */
	@Action(value = "list")
	public String list() {
		getHelpRecordList();
		return "list";
	}
	
	/**
	 * view a list of unhandled help records.
	 */
	@Action(value = "list_unhandled")
	public String listUnhandled(){
		page = Methods.correctPage(page);
		unhandleRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.VERIFYING, page);
		count = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFYING);
		pages = Methods.readPages(count);
		return "list_unhandled";
	}
	
	/**
	 * view a list of help records waiting to feedback.
	 */
	@Action(value = "list_to_feedback")
	public String listToFeedback(){
		page = Methods.correctPage(page);
		toFeedbackRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.VERIFIED, page);
		count = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFIED);
		pages = Methods.readPages(count);
		return "list_to_feedback";
	}
	/**
	 * view a list of help records that verified failure.
	 */
	@Action(value = "list_verified_failure")
	public String listVerifiedFailure(){
		page = Methods.correctPage(page);
		verifiedFailureRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.VERIFIED_FAILURE, page);
		count = helpRecordManager.readCountByStatus(StatusOfRecord.VERIFIED_FAILURE);
		pages = Methods.readPages(count);
		return "list_verified_failure";
	}
	
	/**
	 * view a list of success help records.
	 */
	@Action(value = "list_success")
	public String listSuccess(){
		page = Methods.correctPage(page);
		successRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.SUCCESS, page);
		count = helpRecordManager.readCountByStatus(StatusOfRecord.SUCCESS);
		pages = Methods.readPages(count);
		return "list_success";
	}
	/**
	 * view a list of failure help records.
	 */
	@Action(value = "list_failure")
	public String listFailure(){
		page = Methods.correctPage(page);
		failureRecordList = helpRecordManager .readSomeByStatus(StatusOfRecord.FAILURE, page);
		count = helpRecordManager.readCountByStatus(StatusOfRecord.FAILURE);
		pages = Methods.readPages(count);
		return "list_failure";
	}
	
	/**
	 * handle a help record. often used to update a record's status.
	 */
	@Action(value = "handle")
	public String handle(){
		String adminName = ((Admin)ActionContext.getContext().getSession().get("adminLogined")).getUsername();
		String result = helpRecordManager.updateStatusById(helpRecordId, select, 3, whyVerifyFailure, adminName);
		if(result.equals("success")){
			message = "更新状态成功！";
			getHelpRecordList();
			return "list";
		}else{
			message = "更新失败！请联系开发人员。";
			helpRecord = helpRecordManager.readOneById(helpRecordId);
			return "view";
		}
	}
}
