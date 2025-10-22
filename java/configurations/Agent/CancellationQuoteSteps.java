package configurations.Agent;

import java.io.IOException;

import agents.pageobjects.CancellationQuoteConditions;
import agents.pageobjects.CancellationQuotePage;
import agents.pageobjects.UrlPage;
import agents.pageobjects.UserNamePasswordPage;
import configurations.Hooks;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import DataBase.updateDealer;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;

public class CancellationQuoteSteps {	
	
	public String write = "No";
	public String webFactor = null;
	public String webDRefund = null;
	public String webCRefund = null;
	public String status = "Fail";
	public String[] data = null;
	
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
	
	@Given("^Go to Url for agentCancellation Quote as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_for_Cancellation_Quote_as_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15) throws Throwable {
	    
		write = "Yes";
		
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

	@Given("^Update agentcmsid of the dealer for Cancelation Quote$")
	public void update_cmsid_of_the_dealer_for_Cancelation_Quote() throws Throwable {
	   
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Given("^Login with agentUserName and Password for Cancellation Quote$")
	public void login_with_UserName_and_Password_for_Cancellation_Quote() throws Throwable {
		
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

	@Given("^Click on Cancellation Quote$")
	public void click_on_Cancellation_Quote() throws Throwable {
		CancellationQuotePage cqp = new CancellationQuotePage(Hooks.driver);
		cqp.clickECancellationQuote();
	}

	@When("^Fill Contract Search Form for Cancellation Quote$")
	public void fill_Contract_Search_Form_for_Cancellation_Quote() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.contractSearch(FirstName, LastName, VINNumber, ContractID);		
	}

	@When("^Click on agentCancellation Quote button$")
	public void click_on_Cancellation_Quote_button() throws Throwable {
		CancellationQuotePage cqp = new CancellationQuotePage(Hooks.driver);
		cqp.clickCancellationQuote();
	}

	@When("^Fill the Cancellation Quote details$")
	public void fill_the_Cancellation_Quote_details() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.cancellationConditions(CancellationDate, MethodOfCancellation, CustomerCost, CancellationReason);
	}

	@When("^Click on agentsubmit button$")
	public void click_on_submit_button() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		cqc.ClickSubmit();
	}

	@When("^Verify Factor Dealer Refund Customer Refund$")
	public void verify_Factor_Dealer_Refund_Customer_Refund() throws Throwable {
		CancellationQuoteConditions cqc = new CancellationQuoteConditions();
		data = cqc.matchFactorDRefundCRefund(ExpectedFactor, ExpectedDealerRefund, ExpectedCustomerRefund, Test_Case, Dealer, VINNumber, FirstName, LastName, ContractID);
	
		webFactor = data[0];
		webDRefund = data[1];
		webCRefund = data[2];
		status = data[3];
		
	}

	@After
	public void writeResult(){
		
		System.out.println("+++++++++++++++++++++Cancellation Quote++++++++++++++++++++++"+write);
		
		if (write.equalsIgnoreCase("Yes")) {
			System.out.println("Cancellation Quote Print######################");
			
			try {
				
				String[] valueToWriteNew=null;
				valueToWriteNew = new String[14];
				valueToWriteNew[0]=Test_Case;
				valueToWriteNew[1]=Dealer;
				valueToWriteNew[2]=FirstName;
				valueToWriteNew[3]=LastName;
				valueToWriteNew[4]=ContractID;
				valueToWriteNew[5]=VINNumber;
				valueToWriteNew[6]=webFactor;
				valueToWriteNew[7]=webDRefund;
				valueToWriteNew[8]=webCRefund;
				valueToWriteNew[9]=ExpectedFactor;
				valueToWriteNew[10]=ExpectedDealerRefund;
				valueToWriteNew[11]=ExpectedCustomerRefund;
				valueToWriteNew[12]=status;
				valueToWriteNew[13]=CurrentDateSelection.getCurrentDate();
			
				ExcelReadWrite ERW=new ExcelReadWrite();
				ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "Cancellation_Quote_Result",valueToWriteNew);
				
				} catch (IOException e) {				
				e.printStackTrace();
			}
	
		}
		
	}
	
}
