package utility;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import configurations.Hooks;
import configurations.UrlRepository;

public class DeleteWebConMoneAndDmsConMoneTable {
	
	public static String environment = Hooks.activeEnvironment;
	public static String DBInstance;


	public static void dataBaseWebDmsDelete(String fName, String lName, String VIN) throws SQLException, IOException {
		
		if(environment.equalsIgnoreCase("QA"))
		{
			DBInstance=UrlRepository.qaDBInstance;
		}else if(environment.equalsIgnoreCase("UAT")) {
			DBInstance=UrlRepository.uatDBInstance;
		}else if(environment.equalsIgnoreCase("PRODUCTION")) {
			DBInstance=UrlRepository.prodDBInstance;
		}
				
		ResultSet rs = null;

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		Statement stmt = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://"+DBInstance+"/forte", UrlRepository.userName,
					UrlRepository.password);

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
			
			  stmt = connection.createStatement();
		        
			  try{
				  rs = stmt.executeQuery( "delete from web_con_m1 where web_con_vin='"+VIN+"' and web_con_fname='"+fName.toUpperCase()+"' and web_con_lname='"+lName.toUpperCase()+"';" );
			  }catch(Exception e){
				  e.getMessage();
			  }
			  
			  try{
				  rs = stmt.executeQuery( "delete from dms_con_m1 where dms_con_vin='"+VIN+"' and dms_con_fname='"+fName.toUpperCase()+"' and dms_con_lname='"+lName.toUpperCase()+"';" );
			  }catch(Exception e){
				  e.getMessage();
			  }		       
			  
			  rs.close();
		      stmt.close();
		      connection.close();
		         
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}