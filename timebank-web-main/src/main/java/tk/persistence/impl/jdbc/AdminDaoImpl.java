package tk.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import timebank.model.admin.Admin;
import timebank.model.article.Article;
import timebank.model.user.User;
import timebank.util.database.DBConnection;
import timebank.util.lang.convertor.Convertor;
import tk.persistence.AdminDao;
import tk.util.Tester;
import tk.util.bean.DatabaseTable;
import tk.util.bean.Values;

@Repository
public class AdminDaoImpl implements AdminDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public Admin readOne(String username) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		Admin one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ADMIN + " where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				one = readOneProcess();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return one;
	}
	
	
	@Override
	public String readUsernameById(int adminId) {
		Tester.markHere("AdminDAO.getUsernameByAdminId");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String username = "";
		try {
			ps = conn.prepareStatement("select username from " + DatabaseTable.ADMIN + " where adminId=?");
			ps.setInt(1, adminId);
			rs = ps.executeQuery();
			if(rs.next()){
				Tester.markHere("result.next()");
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return username;
	}

	
	@Override
	public String createOne(Admin one) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("insert into " + DatabaseTable.ADMIN + 
					" (username,password,name,nameToUser,createTime,level)" + " values(?,?,?,?,?,?)");
			int i = 1;
			ps.setString(i++, one.getLoginName());
			ps.setString(i++, one.getPassword());
			ps.setTimestamp(i++, new Timestamp(new Date().getTime()));
			ps.setInt(i++, one.getAdminLevel());
			
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
	public ArrayList<Admin> readSomeByPage(int page) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<Admin> list = new ArrayList<Admin>();
		Admin one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ADMIN + " ORDER BY adminId limit ?,?");
			ps.setInt(1, (page - 1) * Values.PAGE_SIZE);
			ps.setInt(2, Values.PAGE_SIZE);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				one = readOneProcess();
				list.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}

	/**
	 * @return
	 * @throws SQLException 
	 */
	private Admin readOneProcess() throws SQLException {
		Admin one = new Admin();
		one.setId(rs.getInt("adminId"));
		one.setLoginName(rs.getString("username"));
		one.setPassword(rs.getString("password"));
//		one.setLinkedUserId(rs.getInt("linkedUserId"));
//		one.setAdminLevel(rs.getInt("level"));
		return one;
	}

	
	@Override
	public int readCountAll() {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.ADMIN);
			rs = ps.executeQuery();
			while(rs.next()){
				Tester.markHere("result.next()");
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return count;
	}

	
	@Override
	public Admin readOne(int adminId) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		Admin one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ADMIN + " where adminId=?");
			ps.setInt(1, adminId);
			rs = ps.executeQuery();
			if(rs.next()){
				one = readOneProcess();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return one;
	}

	
	@Override
	public String updateOne(Admin one) {
		String flag = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.ADMIN + 
					" set username=?,name=?,password=?,nameToUser=?,level=?,linkedUserId=?,linkedName=?  where adminId=?");
			int i = 1;
			ps.setString(i++, one.getLoginName());
			ps.setString(i++, one.getPassword());
			ps.setInt(i++, one.getAdminLevel());
//			ps.setInt(i++, one.getLinkedUserId());
			
			ps.setInt(i++, one.getId());
			
			int rtn = ps.executeUpdate();
			if (rtn > 0) {
				Tester.markHere("rtn > 0");
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
	public String createOneByPromote(Admin one) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("insert into " + DatabaseTable.ADMIN + 
					" (username,password,name,createTime,level,linkedName,linkedUserId)" + " values(?,?,?,?,?,?,?)");
			int i = 1;
			ps.setString(i++, one.getLoginName());
			ps.setString(i++, one.getPassword());
			ps.setTimestamp(i++, new Timestamp(new Date().getTime()));
			ps.setInt(i++, one.getAdminLevel());
//			ps.setInt(i++, one.getLinkedUserId());
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
	public String deleteOne(int aid) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("delete from " + DatabaseTable.ADMIN + " where adminId=?");
			ps.setInt(1, aid);
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
}
