package utility;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import configurations.Hooks;
import configurations.UrlRepository;


public class DeleteRemitanceDataBase {
	//public static String serverName=HyundaiHooks.serverName;
	public static String environment = Hooks.activeEnvironment;
	public static String DBInstance;

	public static void dataBaseRemDelete(String fName, String lName, String VIN) throws SQLException, IOException {
		
		if(environment.equalsIgnoreCase("QA"))
		{
			DBInstance=UrlRepository.qaDBInstance;
		}else if(environment.equalsIgnoreCase("UAT")) {
			DBInstance=UrlRepository.uatDBInstance;
		}else if(environment.equalsIgnoreCase("PRODUCTION")) {
			DBInstance=UrlRepository.prodDBInstance;
		}		

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
		         
			  ResultSet rs = stmt.executeQuery( "delete from web_remittance_records where vin='"+VIN+"' and first_name='"+fName.toUpperCase()+"' and last_name='"+lName.toUpperCase()+"';" );
		        
			  rs.close();
		      stmt.close();
		      connection.close();
		         
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}