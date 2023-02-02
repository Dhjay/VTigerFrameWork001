package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Driver driverRef;
	Connection con = null;
	
	/*
	 * This method will establish connection with the database
	 */
	public void connectToDB() throws SQLException {
		
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection( IConstantsUtilities.DBUrl,IConstantsUtilities.DBUserName ,IConstantsUtilities.DBPassword );
		
	}
	
	/*
	 * This method close the database connection
	 */
	public void dbClose() throws SQLException {
		con.close();
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 */
	public String executeQueryVerifyDataAndReturn(String query,int columnIndex, String expData) throws SQLException {
		
		//executequery
		
		Boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String actData = result.getString(columnIndex);
			
		//verify the data from database
			
			if(actData.equals(expData)) {
				flag = true;
				break;
			}
		}
		
		//returning if expected and actual data are matching
		
		if(flag) {
			System.out.println("data verified");
			return expData;
		}
		
		else {
			System.out.println("data not verified");
			return "";
		}
	}
	

}
