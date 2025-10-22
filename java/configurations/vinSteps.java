package configurations;

import DataBase.updateDealer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import AutoNation.*;

public class vinSteps {
	
	public String Test_Case=null;
	public String UserName=null;
	public String Password=null;
	public String Dealer=null;
	public String DealNumber_OR_Last7Vin=null;
	public String Full_VIN=null;
	public String Exp_Product_Form=null;
	
	@Given("^Go to Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Vin_Decoding_as_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
	    
		this.Test_Case=arg1;
		this.UserName=arg2;
		this.Password=arg3;
		this.Dealer=arg4;
		this.DealNumber_OR_Last7Vin=arg5;
		this.Full_VIN=arg6;
		this.Exp_Product_Form=arg7;
		
		urlPage up=new urlPage(Hooks.driver);
		up.goToUrl();
	}

	@Given("^Click on Log in Link for Vin Decoding$")
	public void click_on_Log_in_Link_for_Vin_Decoding() throws Throwable {
		logInLinkPage lilp=new logInLinkPage(Hooks.driver);
		lilp.logInLinkClick();
	}

	@Given("^Update cmsid of the dealer for VinDecoding$")
	public void update_cmsid_of_the_dealer_for_VinDecoding() throws Throwable {
	    
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Given("^Login with UserName and Password for Vin Decoding$")
	public void login_with_UserName_and_Password_for_Vin_Decoding() throws Throwable {
		
		/*try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}*/
		
		userNamePasswordPage unpp=new userNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@Given("^Click on Rate and Remit Link for Vin Decoding$")
	public void click_on_Rate_and_Remit_Link_for_Vin_Decoding() throws Throwable {
		
		rateAndRemitPage rar = new rateAndRemitPage(Hooks.driver);
		rar.rateAndRemit();
	}

	@When("^Fill Remittance Form for Vin Decoding$")
	public void fill_Remittance_Form_for_Vin_Decoding() throws Throwable {
		
		addNewRemittancePage anrp=new addNewRemittancePage(Hooks.driver);
		anrp.addRemittance();
		
		if(DealNumber_OR_Last7Vin.equalsIgnoreCase(""))
		{
			vinRemittanceFullVin vrfv=new vinRemittanceFullVin(Hooks.driver);
			Thread.sleep(2000);
			vrfv.enterFullVin(Full_VIN);
			vrfv.clickGetProduct();
			
		}else{
			
			vinRemittanceFullVin vrfv=new vinRemittanceFullVin(Hooks.driver);
			Thread.sleep(2000);
			vrfv.enterDealNumber(DealNumber_OR_Last7Vin);
			vrfv.clickRetriveDealInfo();
		}
	}

	@When("^Verify Product Form for Vin Decoding$")
	public void verify_Product_Form_for_Vin_Decoding() throws Throwable {
		
		verifyProductForms vpf=new verifyProductForms(Hooks.driver);
		vpf.verifyForms(Exp_Product_Form, Test_Case, Dealer, DealNumber_OR_Last7Vin, Full_VIN);
	}

	@Then("^Log Out From Portal for Vin Decoding$")
	public void log_Out_From_Portal_for_Vin_Decoding() throws Throwable {
		
		logOutPage lop=new logOutPage(Hooks.driver);
		lop.logOut();
	}

}
