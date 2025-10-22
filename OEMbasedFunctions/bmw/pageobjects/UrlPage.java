package bmw.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utility.Log;
import configurations.Hooks;
import utility.GetScreenshot;

public class UrlPage {
	
	public WebDriver driver;
	public String environment = Hooks.activeEnvironment;
	
	public UrlPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openUrl(String url)
	{
		if(environment.equalsIgnoreCase("QA"))
		{
			try{
				if(url.equalsIgnoreCase("BMW"))
				{
					driver.get(Hooks.qaBMWUrl);
					Log.log.debug(Hooks.qaBMWUrl+" is open");
				}
				if(url.equalsIgnoreCase("MINI"))
				{
					driver.get(Hooks.qaMINIUrl);
					Log.log.debug(Hooks.qaMINIUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
		else if(environment.equalsIgnoreCase("UAT"))
		{
			try{
				if(url.equalsIgnoreCase("BMW"))
				{
					driver.get(Hooks.uatBMWUrl);
					Log.log.debug(Hooks.uatBMWUrl+" is open");
				}
				if(url.equalsIgnoreCase("MINI"))
				{
					driver.get(Hooks.uatMINIUrl);
					Log.log.debug(Hooks.uatMINIUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}		
		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
			try{
				if(url.equalsIgnoreCase("BMW"))
				{
					driver.get(Hooks.prodBMWUrl);
					Log.log.debug(Hooks.prodBMWUrl+" is open");
				}
				if(url.equalsIgnoreCase("MINI"))
				{
					driver.get(Hooks.prodMINIUrl);
					Log.log.debug(Hooks.prodMINIUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}		
		
	}

}
