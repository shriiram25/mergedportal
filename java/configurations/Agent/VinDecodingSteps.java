package configurations.Agent;

import agents.pageobjects.VinDecodingPage;
import configurations.Hooks;

import java.io.IOException;

import agents.pageobjects.ProductSelectionConditions;
import agents.pageobjects.UrlPage;
import agents.pageobjects.UserNamePasswordPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import DataBase.updateDealer;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;

public class VinDecodingSteps {
	
	public String write = "No";
	public String webMake = null;
	public String webModel = null;
	public String webYear = null;
	public String status = "Fail";
	public String[] data = null;
	
	public String Test_Case=null;
	public String UserName=null;
	public String Password=null;
	public String Dealer=null;
	public String Product=null;
	public String Coverage=null;
	public String Term=null;
	public String FirstName=null;
	public String LastName=null;
	public String StreetAddress=null;
	public String City=null;
	public String State=null;
	public String ZipCode=null;
	public String HomePhone=null;
	public String VehicleID=null;
	public String Category=null;
	public String ExpectedMake=null;
	public String ExpectedModel=null;
	public String ExpectedYear=null;
	
	@Given("^Go to agent Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Vin_Decoding_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19) throws Throwable {
		
		write = "Yes";
		
			this.Test_Case=arg1;
		    this.UserName=arg2;
		    this.Password=arg3;
		    this.Dealer=arg4;
		    this.Product=arg5;
		    this.Coverage=arg6;
		    this.Term=arg7;
		    this.FirstName=arg8;
		    this.LastName=arg9;
		    this.StreetAddress=arg10;
		    this.City=arg11;
		    this.State=arg12;
		    this.ZipCode=arg13;
		    this.HomePhone=arg14;
		    this.VehicleID=arg15;
		    this.Category=arg16;
		    this.ExpectedMake=arg17;
		    this.ExpectedModel=arg18;
		    this.ExpectedYear=arg19;
		    
		    UrlPage up=new UrlPage(Hooks.driver);
		    up.openUrl();
	}

	@Given("^Update agent cmsid of the dealer for VinDecoding$")
	public void update_cmsid_of_the_dealer_for_VinDecoding() throws Throwable {
	    
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Given("^Login with agent UserName and Password for Vin Decoding$")
	public void login_with_UserName_and_Password_for_Vin_Decoding() throws Throwable {
		
		/*try{
			UpdateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}*/
		
		
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	   
	}

	@When("^Fill Product Selection Form for Vin Decoding$")
	public void fill_Product_Selection_Form_for_Vin_Decoding() throws Throwable {
		
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productCondation(Category, Product, Coverage, Term);
	   
	}

	@When("^Fill E-contract Form for Vin Decoding$")
	public void fill_E_contract_Form_for_Vin_Decoding() throws Throwable {
		
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.vinDecoding(Category, FirstName, LastName, StreetAddress, City, State, ZipCode, HomePhone, VehicleID);
	    
	}

	@When("^Verify Make Model and Year$")
	public void verify_Make_Model_and_Year() throws Throwable {
		VinDecodingPage vdp=new VinDecodingPage();
		data= vdp.matchMakeModelYear(ExpectedMake, ExpectedModel, ExpectedYear, Test_Case, Dealer, Product, Coverage, Term, VehicleID);
		webMake = data[0];
		webModel = data[1];
		webYear = data[2];
		status = data[3];
	}

	@After
	public void writeResult(){
		
		System.out.println("+++++++++++++++++++++VIN Decoding++++++++++++++++++++++"+write);
		
		if (write.equalsIgnoreCase("Yes")) {
			System.out.println("VIN Decoding Print######################");
			
			try {
				
				String[] valueToWriteNew=null;
		        valueToWriteNew = new String[14];
		 		valueToWriteNew[0]=Test_Case;
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

				} catch (IOException e) {				
				e.printStackTrace();
			}
	
		}
		
	}
	
}
