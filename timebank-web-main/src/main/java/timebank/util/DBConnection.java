package timebank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.sql.DataSource;

public final class DBConnection {

	private static String driver = "com.mysql.jdbc.Driver";
//	private static String url = "jdbc:mysql://61.147.68.145:3306/timebank";
	 private static String url = "jdbc:mysql://localhost:3306/timebank";
	private static String username = "timebank";
	private static String password = "timebank";

	/**
	 * 构造方法，在构造时加载驱动类
	 */
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对几个集合简单初始化（都置为null）
	 * @param rs 结果集
	 * @param ps 声明集
	 * @param conn 连接
	 */
	public static void initial(ResultSet rs, PreparedStatement ps,
			Connection conn) {
		rs = null;
		ps = null;
		conn = null;
	}

	/**
	 * 获取tomcat连接池的连接
	 * @return 空闲连接
	 */
	public static synchronized Connection getConnection(){
		try {
//			javax.naming.Context initCtx = new javax.naming.InitialContext();
//			javax.naming.Context envCtx = (Context) initCtx.lookup("java:comp/env");
//			javax.sql.DataSource ds = (DataSource) envCtx.lookup("jdbc/TimeBank");
//			return ds.getConnection();
			Connection conn = DriverManager.getConnection(url, username, password);//建立连接
			return conn;
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放数据库资源
	 * @param rs 结果集
	 * @param ps 声明集
	 * @param conn 连接
	 */
	public static void free(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
