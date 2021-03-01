package Scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDB {
	Connection conn;
	@Test
	public void readData() throws Throwable {
		try {
		Driver msdriver=new Driver();
		DriverManager.registerDriver(msdriver);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajivdb","root","rajiv");
		Statement state = conn.createStatement();
		ResultSet result = state.executeQuery("select* from tabledata");
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2));
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
