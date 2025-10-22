package utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import configurations.Hooks;


// class file to take the screen shot while the exception occurs
public class GetScreenshot {
	
	public static String mailscreenshotpath;
	public static WebDriver driver;
	
	public static String name; 	
	public static String filename; 	
	public static void captureScreenshot(){
		
		driver=Hooks.driver;
		
		//Declaring a variables to use for the file name
		 Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //4
		  int year = cal.get(Calendar.YEAR); //
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		
		  //Declaring the file name of the screen shot as the date and current time of exception occur.
		  name = year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";	

		  
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try {
		   
		    //creating a screen shot file  
	   		mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\screenshots\\"+name;	   		
			FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
			filename=name;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 	      
	}
}
