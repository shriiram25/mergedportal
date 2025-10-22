package nissaninfiniti.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import configurations.Hooks;
import org.junit.Assert;
import utility.Log;
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
				if(url.equalsIgnoreCase("Nissan"))
				{
					driver.get(Hooks.qaNissanUrl);
					Log.log.debug(Hooks.qaNissanUrl+" is open");
				}
				if(url.equalsIgnoreCase("Infiniti"))
				{
					driver.get(Hooks.qaInfinitiUrl);
					Log.log.debug(Hooks.qaInfinitiUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		} 
		else if(environment.equalsIgnoreCase("UAT"))
		{
			try{
				if(url.equalsIgnoreCase("Nissan"))
				{
					driver.get(Hooks.uatNissanUrl);
					Log.log.debug(Hooks.uatNissanUrl+" is open");
				}
				if(url.equalsIgnoreCase("Infiniti"))
				{
					driver.get(Hooks.uatInfinitiUrl);
					Log.log.debug(Hooks.uatInfinitiUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
			try{
				if(url.equalsIgnoreCase("Nissan"))
				{
					driver.get(Hooks.prodNissanUrl);
					Log.log.debug(Hooks.prodNissanUrl+" is open");
				}
				if(url.equalsIgnoreCase("Infiniti"))
				{
					driver.get(Hooks.prodInfinitiUrl);
					Log.log.debug(Hooks.prodInfinitiUrl+" is open");
				}
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
	}
}
