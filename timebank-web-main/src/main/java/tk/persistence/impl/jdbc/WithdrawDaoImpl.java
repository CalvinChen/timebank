package tk.persistence.impl.jdbc;
///**
// * @Project TimeBank
// * @CreatedTime 2011-10-8 下午08:34:41 
// * @Author CK
// * @Todo TODO
// */
//package timebank.persistence.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.springframework.stereotype.Repository;
//
//import timebank.model.WithdrawRecord;
//import timebank.model.bank.BankCoreBusiness;
//import timebank.persistence.WithdrawDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//import timebank.util.bean.DatabaseTable;
//import timebank.util.bean.StatusOfRecord;
//import timebank.util.bean.Values;
//
///**
// * @author CK
// *
// */
//@Repository
//public class WithdrawDaoImpl implements WithdrawDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//	/**
//	 * 将一条提取记录的状态改变为指定的状态
//	 * @param withdrawId 该条提取记录的编号 
//	 * @param status 要将之改变成的状态
//	 * @return 更新的结果
//	 */
//	@Override
//	public String updateStatusById(int withdrawId, int status) {
//		Tester.markHere("BankDAO.setOneWithdrawStatus");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set status=?"
//					+ " where withdrawId=?");
//			ps.setInt(1, status);
//			ps.setInt(2, withdrawId);
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
//	@Override
//	public String updateSeekLeftById(int withdrawId, int seekLeft) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set seekLeft=?"
//					+ " where withdrawId=?");
//			ps.setInt(1, seekLeft);
//			ps.setInt(2, withdrawId);
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
//	@Override
//	public String updateSeekNumberById(int withdrawId, int seekNumber) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set seekNumber=?"
//					+ " where withdrawId=?");
//			ps.setInt(1, seekNumber);
//			ps.setInt(2, withdrawId);
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
//	@Override
//	public String updateModesById(int withdrawId, int mode, int seekLeft, int seekNumber) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set mode=?,seekLeft=?,seekNumber=?"
//					+ " where withdrawId=?");
//			int i = 1;
//			ps.setInt(i++, mode);
//			ps.setInt(i++, seekLeft);
//			ps.setInt(i++, seekNumber);
//			ps.setInt(i++, withdrawId);
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
//	/**
//	 * 将一条提取记录的状态改变为指定的状态
//	 * @param withdrawId 该条提取记录的编号 
//	 * @param status 要将之改变成的状态
//	 * @return 更新的结果
//	 */
//	@Override
//	public String updateOneById(WithdrawRecord one) {
//		Tester.markHere("BankDAO.updateOneById");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set theDate=?,theTime=?,zoneWithdraw=?,rangeWithdraw=?,description=?,"
//					+ "seekNumber=?,seekLeft=?,mode=?,expireDate=?,toTop=?,detailed=?"
//					+ " where withdrawId=?");
//			int i = 1;
//			if(one.getTheDate() == null || one.getTheDate().trim().equals("")){
//				ps.setNull(i++, Types.NULL);	
//			}else{
//				ps.setString(i++, one.getTheDate());
//			}
//			ps.setInt(i++, one.getTheTime());
//			ps.setInt(i++, one.getZoneWithdraw());
//			ps.setInt(i++, one.getRangeWithdraw());
//			ps.setString(i++, one.getDescription());
//			ps.setInt(i++, one.getSeekNumber());
//			ps.setInt(i++, one.getSeekLeft());
//			ps.setInt(i++, one.getMode());
//			if(one.getExpireDate() == null || one.getExpireDate().trim().length() == 0){
//				ps.setNull(i++, Types.NULL);
//			}else{
//				ps.setString(i++, one.getExpireDate());	
//			}
//			ps.setInt(i++, one.getToTop());
//			ps.setInt(i++, one.getDetailed());
//			
//			ps.setInt(i++, one.getBankCoreBusinessId());
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
//	/**
//	 * 根据提取编号取出一条提取记录
//	 * @param withdrawId 提取编号
//	 * @return 提取记录
//	 */
//	@Override
//	public WithdrawRecord readOneById(int withdrawId) {
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + " where withdrawId=?");
//			ps.setInt(1, withdrawId);
//			rs = ps.executeQuery();
//			if(rs.next()) {
//				one = readOneProcess();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return one;
//	}
//	/**
//	 * 获得某个用户所有的存储记录
//	 * @param userId 该用户的用户编号
//	 * @return 该用户所有的存储记录表
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> readSomeByUserId(int userId) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + " where userId=?" + " ORDER BY withdrawId DESC");
//			ps.setInt(1, userId);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	/**
//	 * @return
//	 * @throws SQLException
//	 */
//	private WithdrawRecord readOneProcess() throws SQLException {
//		WithdrawRecord one;
//		one = new WithdrawRecord();
//		one.setBankCoreBusinessId(rs.getInt("withdrawId"));
//		one.setUserId(rs.getInt("userId"));
//		one.setUsername(new UserDaoImpl().readUsernameByUserId(one.getUserId()));
//		one.setPicture(new UserDaoImpl().readPhotoById(one.getUserId()));
//		one.setTheDate(Convertor.changeDateToString(rs.getTimestamp("theDate")));
//		one.setTheTime(rs.getInt("theTime"));
//		one.setZoneWithdraw(rs.getInt("zoneWithdraw"));
//		one.setRangeWithdraw(rs.getInt("rangeWithdraw"));
//		one.setDescription(rs.getString("description"));
//		one.setStatus(rs.getInt("status"));
//		one.setMode(rs.getInt("mode"));
//		one.setSeekNumber(rs.getInt("seekNumber"));
//		one.setSeekLeft(rs.getInt("seekLeft"));
//		one.setExpireDate(Convertor.changeDateToString(rs.getTimestamp("expireDate")));
//		one.setLinkHelpRecordId(rs.getInt("linkHelpRecordId"));
//		one.setToTop(rs.getInt("toTop"));
//		one.setDetailed(rs.getInt("detailed"));
//		one.setUpdateTime(Convertor.changeDateTimeToString(rs.getTimestamp("updateTime")));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		return one;
//	}
//	/**
//	 * 获得所有未配对的提取记录
//	 * @param p 
//	 * @return 数据库中所有未配对的提取记录
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> readSomeByIsMatched(int isMatched, int p) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + 
//					" where status=?" + " ORDER BY withdrawId DESC limit ?,?");
//			int i = 1;
//			ps.setInt(i++, isMatched);
//			ps.setInt(i++, (p - 1)*Values.PAGE_SIZE);
//			ps.setInt(i++, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	/**
//	 * 增加一条用户的预提取记录
//	 * @param one 预提取记录的详细内容
//	 * @param userId 用户的编号
//	 * @return 增加的结果
//	 */
//	@Override
//	public String createOne(WithdrawRecord one) {
//		Tester.markHere("BankDAO.addOneWithdraw");		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String result = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.WITHDRAW + 
//					" (userId,theDate,theTime,zoneWithdraw,rangeWithdraw,description,status,createTime," +
//					" mode,seekNumber,seekLeft,expireDate," +
//					" toTop,detailed)" + 
//					" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
//			int i = 1;
//			ps.setInt(i++, one.getUserId());
//			if(one.getTheDate() == null || one.getTheDate().trim().equals("")){
//				ps.setNull(i++, Types.NULL);	
//			}else{
//				ps.setString(i++, one.getTheDate());
//			}
//			ps.setInt(i++, one.getTheTime());
//			ps.setInt(i++, one.getZoneWithdraw());
//			ps.setInt(i++, one.getRangeWithdraw());
//			ps.setString(i++, one.getDescription());
//			ps.setInt(i++, StatusOfRecord.UNMATCHED);
//			ps.setString(i++, Convertor.changeDateTimeToString(new Date()));
//			ps.setInt(i++, one.getMode());
//			ps.setInt(i++, one.getSeekNumber());
//			ps.setInt(i++, one.getSeekNumber());
//			ps.setString(i++, one.getExpireDate());
//			ps.setInt(i++, one.getToTop());
//			ps.setInt(i++, one.getDetailed());
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
//	/**
//	 * @param status
//	 * @return
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> readSomeByStatus(int status) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + " where status=?" + " ORDER BY withdrawId DESC");
//			ps.setInt(1, status);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	/**
//	 * @param status
//	 * @return
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> readSomeByStatusLimit(int status, int page) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + 
//					" where status=?" + " ORDER BY withdrawId DESC limit ?,?");
//			ps.setInt(1, status);
//			ps.setInt(2, (page - 1) * Values.PAGE_SIZE);
//			ps.setInt(3, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//
//	/**
//	 * 根据ID删除一条提取记录
//	 * @param wid 提取记录的ID
//	 * @return
//	 */
//	@Override
//	public String deleteOne(int wid) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String result = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.WITHDRAW + " where withdrawId=?");
//			ps.setInt(1, wid);
//			int i = ps.executeUpdate();
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
//	/**
//	 * 获得今天新的记录
//	 * @return 今天记录数
//	 */
//	@Override
//	public int readTodayNewCount() {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.WITHDRAW + 
//					" where timestampdiff(day ,createTime,now())=0");
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
//
//	@Override
//	public String updateLinkedById(int withdrawId, int key) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set linkHelpRecordId=?"
//					+ " where withdrawId=?");
//			ps.setInt(1, key);
//			ps.setInt(2, withdrawId);
//			int rtn = ps.executeUpdate();
//			if (rtn > 0) {
//				Tester.markHere("rtn > 0");
//				result = Values.SUCCESS;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return result;
//	}
//	/**
//	 * @param verified
//	 * @return
//	 */
//	@Override
//	public int readCountSomeByStatus(int status) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.WITHDRAW + " where status=?");
//			ps.setInt(1, status);
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
//	@Override
//	public int updateExpired() {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set status=?"
//					+ " where status=? and (mode=? or mode=?) and timestampdiff(day ,expireDate,now())>0");
//			int i = 1;
//			ps.setInt(i++, StatusOfRecord.EXPIRED);
//			ps.setInt(i++, StatusOfRecord.UNMATCHED);
//			ps.setInt(i++, Values.MODE_EXPIRE);
//			ps.setInt(i++, Values.MODE_BOTH);
//			count = ps.executeUpdate();			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return count;
//	}
//	
//	@Override
//	public int updateNotExpired() {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.WITHDRAW
//					+ " set status=?,seekNumber=(seekNumber-seekLeft)+(mode-2),seekLeft=mode-2"
//					+ " where not(status=?) and (mode=? or mode=?) and timestampdiff(day ,expireDate,now())<0");
//			int i = 1;
//			ps.setInt(i++, StatusOfRecord.UNMATCHED);
//			ps.setInt(i++, StatusOfRecord.UNMATCHED);
//			ps.setInt(i++, Values.MODE_EXPIRE);
//			ps.setInt(i++, Values.MODE_BOTH);
//			count = ps.executeUpdate();			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return count;
//	}
//	/**
//	 * @param status
//	 * @param yes
//	 * @param yes2
//	 * @return
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> getDisplayWithdrawsByStatus(int status,
//			int isToTop, int isDetailed) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + 
//					" where status=? and toTop=? and detailed=?" + " ORDER BY withdrawId DESC");
//			int i = 1;
//			ps.setInt(i++, status);
//			ps.setInt(i++, isToTop);
//			ps.setInt(i++, isDetailed);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	/**
//	 * @param status
//	 * @param no
//	 * @param no2
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public ArrayList<WithdrawRecord> getDisplayWithdrawsByStatusLimit(int status,
//			int isToTop, int isDetailed, int p) {
//		ArrayList<WithdrawRecord> list = new ArrayList<WithdrawRecord>();
//		WithdrawRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.WITHDRAW + 
//					" where status=? and toTop=? and detailed=?" + " ORDER BY withdrawId DESC limit ?,?");
//			int i = 1;
//			ps.setInt(i++, status);
//			ps.setInt(i++, isToTop);
//			ps.setInt(i++, isDetailed);
//			ps.setInt(i++, (p - 1) * Values.PAGE_SIZE);
//			ps.setInt(i++, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()) {
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
//	/**
//	 * @param status
//	 * @param no
//	 * @param yes
//	 * @return
//	 */
//	@Override
//	public int getCountDisplayWithdrawsByStatus(int status, int isToTop, int isDetailed) {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.WITHDRAW + 
//					" where status=? and toTop=? and detailed=?");
//			int i = 1;
//			ps.setInt(i++, status);
//			ps.setInt(i++, isToTop);
//			ps.setInt(i++, isDetailed);
//			rs = ps.executeQuery();
//			if(rs.next()) {
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
