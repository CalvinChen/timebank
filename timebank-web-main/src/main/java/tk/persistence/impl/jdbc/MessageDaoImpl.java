package tk.persistence.impl.jdbc;
//package timebank.persistence.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Repository;
//
//
//import timebank.model.message.MessageOfUser;
//import timebank.persistence.MessageDao;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//import timebank.util.bean.DatabaseTable;
//import timebank.util.bean.Values;
//
//@Repository
//public class MessageDaoImpl implements MessageDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//	
//	/**
//	 * 向数据库中新增一则消息
//	 * @param one
//	 * @return
//	 */
//	@Override
//	public String createOne(MessageOfUser one) {
//		Tester.markHere("MessageDAO.createOne");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			//插入当前记录的所有属性，
//			//除了messageId（数据库自生成）、updateTime（数据库自更改）、readTime（还未被读）、isRead（默认0）
//			ps = conn.prepareStatement("insert into " + DatabaseTable.MESSAGE + 
//					" (type,sender,senderId,owner,ownerId,title,content,createTime,isTemplate) " + 
//					"values(?,?,?,?,?,?,?,?,?)");
//			int i = 1;
//			ps.setInt(i++, one.getType());
//			ps.setString(i++, one.getSender());
//			ps.setInt(i++, one.getSenderId());
//			ps.setString(i++, one.getOwner());
//			ps.setInt(i++, one.getOwnerId());
//			ps.setString(i++, one.getTitle());
//			ps.setString(i++, one.getContent());
//			ps.setTimestamp(i++, new java.sql.Timestamp(one.getCreateTime().getTime()));
//			ps.setInt(i++, one.getIsTemplate());
//			i = ps.executeUpdate();
//			if(i > 0){
//				Tester.markHere("result > 0");
//				result = Values.SUCCESS;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return result;
//	}
//
////	/**
////	 * 获得数据库中所有消息信息
////	 * @param userId 
////	 * @return
////	 */
////	public ArrayList<Article> readAll() {
////		Tester.markHere("ArticleDAO.getAllArticle");
////		DBConnection.initial(rs, ps, conn);
////		conn = DBConnection.getConnection();
////		ArrayList<Article> list = new ArrayList<Article>();
////		try {
////			ps = conn.prepareStatement("select * from " + DatabaseTable.ARTICLE + " ORDER BY articleId DESC");
////			rs = ps.executeQuery();
////			while(rs.next()){
////				Article one = readOneProcess();
////				list.add(one);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			DBConnection.free(rs, ps, conn);
////		}
////		return list;
////	}
//
//	/**
//	 * @return
//	 * @throws SQLException
//	 */
//	private MessageOfUser readOneProcess() throws SQLException {
//		MessageOfUser one = new MessageOfUser();
//		one.setMessageId(rs.getInt("messageId"));
//		one.setType(rs.getInt("type"));
//		one.setSender(rs.getString("sender"));
//		one.setSenderId(rs.getInt("senderId"));
//		one.setOwner(rs.getString("owner"));
//		one.setOwnerId(rs.getInt("ownerId"));
//		one.setTitle(rs.getString("title"));
//		one.setContent(rs.getString("content"));
//		one.setCreateTime(rs.getTimestamp("createTime"));
//		one.setUpdateTime(rs.getTimestamp("updateTime"));
//		one.setReadTime(rs.getTimestamp("readTime"));
//		one.setIsRead(rs.getInt("isRead"));
//		return one;
//	}
//	
////	/**
////	 * 获得数据库中指定文章类型的所有文章信息
////	 * @param articleType 
////	 * @return
////	 */
////	public ArrayList<Article> readSomeByType(int articleType) {
////		Tester.markHere("MessageDAO.getArticlesByType");
////		DBConnection.initial(rs, ps, conn);
////		conn = DBConnection.getConnection();
////		Article one;
////		ArrayList<Article> list = new ArrayList<Article>();
////		try {
////			ps = conn.prepareStatement("select * from " + DatabaseTable.ARTICLE + " where articleType=? ORDER BY articleId DESC");
////			ps.setInt(1, articleType);
////			rs = ps.executeQuery();
////			while(rs.next()){
////				one = readOneProcess();
////				list.add(one);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			DBConnection.free(rs, ps, conn);
////		}
////		return list;
////	}
//	
//	/**
//	 * 根据one的messageId更新文章内容
//	 * @param one
//	 * @return
//	 */
//	@Override
//	public String updateOne(MessageOfUser one) {
//		Tester.markHere("MessageDAO.updateArticle");
//		String flag = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.MESSAGE + 
//					" set type=?,sender=?,senderId=?,owner=?,ownerId=?,title=?,content=?,isRead=?  where messageId=?");
//			int i = 1;
//			ps.setInt(i++, one.getType());
//			ps.setString(i++, one.getSender());
//			ps.setInt(i++, one.getSenderId());
//			ps.setString(i++, one.getOwner());
//			ps.setInt(i++, one.getOwnerId());
//			ps.setString(i++, one.getTitle());
//			ps.setString(i++, one.getContent());
//			ps.setInt(i++, one.getIsRead());
//			
//			ps.setInt(i++, one.getMessageId());
//			int rtn = ps.executeUpdate();
//			if (rtn > 0) {
//				Tester.markHere("rtn > 0");
//				flag = Values.SUCCESS;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return flag;
//	}
//
//	/**
//	 * 根据message的ID读取消息
//	 * @param messageId
//	 * @return
//	 */
//	@Override
//	public MessageOfUser readOneById(int messageId) {
//		Tester.markHere("MessageDAO.readOneById");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		MessageOfUser one = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.MESSAGE + " where messageId=?");
//			ps.setInt(1, messageId);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				one = readOneProcess();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return one;
//	}
//
//	/**
//	 * 根据message的ID删除消息
//	 * @param messageId
//	 * @return
//	 */
//	@Override
//	public String deleteOne(int messageId) {
//		Tester.markHere("MessageDAO.deleteOne");
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.MESSAGE + " where messageId=?");
//			ps.setInt(1, messageId);
//			int result = ps.executeUpdate();
//			if(result > 0){
//				Tester.markHere("result > 0");
//				flag = Values.SUCCESS;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//
//		return flag;
//	}
//
//	/**
//	 * 根据message的ID读取消息，读出所有的草稿
//	 * @param messageId
//	 * @return
//	 */
//	@Override
//	public ArrayList<MessageOfUser> readAllTemplate() {
//		Tester.markHere("MessageDAO.readOneById");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ArrayList<MessageOfUser> list = new ArrayList<MessageOfUser>();
//		MessageOfUser one = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.MESSAGE + " where isTemplate=?");
//			ps.setInt(1, Values.YES);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = readOneProcess();
//				list.add(one);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return list;
//	}
//
//	/**
//	 * @return
//	 */
//	@Override
//	public int readCountUnreadByIdByType(int isRead, int userId, int type) {
//		Tester.markHere("MessageDAO.readCountByIsReadAndById");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		MessageOfUser one = null;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.MESSAGE + 
//					" where isRead=? and ownerId=? and type=?");
//			ps.setInt(1, isRead);
//			ps.setInt(2, userId);
//			ps.setInt(3, type);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return count;
//	}
//	/**
//	 * @return
//	 */
//	@Override
//	public int readCountIsRead(int isRead, int type) {
//		Tester.markHere("MessageDAO.readCountByIsReadAndById");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		MessageOfUser one = null;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.MESSAGE + 
//					" where isRead=? and type=?");
//			ps.setInt(1, isRead);
//			ps.setInt(2, type);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return count;
//	}
//
//	/**
//	 * @param userId
//	 * @return
//	 */
//	@Override
//	public ArrayList<MessageOfUser> readSomeByOwnerId(int userId) {
//		Tester.markHere("MessageDAO.readSomeByOwnerId");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		MessageOfUser one = null;
//		ArrayList<MessageOfUser> list = new ArrayList<MessageOfUser>();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.MESSAGE + " where ownerId=? order by isRead,createTime desc");
//			ps.setInt(1, userId);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = readOneProcess();
//				list.add(one);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return list;
//	}
//
//	/**
//	 * @param isRead
//	 */
//	@Override
//	public String updateOneIsRead(int mid, int isRead) {
//		Tester.markHere("MessageDAO.updateOneIsRead");
//		String flag = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.MESSAGE + 
//					" set isRead=?  where messageId=?");
//			int i = 1;
//			ps.setInt(i++, isRead);
//			ps.setInt(i++, mid);
//			int rtn = ps.executeUpdate();
//			if (rtn > 0) {
//				Tester.markHere("rtn > 0");
//				flag = Values.SUCCESS;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return flag;
//	}
//}
