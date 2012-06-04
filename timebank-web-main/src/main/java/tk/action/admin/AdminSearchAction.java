package tk.action.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import timebank.business.impl.user.UserManagerImpl;
import timebank.model.reserve.ReserveIdleTime;
import timebank.model.reserve.ReserveSkill;
import timebank.model.user.User;
import tk.business.user.IdleTimeManager;
import tk.business.user.SkillManager;
import tk.util.Methods;
import tk.util.Tester;
import tk.util.Verifier;
import tk.util.bean.Values;

@Namespace(value = "/admin/search")
@Controller
public class AdminSearchAction {
	@Resource
	private UserManagerImpl userManager;
	@Resource
	private SkillManager skillManager;
	@Resource
	private IdleTimeManager idleTimeManager;
	
	public UserManagerImpl getUserManager() {
		return userManager;
	}
	public void setUserManager(UserManagerImpl userManager) {
		this.userManager = userManager;
	}
	public SkillManager getSkillManager() {
		return skillManager;
	}
	public void setSkillManager(SkillManager skillManager) {
		this.skillManager = skillManager;
	}
	public IdleTimeManager getIdleTimeManager() {
		return idleTimeManager;
	}
	public void setIdleTimeManager(IdleTimeManager idleTimeManager) {
		this.idleTimeManager = idleTimeManager;
	}
	private ArrayList<User> list;
	private int p;
	private int count;
	private int count1;
	private int pages;
	private User user;
	private int uid;
	private int cid;
	private String message;
	private String someInfo;
	private String sid;
	private int newReg;
	private int newVer;
	private int countAllVeri;
	private int countAllUsed;
	private int countHaveSkills;
	private int countSkills;
	private int countHaveIdleTimes;
	private int countIdleTimes;
	private ArrayList<ReserveIdleTime> day1;
	private ArrayList<ReserveIdleTime> day2;
	private ArrayList<ReserveIdleTime> day3;
	private ArrayList<ReserveIdleTime> day4;
	private ArrayList<ReserveIdleTime> day5;
	private ArrayList<ReserveIdleTime> day6;
	private ArrayList<ReserveIdleTime> day7;
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
	private ArrayList<Integer> collegesUsed;
	private ArrayList<Integer> collegesVerified;
	public int getCount1() {return count1;}
	public void setCount1(int count1) {this.count1 = count1;}
	public ArrayList<ReserveIdleTime> getDay1() {return day1;}
	public void setDay1(ArrayList<ReserveIdleTime> day1) {this.day1 = day1;}
	public ArrayList<ReserveIdleTime> getDay2() {return day2;}
	public void setDay2(ArrayList<ReserveIdleTime> day2) {this.day2 = day2;}
	public ArrayList<ReserveIdleTime> getDay3() {return day3;}
	public void setDay3(ArrayList<ReserveIdleTime> day3) {this.day3 = day3;}
	public ArrayList<ReserveIdleTime> getDay4() {return day4;}
	public void setDay4(ArrayList<ReserveIdleTime> day4) {this.day4 = day4;}
	public ArrayList<ReserveIdleTime> getDay5() {return day5;}
	public void setDay5(ArrayList<ReserveIdleTime> day5) {this.day5 = day5;}
	public ArrayList<ReserveIdleTime> getDay6() {return day6;}
	public void setDay6(ArrayList<ReserveIdleTime> day6) {this.day6 = day6;}
	public ArrayList<ReserveIdleTime> getDay7() {return day7;}
	public void setDay7(ArrayList<ReserveIdleTime> day7) {this.day7 = day7;}
	public int getCountHaveIdleTimes() {return countHaveIdleTimes;}
	public void setCountHaveIdleTimes(int countHaveIdleTimes) {this.countHaveIdleTimes = countHaveIdleTimes;}
	public int getCountIdleTimes() {return countIdleTimes;}
	public void setCountIdleTimes(int countIdleTimes) {this.countIdleTimes = countIdleTimes;}
	public ArrayList<Integer> getCollegesUsed() {return collegesUsed;}
	public void setCollegesUsed(ArrayList<Integer> collegesUsed) {this.collegesUsed = collegesUsed;}
	public ArrayList<Integer> getCollegesVerified() {return collegesVerified;}
	public void setCollegesVerified(ArrayList<Integer> collegesVerified) {this.collegesVerified = collegesVerified;}
	public int getCid() {return cid;}
	public void setCid(int cid) {this.cid = cid;}
	public int getCountSkills() {return countSkills;}
	public void setCountSkills(int countSkills) {this.countSkills = countSkills;}
	public int getCountHaveSkills() {return countHaveSkills;}
	public void setCountHaveSkills(int countHaveSkills) {this.countHaveSkills = countHaveSkills;}
	public ArrayList<ReserveSkill> getRange1() {return range1;}
	public void setRange1(ArrayList<ReserveSkill> range1) {this.range1 = range1;}
	public ArrayList<ReserveSkill> getRange2() {return range2;}
	public void setRange2(ArrayList<ReserveSkill> range2) {this.range2 = range2;}
	public ArrayList<ReserveSkill> getRange3() {return range3;}
	public void setRange3(ArrayList<ReserveSkill> range3) {this.range3 = range3;}
	public ArrayList<ReserveSkill> getRange4() {return range4;}
	public void setRange4(ArrayList<ReserveSkill> range4) {this.range4 = range4;}
	public ArrayList<ReserveSkill> getRange5() {return range5;}
	public void setRange5(ArrayList<ReserveSkill> range5) {this.range5 = range5;}
	public ArrayList<ReserveSkill> getRange6() {return range6;}
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getCountAllVeri() {return countAllVeri;}
	public void setCountAllVeri(int countAllVeri) {this.countAllVeri = countAllVeri;}
	public int getCountAllUsed() {return countAllUsed;}
	public void setCountAllUsed(int countAllUsed) {this.countAllUsed = countAllUsed;}
	public int getNewVer() {return newVer;}
	public void setNewVer(int newVer) {this.newVer = newVer;}
	public int getNewReg() {return newReg;}
	public void setNewReg(int newReg) {this.newReg = newReg;}
	public String getSid() {return sid;}
	public void setSid(String sid) {this.sid = sid;}
	public String getSomeInfo() {return someInfo;}
	public void setSomeInfo(String someInfo) {this.someInfo = someInfo;}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	public int getP() {if(p < 1){p = 1;}return p;}
	public void setP(int p) {if(p < 1){p = 1;}this.p = p;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	public int getPages() {return pages;}
	public void setPages(int pages) {this.pages = pages;}
	public ArrayList<User> getList() {return list;}
	public void setList(ArrayList<User> list) {this.list = list;}
	private ReserveIdleTime idleTime;	
	public ReserveIdleTime getIdleTime() {return idleTime;}
	public void setIdleTime(ReserveIdleTime idleTime) {this.idleTime = idleTime;}
	private String someSkills;
	public String getSomeSkills() {return someSkills;}
	public void setSomeSkills(String someSkills) {this.someSkills = someSkills;}
	
	/**
	 * 
	 */
	private void readAllRanges(long uid2) {
		range1 = skillManager.readSomeByUserIdAndClass1(uid2, "基础课程");
		range2 = skillManager.readSomeByUserIdAndClass1(uid2, "专业课程");
		range3 = skillManager.readSomeByUserIdAndClass1(uid2, "语言交流");
		range4 = skillManager.readSomeByUserIdAndClass1(uid2, "乐器交流");
		range5 = skillManager.readSomeByUserIdAndClass1(uid2, "兴趣交流");
		range6 = skillManager.readSomeByUserIdAndClass1(uid2, "编织交流");
		range7 = skillManager.readSomeByUserIdAndClass1(uid2, "书刊借阅");
		range8 = skillManager.readSomeByUserIdAndClass1(uid2, "体育运动");
		range9 = skillManager.readSomeByUserIdAndClass1(uid2, "绘画交流");
		range10 = skillManager.readSomeByUserIdAndClass1(uid2, "写作交流");
		range11 = skillManager.readSomeByUserIdAndClass1(uid2, "软件技能");
		range12 = skillManager.readSomeByUserIdAndClass1(uid2, "经验交流");
		range13 = skillManager.readSomeByUserIdAndClass1(uid2, "互助陪伴");
		range14 = skillManager.readSomeByUserIdAndClass1(uid2, "劳动帮忙");
		range15 = skillManager.readSomeByUserIdAndClass1(uid2, "其它");
	}
	
	private void readAllDays(int userId) {
		day1 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期一");
		day2 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期二");
		day3 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期三");
		day4 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期四");
		day5 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期五");
		day6 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期六");
		day7 = idleTimeManager.readSomeByUserIdAndIdleDay(userId, "星期天");
	}
	
	/**
	 * get the sidebar status.
	 */
	private void getSidebarStatus() {
		newReg = userManager.readCountByIsRegisteredToday(Values.INFO_USED);
		newVer = userManager.readCountVerifiedToday();
	}
	
	/**
	 * get the index status.
	 */
	private void getIndexStatus(){
		countAllVeri = userManager.readCountByType(Values.INFO_USED, Values.USER_VERIFIED);
		countAllUsed = countAllVeri + userManager.readCountByType(Values.INFO_USED, Values.USER_NOT_VERIFIED); 
	}
	
	/**
	 * 	before view a user, read some information.
	 */
	private void beforeView() {
		user = userManager.getUserInfo(uid);
		readAllRanges(uid);
		readAllDays(uid);
		count = skillManager.readCountByUserId(uid);
		count1 = idleTimeManager.readCountByUserId(uid);
	}
	
	/**
	 * enter the index page.
	 */
	@Action(value = "index")
	public String index(){
		getSidebarStatus();
		getIndexStatus();
		return "index";
	}
	
	/**
	 * view a user.
	 */
	@Action(value = "view")
	public String view(){
		beforeView();
		return "view";
	}

	@Action(value = "unverified")
	public String unverified(){
		list = userManager.getUsersByType(Values.INFO_USED, Values.USER_NOT_VERIFIED, p);
		count = userManager.readCountByType(Values.INFO_USED, Values.USER_NOT_VERIFIED);
		pages = Methods.readPages(count);
		return "unverified";
	}

	@Action(value = "verified")
	public String verified(){
		list = userManager.getUsersByType(Values.INFO_USED, Values.USER_VERIFIED, p);
		count = userManager.readCountByType(Values.INFO_USED, Values.USER_VERIFIED);
		pages = Methods.readPages(count);
		return "verified";
	}
	
	@Action(value = "unregister")
	public String unregister(){
		list = userManager.getUnregisterUsers(p);
		count = userManager.getUnregisteredUserCount();
		pages = Methods.readPages(count);
		return "unregister";
	}
	
	@Action(value = "verify")
	public String verify(){
		String result = userManager.updateUserStatus(uid, Values.USER_VERIFIED);
		if(result.equals(Values.SUCCESS)){
			message = "更新成功！";
		}else{
			message = "更新失败！请联系管理员。";
		}
		list = userManager.getUsersByType(Values.INFO_USED, Values.USER_VERIFIED, p);
		count = userManager.readCountByType(Values.INFO_USED, Values.USER_VERIFIED);
		pages = Methods.readPages(count);
		return "verified";
	}
	
	@Action(value = "search")
	public String search(){
		if(p < 1){
			p = 1;
		}
		if(someInfo == null || someInfo.trim().length() == 0){
			someInfo = ActionContext.getContext().getSession().get("someInfo").toString();
		}
		someInfo = someInfo.trim();//去除关键字两端空格
		list = userManager.getUsersBySomeInfo(someInfo, p);
		count = userManager.getCountUsersBySomeInfo(someInfo);
		pages = Methods.readPages(count);
		ActionContext.getContext().getSession().put("someInfo", someInfo);
		return "search";
	}
	
	@Action(value = "submit")
	public String submit(){
		String result = userManager.updateAllInfoByUserId(user);
		if(result.equals(Values.SUCCESS)){
			message = "更新用户信息成功！";
		}else{
			message = "更新用户信息失败！请联系开发人员。";
		}
		uid = user.getId();
		beforeView();
		return "viewOne";
	}
	
	@Action(value = "downloadUser")
	public String downloadUser(){
		User user = userManager.getUserInfo(uid);
		ActionContext.getContext().getSession().put("userLogined", user);
		return "downloadUser";
	}
	
	@Action(value = "register")
	public String register(){
		uid = user.getId();
		Verifier v = new Verifier();
		if(v.testUsername(user.getLoginName(), true) != true){
			message = "用户名不符合要求！";
			beforeView();
			return "viewOne";
		}
		if(v.testEmail(user.getUserInfo().getEmail(), true) != true){
			message = "Email不符合要求！";
			beforeView();
			return "viewOne";
		}
//		user.setPassword(user.getStudentId());
//		String result = userManager.registerUser(user);
//		if(result.equals(Values.SUCCESS)){
//			Tester.markHere("true");
//			message = "注册成功！初始密码为用户学号。";
//		}else{
//			Tester.markHere("false");
//			message = result;
//		}
//		beforeView();
		return "viewOne";
	}
	
	@Action(value = "resetPassword")
	public String resetPassword(){
		String result = userManager.resetPsw(uid);
		if(result.equals(Values.SUCCESS) == true){
			message = "重置密码成功！";
		}else{
			message = "重置密码失败！请联系开发人员。";
		}
		beforeView();
		return "viewOne";
	}
	
	/**
	 * 按照技能储备提交搜索用户
	 * @return
	 */
	@Action(value = "searchSkillMen")
	public String searchSkillMen(){
		if(p < 1){
			p = 1;
		}
		if(someInfo == null || someInfo.trim().length() == 0){
			someInfo = ActionContext.getContext().getSession().get("someInfo").toString();
		}
		someInfo = someInfo.trim();//去除关键字两端空格
		
		list = userManager.getSkillMenBySomeInfo(someInfo, p);
		count = userManager.getSkillMenCountBySomeInfo(someInfo);
		
		pages = Methods.readPages(count);
		ActionContext.getContext().getSession().put("someInfo", someInfo);
		return "search";
	}
	
	/**
	 * 查看所有有填写时间储备的用户
	 * @return
	 */
	@Action(value = "viewIdleTimeMen")
	public String viewIdleTimeMen(){
		if(p < 1){
			p = 1;
		}		
		list = userManager.readUserIdByHaveIdleTimes(p);
		count = userManager.readCountUserIdByHaveIdleTimes();
		
		pages = Methods.readPages(count);
		someInfo = "已填写【时间储备】的用户";
		return "search";
	}
	/**
	 * 查看所有有填写技能储备的用户
	 * @return
	 */
	@Action(value = "viewSkillMen")
	public String viewSkillMen(){
		if(p < 1){
			p = 1;
		}		
		list = userManager.readUserIdByHaveSkills(p);
		count = userManager.readCountUserIdByHaveSkills();
		
		pages = Methods.readPages(count);
		someInfo = "已填写【技能储备】的用户";
		return "search";
	}
	
	/**
	 * 按照学院查看用户
	 * @return
	 */
	@Action(value = "byCollege")
	public String byCollege(){
		if(p < 1){
			p = 1;
		}
		if(cid == 0){
			cid = Integer.parseInt(ActionContext.getContext().getSession().get("cid").toString());
		}
		list = userManager.getSomeByCollege(cid, p);
		count = userManager.getSomeCountByCollege(cid);
		someInfo = getStringByCollegeId(cid);
		pages = Methods.readPages(count);
		ActionContext.getContext().getSession().put("cid", cid);
		return "search";
	}
	
	/** 根据学院ID得到学院名称
	 * @param cid2
	 * @return
	 */
	private String getStringByCollegeId(int cid2) {
		if(cid == 1){
			return "农学院";
		}
		if(cid == 2){
			return "资源环境学院";
		}
		if(cid == 3){
			return "生命科学学院";
		}
		if(cid == 4){
			return "经济管理学院";
		}
		if(cid == 5){
			return "工程学院";
		}
		if(cid == 6){
			return "动物科学学院";
		}
		if(cid == 7){
			return "兽医学院";
		}
		if(cid == 8){
			return "园艺学院";
		}
		if(cid == 9){
			return "食品学院";
		}
		if(cid == 10){
			return "林学院";
		}
		if(cid == 11){
			return "人文与法学学院";
		}
		if(cid == 12){
			return "理学院";
		}
		if(cid == 13){
			return "信息学院";
		}
		if(cid == 14){
			return "艺术学院";
		}
		if(cid == 15){
			return "外国语学院";
		}
		if(cid == 16){
			return "水利与土木工程学院";
		}
		if(cid == 17){
			return "公共管理学院";
		}
		return "";
	}
	
	/**
	 * 进入技能储备后台首页
	 * @return
	 */
	@Action(value = "viewSkills")
	public String viewSkills(){
		countHaveSkills = userManager.readCountUserIdByHaveSkills();
		countSkills = userManager.readCountSkills();
		return "viewSkills";
	}	
	
	/**
	 * 进入时间储备后台首页
	 * @return
	 */
	@Action(value = "viewIdleTimes")
	public String viewIdleTimes(){
		countHaveIdleTimes = userManager.readCountUserIdByHaveIdleTimes();
		countIdleTimes = userManager.readCountIdleTimes();
		return "viewIdleTimes";
	}
	
	/**
	 * 根据关键字搜索时间储备
	 * @return
	 */
	@Action(value = "searchIdleTimeMen")
	public String searchIdleTimeMen(){
		p = Methods.correctPage(p);
//		if(idleTime == null || idleTime.getIdleDay() == null || idleTime.getIdleDay().length() == 0 ||
//		   idleTime.getIdleHour() == null || idleTime.getIdleHour().length() == 0){
//			idleTime = ((ReserveIdleTime)ActionContext.getContext().getSession().get("idleTime"));
//		}
//		someInfo = idleTime.getIdleDay() + idleTime.getIdleHour();
		list = userManager.getIdleTimeMenBySomeInfo(idleTime, p);
		count = userManager.getIdleTimeMenCountBySomeInfo(idleTime);
		pages = Methods.readPages(count);
		ActionContext.getContext().getSession().put("idleTime", idleTime);
		return "search";
	}
	
	@Action(value = "viewCollege")
	public String viewCollege(){
		int countT = 0;
		collegesUsed = new ArrayList<Integer>();
		collegesVerified = new ArrayList<Integer>();
		collegesUsed.add(0);
		collegesVerified.add(0);
		for (int i = 1; i <= 17; i++) {
			countT = userManager.readCountSomeByCollegeAndIsUsed(i, Values.INFO_USED);
			collegesUsed.add(countT);
			countT = userManager.readCountSomeByCollegeAndIsVerified(i, Values.USER_VERIFIED);
			collegesVerified.add(countT);
		}
		return "viewCollege";
	}
	
	@Action(value = "searchUnion")
	public String searchUnion(){		
		someInfo = idleTime.getIdleDay() + idleTime.getIdleHour() + " " + someSkills;
		list = userManager.getIdleTimeMenByUnion(idleTime, someSkills, p);
		count = list.size();
		return "searchUnion";
	}
}
