package MB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import MB.Hooks;
import junit.framework.Assert;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

public class UrlPage {
	
	public WebDriver driver;
	public String environment = Hooks.activeEnvironment;
	
	public UrlPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openUrl()
	{		
		if(environment.equalsIgnoreCase("QA"))
		{
			try{
				driver.get(Hooks.MBqaUrl);
				Log.log.debug(Hooks.MBqaUrl+" is open");
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		} 
		
		if(environment.equalsIgnoreCase("UAT"))
		{
			try{
				driver.get(Hooks.MBUATUrl);
				Log.log.debug(Hooks.MBUATUrl+" is open");
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		} 
		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
			try{
				driver.get(Hooks.MBprodUrl);
				Log.log.debug(Hooks.MBprodUrl+" is open");
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
		/*try{
			driver.get(Hooks.webUrl);
			
			Log.log.debug("URL open as:- "+Hooks.webUrl);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}*/
	}

}
