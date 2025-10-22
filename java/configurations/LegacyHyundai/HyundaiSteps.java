package configurations.LegacyHyundai;

import configurations.Hooks;
import configurations.UrlRepository;
import hyundai.CancellationPage;
import hyundai.NewRemittanceFormPage;
import hyundai.VinDecodingPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utility.GetScreenshot;
import utility.Log;

public class HyundaiSteps {
	
	public String environment = Hooks.activeEnvironment;
	public String TestCase = null;
	public String url = "";
	public String loadurl = "";
	
	@Given("^Go to Url for TestCase as \"(.*?)\"$")
	public void go_to_Url_for_TestCase_as(String TestCase) throws Throwable {
		this.TestCase = TestCase;
		
		if(environment.equalsIgnoreCase("QA"))
		{
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

		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
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
	
	
	/*@When("^validate data from Web_Remittance_Records Table as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_data_from_Web_Remittance_Records_Table_as_and_and_and_and(String firstName, String lastName, String VinNumber, String Dealer, String FormType) throws Throwable {
		PgAdminConnection.dataBaseConnection(firstName, lastName, VinNumber, Dealer, FormType);
		//...HyundaiHooks.log.debug("Connected to database "+PgAdminConnection.DBInstance);....
		HyundaiSubmitPage hsp=new HyundaiSubmitPage(HyundaiHooks.driver);
		//hsp.remittanceSubmit();
		//hsp.paySelected();
		//hsp.sendRemittance();
	}*/

	/*@When("^Remit Valid Contract$")
	public void remit_Valid_Contract() throws Throwable {
		HyundaiSubmitPage hsp=new HyundaiSubmitPage(HyundaiHooks.driver);
		hsp.remittanceSubmit();
		if(HyundaiHooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			getScreenshot.captureScreenshot();
		}
		HyundaiHooks.log.debug("Click on Apply Check Box");
		hsp.paySelected();
		HyundaiHooks.log.debug("Click on Pay Selected Remittance Icon");
		hsp.sendRemittance();
		if(HyundaiHooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			getScreenshot.captureScreenshot();
		}
		HyundaiHooks.log.debug("Click on Send Remittance Link");
		RateVerifyPage rvp=new RateVerifyPage(HyundaiHooks.driver);
		rvp.backToRem();
		HyundaiHooks.log.debug("Click on Back to Remittance Link");
	}*/

	/*@When("^validate data from web_con_m(\\d+) Table as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_data_from_web_con_m_Table_as_and_and_and_and(int arg1, String firstName, String lastName, String VinNumber, String Dealer, String FormType) throws Throwable {
		web_con_m1_Connection.webConM1Connection(firstName, lastName, VinNumber, Dealer, FormType);
	
		
	}*/
	
	/*@When("^Delete data from tables as as \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void delete_data_from_tables_as_as_and_and(String firstName, String lastName, String VinNumber) throws Throwable {
		
		try{
			deleteWebConMoneAndDmsConMoneTable.dataBaseWebDmsDelete(firstName, lastName, VinNumber);
		}catch(Exception e){
			e.getMessage();
		}
	}*/

	@When("^Fill New Remittance Form as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void fill_New_Remittance_Form_as_and_and_and(String FormType, String VinNumber, String programType, String currentOdometer) throws Throwable {
		
		NewRemittanceFormPage nrfp=new NewRemittanceFormPage(Hooks.driver);
			
		
		if(FormType.equalsIgnoreCase("PPM"))
		{
			nrfp.PPMProductCategory();
		}
		if(FormType.equalsIgnoreCase("CPO"))
		{
			nrfp.genProductCategory();
		}
		
		nrfp.vinNumber(VinNumber);
		nrfp.ProgType(programType);
		nrfp.curOdometer(currentOdometer);
		nrfp.getOption();
	
		Log.log.debug("Fill Remittance Form as "+FormType);
	}

	@When("^Validate Product Form as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void validate_Product_Form_as_and_and_and_and_and(String ExpectedForms, String DealerID, String VinNumber, String programType, String currentOdometer, String FormType) throws Throwable {
		VinDecodingPage vdp=new VinDecodingPage(Hooks.driver);
		vdp.productForm(TestCase, ExpectedForms, DealerID, VinNumber, programType, currentOdometer, FormType);
	
		Log.log.debug("Validate Product Form");
		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			GetScreenshot.captureScreenshot();
		}
	}
	
	@Given("^Click on Cancellation Quote Menu$")
	public void click_on_Cancellation_Quote_Menu() throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.reportMenuSel();
		
		Log.log.debug("Clicked on Cancellation Quote Menu");
	}

	@When("^Fill Cancellation Required Data as \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void fill_Cancellation_Required_Data_as_and_and(String cFN, String cLN, String cVIN) throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.canFirstName(cFN);
		cp.canLastName(cLN);
		cp.canVin(cVIN);
		
		Log.log.debug("Enter Contract Search required data");
		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			GetScreenshot.captureScreenshot();
		}
	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.canSubmit();
		
		Log.log.debug("Click on Submit Button");
	}

	@When("^Click on Cancellation Quote button as \"(.*?)\"$")
	public void click_on_Cancellation_Quote_button_as(String contractNo) throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.cancelQuote(contractNo);
		
		Log.log.debug("Click on Cancellation Quote Button");
	}

	@When("^Enter Cancellation Date End Mileage and Cancellation Reason as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void enter_Cancellation_Date_End_Mileage_and_Cancellation_Reason_as_and_and(String FactorDrivenBy, String CancelDate, String EndMileage, String CanReason) throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.CancellationQuoteFields(FactorDrivenBy, CancelDate, EndMileage, CanReason);
		
		Log.log.debug("Enter FactorDrivenBy Values as:-"+FactorDrivenBy);
		Log.log.debug("Enter CancelDate Values as:-"+CancelDate);
		Log.log.debug("Enter EndMileage Values as:-"+EndMileage);
		Log.log.debug("Enter CanReason Values as:-"+CanReason);
		Log.log.debug("Clicked on Submit button");
	}

	@When("^Read Data from Web and Match with expected data as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void read_Data_from_Web_and_Match_with_expected_data_as_and_and_and_and(String ExpFactor, String ExpDealerRefund, String ExpCustomerRefund, String DealerID, String VIN, String EndMileage, String CanReason, String CancelDate) throws Throwable {
		CancellationPage cp=new CancellationPage(Hooks.driver);
		cp.matchExpData(TestCase, ExpFactor, ExpDealerRefund, ExpCustomerRefund, DealerID, VIN, EndMileage, CanReason, CancelDate);
		
		Log.log.debug("Read Data From Web and Match with expected data");
		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			GetScreenshot.captureScreenshot();
		}
	}
}
