package resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementRetrieveDemo {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBUtil.getConnection(DBType.MYSQLDB);
			
			String sql = "Select * From Movies where category_id = ?";
			
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			prepareStatement(pstmt,8);
			
		}
		catch(SQLException ex){
			DBUtil.showErrorMessage(ex);
		}
	}

	private static void prepareStatement(PreparedStatement pstmt,int category_id) throws SQLException {
		ResultSet rs;
		pstmt.setInt(1, category_id);
		
		rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("title"));
		}
		
		rs.last();
		System.out.println("Total Movies : " + rs.getRow());
	}
}

