package configurations.LegacyHyundai;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
//import Hyundai.Hooks;
import configurations.Hooks;
import configurations.UrlRepository;
import hyundai.HyundaiEContractingPage;
import hyundai.HyundaiLoginPage;
import hyundai.HyundaiSubmitPage;
import hyundai.LogOutPage;
import hyundai.NewRemittanceFormPage;
//import HyundaiPageObjects.RateVerifyPage;
import hyundai.RateVerifyPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.CurrentDateSelection;
import utility.DeleteRemitanceDataBase;
import utility.DeleteWebConMoneAndDmsConMoneTable;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;
import utility.PGAdminConnection;
import utility.Report;
import utility.Web_Con_Mone_Connection;

public class HyundaiRemittanceSteps {

	public String environment = Hooks.activeEnvironment;

	public String url = "";
	public String testCase = null;
	public String productCategory = null;
	public String formType = null;
	public String dealer = null;
	public String vin = null;
	public String odometer = null;
	public String product = null;
	public String coverage = null;
	public String coverageOptions = null;
	public String productTerm = null;
	public String termMileage = null;
	public String deductible = null;
	public String firstName = null;
	public String lastName = null;
	public String expectedRate = null;

	public String actualRate = "";
	public String rateStatus = "Fail";
	public String contractID = "";
	public String remitStatus = "";
	public String notes = "";
	// public String oem[]=Config.activeOem;
	public String loadurl = "";

	public String write = "No";
	public String functionality="";//new

	// public String status = "Fail";

	public String[] data = null;

	@Given("^select url \"(.*?)\"$")
	public void select_url(String urloem) throws Throwable {
		this.loadurl = urloem;

	}

