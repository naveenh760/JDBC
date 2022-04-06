package resultset;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;


public class TestPreparedUpdate {

	public static void main(String[] args) throws SQLException  {
				
		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
		
		String sql = "Update movies set director = ? where title = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter title of the movie :");
		String title = scanner.next();
		
		System.out.print("Enter New director : ");
		String director = scanner.next();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, director);
		pstmt.setString(2, title);
		
		int result = pstmt.executeUpdate();
		
		if( result == 1 )
		{
			System.out.println("director name Updated Successfully.");
		}
		else{
			System.err.println("Error while updating the director name.");
		}
		
		scanner.close();
		pstmt.close();
		conn.close();
		
	}

}


