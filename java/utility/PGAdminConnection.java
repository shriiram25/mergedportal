package utility;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import configurations.Hooks;
import configurations.UrlRepository;

public class PGAdminConnection {

	public static String environment = Hooks.activeEnvironment;
	public static String DBInstance;

public static void dataBaseConnection(String TestCase, String fName, String lName, String VIN, String Dealer, String FormType) throws SQLException, IOException {
		
		if(environment.equalsIgnoreCase("QA"))
		{
			DBInstance=UrlRepository.qaDBInstance;
		} else if(environment.equalsIgnoreCase("UAT")) {
			DBInstance=UrlRepository.uatDBInstance;
		}else if(environment.equalsIgnoreCase("PRODUCTION")) {
			DBInstance=UrlRepository.prodDBInstance;
		}
		
		String toDayDate=CurrentDateSelection.getCurrentDate();
		String tableStatus="Fail";

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

			connection = DriverManager.getConnection("jdbc:postgresql://"+Hooks.serverName+"/forte", Hooks.userName,Hooks.password);
					//"jdbc:postgresql://"+DBInstance+"/forte", UrlRepository.userName,
					//UrlRepository.password);

		} catch (SQLException e) {

			System.out.println("Connection Failed!");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			//System.out.println("You made it, take control your database now!");
			
			  stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery( "select first_name, last_name,vin from web_remittance_records where vin='"+VIN+"' and created='"+toDayDate+"';" );
		         while ( rs.next() ) {
		        	 
		        	 String  firstNameTable = rs.getString("first_name");
		        	 String  lastNameTable = rs.getString("last_name");
		        	 String vinTable = rs.getString("vin");
		        	 
		        	 //System.out.println(firstNameTable);
		        	 //System.out.println(lastNameTable);
		        	// System.out.println(vinTable);
		        	 if(firstNameTable.equalsIgnoreCase(fName) && lastNameTable.equalsIgnoreCase(lName) && vinTable.equalsIgnoreCase(VIN))
		        	 {
		        		 tableStatus="Pass";
		        	 }
		           
		         }
		         
		        //System.out.println(tableStatus);
		         String[] valueToWriteNew=null;
		         valueToWriteNew = new String[8];
			     valueToWriteNew[0]=TestCase;
			     valueToWriteNew[1]=Dealer;
			 	 valueToWriteNew[2]=fName;
			 	 valueToWriteNew[3]=lName;
			 	 valueToWriteNew[4]=VIN;
			 	 valueToWriteNew[5]=tableStatus;
			 	 valueToWriteNew[6]=toDayDate;
			 	 valueToWriteNew[7]=FormType;   
		 		
		 		ExcelReadWrite ERW=new ExcelReadWrite();
		 		ERW.writeExcelForm(System.getProperty("user.dir"), "VSCresult.xlsx", "Web_Remittance_Table",valueToWriteNew);
		         
		        rs.close();
		        stmt.close();
		        connection.close();
		         
		} else {
			System.out.println("Failed to make connection!");
		}
	}

}