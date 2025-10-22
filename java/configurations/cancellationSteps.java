package configurations;

import DataBase.updateDealer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import AutoNation.*;

public class cancellationSteps {
	
	public String Test_Case=null;
	public String UserName=null;
	public String Password=null;
	public String Dealer=null;
	public String FirstName=null;
	public String LastName=null;
	public String Vin=null;
	public String ContractNumber=null;
	public String CancellationDate=null;
	public String MethodOfCancellation=null;
	public String CustomerCost=null;
	public String CancellationReason=null;
	public String Exp_Factor=null;
	public String Exp_CustomerRefund=null;
	public String End_Mileage=null;
	
	@Given("^Go to Url for Cancellation Quote as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Cancellation_Quote_as_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable {
	    
		this.Test_Case=arg1;
		this.UserName=arg2;
		this.Password=arg3;
		this.Dealer=arg4;
		this.FirstName=arg5;
		this.LastName=arg6;
		this.Vin=arg7;
		this.ContractNumber=arg8;
		this.CancellationDate=arg9;
		this.MethodOfCancellation=arg10;
		this.CustomerCost=arg11;
		this.CancellationReason=arg12;
		this.Exp_Factor=arg13;
		this.Exp_CustomerRefund=arg14;
		this.End_Mileage=arg15;
		
		
		urlPage up=new urlPage(Hooks.driver);
		up.goToUrl();
	}

	@Given("^Click on Log in Link for Cancellation Quote$")
	public void click_on_Log_in_Link_for_Cancellation_Quote() throws Throwable {
	   
		logInLinkPage lilp=new logInLinkPage(Hooks.driver);
		lilp.logInLinkClick();
	}
		
	@Given("^Update cmsid of the dealer for Cancelation Quote$")
	public void update_cmsid_of_the_dealer_for_Cancelation_Quote() throws Throwable {
	    
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}

	
	@Given("^Login with UserName and Password for Cancellation Quote$")
	public void login_with_UserName_and_Password_for_Cancellation_Quote() throws Throwable {
		
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

	@Given("^Click on ANCancellation Quote Menu$")
	public void click_on_Cancellation_Quote_Menu() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.clickCanQuote();
	}

	@Given("^Fill the Contract Search Form$")
	public void fill_the_Contract_Search_Form() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.enterFirstName(FirstName);
		cqp.enterLastName(LastName);
		cqp.enterVinNo(Vin);
	}

	@Given("^Click on ANSubmit button$")
	public void click_on_Submit_button() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.clickSubmitButton();
	}

	@When("^Click on a Contract$")
	public void click_on_a_Contract() throws Throwable {
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.clickContract(ContractNumber);
	}

	@When("^Click on Cancellation Quote button$")
	public void click_on_Cancellation_Quote_button() throws Throwable {
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.clickQuoteButton();
	}

	@When("^Fill the required data for Cancellation Quote$")
	public void fill_the_required_data_for_Cancellation_Quote() throws Throwable {
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.enterDate(CancellationDate);
		cqp.clickMethod(MethodOfCancellation);
		cqp.enterCustCost(CustomerCost);
		cqp.enterMileage(End_Mileage);
		cqp.selectReason(CancellationReason);
		cqp.ClickQuoteSubmitButton();
	}

	@When("^verify Factor and Customer Refund$")
	public void verify_Factor_and_Customer_Refund() throws Throwable {
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.verifyFactorAndCustRef(Exp_Factor, Exp_CustomerRefund, Test_Case, Dealer, FirstName, LastName, Vin, ContractNumber, CancellationDate, MethodOfCancellation, CustomerCost, CancellationReason);
	}

	@Then("^Log Out from Portal for Cancellation Quote$")
	public void log_Out_from_Portal_for_Cancellation_Quote() throws Throwable {
		logOutPage lop=new logOutPage(Hooks.driver);
		lop.logOut();
	}


}
