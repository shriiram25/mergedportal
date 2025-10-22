package configurations.LegacyBMW;

import bmw.pageobjects.DeclinePage;
import bmw.pageobjects.EContractConditions;
import bmw.pageobjects.EContractMenuPage;
import bmw.pageobjects.LogOutPage;
import bmw.pageobjects.LoginLink;
import bmw.pageobjects.ProductSelectionConditions;
import bmw.pageobjects.ReturnToListPage;
import bmw.pageobjects.SubmitContractPage;
import bmw.pageobjects.UrlPage;
import bmw.pageobjects.UserNamePasswordPage;
import bmw.pageobjects.VerifyDealerCostPage;
import configurations.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import DataBase.DeleteFromTable;
import DataBase.DmsConMOne;
import DataBase.updateDealer;
import DataBase.webConMOneTable;

public class LegacyBMWSaveSubmitContractSteps {
	
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
	public String Odometer=null;
	public String VehiclePurchasePrice=null;
	public String VehicleType=null;
	public String ChargeToCustomer=null;
	public String AmountFinanced_LeaseCap=null;
	public String FinancialInstitution=null;
	public String ExpDealerCost=null;
	public String Category=null;
	public String RimSize=null;
	public String Quantity=null;
	public String DOT1=null;
	public String DOT2=null;
	public String DOT3=null;
	public String DOT4=null;
		
	@Given("^Go to BMW Url as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and  \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30) throws Throwable {
	
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
	    this.Odometer=arg17;
	    this.VehiclePurchasePrice=arg18;
	    this.VehicleType=arg19;
	    this.ChargeToCustomer=arg20;
	    this.AmountFinanced_LeaseCap=arg21;
	    this.FinancialInstitution=arg22;
	    this.ExpDealerCost=arg23;
	    this.Category=arg24;
	    this.RimSize=arg25;
	    this.Quantity=arg26;
	    this.DOT1=arg27;
	    this.DOT2=arg28;
	    this.DOT3=arg29;
	    this.DOT4=arg30;
	    
	    UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl(Portal);
	}

	
	@Given("^Click on BMW Log in Link$")
	public void click_on_Log_in_Link() throws Throwable {
		LoginLink lil=new LoginLink(Hooks.driver);
		//lil.clickLogInLink();
		lil.clickLogin();
	}

	@Given("^Update BMW cmsid of the dealer$")
	public void update_cmsid_of_the_dealer() throws Throwable {
		
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
		
	}
	
	@Given("^Login with BMW UserName and Password$")
	public void login_with_UserName_and_Password() throws Throwable {
		
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

	@Given("^Click on BMW Add New E-contract Menu$")
	public void click_on_Add_New_E_contract_Menu() throws Throwable {
		EContractMenuPage ecmp=new EContractMenuPage(Hooks.driver);
		ecmp.clickEContract();
	}

	@When("^Fill BMW Product Selection Form$")
	public void fill_Product_Selection_Form() throws Throwable {
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productConditions(Category, Product, Coverage, Term, RimSize, Quantity, DOT1, DOT2, DOT3, DOT4);
	}

	@When("^Fill BMW E-contract Form$")
	public void fill_E_contract_Form() throws Throwable {
		EContractConditions ecc=new EContractConditions();
		ecc.eContractConditions(Category, FirstName, LastName, StreetAddress, City, State, ZipCode, HomePhone, VehicleID, Odometer, VehiclePurchasePrice, VehicleType, ChargeToCustomer, AmountFinanced_LeaseCap, FinancialInstitution);
	}

	@When("^Click on BMW Return to the list of current contracts Link$")
	public void click_on_Return_to_the_list_of_current_contracts_Link() throws Throwable {
		ReturnToListPage rtlp=new ReturnToListPage(Hooks.driver);
		rtlp.clickReturnTo();
	}

	@When("^Verify BMW Dealer Cost From Web$")
	public void verify_Dealer_Cost_From_Web() throws Throwable {
	    VerifyDealerCostPage vdc=new VerifyDealerCostPage(Hooks.driver);
	    vdc.veryfyDealerCost(LastName, FirstName, VehicleID, ExpDealerCost, Test_Case, Dealer, Product, Coverage, Term, RimSize, Quantity, Portal);
	}

	@When("^Verify BMW Data From DataBase$")
	public void verify_Data_From_DataBase() throws Throwable {
		webConMOneTable.verifyData(FirstName, LastName, VehicleID, Dealer, Test_Case, Portal);
	}

	@When("^Decline BMW E-contract From Web$")
	public void decline_E_contract_From_Web() throws Throwable {
		DeclinePage dp=new DeclinePage(Hooks.driver);
		dp.declineEContract(LastName, FirstName, VehicleID);
	}
	
	@When("^Delete BMW Data From WebConMOne$")
	public void delete_Data_From_WebConMOne() throws Throwable {
		try{			
			DeleteFromTable.deleteDataFromWebConM1(FirstName, LastName, VehicleID);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Then("^Log Out From BMW Portal$")
	public void log_Out_From_Portal() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.clickLogOutLink();
	}
	
	@When("^Verify BMW Data From WEB CON MONE Table$")
	public void verify_Data_From_WEB_CON_MONE_Table() throws Throwable {
		webConMOneTable.verifyData(FirstName, LastName, VehicleID, Dealer, Test_Case, Portal);
	}

	@When("^Submit BMW E-contract From Web$")
	public void submit_E_contract_From_Web() throws Throwable {
		SubmitContractPage scp=new SubmitContractPage(Hooks.driver);
		scp.SubmitEContract(LastName, FirstName, VehicleID);
		scp.clickSubmitAcceptedAgreements();
	}

	@When("^Verify BMW Data From DMS CON MONE Table$")
	public void verify_Data_From_DMS_CON_MONE_Table() throws Throwable {
		DmsConMOne.verifyData(FirstName, LastName, VehicleID, Dealer, Test_Case, Portal);
		/*try{
		DeleteFromTable.deleteData(FirstName, LastName, VehicleID);
		}catch(Exception e){
			e.getMessage();
		}*/
	}
	
	@When("^Delete BMW Data From Database$")
	public void delete_Data_From_Database() throws Throwable {
		
		try{
			DeleteFromTable.deleteDataFromWebConM1(FirstName, LastName, VehicleID);			
		}catch(Exception e){
			e.getMessage();
		}
		
		try{			
			DeleteFromTable.deleteDataFromDmsConM1(FirstName, LastName, VehicleID);
		}catch(Exception e){
			e.getMessage();
		}
	}

}
