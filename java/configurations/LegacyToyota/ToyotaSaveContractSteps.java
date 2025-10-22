package configurations.LegacyToyota;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.PGAdminConnection;
import utility.Report;
import DataBase.DmsConMOne;
import Toyota.*;
import configurations.Hooks;
import utility.Log;

public class ToyotaSaveContractSteps {
	
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
	public String Odometer=null;
	public String VechicleType=null;
	public String FinanceType=null;
	public String LineHolderName=null;
	public String AgreementPurchasePrice=null;
	public String ExpectedDealerCost=null;
	public String RowNo=null;
	
	DealerCostPage dcp;
	
	@Given("^Go to Toyota Url as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22) throws Throwable {
	    
		this.Portal=arg1;
		this.UserName=arg2;
		this.Password=arg3;
		this.Dealer=arg4;
		this.Product=arg5;
		this.Coverage=arg6;
		this.Term=arg7;
		this.FirstName=arg8;
		this.LastName=arg9;
		this.MailingAddress=arg10;
		this.City=arg11;
		this.State=arg12;
		this.ZIP=arg13;
		this.PhoneNo=arg14;
		this.VinNo=arg15;
		this.Odometer=arg16;
		this.VechicleType=arg17;
		this.FinanceType=arg18;
		this.LineHolderName=arg19;
		this.AgreementPurchasePrice=arg20;
		this.ExpectedDealerCost=arg21;
		this.RowNo=arg22;
		
		UrlPage up=new UrlPage(Hooks.driver);
		
		up.openUrl(Portal);
		
		//Log.log.debug(Hooks.webUrl+" is open");
	}
	
	@Given("^Click on Toyota Log in Link$")
	public void click_on_Log_in_Link() throws Throwable {
		LogInPage lip=new LogInPage(Hooks.driver);
		lip.clickLogInLink();
	}

	@Given("^Login with Toyota UserName and Password$")
	public void login_with_UserName_and_Password() throws Throwable {
		UserNamePasswordPage upp=new UserNamePasswordPage(Hooks.driver);
		upp.userName(UserName);
		upp.password(Password);
		upp.Submit();
	}

	@Given("^Click on Toyota Agreement Entry Tab$")
	public void click_on_Agreement_Entry_Tab() throws Throwable {
		AgreementTabPage atp=new AgreementTabPage(Hooks.driver);
		atp.agreeTab();
	}
	@Given("^Click on Toyota Add New E-contract Link$")
	public void click_on_Add_New_E_contract_Link() throws Throwable {
		AddNewEContract anec=new AddNewEContract(Hooks.driver);
		anec.eContracting();
		anec.addEContract();		
		//Thread.sleep(10000L);
	}

	@When("^Fill Toyota Product Selection Form$")
	public void fill_Product_Selection_Form() throws Throwable {
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		psp.enterSaleDate();
		psp.selectProduct(Product);
		psp.selectCoverage(Coverage);
		psp.selectTerm(Term);
		psp.submitButton();
		
		//Thread.sleep(10000L);
	}

	@When("^Fill Toyota E-Contract Form$")
	public void fill_E_Contract_Form() throws Throwable {
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
		ecfp.enterOdometer(Odometer);
		ecfp.selectVehicleType(VechicleType);
		ecfp.selectFinanceType(FinanceType);
		ecfp.enterLienName(LineHolderName);
		ecfp.enterCustCost(AgreementPurchasePrice);		
	}
	
	//<<<Created separate step for saving the contract.>>>//
	@When("^Save the Toyota E-Contract$")
	public void saveTheForm() throws Throwable {
		EContractFormPage ecfp=new EContractFormPage(Hooks.driver);
		ecfp.saveAgreement();		
	}
	
	@When("^Click on Return to the Toyota list of current contracts Link$")
	public void click_on_Return_to_the_list_of_current_contracts_Link() throws Throwable {
		ReturnToTheListPage rttlp=new ReturnToTheListPage(Hooks.driver);
		rttlp.clickReturnTo();
	}

	@When("^Verify Toyota Dealer Cost From Web$")
	public void verify_Dealer_Cost_From_Web() throws Throwable {
		dcp=new DealerCostPage(Hooks.driver);
		dcp.verifyDealerCost(FirstName, LastName, VinNo, ExpectedDealerCost, RowNo, Portal, Dealer, Product, Coverage, Term);
	}

	@When("^Verify Toyota Data From Data Base$")
	public void verify_Data_From_Data_Base() throws Throwable {
		PGAdminConnection.dataBaseConnection(FirstName, LastName, VinNo, Dealer, Portal, RowNo);
	}

	@When("^Decline Toyota E-Contract From Web$")
	public void decline_E_Contract_From_Web() throws Throwable {		
		dcp.decline();
	}

	@Then("^Log Out From Toyota Portal$")
	public void log_Out_From_Portal() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.logOut();
	}

	@When("^Submit E-Contract From Web$")
	public void submit_E_Contract_From_Web() throws Throwable {
		dcp.submit();			
	}

	//<<<Created separate step for verify_Data_From_dms_con_m1_Table.>>>//
	@When("^Verify Toyota Data From dms_con_m(\\d+) Table$")
	public void verify_Data_From_dms_con_m_Table(int arg1) throws Throwable {			
		DmsConMOne.verifyData(FirstName, LastName, VinNo, RowNo, Portal, Dealer);
	}

	@After
	public void generateReport(){
		Report.reportHTML();
	}

}
