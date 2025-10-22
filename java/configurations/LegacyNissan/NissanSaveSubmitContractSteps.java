package configurations.LegacyNissan;

import java.io.IOException;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import DataBase.DeleteFromTable;
import DataBase.DmsConMOne;
import DataBase.updateDealer;
import DataBase.webConMOneTable;
import configurations.Hooks;
import nissaninfiniti.pageobjects.DealerTaxPage;
import nissaninfiniti.pageobjects.DeclineContractPage;
import nissaninfiniti.pageobjects.EContractConditions;
import nissaninfiniti.pageobjects.EContractMenuPage;
import nissaninfiniti.pageobjects.EContractPage;
import nissaninfiniti.pageobjects.LogOutPage;
import nissaninfiniti.pageobjects.LoginLink;
import nissaninfiniti.pageobjects.ProductSelectionConditions;
import nissaninfiniti.pageobjects.ProductSelectionPage;
import nissaninfiniti.pageobjects.ReturnToListPage;
import nissaninfiniti.pageobjects.SubmitContractPage;
import nissaninfiniti.pageobjects.UrlPage;
import nissaninfiniti.pageobjects.UserNamePasswordPage;
import nissaninfiniti.pageobjects.VerifyDealerCostPage;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;

public class NissanSaveSubmitContractSteps {

	public String write = "No";
	public String webDealerCost = null;
	public String status = "Fail";
	public String[] data = null;
	
	public String TestCase=null;
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
	public String Province=null;
	public String PostalCode=null;
	public String HomePhone=null;
	public String BusPhone=null;
	public String Email=null;
	public String CosignerFirstName=null;
	public String CosignerLastName=null;
	public String CosignerStreetAddress=null;
	public String CosignerCity=null;
	public String CosignerProvince=null;
	public String CosignerPostalCode=null;
	public String CosignerHomePhone=null;
	public String CosignerBusPhone=null;	
	public String VehicleID=null;
	public String Odometer=null;
	public String MSRP_CBB=null;
	public String VehicleType=null;
	public String DecalNumber=null;
	public String CustomerPurchasePrice=null;
	public String CustomerHST_GST=null;
	public String CustomerPST=null;
	public String CustomerQST=null;	
	public String AmountFinanced_LeaseCap=null;
	public String ChooseAssignee=null;
	public String ExpDealerCost=null;
	public String ExpDealerHST_GST=null;
	public String ExpDealerPST=null;
	public String ExpDealerQST=null;	
	public String Deductible=null;
	public String Kilometers=null;
	public String Category=null;
	
	@Given("^Go to Nissan Url as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"  and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"  and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_NissanUrl_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31, String arg32, String arg33, String arg34, String arg35, String arg36, String arg37, String arg38, String arg39, String arg40, String arg41, String arg42, String arg43) throws Throwable {
		
		write = "Yes";
		
		TestCase=arg1;
		Portal=arg2;
		UserName=arg3;
		Password=arg4;
		Dealer=arg5;
		Product=arg6;
		Coverage=arg7;
		Term=arg8;
		FirstName=arg9;
		LastName=arg10;
		StreetAddress=arg11;
		City=arg12;
		Province=arg13;
		PostalCode=arg14;
		HomePhone=arg15;
		BusPhone=arg16;
		Email=arg17;
		CosignerFirstName=arg18;
		CosignerLastName=arg19;
		CosignerStreetAddress=arg20;
		CosignerCity=arg21;
		CosignerProvince=arg22;
		CosignerPostalCode=arg23;
		CosignerHomePhone=arg24;
		CosignerBusPhone=arg25;	
		VehicleID=arg26;
		Odometer=arg27;
		MSRP_CBB=arg28;
		VehicleType=arg29;
		DecalNumber=arg30;
		CustomerPurchasePrice=arg31;
		CustomerHST_GST=arg32;
		CustomerPST=arg33;
		CustomerQST=arg34;	
		AmountFinanced_LeaseCap=arg35;
		ChooseAssignee=arg36;
		ExpDealerCost=arg37;
		ExpDealerHST_GST=arg38;
		ExpDealerPST=arg39;
		ExpDealerQST=arg40;
		Deductible=arg41;
		Kilometers=arg42;
		Category=arg43;
		
		UrlPage up=new UrlPage(Hooks.driver);
	    up.openUrl(Portal);
	}	
	
	@Given("^Click on Nissan Log in Link$")
	public void click_on_Log_in_Link() throws Throwable {
		LoginLink lil=new LoginLink(Hooks.driver);
		lil.clickLogInLink();
	}

