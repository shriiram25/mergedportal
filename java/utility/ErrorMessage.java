package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configurations.Hooks;


// Class file to get the error message
public class ErrorMessage {
	
	public static WebDriver driver;
	public static String ErrorMessage;
	public static String screenshotname;
	
	//Function that gets the id of the error message web element as a parameter.
	//Executes with the id to get the message present on the id.
	public static void captureErrorMessage(String messageid){
		
		driver=Hooks.driver;
	   try {			
		   
		   // gets the text of the error message and stores in the string variable
		    ErrorMessage = driver.findElement(By.id(messageid)).getText();
		    
		    // gets the screenshot filename
		    screenshotname = GetScreenshot.filename;
		    
		    //Log
			//EASHooks.log.debug( ErrorMessage + " and refer in this image file " + screenshotname);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    	      
	}

	//Function that gets the xpath of the error message web element as a parameter.
	//Executes with the id to get the message present on the xpath.

	public static void captureErrorMessageXpath(String messageid){
		
		driver=Hooks.driver;
	   try {			
		   
		   // gets the text of the error message and stores in the string variable
		    ErrorMessage = driver.findElement(By.xpath(messageid)).getText();
		    
		    // gets the screenshot filename
		    screenshotname = GetScreenshot.filename;
		    
		    //Log
			//EASHooks.log.debug( ErrorMessage + " and refer in this image file " + screenshotname);
		}
	   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    	      
	}


}
