package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		Driver driverinfo = new Driver();
		DriverManager.registerDriver(driverinfo);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		Statement state = con.createStatement();
		String query = "insert into customerInfo values('Sam',105,'Chennai');";
		int result = state.executeUpdate(query);
		ResultSet set = state.executeQuery("select * from customerInfo");
		while(set.next()) {
			System.out.println(set.getString(1)+" "+set.getString(2)+" "+set.getString(3));
		}
		/*if(result==1) {
			System.out.println("data is inserted");
		}
		else System.out.println("data is not inserted");*/
		con.close();
	}

}
