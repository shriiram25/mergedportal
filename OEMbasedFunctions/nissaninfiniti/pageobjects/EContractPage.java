package nissaninfiniti.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Hooks;
//import nissaninfiniti.Hooks;
import utility.CurrentDateSelection;
import utility.GetScreenshot;
import utility.Log;

public class EContractPage {
	
	public WebDriver driver;
	
	public EContractPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="web_con_fname")
	public WebElement firstName;
	
	public void enterFName(String FirstName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_fname")));
			wait.until(ExpectedConditions.visibilityOf(firstName));
			
			firstName.sendKeys(FirstName);
			
			Log.log.debug("Enter First Name as:- "+FirstName);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_lname")
	public WebElement lastName;
	
	public void enterLName(String LastName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_lname")));
			wait.until(ExpectedConditions.visibilityOf(lastName));
			
			lastName.sendKeys(LastName);
			
			Log.log.debug("Enter Last Name as:- "+LastName);
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_add1")));
			wait.until(ExpectedConditions.visibilityOf(address));
					
			address.sendKeys(Add);
			
			Log.log.debug("Enter Street Address as:- "+Add);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_city")
	public WebElement city;
	
	public void enterCity(String City)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_city")));
			wait.until(ExpectedConditions.visibilityOf(city));
			
			city.sendKeys(City);
			
			Log.log.debug("Enter City as:- "+City);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_state")
	public WebElement province;
	
	public void enterProvince(String Province)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_state")));
			wait.until(ExpectedConditions.visibilityOf(province));
			
			province.sendKeys(Province);
			
			Log.log.debug("Enter Province as:- "+Province);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_zip")
	public WebElement postalCode;
	
	public void enterPostalCode(String PC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_zip")));
			wait.until(ExpectedConditions.visibilityOf(postalCode));
			
			postalCode.sendKeys(PC);
			
			Log.log.debug("Enter Postal Code as:- "+PC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_hphone")
	public WebElement homePhone;
	
	public void enterHomePhone(String HP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_hphone")));
			wait.until(ExpectedConditions.visibilityOf(homePhone));
			
			homePhone.sendKeys(HP);
			
			Log.log.debug("Enter Home Phone as:- "+HP);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_wphone")
	public WebElement busPhone;
	
	public void enterBusPhone(String BP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_wphone")));
			wait.until(ExpectedConditions.visibilityOf(busPhone));
			
			busPhone.sendKeys(BP);
			
			Log.log.debug("Enter Bus Phone as:- "+BP);
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_email")));
			wait.until(ExpectedConditions.visibilityOf(email));
			
			email.sendKeys(Email);
			
			Log.log.debug("Enter Email as:- "+Email);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_first_name")
	public WebElement coFName;
	
	public void enterCosignerFName(String FirstName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_first_name")));
			wait.until(ExpectedConditions.visibilityOf(coFName));
			
			coFName.sendKeys(FirstName);
			
			Log.log.debug("Enter cosigner First Name as:- "+FirstName);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_last_name")
	public WebElement coLName;
	
	public void enterCosignerLName(String LastName)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_last_name")));
			wait.until(ExpectedConditions.visibilityOf(coLName));
			
			coLName.sendKeys(LastName);
			
			Log.log.debug("Enter Cosigner Last Name as;- "+LastName);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_address1")
	public WebElement coAddress;
	
	public void enterCosignerAddress(String Add)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_address1")));
			wait.until(ExpectedConditions.visibilityOf(coAddress));
			
			coAddress.sendKeys(Add);
			
			Log.log.debug("Enter Cosigner Street Address as:- "+Add);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_city")
	public WebElement coCity;
	
	public void enterCosignerCity(String City)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_city")));
			wait.until(ExpectedConditions.visibilityOf(coCity));
			
			coCity.sendKeys(City);
			
			Log.log.debug("Enter Cosigner City as:- "+City);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_state")
	public WebElement coProvince;
	
	public void enterCosignerProvince(String Province)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_state")));
			wait.until(ExpectedConditions.visibilityOf(coProvince));
			
			coProvince.sendKeys(Province);
			
			Log.log.debug("Enter Cosigner Province as:- "+Province);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_zip")
	public WebElement coPostalCode;
	
	public void enterCosignerPostalCode(String PC)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_zip")));
			wait.until(ExpectedConditions.visibilityOf(coPostalCode));
			
			coPostalCode.sendKeys(PC);
			
			Log.log.debug("Enter Cosigner Postal Code as:- "+PC);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_co_hphone")
	public WebElement coHomePhone;
	
	public void enterCosignerHomePhone(String HP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_hphone")));
			wait.until(ExpectedConditions.visibilityOf(coHomePhone));
			
			coHomePhone.sendKeys(HP);
			
			Log.log.debug("Enter Cosigner Home Phone as:- "+HP);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	@FindBy(id="web_con_co_wphone")
	public WebElement coBusPhone;
	
	public void enterCosignerBusPhone(String BP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_co_wphone")));
			wait.until(ExpectedConditions.visibilityOf(coBusPhone));
			
			coBusPhone.sendKeys(BP);
			
			Log.log.debug("Enter Cosigner Bus Phone as:- "+BP);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//
	@FindBy(id="web_con_vin")
	public WebElement vin;
	
	public void enterVin(String VN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_vin")));
			wait.until(ExpectedConditions.visibilityOf(vin));
			
			vin.sendKeys(VN);
			
			Log.log.debug("Enter VIN No as:- "+VN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="vinSearch")
	public WebElement vinS;
	
	@FindBy(id="web_con_dealercost")
	public WebElement dealerCost;
	
	public void clickVinSearch()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vinSearch")));
			wait.until(ExpectedConditions.visibilityOf(vinS));
			
			vinS.click();
			//Thread.sleep(5000L);
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("web_con_dealercost")));
			wait.until(ExpectedConditions.elementToBeClickable(dealerCost));
			Thread.sleep(3000L);
			Log.log.debug("Click on Decode VIN Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
			
	@FindBy(id="web_con_odometer")
	public WebElement odometer;
	
	public void enterOdometer(String Odometer)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_odometer")));
			wait.until(ExpectedConditions.visibilityOf(odometer));
			
			odometer.sendKeys(Odometer);
			
			Log.log.debug("Enter Odometer as:- "+Odometer);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
		
	@FindBy(id="web_con_msrp")
	public WebElement msrp;
	
	public void enterMSRP_CBB(String Msrp)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_msrp")));
			wait.until(ExpectedConditions.visibilityOf(msrp));
			
			msrp.sendKeys(Msrp);
			
			Log.log.debug("Enter MSRP as:- "+Msrp);
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
		if(VT.equalsIgnoreCase("CPO"))
		{
			vechicleCPO.click();
		}
		
		Log.log.debug("Select Vechicle Type as:- "+VT);
	}
	
	@FindBy(id="web_con_reg")
	public WebElement decal;
	
	public void enterDecalNumber(String DN)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_reg")));
			wait.until(ExpectedConditions.visibilityOf(decal));			
			
			decal.sendKeys(DN);
			
			Log.log.debug("Enter DecalNumber as:- "+DN);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_custcost")
	public WebElement custPurchasePrice;
	
	public void enterCustomerPurchasePrice(String CPP)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_custcost")));
			wait.until(ExpectedConditions.visibilityOf(custPurchasePrice));	
			
			custPurchasePrice.sendKeys(CPP);
			
			Log.log.debug("Enter Customer Purchase Price as:- "+CPP);
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_cc_hst_gst")));
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_cc_pst")));
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
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_cc_qst")));
			wait.until(ExpectedConditions.visibilityOf(customerQST));
			
			customerQST.sendKeys(QST);
			
			Log.log.debug("Enter Customer QST as:- "+QST);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_flamt")
	public WebElement amountFinanced_LeaseCap;
	
	public void enterAmountFinanced_LeaseCap(String AFL)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_flamt")));
			wait.until(ExpectedConditions.visibilityOf(amountFinanced_LeaseCap));
			
			amountFinanced_LeaseCap.sendKeys(AFL);
			
			Log.log.debug("Enter Amount Financed/Lease Cap as:- "+AFL);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="assigneeSelection")
	public WebElement assignee;
	
	@FindBy(id="web_con_lien")
	public WebElement financialInstitution;
	
	public void selectAssignee(String Assignee)
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("assigneeSelection")));
			wait.until(ExpectedConditions.visibilityOf(assignee));
			
			Select select=new Select(assignee);
			select.selectByVisibleText(Assignee);
			//Thread.sleep(3000L);
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("web_con_lien")));
			wait.until(ExpectedConditions.elementToBeClickable(financialInstitution));
									
			Log.log.debug("Select Assignee as:- "+Assignee);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	//Dealer Province
	@FindBy(id="web_con_dealer_state")
	public WebElement dealerProvince;
	
	//public String DealerProvince=null;
	
	public String getDealerProvince()
	{
		String DealerProvince=null;
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(dealerProvince));
		
		DealerProvince=dealerProvince.getAttribute("value").trim();
		return DealerProvince;
	}
	
	//QVGS
	
	public void clickVinDecoder()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vinSearch")));
			wait.until(ExpectedConditions.visibilityOf(vinS));
			
			vinS.click();
			Thread.sleep(5000L);
					
			Log.log.debug("Click on Decode VIN Button");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="web_con_insdate")
	public WebElement inServiceDate;
	
	public void enterInServiceDate()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("web_con_insdate")));
			wait.until(ExpectedConditions.visibilityOf(inServiceDate));
			
			String date=CurrentDateSelection.getCurrentDate();
			inServiceDate.sendKeys(date);
			
			Log.log.debug("Select In Service Date as:- "+date);
		}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="deductible")
	public WebElement deductible;
	
	public void selectDeductible(String Deductible)
	{
		try{
			Thread.sleep(8000L);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deductible")));
			wait.until(ExpectedConditions.visibilityOf(deductible));
			Select select=new Select(deductible);
			//select.selectByVisibleText(Deductible);
			select.selectByValue(Deductible);
			Thread.sleep(8000L);
			Log.log.debug("Select Deductible as:- "+Deductible);
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

	@FindBy(id="continue1")
	public WebElement continueButton;
	
	public void clickContinueBtn()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(continueButton));
		
			continueButton.click();
			Log.log.debug("Click on Continue button:- ");
		
		}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="continue2")
	public WebElement continueButton2;
	
	public void clickContinueBtn2()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(continueButton2));
		
			continueButton2.click();
			//Thread.sleep(5000L);
			Log.log.debug("Click on Continue button 2:- ");
		
		}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="continue3")
	public WebElement continueButton3;
	
	public void clickContinueBtn3()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(continueButton3));
		
			continueButton3.click();
			//Thread.sleep(5000L);
			Log.log.debug("Click on Continue button 3:- ");
		
		}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="continue4")
	public WebElement continueButton4;
	
	public void clickContinueBtn4()
	{
		try{
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
			
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(continueButton4));
		
			continueButton4.click();
			//Thread.sleep(5000L);
			Log.log.debug("Click on Continue button 4:- ");
		
		}catch(Exception e){
				GetScreenshot.captureScreenshot();
				Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(id="cash")
	public WebElement cashLien;
	
	public void clickCashDeal()
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cash")));
			wait.until(ExpectedConditions.visibilityOf(cashLien));
			
			cashLien.click();
								
			Log.log.debug("Click on Cash Deal Check box");
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
}