package Toyota;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import junit.framework.Assert;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class VerifyMakeModelYear {
	
	public WebDriver driver;
	
	public VerifyMakeModelYear(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_ncic")
	public WebElement make;
	
	@FindBy(id="web_con_model")
	public WebElement model;
	
	@FindBy(id="web_con_year")
	public WebElement year;
	
	public void makeModelYear(String Exp_Make, String Exp_Model, String Exp_Year, String RowNo, String Portal, String Dealer, String VinNo)
	{
		try{
//			Thread.sleep(5000L);
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_ncic")));
			String eMake=make.getAttribute("value").trim();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_model")));
			String eModel=model.getAttribute("value").trim();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_year")));
			String eYear=year.getAttribute("value").trim();
			
			/*System.out.println("eMake:- "+eMake);
			System.out.println("eModel:- "+eModel);
			System.out.println("eYear:- "+eYear);*/
			
			String vinDecodingStatus="";
			
			if(eMake.equalsIgnoreCase(Exp_Make) && eModel.equalsIgnoreCase(Exp_Model) && eYear.equalsIgnoreCase(Exp_Year))
			{
				vinDecodingStatus="Pass";
			}else{
				vinDecodingStatus="Fail";
			}
			
			//System.out.println("vinDecodingStatus:- "+vinDecodingStatus);
			
			String[] valueToWriteNew=null;
	        valueToWriteNew = new String[12];
	 		valueToWriteNew[0]=RowNo;
	 		valueToWriteNew[1]=Portal;
	 		valueToWriteNew[2]=Dealer;
	 		valueToWriteNew[3]=VinNo;
	 		valueToWriteNew[4]=Exp_Make;
	 		valueToWriteNew[5]=Exp_Model;
	 		valueToWriteNew[6]=Exp_Year;
	 		valueToWriteNew[7]=eMake;
	 		valueToWriteNew[8]=eModel;
	 		valueToWriteNew[9]=eYear;
	 		valueToWriteNew[10]=vinDecodingStatus;
	 		valueToWriteNew[11]=CurrentDateSelection.getCurrentDate();
	 		
	 		ExcelReadWrite ERW=new ExcelReadWrite();
	 		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "VinDecoding_Result",valueToWriteNew);
	         
	         Log.log.debug("Exp Make Is:- "+Exp_Make);
	         Log.log.debug("Exp Model Is:- "+Exp_Model);
	         Log.log.debug("Exp Year Is:- "+Exp_Year);
	         Log.log.debug("Actual Make Is:- "+eMake);
	         Log.log.debug("Actual Model Is:- "+eModel);
	         Log.log.debug("Actual Year:- "+eYear);
	         Log.log.debug("Status Is:- "+vinDecodingStatus);
	         
	        /* if(vinDecodingStatus.equalsIgnoreCase("Fail"))
	         {
	        	 Assert.assertFalse(true);
	         }*/
	         
			
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
