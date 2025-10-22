package agents.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import configurations.Hooks;
//import configurations.Config;
import org.junit.Assert;
import utility.GetScreenshot;
import utility.Log;

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
				driver.get(Hooks.agentqaUrl);
				Log.log.debug(Hooks.agentqaUrl+" is open");
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		} 
		else if(environment.equalsIgnoreCase("UAT"))
		{
			try{
				driver.get(Hooks.agentuatUrl);
				Log.log.debug(Hooks.agentuatUrl+" is open");
			}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
			}
		}
		else if(environment.equalsIgnoreCase("PRODUCTION"))
		{
			try{
				driver.get(Hooks.prodUrl);
				Log.log.debug(Hooks.prodUrl+" is open");
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
