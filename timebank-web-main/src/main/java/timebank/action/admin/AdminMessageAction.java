/**
 * @Project TimeBank
 * @CreatedTime 2011-10-11 上午10:03:06 
 * @Author CK
 * @Todo TODO
 */
package timebank.action.admin;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;

import timebank.business.other.MessageManager;
import timebank.model.message.UserMessageFromSystem;
import timebank.util.Tester;
import timebank.util.bean.Values;

/**
 * @author CK
 *  
 */
@Namespace(value = "/admin/message")
@Controller
public class AdminMessageAction {
	@Resource
	private MessageManager messageManager;

	public MessageManager getMessageManager() {
		return messageManager;
	}
	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	private UserMessageFromSystem one;
	public UserMessageFromSystem getOne() {return one;}
	public void setOne(UserMessageFromSystem one) {this.one = one;}
	
	private ArrayList<UserMessageFromSystem> list;	
	public ArrayList<UserMessageFromSystem> getList() {	return list;}
	public void setList(ArrayList<UserMessageFromSystem> list) {this.list = list;}
	 
	private String message;
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	
	private int mAll;
	private int mRead;
		
	public int getMAll() {
		return mAll;
	}
	public void setMAll(int all) {
		mAll = all;
	}
	public int getMRead() {
		return mRead;
	}
	public void setMRead(int read) {
		mRead = read;
	}

	/**
	 * 传递过来的通知的ID
	 */ 
	private int nid;	
	public int getNid() {return nid;}
	public void setNid(int nid) {this.nid = nid;}
	
	/**
	 * 进入“消息”模块首页
	 * @return
	 */
	@Action(value = "view")
	public String view(){
		mRead = messageManager.readCountIsRead(Values.YES, Values.MSG_NOTICE);
		mAll = messageManager.readCountIsRead(Values.NO, Values.MSG_NOTICE) + mRead;
		return "view";
	}
	
	/**
	 * 查看所有已发布通知
	 * @return
	 */
	@Action(value = "viewNotice")
	public String viewNotice(){
		list = messageManager.readAllTemplate();
		if(message != null){
			Tester.markHere(message);
		}
		return "viewNotice";
	}

	/**
	 * 查看与修改已发布通知
	 * @return
	 */
	@Action(value = "modifyNotice")
	public String modifyNotice(){
		one = messageManager.getOneById(nid);
		return "modifyNotice";
	}
	
	/**
	 * 进入发布通知界面
	 * @return
	 */
	@Action(value = "newMessage")
	public String newMessage(){
		return "newMsg";
	}
	
	/**
	 * 提交新发布通知
	 * @return
	 */
	@Action(value = "submitNewNotice")
	public String submitNewNotice(){
		String result = messageManager.newNotice(one);
		list = messageManager.readAllTemplate();
		if(result.equals(Values.SUCCESS)){
			message = "增加通知成功！";
			return "viewNotice";
		}else{
			message = "增加通知失败！请联系开发人员。";
			return "viewNotice";
		}
	}
	
	/**
	 * 提交修改后的通知
	 * @return
	 */
	@Action(value = "submitModifyNotice")
	public String submitModifyNotice(){
		String result = messageManager.modifyNotice(one);
		list = messageManager.readAllTemplate();
		if(result.equals(Values.SUCCESS)){
			message = "修改通知成功！";
			return "viewNoticeWithMsg";
		}else{
			message = "修改通知失败！请联系开发人员。";
			return "viewNoticeWithMsg";
		}
	}
}
