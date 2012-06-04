package tk.persistence.impl.jdbc;
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
//import timebank.model.ReserveSkill;
//import timebank.model.article.Article;
//import timebank.model.user.User;
//import timebank.persistence.SkillDao;
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
//public class SkillDaoImpl implements SkillDao {
//	private Connection conn = null;
//	private PreparedStatement ps = null;
//	private ResultSet rs = null;
//
//	/**
//	 * 向数据库中新增一项爱好
//	 * @param one
//	 * @return
//	 */
//	@Override
//	public String createOne(ReserveSkill one) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("insert into " + DatabaseTable.SKILL + 
//					" (userId,createTime,class1,class2)" + 
//					" values(?,?,?,?)");
//			int i = 1;
//			ps.setInt(i++, one.getUserId());
//			ps.setString(i++, one.getCreateTime());
//			ps.setString(i++, one.getClassFirst());
//			ps.setString(i++, one.getClassSecond());
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
//	 * 获得数据库中指定用户指定第一分类的所有技能信息
//	 * @param userId 
//	 * @return
//	 */
//	@Override
//	public ArrayList<ReserveSkill> readSomeByUserIdAndClass1(long userId, String class1) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ReserveSkill one = new ReserveSkill();
//		one.setClassFirst(class1);
//		ArrayList<ReserveSkill> list = new ArrayList<ReserveSkill>();
//		list.add(one);
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.SKILL + " where userId=? and class1=?");
//			ps.setLong(1, userId);
//			ps.setString(2, class1);
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
//	 * 获得数据库中指定用户的所有技能信息的总数
//	 * @param userId 
//	 * @return
//	 */
//	@Override
//	public int readCountByUserId(int userId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.SKILL + " where userId=?");
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
//	private ReserveSkill readOneProcess() throws SQLException {
//		ReserveSkill one = new ReserveSkill();
//		one.setSkillId(rs.getInt("skillId"));
//		one.setUserId(rs.getInt("userId"));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
//		one.setClassFirst(rs.getString("class1"));
//		one.setClassSecond(rs.getString("class2"));
//		return one;
//	}
//
//	@Override
//	public ReserveSkill readOneById(int skillId) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ReserveSkill one = null;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.SKILL + " where skillId=?");
//			ps.setInt(1, skillId);
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
//	 * 根据信息查看用户有没有这条爱好特长
//	 * @param userId 用户编号
//	 * @param c1 第一分类
//	 * @param c2 第二分类
//	 * @return
//	 */
//	@Override
//	public boolean readOneIsHave(int userId, String c1, String c2) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		boolean result = false;
//		try {
//			ps = conn.prepareStatement("select * from " + DatabaseTable.SKILL + 
//					" where userId=? and class1=? and class2=?");
//			ps.setInt(1, userId);
//			ps.setString(2, c1);
//			ps.setString(3, c2);
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
//	/**
//	 * 根据信息查看用户有没有这条模糊的爱好特长
//	 * @param userId 用户编号
//	 * @param someSkills 模糊的技能储备
//	 * @return
//	 */
//	@Override
//	public boolean readOneIsHave(int userId, String someSkills) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		boolean result = false;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.SKILL + 
//					" where userId=? and (class1 like ? or class2 like ?)");
//			ps.setInt(1, userId);
//			ps.setString(2, "%" + someSkills + "%");
//			ps.setString(3, "%" + someSkills + "%");
//			rs = ps.executeQuery();
//			if(rs.next()){
//				if(rs.getInt(1) != 0){
//					result = true;
//				}
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
//	public String deleteOne(int skillId) {
//		
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		String flag = Values.FAILURE;
//		try {
//			ps = conn.prepareStatement("delete from " + DatabaseTable.SKILL + " where skillId=?");
//			ps.setInt(1, skillId);
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
//	 * 根据关键字找出用户爱好技能里面含有的记录
//	 * @param someInfo
//	 * @param p 页码
//	 * @return
//	 */
//	@Override
//	public ArrayList<Integer> readUserIdBySomeSkill(String someInfo, int p) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select distinct(userId) from " + DatabaseTable.SKILL + 
//					" where class1 like ? or class2 like ? order by createTime limit ?,?");
//			ps.setString(1, "%" + someInfo + "%");
//			ps.setString(2, "%" + someInfo + "%");
//			ps.setInt(3, (p - 1) * Values.PAGE_SIZE);
//			ps.setInt(4, Values.PAGE_SIZE);
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
//	 * 根据关键字找出用户爱好技能里面含有的记录
//	 * @param someInfo
//	 * @param p 页码
//	 * @return
//	 */
//	@Override
//	public ArrayList<Integer> readUserIdByHaveSkills(int p) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		Integer one = null;
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		try {
//			ps = conn.prepareStatement("select distinct(userId) from " + DatabaseTable.SKILL + 
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
//	 * 根据关键字找出用户爱好技能里面含有的记录的总数
//	 * @param someInfo
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public int readCountUserIdBySomeSkill(String someInfo) {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(distinct(userId)) from " + DatabaseTable.SKILL + 
//					" where class1 like ? or class2 like ?");
//			ps.setString(1, "%" + someInfo + "%");
//			ps.setString(2, "%" + someInfo + "%");
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
//	 * 读出所有有填写爱好技能的用户的总数
//	 * @param someInfo
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public int readCountUserIdByHaveSkills() {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(distinct(userId)) from " + DatabaseTable.SKILL);
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
//	 * 读出所有爱好技能的总数
//	 * @param someInfo
//	 * @param p
//	 * @return
//	 */
//	@Override
//	public int readCountSkills() {
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		int count = 0;
//		try {
//			ps = conn.prepareStatement("select count(*) from " + DatabaseTable.SKILL);
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
//}
