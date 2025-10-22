package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import configurations.Hooks;
import utility.Log;
import utility.GetScreenshot;


public class UrlPage {
	
	public WebDriver driver;
	
	public UrlPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openUrl(String url)
	{
		try{
			if (Hooks.activeEnvironment.equalsIgnoreCase("QA")) {
				if (url.equalsIgnoreCase("TOYOTA")) {
					driver.get(Hooks.qaToyota);
					Log.log.debug(Hooks.qaToyota + " is open");
				}
				if (url.equalsIgnoreCase("LEXUS")) {
					driver.get(Hooks.qaLexus);
					Log.log.debug(Hooks.qaLexus + " is open");
				}
				if (url.equalsIgnoreCase("CCC")) {
					driver.get(Hooks.qaCCC);
					Log.log.debug(Hooks.qaCCC + " is open");
				} 
			} else if (Hooks.activeEnvironment.equalsIgnoreCase("UAT")) {
				if (url.equalsIgnoreCase("TOYOTA")) {
					driver.get(Hooks.uatToyota);
					Log.log.debug(Hooks.uatToyota + " is open");
				}
				if (url.equalsIgnoreCase("LEXUS")) {
					driver.get(Hooks.uatLexus);
					Log.log.debug(Hooks.uatLexus + " is open");
				}
				if (url.equalsIgnoreCase("CCC")) {
					driver.get(Hooks.uatCCC);
					Log.log.debug(Hooks.uatCCC + " is open");
				} 
			} else if (Hooks.activeEnvironment.equalsIgnoreCase("PRODUCTION")) {
				if (url.equalsIgnoreCase("TOYOTA")) {
					driver.get(Hooks.prodToyota);
					Log.log.debug(Hooks.prodToyota + " is open");
				}
				if (url.equalsIgnoreCase("LEXUS")) {
					driver.get(Hooks.prodLexus);
					Log.log.debug(Hooks.prodLexus + " is open");
				}
				if (url.equalsIgnoreCase("CCC")) {
					driver.get(Hooks.prodCCC);
					Log.log.debug(Hooks.prodCCC + " is open");
				} 
			}
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
