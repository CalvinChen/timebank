/**
 * @Project TimeBank
 * @CreatedTime 2011-10-22 上午08:16:43 
 * @Author CK
 * @Todo TODO
 */
package tk.action.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.model.reserve.ReserveSkill;
import timebank.model.user.User;
import tk.business.user.SkillManager;
import tk.util.bean.Values;

/**
 * @author CK
 *
 */
@Controller
public class SkillAction {
	@Resource
	private SkillManager skillManager;
	/**
	 * @return the skillManager
	 */
	public SkillManager getSkillManager() {
		return skillManager;
	}

	/**
	 * @param skillManager the skillManager to set
	 */
	public void setSkillManager(SkillManager skillManager) {
		this.skillManager = skillManager;
	}

	private int count;
	private int sid;
	private ReserveSkill one;
	private ArrayList<ReserveSkill> range1;
	private ArrayList<ReserveSkill> range2;
	private ArrayList<ReserveSkill> range3;
	private ArrayList<ReserveSkill> range4;
	private ArrayList<ReserveSkill> range5;
	private ArrayList<ReserveSkill> range6;
	private ArrayList<ReserveSkill> range7;
	private ArrayList<ReserveSkill> range8;
	private ArrayList<ReserveSkill> range9;
	private ArrayList<ReserveSkill> range10;
	private ArrayList<ReserveSkill> range11;
	private ArrayList<ReserveSkill> range12;
	private ArrayList<ReserveSkill> range13;
	private ArrayList<ReserveSkill> range14;
	private ArrayList<ReserveSkill> range15;
	public ReserveSkill getOne() {
		return one;
	}

	public void setOne(ReserveSkill one) {
		this.one = one;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<ReserveSkill> getRange1() {
		return range1;
	}

	public void setRange1(ArrayList<ReserveSkill> range1) {
		this.range1 = range1;
	}

	public ArrayList<ReserveSkill> getRange2() {
		return range2;
	}

	public void setRange2(ArrayList<ReserveSkill> range2) {
		this.range2 = range2;
	}

	public ArrayList<ReserveSkill> getRange3() {
		return range3;
	}

	public void setRange3(ArrayList<ReserveSkill> range3) {
		this.range3 = range3;
	}

	public ArrayList<ReserveSkill> getRange4() {
		return range4;
	}

	public void setRange4(ArrayList<ReserveSkill> range4) {
		this.range4 = range4;
	}

	public ArrayList<ReserveSkill> getRange5() {
		return range5;
	}

	public void setRange5(ArrayList<ReserveSkill> range5) {
		this.range5 = range5;
	}

	public ArrayList<ReserveSkill> getRange6() {
		return range6;
	}

	public void setRange6(ArrayList<ReserveSkill> range6) {
		this.range6 = range6;
	}

	public ArrayList<ReserveSkill> getRange7() {
		return range7;
	}

	public void setRange7(ArrayList<ReserveSkill> range7) {
		this.range7 = range7;
	}

	public ArrayList<ReserveSkill> getRange8() {
		return range8;
	}

	public void setRange8(ArrayList<ReserveSkill> range8) {
		this.range8 = range8;
	}

	public ArrayList<ReserveSkill> getRange9() {
		return range9;
	}

	public void setRange9(ArrayList<ReserveSkill> range9) {
		this.range9 = range9;
	}

	public ArrayList<ReserveSkill> getRange10() {
		return range10;
	}

	public void setRange10(ArrayList<ReserveSkill> range10) {
		this.range10 = range10;
	}

	public ArrayList<ReserveSkill> getRange11() {
		return range11;
	}

	public void setRange11(ArrayList<ReserveSkill> range11) {
		this.range11 = range11;
	}

	public ArrayList<ReserveSkill> getRange12() {
		return range12;
	}

	public void setRange12(ArrayList<ReserveSkill> range12) {
		this.range12 = range12;
	}

	public ArrayList<ReserveSkill> getRange13() {
		return range13;
	}

	public void setRange13(ArrayList<ReserveSkill> range13) {
		this.range13 = range13;
	}

	public ArrayList<ReserveSkill> getRange14() {
		return range14;
	}

	public void setRange14(ArrayList<ReserveSkill> range14) {
		this.range14 = range14;
	}

	public ArrayList<ReserveSkill> getRange15() {
		return range15;
	}

	public void setRange15(ArrayList<ReserveSkill> range15) {
		this.range15 = range15;
	}
	/**
	 * 查看已提交的技能储备页面
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
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		readAllRanges(userId);
		count = skillManager.readCountByUserId(userId);
	}
	
	/**
	 * 进入技能储备表单填写界面
	 * @return
	 */
	public String form(){
		return "form";
	}
	/**
	 * 提交已更新好的技能储备页面
	 * @return
	 */
	public String update(){
		int userId = ((User)ActionContext.getContext().getSession().get("userLogined")).getId();
		String result = skillManager.updateSkill(userId, range1,range2,range3,range4,range5,range6,range7,range8,
					range9,range10,range11,range12,range13,range14,range15);
		if(result.equals(Values.SUCCESS)){
			message = "更新成功！";
		} else {
			message = "更新失败！请联系开发人员。";
		}
		beforeView();
		return "view";
	}

	/**
	 * 提交删除某条技能储备
	 * @return
	 */
	public String delete(){
		one = skillManager.readOne(sid);
		if(one == null){
			message = "这条技能储备已经不存在了哦！";
			beforeView();
			return "view";
		}
		User user = ((User)ActionContext.getContext().getSession().get("userLogined"));
		if(one.getUser().getId() != user.getId()){
			message = "请勿删除不属于您的技能储备";
		}else{
			String result = skillManager.deleteOne(sid);
			if(result.equals(Values.SUCCESS)){
				message = "删除成功！";
			}else if(result.equals(Values.FAILURE)){
				message = "删除失败！请联系开发人员。";
			}else {
				message = result;
			}
		}
		beforeView();
		return "view";
	}
	/**
	 * 
	 */
	private void readAllRanges(int userId) {
		range1 = skillManager.readSomeByUserIdAndClass1(userId, "基础课程");
		range2 = skillManager.readSomeByUserIdAndClass1(userId, "专业课程");
		range3 = skillManager.readSomeByUserIdAndClass1(userId, "语言交流");
		range4 = skillManager.readSomeByUserIdAndClass1(userId, "乐器交流");
		range5 = skillManager.readSomeByUserIdAndClass1(userId, "兴趣交流");
		range6 = skillManager.readSomeByUserIdAndClass1(userId, "编织交流");
		range7 = skillManager.readSomeByUserIdAndClass1(userId, "书刊借阅");
		range8 = skillManager.readSomeByUserIdAndClass1(userId, "体育运动");
		range9 = skillManager.readSomeByUserIdAndClass1(userId, "绘画交流");
		range10 = skillManager.readSomeByUserIdAndClass1(userId, "写作交流");
		range11 = skillManager.readSomeByUserIdAndClass1(userId, "软件技能");
		range12 = skillManager.readSomeByUserIdAndClass1(userId, "经验交流");
		range13 = skillManager.readSomeByUserIdAndClass1(userId, "互助陪伴");
		range14 = skillManager.readSomeByUserIdAndClass1(userId, "劳动帮忙");
		range15 = skillManager.readSomeByUserIdAndClass1(userId, "其它");
	}
}
