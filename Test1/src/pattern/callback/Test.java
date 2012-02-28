package pattern.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class User{
	int id;
	String userName;
	Date birth;
	Date createDate;
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
public class Test {

	public Object query(final String sql) throws SQLException {
		class QueryStatementCallback implements StatementCallback {
			public Object doInStatement(Statement stmt) throws SQLException {
				ResultSet rs = stmt.executeQuery("");
				List<User> userList = new ArrayList<User>();

				User user = null;
				while (rs.next()) {

					user = new User();
					user.setId(rs.getInt("id"));
					user.setUserName(rs.getString("user_name"));
					user.setBirth(rs.getDate("birth"));
					user.setCreateDate(rs.getDate("create_date"));
					userList.add(user);
				}
				return userList;

			}

		}

		JdbcTemplate jt = new JdbcTemplate(){};
		return jt.query(new QueryStatementCallback());
	}
}
