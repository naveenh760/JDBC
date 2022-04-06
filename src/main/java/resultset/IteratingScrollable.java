package resultset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingScrollable {
	public static void main(String[] args) {
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("Select * from Movies limit 10");
				) {
			
			// First 10 rows
			rs.beforeFirst();
			while (rs.next()) {
				System.out.println(rs.getString("title"));
			}
			
			//Last 10 rows
			rs.afterLast();
			while(rs.previous()) {
				System.out.println(rs.getString("title"));
			}
			
			// First record
			rs.first();
			System.out.println(rs.getString("title"));
			
			//Last record
			rs.last();
			System.out.println(rs.getString("title"));
			
			//4th record
			rs.absolute(4);
			System.out.println(rs.getString("title"));
			
			//6th record
			rs.relative(2);
			System.out.println(rs.getString("title"));
			
			//2nd record
			rs.relative(-2);
			System.out.println(rs.getString("title"));
			
		} catch (SQLException e) {
			// TODO: handle exception
			DBUtil.showErrorMessage(e);
		}
		
	}
	
}
