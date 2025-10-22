package configurations.LegacyNissan;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import DataBase.updateDealer;
import configurations.Hooks;
import nissaninfiniti.pageobjects.ProductSelectionConditions;
import nissaninfiniti.pageobjects.UrlPage;
import nissaninfiniti.pageobjects.UserNamePasswordPage;
import nissaninfiniti.pageobjects.VinDecodingPage;

public class NissanVinDecodingSteps {
		
	public String TestCase=null;
	public String Portal=null;
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
	public String Province=null;
	public String PostalCode=null;
	public String HomePhone=null;
	public String BusPhone=null;
	public String Email=null;
	public String VehicleID=null;
	public String ExpectedMake=null;
	public String ExpectedModel=null;
	public String ExpectedYear=null;
	public String Category=null;
	
	@Given("^Go to Nissan Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22) throws Throwable {
	   
		TestCase=arg1;
		Portal=arg2;
		UserName=arg3;
		Password=arg4;
		Dealer=arg5;
		Product=arg6;
		Coverage=arg7;
		Term=arg8;
		FirstName=arg9;
		LastName=arg10;
		StreetAddress=arg11;
		City=arg12;
		Province=arg13;
		PostalCode=arg14;
		HomePhone=arg15;
		BusPhone=arg16;
		Email=arg17;			
		VehicleID=arg18;
		ExpectedMake=arg19;
		ExpectedModel=arg20;
		ExpectedYear=arg21;
		Category=arg22;
		
		UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl(Portal);		
	}

	@Given("^Update cmsid of the Nissan dealer for VinDecoding$")
	public void update_cmsid_of_the_dealer_for_VinDecoding() throws Throwable {
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Given("^Login with Nissan UserName and Password for Vin Decoding$")
	public void login_with_UserName_and_Password_for_Vin_Decoding() throws Throwable {
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@When("^Fill Nissan Product Selection Form for Vin Decoding$")
	public void fill_Product_Selection_Form_for_Vin_Decoding() throws Throwable {
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productCondation(Category, Product, Coverage, Term);
	}

	@When("^Fill Nissan E-contract Form for Vin Decoding$")
	public void fill_E_contract_Form_for_Vin_Decoding() throws Throwable {
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.vinDecoding(Category, FirstName, LastName, StreetAddress, City, Province, PostalCode, HomePhone, BusPhone, Email, VehicleID);
	}

	@When("^Verify Nissan Make Model and Year$")
	public void verify_Make_Model_and_Year() throws Throwable {
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.verifyMakeModelYear(ExpectedMake, ExpectedModel, ExpectedYear, TestCase, Portal, Dealer, Product, Coverage, Term, VehicleID);
	}
	
}
