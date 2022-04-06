package resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStaticSQLStatement {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBUtil.getConnection(DBType.MYSQLDB);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select distinct gender from members");
			rs.last();
			System.out.println("Total Rows : " + rs.getRow());
			
			
		}catch(SQLException ex){
			DBUtil.showErrorMessage(ex);
		}
		finally{
			if( rs!= null )
				rs.close();
			if (stmt != null )
				stmt.close();
			if(conn != null)
				conn.close();
		}
	}

}
