/**
 * @Project TimeBank
 * @CreatedTime 2011-10-25 下午12:30:03 
 * @Author CK
 */
package tk.action.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import timebank.model.admin.Admin;
import tk.business.admin.AdminManager;
import tk.util.Methods;
import tk.util.Verifier;
import tk.util.bean.Values;

/**
 * An action which controls admin management
 * @author CK
 */
@Namespace(value = "/admin/manage/admin")
@Results(value = {
		@Result(name = "create", location = "/view/admin/manage/admin/create.jsp"),
		@Result(name = "index", location = "/view/admin/manage/admin/index.jsp"),
		@Result(name = "list", location = "/view/admin/manage/admin/list.jsp"),
		@Result(name = "view", location = "/view/admin/manage/admin/view.jsp")
})
@Controller
public class AdminAction {

	@Resource
	private AdminManager adminManager;
	public AdminManager getAdminManager() {
		return adminManager;
	}
	public void setAdminManager(AdminManager adminManager) {
		this.adminManager = adminManager;
	}

	private ArrayList<Admin> list;

	public ArrayList<Admin> getList() {
		return list;
	}

	public void setList(ArrayList<Admin> list) {
		this.list = list;
	}

	private int p;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	private int pages;

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String passwordConfirm;

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Admin one;

	public Admin getOne() {
		return one;
	}

	public void setOne(Admin one) {
		this.one = one;
	}

	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private int aid;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * enter the index page of admin management.
	 */
	@Action(value = "index")
	public String index() {
		beforeEnterIndex();
		return "index";
	}

	/**
	 * view one admin's detail information
	 */
	@Action(value = "view")
	public String view() {
		one = adminManager.readOne(aid);
		return "view";
	}

	/**
	 * before entering index page, we must do something
	 */
	private void beforeEnterIndex() {
		if (p < 1) {
			p = 1;
		}
		list = adminManager.readAllbyPage(p);
		count = adminManager.readCountAll();
		pages = Methods.readPages(count);
	}

	/**
	 * create one admin
	 */
	@Action(value = "create")
	public String create() {
		return "create";
	}

	/**
	 * the action of submitting admin creation
	 */
	@Action(value = "submitCreate")
	public String submitCreate() {
		if (one.getPassword().equals(passwordConfirm) == false) {
			message = "两次密码输入不一致！";
			return "create";
		}
		Verifier v = new Verifier();
		if (v.testUsername(one.getLoginName(), true) == false) {
			message = "用户名不符合要求！";
			return "create";
		}
		if (v.testPassword(one.getPassword(), true) == false) {
			message = "密码不符合要求！";
			return "create";
		}
		String result = adminManager.createOne(one);
		if (result.equals(Values.SUCCESS) == false) {
			message = result;
			return "create";
		} else {
			message = "新建管理员成功！";
			beforeEnterIndex();
			return "index";
		}
	}

	/**
	 * submit the request of modifying one admin
	 */
	@Action(value = "submitModify")
	public String submitModify() {
		one.setId(aid);
		Verifier v = new Verifier();
		if (v.testPassword(one.getPassword(), false) == false) {
			message = "密码不符合要求！";
		}
		if ((one.getPassword() != null && one.getPassword().length() != 0)
				|| (passwordConfirm != null && passwordConfirm.length() != 0)) {
			if (one.getPassword().equals(passwordConfirm) == false) {
				message = "两次密码不一致！";
			}
		}
		if (v.testUsername(one.getLoginName(), true) == false) {
			message = "用户名不符合要求！";
		}
		if (message == null || message.length() == 0) {
			String result = adminManager.updateOne(one);
			if (result.equals(Values.SUCCESS) == false) {
				message = "管理员信息更新失败！请联系开发人员。";
			} else {
				message = "更新成功！";
			}
		}
		one = adminManager.readOne(aid);
		return "view";
	}

	/**
	 * promote the admin's level
	 */
	@Action(value = "promote")
	public String promote() {
		String result = adminManager.promote(uid);
		if (result.equals(Values.SUCCESS)) {
			message = "提拔管理员成功！";
		} else {
			message = result;
		}
		beforeEnterIndex();
		return "index";
	}

	/**
	 * delete one admin 
	 */
	@Action(value = "delete")
	public String delete() {
		String reslut = adminManager.deleteOne(aid);
		if (reslut.equals(Values.SUCCESS)) {
			message = "删除成功！";
		} else {
			message = "删除失败！请联系开发人员。";
		}
		beforeEnterIndex();
		return "index";
	}

	/**
	 * remove the association user link
	 */
	@Action(value = "removeLink")
	public String removeLink() {
		String result = adminManager.removeLink(aid);
		if (result.equals(Values.SUCCESS)) {
			message = "解除绑定成功！";
		} else {
			message = "解除绑定失败！请联系开发人员。";
		}
		one = adminManager.readOne(aid);
		return "view";
	}

	/**
	 * view the admin list
	 */
	@Action(value = "list")
	public String list() {
		beforeEnterIndex();
		return "list";
	}
}
