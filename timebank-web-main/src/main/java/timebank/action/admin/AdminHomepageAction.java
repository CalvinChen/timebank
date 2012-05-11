package timebank.action.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.admin.AdminManager;
import timebank.business.bank.BankInfoManager;
import timebank.business.bank.DepositManager;
import timebank.business.bank.HelpRecordManager;
import timebank.business.bank.WithdrawManager;
import timebank.business.user.UserManager;
import timebank.model.WithdrawRecord;
import timebank.model.admin.Admin;
import timebank.model.bank.BankCompleteRecord;
import timebank.model.bank.BankCoreBusiness;
import timebank.model.user.User;
import timebank.util.Methods;
import timebank.util.Tester;
import timebank.util.bean.StatusOfRecord;
import timebank.util.bean.Values;

@Namespace(value = "/admin/homepage")
@Results(value = { @Result(name = "index", location = "/view/admin/homepage/index.jsp") })
@Controller
public class AdminHomepageAction {
	@Resource
	private HelpRecordManager helpRecordManager;
	@Resource
	private DepositManager depositManager;
	@Resource
	private WithdrawManager withdrawManager;
	private int countTodayDeposit;
	private int countTodayWithdraw;
	private int countTodayHelpRecord;
	private int countTodayVerifying;

	public HelpRecordManager getHelpRecordManager() {
		return helpRecordManager;
	}

	public void setHelpRecordManager(HelpRecordManager helpRecordManager) {
		this.helpRecordManager = helpRecordManager;
	}

	public DepositManager getDepositManager() {
		return depositManager;
	}

	public void setDepositManager(DepositManager depositManager) {
		this.depositManager = depositManager;
	}

	public WithdrawManager getWithdrawManager() {
		return withdrawManager;
	}

	public void setWithdrawManager(WithdrawManager withdrawManager) {
		this.withdrawManager = withdrawManager;
	}

	public int getCountTodayDeposit() {
		return countTodayDeposit;
	}

	public void setCountTodayDeposit(int countTodayDeposit) {
		this.countTodayDeposit = countTodayDeposit;
	}

	public int getCountTodayWithdraw() {
		return countTodayWithdraw;
	}

	public void setCountTodayWithdraw(int countTodayWithdraw) {
		this.countTodayWithdraw = countTodayWithdraw;
	}

	public int getCountTodayHelpRecord() {
		return countTodayHelpRecord;
	}

	public void setCountTodayHelpRecord(int countTodayHelpRecord) {
		this.countTodayHelpRecord = countTodayHelpRecord;
	}

	public int getCountTodayVerifying() {
		return countTodayVerifying;
	}

	public void setCountTodayVerifying(int countTodayVerifying) {
		this.countTodayVerifying = countTodayVerifying;
	}

	/**
	 * enter the index page
	 */
	@Action(value = "index")
	public String index() {
		countTodayDeposit = depositManager.readTodayNewCount();
		countTodayWithdraw = withdrawManager.readTodayNewCount();
		countTodayHelpRecord = helpRecordManager.readTodayNewCount();
		countTodayVerifying = helpRecordManager
				.readCountByStatus(StatusOfRecord.VERIFYING);
		return "index";
	}
}