	@Given("^Update Nissan cmsid of the dealer$")
	public void update_cmsid_of_the_dealer() throws Throwable {
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}

	@Given("^Login with Nissan UserName and Password$")
	public void login_with_UserName_and_Password() throws Throwable {
		UserNamePasswordPage unpp=new UserNamePasswordPage(Hooks.driver);
		unpp.enterUserName(UserName);
		unpp.enterPassword(Password);
		unpp.clickSubmit();
	}

	@Given("^Click on Nissan Add New E-contract Menu$")
	public void click_on_Add_New_E_contract_Menu() throws Throwable {
		EContractMenuPage ecmp=new EContractMenuPage(Hooks.driver);
		ecmp.clickEContract();
	}

	@When("^Fill Nissan Product Selection Form$")
	public void fill_Product_Selection_Form() throws Throwable {
		ProductSelectionConditions psc=new ProductSelectionConditions();
		psc.productCondation(Category, Product, Coverage, Term);
	}

	@When("^Fill Nissan E-contract Form$")
	public void fill_E_contract_Form() throws Throwable {
		EContractConditions ecc=new EContractConditions();
		if(Category.equalsIgnoreCase("QVGS-CAN")||Category.equalsIgnoreCase("QVGS-FR"))
		{
			ecc.eContractConditionsQVGS(Category, VehicleID, MSRP_CBB, Odometer, Coverage, Deductible, Term, Kilometers, FirstName, LastName, StreetAddress, City, Province, PostalCode, HomePhone, BusPhone, Email, CustomerPurchasePrice, CustomerHST_GST, CustomerQST, CustomerPST);
		} else {			
			ecc.eContractConditions(Category, FirstName, LastName, StreetAddress, City, Province, PostalCode, HomePhone, BusPhone, Email, CosignerFirstName, CosignerLastName, CosignerStreetAddress, CosignerCity, CosignerProvince, CosignerPostalCode, CosignerHomePhone, CosignerBusPhone, VehicleID, Odometer, MSRP_CBB, VehicleType, DecalNumber, CustomerPurchasePrice, CustomerHST_GST, CustomerPST, CustomerQST, AmountFinanced_LeaseCap, ChooseAssignee); //, ExpDealerCost, ExpDealerHST_GST, ExpDealerPST, ExpDealerQST);
			//ecc.eContractConditions(Category, FirstName, LastName, StreetAddress, City, Province, PostalCode, HomePhone, BusPhone, Email, CosignerFirstName, CosignerLastName, CosignerStreetAddress, CosignerCity, CosignerProvince, CosignerPostalCode, CosignerHomePhone, CosignerBusPhone, VehicleID, Odometer, MSRP_CBB, VehicleType, DecalNumber, CustomerPurchasePrice, CustomerHST_GST, CustomerPST, CustomerQST, AmountFinanced_LeaseCap, ChooseAssignee, ExpDealerCost, ExpDealerHST_GST, ExpDealerPST, ExpDealerQST, TestCase, Portal, Dealer, Product, Coverage, Term);
		}
	}

	/*@When("^Verify Dealer Taxation and submit the form$")
	public void verify_Dealer_Taxation_and_submit_the_form() throws Throwable {
		DealerTaxPage dtp = new DealerTaxPage(Hooks.driver);
		dtp.verifyDealerTax(ExpDealerCost, ExpDealerHST_GST, ExpDealerQST, ExpDealerPST, Province, TestCase, Portal, Dealer, VehicleID, Product, Coverage, Term, FirstName, LastName);
		ProductSelectionPage psp = new ProductSelectionPage(Hooks.driver);
		psp.clickSubmit();
	}*/
	
	@When("^Verify Nissan Dealer Taxation$")
	public void verify_Dealer_Taxation() throws Throwable {
		DealerTaxPage dtp = new DealerTaxPage(Hooks.driver);
		dtp.verifyDealerTax(ExpDealerCost, ExpDealerHST_GST, ExpDealerQST, ExpDealerPST, Province, TestCase, Portal, Dealer, VehicleID, Product, Coverage, Term, FirstName, LastName, Category);
	}

	@When("^submit the Nissan form$")
	public void submit_the_form() throws Throwable {
		ProductSelectionPage psp = new ProductSelectionPage(Hooks.driver);
		EContractPage ecp = new EContractPage(Hooks.driver);
		
		if(Category.equalsIgnoreCase("QVGS-CAN")||Category.equalsIgnoreCase("QVGS-FR"))
		{
			ecp.clickContinueBtn4();
		} else {
			psp.clickSubmit();
		}
		
	}
	
