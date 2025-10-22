package configurations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import configurations.Hooks;
import hyundai.HyundaiLoginPage;
import hyundai.LogOutPage;
import hyundai.ProductRateLookUpPage;
import hyundai.VerifyProductLookUpRate;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Report;
import utility.Log;
import configurations.UrlRepository;
public class RateLookUpSteps {
	
	public String environment = Hooks.activeEnvironment;
	public String url = "";
		
	public String testCase = null;
	public String dealer = null;
	public String userName = null;
	public String password = null;
	public String vin = null;
	public String odometer = null;
	public String product = null;
	public String coverage = null;
	public String term = null;
	public String maxTerm = null;
	public String maxAmount = null;
	public String deductible = null;
	public String rate = null;
	public String loadurl = "";

	
	public String rateStatus = "Fail";
	
	public String write = "No";
	
	@Given("^select urlforRL \"(.*?)\"$")
	public void select_url(String urloem) throws Throwable {
		this.loadurl = urloem;

	}
	@Given("^Go to Url as \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\" and \"(.*?)\"$")
	public void go_to_Url_with(String testCase, String dealer, String userName, String password, String vin, String odometer, String product, String coverage, String term, String maxTerm, String maxAmount, String deductible, String rate) throws Throwable {
		
		write = "Yes";
		
		Hooks.driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
		
		this.testCase = testCase;
		this.dealer = dealer;
		this.userName = userName;
		this.password = password;
		this.vin = vin;
		this.odometer = odometer;
		this.product = product;
		this.coverage = coverage;
		this.term = term;
		this.maxTerm = maxTerm;
		this.maxAmount = maxAmount;
		this.deductible = deductible;
		this.rate = rate;
		
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
	
	@Given("^Login to the Portal$")
	public void login_to_the_Portal() throws Throwable {
		
		HyundaiLoginPage hlp = new HyundaiLoginPage(Hooks.driver);	
		hlp.loginLink();
		hlp.userID(userName);
		hlp.userPassword(password);
		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
		{
			GetScreenshot.captureScreenshot();
		}
		hlp.loginToSafeGuard();
		Log.log.debug("Log in to Portal as:-"+userName);
	}

	@Given("^Redirect to the rate look up url$")
	public void redirect_to_the_rate_look_up_url() throws Throwable {
		
		if(environment.equalsIgnoreCase("QA"))
		{
			if (loadurl.equalsIgnoreCase("Hyundai")) {
			Hooks.driver.get(UrlRepository.qaHPPUrl.substring(0,51)+"/form/remittance/ratelookup/");
			}
			else if (loadurl.equalsIgnoreCase("Genesis")) {
				
				Hooks.driver.get(UrlRepository.qaGPPUrl.substring(0,51)+"/form/remittance/ratelookup/");
			}
			else if (loadurl.equalsIgnoreCase("KIA")) {
				Hooks.driver.get(UrlRepository.qaPPUrl.substring(0,51)+"/form/remittance/ratelookup/");
			}
			
		}
		else if(environment.equalsIgnoreCase("UAT"))
		{
			if (loadurl.equalsIgnoreCase("Hyundai")) {
				Hooks.driver.get(UrlRepository.uatHPPUrl.substring(0,44)+"/form/remittance/ratelookup/");
				}
				else if (loadurl.equalsIgnoreCase("Genesis")) {
					Hooks.driver.get(UrlRepository.uatGPPUrl.substring(0,44)+"/form/remittance/ratelookup/");
				}
				else if (loadurl.equalsIgnoreCase("KIA")) {
					Hooks.driver.get(UrlRepository.uatPPUrl.substring(0,44)+"/form/remittance/ratelookup/");
				}		
		}
		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
			if (loadurl.equalsIgnoreCase("Hyundai")) {
				Hooks.driver.get(UrlRepository.prodHPPUrl+"/form/remittance/ratelookup/");
				}
				else if (loadurl.equalsIgnoreCase("Genesis")) {
					Hooks.driver.get(UrlRepository.prodGPPUrl+"/form/remittance/ratelookup/");
				}
				else if (loadurl.equalsIgnoreCase("KIA")) {
					Hooks.driver.get(UrlRepository.prodPPUrl+"/form/remittance/ratelookup/");
				}			
		}
	}

	@When("^Fill the Product Rate Look up details VIN and Odometer$")
	public void fill_the_Product_Rate_Look_up_details_VIN_and_Odometer() throws Throwable {
		ProductRateLookUpPage prlp = new ProductRateLookUpPage(Hooks.driver);
		prlp.vin(vin);
		prlp.odometer(odometer);
		prlp.getRates();
	}
	
	@When("^Click on the Product$")
	public void click_on_the_Product() throws Throwable {
		ProductRateLookUpPage prlp = new ProductRateLookUpPage(Hooks.driver);
		prlp.clickProduct(product);
	}

	
	@When("^Verify the Rate$")
	public void verify_the_Rate() throws Throwable {		
		ProductRateLookUpPage prlp = new ProductRateLookUpPage(Hooks.driver);
		rateStatus = prlp.verifyRate(product,coverage, term, deductible, rate, maxTerm, maxAmount);
	}

	@Then("^Logout from the Portal$")
	public void logout_from_the_Portal() throws Throwable {
		LogOutPage lop=new LogOutPage(Hooks.driver);
		lop.logOut();
		Log.log.debug("LogOut from Portal");		
	}	
	
	
	@After
	public void writeResult(){
		
		//System.out.println("+++++++++++++++++++++Rate Look Up++++++++++++++++++++++"+write);
		
		if (write.equalsIgnoreCase("Yes")) {
			//System.out.println("Rate Look Up Print######################");
			
			try {	
				
				String[] valueToWriteNew=null;
		        valueToWriteNew = new String[13];
		    	valueToWriteNew[0] = testCase;
		    	valueToWriteNew[1] = dealer;	
		    	valueToWriteNew[2] = vin;	
		    	valueToWriteNew[3] = odometer;
		    	valueToWriteNew[4] = product;
		    	valueToWriteNew[5] = coverage;
		    	valueToWriteNew[6] = term;
		    	valueToWriteNew[7] = maxTerm;
		    	valueToWriteNew[8] = maxAmount;
		    	valueToWriteNew[9] = deductible;
		    	valueToWriteNew[10] = rate;		    
		    	valueToWriteNew[11] = rateStatus;
		    	valueToWriteNew[12] = CurrentDateSelection.getCurrentDate();  
		    	
				ExcelReadWrite ERW=new ExcelReadWrite();
				ERW.writeExcelForm(System.getProperty("user.dir"), "Result.xlsx", "RateLookUp",valueToWriteNew);
			} catch (IOException e) {				
				e.printStackTrace();
			}
	
		}	
		
		/////Report.reportHTML();
	}
	
}
