package MB;

import java.io.IOException;

import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.Log;
import configurations.Hooks;

public class VinDecodingPage {
	
	public void vinDecoding(String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String VehicleID)
	{
		EContractPage ecp=new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterState(State);
		ecp.enterZip(ZipCode);
		ecp.enterPhone(HomePhone);
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
	}
	
	public void vinDecodingMBCA(String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String WorkPhone, String Email, String VehicleID)
	{
		EContractPage ecp=new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterState(State);
		ecp.enterZip(ZipCode);
		ecp.enterPhone(HomePhone);
		ecp.enterWorkPhone(WorkPhone);
		ecp.enterEmail(Email);
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
	}
	
	public void matchMakeModelYear(String ExpectedMake, String ExpectedModel, String ExpectedYear, String TestCase, String Dealer, String Product, String Coverage, String Term, String VehicleID) throws IOException
	{
		String status=null;
		VinMakeModelYearPage vmmyp=new VinMakeModelYearPage(Hooks.driver);
		String webMake=vmmyp.getMake();
		String webModel=vmmyp.getModel();
		String webYear=vmmyp.getYear();
		
		System.out.println("webMake:- "+webMake);
		System.out.println("webModel:- "+webModel);
		System.out.println("webYear:- "+webYear);
		
		if(webMake.equalsIgnoreCase(ExpectedMake.trim()) && webModel.equalsIgnoreCase(ExpectedModel.trim()) && webYear.equalsIgnoreCase(ExpectedYear.trim()))
		{
			status="Pass";
		}
		else
		{
			status="Fail";
		}
		
		//System.out.println("status:- "+status);
		
		 String[] valueToWriteNew=null;
	        valueToWriteNew = new String[14];
	 		valueToWriteNew[0]=TestCase;
	 		valueToWriteNew[1]=Dealer;
	 		valueToWriteNew[2]=Product;
	 		valueToWriteNew[3]=Coverage;
	 		valueToWriteNew[4]=Term;
	 		valueToWriteNew[5]=VehicleID;
	 		valueToWriteNew[6]=ExpectedMake;
	 		valueToWriteNew[7]=ExpectedModel;
	 		valueToWriteNew[8]=ExpectedYear;
	 		valueToWriteNew[9]=webMake;
	 		valueToWriteNew[10]=webModel;
	 		valueToWriteNew[11]=webYear;
	 		valueToWriteNew[12]=status;
	 		valueToWriteNew[13]=CurrentDateSelection.getCurrentDate();
	 		
	 		ExcelReadWrite ERW=new ExcelReadWrite();
	 		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "Vin_Decoding_Result",valueToWriteNew);
	        
	 		Log.log.debug("Verify Make Model Year as:-");
	 		Log.log.debug("Expected Make as:- "+ExpectedMake);
    		Log.log.debug("Actual Make as:- "+webMake);
    		Log.log.debug("Expected Model as:- "+ExpectedModel);
    		Log.log.debug("Actual Model as:- "+webModel);
    		Log.log.debug("Expected Year as:- "+ExpectedYear);
    		Log.log.debug("Actual Year as:- "+webYear);
    		Log.log.debug("Status as:- "+status);
		
	}

}