	@When("^Click on Return to the list of current Nissan contracts Link$")
	public void click_on_Return_to_the_list_of_current_contracts_Link() throws Throwable {
	    ReturnToListPage rtlp = new ReturnToListPage(Hooks.driver);
	    rtlp.clickReturnTo();
	}

	@When("^Verify Nissan Dealer Cost From Web$")
	public void verify_Dealer_Cost_From_Web() throws Throwable {
	   VerifyDealerCostPage vdcp = new VerifyDealerCostPage(Hooks.driver);
	  data = vdcp.veryfyDealerCost(FirstName, LastName, VehicleID, ExpDealerCost, TestCase, Portal, Dealer, Product, Coverage, Term);
	 
	  webDealerCost = data[0];
	  status = data[1];
	  
	}

	@When("^Verify Nissan Data From DataBase$")
	public void verify_Data_From_DataBase() throws Throwable {
	    webConMOneTable.verifyData(FirstName, LastName, VehicleID, Dealer, TestCase, Portal);
	}

	@When("^Decline Nissan E-contract From Web$")
	public void decline_E_contract_From_Web() throws Throwable {
	   DeclineContractPage dcp = new DeclineContractPage(Hooks.driver);
	   dcp.declineEContract(FirstName, LastName, VehicleID);
	}

	@When("^Delete Nissan Data From WebConMOne$")
	public void delete_Data_From_WebConMOne() throws Throwable {
		try{			
			DeleteFromTable.deleteDataFromWebConM1(FirstName, LastName, VehicleID);
			}catch(Exception e){
				e.getMessage();
			}
	}
	
	@Then("^Log Out From Nissan Portal$")
	public void log_Out_From_Portal() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.clickLogOutLink();
	}
	
	@When("^Verify Nissan Data From WEB CON MONE Table$")
	public void verify_Data_From_WEB_CON_MONE_Table() throws Throwable {
		webConMOneTable.verifyData(FirstName, LastName, VehicleID, Dealer, TestCase, Portal);		
	}

	@When("^Submit Nissan E-contract From Web$")
	public void submit_E_contract_From_Web() throws Throwable {
	    SubmitContractPage scp = new SubmitContractPage(Hooks.driver);
	    scp.submitEContract(FirstName, LastName, VehicleID);
	    scp.clickSubmitAcceptedAgreements();
	}

	@When("^Verify Nissan Data From DMS CON MONE Table$")
	public void verify_Data_From_DMS_CON_MONE_Table() throws Throwable {
	    DmsConMOne.verifyData(FirstName, LastName, VehicleID, Dealer, TestCase, Portal);
	}

	@When("^Delete Nissan Data From Database$")
	public void delete_Data_From_Database() throws Throwable {
		try{
			//DeleteFromTable.deleteData(FirstName, LastName, VehicleID);
			DeleteFromTable.deleteDataFromWebConM1(FirstName, LastName, VehicleID);
			}catch(Exception e){
				e.getMessage();
			}
		
		try{
			//DeleteFromTable.deleteData(FirstName, LastName, VehicleID);
			DeleteFromTable.deleteDataFromDmsConM1(FirstName, LastName, VehicleID);
			}catch(Exception e){
				e.getMessage();
			}
	}
	
	@After
	public void writeResult(){
		
		System.out.println("+++++++++++++++++++++Contract++++++++++++++++++++++"+write);
		
		if (write.equalsIgnoreCase("Yes")) {
			System.out.println("Contract Print######################");
			
			try {
				
				String[] valueToWriteNew=null;
				valueToWriteNew = new String[13];
        		valueToWriteNew[0]=TestCase;
        		valueToWriteNew[1]=Portal;
        		valueToWriteNew[2]=Dealer;
        		valueToWriteNew[3]=VehicleID;
        		valueToWriteNew[4]=Product;
        		valueToWriteNew[5]=Coverage;
        		valueToWriteNew[6]=Term;
        		valueToWriteNew[7]=FirstName;
        		valueToWriteNew[8]=LastName;
        		valueToWriteNew[9]=ExpDealerCost;
        		valueToWriteNew[10]=webDealerCost;
        		valueToWriteNew[11]=status;
        		valueToWriteNew[12]=CurrentDateSelection.getCurrentDate();
        		
        		ExcelReadWrite ERW=new ExcelReadWrite();
        		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "E-Contracting_Result",valueToWriteNew);
			
			} catch (IOException e) {				
				e.printStackTrace();
			}
	
		}
		
	}
	
}
