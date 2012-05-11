/**
 * @Project TimeBank
 * @CreatedTime 2011-10-11 下午12:18:06 
 * @Author CK
 * @Todo TODO
 */
package timebank.business.other;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

import timebank.model.admin.Admin;
import timebank.model.bank.BankCompleteRecord;
import timebank.model.message.UserMessageFromSystem;
import timebank.model.user.User;
import timebank.persistence.MessageDao;
import timebank.persistence.UserDao;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
@Service
public class MessageManager{
//	@Resource
	private MessageDao messageDao;
	@Resource
	private UserDao userDao;
	
	/**
	 * @return the messageDao
	 */
	public MessageDao getMessageDao() {
		return messageDao;
	}

	/**
	 * @param messageDao the messageDao to set
	 */
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 添加新通知
	 * @param one
	 * @return
	 */
	public String newNotice(UserMessageFromSystem one){
		//获得当前操作管理员的ID，填充为记录的senderId。
//		int senderId = ((Admin)ActionContext.getContext().getSession().get("adminLogined")).getAdminId();
//		one.setSenderId(senderId);
//		
//		//管理员发布的通知皆为模板，以此属性标明。
//		one.setIsTemplate(Values.YES);
//		
//		//此时此刻发布。
//		one.setCreateTime(new Date());
		
		//存入数据库中，并获得ID指。
		String result = messageDao.createOne(one);
		
		if(result.equals(Values.SUCCESS)){
			//如果成功，取出所有用户的名单
			ArrayList<User> list = userDao.readSomeByIsRegistered(Values.YES);
			
			//临时存放单个用户，用于遍历
			User user;
			
			//将此通知设置为非管理员模板，即用户个人所有
//			one.setIsTemplate(Values.NO);
//			
//			for(int i = 0; i < list.size() ; i++){
//				//挨个增加每个用户对应的通知
//				user = list.get(i);
//				one.setOwner(user.getUsername());
//				one.setOwnerId(user.getUserId());
//				result = messageDao.createOne(one);
//				if(result.equals(Values.SUCCESS) == false){
//					return Values.FAILURE;
//				}
//			}
			return Values.SUCCESS;
		}
		return Values.FAILURE;
	}
	
	public ArrayList<UserMessageFromSystem> readAllTemplate(){
		return messageDao.readAllTemplate();
	}

	/**
	 * @param messageId
	 * @return
	 */
	public UserMessageFromSystem getOneById(int messageId) {
		UserMessageFromSystem one = messageDao.readOneById(messageId);
		return one;
	}

	/**
	 * @param one
	 * @return
	 */
	public String modifyNotice(UserMessageFromSystem one) {
		UserMessageFromSystem oldOne = messageDao.readOneById(one.getMessageId());
//		oldOne.setSender(one.getSender());
		oldOne.setTitle(one.getTitle());
		oldOne.setContent(one.getContent());
		return messageDao.updateOne(oldOne);
	}
	
	public String setOneRead(int mid){
		return messageDao.updateOneIsRead(mid,Values.YES);
	}

	/**
	 * @param userId
	 * @return
	 */
	public int[] getUnreadCountByUserId(int userId) {
		int notice = messageDao.readCountUnreadByIdByType(Values.NO, userId, Values.MSG_NOTICE);
		int msg = messageDao.readCountUnreadByIdByType(Values.NO, userId, Values.MSG_MESSAGE);
		if(notice == 0 && msg == 0){
			return null;
		}
		int[] list = new int[5];
		list[Values.MSG_MESSAGE] = msg;
		list[Values.MSG_NOTICE] = notice;
		return list;
	}

	/**
	 * @param userId
	 * @return
	 */
	public ArrayList<UserMessageFromSystem> getOnesMessage(int userId) {
		ArrayList<UserMessageFromSystem> list = messageDao.readSomeByOwnerId(userId);
		return list;
	}

	public int readCountIsRead(int isRead, int type) {
		return messageDao.readCountIsRead(isRead, type);
	}
}
