package configurations.LegacyToyota;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Log;
import Toyota.*;
import configurations.Hooks;

public class ToyotaVinDecodingSteps {
	
	public String RowNo=null;
	public String Portal=null;
	public String UserName=null;
	public String Password=null;
	public String Dealer=null;
	public String Product=null;
	public String Coverage=null;
	public String Term=null;
	public String FirstName=null;
	public String LastName=null;
	public String MailingAddress=null;
	public String City=null;
	public String State=null;
	public String ZIP=null;
	public String PhoneNo=null;
	public String VinNo=null;
	public String Exp_Make=null;
	public String Exp_Model=null;
	public String Exp_Year=null;

@Given("^Go to Toyota Url for Vin Decoding as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
public void go_to_Url_for_Vin_Decoding_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19) throws Throwable {
    this.RowNo=arg1;
    this.Portal=arg2;
    this.UserName=arg3;
    this.Password=arg4;
    this.Dealer=arg5;
    this.Product=arg6;
    this.Coverage=arg7;
    this.Term=arg8;
    this.FirstName=arg9;
    this.LastName=arg10;
    this.MailingAddress=arg11;
    this.City=arg12;
    this.State=arg13;
    this.ZIP=arg14;
    this.PhoneNo=arg15;
    this.VinNo=arg16;
    this.Exp_Make=arg17;
    this.Exp_Model=arg18;
    this.Exp_Year=arg19;
    
    UrlPage up=new UrlPage(Hooks.driver);
	up.openUrl(Portal);
}

@Given("^Click on Toyota Log in Link for Vin Decoding$")
public void click_on_Log_in_Link_for_Vin_Decoding() throws Throwable {
	LogInPage lip=new LogInPage(Hooks.driver);
	lip.clickLogInLink();
}

@Given("^Login with Toyota UserName and Password for Vin Decoding$")
public void login_with_UserName_and_Password_for_Vin_Decoding() throws Throwable {
	UserNamePasswordPage upp=new UserNamePasswordPage(Hooks.driver);
	upp.userName(UserName);
	upp.password(Password);
	upp.Submit();
}

@Given("^Click on Toyota Agreement Entry Tab for Vin Decoding$")
public void click_on_Agreement_Entry_Tab_for_Vin_Decoding() throws Throwable {
	AgreementTabPage atp=new AgreementTabPage(Hooks.driver);
	atp.agreeTab();
}

@When("^Fill Toyota Product Selection Form for Vin Decoding$")
public void fill_Product_Selection_Form_for_Vin_Decoding() throws Throwable {
	ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
	psp.enterSaleDate();
	psp.selectProduct(Product);
	psp.selectCoverage(Coverage);
	psp.selectTerm(Term);
	psp.submitButton();
}

@When("^Fill Toyota E-Contract Form for Vin Decoding$")
public void fill_E_Contract_Form_for_Vin_Decoding() throws Throwable {
	EContractFormPage ecfp=new EContractFormPage(Hooks.driver);
	ecfp.enterFirstName(FirstName);
	ecfp.enterLastName(LastName);
	ecfp.enterMailAddress(MailingAddress);
	ecfp.enterCity(City);
	ecfp.enterState(State);
	ecfp.enterZip(ZIP);
	ecfp.enterPhone(PhoneNo);
	ecfp.enterVin(VinNo);
	ecfp.vinSearchButton();
	
	
	//Thread.sleep(30000L);
}

@When("^Verify Toyota Make Model and Year for Vin Decoding$")
public void verify_Toyota_Make_Model_and_Year_for_Vin_Decoding() throws Throwable {
	VerifyMakeModelYear vmmy=new VerifyMakeModelYear(Hooks.driver);
	vmmy.makeModelYear(Exp_Make, Exp_Model, Exp_Year, RowNo, Portal, Dealer, VinNo);
}

@Then("^Log Out From Toyota Portal for Vin Decoding$")
public void log_Out_From_Portal_for_Vin_Decoding() throws Throwable {
	LogOutPage lop=new LogOutPage(Hooks.driver);
	lop.logOut();
}

}
