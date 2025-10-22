package configurations.LegacyMercedesBenz;

import java.io.IOException;

import DataBase.DeleteFromTable;
import DataBase.DmsConMOne;
import DataBase.updateDealer;
import DataBase.webConMOneTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import MB.*;
import configurations.Hooks;
import utility.Log;

public class SaveSubmitContractMB_USSteps {

	public String write = "No";
	public String webDealerCost = null;
	public String status = "Fail";
	public String[] data = null;	
	
	public String Test_Case=null;
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
	public String VehicleType=null;
	public String ChargeToCustomer=null;
	public String ExpDealerCost=null;
	public String Category=null;
	
	@Given("^Go to MB_US Url as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19) throws Throwable {
	    
		write = "Yes";
		
		this.Test_Case=arg1;
	    this.UserName=arg2;
	    this.Password=arg3;
	    this.Dealer=arg4;
	    this.Product=arg5;
	    this.Coverage=arg6;
	    this.Term=arg7;
	    this.FirstName=arg8;
	    this.LastName=arg9;
	    this.StreetAddress=arg10;
	    this.City=arg11;
	    this.State=arg12;
	    this.ZipCode=arg13;
	    this.HomePhone=arg14;
	    this.VehicleID=arg15;
	    this.VehicleType=arg16;
	    this.ChargeToCustomer=arg17;
	    this.ExpDealerCost=arg18;
	    this.Category=arg19;
		
	    UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl();
	}

	@Given("^Click on MB_US Log in Link$")
	public void click_on_Log_in_Link() throws Throwable {
		LoginLink lil=new LoginLink(Hooks.driver);
		lil.clickLogInLink();		
	}
	
	@Given("^Update MB_US cmsid of the dealer$")
	public void update_cmsid_of_the_dealer() throws Throwable {
		
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
		
	}

	@Given("^Login with MB_US UserName and Password$")
	public void login_with_UserName_and_Password() throws Throwable {
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@Given("^Click on MB_US Add New E-contract Menu$")
	public void click_on_Add_New_E_contract_Menu() throws Throwable {
		EContractMenuPage ecmp=new EContractMenuPage(Hooks.driver);
		ecmp.clickEContract();
	}

	@When("^Fill MB_US Product Selection Form$")
	public void fill_Product_Selection_Form() throws Throwable {
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productCondition(Category, Product, Coverage, Term);
		
	}

	@When("^Fill MB_US E-contract Form$")
	public void fill_E_contract_Form() throws Throwable {
		EContractConditions ecc=new EContractConditions();
		ecc.eContractConditions(Category, FirstName, LastName, StreetAddress, City, State, ZipCode, HomePhone, VehicleID, VehicleType, ChargeToCustomer);
		
	}

	@When("^Save the MB_US contract$")
	public void submit_the_form_for_MB_CA() throws Throwable {		
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		psp.clickSubmit();
	}
	
	@When("^Click on Return to the list of MB_US current contracts Link$")
	public void click_on_Return_to_the_list_of_current_contracts_Link() throws Throwable {
		ReturnToListPage rtlp=new ReturnToListPage(Hooks.driver);
		rtlp.clickReturnTo();
	}

	@When("^Verify MB_US Dealer Cost From Web$")
	public void verify_Dealer_Cost_From_Web() throws Throwable {
		VerifyDealerCostPage vdcp=new VerifyDealerCostPage(Hooks.driver);
		data = vdcp.veryfyDealerCost(LastName, FirstName, VehicleID, ExpDealerCost, Test_Case, Dealer, Product, Coverage, Term);
	
		webDealerCost = data[0];
		status = data[1];
	}

	@When("^Verify MB_US Data From DataBase$")
	public void verify_Data_From_DataBase() throws Throwable {
		webConMOneTable.verifyDataWebCon(FirstName, LastName, VehicleID, Dealer, Test_Case);
	}

	@When("^Decline MB_US E-contract From Web$")
	public void decline_E_contract_From_Web() throws Throwable {
		DeclineContractPage dp=new DeclineContractPage(Hooks.driver);
		dp.declineEContract(LastName, FirstName, VehicleID);
	}
	
	@When("^Delete MB_US Data From WebConMOne$")
	public void delete_Data_From_WebConMOne() throws Throwable {
		try{			
			DeleteFromTable.deleteDataFromWebConM1(FirstName, LastName, VehicleID);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Then("^Log Out From MB_US Portal$")
	public void log_Out_From_Portal() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.clickLogOutLink();
		
	}

	@When("^Verify MB_US Data From WEB CON MONE Table$")
	public void verify_Data_From_WEB_CON_MONE_Table() throws Throwable {
		webConMOneTable.verifyDataWebCon(FirstName, LastName, VehicleID, Dealer, Test_Case);
	}

	@When("^Submit MB_US E-contract From Web$")
	public void submit_E_contract_From_Web() throws Throwable {
		SubmitContractPage sp = new SubmitContractPage(Hooks.driver);
		sp.submitEContract(LastName, FirstName, VehicleID);
		sp.clickSubmitAcceptedAgreements();
	}

	@When("^Verify MB_US Data From DMS CON MONE Table$")
	public void verify_Data_From_DMS_CON_MONE_Table() throws Throwable {
		DmsConMOne.verifyData(FirstName, LastName, VehicleID, Dealer, Test_Case);		
	}
	
	@When("^Delete MB_US Data From Database$")
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
	
	@After
	public void writeResult(){
		
		System.out.println("+++++++++++++++++++++Contract US++++++++++++++++++++++"+write);
		
		if (write.equalsIgnoreCase("Yes")) {
			System.out.println("Contract US Print######################");
			
			try {
				
				String[] valueToWriteNew=null;
				valueToWriteNew = new String[12];
        		valueToWriteNew[0]=Test_Case;
        		valueToWriteNew[1]=Dealer;
        		valueToWriteNew[2]=VehicleID;
        		valueToWriteNew[3]=Product;
        		valueToWriteNew[4]=Coverage;
        		valueToWriteNew[5]=Term;
        		valueToWriteNew[6]=FirstName;
        		valueToWriteNew[7]=LastName;
        		valueToWriteNew[8]=ExpDealerCost;
        		valueToWriteNew[9]=webDealerCost;
        		valueToWriteNew[10]=status;
        		valueToWriteNew[11]=CurrentDateSelection.getCurrentDate();
        		
        		ExcelReadWrite ERW=new ExcelReadWrite();
        		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "MB_US_EContract_Result",valueToWriteNew);
			
			} catch (IOException e) {				
				e.printStackTrace();
			}	
		}		
	}
	
}
