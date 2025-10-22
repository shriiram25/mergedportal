package hyundai;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class CancellationPage {
	
	public WebDriver driver;
	public String CustValue=null;
	
	public CancellationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Reports")
	public WebElement reportMenu;
	
	@FindBy(linkText="Cancellation Quote")
	public WebElement canQuote;
	
	public void reportMenuSel()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reports")));
			Actions action=new Actions(driver);
			action.moveToElement(reportMenu).perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cancellation Quote")));
			canQuote.click();
		}catch(Exception e){
			//TestUtil.captureScreenshot();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="fname")
	public WebElement firstName;
	
	public void canFirstName(String cFN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
			firstName.sendKeys(cFN);
			
		}catch(Exception e){
			//TestUtil.captureScreenshot();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="lname")
	public WebElement lastName;
	
	public void canLastName(String cLN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lname")));
			lastName.sendKeys(cLN);
			
		}catch(Exception e){
			//TestUtil.captureScreenshot();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="vin")
	public WebElement vinNumber;
	
	public void canVin(String cVIN)
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vin")));
			vinNumber.sendKeys(cVIN);
			
		}catch(Exception e){
			//TestUtil.captureScreenshot();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement submitButton;
	
	public void canSubmit()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
			submitButton.click();
			
		}catch(Exception e){
			//TestUtil.captureScreenshot();
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(xpath="//*[@id='contentcontainer']/div[4]/span/a")
	public WebElement searchPage;
	
	@FindBy(xpath="//*[@id='content']/table/tbody/tr[1]/td[1]/a")
	public WebElement contractSelect;
	
	@FindBy(className="customercost")
	public WebElement custCostVal;
	
	@FindBy(id="quoteButton")
	public WebElement canQuoteButton;
	
	public void cancelQuote(String cn)
	{
		try{
			/*String page=searchPage.getText().trim();
			if(page.equalsIgnoreCase("Export Report"))
			{
				//contractSelect.click();
				driver.findElement(By.linkText(cn)).click();
			}*/
			
			try{
				driver.findElement(By.linkText(cn)).click();
			}catch(Exception e){
				
			}
			
			CustValue=custCostVal.getText().trim();
			canQuoteButton.click();
			//Thread.sleep(5000L);
			
			if(CustValue.equalsIgnoreCase("$0.00"))
			{
				Alert alert=driver.switchTo().alert();
				alert.accept();
			}
			
		}catch(Exception e){
			System.out.println("Search Data is not Valid");
			//e.printStackTrace();
		}
	}
	
	@FindBy(id="f-calendar-field-1")
	public WebElement CanDate;
	
	@FindBy(id="mileage")
	public WebElement milageVal;
	
	@FindBy(id="reason")
	public WebElement canReason;
	
	@FindBy(id="quoteSubmit")
	public WebElement canSubmit;
	
	public void CancellationQuoteFields(String fDeriveBy, String canDate, String EndMileage, String CanReason)
	{
		try{
			String CustValue1=custCostVal.getText().trim();
			if(!CustValue1.equalsIgnoreCase("$0.00"))
			{
				CanDate.clear();
				CanDate.sendKeys(canDate);
				//Thread.sleep(5000L);
				if(fDeriveBy.equalsIgnoreCase("Mileage"))
				{
					milageVal.sendKeys(EndMileage);
				}
				//Thread.sleep(5000L);
				Select select=new Select(canReason);
				select.selectByVisibleText(CanReason);
				//Thread.sleep(5000L);
				canSubmit.click();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[2]")
	public WebElement EFactor;
	
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[4]")
	public WebElement EDRefund;
	
	@FindBy(xpath="//*[@id='quoteTableTbody']/tr/td[5]")
	public WebElement ECRefund;
	
	public void matchExpData(String TestCase, String ExpFactor, String ExpDealerRefund, String ExpCustomerRefund, String DealerID, String VIN, String EndMileage, String CanReason, String CancelDate )
	{
		try{
			String CustValue1=custCostVal.getText().trim();
			if(!CustValue1.equalsIgnoreCase("$0.00"))
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,250)", "");
				String canStatus=null;
				String EFactorWeb=null;
				String EDRefundWeb=null;
				String ECRefundWeb=null;
				
				
				/*System.out.println("EFactorWeb:-"+EFactorWeb);
				System.out.println("EDRefundWeb:-"+EDRefundWeb);
				System.out.println("ECRefundWeb:-"+ECRefundWeb);*/
				if(!ExpDealerRefund.equalsIgnoreCase(""))
				{
					EFactorWeb=EFactor.getText().trim();
					EDRefundWeb=EDRefund.getText().trim();
					ECRefundWeb=ECRefund.getText().trim();
				
					if(EFactorWeb.equalsIgnoreCase(ExpFactor) && EDRefundWeb.equalsIgnoreCase(ExpDealerRefund) && ECRefundWeb.equalsIgnoreCase(ExpCustomerRefund))
					{
						canStatus="Pass";
					}
					else
					{
						canStatus="Fail";
					}
				}
				else
				{
					EFactorWeb=EFactor.getText().trim();
					ECRefundWeb=EDRefund.getText().trim();
					
					if(EFactorWeb.equalsIgnoreCase(ExpFactor) && ECRefundWeb.equalsIgnoreCase(ExpCustomerRefund))
					{
						canStatus="Pass";
					}
					else
					{
						canStatus="Fail";
					}
				}
				
				//System.out.println("canStatus:-"+canStatus);
				
				String toDayDate=CurrentDateSelection.getCurrentDate();
				
				String[] valueToWriteNew=null;
		        valueToWriteNew = new String[14];
		        valueToWriteNew[0]=TestCase;
		 		valueToWriteNew[1]=DealerID;
		 		valueToWriteNew[2]=VIN;
		 		valueToWriteNew[3]=EndMileage;
		 		valueToWriteNew[4]=CanReason;
		 		valueToWriteNew[5]=CancelDate;
		 		valueToWriteNew[6]=ExpFactor;
		 		valueToWriteNew[7]=ExpDealerRefund;
		 		valueToWriteNew[8]=ExpCustomerRefund;
		 		valueToWriteNew[9]=EFactorWeb;
		 		valueToWriteNew[10]=EDRefundWeb;
		 		valueToWriteNew[11]=ECRefundWeb;
		 		valueToWriteNew[12]=canStatus;
		 		valueToWriteNew[13]=toDayDate;
		 		
		 		ExcelReadWrite ERW=new ExcelReadWrite();
		 		ERW.writeExcelForm(System.getProperty("user.dir"), "VSCresult.xlsx", "CancellationResult",valueToWriteNew);       		
			
			}						
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
