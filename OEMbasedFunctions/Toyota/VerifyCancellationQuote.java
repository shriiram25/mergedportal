package Toyota;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class VerifyCancellationQuote {
	
	public WebDriver driver;
	
	public VerifyCancellationQuote(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="tbody")
	public WebElement table;
	
	@FindBy(xpath="//*[@id='content-right']/table/tbody/tr/td[4]/a")
	public WebElement viewDetail;
	
	@FindBy(id="quoteButton")
	public WebElement canQuoteLink;
	
	@FindBy(id="f-calendar-field-1")
	public WebElement canDate;
	
	@FindBy(id="cost")
	public WebElement cCost;
	
	@FindBy(id="quoteSubmit")
	public WebElement qButton;
	
	public void verifyCancellQuote(String Can_Date, String Cust_Cost, String Exp_Factor, String Exp_CancellationFee, String Exp_CustomerRefund, String RowNo, String Portal, String Dealer, String FirstName, String LastName, String VinNo)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tbody")));
			
			List<WebElement> trList=table.findElements(By.tagName("tr"));
			//System.out.println("trList:- "+trList.size());
			if(trList.size()>1)
			{
				//System.out.println("Greater");
				
				 String[] valueToWriteNew=null;
			        valueToWriteNew = new String[16];
			 		valueToWriteNew[0]=RowNo;
			 		valueToWriteNew[1]=Portal;
			 		valueToWriteNew[2]=Dealer;
			 		valueToWriteNew[3]=FirstName;
			 		valueToWriteNew[4]=LastName;
			 		valueToWriteNew[5]=VinNo;
			 		valueToWriteNew[6]=Can_Date;
			 		valueToWriteNew[7]=Cust_Cost;
			 		valueToWriteNew[8]=Exp_Factor;
			 		valueToWriteNew[9]=Exp_CancellationFee;
			 		valueToWriteNew[10]=Exp_CustomerRefund;
			 		valueToWriteNew[11]="";
			 		valueToWriteNew[12]="";
			 		valueToWriteNew[13]="";
			 		valueToWriteNew[14]="Multiple Agreement Found";
			 		valueToWriteNew[15]=CurrentDateSelection.getCurrentDate();
			 		
			 		ExcelReadWrite ERW=new ExcelReadWrite();
			 		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "CancellationQuote_Result",valueToWriteNew);
			         
			        
			 		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			 		{
			 			GetScreenshot.captureScreenshot();
			 		}
				
				
				
				
				
			}else{
				viewDetail.click();
				//Thread.sleep(5000L);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteButton")));
				canQuoteLink.click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("f-calendar-field-1")));
				canDate.clear();
				canDate.sendKeys(Can_Date);
				
				if(!Cust_Cost.equals(""))
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cost")));
					cCost.clear();
					cCost.sendKeys(Cust_Cost);
				}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quoteSubmit")));
				qButton.click();
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				
				String actualFactor=driver.findElement(By.xpath("//*[@id='quoteTableTbody']/tr/td[2]")).getText().trim();
				String actualCanFee=driver.findElement(By.xpath("//*[@id='quoteTableTbody']/tr/td[3]")).getText().trim();
				String actualCustRefund=driver.findElement(By.xpath("//*[@id='quoteTableTbody']/tr/td[4]")).getText().trim();
				
				/*System.out.println("actualFactor:- "+actualFactor);
				System.out.println("actualCanFee:- "+actualCanFee);
				System.out.println("actualCustRefund:- "+actualCustRefund);*/
				
				String canQuoteStatus="";
				
				if(actualFactor.equalsIgnoreCase(Exp_Factor) && actualCanFee.equalsIgnoreCase(Exp_CancellationFee) && actualCustRefund.equalsIgnoreCase(Exp_CustomerRefund))
				{
					canQuoteStatus="Pass";
				}
				else
				{
					canQuoteStatus="Fail";
				}
				
				//System.out.println("canQuoteStatus:- "+canQuoteStatus);
				
				 String[] valueToWriteNew=null;
			        valueToWriteNew = new String[16];
			 		valueToWriteNew[0]=RowNo;
			 		valueToWriteNew[1]=Portal;
			 		valueToWriteNew[2]=Dealer;
			 		valueToWriteNew[3]=FirstName;
			 		valueToWriteNew[4]=LastName;
			 		valueToWriteNew[5]=VinNo;
			 		valueToWriteNew[6]=Can_Date;
			 		valueToWriteNew[7]=Cust_Cost;
			 		valueToWriteNew[8]=Exp_Factor;
			 		valueToWriteNew[9]=Exp_CancellationFee;
			 		valueToWriteNew[10]=Exp_CustomerRefund;
			 		valueToWriteNew[11]=actualFactor;
			 		valueToWriteNew[12]=actualCanFee;
			 		valueToWriteNew[13]=actualCustRefund;
			 		valueToWriteNew[14]=canQuoteStatus;
			 		valueToWriteNew[15]=CurrentDateSelection.getCurrentDate();
			 		
			 		ExcelReadWrite ERW=new ExcelReadWrite();
			 		ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "CancellationQuote_Result",valueToWriteNew);
			         
			        
			 		if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			 		{
			 			GetScreenshot.captureScreenshot();
			 		}
			 		
			 		Log.log.debug("Verify Cancellation Quote as:-");
			 		Log.log.debug("Exp Factor is:- "+Exp_Factor);
			 		Log.log.debug("Exp Cancellation Fee is:- "+Exp_CancellationFee);
			 		Log.log.debug("Exp Customer Refund is:- "+Exp_CustomerRefund);
			 		Log.log.debug("Actual Factor is:- "+actualFactor);
			 		Log.log.debug("Actual Cancellation Fee is:- "+actualCanFee);
			 		Log.log.debug("Actual Customer Refund is:- "+actualCustRefund);
			 		Log.log.debug("Status is:- "+canQuoteStatus);
			}
			
		}catch(Exception e)
		{
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
