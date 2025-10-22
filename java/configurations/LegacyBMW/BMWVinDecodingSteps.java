package configurations.LegacyBMW;

import bmw.pageobjects.ProductSelectionConditions;
import bmw.pageobjects.UrlPage;
import bmw.pageobjects.UserNamePasswordPage;
import bmw.pageobjects.VinDecodingPage;
import configurations.Hooks;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import DataBase.updateDealer;

public class BMWVinDecodingSteps {

	public String Test_Case=null;
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
	public String State=null;
	public String ZipCode=null;
	public String HomePhone=null;
	public String VehicleID=null;
	public String ExpectedMake=null;
	public String ExpectedModel=null;
	public String ExpectedYear=null;
	public String RimSize=null;
	public String Quantity=null;
	public String DOT1=null;
	public String DOT2=null;
	public String DOT3=null;
	public String DOT4=null;
	public String Category=null;
	
	@Given("^Go to BMW Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Vin_Decoding_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26) throws Throwable {
	  	
		this.Test_Case=arg1;
		this.Portal=arg2;
	    this.UserName=arg3;
	    this.Password=arg4;
	    this.Dealer=arg5;
	    this.Product=arg6;
	    this.Coverage=arg7;
	    this.Term=arg8;
	    this.FirstName=arg9;
	    this.LastName=arg10;
	    this.StreetAddress=arg11;
	    this.City=arg12;
	    this.State=arg13;
	    this.ZipCode=arg14;
	    this.HomePhone=arg15;
	    this.VehicleID=arg16;
	    this.ExpectedMake=arg17;
	    this.ExpectedModel=arg18;
	    this.ExpectedYear=arg19;
	    this.RimSize=arg20;
	    this.Quantity=arg21;
	    this.DOT1=arg22;
	    this.DOT2=arg23;
	    this.DOT3=arg24;
	    this.DOT4=arg25;
	    this.Category=arg26;
	    
	    UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl(Portal);
	}

	@Given("^Update BMW cmsid of the dealer for VinDecoding$")
	public void update_cmsid_of_the_dealer_for_VinDecoding() throws Throwable {
	    
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Given("^Login with BMW UserName and Password for Vin Decoding$")
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

	@When("^Fill BMW Product Selection Form for Vin Decoding$")
	public void fill_Product_Selection_Form_for_Vin_Decoding() throws Throwable {
	   
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productConditions(Category, Product, Coverage, Term, RimSize, Quantity, DOT1, DOT2, DOT3, DOT4);
	}

	@When("^Fill BMW E-contract Form for Vin Decoding$")
	public void fill_E_contract_Form_for_Vin_Decoding() throws Throwable {
		
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.vinDecoding(Category, FirstName, LastName, StreetAddress, City, State, ZipCode, HomePhone, VehicleID);
	    
	}

	@When("^Verify BMW Make Model and Year$")
	public void verify_Make_Model_and_Year() throws Throwable {
		
		VinDecodingPage vdp=new VinDecodingPage();
		vdp.matchMakeModelYear(ExpectedMake, ExpectedModel, ExpectedYear, Test_Case, Dealer, Product, Coverage, Term, VehicleID, Portal);
	   
	}

}