	@Given("^Go to Url as \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\", and \"(.*?)\"$")
	public void go_to_Url(String testCase, String productCategory, String formType, String dealer, String vin,
			String odometer, String product, String coverage, String coverageOptions, String productTerm,
			String termMileage, String deductible, String firstName, String lastName, String expectedRate)
			throws Throwable {

		write = "Yes";

		Hooks.driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

		this.testCase = testCase;
		this.productCategory = productCategory;
		this.formType = formType;
		this.dealer = dealer;
		this.vin = vin;
		this.odometer = odometer;
		this.product = product;
		this.coverage = coverage;
		this.coverageOptions = coverageOptions;
		this.productTerm = productTerm;
		this.termMileage = termMileage;
		this.deductible = deductible;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expectedRate = expectedRate;

		if (environment.equalsIgnoreCase("QA")) {
//			Hooks.driver.get(Config.qaUrl);
//			url = Hooks.driver.getCurrentUrl();
//			Hooks.log.debug("Enter URL as " + url);
			if (loadurl.equalsIgnoreCase("Hyundai")) {
				Hooks.driver.get(UrlRepository.qaHPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("Genesis")) {
				Hooks.driver.get(UrlRepository.qaGPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("KIA")) {
				Hooks.driver.get(UrlRepository.qaPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			}}
 
		else if (environment.equalsIgnoreCase("UAT")) {
			if (loadurl.equalsIgnoreCase("Hyundai")) {
				Hooks.driver.get(UrlRepository.uatHPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("Genesis")) {
				Hooks.driver.get(UrlRepository.uatGPPUrl); 
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("KIA")) {
				Hooks.driver.get(UrlRepository.uatPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			}
			
		} else if (environment.equalsIgnoreCase("PRODUCTION")) {
			if (loadurl.equalsIgnoreCase("Hyundai")) {
				Hooks.driver.get(UrlRepository.prodHPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("Genesis")) {
				Hooks.driver.get(UrlRepository.prodGPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			} else if (loadurl.equalsIgnoreCase("KIA")) {
				Hooks.driver.get(UrlRepository.prodPPUrl);
				url = Hooks.driver.getCurrentUrl();
				Log.log.debug("Enter URL as " + url);
			}
			//
		}
	}

	@Given("^Login to Portal as \"(.*?)\" and \"(.*?)\"$")
	public void login_to_Portal_as_and(String username, String password) throws Throwable {

		HyundaiLoginPage hlp = new HyundaiLoginPage(Hooks.driver);
		hlp.loginLink();
		hlp.userID(username);
		hlp.userPassword(password);
		if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
			GetScreenshot.captureScreenshot();
		}
		hlp.loginToSafeGuard();
		functionality="Login";
;		Log.log.debug("Log in to Portal as:-" + username);
	}

	@Given("^Click on Product Rate menu$")
	public void click_on_Product_Rate_menu() throws Throwable {
		HyundaiEContractingPage hecp = new HyundaiEContractingPage(Hooks.driver);
		hecp.econMenu();
		hecp.proRateMenu();
		Log.log.debug("Clicked on Product Rate Menu");
	}

	@When("^Fill Remittance Form as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void fill_Remittance_Form(String VinNumber, String programType, String currentOdometer, String product,
			String Coverage, String CoverageOptions, String ProductTerm, String TermMileage, String Deductible,
			String financeAmount, String DealerState, String CustRetail, String firstName, String lastName,
			String Address, String City, String ZIP, String HomePhone, String vehicleCondition, String PaymentType,
			String productCategory, String VehicleSalesPrice, String LienHolder, String VehiclePurchasePrice,
			String formType) throws Throwable {

		try {
			// DeleteRemitanceDataBase.dataBaseRemDelete(firstName, lastName,
			// VinNumber);
		} catch (Exception e) {
			e.getMessage();
		}

		NewRemittanceFormPage nrfp = new NewRemittanceFormPage(Hooks.driver);
		if (productCategory.equalsIgnoreCase("VSC")) {
			nrfp.vinNumber(VinNumber);
			nrfp.ProgType(programType);
			nrfp.curOdometer(currentOdometer);
			nrfp.getOption();
			nrfp.productForm(product);
			nrfp.clickOutSide();
			nrfp.covCode(Coverage);
			nrfp.clickOutSide();
			nrfp.ProductTerm(ProductTerm);
			nrfp.clickOutSide();
			nrfp.TermMileage(TermMileage);
			nrfp.vscDeductible(Deductible);
			nrfp.cDate();
			nrfp.saveInfoButton();
			nrfp.financeAmount(financeAmount);
			nrfp.clickOutSide();
			nrfp.customerCost(DealerState, CustRetail);

			actualRate = nrfp.getProductCost();
			rateStatus = nrfp.productCostMatch(expectedRate, actualRate);
			if (rateStatus.equalsIgnoreCase("Fail")) {
				notes = "Rate didn't match";
				// Assert.assertTrue("Rate didn't match", false);
			}
			nrfp.firstName(firstName);
			nrfp.lastName(lastName);
			if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
				GetScreenshot.captureScreenshot();
			}
			nrfp.addCon();
			nrfp.addAdd(Address);
			nrfp.addCit(City);
			nrfp.addState(DealerState);
			nrfp.addZip(ZIP);
			nrfp.addHomePhome(HomePhone);
			nrfp.vechileCond(vehicleCondition);
			nrfp.addPayType(PaymentType);
			nrfp.addLienHolder(LienHolder);
			nrfp.addMSRP(VehiclePurchasePrice);
		}
		if (productCategory.equalsIgnoreCase("PPM")) {
			nrfp.PPMProductCategory();
			nrfp.vinNumber(VinNumber);
			nrfp.ProgType(programType);
			nrfp.curOdometer(currentOdometer);
			nrfp.getOption();
			nrfp.productForm(product);
			nrfp.clickOutSide();
			nrfp.covCode(Coverage);
			nrfp.clickOutSide();
			nrfp.ProductTerm(ProductTerm);
			nrfp.clickOutSide();
			// nrfp.TermMileage(TermMileage);
			// nrfp.vscDeductible(Deductible);
			// nrfp.cDate();
			// nrfp.saveInfoButton();
			//if((product.equalsIgnoreCase("HYSW")) || (product.equalsIgnoreCase("HYBW")) ) 
			if(product.contains("Wrap"))
			{
				nrfp.saveInfo_inserviceButton();
			}
			nrfp.financeAmount(financeAmount);
			
			nrfp.clickOutSide();
			nrfp.customerCost(DealerState, CustRetail);
			actualRate = nrfp.getProductCost();
			rateStatus = nrfp.productCostMatch(expectedRate, actualRate);
			// WebDriverWait wait=new WebDriverWait(Hooks.driver, 20);
			if (rateStatus.equalsIgnoreCase("Fail")) {
				notes = "Rate didn't match";
				// Assert.assertTrue("Rate didn't match", false);
			}
			nrfp.firstName(firstName);
			nrfp.lastName(lastName);
			if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
				GetScreenshot.captureScreenshot();
			}
			nrfp.addCon();
			nrfp.addAdd(Address);
			nrfp.addCit(City);
			nrfp.addState(DealerState);
			nrfp.addZip(ZIP);
			nrfp.addHomePhome(HomePhone);
			nrfp.vechileCond(vehicleCondition);
			nrfp.addPayType(PaymentType);
			nrfp.addLienHolder(LienHolder);
			nrfp.addMSRP(VehiclePurchasePrice);
		}
		if (productCategory.equalsIgnoreCase("CPO")) {
			nrfp.genProductCategory();
			nrfp.vinNumber(VinNumber);
			nrfp.ProgType(programType);
			nrfp.curOdometer(currentOdometer);
			nrfp.getOption();
			nrfp.productForm(product);
			nrfp.clickOutSide();
			if (formType.equalsIgnoreCase("BUNDLE")) {
				nrfp.optionChooser();
				nrfp.fullCoverage(CoverageOptions);
				nrfp.SaveSelector();
			} else {
				nrfp.covCode(Coverage);
				nrfp.clickOutSide();
			}
			nrfp.ProductTerm(ProductTerm);
			nrfp.clickOutSide();
			if (formType.equalsIgnoreCase("TERM")) {
				nrfp.TermMileage(TermMileage);
				nrfp.vscDeductible(Deductible);
				nrfp.cDate();
				nrfp.saveInfoButton();
			}
			nrfp.financeAmount(financeAmount);
			nrfp.clickOutSide();
			if (formType.equalsIgnoreCase("LEASE")) {
				nrfp.exceptionMsrp(VehicleSalesPrice);
				nrfp.vechicleSave();
			}
			Thread.sleep(4000L);
			nrfp.customerCost(DealerState, CustRetail);
			actualRate = nrfp.getProductCost();
			rateStatus = nrfp.productCostMatch(expectedRate, actualRate);
			// System.out.println("expectedRate:-"+expectedRate+";");
			// System.out.println("actualRate:-"+actualRate+";");
			if (rateStatus.equalsIgnoreCase("Fail")) {
				notes = "Rate didn't match";
				// Assert.assertTrue("Rate didn't match", false);
			}
			nrfp.firstName(firstName);
			nrfp.lastName(lastName);
			/*
			 * if(Config.screenShotStatus.equalsIgnoreCase("Yes")) {
			 * GetScreenshot.captureScreenshot(); }
			 */
			nrfp.addCon();
			nrfp.addAdd(Address);
			nrfp.addCit(City);
			nrfp.addState(DealerState);
			nrfp.addZip(ZIP);
			nrfp.addHomePhome(HomePhone);
			nrfp.vechileCond(vehicleCondition);
			nrfp.addPayType(PaymentType);
			nrfp.addLienHolder(LienHolder);
		}

		Log.log.debug("Fill Remittance Form as " + productCategory);
	}


	@When("^Save the form$")
	public void save_the_form() throws Throwable {
		NewRemittanceFormPage nrfp = new NewRemittanceFormPage(Hooks.driver);
		nrfp.saveCon();
		RateVerifyPage rvp = new RateVerifyPage(Hooks.driver);
		rvp.SubContractRem();
	}

	@When("^Read data from portal and match with ExpextedProductRate as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void read_data_from_portal_and_match_with_ExpextedProductRate(String ExpRate, String firstName,
			String VinNumber, String Dealer, String ProductTerm, String Coverage, String lastName, String FormType)
			throws Throwable {

		RateVerifyPage rvp = new RateVerifyPage(Hooks.driver);

		data = rvp.getDataFromUINew(testCase, ExpRate, firstName, VinNumber, Dealer, ProductTerm, Coverage, FormType);
		Log.log.debug("Verifying contract total from Contract Remittance - Unpaid page");
		Log.log.debug("Contract Total" + rvp.ER);
		Log.log.debug("Expected Rate" + ExpRate);

		actualRate = data[0];
		rateStatus = data[1];
		contractID = data[2];

	}

	@When("^validate data from table as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_data_from_table_as_and_and_and_and(String firstName, String lastName, String VinNumber,
			String Dealer, String FormType) throws Throwable {

		try {
			PGAdminConnection.dataBaseConnection(testCase, firstName, lastName, VinNumber, Dealer, FormType);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("^Delete E-Remittance From Web$")
	public void delete_E_Remittance_From_Web() throws Throwable {
		HyundaiSubmitPage hsp = new HyundaiSubmitPage(Hooks.driver);
		hsp.remittanceDelete();
		Log.log.debug("Delete Remittance Form ");
	}

	@Then("^Logout from Portal$")
	public void logout_from_Portal() throws Throwable {
		LogOutPage lop = new LogOutPage(Hooks.driver);

		if (url.contains("layout") || Hooks.activeEnvironment.equalsIgnoreCase("PRODUCTION")) {
			// System.out.println("URL:- " + url);
			lop.clickLogoutLink();
		} else {
			// System.out.println("URL:- " + url);
			lop.logOut();
		}

		Log.log.debug("Logout from Portal");
	}

	@When("^validate data from Web_Remittance_Records Table as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_data_from_Web_Remittance_Records_Table_as_and_and_and_and(String firstName, String lastName,
			String VinNumber, String Dealer, String FormType) throws Throwable {
		try {
			PGAdminConnection.dataBaseConnection(testCase, firstName, lastName, VinNumber, Dealer, FormType);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("^Remit Valid Contract$")
	public void remit_Valid_Contract() throws Throwable {
		HyundaiSubmitPage hsp = new HyundaiSubmitPage(Hooks.driver);
		hsp.remittanceSubmit();
		if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
			GetScreenshot.captureScreenshot();
		}
		Log.log.debug("Click on Apply Check Box");
		hsp.paySelected();
		Log.log.debug("Click on Pay Selected Remittance Icon");
		remitStatus = hsp.sendRemittance();
		if (Hooks.screenShotStatus.equalsIgnoreCase("Yes")) {
			GetScreenshot.captureScreenshot();
		}
		Log.log.debug("Click on Send Remittance Link");
		RateVerifyPage rvp = new RateVerifyPage(Hooks.driver);
		rvp.backToRem();
		Log.log.debug("Click on Back to Remittance Link");
	}

	@When("^validate data from web_con_m(\\d+) Table as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_data_from_web_con_m_Table_as_and_and_and_and(int arg1, String firstName, String lastName,
			String VinNumber, String Dealer, String FormType) throws Throwable {
		Web_Con_Mone_Connection.webConM1Connection(testCase, firstName, lastName, VinNumber, Dealer, FormType);
	}

	@When("^Delete data from tables as as \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void delete_data_from_tables_as_as_and_and(String firstName, String lastName, String VinNumber)
			throws Throwable {

		try {
			DeleteWebConMoneAndDmsConMoneTable.dataBaseWebDmsDelete(firstName, lastName, VinNumber);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@After("@SaveContract_Hyundai_PROD,@SaveContract_Hyundai_QA,@RemitContract_Hyundai_QA,@RateLookUp")
	 public void writeResult() {

		// System.out.println("+++++++++++++++++++++Contract++++++++++++++++++++++"+write);

		if (write.equalsIgnoreCase("Yes")) {
			// System.out.println("Contract Print######################");

			try {

				String[] valueToWriteNew = null;
				valueToWriteNew = new String[21];
				valueToWriteNew[0] = testCase;
				valueToWriteNew[1] = productCategory;
				valueToWriteNew[2] = formType;
				valueToWriteNew[3] = dealer;
				valueToWriteNew[4] = vin;
				valueToWriteNew[5] = odometer;
				valueToWriteNew[6] = product;
				valueToWriteNew[7] = coverage;
				valueToWriteNew[8] = coverageOptions;
				valueToWriteNew[9] = productTerm;
				valueToWriteNew[10] = termMileage;
				valueToWriteNew[11] = deductible;
				valueToWriteNew[12] = firstName;
				valueToWriteNew[13] = lastName;
				valueToWriteNew[14] = expectedRate;
				valueToWriteNew[15] = actualRate;
				valueToWriteNew[16] = rateStatus;
				valueToWriteNew[17] = contractID;
				valueToWriteNew[18] = remitStatus;
				valueToWriteNew[19] = CurrentDateSelection.getCurrentDate();
				valueToWriteNew[20] = notes;

				ExcelReadWrite ERW = new ExcelReadWrite();
				ERW.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "Result", valueToWriteNew);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		 Report.reportHTML();
	}

	/*@After(order = 0)
	public void generateReport() {
		Report.reportHTML();
	}*/
	
	}
