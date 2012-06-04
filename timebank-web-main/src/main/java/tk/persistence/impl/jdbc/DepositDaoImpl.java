package tk.persistence.impl.jdbc;
///**
// * @Project TimeBank
// * @CreatedTime 2011-10-8 下午08:30:24 
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
//import timebank.model.DatabaseTable;
//import timebank.model.StatusOfRecord;
//import timebank.model.Values;
//import timebank.model.bank.BankCoreBusiness;
//import timebank.persistence.DepositDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//
///**
// * @author CK
// *
// */
//@Repository
//public class DepositDaoImpl implements DepositDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//
//	/**
//	 * 根据存储编号取得一条存储记录
//	 * @param depositId 存储编号
//	 * @return 欲取得的存储记录
//	 */
//	@Override
//	public BankCoreBusiness readOneById(int depositId) {
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + " where depositId=?");
//			ps.setInt(1, depositId);
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
//
//	/**
//	 * @return
//	 * @throws SQLException
//	 */
//	private BankCoreBusiness readOneProcess() throws SQLException {
//		BankCoreBusiness one;
//		one = new BankCoreBusiness();
//		one.setBankCoreBusinessId(rs.getInt("depositId"));
//		one.setUserId(rs.getInt("userId"));
//		one.setUsername(new UserDaoImpl().readUsernameByUserId(one.getUserId()));
//		one.setPicture(new UserDaoImpl().readPhotoById(one.getUserId()));
//		one.setTheDate(Convertor.changeDateToString(rs.getTimestamp("theDate")));
//		one.setTheTime(rs.getInt("theTime"));
//		one.setZoneDeposit(rs.getInt("zoneDeposit"));
//		one.setRangeDeposit(rs.getInt("rangeDeposit"));
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
//
//	/**
//	 * 将一条存储记录的状态改变为指定的状态
//	 * @param depositId 该条存储记录的编号 
//	 * @param status 要将之改变成的状态
//	 * @return 更新的结果
//	 */
//	@Override
//	public String updateStatusById(int depositId, int status) {
//		Tester.markHere("BankDAO.setOneDepositStatus");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set status=?"
//					+ " where depositId=?");
//			ps.setInt(1, status);
//			ps.setInt(2, depositId);
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
//
//	/**
//	 * 更新匹配剩余次数
//	 * @param depositId
//	 * @param seekLeft
//	 * @return
//	 */
//	@Override
//	public String updateSeekLeftById(int depositId, int seekLeft) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set seekLeft=?"
//					+ " where depositId=?");
//			ps.setInt(1, seekLeft);
//			ps.setInt(2, depositId);
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
//	 * 更新匹配总次数
//	 * @param depositId
//	 * @param seekNumber
//	 * @return
//	 */
//	@Override
//	public String updateSeekNumberById(int depositId, int seekNumber) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set seekNumber=?"
//					+ " where depositId=?");
//			ps.setInt(1, seekNumber);
//			ps.setInt(2, depositId);
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
//	 * 将一条存储记录的链接互助记录改变为指定的记录
//	 * @param depositId 该条存储记录的编号 
//	 * @param key 要将之改变成的记录
//	 * @return 更新的结果
//	 */
//	@Override
//	public String updateLinkedById(int depositId, int key) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set linkHelpRecordId=?"
//					+ " where depositId=?");
//			ps.setInt(1, key);
//			ps.setInt(2, depositId);
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
//	 * 将一条存储记录的状态改变为指定的状态
//	 * @param depositId 该条存储记录的编号 
//	 * @param status 要将之改变成的状态
//	 * @return 更新的结果
//	 */
//	@Override
//	public String updateOneById(BankCoreBusiness one) {
//		Tester.markHere("BankDAO.setOneDepositStatus");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set theDate=?,theTime=?,zoneDeposit=?,rangeDeposit=?,description=?,"
//					+ "seekNumber=?,seekLeft=?,mode=?,expireDate=?,toTop=?,detailed=?"
//					+ " where depositId=?");
//			int i = 1;
//			if(one.getTheDate() == null || one.getTheDate().trim().equals("")){
//				ps.setNull(i++, Types.NULL);	
//			}else{
//				ps.setString(i++, one.getTheDate());
//			}
//			ps.setInt(i++, one.getTheTime());
//			ps.setInt(i++, one.getZoneDeposit());
//			ps.setInt(i++, one.getRangeDeposit());
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
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return result;
//	}
//
//	/**
//	 * 获得某个用户所有的存储记录
//	 * @param userId 该用户的用户编号
//	 * @return 该用户所有的存储记录表
//	 */
//	@Override
//	public ArrayList<BankCoreBusiness> readSomeByUserId(int userId) {
//		ArrayList<BankCoreBusiness> list = new ArrayList<BankCoreBusiness>();
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + " where userId=?" + " ORDER BY depositId DESC");
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
//
//	/**
//	 * 获得所有该类型的的存储记录
//	 * @param status 该类型
//	 * @param p 
//	 * @return 数据库中所有该类型的存储记录
//	 */
//	@Override
//	public ArrayList<BankCoreBusiness> readSomeByStatus(int status) {
//		ArrayList<BankCoreBusiness> list = new ArrayList<BankCoreBusiness>();
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + 
//					" where status=?" + " ORDER BY depositId DESC");
//			int i = 1;
//			ps.setInt(i++, status);
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
//	/**
//	 * 获得所有该类型的的存储记录，限制页数
//	 * @param status 该类型
//	 * @return 数据库中所有该类型的存储记录
//	 */
//	@Override
//	public ArrayList<BankCoreBusiness> readSomeByStatusLimit(int status, int page) {
//		ArrayList<BankCoreBusiness> list = new ArrayList<BankCoreBusiness>();
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + " where status=?" + " ORDER BY depositId DESC limit ?,? ");
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
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.DEPOSIT + 
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
//	//--------------------------------------About Deposit------------------------------------
//	
//	/**
//	 * 增加一名用户的预存储时间
//	 * @param one 预存储时间的详细信息
//	 * @param userId 用户的编号
//	 * @return 结果
//	 */
//	@Override
//	public String createOne(BankCoreBusiness one) {
//		Tester.markHere("BankDAO.addOneDeposit");
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String result = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.DEPOSIT + 
//					" (userId,theDate,theTime,zoneDeposit,rangeDeposit,description,status,createTime," +
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
//			ps.setInt(i++, one.getZoneDeposit());
//			ps.setInt(i++, one.getRangeDeposit());
//			ps.setString(i++, one.getDescription());
//			ps.setInt(i++, StatusOfRecord.UNMATCHED);
//			ps.setString(i++, Convertor.changeDateTimeToString(new Date()));
//			ps.setInt(i++, one.getMode());
//			ps.setInt(i++, one.getSeekNumber());
//			ps.setInt(i++, one.getSeekNumber());//一开始总匹配次数与剩余匹配次数一致
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
//	
//
//	/**
//	 * 根据ID删除存储记录
//	 * @param did 存储记录的ID
//	 * @return
//	 */
//	@Override
//	public String deleteOne(int did) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.DEPOSIT + " where depositId=?");
//			ps.setInt(1, did);
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
//	 * @param verifying
//	 * @return
//	 */
//	@Override
//	public int readCountDepositsByStatus(int status) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.DEPOSIT + " where status=?");
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
//	/**
//	 * 
//	 */
//	@Override
//	public int updateExpired() {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
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
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
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
//
//	/**
//	 * @param did
//	 * @param modeSeek
//	 * @param i
//	 * @param validNumber
//	 * @return
//	 */
//	@Override
//	public String updateModesById(int depositId, int mode, int seekLeft, int seekNumber) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.DEPOSIT
//					+ " set mode=?,seekLeft=?,seekNumber=?"
//					+ " where depositId=?");
//			int i = 1;
//			ps.setInt(i++, mode);
//			ps.setInt(i++, seekLeft);
//			ps.setInt(i++, seekNumber);
//			ps.setInt(i++, depositId);
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
//	 * @param status
//	 * @return
//	 */
//	@Override
//	public ArrayList<BankCoreBusiness> getDisplayDepositsByStatus(int status, int isToTop, int isDetailed) {
//		ArrayList<BankCoreBusiness> list = new ArrayList<BankCoreBusiness>();
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + 
//					" where status=? and toTop=? and detailed=?" + " ORDER BY depositId DESC");
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
//
//	/**
//	 * @param status
//	 * @param no
//	 * @param no2
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public ArrayList<BankCoreBusiness> getDisplayDepositsByStatusLimit(int status,
//			int isToTop, int isDetailed, int p) {
//		ArrayList<BankCoreBusiness> list = new ArrayList<BankCoreBusiness>();
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.DEPOSIT + 
//					" where status=? and toTop=? and detailed=?" + " ORDER BY depositId DESC limit ?,?");
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
//
//	/**
//	 * @param status
//	 * @param no
//	 * @param no2
//	 * @return
//	 */
//	@Override
//	public int getCountDisplayDepositsByStatus(int status, int isToTop, int isDetailed) {
//		int count = 0;
//		BankCoreBusiness one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.DEPOSIT + 
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
