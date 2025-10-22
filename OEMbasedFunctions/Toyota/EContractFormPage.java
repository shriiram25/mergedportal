package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;

import utility.GetScreenshot;

public class EContractFormPage {
	
	public WebDriver driver;
	
	public EContractFormPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_fname")
	public WebElement fname;
	
	public void enterFirstName(String FN)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(fname));
			fname.click();
			fname.clear();
			fname.sendKeys(FN);
			Log.log.debug("Enter First Name as:- "+FN);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_lname")
	public WebElement lname;
	
	public void enterLastName(String LN)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(lname));
			lname.click();
			lname.clear();
			lname.sendKeys(LN);
			Log.log.debug("Enter Last Name as:- "+LN);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_add1")
	public WebElement mailAdd;
	
	public void enterMailAddress(String MA)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(mailAdd));
			mailAdd.click();
			mailAdd.clear();
			mailAdd.sendKeys(MA);
			Log.log.debug("Enter Mailing Address as:- "+MA);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_city")
	public WebElement city;
	
	public void enterCity(String CY)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(city));
			city.click();
			city.clear();
			city.sendKeys(CY);
			Log.log.debug("Enter City as:- "+CY);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_state")
	public WebElement state;
	
	public void enterState(String ST)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(state));
			state.click();
			state.clear();
			state.sendKeys(ST);
			Log.log.debug("Enter State as:- "+ST);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_zip")
	public WebElement zip;
	
	public void enterZip(String ZP)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(zip));
			zip.click();
			zip.clear();
			zip.sendKeys(ZP);
			Log.log.debug("Enter ZIP as:- "+ZP);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_hphone")
	public WebElement phone;
	
	public void enterPhone(String HP)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(phone));
			phone.click();
			phone.clear();
			phone.sendKeys(HP);
			Log.log.debug("Enter Phone Number as:- "+HP);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_vin")
	public WebElement vin;
	
	public void enterVin(String VN)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(vin));
			vin.click();
			vin.clear();
			vin.sendKeys(VN);
			Log.log.debug("Enter Vin Number as:- "+VN);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="vinSearch")
	public WebElement search;
	
	public void vinSearchButton()
	{
		try{
			//Thread.sleep(3000L);
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(search));
			search.click();
			Log.log.debug("Clicked on Decode VIN Button");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_odometer")
	public WebElement odo;
	
	public void enterOdometer(String OM)
	{
		try{
			
			//Thread.sleep(5000L);
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(odo));
			odo.click();
			odo.clear();
			odo.sendKeys(OM);
			Log.log.debug("Enter Odometer as:- "+OM);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_newused-N")
	public WebElement typeNew;
	
	@FindBy(id="web_con_newused-U")
	public WebElement typeUsed;
	
	@FindBy(id="web_con_newused-C")
	public WebElement typeCertified;
	
	@FindBy(id="web_con_newused-D")
	public WebElement typeDemo;
	
	public void selectVehicleType(String VT)
	{
		try{
			
			if(VT.equalsIgnoreCase("New"))
			{
				typeNew.click();
			}
			if(VT.equalsIgnoreCase("Used"))
			{
				typeUsed.click();
			}
			if(VT.equalsIgnoreCase("Certified"))
			{
				typeCertified.click();
			}
			if(VT.equalsIgnoreCase("Demo"))
			{
				typeDemo.click();
			}
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_flb-F")
	public WebElement typeFinance;
	
	@FindBy(id="web_con_flb-L")
	public WebElement typeLease;
	
	@FindBy(id="web_con_flb-C")
	public WebElement typeCash;
	
	public void selectFinanceType(String FT)
	{
		try{
			
			if(FT.equalsIgnoreCase("Finance"))
			{
				typeFinance.click();
			}
			if(FT.equalsIgnoreCase("Lease"))
			{
				typeLease.click();
			}
			if(FT.equalsIgnoreCase("Cash"))
			{
				typeCash.click();
			}
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_lien")
	public WebElement lienName;
	
	public void enterLienName(String LN)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(lienName));			
			lienName.sendKeys(LN);
			Log.log.debug("Enter Lienholder Name as:- "+LN);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_custcost")
	public WebElement cust;
	
	public void enterCustCost(String CC)
	{
		try{
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(cust));
			cust.click();
			cust.clear();
			cust.sendKeys(CC);
			Log.log.debug("Enter Agreement Purchase Price as:- "+CC);
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="submit")
	public WebElement sub;
	
	public void saveAgreement()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(sub));
			sub.click();
			Log.log.debug("Click On Save Agreement Button");
			
			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	

}
