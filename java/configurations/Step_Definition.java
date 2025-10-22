package configurations;

import java.io.IOException;

import org.junit.Assert;

import configurations.Hooks;
import AutoNation.addNewRemittancePage;
import AutoNation.dealOrLastSevenCondation;
import AutoNation.deleteRemitFromWeb;
import AutoNation.logInLinkPage;
import AutoNation.logOutPage;
import AutoNation.rateAndRemitPage;
import AutoNation.remitContractFromWeb;
import AutoNation.remittanceCondation;
import AutoNation.urlPage;
import AutoNation.userNamePasswordPage;
import AutoNation.verifyProductCostPage;
import DataBase.updateDealer;
import DataBase.webConMOneTable;
import DataBase.webRemittanceRecordsTable;
import alphera.CustomerDetailsPage_Alphera;
import alphera.LienholderInfoPage_Alphera;
import alphera.ProductPage_Alphera;
import alphera.VehicleInfoPage_Alphera;
import bmm.CustomerDetailsPage_bmm;
import bmm.DealerTaxPage_bmm;
import bmm.LienholderInfoPage_bmm;
import bmm.ProductPage_bmm;
import bmm.VehicleInfoPage_bmm;
//<<<--import BMW.Hooks;
//<<<--import BMWPageObject.EASAddNewContractPage;
//<<<--import CucumberPBLAutomation.PBLHooks;
//<<<--import PBLPageObject.PBLSelectProductPage;
//<<<--import CucumberEASAutomation.EASHooks;
//<<<--import EASPageObject.EASProductPage;
import commonFunctions.AddNewContractPage;
import commonFunctions.E_ContractingPage;
import commonFunctions.LoginPage;
import commonFunctions.LogoutPage;
import commonFunctions.SubmitEcontractPage;
import commonFunctions.SummaryPage;
import commonFunctions.UrlMapping;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fuccillo.CustomerDetailsPage_Fuccillo;
import fuccillo.LienholderInfoPage_Fuccillo;
import fuccillo.ProductPage_Fuccillo;
import fuccillo.VehicleInfoPage_Fuccillo;
import harley_Canada.CustomerDetailsPage_Harley_Canada;
import harley_Canada.DealerTaxPage_Harley_Canada;
import harley_Canada.LienholderInfoPage_Harley_Canada;
import harley_Canada.ProductPage_Harley_Canada;
import harley_Canada.VehicleInfoPage_Harley_Canada;
import harley_US.CustomerDetailsPage_Harley_us;
import harley_US.LienholderInfoPage_Harley_us;
import harley_US.ProductPage_Harley_us;
import harley_US.VehicleInfoPage_Harley_us;
import honda.CustomerDetailsPage_honda;
import honda.DealerTaxPage_honda;
import honda.LienholderInfoPage_honda;
import honda.ProductPage_honda;
import pbl_Canada.CustomerDetailsPage_PBL_Canada;
import pbl_Canada.DealerTaxPage_PBL_Canada;
import pbl_Canada.LienholderInfoPage_PBL_Canada;
import pbl_Canada.ProductPage_PBL_Canada;
import pbl_Canada.VehicleInfoPage_PBL_Canada;
import pbl_US.CustomerDetailsPage_PBL_us;
import pbl_US.LienholderInfoPage_PBL_us;
import pbl_US.ProductPage_PBL_us;
import pbl_US.VehicleInfoPage_PBL_us;
import penske.CustomerDetailsPage_Penske;
import penske.LienholderInfoPage_Penske;
import penske.ProductPage_Penske;
import penske.VehicleInfoPage_Penske;
import rollsRoyce.CustomerDetailsPage_RollsRoyce;
import rollsRoyce.LienholderInfoPage_RollsRoyce;
import rollsRoyce.ProductPage_RollsRoyce;
import rollsRoyce.VehicleInfoPage_RollsRoyce;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.Report;
import vci.CustomerDetailsPage_VCI;
import vci.LienholderInfoPage_VCI;
import vci.ProductPage_VCI;
import vci.VehicleInfoPage_VCI;
import vroom.CustomerDetailsPage_Vroom;
import vroom.LienholderInfoPage_Vroom;
import vroom.ProductPage_Vroom;
import vroom.VehicleInfoPage_Vroom;

public class Step_Definition {

	public String write = "No";

	public String functionality = "";

	public String status = "";
	public String[] data = null;
	public String actualCost = "";

	public String TestCase = null;
	public String Portal = null;
	public String Dealer = null;
	public String Language = null;
	public String UserName = null;
	public String Password = null;
	public String Captcha = null;
	public String Vin = null;
	public String Term = null;
	public String Product = null;
	public String Plan = null;
	public String TermMiles = null;
	public String Deductible = null;
	public String odometer = null;
	public String DealerCost = null;
	public String FirstName = null;
	public String LastName = null;
	public String Province = null;
	public boolean statuslogin = false;
	public String loginStatus = "Fail";
	public String vinDecodeStatus = "Fail";
	
	
	//<<<--Below parameters have been used only for the Canadian portals
	public String customerAgreementLanguage = null;
	public String CustomerCost=null;
	public String CustomerGST=null;
	public String CustomerHST=null;
	public String CustomerPST=null;
	public String CustomerQST=null;	
	
	public String ExpDealerCost=null;
	public String ExpDealerGST=null;
	public String ExpDealerHST=null;
	public String ExpDealerPST=null;
	public String ExpDealerQST=null;
	public String ExpDealerCostTotal=null;
	
	public static String webDealerCost = null;
    //<<<--	public static String webDealerCostTotal = "";
	public static String webDealerGST = null;
	public static String webDealerHST = null;
	public static String webDealerQST = null;
	public static String webDealerPST = null;
	//<<<--public String DealerProvince = null;
	public static String dealerTaxError = null;
	public static String customerTaxError = null;
	public static String dealerTaxStatus = null;	
	public static String customerTaxStatus = null;
	public static String finalStatus = null;
	public static String taxPopup = null;
	
	//below data's  are only for legacy	

