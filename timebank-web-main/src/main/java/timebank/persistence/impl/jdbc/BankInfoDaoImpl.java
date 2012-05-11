package timebank.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Repository;


import timebank.model.BankInfoRecord;
import timebank.model.bank.BankCoreBusiness;
import timebank.persistence.BankInfoDao;
import timebank.util.Convertor;
import timebank.util.DBConnection;
import timebank.util.Tester;
import timebank.util.bean.DatabaseTable;
import timebank.util.bean.Values;

@Repository
public class BankInfoDaoImpl implements BankInfoDao {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * 增加一条用户银行信息
	 * @param userId 新注册的用户
	 * @return 增加的结果
	 */
	@Override
	public String createOne(int userId) {
		Tester.markHere("BankDAO.addBankInfo");
		
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("insert into " + DatabaseTable.BANK_INFO + 
					" (userId,balance,createTime)" +
					" values(?,?,?)");
			ps.setInt(1, userId);
			ps.setDouble(2, Values.INIT_BALANCE);
			ps.setString(3, Convertor.changeDateTimeToString(new Date()));
			int result = ps.executeUpdate();
			if(result > 0){
				Tester.markHere("result > 0");
				flag = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}		
		return flag;
	}

	@Override
	public double readBalanceByUserId(int userId) {
		BankCoreBusiness one = null;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		double balance = -1;
		try {
			ps = conn.prepareStatement("select balance" +
					" from " + DatabaseTable.BANK_INFO + " where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				balance = rs.getDouble("balance");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return balance;
	}

	@Override
	public String updateOne(BankInfoRecord one) {
		Tester.markHere("BankDAO.setOnesBankInfo");
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.BANK_INFO
					+ " set balance=?," +
							"depositCountAll=?,depositCountValid=?," +
							"withdrawCountAll=?,withdrawCountValid=?," +
							"averageScore=?"
					+ " where userId=?");
			ps.setDouble(1, one.getBalance());
			ps.setInt(2, one.getDepositCountAll());
			ps.setInt(3, one.getDepositCountValid());
			ps.setInt(4, one.getWithdrawCountAll());
			ps.setInt(5, one.getWithdrawCountValid());
			ps.setDouble(6, one.getAverageScore());
			ps.setInt(7, one.getUserId());
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}
	
	/**【原子】
	 * 更改编号为userId的会员银行数据，传入参数为改变量。
	 * @param userId 会员编号
	 * @param change 例如-2,+1等等
	 * @return 结果
	 */
	@Override
	public String updateOne(int userId, double balance, int depositCountAll, int depositCountValid,
							int withdrawCountAll, int withdrawCountValid, int averageScore) {
		Tester.markHere("BankDAO.updateBalanceCol");
		String result = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.BANK_INFO
					+ " set balance=balance+(?),depositCountAll=depositCountAll+(?),depositCountValid=depositCountValid+(?)," +
					  " withdrawCountAll=withdrawCountAll+(?),withdrawCountValid=withdrawCountValid+(?)," +
					  " averageScore=averageScore+(?) where userId=?");
			int i = 1;
			ps.setDouble(i++, balance);
			ps.setInt(i++, depositCountAll);
			ps.setInt(i++, depositCountValid);
			ps.setInt(i++, withdrawCountAll);
			ps.setInt(i++, withdrawCountValid);
			ps.setDouble(i++, averageScore);
			ps.setInt(i++, userId);
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
				result = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return result;
	}
	
	/**
	 * 获得某个用户的银行信息
	 * @param userId 某个用户的ID
	 * @return 该用户的银行信息
	 */
	@Override
	public BankInfoRecord readOneByUserId(int userId) {
		BankInfoRecord one = null;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.BANK_INFO + " where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				one = readOneProcess();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return one;
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	private BankInfoRecord readOneProcess() throws SQLException {
		BankInfoRecord one;
		one = new BankInfoRecord();
		one.setUserId(rs.getInt("userId"));
		one.setBalance(rs.getDouble("balance"));
		one.setDepositCountAll(rs.getInt("depositCountAll"));
		one.setDepositCountValid(rs.getInt("depositCountValid"));
		one.setWithdrawCountAll(rs.getInt("withdrawCountAll"));
		one.setWithdrawCountValid(rs.getInt("withdrawCountValid"));
		one.setAverageScore(rs.getDouble("averageScore"));
		return one;
	}
}
