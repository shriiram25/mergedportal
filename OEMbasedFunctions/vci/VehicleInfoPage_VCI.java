package vci;

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

public class VehicleInfoPage_VCI {
	public WebDriver driver;

	// Available Products
	public String product1 = "MULTI";
	public String product2 = "GAP PROTECTION";
	public String product3 = "GAP P PROTECTION";
	public String product4 = "SERVICE";
	public String product5 = "LEASE";
	public String product6 = "GAP PLUS PROTECTION";
	public String product7 = "AUDI THEFT";
	public String product8 = "AUDI TERM";
	public String product9 = "VSC";
	public String product10 = "TIRE";
	public String product11 = "VW TERM";
	public String product12 = "QP VEHICLE";
	public String product13 = "EXTENSION";
	public String product14 = "QP TERM";
	public String product15 = "PROMOTION";
	public String product16 = "DUCATI THEFT";
	public String product17 = "VW DRIVE EASY THEFT";
	public String product18 = "VW TERM";
	public String product19 = "QP MULTI";
	public String product20 = "QP THEFT";
	public String product21 = "AU TERM";
	public String product22 = "THEFT";

	// Declaring variables to write excel
	public String vehicleMSRP;
	public String financeAmount;
	public String APR;
	public String grossGapCost;
	public String vehiclePrice;

	public VehicleInfoPage_VCI(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	// function for entering the value considering the product
	// Comparing the product selected we are sending the data to the required
	// field
	public void entervehicleinfo(String product, String vehiclemsrp, String financeamount, String apr,
			String grossgapcost, String vehicleprice) {
		vehicleMSRP = vehiclemsrp;
		financeAmount = financeamount;
		APR = apr;
		grossGapCost = grossgapcost;
		vehiclePrice = vehicleprice;
		
		if (product.contains(product19) || product.contains(product20) || product.contains(product11)) {
			
			vehicleMSRP(vehiclemsrp);
			financeAmount(financeamount);
			arp(apr);
			continueBtn();		
		}
		
		else if (product.contains(product2) || product.contains(product3) || product.contains(product6) || product.contains(product12) || product.contains(product13) || product.contains(product15)) {
			vehicleMSRP(vehiclemsrp);
			financeAmount(financeamount);
			arp(apr);
			vehiclePurchasePrice(vehicleprice);
			continueBtn();
		}

		else if (product.contains(product4) || product.contains(product9)  || product.contains(product14) ) {

			vehiclePurchasePrice(vehicleprice);
			continueBtn();
		}


		else if (product.contains(product7) || product.contains(product10)|| product.contains(product16)) {

			vehiclePurchasePrice(vehicleprice);
			financeAmount(financeamount);
			continueBtn();
		}

		else if (product.contains(product1)) {

			vehiclePurchasePrice(vehicleprice);
			financeAmount(financeamount);
			continueBtn();
		}

		else if (product.contains(product8)) {

			vehicleMSRP(vehiclemsrp);
			vehiclePurchasePrice(vehicleprice);
			continueBtn();
		}
		
		else if (product.contains(product17) || product.contains(product22)) {

			vehicleMSRP(vehiclemsrp);
			financeAmount(financeamount);
			vehiclePurchasePrice(vehicleprice);
			continueBtn();
		}
		else if (product.contains(product21)) {

			vehicleMSRP(vehiclemsrp);
			financeAmount(financeamount);
			arp(apr);
			//vehiclePurchasePrice(vehicleprice);
			continueBtn();
		}

		else if (product.contains(product5)) {

			vehicleMSRP(vehiclemsrp);
			if (!grossGapCost.equals("")) {
				grossCapCost(grossGapCost);
				continueBtn();
			} else {
				continueBtn();
			}
		}
	}
	
	

	@FindBy(id = "vehicleMSRP_") // To locate the button with id 'vehicleMSRP_' in DOM
	public WebElement vehicleMsrp; // Declaring a WebElement named vehicleMsrp

	public void vehicleMSRP(String vehicle_msrp) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicleMSRP_"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			
			vehicleMsrp.clear();
			vehicleMsrp.sendKeys(vehicle_msrp); // sending the data to the text field
			
		} catch (Exception e) {

			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
	@FindBy(id = "financeAmount_") // To locate the button with id 'financeAmount_' in DOM
	public WebElement Financeamount; // Declaring a WebElement named Financeamount
	
	public void financeAmount(String financeamount) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("financeAmount_"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error											// to
																								
			Financeamount.clear();   // sending the data to the
			Financeamount.sendKeys(financeamount); // sending the data to the text field
		   } 
		catch (Exception e)
		 {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		 }
	}

	
	@FindBy(id = "arp_") // To locate the button with id 'arp_' in DOM
	public WebElement Arp; // Declaring a WebElement named Arp send values of arp

	public void arp(String arp_) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arp_"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			
			Arp.sendKeys(arp_); // sending the data to the text field
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
	@FindBy(id = "con-continue") // To locate the button with id 'con-continue' in DOM
	public WebElement Continue; // Declaring a WebElement named Continue
	
	public void continueBtn() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.elementToBeClickable(Continue)); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			Continue.click(); // clicking the master continue button		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			ErrorMessage.captureErrorMessageXpath("//div[@id='errorMsgFinanace']/label"); // Getting the error message shown in the browser.
		//	writeExcel(); // Function calling the write excel.
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	
	@FindBy(id = "vehicle_purchase_price") // To locate the button with id 'vehicle_purchase_price' in DOM
	public WebElement vehiclePurchasePrice; // Declaring a WebElement named vehiclePurchasePrice
	

	public void vehiclePurchasePrice(String vPurchacePrice) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle_purchase_price"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			
			vehiclePurchasePrice.clear();																							// error
			vehiclePurchasePrice.sendKeys(vPurchacePrice); // sending the data to the text field
			
		   } 
		catch (Exception e) 
		   {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		  }
	   }

	
	@FindBy(id = "grossCapCost_") // To locate the button with id 'grossCapcost_' in DOM
	public WebElement grossCapCost; // Declaring a WebElement named grossCapCost send values of grossCapCost

	public void grossCapCost(String grossCapcost) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
																
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grossCapCost_"))); // Instructing web driver to wait until the visibility of element by its locator before it throws error	
			
			grossCapCost.sendKeys(grossCapcost); // sending the data to the text field
			
		   } catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	} }

	/*// writing excel
	public void writeExcel() {

		try {

			String[] valueToWriteNew = null;     // Declaring an array of string to store the data
			valueToWriteNew = new String[7];    // Initializing string with size
			valueToWriteNew[0] = vehicleMSRP;   // Assigning data to the string array
			valueToWriteNew[1] = financeAmount;
			valueToWriteNew[2] = APR;
			valueToWriteNew[3] = grossGapCost;
			valueToWriteNew[4] = vehiclePrice;
			valueToWriteNew[5] = ErrorMessage.ErrorMessage;
			valueToWriteNew[6] = GetScreenshot.filename;

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}*/
