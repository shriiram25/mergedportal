package nissaninfiniti.pageobjects;

import java.io.IOException;

import configurations.Hooks;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.Log;

public class VinDecodingPage {
	
	public void vinDecoding(String Category, String FirstName, String LastName, String StreetAddress, String City, String Province, String PostalCode, String HomePhone, String BusPhone, String Email, String VehicleID)
	{
		EContractPage ecp=new EContractPage(Hooks.driver);
		
		if(Category.equalsIgnoreCase("QVGS-CAN")||Category.equalsIgnoreCase("QVGS-FR"))
		{
			ecp.enterVin(VehicleID);
			ecp.clickVinDecoder();
		}
		else
		{	
			ecp.enterFName(FirstName);
			ecp.enterLName(LastName);
			ecp.enterAddress(StreetAddress);
			ecp.enterCity(City);
			ecp.enterProvince(Province);
			ecp.enterPostalCode(PostalCode);
			ecp.enterHomePhone(HomePhone);
			ecp.enterBusPhone(BusPhone);
			ecp.enterEmail(Email);
			ecp.enterVin(VehicleID);
			ecp.clickVinSearch();
		}
		
		
	}
	
	public void verifyMakeModelYear(String ExpectedMake, String ExpectedModel, String ExpectedYear, String TestCase, String Portal, String Dealer, String Product, String Coverage, String Term, String VehicleID) throws IOException
	{
		String status=null;
		VinMakeModelYearPage vmmyp=new VinMakeModelYearPage(Hooks.driver);
		String webMake=vmmyp.getMake();
		String webModel=vmmyp.getModel();
		String webYear=vmmyp.getYear();
		
		/*System.out.println("webMake:- "+webMake);
		System.out.println("webModel:- "+webModel);
		System.out.println("webYear:- "+webYear);*/
		
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
        valueToWriteNew = new String[15];
        valueToWriteNew[0]=TestCase;
        valueToWriteNew[1]=Portal;
 		valueToWriteNew[2]=Dealer;
 		valueToWriteNew[3]=Product;
 		valueToWriteNew[4]=Coverage;
 		valueToWriteNew[5]=Term;
 		valueToWriteNew[6]=VehicleID;
 		valueToWriteNew[7]=ExpectedMake;
 		valueToWriteNew[8]=ExpectedModel;
 		valueToWriteNew[9]=ExpectedYear;
 		valueToWriteNew[10]=webMake;
 		valueToWriteNew[11]=webModel;
 		valueToWriteNew[12]=webYear;
 		valueToWriteNew[13]=status;
 		valueToWriteNew[14]=CurrentDateSelection.getCurrentDate();
 		
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
