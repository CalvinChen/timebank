package timebank.persistence.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;


import timebank.model.article.Article;
import timebank.model.user.User;
import timebank.persistence.ArticleDao;
import timebank.util.Convertor;
import timebank.util.DBConnection;
import timebank.util.Tester;
import timebank.util.bean.DatabaseTable;
import timebank.util.bean.Values;

@Repository
public class ArticleDaoImpl extends AbstractDao implements ArticleDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null;
	private Object[] param = null;
	
	/**
	 * 向数据库中新增一篇文章
	 * @param one
	 * @return
	 */
	@Override
	public String insert(Article one) {
		sql = "insert into " + DatabaseTable.ARTICLE + 
			" (adminId,author,createTime,articleType,articleTitle,articleContent,articleClickCount)" +
			" values(?,?,?,?,?,?,?)";
		param = new Object[]{
//			one.getAdminId(),one.getAuthor(),one.getCreateTime(),one.getArticleType(),
			one.getArticleTitle(),one.getArticleContent(),one.getArticleClickCount()};
		return super.update(sql, param);
	}

	/**
	 * 获得数据库中所有文章信息
	 * @param userId 
	 * @return
	 */
	@Override
	public ArrayList<Article> selectAll() {
		Tester.markHere("ArticleDAO.getAllArticle");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		ArrayList<Article> list = new ArrayList<Article>();
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ARTICLE + " ORDER BY articleId DESC");
			rs = ps.executeQuery();
			while(rs.next()){
				Article one = readOneProcess();
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
	private Article readOneProcess() throws SQLException {
		Article one = new Article();
//		one.setAdminId(rs.getInt("adminId"));
//		one.setArticleClickCount(rs.getInt("articleClickCount"));
//		one.setArticleContent(rs.getString("articleContent"));
//		one.setArticleId(rs.getInt("articleId"));
//		one.setArticleTitle(rs.getString("articleTitle"));
//		one.setArticleType(rs.getInt("articleType"));
//		one.setAuthor(rs.getString("author"));
//		one.setUpdateTime(rs.getString("updateTime"));
//		one.setCreateTime(Convertor.changeDateTimeToString(rs.getTimestamp("createTime")));
		return one;
	}
	
	/**
	 * 获得数据库中指定文章类型的所有文章信息
	 * @param articleType 
	 * @return
	 */
	@Override
	public ArrayList<Article> selectListByType(int articleType) {
		Tester.markHere("ArticleDAO.getArticlesByType");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		Article one;
		ArrayList<Article> list = new ArrayList<Article>();
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ARTICLE + " where articleType=? ORDER BY articleId DESC");
			ps.setInt(1, articleType);
			rs = ps.executeQuery();
			while(rs.next()){
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
	 * 根据one的articleId更新文章内容
	 * @param one
	 * @return
	 */
	@Override
	public String update(Article one) {
		Tester.markHere("ArticleDAO.updateArticle");
		String flag = Values.FAILURE;
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		try {
			ps = conn.prepareStatement("update " + DatabaseTable.ARTICLE + 
					" set author=?,articleType=?,articleTitle=?,articleContent=?,articleClickCount=?  where articleId=?");
//			ps.setString(1, one.getAuthor());
			ps.setInt(2, one.getArticleType());
			ps.setString(3, one.getArticleTitle());
			ps.setString(4, one.getArticleContent());
			ps.setInt(5, one.getArticleClickCount());
			ps.setInt(6, one.getArticleId());
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
	public Article select(int articleId) {
		Tester.markHere("ArticleDAO.getArticleById");
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		Article one = null;
		try {
			ps = conn.prepareStatement("select * from " + DatabaseTable.ARTICLE + " where articleId=?");
			ps.setInt(1, articleId);
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
	public String delete(int articleId) {
		Tester.markHere("ArticleDAO.deleteArticle");
		
		DBConnection.initial(rs, ps, conn);
		conn = DBConnection.getConnection();
		String flag = Values.FAILURE;
		try {
			ps = conn.prepareStatement("delete from " + DatabaseTable.ARTICLE + " where articleId=?");
			ps.setInt(1, articleId);
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
