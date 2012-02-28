package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
					.newInstance();
			Connection msConn = getMsSQLConn();
			Connection myConn = getMySQLConn();
			//transferUser(msConn, myConn);
			if(msConn != null)
				System.out.print("success");
			msConn.close();
			myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void transferBlock(Connection msConn, Connection tarConn)
			throws Exception {
		Statement msStat = msConn.createStatement();
		Statement tarStat = tarConn.createStatement();
		msStat.execute("SELECT * FROM bbs_config ORDER BY ID");
		ResultSet msRs = msStat.getResultSet();
		String sql = null;
		while (msRs.next()) {
			sql = "INSERT INTO block (ID, PARENT, NAME) VALUES ("
					+ msRs.getInt("id") + ", " + msRs.getInt("parent") + ", '"
					+ escapeString(msRs.getString("name")) + "')";
			tarStat.addBatch(sql);
			System.out.println(sql);
		}
		tarStat.executeBatch();
		msRs.close();
		tarStat.close();
		msStat.close();
	}

	private static void transferPost(Connection msConn, Connection tarConn)
			throws Exception {
		Statement msStat = msConn.createStatement();
		Statement tarStat = tarConn.createStatement();
		msStat.execute("SELECT * FROM bbs_book ORDER BY ID");
		ResultSet msRs = msStat.getResultSet();
		String sql = null;
		int i = 0;
		while (msRs.next()) {
			i++;
			sql = "INSERT INTO post (ID, USER_ID, BLOCK_ID, TITLE, CONTENT, VIEW_COUNT, GOOD_COUNT, BAD_COUNT, WELL, BEST, `END`, `LOCK`, MARK, DELETED, TOP_TYPE, CREATE_TIME, REPLY_TIME, REPLY_COUNT, REPLY_HAS_TOP, FAV_COUNT, AUTHOR_NAME, HAS_ATTACHMENT, HAS_VOTE) VALUES ("
					+ msRs.getInt("id")
					+ ", "
					+ msRs.getInt("author_id")
					+ ", "
					+ msRs.getInt("bbs_id")
					+ ", '"
					+ escapeString(msRs.getString("title"))
					+ "', '"
					+ escapeString(msRs.getString("text"))
					+ "', "
					+ msRs.getInt("read")
					+ ",0 ,0 ,"
					+ msRs.getInt("good")
					+ ", "
					+ msRs.getInt("strong")
					+ ", "
					+ msRs.getInt("end")
					+ ", "
					+ msRs.getInt("lock")
					+ ", "
					+ msRs.getInt("mark")
					+ ", "
					+ msRs.getInt("del")
					+ ", "
					+ msRs.getInt("top")
					+ ", '"
					+ msRs.getString("time")
					+ "', '"
					+ msRs.getString("reply_time")
					+ "', "
					+ msRs.getInt("reply")
					+ ",0 ,0, '"
					+ escapeString(msRs.getString("author_name")) + "' ,0 ,0)";

			if (i == 100) {
				i = 0;
				tarStat.executeBatch();
			}
			System.out.println(sql);
			tarStat.addBatch(sql);
		}
		tarStat.executeBatch();
		msRs.close();
		tarStat.close();
		msStat.close();
	}

	private static void transferReply(Connection msConn, Connection tarConn)
			throws Exception {
		Statement msStat = msConn.createStatement();
		Statement tarStat = tarConn.createStatement();
		msStat.execute("SELECT * FROM bbs_reply WHERE ID > 3259652 ORDER BY ID");
		ResultSet msRs = msStat.getResultSet();
		String sql = null;
		int i = 0;
		while (msRs.next()) {
			i++;
			sql = "INSERT INTO reply (ID, USER_ID, POST_ID, CONTENT, CREATE_TIME, TOP, MARK, USER_NAME) VALUES ("
					+ msRs.getInt("id")
					+ ", "
					+ msRs.getInt("author_id")
					+ ", "
					+ msRs.getInt("book_id")
					+ ", '"
					+ escapeString(msRs.getString("text"))
					+ "', '"
					+ msRs.getString("time")
					+ "', "
					+ msRs.getInt("istop")
					+ ", "
					+ msRs.getInt("get_mark")
					+ ", '"
					+ escapeString(msRs.getString("author_name")) + "')";

			if (i == 100) {
				i = 0;
				tarStat.executeBatch();
				tarStat.clearBatch();
			}
			System.out.println(sql);
			tarStat.addBatch(sql);
		}
		tarStat.executeBatch();
		msRs.close();
		tarStat.close();
		msStat.close();
	}

	private static void transferUser(Connection msConn, Connection tarConn)
			throws Exception {
		Statement msStat = msConn.createStatement();
		Statement tarStat = tarConn.createStatement();
		msStat.execute("SELECT * FROM [user] ORDER BY userID");
		ResultSet msRs = msStat.getResultSet();
		String sql = null;
		int i = 0;
		while (msRs.next()) {
			i++;
			sql = "INSERT INTO `user` (ID, `NAME`, `PASSWORD`, SESSIONID, MOBILE, `ONLINE`, EMAIL, MARK, MONEY, LOGIN_TIME, REG_TIME) VALUES ("
					+ msRs.getInt("userid")
					+ ", '"
					+ escapeString("UNKNOW".equals(msRs.getString("nickname")) ? ""
							: msRs.getString("nickname"))
					+ "', '"
					+ ((msRs.getString("password").length() != 16) ? "" : msRs
							.getString("password"))
					+ "', '"
					+ (UUID.randomUUID().toString())
					+ "', '"
					+ msRs.getString("tel")
					+ "', 0, '"
					+ ("@".equals(msRs.getString("email")) ? "" : msRs
							.getString("email"))
					+ "', "
					+ msRs.getInt("mark")
					+ ", "
					+ msRs.getInt("money")
					+ ", '"
					+ msRs.getString("logintime")
					+ "', '"
					+ msRs.getString("regtime") + "')";
			if (i == 100) {
				i = 0;
				tarStat.executeBatch();
				tarStat.clearBatch();
			}
			System.out.println(sql);
			tarStat.addBatch(sql);
		}
		tarStat.executeBatch();
		msRs.close();
		tarStat.close();
		msStat.close();
	}

	private static Connection getMySQLConn() {
		try {
			return DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/3ghack?characterEncoding=utf8&concurrent_insert=2",
							"root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Connection getMsSQLConn() {
		try {
			return DriverManager
					.getConnection(
							"jdbc:sqlserver://127.0.0.1:1433;databaseName=3ghack;selectMethod=cursor",
							"weefic", "890424ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String escapeString(String s) {
		if (s == null)
			return s;
		return s.replaceAll("\\\\", "\\\\\\\\");
	}
}
