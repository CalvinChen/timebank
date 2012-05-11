///**
// * @Project TimeBank
// * @CreatedTime 2011-10-8 下午08:36:56 
// * @Author CK
// * @Todo TODO
// */
//package timebank.persistence.impl.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.Date;
//
//import org.springframework.stereotype.Repository;
//
//import timebank.model.DatabaseTable;
//import timebank.model.BankCompleteRecord;
//import timebank.model.StatusOfRecord;
//import timebank.model.Values;
//import timebank.persistence.HelpRecordDao;
//import timebank.util.Convertor;
//import timebank.util.DBConnection;
//import timebank.util.Tester;
//
///**
// * @author CK
// *
// */
//@Repository
//public class HelpRecordDaoImpl implements HelpRecordDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//	/**
//	 * 获得某个用户所有的互助记录
//	 * @param userId 该用户的用户编号
//	 * @return 该用户所有的互助记录表
//	 */
//	@Override
//	public ArrayList<BankCompleteRecord> readSomeByUserId(int userId) {
//		Tester.markHere("BankDAO.getOnesHelpRecords");
//		ArrayList<BankCompleteRecord> list = new ArrayList<BankCompleteRecord>();
//		BankCompleteRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + 
//					DatabaseTable.HELP_RECORD + " where toHelpUserId=? or helpedUserId=?" + " ORDER BY helpRecordId DESC");
//			ps.setInt(1, userId);
//			ps.setInt(2, userId);
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
//	 * 获得某条互助记录
//	 * @param helpRecordId 该条互助记录的编号
//	 * @return 该条互助记录
//	 */
//	@Override
//	public BankCompleteRecord readOne(int helpRecordId) {
//		Tester.markHere("BankDAO.getOneHelpRecord");
//		BankCompleteRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + 
//					DatabaseTable.HELP_RECORD + " where helpRecordId=?");
//			ps.setInt(1, helpRecordId);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				one = readOneProcess();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return one;
//	}
//	//--------------------------------------About Deposit------------------------------------
//	/**
//	 * @return
//	 * @throws SQLException
//	 */
//	private BankCompleteRecord readOneProcess() throws SQLException {
//		BankCompleteRecord one;
//		one = new BankCompleteRecord();
//		one.setBankCompleteRecordId(rs.getInt("helpRecordId"));
//		one.setToHelpUserId(rs.getInt("toHelpUserId"));
//		one.setHelpedUserId(rs.getInt("helpedUserId"));
//		one.setToHelpUsername(new UserDaoImpl().readUsernameByUserId(one.getToHelpUserId()));
//		one.setToHelpPicture(new UserDaoImpl().readPhotoById(one.getToHelpUserId()));
//		one.setHelpedUsername(new UserDaoImpl().readUsernameByUserId(one.getHelpedUserId()));
//		one.setHelpedPicture(new UserDaoImpl().readPhotoById(one.getHelpedUserId()));
//		one.setTheDate(Convertor.changeDateToString(rs.getTimestamp("theDate")));
//		one.setTheTime(rs.getInt("theTime"));
//		one.setZone(rs.getInt("zoneHelp"));
//		one.setRange(rs.getInt("rangeHelp"));
//		one.setDescriptionToHelp(rs.getString("descriptionToHelp"));
//		one.setDescriptionHelped(rs.getString("descriptionHelped"));
//		one.setStatusHelp(rs.getInt("statusHelp"));
//		one.setPictureHelp(rs.getString("pictureHelp"));
//		one.setUserToHelpScore(rs.getDouble("userToHelpScore"));
//		one.setUserToHelpFeedback(rs.getString("userToHelpFeedback"));
//		one.setUserToHelpFeedbackTime(Convertor.changeDateTimeToString(rs.getTimestamp("userToHelpFeedbackTime")));
//		one.setUserHelpedScore(rs.getDouble("userHelpedScore"));
//		one.setUserHelpedFeedback(rs.getString("userHelpedFeedback"));
//		one.setUserHelpedFeedbackTime(Convertor.changeDateTimeToString(rs.getTimestamp("userHelpedFeedbackTime")));
//		one.setRequireBy(rs.getInt("requireBy"));
//		one.setVerifier(rs.getString("verifier"));
//		one.setVerifiedTime(Convertor.changeDateTimeToString(rs.getTimestamp("verifiedTime")));
//		one.setWhyFailure(rs.getString("whyFailure"));
//		one.setFailureBy(rs.getInt("failureBy"));
//		one.setFailureTime(Convertor.changeDateTimeToString(rs.getTimestamp("failureTime")));
//		one.setWhyVerifyFailure(rs.getString("whyVerifyFailure"));
//		one.setLinkDepositId(rs.getInt("linkDepositId"));
//		one.setLinkWithdrawId(rs.getInt("linkWithdrawId"));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		one.setUpdateTime(Convertor.changeDateTimeToString(rs.getTimestamp("updateTime")));
//		return one;
//	}
//	
//	//--------------------------------------About Helprecord------------------------------------
//	/**
//	 * 增加一条互助记录
//	 * @param toHelpUserId 帮助者的用户编号
//	 * @param helpedUserId 求助者的用户编号
//	 * @param helpTime 互助的时间
//	 * @param zoneHelp 互助的区域
//	 * @param rangeHelp 互助的范围
//	 * @param descriptionToHelp 帮助者的详细说明
//	 * @param descriptionHelped 求助者的详细说明
//	 * @param requireBy 此条互助记录是由谁申请的
//	 * @param linkDepositId 此条互助记录是由哪条存储记录合成的
//	 * @param linkWithdrawId 此条互助记录是由哪条提取记录合成的
//	 * @return 增加的结果
//	 */
//	@Override
//	public int createOne(BankCompleteRecord one) {
//		Tester.markHere("BankDAO.addOneHelpRecord");
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int key = 0;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.HELP_RECORD + 
//					" (toHelpUserId,helpedUserId," +
//					"theDate,theTime,zoneHelp,rangeHelp," +
//					"descriptionToHelp,descriptionHelped," +
//					"statusHelp,createTime,requireBy," +
//					"linkDepositId,linkWithdrawId)" + 
//					" values(?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//			int i = 1;
//			ps.setInt(i++, one.getToHelpUserId());
//			ps.setInt(i++, one.getHelpedUserId());
//			if(one.getTheDate() == null || one.getTheDate().trim().equals("")){
//				ps.setNull(i++, Types.NULL);	
//			}else{
//				ps.setString(i++, one.getTheDate());
//			}
//			ps.setInt(i++, one.getTheTime());
//			ps.setInt(i++, one.getZone());
//			ps.setInt(i++, one.getRange());
//			ps.setString(i++, one.getDescriptionToHelp());
//			ps.setString(i++, one.getDescriptionHelped());
//			ps.setInt(i++, StatusOfRecord.VERIFYING);
//			ps.setString(i++, Convertor.changeDateTimeToString(new Date()));
//			ps.setInt(i++, one.getRequireBy());
//			ps.setInt(i++, one.getLinkDepositId());
//			ps.setInt(i++, one.getLinkWithdrawId());
//			int result = ps.executeUpdate();
//			if(result > 0){
//				Tester.markHere("result > 0");
//				rs = ps.getGeneratedKeys();
//				if(rs.next()){
//					key = rs.getInt(1);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}		
//		return key;
//	}
//	/**
//	 * 获得所有由参数status指定状态的互助记录
//	 * @param status 互助记录的状态
//	 * @return 所有符合要求的互助记录
//	 */
//	@Override
//	public ArrayList<BankCompleteRecord> readSomeByStatus(int status, int page) {
//		Tester.markHere("AdminDAO.getUnhandleRecordList");
//		BankCompleteRecord one = null;
//		PreparedStatement ps1 = null;
//		ArrayList<BankCompleteRecord> recordList = new ArrayList<BankCompleteRecord>();
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.HELP_RECORD + " where statusHelp=?" + " ORDER BY helpRecordId DESC limit ?,?");
//			ps.setInt(1, status);
//			ps.setInt(2, (page - 1) * Values.PAGE_SIZE);
//			ps.setInt(3, Values.PAGE_SIZE);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				one = readOneProcess();
//				recordList.add(one);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBConnection.free(rs, ps, conn);
//		}
//		return recordList;
//	}
//	/**
//	 * 根据互助记录编号获得该互助记录
//	 * @param helpRecordId 该条互助记录的编号
//	 * @return 该条互助记录的所有信息
//	 */
//	@Override
//	public BankCompleteRecord readOneById(int helpRecordId) {
//		Tester.markHere("AdminDAO.getHelpRecordById");
//		BankCompleteRecord one = null;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.HELP_RECORD + " where helpRecordId=?");
//			ps.setInt(1, helpRecordId);
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
//	 * 设置互助记录的状态
//	 * @param helpRecordId 该条互助记录的编号
//	 * @param status 该条互助记录的新的状态
//	 * @return
//	 */
//	@Override
//	public String updateStatusById(int helpRecordId, int status) {
//		Tester.markHere("AdminDAO.setHelpRecordStatus");
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.HELP_RECORD
//					+ " set statusHelp=? where helpRecordId=?");
//			ps.setInt(1, status);
//			ps.setInt(2, helpRecordId);
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
//	 * 获得由参数status指定状态的互助记录的总数
//	 * @param status 互助记录的状态
//	 * @return 所有符合要求的互助记录的总数
//	 */
//	@Override
//	public int readCountByStatus(int status) {
//		Tester.markHere("AdminDAO.readHelpRecordsCountByStatus");
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.HELP_RECORD + " where statusHelp=?");
//			ps.setInt(1, status);
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
//	/**
//	 * @param helpRecordId
//	 * @param userScore
//	 * @param userFeedback
//	 * @return
//	 */
//	@Override
//	public String updateToHelpPartById(int helpRecordId, double userScore,
//			String userFeedback) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.HELP_RECORD
//					+ " set userToHelpScore=?,userToHelpFeedback=?,userToHelpFeedbackTime=? where helpRecordId=?");
//			ps.setDouble(1, userScore);
//			ps.setString(2, userFeedback);
//			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
//			ps.setInt(4, helpRecordId);
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
//	 * @param helpRecordId
//	 * @param userScore
//	 * @param userFeedback
//	 * @return
//	 */
//	@Override
//	public String updateHelpedPartById(int helpRecordId, double userScore,
//			String userFeedback) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.HELP_RECORD
//					+ " set userHelpedScore=?,userHelpedFeedback=?,userHelpedFeedbackTime=? where helpRecordId=?");
//			ps.setDouble(1, userScore);
//			ps.setString(2, userFeedback);
//			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
//			ps.setInt(4, helpRecordId);
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
//	 * @param helpRecordId
//	 * @param whyFailure
//	 * @param failureBy
//	 * @return
//	 */
//	@Override
//	public String updateWhyFailureById(int helpRecordId, String whyFailure,
//			int failureBy) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.HELP_RECORD
//					+ " set whyFailure=?,failureBy=?,failureTime=? where helpRecordId=?");
//			ps.setString(1, whyFailure);
//			ps.setInt(2, failureBy);
//			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
//			ps.setInt(4, helpRecordId);
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
//	 * 更新互助记录的验证失败部分
//	 * @param helpRecordId
//	 * @param whyVerifyFailure
//	 * @return
//	 */
//	@Override
//	public String updateVerifyPartById(int helpRecordId, String verifier,String whyVerifyFailure) {
//		String result = Values.FAILURE;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("update " + DatabaseTable.HELP_RECORD
//					+ " set whyVerifyFailure=?,verifier=?,verifiedTime=? where helpRecordId=?");
//			int i = 1;
//			ps.setString(i++, whyVerifyFailure);
//			ps.setString(i++, verifier);
//			ps.setTimestamp(i++, new Timestamp(new Date().getTime()));
//			ps.setInt(i++, helpRecordId);
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
//	 * 获得今天新的记录
//	 * @return 今天记录数
//	 */
//	@Override
//	public int readTodayNewCount() {
//		int count = 0;
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.HELP_RECORD + 
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
//}
