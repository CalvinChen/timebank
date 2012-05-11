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
//import timebank.model.CookieAdmin;
//import timebank.model.CookieUser;
//import timebank.model.DatabaseTable;
//import timebank.model.Values;
//import timebank.model.article.Article;
//import timebank.model.user.User;
//import timebank.persistence.CookieAdminDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//
//@Repository
//public class CookieAdminDaoImpl implements CookieAdminDao {
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
//	public String createOne(CookieAdmin one) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.COOKIESADMIN + 
//					" (adminId,adminSessionId)" + " values(?,?)");
//			ps.setString(1, one.getAdminId());
//			ps.setString(2, one.getAdminSessionId());
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
//	private CookieAdmin readOneProcess() throws SQLException {
//		CookieAdmin one = new CookieAdmin();
//		one.setAdminId(rs.getString("adminId"));
//		one.setAdminSessionId(rs.getString("adminSessionId"));
//		return one;
//	}
//
//	
//	@Override
//	public CookieAdmin readOne(CookieAdmin one) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		CookieAdmin cook = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.COOKIESADMIN + " where adminId=? and adminSessionId=?");
//			ps.setString(1, one.getAdminId());
//			ps.setString(2, one.getAdminSessionId());
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
//	public String deleteOne(String adminId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.COOKIESADMIN + " where adminId=?");
//			ps.setString(1, adminId);
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
//	 * @param adminId
//	 * @return
//	 */
//	@Override
//	public int readIsHaveAdminId(String adminId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.COOKIESADMIN + " where adminId=?");
//			ps.setString(1, adminId);
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
