package MB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import MB.Hooks;
import junit.framework.Assert;
import utility.CurrentDateSelection;
import utility.GetScreenshot;
import utility.Log;
import configurations.Hooks;

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
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
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
	
	//
	@FindBy(id="web_con_wphone")
	public WebElement wPhone;
	
	public void enterWorkPhone(String WP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_wphone")));
			wPhone.sendKeys(WP);
			
			Log.log.debug("Enter Work Phone as:- "+WP);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_email")
	public WebElement email;
	
	public void enterEmail(String Email)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_email")));
						
			email.sendKeys(Email);
			
			Log.log.debug("Enter Email as:- "+Email);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_cc_hst_gst")
	public WebElement customerHST_GST;
	
	public void enterCustomerHST_GST(String HG)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(customerHST_GST));	
			
			customerHST_GST.sendKeys(HG);
			
			Log.log.debug("Enter Customer HST/GST as:- "+HG);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_cc_pst")
	public WebElement customerPST;
	
	public void enterCustomerPST(String PST)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);			
			wait.until(ExpectedConditions.visibilityOf(customerPST));
			
			customerPST.sendKeys(PST);
			
			Log.log.debug("Enter Customer PST as:- "+PST);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_cc_qst")
	public WebElement customerQST;
	
	public void enterCustomerQST(String QST)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);			
			wait.until(ExpectedConditions.visibilityOf(customerQST));
			
			customerQST.sendKeys(QST);
			
			Log.log.debug("Enter Customer QST as:- "+QST);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_dealer_state")
	public WebElement dealerProvince;
	
	public String getDealerProvince()
	{
		String DealerProvince=null;
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(dealerProvince));
		
		DealerProvince=dealerProvince.getAttribute("value").trim();
		return DealerProvince;
	}
	
	@FindBy(id="assigneeSelection")
	public WebElement assigneeSelection;
	
	public void selectAssignee()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assigneeSelection")));
			Select select=new Select(assigneeSelection);
			select.selectByIndex(1);
						
			Log.log.debug("Select Assignee Selection as:- ");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
}
