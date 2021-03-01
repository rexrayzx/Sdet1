package Scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class WriteDataDB {
	Connection conn;
	
	@Test
	public void writeData() throws Throwable {
		try {
		Driver msdriver=new Driver();
		DriverManager.registerDriver(msdriver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajivdb","root", "rajiv");
		Statement state = conn.createStatement();
		int result = state.executeUpdate("insert into tabledata values('saket','yadav','mno@gmail.com')");
		if (result==0) {
			System.out.println("failed");
		}else if(result==1) {
			System.out.println("pass");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		
	}

}
