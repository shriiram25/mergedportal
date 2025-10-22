package configurations;

import java.util.concurrent.TimeUnit;
import utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
		
	public static String screenShotStatus="No";
	
	//############### Testing Environment ... [QA / UAT / PRODUCTION ] 
	public static String activeEnvironment = "QA";
	
	
	//Change URL
		//QA URL	
		public static String qaUrl="https://lgynew-qa.safe-guardproducts.com/portal/";
		//public static String qaUrl="https://lgy-qa02.safe-guardproducts.com/portal/";
		public static String prodUrl="https://consumerassurance.powersports.honda.com/";
		//PRODUCTION URL
		//public static String prodUrl="https://portal.safe-guardproducts.com";

		//Change DB Information

		public static String serverName="QTSQAPOST2:54123";//"10.10.6.165:54123"; // lgy-QA02 QTSQAPOST2:54123
		public static String userName="pkumar";
		public static String password="Think%123";
	
		//******************************************************************************
		//	              Following details are for legacy agent
		//******************************************************************************
		
		public static String agentqaUrl="https://lgy-qa02.safe-guardproducts.com/portal/";	// QA-01
		
		
		public static String qaDBInstance="10.10.6.165:54122"; 
		
		//******************************************************************************
		//	              UAT URL & DB Instance
		//******************************************************************************
			
		public static String agentuatUrl="https://lgy-uat07.safe-guardproducts.com/portal";
		public static String uatDBInstance="qtsuatetapost1:5432";
			 
		//******************************************************************************
		//	              PRODUCTION URL & DB Instance
		//******************************************************************************
			
		public static String agentprodUrl="https://portal.safe-guardproducts.com";
		public static String prodDBInstance="";	
			
			
		//*****************************************************************************
		//  QA URL & DB Instance
		//*****************************************************************************

		public static String qaNissanUrl="http://nissan-qa.safe-guardproducts.com/?layout=nissan";	
		public static String qaInfinitiUrl="http://nissan-qa.safe-guardproducts.com/?layout=infiniti";
		
		//public static String qaDBInstance="10.10.3.155:54000";

		
		//******************************************************************************
		//	              UAT URL & DB Instance
		//******************************************************************************
			
		public static String uatNissanUrl="https://lgynew-uat.safe-guardproducts.com/nissan/?layout=nissan";	
		public static String uatInfinitiUrl="";
		
		//public static String uatDBInstance="";
			
		//******************************************************************************
		//	              PRODUCTION URL & DB Instance
		//******************************************************************************
			
		public static String prodNissanUrl="http://www.securityplusprotectionplans.ca";
		public static String prodInfinitiUrl="http://www.eliteprotectionplans.ca";
		
		//public static String prodDBInstance="";	
			
		//******************************************************************************
		//		              DB User Credential
		//******************************************************************************
			
			
		//public static String userName="";
		//public static String password="";
		
		
		//******************************************************************************
				//		             MB URL User Credential
				//******************************************************************************
		//Change QA URL & DB Instance
		public static String MBqaUrl="https://lgynew-qa.safe-guardproducts.com/mb/?layout=mb";		   
		public static String MBqaDBInstance="QTSQAPOST2:54124";	  	//qa-04
		
		//Change UAT URL & DB Instance
		public static String MBUATUrl="https://lgynew-uat.safe-guardproducts.com/mb/?layout=mb";
		public static String UATDBInstance="qtsuatetapost1:5432";
		
		//Change PRODUCTION URL & DB Instance
		public static String MBprodUrl="http://www.firstclassprotection.com";
		public static String MBprodDBInstance="";	
		
		//*****************************************************************************
		//                    BMW QA URL & DB Instance
		//*****************************************************************************

		//public static String qaBMWUrl="https://lgy-qa01.safe-guardproducts.com/bmw/?layout=bmw";

		//public static String qaMINIUrl="https://lgy-qa01.safe-guardproducts.com/bmw/?layout=mini";
		
		public static String qaBMWUrl="https://lgynew-qa.safe-guardproducts.com/bmw/?layout=bmw";

		public static String qaMINIUrl="https://lgynew-qa.safe-guardproducts.com/bmw/?layout=mini";	
		
		//public static String qaDBInstance="10.10.6.165:54121"; // lgy-qa01 DB 
		//public static String qaDBInstance="10.10.6.165:54122"; // lgy-qa02 DB 
		
		//******************************************************************************
		//	              UAT URL & DB Instance
		//******************************************************************************
			
		public static String uatBMWUrl="";
		public static String uatMINIUrl="";
		
		//public static String uatDBInstance="";
			
		//******************************************************************************
		//	              PRODUCTION URL & DB Instance
		//******************************************************************************
			
		public static String prodBMWUrl="https://www.bmw-protection.com";
		public static String prodMINIUrl="https://www.mini-protection.com";
		
		//public static String prodDBInstance="";	
		
		
		// *****************************************************************************
		//  TOYOTA QA URL & DB Instance.... [ Use layout for Url:- "/?layout=toyota/lexus/ccc"]
		// *****************************************************************************

		public static String qaToyota = "https://lgynew-qa.safe-guardproducts.com/toyota/?layout=toyota";
		public static String qaLexus = "https://lgynew-qa.safe-guardproducts.com/toyota/?layout=lexus";
		public static String qaCCC = "https://lgynew-qa.safe-guardproducts.com/toyota/?layout=ccc";

		//public static String qaDBInstance = "";
		

		// ******************************************************************************
		// UAT URL & DB Instance.... [ Use layout for Url:- "/?layout=toyota/lexus/ccc" ]
		// ******************************************************************************

		public static String uatToyota = "";
		public static String uatLexus = "";
		public static String uatCCC = "";
		//public static String uatDBInstance = "";

		// ******************************************************************************
		// PRODUCTION URL & DB Instance
		// ******************************************************************************

		public static String prodToyota = "https://www.tfsdealerportal.com/";
		public static String prodLexus = "https://www.lfsdealerportal.com/";
		public static String prodCCC = "https://www.cccdealerportal.com/";
		//public static String prodDBInstance = "";

		// ******************************************************************************
		/*
 	public static String[] mailTo = {"ppattans@sgintl.com"};
 	public static String[] mailCc = {"ppattans@sgintl.com"};
	
	public static String[] mailTo ={"ITQATEAM@sgintl.com", "iteasecomteam@sgintl.com"};	
	public static String[] mailCc ={"mrahman@sgintl.com", "dshah@sgintl.com"};
	
	public static String[] mailTo = {"ppattans@sgintl.com"};
	public static String[] mailCc = {"pmikkilineni@sgintl.com"};*/
	
	public static String[] mailTo = {"pkumar@sgintl.com"};
	public static String[] mailCc = {"pkumar@sgintl.com"};
	


	// static String[] mailTo = {"ITQATEAM@sgintl.com"};
	//public static String[] mailCc = {"drobinson@sgintl.com"};
 	
	public static String mailSubject = " Regression Test - Hyundai Portal";
	
	public static String mailmessageBody = "Hello Everyone,"+"<br/><br/>"+"Please find attachments for Results."+"<br/><br/><br/><br/>"+"Thanks & Regards,"+"<br/><br/>"+"QA Team";
	
	
	// this is to initialize the Browser 
	
	//public String browser = "FireFox";
    public String browser = "Chrome";
	
	
	@Before
	public void webDriverIniti()
	{
		try {
			if(browser.equalsIgnoreCase("FireFox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Browser//geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette",true);
				driver= new FirefoxDriver(capabilities);
			       

//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Browser//geckodriver.exe");                
//				driver=new FirefoxDriver();
//				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//				driver.manage().window().maximize();
//				driver.manage().deleteAllCookies();	
			}
			else if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();			
				options.addArguments("disable-infobars","start-maximized");	
				driver = new ChromeDriver(options);
				//driver=new ChromeDriver();
				//driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);				
				driver.manage().deleteAllCookies();	
			}
			
			Log.log.debug("Passed: "+browser+" Browser is Initilized");
		} catch (Exception e) {			
			e.printStackTrace();
			Log.log.debug("Failed: "+browser+" Browser is not Initilized");
		}
	}
	
	@After
	public void webDriverClose()
	{
		driver.quit();
		Log.log.debug(browser+" Browser is Closed");
	}
}
