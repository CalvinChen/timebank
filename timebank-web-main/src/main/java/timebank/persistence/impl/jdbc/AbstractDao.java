/**
 * @Project TimeBank
 * @CreatedTime 2011-11-13 上午09:54:58 
 * @Author CK
 * @Todo TODO
 */
package timebank.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import timebank.model.article.Article;
import timebank.util.DBConnection;
import timebank.util.Tester;
import timebank.util.bean.DatabaseTable;
import timebank.util.bean.Values;

/**
 * @author CK
 *
 */
public abstract class AbstractDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/**
	 * DAO模板类
	 * @param sql 执行的sql语句
	 * @param param 参数
	 * @return 结果
	 */
	public String update(String sql, Object[] param) {
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}
			int result = ps.executeUpdate();
			if(result > 0){
				flag = Values.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return flag;
	}
	
//	public ArrayList<Object> readSome(String sql, Object[] param){
//		DBConnection.initial(rs, ps, conn);
//		conn = DBConnection.getConnection();
//		ArrayList<Object> list = new ArrayList<Object>();
//		try {
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while(rs.next()){
//				Object one = readOneProcess1();
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
//	 * @return
//	 */
//	protected abstract Object readOneProcess1() throws SQLException ;
}