	public String Test_Case=null;
	//public String UserName=null;
	//public String Password=null;
	//public String Dealer=null;
	public String DealNumber_OR_Last7Vin=null;
	public String Full_VIN=null;
	public String Lienholder=null;
	//public String Product=null;
	public String Coverage=null;
	//public String Term=null;
	public String Finance_Amount=null;
	public String VehicleSalesPrice=null;
	public String ReferenceNumber=null;
	public String TermMileage=null;
	public String CustomerRetail=null;
	public String Address=null;
	public String City=null;
	public String State=null;
	public String Zip=null;
	public String VehicleCondition=null;
	public String PaymentType=null;
	public String Exp_Product_Cost=null;
	public String Category=null;
	public String Odometer=null;
	public String MSRP=null;
	public String Email=null;
	public String HomePhone=null;
	public String WorkPhone=null;
	@Given("^Go to url with data as \"(.*?)\" and \"(.*?)\" and \"(.*?)\"and \"(.*?)\"$")
	public void go_to_url_with_data_as_and_and_and(String TestCase, String Portal, String Language, String Dealer)
			throws 
			Throwable {

		write = "Yes";
		this.TestCase = TestCase;
		this.Portal = Portal.toUpperCase();
		this.Language = Language;
		this.Dealer = Dealer;
		
	

		UrlMapping url = new UrlMapping(Hooks.driver);
		//<<<-- Launch URL
		url.openUrl(Portal);

		if (Language.contains("English")) {
			LoginPage elp = new LoginPage(Hooks.driver);
			elp.Select_Language(Language);
		}
	}

	@Given("^Select Language \"(.*?)\"$")
	public void Select_Language(String language) {
		LoginPage elp = new LoginPage(Hooks.driver);
		elp.Select_Language(language);
	}

	
	@Given("^Verifying the funtionality of \"(.*?)\"$")
	public void verifying_the_funtionality_of(String functionality) throws Throwable {
		this.functionality = functionality;
	}
	
	//autonation data 
	
	@Given("^Go to AUrl as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_as_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16, String arg17, String arg18, String arg19, String arg20, String arg21, String arg22, String arg23, String arg24, String arg25, String arg26, String arg27, String arg28, String arg29, String arg30, String arg31) throws Throwable {
	
		this.Test_Case=arg1;
		this.UserName=arg2;
		this.Password=arg3;
		this.Dealer=arg4;
		this.DealNumber_OR_Last7Vin=arg5;
		this.Full_VIN=arg6;
		this.Lienholder=arg7;
		this.Product=arg8;
		this.Coverage=arg9;
		this.Term=arg10;
		this.Finance_Amount=arg11;
		this.VehicleSalesPrice=arg12;
		this.ReferenceNumber=arg13;
		this.TermMileage=arg14;
		this.Deductible=arg15;
		this.CustomerRetail=arg16;
		this.FirstName=arg17;
		this.LastName=arg18;
		this.Address=arg19;
		this.City=arg20;
		this.State=arg21;
		this.Zip=arg22;
		this.VehicleCondition=arg23;
		this.PaymentType=arg24;
		this.Exp_Product_Cost=arg25;
		this.Category=arg26;
		this.Odometer=arg27;
		this.MSRP=arg28;
		this.Email=arg29;
		this.HomePhone=arg30;
		this.WorkPhone=arg31;

		urlPage up=new urlPage(Hooks.driver);
		up.goToUrl();
					
	}

	
	@Given("^Login as \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void login_as_and_and(String UserName, String Password, String Captcha) throws Throwable {

		this.UserName = UserName;
		this.Password = Password;

		LoginPage elp = new LoginPage(Hooks.driver);

		//<<<-- Input UserID, Password and click Login
		
		elp.userID(UserName);
		elp.userPassword(Password);
		statuslogin = elp.clickLogin();
		
		if (statuslogin) {
			loginStatus = "Pass";
		} 
		else {
			loginStatus = "Fail";
			Assert.assertTrue(false);
		}
	}

	@When("^Click on add New eContract$")
	public void click_Econ_menu() throws Throwable {

		E_ContractingPage ecp = new E_ContractingPage(Hooks.driver);

		//<<<-- Select Add New Contract
		 
		//<<<-- Seperated condition for BMW CAN Portals - Create new eContract 
		if ( Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("VOLKSWAGEN") || Portal.contains("AUDI") || Portal.contains("DUCATI") || Portal.contains("QUALITYPROTECT")) { 
			ecp.econMenuVCI();
		}

		else if (Portal.contains("ALPHERA")) {
			//ecp.eSubmissions();
			//ecp.addNewEsubmission();
			ecp.eSubsMenuLink();
			
		}

		else if (Portal.contains("ROLLSROYCE")) {
			//ecp.eSubmissionMenu();
			//ecp.addSubmissionbtn();
			ecp.eSubmissionMenuLink();
			
		}
		
		//<<<-- Added condition for BMW CAN Portals - Create new eContract 
		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD") ) {			
			ecp.econMenuLinkBMW();			
		}
		

