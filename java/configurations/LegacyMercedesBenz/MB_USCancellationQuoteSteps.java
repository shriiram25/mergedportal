package configurations.LegacyMercedesBenz;

import DataBase.updateDealer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import MB.*;
import configurations.Hooks;

public class MB_USCancellationQuoteSteps {

	public String Test_Case=null;
	public String UserName=null;
	public String Password=null;
	public String FirstName=null;
	public String LastName=null;
	public String VINNumber=null;
	public String ContractID=null;
	public String CancellationDate=null;
	public String MethodOfCancellation=null;
	public String CustomerCost=null;
	public String CancellationReason=null;
	public String ExpectedFactor=null;
	public String ExpectedDealerRefund=null;
	public String ExpectedCustomerRefund=null;
	public String Dealer=null;
	
	@Given("^Go to MB_US Url for Cancellation Quote as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Cancellation_Quote_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable {
		
		this.Test_Case=arg1;
	    this.UserName=arg2;
	    this.Password=arg3;
	    this.FirstName=arg4;
	    this.LastName=arg5;
	    this.VINNumber=arg6;
	    this.ContractID=arg7;
	    this.CancellationDate=arg8;
	    this.MethodOfCancellation=arg9;
	    this.CustomerCost=arg10;
	    this.CancellationReason=arg11;
	    this.ExpectedFactor=arg12;
	    this.ExpectedDealerRefund=arg13;
	    this.ExpectedCustomerRefund=arg14;
	    this.Dealer=arg15;
	    
	    UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl();
	}

	@Given("^Update MB_US cmsid of the dealer for Cancelation Quote$")
	public void update_cmsid_of_the_dealer_for_Cancelation_Quote() throws Throwable {
		
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Given("^Login with MB_US UserName and Password for Cancellation Quote$")
	public void login_with_UserName_and_Password_for_Cancellation_Quote() throws Throwable {
	    
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@Given("^Click on MB_US Cancellation Quote$")
	public void click_on_Cancellation_Quote() throws Throwable {
	    CancellationQuotePage cqp = new CancellationQuotePage(Hooks.driver);
		cqp.clickECancellationQuote();
	}

	@When("^Fill MB_US Contract Search Form for Cancellation Quote$")
	public void fill_Contract_Search_Form_for_Cancellation_Quote() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.contractSearch(FirstName, LastName, VINNumber, ContractID);		
	}

	@When("^Click on MB_US Cancellation Quote button$")
	public void click_on_Cancellation_Quote_button() throws Throwable {
	    CancellationQuotePage cqp = new CancellationQuotePage(Hooks.driver);
		cqp.clickCancellationQuote();
	}

	@When("^Fill the MB_US Cancellation Quote details$")
	public void fill_the_Cancellation_Quote_details() throws Throwable {
	    CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.cancellationConditions(CancellationDate, MethodOfCancellation, CustomerCost, CancellationReason);
	}

	@When("^Click on MB_US submit button$")
	public void click_on_submit_button() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.ClickSubmit();
	}

	@When("^Verify MB_US Factor Dealer Refund Customer Refund$")
	public void verify_Factor_Dealer_Refund_Customer_Refund() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.matchFactorDRefundCRefund(ExpectedFactor, ExpectedDealerRefund, ExpectedCustomerRefund, Test_Case, Dealer, VINNumber, FirstName, LastName, ContractID);
	}
}
