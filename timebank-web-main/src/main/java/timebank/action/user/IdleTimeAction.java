/**
 * @Project TimeBank
 * @CreatedTime 2011-10-22 上午08:16:43 
 * @Author CK
 * @Todo TODO
 */
package timebank.action.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.user.IdleTimeManager;
import timebank.model.reserve.ReserveIdleTime;
import timebank.model.user.User;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Controller
public class IdleTimeAction {
	@Resource
	private IdleTimeManager idleTimeManager;
	/**
	 * @return the idleTimeManager
	 */
	public IdleTimeManager getIdleTimeManager() {
		return idleTimeManager;
	}

	/**
	 * @param idleTimeManager the idleTimeManager to set
	 */
	public void setIdleTimeManager(IdleTimeManager idleTimeManager) {
		this.idleTimeManager = idleTimeManager;
	}
	private int count;
	private int iid;
	private ReserveIdleTime one;
	private ArrayList<ReserveIdleTime> day1;
	private ArrayList<ReserveIdleTime> day2;
	private ArrayList<ReserveIdleTime> day3;
	private ArrayList<ReserveIdleTime> day4;
	private ArrayList<ReserveIdleTime> day5;
	private ArrayList<ReserveIdleTime> day6;
	private ArrayList<ReserveIdleTime> day7;
	private String message;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public ReserveIdleTime getOne() {
		return one;
	}

	public void setOne(ReserveIdleTime one) {
		this.one = one;
	}

	public ArrayList<ReserveIdleTime> getDay1() {
		return day1;
	}

	public void setDay1(ArrayList<ReserveIdleTime> day1) {
		this.day1 = day1;
	}

	public ArrayList<ReserveIdleTime> getDay2() {
		return day2;
	}

	public void setDay2(ArrayList<ReserveIdleTime> day2) {
		this.day2 = day2;
	}

	public ArrayList<ReserveIdleTime> getDay3() {
		return day3;
	}

	public void setDay3(ArrayList<ReserveIdleTime> day3) {
		this.day3 = day3;
	}

	public ArrayList<ReserveIdleTime> getDay4() {
		return day4;
	}

	public void setDay4(ArrayList<ReserveIdleTime> day4) {
		this.day4 = day4;
	}

	public ArrayList<ReserveIdleTime> getDay5() {
		return day5;
	}

	public void setDay5(ArrayList<ReserveIdleTime> day5) {
		this.day5 = day5;
	}

	public ArrayList<ReserveIdleTime> getDay6() {
		return day6;
	}

	public void setDay6(ArrayList<ReserveIdleTime> day6) {
		this.day6 = day6;
	}

	public ArrayList<ReserveIdleTime> getDay7() {
		return day7;
	}

	public void setDay7(ArrayList<ReserveIdleTime> day7) {
		this.day7 = day7;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 查看已提交的时间储备页面
	 * @return
	 */
	public String view(){
		beforeView();
		return "view";
	}

	/**
	 * 
	 */
	private void beforeView() {
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		readAllRanges(userId);
		count = idleTimeManager.readCountByUserId(userId);
	}
	
	/**
	 * 进入时间储备表单填写界面
	 * @return
	 */
	public String form(){
		return "form";
	}
	/**
	 * 提交已更新好的时间储备页面
	 * @return
	 */
	public String update(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getUserId();
		String result = idleTimeManager.updateIdleTime(userId, day1,day2,day3,day4,day5,day6,day7);
		if(result.equals(Values.SUCCESS)){
			message = "更新成功！";
		} else {
			message = "更新失败！请联系开发人员。";
		}
		beforeView();
		return "view";
	}

	/**
	 * 提交删除某条时间储备
	 * @return
	 */
	public String delete(){
		one = idleTimeManager.readOne(iid);
		if(one == null){
			message = "这条时间储备已经不存在了哦！";
			beforeView();
			return "view";
		}
		User user = ((User)ActionContext.getContext().getSession().get("userLogined"));
//		if(one.getUserId() != user.getUserId()){
//			message = "请勿删除不属于您的时间储备！";
//		}else{
//			String result = idleTimeManager.deleteOne(iid);
//			if(result.equals(Values.SUCCESS)){
//				message = "删除成功！";
//			}else if(result.equals(Values.FAILURE)){
//				message = "删除失败！请联系开发人员。";
//			}else {
//				message = result;
//			}
//		}
		beforeView();
		return "view";
	}
	/**
	 * 
	 */
	private void readAllRanges(int userId) {
		day1 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期一");
		day2 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期二");
		day3 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期三");
		day4 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期四");
		day5 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期五");
		day6 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期六");
		day7 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期天");
	}
}
