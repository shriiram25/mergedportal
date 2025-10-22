package configurations;

import DataBase.updateAgent;
import DataBase.updateDealer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import AutoNation.*;

public class cancellSteps {
	
	public String Test_Case=null;
	public String UserName=null;
	public String Password=null;
	public String Agent=null;
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
	
	@Given("^Go to Url for Cancellations as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Cancellations_as_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14) throws Throwable {
	    
		this.Test_Case=arg1;
		this.UserName=arg2;
		this.Password=arg3;
		this.Agent=arg4;
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
		
		
		urlPage up=new urlPage(Hooks.driver);
		up.goToUrl();
	}

	@Given("^Click on Log in Link for Cancellations$")
	public void click_on_Log_in_Link_for_Cancellations() throws Throwable {
		
		logInLinkPage lilp=new logInLinkPage(Hooks.driver);
		lilp.logInLinkClick();
	}

	@Given("^Update cmsid of the dealer for Cancelations$")
	public void update_cmsid_of_the_dealer_for_Cancelations() throws Throwable {
	    
		try{
			updateAgent.dataBaseConnectionAgent(Agent, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}	

	@Given("^Login with UserName and Password for Cancellations$")
	public void login_with_UserName_and_Password_for_Cancellations() throws Throwable {
		
		/*try{
			updateAgent.dataBaseConnectionAgent(Agent, UserName);
		}catch(Exception e){
			e.getMessage();
		}*/
		
		
		userNamePasswordPage unpp=new userNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@Given("^Fill the Contract Search Form for Cancellations$")
	public void fill_the_Contract_Search_Form_for_Cancellations() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.enterFirstName(FirstName);
		cqp.enterLastName(LastName);
		cqp.enterVinNo(Vin);
	}

	@When("^Click on a Contract for Cancellations$")
	public void click_on_a_Contract_for_Cancellations() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.clickContract(ContractNumber);
	}

	@When("^Fill the required data for Cancellations$")
	public void fill_the_required_data_for_Cancellations() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.enterDate(CancellationDate);
		cqp.clickMethod(MethodOfCancellation);
		cqp.enterCustCost(CustomerCost);
		cqp.selectReason(CancellationReason);
		cqp.ClickQuoteSubmitButton();
	}

	@When("^verify Factor and Customer Refund for Cancellations$")
	public void verify_Factor_and_Customer_Refund_for_Cancellations() throws Throwable {
		
		cancellationQuotePage cqp=new cancellationQuotePage(Hooks.driver);
		cqp.verifyFactorAndCustRef(Exp_Factor, Exp_CustomerRefund, Test_Case, Agent, FirstName, LastName, Vin, ContractNumber, CancellationDate, MethodOfCancellation, CustomerCost, CancellationReason);
	
	}

	@Then("^Log Out from Portal for Cancellations$")
	public void log_Out_from_Portal_for_Cancellations() throws Throwable {
		
		logOutPage lop=new logOutPage(Hooks.driver);
		lop.logOut();
	}
	
	@When("^Click on Complete Cancellation and Verify Message$")
	public void click_on_Complete_Cancellation_and_Verify_Message() throws Throwable {
		logOutPage lop=new logOutPage(Hooks.driver);
		lop.compCanButton();
		
	}

}
