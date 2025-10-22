package configurations.LegacyMercedesBenz;

import DataBase.updateDealer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When; 
import MB.*;
import configurations.Hooks;

public class VinDecodingMBSteps {

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
	public String ExpectedMake=null;
	public String ExpectedModel=null;
	public String ExpectedYear=null;
	public String Category=null;
	
	@Given("^Go to MB_US Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Vin_Decoding_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19) throws Throwable {
	   
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
	    this.ExpectedMake=arg16;
	    this.ExpectedModel=arg17;
	    this.ExpectedYear=arg18;
	    this.Category=arg19;
	    
	    UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl();
	}

	@Given("^Update MB_US cmsid of the dealer for VinDecoding$")
	public void update_cmsid_of_the_dealer_for_VinDecoding() throws Throwable {
		
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Given("^Login with MB_US UserName and Password for Vin Decoding$")
	public void login_with_UserName_and_Password_for_Vin_Decoding() throws Throwable {
	    
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
		
	}

	@When("^Fill MB_US Product Selection Form for Vin Decoding$")
	public void fill_Product_Selection_Form_for_Vin_Decoding() throws Throwable {
	 
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productCondition(Category, Product, Coverage, Term);
		
	}

	@When("^Fill MB_US E-contract Form for Vin Decoding$")
	public void fill_E_contract_Form_for_Vin_Decoding() throws Throwable {
	    
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.vinDecoding(Category, FirstName, LastName, StreetAddress, City, State, ZipCode, HomePhone, VehicleID);
		
	}

	@When("^Verify MB_US Make Model and Year$")
	public void verify_Make_Model_and_Year() throws Throwable {
	    
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.matchMakeModelYear(ExpectedMake, ExpectedModel, ExpectedYear, Test_Case, Dealer, Product, Coverage, Term, VehicleID);
		
	}
}
