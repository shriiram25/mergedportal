package agents.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
import utility.Log;
import org.junit.Assert;
import utility.CurrentDateSelection;
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
	
	public void enterFName(String FN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_fname")));
			fName.sendKeys(FN);
			
			Log.log.debug("Enter First Name as:- "+FN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_lname")
	public WebElement lName;
	
	public void enterLName(String LN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_lname")));
			lName.sendKeys(LN);
			
			Log.log.debug("Enter Last Name as;- "+LN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_add1")
	public WebElement address;
	
	public void enterAddress(String add)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_add1")));
			address.sendKeys(add);
			
			Log.log.debug("Enter Street Address as:- "+add);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_city")
	public WebElement city;
	
	public void enterCity(String cit)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_city")));
			city.sendKeys(cit);
			
			Log.log.debug("Enter City as:- "+cit);
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
	public WebElement msrp;
	
	public void enterMsrp(String MP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_msrp")));
			msrp.sendKeys(MP);
			
			Log.log.debug("Enter MSRP/NADA as:- "+MP);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//In Service Date
	@FindBy(id="web_con_insdate")
	public WebElement insdate;
	
	
	public void enterDate()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_insdate")));
			insdate.sendKeys(CurrentDateSelection.getCurrentDate());
			
			Log.log.debug("Enter Date as:- "+CurrentDateSelection.getCurrentDate());
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//Select Assignee Payment Type
	@FindBy(id="web_con_flb-C")
	public WebElement assigneePaymentTypeC;
	
	@FindBy(id="web_con_flb-F")
	public WebElement assigneePaymentTypeI;
	
	@FindBy(id="web_con_flb-L")
	public WebElement assigneePaymentTypeL;
	
	
	public void selectAssigneePaymentType(String APT)
	{
		if(APT.equalsIgnoreCase("Cash")){
		assigneePaymentTypeC.click();	
		
		} 
		
		if(APT.equalsIgnoreCase("Installment Contract/Loan")){
			assigneePaymentTypeI.click();
		}
		
		if(APT.equalsIgnoreCase("Balloon Loan/Lease")) {
			assigneePaymentTypeL.click();
		}
		
		Log.log.debug("Select Type as:-"+APT);
	}
	
	//Select Contract Payment Type    
	/*@FindBy(id="web_con_flb-F")
	public WebElement contractPaymentType;
		
	public void selectContractPaymentType()
	{
			contractPaymentType.click();
			
			Log.log.debug("Select Type as:- Installment Contract/Loan");
	}
	*/
	//Enter VehiclePurchasePrice
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
		
		Log.log.debug("Select Vechicle Type as:- "+VT);
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