		else {
			//ecp.econMenu();
			//ecp.addContractbtn();
			ecp.econMenuLink();
		}

	}

	@When("^Decode the VIN \"(.*?)\"$")
	public void decode_by_vinnumber(String Vin) throws Throwable {
		this.Vin = Vin;

		AddNewContractPage ncp = new AddNewContractPage(Hooks.driver);

		//<<<-- Enter VIN number and click VinDecode button
		ncp.vinCode(Vin);
		boolean statusOfVinDecode = ncp.vinDecode();
		
		if (statusOfVinDecode) {
			vinDecodeStatus = "Pass";
		} 
		else {
			vinDecodeStatus = "Fail";
			Assert.assertTrue(false);
		}

	}

	@When("^Enter contract purchase information \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void enterdetails_and_and_and_and_and_and_and_and(String Vin, String Trim, String inservicedate,
			String ContractPurchaseDate, String Vehicle_Purchase, String Vehicle_Purchase_Date, String Vehicle_condtion,
			String FinanceType, String odometer, String province) throws Throwable {
		this.odometer = odometer;
		this.Province = province;

		
		//<<<-- Enter Details on Add New Contract page
		AddNewContractPage ncp = new AddNewContractPage(Hooks.driver);
		
		ncp.vinCodeTrim(Trim, Vin);
		
		if ((Portal.contains("VOLKSWAGEN") || Portal.contains("AUDI"))) {
			ncp.inServiceDateVSCVW(inservicedate);
		}
		else if ((!Portal.contains("ALPHERA")) && (!Portal.contains("HARLEY_US"))) {
			ncp.inServiceDateVSC(inservicedate);
		}
		 
		
		
		ncp.contractDate(ContractPurchaseDate);

		/*if (Portal.contains("HARLEY_CANADA") || Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD") || Portal.contains("PORSCHE_CANADA")|| Portal.contains("BENTLEY_CANADA")|| Portal.contains("LAMBORGHINI_CANADA")|| Portal.contains("CANADA")|| Portal.contains("HONDA")|| Portal.contains("ACURA")) {
			if (province.length() == 2)
				//<<<-- province conversion into Full Name
				ncp.convertProvinceInFullNameAndSelect(province);
			else
				ncp.selectProvince(province);
		}*/
		
		ncp.isVehiclePurchase(Vehicle_Purchase, Vehicle_Purchase_Date);
		ncp.vehicleCondition(Vehicle_condtion);
		if (Portal.contains("HARLEY_CANADA") || Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD") || Portal.contains("PORSCHE_CANADA")|| Portal.contains("BENTLEY_CANADA")|| Portal.contains("LAMBORGHINI_CANADA")|| Portal.contains("CANADA")|| Portal.contains("HONDA")|| Portal.contains("ACURA")) {
			if (province.length() == 2)
				//<<<-- province conversion into Full Name
				ncp.convertProvinceInFullNameAndSelect(province);
			else
				ncp.selectProvince(province);
		}
		ncp.financeType(FinanceType);
		ncp.odoMeter(odometer);
		ncp.getProduct();

	}

	@When("^Select product and get rates \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void getprice_and_and_and_and_and_and_and(String Product, String BundleSelection, String Plan, String Term,
			String TermMiles, String Deductible, String RetailPrice, String DealerCost, String firstServiceInterval,
			String finalServiceInterval, String registrationCode) throws Throwable {
		
		this.Product = Product;
		this.Term = Term;
		this.Plan = Plan;
		this.TermMiles = TermMiles;
		this.DealerCost = DealerCost;
		this.Deductible = Deductible;

		//<<<-- Select Product, verify DealerCost and ActualCost, Enter RetailCost
	

		if (Portal.contains("VCI")) {
			ProductPage_VCI ppvc = new ProductPage_VCI(Hooks.driver);
			ppvc.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}
		
		else if (Portal.contains("VROOM")) {			
			ProductPage_Vroom ppvr = new ProductPage_Vroom(Hooks.driver);
			ppvr.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}

		else if (Portal.contains("FUCCILLO")) {
			ProductPage_Fuccillo ppfu = new ProductPage_Fuccillo(Hooks.driver);
			ppfu.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}

		else if (Portal.contains("ALPHERA")) {
			ProductPage_Alphera ppal = new ProductPage_Alphera(Hooks.driver);
			ppal.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}

		else if (Portal.contains("HARLEY_US")) {
			ProductPage_Harley_us pphaus = new ProductPage_Harley_us(Hooks.driver);
			pphaus.selectProductHDUS(Product, Plan, Term, TermMiles, Deductible, DealerCost, RetailPrice,firstServiceInterval, finalServiceInterval, registrationCode);
		}

		
		else if (Portal.contains("ROLLSROYCE")) {
			ProductPage_RollsRoyce pprr = new ProductPage_RollsRoyce(Hooks.driver);
			pprr.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}

		else if (Portal.contains("PENSKE")) {
			ProductPage_Penske pppk = new ProductPage_Penske(Hooks.driver);
			pppk.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, DealerCost);
		}

		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
			ProductPage_bmm ppbmm = new ProductPage_bmm(Hooks.driver);
			ppbmm.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
			ProductPage_Harley_Canada pphaca = new ProductPage_Harley_Canada(Hooks.driver);
			pphaca.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, firstServiceInterval, finalServiceInterval, registrationCode);
		}
		
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")) {
			ProductPage_PBL_us pppblus = new ProductPage_PBL_us(Hooks.driver);
			pppblus.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, firstServiceInterval, finalServiceInterval, registrationCode);
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")) {
			ProductPage_PBL_Canada pppblca = new ProductPage_PBL_Canada(Hooks.driver);
			pppblca.selectProduct(Product, BundleSelection, Plan, Term, TermMiles, Deductible, firstServiceInterval, finalServiceInterval, registrationCode);
		}
		
		else if (Portal.contains("HONDA") || Portal.contains("ACURA")) {
			ProductPage_honda pph = new ProductPage_honda(Hooks.driver);
			pph.selectProduct(Product, Plan, Term, TermMiles);
		}
	}

	@When("^Verify Dealer Cost and Retail Price \"(.*?)\" and \"(.*?)\"$")
	public void VerifyDealerCostandRetailPrice(String DealerCost, String RetailPrice)

	throws Throwable {

		this.DealerCost = DealerCost;

		//<<<-- Select Product, verify DealerCost and ActualCost, Enter RetailCost
		if (Portal.contains("VCI")) {
			ProductPage_VCI ppvc = new ProductPage_VCI(Hooks.driver);
			data = ppvc.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			ppvc.selectRetailCost(RetailPrice);
			ppvc.createContract(Plan);
		}
		
		else if (Portal.contains("VROOM")) {
			ProductPage_Vroom ppvr = new ProductPage_Vroom(Hooks.driver);
			data = ppvr.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			ppvr.selectRetailCost(RetailPrice);
			ppvr.createContract();
		}

		else if (Portal.contains("FUCCILLO")) {
			ProductPage_Fuccillo ppfu = new ProductPage_Fuccillo(Hooks.driver);
			data = ppfu.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			ppfu.selectRetailCost(RetailPrice);
			ppfu.createContract(Product);
		}

		else if (Portal.contains("ALPHERA")) {
			ProductPage_Alphera ppal = new ProductPage_Alphera(Hooks.driver);
			data = ppal.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			ppal.selectRetailCost(RetailPrice);
			ppal.createContract();
		}

		else if (Portal.contains("ROLLSROYCE")) {
			ProductPage_RollsRoyce pprr = new ProductPage_RollsRoyce(Hooks.driver);
			data = pprr.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			pprr.selectRetailCost(RetailPrice);
			pprr.createContract(Product);
		}

		else if (Portal.contains("PENSKE")) {
			ProductPage_Penske pppk = new ProductPage_Penske(Hooks.driver);
			data = pppk.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			pppk.selectRetailCost(RetailPrice);
			pppk.createContract();
		}
		
		else if (Portal.contains("HARLEY_US")) {
			ProductPage_Harley_us pphaus = new ProductPage_Harley_us(Hooks.driver);
			data = pphaus.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			pphaus.selectRetailCost(RetailPrice);
			pphaus.createContractHDUS(Product);
		}
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")) {
			ProductPage_PBL_us pppblus = new ProductPage_PBL_us(Hooks.driver);
			data = pppblus.selectDealerCost(DealerCost);
			actualCost = data[0];
			status = data[1];
			pppblus.selectRetailCost(RetailPrice);
			pppblus.createContract(Product);

		}	

	}

	@When("^Verify Dealer Cost and Candian Taxation \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void VerifyDealerCostAndCandianTaxation(String DealerCost, String ExpDealerHST, String ExpDealerGST, String ExpDealerPST, String ExpDealerQST, String ExpDealerCostTotal  )

	throws Throwable {

		this.DealerCost = DealerCost;
		this.ExpDealerHST = ExpDealerHST;
		this.ExpDealerGST = ExpDealerGST;
		this.ExpDealerPST = ExpDealerPST;
		this.ExpDealerQST = ExpDealerQST;


		//<<<-- Select Product, verify DealerCost and ActualCost, Enter RetailCost
		if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
		
			DealerTaxPage_bmm dtpbmm = new DealerTaxPage_bmm(Hooks.driver);
			dtpbmm.verifyDealerTax(DealerCost, ExpDealerHST,ExpDealerGST, ExpDealerQST, ExpDealerPST,ExpDealerCostTotal);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
		
			DealerTaxPage_Harley_Canada dtphaca = new DealerTaxPage_Harley_Canada(Hooks.driver);
			dtphaca.verifyDealerTax(DealerCost, ExpDealerHST,ExpDealerGST, ExpDealerQST, ExpDealerPST,ExpDealerCostTotal);
				
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")) {
			
			DealerTaxPage_PBL_Canada dtppblca = new DealerTaxPage_PBL_Canada(Hooks.driver);
			dtppblca.verifyDealerTax(DealerCost, ExpDealerHST,ExpDealerGST, ExpDealerQST, ExpDealerPST,ExpDealerCostTotal);
				
		}
		
		if (Portal.contains("HONDA") || Portal.contains("ACURA")) {
			
			DealerTaxPage_honda dtph = new DealerTaxPage_honda(Hooks.driver);
			dtph.verifyDealerTax(DealerCost, ExpDealerHST,ExpDealerGST, ExpDealerQST, ExpDealerPST,ExpDealerCostTotal);
		}

	}

	
	@When("^Verify Customer Cost and Candian Taxation \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void VerifyCustomerCostAndCandianTaxation(String CustomerCost, String CustomerHST, String CustomerGST, String CustomerPST, String CustomerQST, String ExpTotalCustomerCost)

	throws Throwable {

		this.CustomerCost = CustomerCost;

		//<<<-- Select Product, verify DealerCost and ActualCost, Enter RetailCost
		if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
		
			DealerTaxPage_bmm dtpbmm = new DealerTaxPage_bmm(Hooks.driver);
			dtpbmm.inputCustomerCostAndTax(CustomerCost, CustomerHST,CustomerGST, CustomerPST, CustomerQST,ExpTotalCustomerCost, Product);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
			
			DealerTaxPage_Harley_Canada dtphaca = new DealerTaxPage_Harley_Canada(Hooks.driver);
			dtphaca.inputCustomerCostAndTax(CustomerCost, CustomerHST,CustomerGST, CustomerPST, CustomerQST,ExpTotalCustomerCost);
			
			ProductPage_Harley_Canada pphaca = new ProductPage_Harley_Canada(Hooks.driver);
			pphaca.createContract(Product);
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")) {
			
			//<<<-- Will implement this in future.
			/*DealerTaxPage_PBL_Canada dtppblca = new DealerTaxPage_PBL_Canada(Hooks.driver);
			dtppblca.inputCustomerCostAndTax(CustomerCost, CustomerHST,CustomerGST, CustomerPST, CustomerQST,ExpTotalCustomerCost);*/
			
			ProductPage_PBL_Canada pppblca = new ProductPage_PBL_Canada(Hooks.driver);
			pppblca.createContract(Product);
		}
		
		if (Portal.contains("HONDA") || Portal.contains("ACURA")) {

			//<<<-- Verifying Customer Cost and Taxes.
			DealerTaxPage_honda dtph = new DealerTaxPage_honda(Hooks.driver);
			dtph.verifyCustomerCostAndTax(CustomerCost, CustomerHST,CustomerGST, CustomerPST, CustomerQST,ExpTotalCustomerCost);
			
			ProductPage_honda pph = new ProductPage_honda(Hooks.driver);
			pph.createContract();
		}

	}	
	

	@When("^Enter customer details \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void enterCustomerDetails(
			String isThisaBussiness, String customerAgreementLanguage, String BussinessName, String FirstName, String LastName, String Address,
			String PostalCode, String PhoneNumber1, String EmailAddress, String CoSigner, String cosFirstName,
			String cosLastName, String cosAddress, String cosPostalCode, String cosPhoneNumber1, String cosEmailAddress,
			String Product) throws Throwable {
		this.FirstName = FirstName;
		this.LastName = LastName;

		//<<<-- Enter Customer details
		if (Portal.contains("VROOM")) {
			CustomerDetailsPage_Vroom cdpvr = new CustomerDetailsPage_Vroom(Hooks.driver);
			cdpvr.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdpvr.address(Address);
			cdpvr.zip(PostalCode);
			cdpvr.phone(PhoneNumber1);
			cdpvr.email(EmailAddress);
			cdpvr.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdpvr.continueBtn(Product);
		}

		else if (Portal.contains("VCI"))
										
		{
			CustomerDetailsPage_VCI cdpvc = new CustomerDetailsPage_VCI(Hooks.driver);
			cdpvc.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdpvc.address(Address);
			cdpvc.zip(PostalCode);
			cdpvc.phone(PhoneNumber1);
			cdpvc.email(EmailAddress);
			cdpvc.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdpvc.continueBtn(Product);
		}

		else if (Portal.contains("FUCCILLO")) {
			CustomerDetailsPage_Fuccillo cdpfu = new CustomerDetailsPage_Fuccillo(Hooks.driver);
			cdpfu.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdpfu.address(Address);
			cdpfu.zip(PostalCode);
			cdpfu.phone(PhoneNumber1);
			cdpfu.email(EmailAddress);
			cdpfu.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdpfu.continueBtn();

		}

		else if (Portal.contains("ALPHERA")) {
			CustomerDetailsPage_Alphera cdpal = new CustomerDetailsPage_Alphera(Hooks.driver);
			cdpal.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdpal.address(Address);
			cdpal.zip(PostalCode);
			cdpal.phone(PhoneNumber1);
			cdpal.email(EmailAddress);
			cdpal.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdpal.continueBtn(Product);

		}

		else if (Portal.contains("HARLEY_US")) {
			CustomerDetailsPage_Harley_us cdphaus = new CustomerDetailsPage_Harley_us(Hooks.driver);
			cdphaus.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdphaus.address(Address);
			cdphaus.zip(PostalCode);
			cdphaus.phone(PhoneNumber1);
			cdphaus.email(EmailAddress);
			//cdphaus.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdphaus.continueBtn(Product);

		}

		
		else if (Portal.contains("ROLLSROYCE")) {
			CustomerDetailsPage_RollsRoyce cdprr = new CustomerDetailsPage_RollsRoyce(Hooks.driver);
			cdprr.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdprr.address(Address);
			cdprr.zip(PostalCode);
			cdprr.phone(PhoneNumber1);
			cdprr.email(EmailAddress);
			cdprr.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdprr.continueBtn(Product);

		}

		else if (Portal.contains("PENSKE")) {
			CustomerDetailsPage_Penske cdppk = new CustomerDetailsPage_Penske(Hooks.driver);
			cdppk.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdppk.address(Address);
			cdppk.zip(PostalCode);
			cdppk.phone(PhoneNumber1);
			cdppk.email(EmailAddress);
			cdppk.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdppk.continueBtn(Product);
		}

		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
			CustomerDetailsPage_bmm cdpbmm = new CustomerDetailsPage_bmm(Hooks.driver);
			cdpbmm.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdpbmm.selectCustomerAgreementLanguage(customerAgreementLanguage);
			cdpbmm.address(Address);
			cdpbmm.zip(PostalCode);
			cdpbmm.phone(PhoneNumber1);
			cdpbmm.email(EmailAddress);
			cdpbmm.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdpbmm.continueBtn(Product);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
			CustomerDetailsPage_Harley_Canada cdphaca = new CustomerDetailsPage_Harley_Canada(Hooks.driver);
			cdphaca.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdphaca.selectCustomerAgreementLanguage(customerAgreementLanguage);
			cdphaca.address(Address);
			cdphaca.zip(PostalCode);
			cdphaca.phone(PhoneNumber1);
			cdphaca.email(EmailAddress);
			//cdphaca.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdphaca.continueBtn(Product);
		}
		
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")) {
			CustomerDetailsPage_PBL_us cdppblus = new CustomerDetailsPage_PBL_us(Hooks.driver);
			cdppblus.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdppblus.address(Address);
			cdppblus.zip(PostalCode);
			cdppblus.phone(PhoneNumber1);
			cdppblus.email(EmailAddress);
			cdppblus.isCosigner(CoSigner, cosFirstName, cosLastName,cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdppblus.continueBtn(Product);
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")) {
			CustomerDetailsPage_PBL_Canada cdppblca = new CustomerDetailsPage_PBL_Canada(Hooks.driver);
			cdppblca.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdppblca.selectCustomerAgreementLanguage(customerAgreementLanguage);
			cdppblca.address(Address);
			cdppblca.zip(PostalCode);
			cdppblca.phone(PhoneNumber1);
			cdppblca.email(EmailAddress);
			cdppblca.isCosigner(CoSigner, cosFirstName, cosLastName,cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdppblca.continueBtn(Product);
		}

		else if (Portal.contains("HONDA") || Portal.contains("ACURA")) {
			CustomerDetailsPage_honda cdph = new CustomerDetailsPage_honda(Hooks.driver);
			cdph.isBussiness(isThisaBussiness, BussinessName, FirstName, LastName);
			cdph.selectCustomerAgreementLanguage(customerAgreementLanguage);
			cdph.address(Address);
			cdph.zip(PostalCode);
			cdph.phone(PhoneNumber1);
			cdph.email(EmailAddress);
			cdph.isCosigner(CoSigner, cosFirstName, cosLastName, cosAddress, cosPostalCode, cosPhoneNumber1, cosEmailAddress);
			cdph.continueBtn(Product);
		}
	}

	@When("^Enter vehicle purchase price and finance info \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and  \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void get_Vehicle_info_and_and_and_and_and(String Product, String VehicleMSRP, String FinanceAmount,
			String APR, String GrossCapCost, String Vehicleprice) throws Throwable {

		VehicleInfoPage_Vroom vipvr = new VehicleInfoPage_Vroom(Hooks.driver);
		VehicleInfoPage_VCI vipvci = new VehicleInfoPage_VCI(Hooks.driver);
		VehicleInfoPage_Fuccillo vipf = new VehicleInfoPage_Fuccillo(Hooks.driver);
		VehicleInfoPage_Alphera vipal = new VehicleInfoPage_Alphera(Hooks.driver);
		VehicleInfoPage_Harley_us viphaus = new VehicleInfoPage_Harley_us(Hooks.driver);
		VehicleInfoPage_Harley_Canada viphaca = new VehicleInfoPage_Harley_Canada(Hooks.driver);
		VehicleInfoPage_RollsRoyce viprr = new VehicleInfoPage_RollsRoyce(Hooks.driver);
		VehicleInfoPage_Penske vippk = new VehicleInfoPage_Penske(Hooks.driver);
		VehicleInfoPage_bmm vipbmm = new VehicleInfoPage_bmm(Hooks.driver);
		VehicleInfoPage_PBL_us vippblus = new VehicleInfoPage_PBL_us(Hooks.driver);
		VehicleInfoPage_PBL_Canada vippblca = new VehicleInfoPage_PBL_Canada(Hooks.driver);

		//<<<-- Enter vehicle Info
		if (Portal.contains("VROOM")) {
			vipvr.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, VehicleMSRP);
		}

		else if (Portal.contains("VCI")) {
			vipvci.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);

		} 
		else if (Portal.contains("FUCCILLO")) {
			vipf.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);

		}

		else if (Portal.contains("ALPHERA")) {
			vipal.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);

		}

		else if (Portal.contains("HARLEY_US")) {
			viphaus.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);

		}

		 else if (Portal.contains("ROLLSROYCE")) {
			viprr.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}

		else if (Portal.contains("PENSKE")) {
			vippk.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}

		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
			vipbmm.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
			viphaca.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")) {
			vippblus.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")) {
			vippblca.entervehicleinfo(Product, VehicleMSRP, FinanceAmount, APR, GrossCapCost, Vehicleprice);
		}
	}

	
	@When("^Select Lienholder \"(.*?)\" and \"(.*?)\"$")
	public void get_Lienholder_info(String Lienholder, String Product) throws Throwable {

		LienholderInfoPage_VCI lhipvc = new LienholderInfoPage_VCI(Hooks.driver);
		LienholderInfoPage_Vroom lhipvr = new LienholderInfoPage_Vroom(Hooks.driver);
		LienholderInfoPage_Fuccillo lhipfu = new LienholderInfoPage_Fuccillo(Hooks.driver);
		LienholderInfoPage_Alphera lhipal = new LienholderInfoPage_Alphera(Hooks.driver);
		LienholderInfoPage_Harley_us lhiphaus = new LienholderInfoPage_Harley_us(Hooks.driver);
		LienholderInfoPage_Harley_Canada lhiphaca = new LienholderInfoPage_Harley_Canada(Hooks.driver);
		LienholderInfoPage_RollsRoyce lhiprr = new LienholderInfoPage_RollsRoyce(Hooks.driver);
		LienholderInfoPage_Penske lhippk = new LienholderInfoPage_Penske(Hooks.driver);
		LienholderInfoPage_bmm lhipbmm = new LienholderInfoPage_bmm(Hooks.driver);
		LienholderInfoPage_PBL_us lhippblus = new LienholderInfoPage_PBL_us(Hooks.driver);
		LienholderInfoPage_PBL_Canada lhippblca = new LienholderInfoPage_PBL_Canada(Hooks.driver);
		//<<<-- Enter Lien Holder details
		if (Portal.contains("VCI")) {
			
			if (!Product.contains("LEASE")) {
				lhipvc.lienHolder(Lienholder);
			}
		}
		
		else if (Portal.contains("VROOM")) {
			lhipvr.lienHolder(Lienholder);
		} 
		
		else if (Portal.contains("FUCCILLO")) {
			lhipfu.lienHolder(Lienholder);
		}

		else if (Portal.contains("ALPHERA")) {
			lhipal.lienHolder(Lienholder);
		}

		else if (Portal.contains("HARLEY_US")) {
			lhiphaus.lienHolder(Lienholder, Product);
		}

		else if (Portal.contains("ROLLSROYCE")) {
			lhiprr.lienHolder(Lienholder, Product);
		}

		else if (Portal.contains("PENSKE")) {
			lhippk.lienHolder(Lienholder);
			//<<<-- if(!Product.contains("LEASE")){
			//<<<-- lhipp.lienHolder(Lienholder);
		}

		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
			lhipbmm.lienHolder(Lienholder);
		}
		
		else if (Portal.contains("HARLEY_CANADA")) {
			lhiphaca.lienHolder(Lienholder, Product);
		}
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")){
			lhippblus.lienHolder(Lienholder, Product);
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")){
			lhippblca.lienHolder(Lienholder, Product);
		}
		//<<<-- Will implement this in future for HONDA ACURA
		else {
			Thread.sleep(1000L);
		}
	}

	
	@When("^Save the contract$")
	public void save_the_form() throws Throwable {
		LienholderInfoPage_VCI lhipvci = new LienholderInfoPage_VCI(Hooks.driver);
		LienholderInfoPage_Vroom lhipvroom = new LienholderInfoPage_Vroom(Hooks.driver);
		LienholderInfoPage_Fuccillo lhipfuccillo = new LienholderInfoPage_Fuccillo(Hooks.driver);
		LienholderInfoPage_Alphera lhipal = new LienholderInfoPage_Alphera(Hooks.driver);
		LienholderInfoPage_Harley_us liphdus = new LienholderInfoPage_Harley_us(Hooks.driver);
		LienholderInfoPage_Harley_Canada liphdca = new LienholderInfoPage_Harley_Canada(Hooks.driver);
		LienholderInfoPage_RollsRoyce lhiprr = new LienholderInfoPage_RollsRoyce(Hooks.driver);
		LienholderInfoPage_Penske lippk = new LienholderInfoPage_Penske(Hooks.driver);
		LienholderInfoPage_bmm lipbmm = new LienholderInfoPage_bmm(Hooks.driver);
		LienholderInfoPage_PBL_us lhpblus = new LienholderInfoPage_PBL_us(Hooks.driver);
		LienholderInfoPage_PBL_Canada lhpblca = new LienholderInfoPage_PBL_Canada(Hooks.driver);
		LienholderInfoPage_honda liph = new LienholderInfoPage_honda(Hooks.driver);
		
		//<<<-- Click Save and Add Button

		 
		if (Portal.contains("VCI")) {
			lhipvci.saveAndAddProduct();
		} 
		
		else if (Portal.contains("VROOM")) {
			lhipvroom.saveAndAddProduct();
		}
		
		else if (Portal.contains("FUCCILLO")) {
			lhipfuccillo.saveAndAddProduct();
		}

		else if (Portal.contains("ALPHERA")) {
			lhipal.saveAndAddProduct();
		}

		else if (Portal.contains("HARLEY_US")) {
			liphdus.saveAndAddProduct();
		}

		else if (Portal.contains("HARLEY_CANADA")) {
			liphdca.saveAndAddProduct();
		}

		else if (Portal.contains("ROLLSROYCE")) {
			lhiprr.saveAndAddProduct();
		}

		else if (Portal.contains("PENSKE")) {
			lippk.saveAndAddProduct();
		}

		else if (Portal.contains("BMW_MINI") || Portal.contains("MOTORRAD")) {
			lipbmm.saveAndAddProduct();
		}
		
		else if (Portal.contains("PORSCHE_US") || Portal.contains("BENTLEY_US") || Portal.contains("LAMBORGHINI_US")) {
			lhpblus.saveAndAddProduct();
		}
		
		else if (Portal.contains("PORSCHE_CANADA") || Portal.contains("BENTLEY_CANADA") || Portal.contains("LAMBORGHINI_CANADA")){
			lhpblca.saveAndAddProduct();
		}
		
		else if (Portal.contains("HONDA") || Portal.contains("ACURA")) {
			liph.saveAndAddProduct();
		}
	}

	@When("^Go to the summary page$")
	public void go_to_summary() throws Throwable {

		SummaryPage esp = new SummaryPage(Hooks.driver);
		//<<<-- Click Go Summary button
		esp.goSummary();
	}

	//<<<-- Created new step to click Manage Saved eContracts button
	@When("^Click on Manage Saved eContracts$")
	public void click_on_Manage_Saved_eContracts() throws Throwable {
		
		SummaryPage esp = new SummaryPage(Hooks.driver);
		//<<<-- Click Manage Saved eContracts button
		esp.clickManageSavedEContracts();
	}

	//<<<-- Created new step to select Saved eContract
	@When("^Select the contract with Last Name \"(.*?)\", VIN \"(.*?)\", Product \"(.*?)\" and Portal \"(.*?)\"$")
	public void select_the_contract_with_Last_Name_VIN_Product(String LastName, String VIN, String Product, String Portal) throws Throwable {
		SubmitEcontractPage sep = new SubmitEcontractPage(Hooks.driver);
		//<<<-- Click the check box of the eContarct
		sep.selectContract(LastName, VIN, Product, Portal);
	}

	//<<<-- Created new step to Submit eContract
	@When("^Submit the contract$")
	public void submit_the_contract() throws Throwable {
		SubmitEcontractPage sep = new SubmitEcontractPage(Hooks.driver);
		//<<<-- Click Sbbmit selected EContarcts button
		sep.clickSubmitEContract();
		//<<<-- Click OK on the Pop Up
		sep.clickSubmitEContractsPopUp();
	}
	
	@Then("^Logout out from the portal$")
	public void logout_from_portal() throws Throwable {

		LogoutPage elp = new LogoutPage(Hooks.driver);

		//<<<-- Click Logout link
		elp.logout();
	}
	
	// legacy
	
	@Given("^Click on Log in Link$")
	public void click_on_Log_in_Link() throws Throwable {
		logInLinkPage lilp=new logInLinkPage(Hooks.driver);
		Thread.sleep(2000);
		lilp.logInLinkClick();
	}	
	
	@Given("^Update cmsid of the dealer$")
	public void update_cmsid_of_the_dealer() throws Throwable {
		
		try{
			updateDealer.dataBaseConnection(Dealer, UserName);
		}catch(Exception e){
			e.getMessage();
		}
	}
	
	@Given("^Login with UserName and Password$")
	public void login_with_UserName_and_Password() throws Throwable {
		
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

	@Given("^Click on Rate and Remit Link$")
	public void click_on_Rate_and_Remit_Link() throws Throwable {
		rateAndRemitPage rar = new rateAndRemitPage(Hooks.driver);
		rar.rateAndRemit();
	}

	@When("^Fill Remittance Form$")
	public void fill_Remittance_Form() throws Throwable {
		addNewRemittancePage anrp=new addNewRemittancePage(Hooks.driver);
		anrp.addRemittance();
		
		if(DealNumber_OR_Last7Vin.equalsIgnoreCase(""))
		{
			remittanceCondation rc=new remittanceCondation();

			rc.remCon(Category, Full_VIN, Product, Coverage, Term, Finance_Amount, CustomerRetail, FirstName, LastName, Address, City, State, Zip, VehicleCondition, PaymentType, VehicleSalesPrice, ReferenceNumber, Lienholder, Odometer, MSRP, Email, HomePhone, WorkPhone );

		}else{
			dealOrLastSevenCondation dolsvc=new dealOrLastSevenCondation();
			dolsvc.dealCondation(Category, DealNumber_OR_Last7Vin, Product, Coverage, Term, CustomerRetail, VehicleSalesPrice, ReferenceNumber, Finance_Amount, FirstName, LastName);
		}
	}

	/*@When("^Click on Rate and Remit Link$")
	public void click_on_Rate_and_Remit_Link() throws Throwable {
		System.out.println("6");
	}*/

	@When("^Verify Product Cost From Web$")
	public void verify_Product_Cost_From_Web() throws Throwable {
		verifyProductCostPage vpcp=new verifyProductCostPage(Hooks.driver);
		vpcp.verifyCost(Exp_Product_Cost, Test_Case, Dealer, Full_VIN, Product, Coverage, Term, FirstName, LastName);
	}

	@When("^Verify Data From Data Base$")
	public void verify_Data_From_Data_Base() throws Throwable {
		webRemittanceRecordsTable.verifyData(FirstName, LastName, Full_VIN, Dealer, Test_Case);
	}

	@When("^Delete Contract From Web$")
	public void delete_Contract_From_Web() throws Throwable {
		deleteRemitFromWeb drfw=new deleteRemitFromWeb(Hooks.driver);
		drfw.deleteRem();
	}
		
	@Then("^Log Out From Portal$")
	public void log_Out_From_Portal() throws Throwable {
		logOutPage lop=new logOutPage(Hooks.driver);
		lop.logOut();
	}


	@When("^Remit Contract From Web$")
	public void remit_Contract_From_Web() throws Throwable {
		remitContractFromWeb rcfw=new remitContractFromWeb(Hooks.driver);
		rcfw.remitContract();
		rcfw.paySelectIcon();
	}

	@When("^Verify Data From Web_Con_M(\\d+) Table$")
	public void verify_Data_From_Web_Con_M_Table(int arg1) throws Throwable {
		webConMOneTable.verifyDataWebCon(FirstName, LastName, Full_VIN, Dealer, Test_Case);
	}


	
	
	
	
	
	
	
	@After(" @SaveContract_Canadian_portal_QUICK_Regression , @SaveContract__US_portal_QUICK_Regression , @SaveContract_Fuccillo_PROD , @SaveContract_Vroom_PROD , @SaveContract_BMW-MINI_PROD , @SaveContract_HONDA-ACURA_PROD , @SaveContract_RollsRoyce_PROD , @SaveContract_Penske_PROD , @SaveContract_HD_CA_PROD , @SaveContract_HD_US_PROD , @SaveContract_VCI_PROD , @SaveContract_PBL_CANADA_QA , @SaveContract_PBL_US_QA, @SaveContract_VCI_QA_2 , @SaveContract_HD_US_PROD , @SaveContract_HD_CA_PROD , @SaveContract_HONDA-ACURA_PROD, @SaveContract_RollsRoyce_PROD, @SaveContract_Vroom_PROD, @SaveContract_VCI_PROD, @SaveContract_PBL_CANADA_PROD, @SaveContract_PBL_US_PROD, @SaveContract_Penske_PROD, @SaveContract_Fuccillo_PROD , @SubmitContract__US_portal_QUICK_Regression , @SubmitContract_Canadian_portal_QUICK_Regression  ")
	//@After("
		//	 " "+ 
			// "")
	public void writeResult() {

		System.out.println("+++++++++++++++++++++Contract++++++++++++++++++++++" + write);

		if (functionality.equalsIgnoreCase("Login")) {
			if (write.equalsIgnoreCase("Yes")) {
				//<<<--System.out.println("Contract Print######################");

				try {

					String[] valueToWriteNew = null;
					valueToWriteNew = new String[5];

					valueToWriteNew[0] = TestCase;
					valueToWriteNew[1] = Portal;
					valueToWriteNew[2] = Dealer;
					valueToWriteNew[3] = UserName;
					valueToWriteNew[4] = loginStatus;
					
					ExcelReadWrite erw = new ExcelReadWrite();
					erw.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "Login_Status_Report", valueToWriteNew);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} 
		else if (functionality.equalsIgnoreCase("VIN_Decoding")) {
				
				if (write.equalsIgnoreCase("Yes")) {
				//<<<--System.out.println("Contract Print######################");

				try {

					String[] valueToWriteNew = null;
					valueToWriteNew = new String[6];

					valueToWriteNew[0] = TestCase;
					valueToWriteNew[1] = Portal;
					valueToWriteNew[2] = Dealer;
					valueToWriteNew[3] = UserName;
					valueToWriteNew[4] = Vin;
					valueToWriteNew[5] = vinDecodeStatus;
					ExcelReadWrite erw = new ExcelReadWrite();
					erw.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "VIN_Decoding_Report", valueToWriteNew);
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		else {
					
				if (Language.contains("Canada")){
					if (write.equalsIgnoreCase("Yes")) {
					System.out.println("Contract Print######################");

					try {

						String[] valueToWriteNew = null;
						valueToWriteNew = new String[29];

						valueToWriteNew[0] = TestCase;
						valueToWriteNew[1] = Portal;
						valueToWriteNew[2] = Dealer;
						valueToWriteNew[3] = UserName;
						valueToWriteNew[4] = Vin;
						valueToWriteNew[5] = FirstName;
						valueToWriteNew[6] = LastName;
						valueToWriteNew[7]= Province;
						valueToWriteNew[8] = Product;
						valueToWriteNew[9] = Plan;
						valueToWriteNew[10] = Term;
						valueToWriteNew[11] = TermMiles;
						valueToWriteNew[12] = odometer;
						valueToWriteNew[13] = Deductible;
						//valueToWriteNew[14] = DealerCost;
						//valueToWriteNew[15] = actualCost;
						valueToWriteNew[14]= DealerCost;
						valueToWriteNew[15]= webDealerCost;
						valueToWriteNew[16]= ExpDealerHST;
						valueToWriteNew[17]= webDealerHST;
						valueToWriteNew[18]= ExpDealerGST;				 
						valueToWriteNew[19]= webDealerGST;
						valueToWriteNew[20]= ExpDealerPST;
						valueToWriteNew[21]= webDealerPST;
						valueToWriteNew[22]= ExpDealerQST;
						valueToWriteNew[23]= webDealerQST;
						valueToWriteNew[24]= finalStatus;
						valueToWriteNew[25]=CurrentDateSelection.getCurrentDate();
						valueToWriteNew[26]=dealerTaxError;
						valueToWriteNew[27]=customerTaxError;				
						valueToWriteNew[28]=taxPopup;
									

					ExcelReadWrite erw = new ExcelReadWrite();

					//<<<-- Publish Report in US and Canada Portal sheets
					erw.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "Canada_Portal_Report", valueToWriteNew);
					
					
					//<<<<--- WE NEED TO REMOVE BELOW PATAMETERS IN OUR ENHANCEMENT PHASE.
					Step_Definition.webDealerCost = "";
					//public static String webDealerCostTotal = "";
					Step_Definition.webDealerGST = "";
					Step_Definition.webDealerHST = "";
					Step_Definition.webDealerQST = "";
					Step_Definition.webDealerPST = "";
					//public String DealerProvince = "";
					Step_Definition.dealerTaxError = "";
					Step_Definition.customerTaxError = "";
					//Step_Definition.dealerTaxStatus = "";	
					Step_Definition.finalStatus = "";
					Step_Definition.taxPopup = "";
					
					
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
			
			else{
				
				
					if (write.equalsIgnoreCase("Yes")) {
					System.out.println("Contract Print######################");

					try {

						String[] valueToWriteNew = null;
						valueToWriteNew = new String[17];

						valueToWriteNew[0] = TestCase;
						valueToWriteNew[1] = Portal;
						valueToWriteNew[2] = Dealer;
						valueToWriteNew[3] = UserName;
						valueToWriteNew[4] = Vin;
						valueToWriteNew[5] = FirstName;
						valueToWriteNew[6] = LastName;
						valueToWriteNew[7] = Product;
						valueToWriteNew[8] = Plan;
						valueToWriteNew[9] = Term;
						valueToWriteNew[10] = TermMiles;
						valueToWriteNew[11] = odometer;
						valueToWriteNew[12] = Deductible;
						valueToWriteNew[13] = DealerCost;
						valueToWriteNew[14] = actualCost;
						valueToWriteNew[15] = status;

						ExcelReadWrite erw = new ExcelReadWrite();

					//<<<-- Publish Report in US and Canada Portal sheets
					
						erw.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "US_Portal_Report", valueToWriteNew);
					
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
				
	
	}
		
		Report.reportHTML();
	}
}
