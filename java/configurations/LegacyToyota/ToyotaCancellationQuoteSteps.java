package configurations.LegacyToyota;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Log;
import configurations.Hooks; 
import Toyota.*;

public class ToyotaCancellationQuoteSteps {
	
	public String RowNo=null;
	public String Portal=null;
	public String UserName=null;
	public String Password=null;
	public String Dealer=null;
	public String FirstName=null;
	public String LastName=null;
	public String VinNo=null;
	public String Can_Date=null;
	public String Cust_Cost=null;
	public String Exp_Factor=null;
	public String Exp_CancellationFee=null;
	public String Exp_CustomerRefund=null;
	public String AgreementNumber=null;
	
	
	@Given("^Go to Toyota Url for Cancellation Quote as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Cancellation_Quote_as_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14) throws Throwable {
	   this.RowNo=arg1;
	   this.Portal=arg2;
	   this.UserName=arg3;
	   this.Password=arg4;
	   this.Dealer=arg5;
	   this.FirstName=arg6;
	   this.LastName=arg7;
	   this.VinNo=arg8;
	   this.Can_Date=arg9;
	   this.Cust_Cost=arg10;
	   this.Exp_Factor=arg11;
	   this.Exp_CancellationFee=arg12;
	   this.Exp_CustomerRefund=arg13;
	   this.AgreementNumber=arg14;
	   
	   UrlPage up=new UrlPage(Hooks.driver);
		up.openUrl(Portal);
	}

	@Given("^Click on Toyota Log in Link for Cancellation Quote$")
	public void click_on_Log_in_Link_for_Cancellation_Quote() throws Throwable {
		LogInPage lip=new LogInPage(Hooks.driver);
		lip.clickLogInLink();
	}

	@Given("^Login with Toyota UserName and Password for Cancellation Quote$")
	public void login_with_UserName_and_Password_for_Cancellation_Quote() throws Throwable {
		UserNamePasswordPage upp=new UserNamePasswordPage(Hooks.driver);
		upp.userName(UserName);
		upp.password(Password);
		upp.Submit();
	}

	@Given("^Click on Toyota Cancellation Quote Tab$")
	public void click_on_Cancellation_Quote_Tab() throws Throwable {
		CancellationQuotePage cqp=new CancellationQuotePage(Hooks.driver);
		cqp.cancellationQuote();
	}

	@Given("^Fill Toyota Customer Search Form$")
	public void fill_Customer_Search_Form() throws Throwable {
		CustomerSearchPage csp=new CustomerSearchPage(Hooks.driver);
		csp.enterFirst(FirstName);
		csp.enterLast(LastName);
		csp.enterVinNumber(VinNo);
		csp.clickSearch();
	}

	@When("^Verify Toyota Factor Cancellation Fee and Customer Refund$")
	public void verify_Factor_Cancellation_Fee_and_Customer_Refund() throws Throwable {
		VerifyCancellationQuote vcq=new VerifyCancellationQuote(Hooks.driver);
		vcq.verifyCancellQuote(Can_Date, Cust_Cost, Exp_Factor, Exp_CancellationFee, Exp_CustomerRefund, RowNo, Portal, Dealer, FirstName, LastName, VinNo);
	}

	@Then("^Log Out From Toyota Portal for Cancellation Quote$")
	public void log_Out_From_Portal_for_Cancellation_Quote() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.logOut();
				
	}

}
