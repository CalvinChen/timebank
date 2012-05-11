///**
// * @Project TimeBank
// * @CreatedTime 2011-10-8 下午09:01:24 
// * @Author CK
// * @Todo TODO
// */
//package timebank.persistence.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.springframework.stereotype.Repository;
//
//import timebank.model.DatabaseTable;
//import timebank.model.Values;
//import timebank.model.suggestion.UserSuggestion;
//import timebank.persistence.FeedbackDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//
///**
// * @author CK
// *
// */
//@Repository
//public class FeedbackDaoImpl implements FeedbackDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//
//	/**
//	 * 获得所有已经处理了的反馈信息
//	 * @param p 
//	 * @return 所有已处理反馈信息
//	 */
//	@Override
//	public ArrayList<UserSuggestion> readSomeByIsHandledLimit(int isHandled, int p) {
//		ArrayList<UserSuggestion> fbrList = new ArrayList<UserSuggestion>();
//		UserSuggestion fbr;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.FEEDBACK + 
//					" where isAnswered=? ORDER BY feedbackId DESC limit ?,?");
//			ps.setInt(1, isHandled);
//			ps.setInt(2, Values.PAGE_SIZE * (p - 1));
//			ps.setInt(3, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				fbr = readOneProcess();
//				fbrList.add(fbr);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return fbrList;
//	}
//	/**
//	 * 获得是否处理了的反馈信息的总数
//	 * @return 总数
//	 */
//	@Override
//	public int readCountByIsHandled(int isHandled) {
//		ArrayList<UserSuggestion> fbrList = new ArrayList<UserSuggestion>();
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.FEEDBACK + " where isAnswered=? ORDER BY feedbackId DESC");
//			ps.setInt(1, isHandled);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	 * 获得今天是否处理了的反馈信息的总数
//	 * @return 总数
//	 */
//	@Override
//	public int readTodayCountByIsHandled(int isHandled) {
//		ArrayList<UserSuggestion> fbrList = new ArrayList<UserSuggestion>();
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.FEEDBACK + 
//					" where isAnswered=? and timestampdiff(day ,createTime,now())=0 ORDER BY feedbackId DESC");
//			ps.setInt(1, isHandled);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	 * @return
//	 * @throws SQLException
//	 */
//	private UserSuggestion readOneProcess() throws SQLException {
//		UserSuggestion fbr;
//		fbr = new UserSuggestion();
//		fbr.setUserId(rs.getInt("userId"));
//		fbr.setFeedbackId(rs.getInt("feedbackId"));
//		fbr.setPostTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		fbr.setTitle(rs.getString("feedbackTitle"));
//		fbr.setFeedbackContent(rs.getString("feedbackContent"));
//		fbr.setIsAnswered(rs.getInt("isAnswered"));
//		fbr.setAdminId(rs.getInt("adminId"));
//		fbr.setAnswerTime(Convertor.changeDateTimeToString(rs.getTimestamp("answerTime")));
//		fbr.setAnswerContent(rs.getString("answerContent"));
//		return fbr;
//	}
//
//	/**
//	 * 管理员回复反馈
//	 * @param feedbackId 该条反馈的编号
//	 * @param adminId 管理员的编号
//	 * @param answerContent 回复的内容
//	 * @return 回复结果
//	 */
//	@Override
//	public String updateOne(int feedbackId, int adminId,
//			String answerContent) {
//		Tester.markHere("AdminDAO.commentFeedback");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.FEEDBACK
//					+ " set isAnswered=?,adminId=?,answerTime=?,answerContent=? where feedbackId=?");
//			ps.setInt(1,Values.FEEDBACK_HANDLED);
//			ps.setInt(2, adminId);
//			ps.setString(3, Convertor.changeDateTimeToString(new Date()));
//			ps.setString(4, answerContent);
//			ps.setInt(5, feedbackId);
//			int rtn = ps.executeUpdate();
//			if (rtn > 0) {
//				Tester.markHere("rtn > 0");
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
//	/**
//	 * 增加一条反馈信息
//	 * @param userId 反馈用户的编号
//	 * @param feedbackTitle 反馈的标题
//	 * @param feedbackContent 反馈的内容
//	 * @param feedbackPicture 反馈的截图
//	 * @return 反馈提交的结果
//	 */
//	@Override
//	public String createOne(int userId, String feedbackTitle,
//			String feedbackContent, String feedbackPicture) {
//		Tester.markHere("OtherDAO.addFeedbackRecord");
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String result = "failure";
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.FEEDBACK + 
//					" (userId,createTime,feedbackTitle,feedbackContent,feedbackPicture)" + 
//					" values(?,?,?,?,?)");
//			ps.setInt(1, userId);
//			ps.setString(2, Convertor.changeDateTimeToString(new Date()));
//			ps.setString(3, feedbackTitle);
//			ps.setString(4, feedbackContent);
//			ps.setString(5, feedbackPicture);
//			int flag = ps.executeUpdate();
//			if(flag > 0){
//				Tester.markHere("result > 0");
//				result = "success";
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}		
//		return result;
//	}
//
//	/**
//	 * 获得某个用户的所有反馈历史
//	 * @param userId 该用户的编号
//	 * @return 该用户的所有反馈历史
//	 */
//	@Override
//	public ArrayList<UserSuggestion> readSomeByUserId(int userId) {
//		ArrayList<UserSuggestion> fbrList = new ArrayList<UserSuggestion>();
//		UserSuggestion fbr;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select feedbackId,createTime,feedbackTitle,feedbackContent,isAnswered" +
//					" from " + DatabaseTable.FEEDBACK + " where userId=?" + " ORDER BY feedbackId DESC");
//			ps.setInt(1, userId);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				fbr = new UserSuggestion();
//				fbr.setUserId(userId);
//				fbr.setFeedbackId(rs.getInt("feedbackId"));
//				fbr.setPostTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//				fbr.setTitle(rs.getString("feedbackTitle"));
//				fbr.setFeedbackContent(rs.getString("feedbackContent"));
//				fbr.setIsAnswered(rs.getInt("isAnswered"));
//				fbrList.add(fbr);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return fbrList;
//	}
//
//	/**
//	 * 根据反馈ID获得某条反馈的相关信息
//	 * @param getFeedbackId 该条反馈的编号
//	 * @return 该条反馈的相关信息
//	 */
//	@Override
//	public UserSuggestion readOneById(int getFeedbackId) {
//		UserSuggestion fbr = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select userId,createTime,feedbackTitle,feedbackContent,feedbackPicture,isAnswered," +
//					"adminId,answerTime,answerContent from " + DatabaseTable.FEEDBACK + " where feedbackId=?");
//			ps.setInt(1, getFeedbackId);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				fbr = new UserSuggestion();
//				fbr.setUserId(rs.getInt("userId"));
//				fbr.setPostTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//				fbr.setTitle(rs.getString("feedbackTitle"));
//				fbr.setFeedbackContent(rs.getString("feedbackContent"));
//				fbr.setFeedbackPicture(rs.getString("feedbackPicture"));
//				fbr.setIsAnswered(rs.getInt("isAnswered"));
//				if(fbr.getIsAnswered() == 1){
//					fbr.setAdminId(rs.getInt("adminId"));
//					fbr.setAnswerTime(Convertor.changeDateTimeToString(rs.getTimestamp("answerTime")));
//					fbr.setAnswerContent(rs.getString("answerContent"));
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return fbr;
//	}
//
//}
