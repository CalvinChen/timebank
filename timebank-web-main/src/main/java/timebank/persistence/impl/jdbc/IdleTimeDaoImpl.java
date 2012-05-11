///**
// * @Project TimeBank
// * @CreatedTime 2011-10-22 上午10:05:28 
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
//
//import org.springframework.stereotype.Repository;
//
//import timebank.model.article.Article;
//import timebank.model.reserve.ReserveIdleTime;
//import timebank.model.reserve.ReserveSkill;
//import timebank.model.user.User;
//import timebank.persistence.IdleTimeDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//import timebank.util.bean.DatabaseTable;
//import timebank.util.bean.Values;
//
///**
// * @author CK
// *
// */
//@Repository
//public class IdleTimeDaoImpl implements IdleTimeDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//
//	/**
//	 * 向数据库中新增一项空闲时间
//	 * @param one
//	 * @return
//	 */
//	@Override
//	public String createOne(ReserveIdleTime one) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.IDLETIME + 
//					" (userId,createTime,idleDay,idleHour)" + 
//					" values(?,?,?,?)");
//			int i = 1;
//			ps.setInt(i++, one.getUserId());
//			ps.setString(i++, one.getCreateTime());
//			ps.setString(i++, one.getIdleDay());
//			ps.setString(i++, one.getIdleHour());
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
//
//	/**
//	 * 获得数据库中指定用户指定天的所有空闲信息
//	 * @param userId 
//	 * @return
//	 */
//	@Override
//	public ArrayList<ReserveIdleTime> readSomeByUserIdAndDay(int userId, String idleDay) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ReserveIdleTime one = new ReserveIdleTime();
//		one.setIdleDay(idleDay);
//		ArrayList<ReserveIdleTime> list = new ArrayList<ReserveIdleTime>();
//		list.add(one);
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.IDLETIME + " where userId=? and idleDay=? order by idleHour ");
//			ps.setInt(1, userId);
//			ps.setString(2, idleDay);
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
//	 * 获得数据库中指定用户的所有空闲信息的总数
//	 * @param userId 
//	 * @return
//	 */
//	@Override
//	public int readCountByUserId(int userId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.IDLETIME + " where userId=?");
//			ps.setInt(1, userId);
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
//	/**
//	 * @return
//	 * @throws SQLException 
//	 */
//	private ReserveIdleTime readOneProcess() throws SQLException {
//		ReserveIdleTime one = new ReserveIdleTime();
//		one.setIdleTimeId(rs.getInt("idleTimeId"));
//		one.setUserId(rs.getInt("userId"));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		one.setIdleDay(rs.getString("idleDay"));
//		one.setIdleHour(rs.getString("idleHour"));
//		return one;
//	}
//
//	@Override
//	public ReserveIdleTime readOneById(int idleTimeId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ReserveIdleTime one = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.IDLETIME + " where idleTimeId=?");
//			ps.setInt(1, idleTimeId);
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
//	 * 根据信息查看用户有没有这条空闲时间
//	 * @param userId 用户编号
//	 * @param day 空闲天
//	 * @param hour 空闲时
//	 * @return
//	 */
//	@Override
//	public boolean readOneIsHave(int userId, String day, String hour) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		boolean result = false;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.IDLETIME + 
//					" where userId=? and idleDay=? and idleHour=?");
//			ps.setInt(1, userId);
//			ps.setString(2, day);
//			ps.setString(3, hour);
//			rs = ps.executeQuery();
//			if(rs.next()){
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return result;
//	}
//	
//	@Override
//	public String deleteOne(int idleTimeId) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.IDLETIME + " where idleTimeId=?");
//			ps.setInt(1, idleTimeId);
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
//
//	/**
//	 * 根据关键字找出用户时间储备里面含有的记录
//	 * @param someInfo
//	 * @param p 页码
//	 * @return
//	 */
//	@Override
//	public ArrayList<Integer> readUserIdBySomeTimeLimit(String idleDay, String idleHour, int p) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select distinct(userId) from " + DatabaseTable.IDLETIME + 
//					" where idleDay=? and idleHour=? limit ?,?");
//			int i = 1;
//			ps.setString(i++, idleDay);
//			ps.setString(i++, idleHour);
//			ps.setInt(i++, (p - 1) * Values.PAGE_SIZE);
//			ps.setInt(i++, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = rs.getInt(1);
//				list.add(one);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return list;
//	}
//	/**
//	 * 根据关键字找出用户时间储备里面含有的记录
//	 * @param someInfo
//	 * @param p 页码
//	 * @return
//	 */
//	@Override
//	public ArrayList<Integer> readUserIdBySomeTime(String idleDay, String idleHour) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select distinct(userId) from " + DatabaseTable.IDLETIME + 
//					" where idleDay=? and idleHour=?");
//			int i = 1;
//			ps.setString(i++, idleDay);
//			ps.setString(i++, idleHour);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = rs.getInt(1);
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
//	@Override
//	public ArrayList<Integer> readUserIdsByIdleDayAndSoOn(String idleDay, String andSoNo, int p){
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select userId from " + DatabaseTable.IDLETIME + 
//					" where idleDay=? and " + andSoNo + " limit ?,?");
//			int i = 1;
//			ps.setString(i++, idleDay);
//			ps.setInt(i++, (p - 1) * Values.PAGE_SIZE);
//			ps.setInt(i++, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = rs.getInt(1);
//				list.add(one);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return list;
//	}
//	@Override
//	public ArrayList<Integer> readUserIdsForUnion(String idleDay, String andSoNo){
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select userId from " + DatabaseTable.IDLETIME + 
//					" where idleDay=? and " + andSoNo);
//			int i = 1;
//			ps.setString(i++, idleDay);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = rs.getInt(1);
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
//	 * 根据关键字找出用户时间储备里面含有的记录
//	 * @param someInfo
//	 * @param p 页码
//	 * @return
//	 */
//	@Override
//	public ArrayList<Integer> readUserIdByHaveTimes(int p) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select distinct(userId) from " + DatabaseTable.IDLETIME + 
//					" limit ?,?");
//			ps.setInt(1, (p - 1) * Values.PAGE_SIZE);
//			ps.setInt(2, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				one = rs.getInt(1);
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
//	
//	/**
//	 * 根据关键字找出用户时间储备里面含有的记录的总数
//	 * @param someInfo
//	 * @param string 
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public int readCountUserIdBySomeTime(String idleDay, String idleHour) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.IDLETIME + 
//					" where idleDay=? and idleHour=?");
//			int i = 1;
//			ps.setString(i++, idleDay);
//			ps.setString(i++, idleHour);
//			rs = ps.executeQuery();
//			while(rs.next()){
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
//	 * 读出所有有填写空闲时间的用户的总数
//	 * @param someInfo
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public int readCountUserIdByHaveTimes() {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(distinct(userId)) from " + DatabaseTable.IDLETIME);
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
//	 * 读出所有时间储备的总数
//	 * @return
//	 */
//	@Override
//	public int readCountTimes() {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.IDLETIME);
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
//	/**
//	 * @param idleDay
//	 * @param string
//	 * @return
//	 */
//	@Override
//	public int readCountUserIdsByIdleDayAndSoOn(String idleDay, String sql) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement(sql);
//			int i = 1;
//			ps.setString(i++, idleDay);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				count = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return count;
//	}
//}
