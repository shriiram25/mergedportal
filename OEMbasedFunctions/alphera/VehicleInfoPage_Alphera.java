package alphera;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
public class VehicleInfoPage_Alphera {
	
	public WebDriver driver;

	public VehicleInfoPage_Alphera(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void entervehicleinfo(String product, String vehiclemsrp, String financeamount, String apr, String grossgapcost, String vehicleprice) {
	
		if (product.contains("SERVICE") || product.contains("GAP PROTECTION")) {
			vehicleMSRP(vehiclemsrp);
			financeAmount(financeamount);
			arp(apr);
			continueBtn();
		}
	}

	@FindBy(id = "vehicleMSRP_") 
									
	public WebElement vehicleMsrp; 	

	public void vehicleMSRP(String vehicle_msrp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleMSRP_"))); 
			vehicleMsrp.sendKeys(vehicle_msrp);
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "financeAmount_") 
	public WebElement Financeamount; 

	public void financeAmount(String financeamount) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("financeAmount_"))); 
			Financeamount.sendKeys(financeamount); 
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "arp_") // To locate the button with id 'arp_' in DOM
	public WebElement Arp; // Declaring a WebElement named Arp
	
	public void arp(String arp_) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arp_"))); 
			Arp.sendKeys(arp_); // sending the data to the text field
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); 
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "con-continue") 
	public WebElement Continue; 
	// click continue button
	public void continueBtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.elementToBeClickable(Continue));
			Continue.click(); // clicking the master continue button		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn"))); 
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			ErrorMessage.captureErrorMessageXpath("//div[@id='errorMsgFinanace']/label"); 
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "vehicle_purchase_price")
	public WebElement vehiclePurchasePrice; 
	
	public void vehiclePurchasePrice(String vPurchacePrice) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle_purchase_price"))); 
			vehiclePurchasePrice.sendKeys(vPurchacePrice); 
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); 
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "grossCapCost_") 
	public WebElement grossCapCost; 
	// send values of grossCapCost
	public void grossCapCost(String grossCapcost) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grossCapCost_")));
			grossCapCost.sendKeys(grossCapcost); 
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); 
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
}
