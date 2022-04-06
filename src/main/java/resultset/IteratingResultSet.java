package resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingResultSet {

	public static void main(String[] args) {
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from Members");
				) {
			
			while (rs.next()) {
				System.out.println(rs.getString("full_names"));
			}
						
			
		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.showErrorMessage(e);
		}
		
	}
}
