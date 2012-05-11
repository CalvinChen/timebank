//package timebank.persistence.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.springframework.stereotype.Repository;
//
//
//import timebank.model.CookieUser;
//import timebank.model.DatabaseTable;
//import timebank.model.Values;
//import timebank.model.article.Article;
//import timebank.model.user.User;
//import timebank.persistence.CookieDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//
//@Repository
//public class CookieDaoImpl implements CookieDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//
//	
//	/**
//	 * 向数据库中新增一则cookies记录
//	 * @param one
//	 * @return
//	 */
//	@Override
//	public String createOne(CookieUser one) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.COOKIES + 
//					" (userId,sessionId)" + " values(?,?)");
//			ps.setString(1, one.getUserId());
//			ps.setString(2, one.getSessionId());
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
//		return flag;
//	}
//
//	/**
//	 * @return
//	 * @throws SQLException
//	 */
//	private CookieUser readOneProcess() throws SQLException {
//		CookieUser one = new CookieUser();
//		one.setUserId(rs.getString("userId"));
//		one.setSessionId(rs.getString("sessionId"));
//		return one;
//	}
//
//	
//	@Override
//	public CookieUser readOne(CookieUser one) {
//		Tester.markHere("ArticleDAO.getArticleById");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		CookieUser cook = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.COOKIES + " where userId=? and sessionId=?");
//			ps.setString(1, one.getUserId());
//			ps.setString(2, one.getSessionId());
//			rs = ps.executeQuery();
//			if(rs.next()){
//				cook = readOneProcess();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return cook;
//	}
//
//	@Override
//	public String deleteOne(String userId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.COOKIES + " where userId=?");
//			ps.setString(1, userId);
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
//	 * @param userId
//	 * @return
//	 */
//	@Override
//	public int readIsHaveUserId(String userId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.COOKIES + " where userId=?");
//			ps.setString(1, userId);
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
//	
//}
