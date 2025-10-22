package bmw.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import utility.GetScreenshot;

public class EContractPage {
	
	public WebDriver driver;
	
	public EContractPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_fname")
	public WebElement fName;
	
	public void enterFName(String FirstName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_fname")));			
			fName.sendKeys(FirstName);
			
			Log.log.debug("Enter First Name as:- "+FirstName);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_lname")
	public WebElement lName;
	
	public void enterLName(String LastName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_lname")));
			lName.sendKeys(LastName);
			
			Log.log.debug("Enter Last Name as;- "+LastName);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_add1")
	public WebElement address;
	
	public void enterAddress(String Add)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_add1")));
			address.sendKeys(Add);
			
			Log.log.debug("Enter Street Address as:- "+Add);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_city")
	public WebElement city;
	
	public void enterCity(String cty)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_city")));
			city.sendKeys(cty);
			
			Log.log.debug("Enter City as:- "+cty);
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
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_state")));
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
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_zip")));
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
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_hphone")));
			phone.sendKeys(HP);
			
			Log.log.debug("Enter Home Phone as:- "+HP);
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
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_vin")));
			vin.sendKeys(VN);
			
			Log.log.debug("Enter VIN No as:- "+VN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="vinSearch")
	public WebElement vinS;
	
	public void clickVinSearch()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vinSearch")));
			vinS.click();
			Thread.sleep(8000L);
			Log.log.debug("Click on Decode VIN Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_odometer")
	public WebElement odometer;
	
	public void enterOdometer(String odo)
	{
		try{
			//Thread.sleep(5000L);			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_odometer")));
			odometer.sendKeys(odo);
			
			Log.log.debug("Enter Odometer as:- "+odo);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
		
	@FindBy(id="web_con_msrp")
	public WebElement vehiclePurchasePrice;
	
	public void enterVehiclePurchasePrice(String VPC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_msrp")));
			vehiclePurchasePrice.sendKeys(VPC);
			
			Log.log.debug("Enter vehiclePurchasePrice as:- "+VPC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}	
		
	@FindBy(id="web_con_newused-N")
	public WebElement vechicleNew;
	
	@FindBy(id="web_con_newused-U")
	public WebElement vechicleUsed;
	
	@FindBy(id="web_con_newused-C")
	public WebElement vechicleCPO;
	
	public void selectVechileType(String VT)
	{
		if(VT.equalsIgnoreCase("New"))
		{
			vechicleNew.click();
		}
		if(VT.equalsIgnoreCase("Used"))
		{
			vechicleUsed.click();
		}
		if(VT.equalsIgnoreCase("Certified Pre-Owned"))
		{
			vechicleCPO.click();
		}
		
		Log.log.debug("Select Vechicle Type as:- "+VT);
	}
	@FindBy(id="web_con_flb-F")
	public WebElement vechicleFinance;
	
	@FindBy(id="web_con_flb-B")
	public WebElement vechicleBaloon;
	public void selectVechilefinanceType(String VT)
	{
		if(VT.equalsIgnoreCase("Finance"))
		{
			vechicleFinance.click();
		}
		if(VT.equalsIgnoreCase("Used"))
		{
			vechicleBaloon.click();
		}
			
		Log.log.debug("Select Vechicle Finance Type as:- "+VT);
	}
	
	
	@FindBy(id="web_con_custcost")
	public WebElement customer;
	
	public void enterCustCost(String CC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_custcost")));
			customer.sendKeys(CC);
			
			Log.log.debug("Enter Charge to Customer as:- "+CC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_flamt")
	public WebElement amountFinanced;
	
	public void enterAmountFinanced(String AF)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_flamt")));
			amountFinanced.sendKeys(AF);
			
			Log.log.debug("Enter Amount Financed as:- "+AF);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	
	@FindBy(id="web_con_lien")
	public WebElement lien;
	
	public void enterFinancialInstitution(String FI)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_lien")));
			lien.sendKeys(FI);
			
			Log.log.debug("Enter Financial Institution as:- "+FI);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_bank_address")
	public WebElement bankAdd;
	
	public void enterBankAddress(String BA)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_bank_address")));
			bankAdd.sendKeys(BA);
			
			Log.log.debug("Enter Assignee Street Address as:- "+BA);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_bank_city")
	public WebElement bankCity;
	
	public void enterBankCity(String BC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_bank_city")));
			bankCity.sendKeys(BC);
			
			Log.log.debug("Enter Assignee City as:- "+BC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_bank_state")
	public WebElement bankState;
	
	public void enterBankState(String BS)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_bank_state")));
			bankState.sendKeys(BS);
			
			Log.log.debug("Enter Assignee State as:- "+BS);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_bank_zip")
	public WebElement bankZip;
	
	public void enterBankZip(String BZ)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_bank_zip")));
			bankZip.sendKeys(BZ);
			
			Log.log.debug("Enter Assignee Zip Code as:- "+BZ);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
